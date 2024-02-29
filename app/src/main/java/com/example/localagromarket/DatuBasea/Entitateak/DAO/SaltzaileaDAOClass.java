package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.BezClass;
import com.example.localagromarket.DatuBasea.Entitateak.SaltzaileaClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SaltzaileaDAOClass {
    private static final String url = "jdbc:mysql://10.5.13.127:3306/local_agro_market?autoReconnect=true&useSSL=false";
    private static final String user = "aingeru";
    private static final String password = "12345678";

    // GetSaltzaileak
    public List<SaltzaileaClass> getSaltzaileak() {
        try {
            return new Saltzaileak().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class Saltzaileak extends AsyncTask<Void, Void, List<SaltzaileaClass>> {
        @Override
        protected List<SaltzaileaClass> doInBackground(Void... voids) {
            List<SaltzaileaClass> saltzaileak = new ArrayList<>();
            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM saltzaileak");

                while (rs.next()) {
                    int kodSaltzailea = rs.getInt(1);
                    String nan = rs.getString(2);
                    String izena = rs.getString(3);
                    String abizena1 = rs.getString(4);
                    String abizena2 = rs.getString(5);
                    String helbidea = rs.getString(6);
                    String telefonoa = rs.getString(7);
                    String email = rs.getString(8);
                    String pasahitza = rs.getString(9);
                    String postaKodea = rs.getString(10);
                    String probintzia = rs.getString(11);
                    String herria = rs.getString(12);
                    SaltzaileaClass saltzailea = new SaltzaileaClass(kodSaltzailea, nan, izena, abizena1, abizena2, helbidea, telefonoa, email, pasahitza, postaKodea, probintzia, herria);
                    saltzaileak.add(saltzailea);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Log.e("SaltzaileaDAOClass", "Error al ejecutar la consulta MySQL", e);
            }
            return saltzaileak;
        }
    }

    // GetSaltzailea
    public List<SaltzaileaClass> getSaltzailea() {
        try {
            return new Saltzailea().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class Saltzailea extends AsyncTask<String, Void, List<SaltzaileaClass>> {
        @Override
        protected List<SaltzaileaClass> doInBackground(String... filters) {
            List<SaltzaileaClass> saltzaileak = new ArrayList<>();
            String filter = filters.length > 0 ? filters[0] : "";
            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM saltzaileak");

                while (rs.next()) {
                    int kodSaltzailea = rs.getInt(1);
                    String nan = rs.getString(2);
                    String izena = rs.getString(3);
                    String abizena1 = rs.getString(4);
                    String abizena2 = rs.getString(5);
                    String helbidea = rs.getString(6);
                    String telefonoa = rs.getString(7);
                    String email = rs.getString(8);
                    String pasahitza = rs.getString(9);
                    String postaKodea = rs.getString(10);
                    String probintzia = rs.getString(11);
                    String herria = rs.getString(12);
                    SaltzaileaClass saltzailea = new SaltzaileaClass(kodSaltzailea, nan, izena, abizena1, abizena2, helbidea, telefonoa, email, pasahitza, postaKodea, probintzia, herria);
                    saltzaileak.add(saltzailea);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Log.e("SaltzaileaDAOClass", "Error al ejecutar la consulta MySQL", e);
            }
            return saltzaileak;
        }
    }
}
