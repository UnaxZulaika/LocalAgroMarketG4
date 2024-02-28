package com.example.localagromarket;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SaskiActivity extends AppCompatActivity {

    private Button amaituErosketa;
    private ImageView produktuArgazkia;
    private ImageButton btnJaitsiKantitatea;
    private ImageButton btnIgoKantitatea;
    private EditText kantitateZenbakia;
    private int kantitatea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saski);

        kantitateZenbakia = findViewById(R.id.kantitateZenbakia);
        amaituErosketa= findViewById(R.id.amaituErosketa);
        btnJaitsiKantitatea= findViewById(R.id.btnJaitsiKantitatea);
        btnIgoKantitatea= findViewById(R.id.btnIgoKantitatea);

        produktuArgazkia = findViewById(R.id.produktuArgazkia);
        produktuArgazkia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //Ezin izatea kantitatea eskuz editatzea bakarrik botoiekin
        kantitateZenbakia =  findViewById(R.id.kantitateZenbakia);
        kantitateZenbakia.setEnabled(false);
        amaituErosketa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPdf();
            }
        });

        btnJaitsiKantitatea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kantitatea= Integer.parseInt(kantitateZenbakia.getText().toString());
                if (kantitatea > 1) {
                    kantitateZenbakia.setText(String.valueOf(kantitatea - 1));
                }
            }
        });

        btnIgoKantitatea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kantitatea= Integer.parseInt(kantitateZenbakia.getText().toString());
                kantitateZenbakia.setText(String.valueOf(kantitatea + 1));
            }
        });

    }

    private void createPdf() {
        // Data
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String momentukoData = dateFormat.format(new Date());

        // Create a new PdfDocument
        PdfDocument document = new PdfDocument();

        // Page configuration
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(600, 800, 1).create();
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(12);

        // Load image from resources (You need to put an image in your drawable folder)
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.local_agro_market_logo); // Replace "logo" with the actual image resource name

        // Draw logo at the top of the page
        float leftMargin = 50;
        float topMargin = 50;
        float logoWidth = 100;
        float logoHeight = 50;
        canvas.drawBitmap(bitmap, null, new RectF(leftMargin, topMargin, leftMargin + logoWidth, topMargin + logoHeight), null);

        // Invoice header
        paint.setTextSize(20);
        paint.setFakeBoldText(true);
        canvas.drawText("FACTURA", 250, 120, paint);

        // Invoice details
        paint.setTextSize(12);
        paint.setFakeBoldText(false);
        canvas.drawText("Número de factura: 001", 50, 180, paint);
        canvas.drawText("Fecha: " + momentukoData, 50, 200, paint);
        canvas.drawText("Cliente: Juan Pérez", 50, 220, paint);
        canvas.drawText("Dirección: Calle Principal, 123", 50, 240, paint);

        // Line separator
        canvas.drawLine(50, 270, 550, 270, paint);

        // Table header
        paint.setFakeBoldText(true);
        canvas.drawText("Producto", 100, 300, paint);
        canvas.drawText("Cantidad", 300, 300, paint);
        canvas.drawText("Precio Unitario", 400, 300, paint);
        canvas.drawText("Total", 500, 300, paint);

        // Table rows
        paint.setFakeBoldText(false);
        canvas.drawText("Producto A", 100, 330, paint);
        canvas.drawText("2", 300, 330, paint);
        canvas.drawText("$10", 400, 330, paint);
        canvas.drawText("$20", 500, 330, paint);

        canvas.drawText("Producto B", 100, 360, paint);
        canvas.drawText("1", 300, 360, paint);
        canvas.drawText("$15", 400, 360, paint);
        canvas.drawText("$15", 500, 360, paint);

        // Line separator
        canvas.drawLine(50, 390, 550, 390, paint);

        // Total
        paint.setFakeBoldText(true);
        canvas.drawText("TOTAL:", 400, 420, paint);
        canvas.drawText("$35", 500, 420, paint);

        // Finish the page
        document.finishPage(page);

        // Save the document
        String directoryPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        String filePath = directoryPath + "/Facturas.pdf";
        File file = new File(filePath);
        try {
            document.writeTo(new FileOutputStream(file));
            Toast.makeText(SaskiActivity.this, "PDF creado y guardado en Descargas", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(SaskiActivity.this, "Error al crear PDF", Toast.LENGTH_SHORT).show();
        }
        // Close the document
        document.close();
    }
}