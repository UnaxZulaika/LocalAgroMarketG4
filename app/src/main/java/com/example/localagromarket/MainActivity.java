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
    private GoikoMenuFragment goikoMenuaFragment = new GoikoMenuFragment();
    private ProduktuakFragment produktuakFragment = new ProduktuakFragment();
    private ProfilaFragment profilaFragment = new ProfilaFragment();
    private static final int PRODUKTUAK_FRAGMENT_ID = R.id.produktuakFragment;
    private static final int MAPA_FRAGMENT_ID = R.id.mapaFragment;
    private static final int PROFILA_FRAGMENT_ID = R.id.profilaFragment;
    int contenedorId = R.id.frame_container;
    int contenedorInfoId = R.id.frame_container_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        erakutsiIkasleMenua();
    }
    private final BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        int itemId = item.getItemId();

        if (itemId == PRODUKTUAK_FRAGMENT_ID) {
            loadFragment(goikoMenuaFragment, contenedorInfoId);
            loadFragment(produktuakFragment, contenedorId);
            return true;
        } else if (itemId == MAPA_FRAGMENT_ID) {
            // goikoMenuaFragment kentzen du
            getSupportFragmentManager().beginTransaction().remove(goikoMenuaFragment).commit();

            loadFragment(mapaFragment, contenedorId);
            return true;
        } else if (itemId == PROFILA_FRAGMENT_ID) {
            // goikoMenuaFragment kentzen du
            getSupportFragmentManager().beginTransaction().remove(goikoMenuaFragment).commit();

            loadFragment(profilaFragment, contenedorId);
            return true;
        }
        return false;
    };

    public void loadFragment(Fragment fragment, int containerId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void erakutsiIkasleMenua() {
        BottomNavigationView navigationIkasle = findViewById(R.id.bottom_navigation);
        navigationIkasle.setVisibility(View.VISIBLE);
        loadFragment(goikoMenuaFragment, contenedorInfoId);
        loadFragment(produktuakFragment, contenedorId);
        navigationIkasle.setOnItemSelectedListener(mOnNavigationItemSelectedListener); // Nabegazio menuari logika gehitzen dio
        // Mapa kargatzeko
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

    }

    public GoikoMenuFragment getGoikoMenuFragment() {
        return goikoMenuaFragment;
    }
}