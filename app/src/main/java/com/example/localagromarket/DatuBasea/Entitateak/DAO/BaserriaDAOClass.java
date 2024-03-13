package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.Model.BaserriaClass;
import com.example.localagromarket.DatuBasea.Entitateak.Model.ProduktuClass;
import com.example.localagromarket.DatuBasea.Entitateak.Model.SaltzaileaClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BaserriaDAOClass {
    private static final String url = "jdbc:mysql://10.5.13.127:3306/local_agro_market?autoReconnect=true&useSSL=false";
    private static final String user = "aingeru";
    private static final String password = "12345678";

    // GetProduktuak
    public List<BaserriaClass> getBaserriak() {
        try {
            return new Baserriak().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class Baserriak extends AsyncTask<Void, Void, List<BaserriaClass>> {
        @Override
        protected List<BaserriaClass> doInBackground(Void... voids) {
            List<BaserriaClass> baserriak = new ArrayList<>();
            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT b.kodBaserria, b.izena, s.kodSaltzailea, s.nan, s.izena, s.abizena1, s.abizena2, s.helbidea, s.telefonoa, s.email, s.pasahitza, s.postaKodea, s.probintzia, s.herria, b.lokalizazioa, b.deskribapenaEus FROM saltzailea s INNER JOIN baserria b ON s.kodSaltzailea = b.kodSaltzailea;");

                while (rs.next()) {
                    int kodBaserria = rs.getInt(1);
                    String izena = rs.getString(2);
                    int skodSaltzailea = rs.getInt(3);
                    String snan = rs.getString(4);
                    String sizena = rs.getString(5);
                    String sabizena1 = rs.getString(6);
                    String sabizena2 = rs.getString(7);
                    String shelbidea = rs.getString(8);
                    String stelefonoa = rs.getString(9);
                    String semail = rs.getString(10);
                    String spasahitza = rs.getString(11);
                    String spostaKodea = rs.getString(12);
                    String sprobintzia = rs.getString(13);
                    String sherria = rs.getString(14);
                    double lokalizazioa = rs.getDouble(15);
                    String deskribapenaEUS = rs.getString(16);

                    SaltzaileaClass saltzailea = new SaltzaileaClass(skodSaltzailea, snan, sizena, sabizena1, sabizena2, shelbidea, stelefonoa, semail, spasahitza, spostaKodea, sprobintzia, sherria);
                    BaserriaClass baserria = new BaserriaClass(kodBaserria, izena, saltzailea, lokalizazioa, deskribapenaEUS);
                    baserriak.add(baserria);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Log.e("ProduktuDAOClass", "Error al ejecutar la consulta MySQL", e);
            }
            return baserriak;
        }
    }
}
