package com.example.localagromarket;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button btnSaioaHasi;
    private EditText etEposta;
    private EditText etPasahitza;
    private String posta;
    private String pasahitza;
    private TextView tvErregistratuEmen;
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
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(loginIntent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, getString(R.string.loginErrorea), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}