package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.Model.ArgazkiaClass;
import com.example.localagromarket.DatuBasea.Entitateak.Model.BezClass;
import com.example.localagromarket.DatuBasea.Entitateak.Model.KategoriaClass;
import com.example.localagromarket.DatuBasea.Entitateak.Model.ProduktuClass;
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
                ResultSet rs = stmt.executeQuery("SELECT k.kodKategoria, k.izenaEus, p.kodProduktua, p.izenaEus, p.deskribapenaEus, p.prezioa, p.stoka, p.pisua, p.kantitateta FROM produktukategoria pk INNER JOIN kategoria k On pk.kodKategoria = k.kodKategoria INNER JOIN produktua p ON p.kodProduktua = pk.kodProduktua;");

                while (rs.next()) {
                    int kodKategoria = rs.getInt(1);
                    String izenaEus = rs.getString(2);
                    int kodProduktua = rs.getInt(1);
                    String pizenaEus = rs.getString(2);
                    String deskribapenaEus = rs.getString(3);
                    Float prezioa = rs.getFloat(4);
                    int stoka = rs.getInt(5);
                    Float pisua = rs.getFloat(6);
                    int kantitatea = rs.getInt(7);
                    int bkodBez = rs.getInt(8);
                    int bportzentaia = rs.getInt(9);
                    String bdeskribapenaEus = rs.getString(10);
                    int akodArgazkia = rs.getInt(11);
                    String aimg = rs.getString(12);

                    BezClass bez = new BezClass(bkodBez, bportzentaia, bdeskribapenaEus);
                    ArgazkiaClass argazkia = new ArgazkiaClass(akodArgazkia, aimg);
                    ProduktuClass produktua = new ProduktuClass(kodProduktua, pizenaEus, deskribapenaEus, prezioa, stoka, pisua, kantitatea, bez, argazkia);

                    KategoriaClass kategoria = new KategoriaClass(kodKategoria, izenaEus);
                    ProduktuKategoriaClass produktuKategoria = new ProduktuKategoriaClass(kategoria,produktua);
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
