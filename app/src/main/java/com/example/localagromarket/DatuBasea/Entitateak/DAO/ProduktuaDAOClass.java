package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.Model.ArgazkiaClass;
import com.example.localagromarket.DatuBasea.Entitateak.Model.BezClass;
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
                ResultSet rs = stmt.executeQuery("SELECT p.kodProduktua, p.izenaEus, p.deskribapenaEus, p.prezioa, p.stoka, p.pisua, p.kantitateta, b.kodBez, b.portzentaia, b.deskribapenaEus, a.kodArgazkia, a.img FROM produktua p INNER JOIN bez b ON b.kodBez = p.kodBez INNER JOIN argazkia a ON a.kodArgazkia = p.kodArgazkia;");

                while (rs.next()) {
                    int kodProduktua = rs.getInt(1);
                    String izenaEus = rs.getString(2);
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
                    ProduktuClass produktua = new ProduktuClass(kodProduktua, izenaEus, deskribapenaEus, prezioa, stoka, pisua, kantitatea, bez, argazkia);
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
