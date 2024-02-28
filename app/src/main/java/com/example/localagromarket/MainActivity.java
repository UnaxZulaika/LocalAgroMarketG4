package com.example.localagromarket;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.osmdroid.config.Configuration;

public class
MainActivity extends AppCompatActivity implements GoikoMenuFragment.ProfilaFragmentClickListener {

    private MapaFragment mapaFragment = new MapaFragment();
    private GoikoMenuFragment goikoMenuaFragment = new GoikoMenuFragment();
    private ProduktuakFragment produktuakFragment = new ProduktuakFragment();
    private ProfilaFragment profilaFragment = new ProfilaFragment();
    private static final int PRODUKTUAK_FRAGMENT_ID = R.id.produktuakFragment;
    private static final int MAPA_FRAGMENT_ID = R.id.mapaFragment;
    private static final int PROFILA_FRAGMENT_ID = R.id.profilaFragment;
    private static final int UNCHECKED_ITEM_ID = R.id.uncheckedItem;
    int contenedorId = R.id.frame_container;
    int contenedorInfoId = R.id.frame_container_info;

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.findViewById(R.id.uncheckedItem).setVisibility(View.GONE);

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        erakutsiIkasleMenua();
    }
    private final BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        int itemId = item.getItemId();

        if (itemId == PRODUKTUAK_FRAGMENT_ID) {
            loadFragment(goikoMenuaFragment, contenedorInfoId);
            loadFragment(produktuakFragment, contenedorId);

            bottomNavigationView.getMenu().findItem(R.id.produktuakFragment).setChecked(true);
            bottomNavigationView.findViewById(R.id.uncheckedItem).setVisibility(View.GONE);

            return true;
        } else if (itemId == MAPA_FRAGMENT_ID) {
            // goikoMenuaFragment kentzen du
            getSupportFragmentManager().beginTransaction().remove(goikoMenuaFragment).commit();

            loadFragment(mapaFragment, contenedorId);

            bottomNavigationView.getMenu().findItem(R.id.mapaFragment).setChecked(true);
            bottomNavigationView.findViewById(R.id.uncheckedItem).setVisibility(View.GONE);
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
        bottomNavigationView.setVisibility(View.VISIBLE);
        loadFragment(goikoMenuaFragment, contenedorInfoId);
        loadFragment(produktuakFragment, contenedorId);
        goikoMenuaFragment.setProfilaFragmentClickListener(this);
        bottomNavigationView.setOnItemSelectedListener(mOnNavigationItemSelectedListener); // Nabegazio menuari logika gehitzen dio
        // Mapa kargatzeko
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

    }

    public GoikoMenuFragment getGoikoMenuFragment() {
        return goikoMenuaFragment;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        bottomNavigationView.setSelectedItemId(PRODUKTUAK_FRAGMENT_ID);

        loadFragment(goikoMenuaFragment, contenedorInfoId);
        loadFragment(produktuakFragment, contenedorId);
    }

    @Override
    public void onProfilaFragmentClicked() {
        getSupportFragmentManager().beginTransaction().remove(goikoMenuaFragment).commit();

        loadFragment(profilaFragment, contenedorId);
        bottomNavigationView.getMenu().findItem(R.id.uncheckedItem).setChecked(true);
        bottomNavigationView.findViewById(R.id.uncheckedItem).setVisibility(View.GONE);
    }



}