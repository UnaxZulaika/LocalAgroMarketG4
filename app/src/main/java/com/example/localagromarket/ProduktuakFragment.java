package com.example.localagromarket;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProduktuakFragment extends Fragment {

    private Button createPdfButton;
    private ImageButton addToCartButton;
    public ProduktuakFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_produktuak, container, false);
        createPdfButton = view.findViewById(R.id.createPdfButton);
        addToCartButton = view.findViewById(R.id.addToCartButton);

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {erakutsiMezua();
            }
        });



        createPdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPdf();
            }
        });

        return view;
    }

    private void createPdf() {
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
        canvas.drawText("Fecha: 26/02/2024", 50, 200, paint);
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
        String filePath = directoryPath + "/Factura.pdf";
        File file = new File(filePath);
        try {
            document.writeTo(new FileOutputStream(file));
            Toast.makeText(getActivity(), "PDF creado y guardado en Descargas", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "Error al crear PDF", Toast.LENGTH_SHORT).show();
        }
        // Close the document
        document.close();
    }

    private void erakutsiMezua() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.eroskerarekin_jarraitu, null);

        Button erostenJarraitu = view.findViewById(R.id.erostenJarraitu);
        Button saskiraJoan = view.findViewById(R.id.saskiraJoan);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);

        erostenJarraitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        saskiraJoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SaskiActivity.class);
                startActivity(intent);
            }
        });
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        alertDialog.show();
    }
}
