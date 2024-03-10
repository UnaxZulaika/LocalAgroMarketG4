package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.Model.ProduktuClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProduktuaDAOClass {
    private static final String url = "jdbc:mysql://10.5.13.127:3306/local_agro_market?autoReconnect=true&useSSL=false";
    private static final String user = "aingeru";
    private static final String password = "12345678";

    // GetProduktuak
    public List<ProduktuClass> getProduktuak() {
        try {
            return new Produktuak().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class Produktuak extends AsyncTask<Void, Void, List<ProduktuClass>> {
        @Override
        protected List<ProduktuClass> doInBackground(Void... voids) {
            List<ProduktuClass> produktuak = new ArrayList<>();
            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM produktua");

                while (rs.next()) {
                    int kodProduktua = rs.getInt(1);
                    String izenaEus = rs.getString(2);
                    String deskribapenaEus = rs.getString(3);
                    Float prezioa = rs.getFloat(4);
                    int stoka = rs.getInt(5);
                    Float pisua = rs.getFloat(6);
                    int kantitatea = rs.getInt(7);
                    ProduktuClass produktua = new ProduktuClass();
                    produktuak.add(produktua);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Log.e("ProduktuDAOClass", "Error al ejecutar la consulta MySQL", e);
            }
            return produktuak;
        }
    }
}
