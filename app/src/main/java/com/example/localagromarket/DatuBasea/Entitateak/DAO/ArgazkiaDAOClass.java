package com.example.localagromarket.DatuBasea.Entitateak.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.localagromarket.DatuBasea.Entitateak.Model.ArgazkiaClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ArgazkiaDAOClass {
    private static final String url = "jdbc:mysql://10.5.13.127:3306/local_agro_market?autoReconnect=true&useSSL=false";
    private static final String user = "aingeru";
    private static final String password = "12345678";

    // GetArgazkia
    public List<ArgazkiaClass> getArgazkiak() {
        try {
            return new Argazkiak().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class Argazkiak extends AsyncTask<Void, Void, List<ArgazkiaClass>> {
        @Override
        protected List<ArgazkiaClass> doInBackground(Void... voids) {
            List<ArgazkiaClass> argazkiak = new ArrayList<>();
            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM argazkia");

                while (rs.next()) {
                    int kodBez = rs.getInt(1);
                    ArgazkiaClass argazkia = new ArgazkiaClass();
                    argazkiak.add(argazkia);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Log.e("ArgazkiaDAOClass", "Error al ejecutar la consulta MySQL", e);
            }
            return argazkiak;
        }
    }
}
