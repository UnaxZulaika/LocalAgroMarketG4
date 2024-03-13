package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.Model.KategoriaClass;
import com.example.localagromarket.DatuBasea.Entitateak.Model.ProduktuKategoriaClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class KategoriaDAOClass {
    private static final String url = "jdbc:mysql://10.5.13.127:3306/local_agro_market?autoReconnect=true&useSSL=false";
    private static final String user = "aingeru";
    private static final String password = "12345678";

    // GetKategoriak
    public List<KategoriaClass> getKategoriak() {
        try {
            return new Kategoria().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class Kategoria extends AsyncTask<Void, Void, List<KategoriaClass>> {
        @Override
        protected List<KategoriaClass> doInBackground(Void... voids) {
            List<KategoriaClass> kategoriak = new ArrayList<>();
            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM produktukategoria");

                while (rs.next()) {
                    int kodKategoria = rs.getInt(1);
                    String izenaEus = rs.getString(2);
                    KategoriaClass kategoria = new KategoriaClass(kodKategoria, izenaEus);
                    kategoriak.add(kategoria);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Log.e("KategoriaDAOClass", "Error al ejecutar la consulta MySQL", e);
            }
            return kategoriak;
        }
    }
}
