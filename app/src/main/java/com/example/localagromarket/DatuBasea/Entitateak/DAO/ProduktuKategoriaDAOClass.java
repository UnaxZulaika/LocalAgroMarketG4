package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.Model.ProduktuKategoriaClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProduktuKategoriaDAOClass {
    private static final String url = "jdbc:mysql://10.5.13.127:3306/local_agro_market?autoReconnect=true&useSSL=false";
    private static final String user = "aingeru";
    private static final String password = "12345678";

    // GetProduktuKategoriak
    public List<ProduktuKategoriaClass> getProduktuKategoriak() {
        try {
            return new ProduktuKategoria().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class ProduktuKategoria extends AsyncTask<Void, Void, List<ProduktuKategoriaClass>> {
        @Override
        protected List<ProduktuKategoriaClass> doInBackground(Void... voids) {
            List<ProduktuKategoriaClass> produktuKategoriak = new ArrayList<>();
            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM produktukategoria");

                while (rs.next()) {
                    int kodSaltzailea = rs.getInt(1);
                    ProduktuKategoriaClass produktuKategoria = new ProduktuKategoriaClass();
                    produktuKategoriak.add(produktuKategoria);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Log.e("ProduktuKategoriaDAOClass", "Error al ejecutar la consulta MySQL", e);
            }
            return produktuKategoriak;
        }
    }
}
