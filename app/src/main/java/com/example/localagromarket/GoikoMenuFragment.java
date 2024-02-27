package com.example.localagromarket;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GoikoMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoikoMenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int productCount = 0;

    private TextView tvIzena;
    private ImageButton ibSaskia;
    private TextView cartItemCount;

    public GoikoMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GoikoMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GoikoMenuFragment newInstance(String param1, String param2) {
        GoikoMenuFragment fragment = new GoikoMenuFragment();
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
        View view = inflater.inflate(R.layout.fragment_goiko_menu, container, false);

        tvIzena = view.findViewById(R.id.tvIzena);
        ibSaskia = view.findViewById(R.id.ibSaskia);
        cartItemCount = view.findViewById(R.id.cartItemCount);

        ibSaskia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SaskiActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
    public void updateCartCount() {
        productCount++;
        if (productCount > 0) {
            cartItemCount.setVisibility(View.VISIBLE);
            if (productCount > 9) {
                cartItemCount.setText("9+");
            } else {
                cartItemCount.setText(String.valueOf(productCount));
            }
        } else {
            cartItemCount.setVisibility(View.INVISIBLE);
        }
    }

}