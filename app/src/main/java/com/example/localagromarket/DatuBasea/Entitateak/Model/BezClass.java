package com.example.localagromarket.DatuBasea.Entitateak.Model;

public class BezClass {
    private int kodBez;
    private int portzentaia;
    private String deskribapenaEus;

    // Constructor
    public BezClass(int kodBez, int portzentaia, String deskribapenaEus) {
        this.kodBez = kodBez;
        this.portzentaia = portzentaia;
        this.deskribapenaEus = deskribapenaEus;
    }
    public BezClass(){}

    // Getters
    public int getKodBez() {
        return kodBez;
    }
    public int getPortzentaia() {
        return portzentaia;
    }
    public String getdeskribapenaEus() {
        return deskribapenaEus;
    }

    // Setters
    public void setKodBez(int kodBez) {
        this.kodBez = kodBez;
    }
    public void setPortzentaia(int portzentaia) {
        this.portzentaia = portzentaia;
    }
    public void setdeskribapenaEus(String deskribapenaEus) {
        this.deskribapenaEus = deskribapenaEus;
    }
}
