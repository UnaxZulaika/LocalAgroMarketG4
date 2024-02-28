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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProduktuakFragment extends Fragment {

    private ImageButton addToCartButton;
    public ProduktuakFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_produktuak, container, false);
        addToCartButton = view.findViewById(R.id.addToCartButton);

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                erakutsiMezua();

                if (getActivity() != null && getActivity() instanceof MainActivity) {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    GoikoMenuFragment goikoMenuaFragment = mainActivity.getGoikoMenuFragment();

                    if (goikoMenuaFragment != null) {
                        goikoMenuaFragment.updateCartCount();
                    }
                }
            }
        });

        return view;
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
                alertDialog.dismiss();
            }
        });
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        alertDialog.show();
    }
}
