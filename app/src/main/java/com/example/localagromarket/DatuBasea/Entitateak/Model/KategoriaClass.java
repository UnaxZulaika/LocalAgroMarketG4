package com.example.localagromarket.DatuBasea.Entitateak.Model;

public class KategoriaClass {
    private int kodKategoria;
    private String izenaEus;

    // Constructors
    public KategoriaClass(int kodKategoria, String izenaEus) {
        this.kodKategoria = kodKategoria;
        this.izenaEus = izenaEus;
    }
    public KategoriaClass(){}

    // Getters
    public int getKodKategoria() {
        return kodKategoria;
    }
    public String getIzenaEus() {
        return izenaEus;
    }

    // Setters
    public void setKodKategoria(int kodKategoria) {
        this.kodKategoria = kodKategoria;
    }
    public void setIzenaEus(String izenaEus) {
        this.izenaEus = izenaEus;
    }
}
