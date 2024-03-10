package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.Model.BezeroaClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BezeroDAOCLass {
    private static final String url = "jdbc:mysql://10.5.13.127:3306/local_agro_market?autoReconnect=true&useSSL=false";
    private static final String user = "aingeru";
    private static final String password = "12345678";

    // GetBezeroa
    public List<BezeroaClass> getBezeroak() {
        try {
            return new Bezeroa().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class Bezeroa extends AsyncTask<Void, Void, List<BezeroaClass>> {
        @Override
        protected List<BezeroaClass> doInBackground(Void... voids) {
            List<BezeroaClass> bezeroak = new ArrayList<>();
            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM bezeroa");

                while (rs.next()) {
                    int kodBezeroa = rs.getInt(1);
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
                    BezeroaClass bezeroa = new BezeroaClass(kodBezeroa, nan, izena, abizena1, abizena2, helbidea, telefonoa, email, pasahitza, postaKodea, probintzia, herria);
                    bezeroak.add(bezeroa);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Log.e("BezeroaDAOClass", "Error al ejecutar la consulta MySQL", e);
            }
            return bezeroak;
        }
    }
}
