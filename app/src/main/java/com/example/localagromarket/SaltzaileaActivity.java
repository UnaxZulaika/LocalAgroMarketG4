package com.example.localagromarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SaltzaileaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saltzailea);

        // Instanciar el fragmento
        ProduktuaIgoFragment fragment = new ProduktuaIgoFragment();

        // Obtener el FragmentManager e iniciar una transacción
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container_info, fragment) // Reemplazar el contenido del contenedor de fragmentos
                .commit(); // Confirmar la transacción
    }
}