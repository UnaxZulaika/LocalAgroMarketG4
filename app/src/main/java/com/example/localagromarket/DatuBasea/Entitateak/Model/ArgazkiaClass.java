package com.example.localagromarket.DatuBasea.Entitateak.Model;

public class ArgazkiaClass {
    private int kodArgazkia;
    private String path;

    // Constructor
    public ArgazkiaClass(int kodArgazkia, String path) {
        this.kodArgazkia = kodArgazkia;
        this.path = path;
    }
    public ArgazkiaClass(){}

    // Getters

    public int getKodArgazkia() {
        return kodArgazkia;
    }
    public String getPath() {
        return path;
    }

    // Setters
    public void setKodArgazkia(int kodArgazkia) {
        this.kodArgazkia = kodArgazkia;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
