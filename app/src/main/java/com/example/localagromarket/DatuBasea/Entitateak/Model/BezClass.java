package com.example.localagromarket.DatuBasea.Entitateak.Model;

public class BezClass {
    private int kodBez;
    private int portzentaia;
    private String deskribapena;

    // Constructor
    public BezClass(int kodBez, int portzentaia, String deskribapena) {
        this.kodBez = kodBez;
        this.portzentaia = portzentaia;
        this.deskribapena = deskribapena;
    }
    public BezClass(){}

    // Getters
    public int getKodBez() {
        return kodBez;
    }
    public int getPortzentaia() {
        return portzentaia;
    }
    public String getDeskribapena() {
        return deskribapena;
    }

    // Setters
    public void setKodBez(int kodBez) {
        this.kodBez = kodBez;
    }
    public void setPortzentaia(int portzentaia) {
        this.portzentaia = portzentaia;
    }
    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }
}
