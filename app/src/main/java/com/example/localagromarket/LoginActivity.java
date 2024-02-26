package com.example.localagromarket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private Button btnSaioaHasi;
    private ImageButton ibPasahitza;
    private CheckBox cbPasahitzaGorde;
    private EditText etEposta;
    private EditText etPasahitza;
    private String posta;
    private String pasahitza;
    private TextView tvErregistratuEmen;
    private List<String> lehentasunakInfo;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        btnSaioaHasi = findViewById(R.id.btnSaioahasi);
        etEposta = findViewById(R.id.etEposta);
        etPasahitza = findViewById(R.id.etPasahitza);
        tvErregistratuEmen = findViewById(R.id.tvErregistratuEmen);
        ibPasahitza = findViewById(R.id.ibPasahitza);
        cbPasahitzaGorde = findViewById(R.id.cbPasahitzaGorde);

        lehentasunakInfo = lehentasunakKargatu();

        btnSaioaHasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posta = etEposta.getText().toString().trim();
                pasahitza = etPasahitza.getText().toString().trim();
                if (TextUtils.isEmpty(posta)) {
                    String sartuEposta = getResources().getString(R.string.sartuEposta);
                    etEposta.setError(sartuEposta);
                } else if (TextUtils.isEmpty(pasahitza)) {
                    String sartuPasahitza = getResources().getString(R.string.sartuPasahitza);
                    etPasahitza.setError(sartuPasahitza);
                } else {
                    saioaHasi(posta, pasahitza);
                }
            }
        });

        // Erregistro textView-ean click egitean ErregistroActivitira eramago zaizu
        tvErregistratuEmen.setOnClickListener(v -> {
            Intent erregistroIntent = new Intent(LoginActivity.this, ErregistroaActivity.class);
            startActivity(erregistroIntent);
            finish();
        });

        // ImageButton-ari click egitean pasahitza erakutsiko da, berriro egiten badugu click pasahitza eskutatuko da.
        ibPasahitza.setOnClickListener(v -> {
            int currentInputType = etPasahitza.getInputType();

            // Pasahitza ez badago ikusgarri
            if (currentInputType == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                etPasahitza.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                etPasahitza.setTypeface(Typeface.DEFAULT);
                ibPasahitza.setImageResource(R.drawable.begia_off_24);
            }
            // Pasahitza ikusgarri badago
            else {
                etPasahitza.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                etPasahitza.setTypeface(Typeface.DEFAULT);
                ibPasahitza.setImageResource(R.drawable.begia_24);
            }
            // Kurtsorea testuaren amaieran mugitzen da.
            etPasahitza.setSelection(etPasahitza.getText().length());
        });
    }

    /**
     * Eposta eta pasahitza bidaltzen diogu metodoario eta konprobatzen du ea dagoen kontu bat non emial eta pasahitza hori daukan.
     * Konturik badago intent bat egiten du eta Activity berri batera eramaten ditu.
     * Datu horiek dituen konturik ez badago, mezu bat agertuko da
     * @param eposta
     * @param pasahitza
     */
    private void saioaHasi(String eposta, String pasahitza) {
        mAuth.signInWithEmailAndPassword(eposta, pasahitza)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Saioa ondo hasi da
                        cbPasahitzaGorde = findViewById(R.id.cbPasahitzaGorde);
                        if(cbPasahitzaGorde.isChecked()) {
                            lehentasunakGorde();
                        } else if (!lehentasunakInfo.get(0).equals(eposta) && !lehentasunakInfo.get(1).equals(pasahitza)){
                            etEposta.setText("");
                            etPasahitza.setText("");
                        }
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        // Toast.makeText(MainActivity.this, getResources().getString(R.string.ongiEtorri), Toast.LENGTH_SHORT).show();
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof FirebaseNetworkException) {
                            Toast.makeText(LoginActivity.this, getResources().getString(R.string.erKonexioaLogin), Toast.LENGTH_SHORT).show();
                        } else if (exception instanceof FirebaseAuthInvalidUserException) {
                            // Eposta ez da aurkitu
                            Toast.makeText(LoginActivity.this, getResources().getString(R.string.erEpostaLogin), Toast.LENGTH_SHORT).show();
                        } else if (exception instanceof FirebaseAuthInvalidCredentialsException) {
                            // Saio-hasierako kredentzial baliogabeak (eposta edo pasahitza baliogabeak)
                            Toast.makeText(LoginActivity.this, getResources().getString(R.string.erPasahitzaLogin), Toast.LENGTH_SHORT).show();
                        } else {
                            // Otro error no manejado específicamente
                            Toast.makeText(LoginActivity.this, getResources().getString(R.string.erLoginLogin), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * Lehentasunak kargatzeko metodoa. Kasu onetan, erabiltzailearen e-posta eta pasahitza kargatzeko.
     * @return Gordetako kredentzialak bueltatuko ditu.
     */
    private List<String> lehentasunakKargatu() {
        List<String> kredentzialak = new ArrayList<>();
        // Kredentzialak.xml kargatzen du (lehenengo aldia bada 'kredentzialak.xml' sortzen du)
        SharedPreferences preferences = getSharedPreferences("kredentzialak", Context.MODE_PRIVATE);

        // xml barruan 'user'-ean eta 'pass'-ean gordetako informazioa gordetzen du.
        String eposta = preferences.getString("user", "");
        String pasahitza = preferences.getString("pass", "");

        // EditText-etan ipintzen du kargatutako informazioa
        etEposta.setText(eposta);
        etPasahitza.setText(pasahitza);

        // Informazioa listan gordetzen da
        kredentzialak.add(eposta);
        kredentzialak.add(pasahitza);

        return kredentzialak;
    }


    /**
     * Lehentasunak gordetzeko metodoa. Kasu onetan, erabiltzailearen e-posta eta pasahitza gordetzeko.
     */
    private void lehentasunakGorde() {
        // Kredentzialak.xml kargatzen da informazioa gordetzeko (lehenengo aldia bada 'kredentzialak.xml' sortzen du)
        SharedPreferences preferences = getSharedPreferences("kredentzialak", Context.MODE_PRIVATE);
        // Sartutako erabiltzaile eta pasahitzak eskuratzen dira
        String eposta = etEposta.getText().toString();
        String pasahitza = etPasahitza.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", eposta);
        editor.putString("pass", pasahitza);

        // Dena gordeko da xml-an.
        editor.apply();
    }
}