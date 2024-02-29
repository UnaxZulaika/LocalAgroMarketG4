package com.example.localagromarket.DatuBasea.Entitateak;

public class BaserriaClass {
    private int kodBaserria;
    private String izena;
    private SaltzaileaClass Saltzailea = new SaltzaileaClass();
    private double lokalizazioa;
    private String deskribapenaEus;

    // Constructor
    public BaserriaClass(int kodBaserria, String izena, SaltzaileaClass saltzailea, double lokalizazioa, String deskribapenaEus) {
        this.kodBaserria = kodBaserria;
        this.izena = izena;
        Saltzailea = saltzailea;
        this.lokalizazioa = lokalizazioa;
        this.deskribapenaEus = deskribapenaEus;
    }
    public BaserriaClass(){}

    // Getters
    public int getKodBaserria() {
        return kodBaserria;
    }
    public String getIzena() {
        return izena;
    }
    public SaltzaileaClass getSaltzailea() {
        return Saltzailea;
    }
    public double getLokalizazioa() {
        return lokalizazioa;
    }
    public String getDeskribapenaEus() {
        return deskribapenaEus;
    }

    // Setters
    public void setKodBaserria(int kodBaserria) {
        this.kodBaserria = kodBaserria;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public void setSaltzailea(SaltzaileaClass saltzailea) {
        Saltzailea = saltzailea;
    }
    public void setLokalizazioa(double lokalizazioa) {
        this.lokalizazioa = lokalizazioa;
    }
    public void setDeskribapenaEus(String deskribapenaEus) {
        this.deskribapenaEus = deskribapenaEus;
    }
}
