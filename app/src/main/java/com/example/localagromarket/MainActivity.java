package com.example.localagromarket;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.osmdroid.config.Configuration;

public class
MainActivity extends AppCompatActivity {
    private MapaFragment mapaFragment = new MapaFragment();
    private ProduktuakFragment produktuakFragment = new ProduktuakFragment();
    private ProfilaFragment profilaFragment = new ProfilaFragment();
    private static final int PRODUKTUAK_FRAGMENT_ID = R.id.produktuakFragment;
    private static final int MAPA_FRAGMENT_ID = R.id.mapaFragment;
    private static final int PROFILA_FRAGMENT_ID = R.id.profilaFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        erakutsiIkasleMenua();
        loadFragment(produktuakFragment);
    }
    private final BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        int itemId = item.getItemId();

        if (itemId == PRODUKTUAK_FRAGMENT_ID) {
            loadFragment(produktuakFragment);
            return true;
        } else if (itemId == MAPA_FRAGMENT_ID) {
            loadFragment(mapaFragment);
            return true;
        } else if (itemId == PROFILA_FRAGMENT_ID) {
            loadFragment(profilaFragment);
            return true;
        }
        return false;
    };

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    private void erakutsiIkasleMenua() {
        BottomNavigationView navigationIkasle = findViewById(R.id.bottom_navigation);
        navigationIkasle.setVisibility(View.VISIBLE);
        //loadFragment(guneakFragment); // Ikaslearen fragmenta kargatzen du
        navigationIkasle.setOnItemSelectedListener(mOnNavigationItemSelectedListener); // Nabegazio menuari logika gehitzen dio

        // Mapa kargatzeko
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

    }
}