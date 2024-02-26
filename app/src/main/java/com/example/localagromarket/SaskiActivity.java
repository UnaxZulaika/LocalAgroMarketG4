package com.example.localagromarket;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SaskiActivity extends AppCompatActivity {
    private ImageView argazkia;
    private Button igoArgazkia;
    private final int GALLERY_RREQ_CODE= 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saski);

        argazkia = findViewById(R.id.imageView);
        igoArgazkia = findViewById(R.id.igoArgazkia);

        igoArgazkia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGalery = new Intent(Intent.ACTION_PICK);
                iGalery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGalery,GALLERY_RREQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==GALLERY_RREQ_CODE){
                argazkia.setImageURI(data.getData());
            }
        }
    }
}