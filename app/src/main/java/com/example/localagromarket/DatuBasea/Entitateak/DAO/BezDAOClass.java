package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.Model.BezClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BezDAOClass {
    private static final String url = "jdbc:mysql://10.5.13.127:3306/local_agro_market?autoReconnect=true&useSSL=false";
    private static final String user = "aingeru";
    private static final String password = "12345678";

    // GetBez
    public List<BezClass> getBezak() {
        try {
            return new BEZak().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class BEZak extends AsyncTask<Void, Void, List<BezClass>> {
        @Override
        protected List<BezClass> doInBackground(Void... voids) {
            List<BezClass> bezak = new ArrayList<>();
            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM produktua");

                while (rs.next()) {
                    int kodBez = rs.getInt(1);
                    int portzentaia = rs.getInt(2);
                    String deskribapenaEus = rs.getString(3);
                    BezClass bez = new BezClass();
                    bezak.add(bez);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Log.e("BEZDAOClass", "Error al ejecutar la consulta MySQL", e);
            }
            return bezak;
        }
    }
}
