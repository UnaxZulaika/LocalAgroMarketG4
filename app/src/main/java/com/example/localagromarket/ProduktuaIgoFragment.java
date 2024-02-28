package com.example.localagromarket;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProduktuaIgoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProduktuaIgoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final int MAX_LENGTH = 10;
    public ProduktuaIgoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProduktuaIgoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProduktuaIgoFragment newInstance(String param1, String param2) {
        ProduktuaIgoFragment fragment = new ProduktuaIgoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produktua_igo, container, false);

        // Obtener referencia al Spinner
        Spinner productSpinner = view.findViewById(R.id.productSpinner);
        // Obtener referencia al EditText para la cantidad
        EditText quantityEditText = view.findViewById(R.id.quantityEditText);
        // Obtener referencia al TextView para la etiqueta de cantidad
        TextView quantityLabel = view.findViewById(R.id.quantityLabel);
        TextView kgTextView = view.findViewById(R.id.kgTextView);

        // Datos para el Spinner
        List<String> productList = new ArrayList<>(Arrays.asList(
                "Kalabaza",
                "Letxugak",
                "Tipulak",
                "Esnea",
                "Gazta",
                "Jogurta",
                "Tomatea",
                "Sagarra",
                "Laranja",
                "Ogi integrala",
                "Masa amako ogia",
                "Euskal pastela",
                "Txahal-xerra",
                "Oilaskoa",
                "Txerrikumea",
                "Babarrun gorria",
                "Txitxirio",
                "Babarrun zuria",
                "Arrutzak M",
                "Arrautzak L",
                "Galeper-arrautzak",
                "Shitake perretxikoa",
                "Belarri landua",
                "Barrengorria"
        ));

        // Ordenar alfabéticamente la lista de productos
        Collections.sort(productList);

        // Crear ArrayAdapter usando el listado de productos y un layout simple
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), // Use requireContext() instead of getActivity() for Fragments
                android.R.layout.simple_spinner_item,
                productList
        );

        // Especificar el layout a usar cuando aparece la lista de opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Establecer el ArrayAdapter como adaptador del Spinner
        productSpinner.setAdapter(adapter);

        // Agregar listener al Spinner para manejar la selección de productos
        productSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Reiniciar el contenido del EditText
                quantityEditText.setText("");

                // Obtener el producto seleccionado
                String selectedProduct = productList.get(position);

                // Verificar si el producto seleccionado es "Tomatea"
                if (selectedProduct.equals("Tomatea")) {
                    // Si es "Tomate", mostrar el campo de entrada de peso
                    quantityLabel.setText("Peso"); // Cambiar la etiqueta a "Peso (Kg)"

                    quantityEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    quantityEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(MAX_LENGTH)});

                    kgTextView.setVisibility(View.VISIBLE);

                } else {
                    // Si es otro producto, mostrar el campo de entrada de cantidad
                    quantityLabel.setText("Cantidad"); // Cambiar la etiqueta a "Cantidad"
                    // Configurar el EditText para entrada numérica sin decimales
                    quantityEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                    quantityEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(MAX_LENGTH)});

                    kgTextView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada si no se selecciona nada
            }
        });


        return view;
    }
}