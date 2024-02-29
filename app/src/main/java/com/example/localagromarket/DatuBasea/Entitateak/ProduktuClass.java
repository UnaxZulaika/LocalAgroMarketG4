package com.example.localagromarket.DatuBasea.Entitateak;

import com.example.localagromarket.DatuBasea.Entitateak.ArgazkiaClass;
import com.example.localagromarket.DatuBasea.Entitateak.BezClass;

public class ProduktuClass {
    private int kodProduktua;
    private String izenaEus;
    private float prezioa;
    private int stoka;
    private float pisua;
    private int kantitatea;
    private BezClass bez = new BezClass();
    private ArgazkiaClass argazkia = new ArgazkiaClass();

    // Constructor
    public ProduktuClass(int kodProduktua, String izenaEus, float prezioa, int stoka, float pisua, int kantitatea, BezClass bez, ArgazkiaClass argazkia) {
        this.kodProduktua = kodProduktua;
        this.izenaEus = izenaEus;
        this.prezioa = prezioa;
        this.stoka = stoka;
        this.pisua = pisua;
        this.kantitatea = kantitatea;
        this.bez = bez;
        this.argazkia = argazkia;
    }
    public ProduktuClass(){}

    // Getters
    public int getKodProduktua() {
        return kodProduktua;
    }
    public String getIzenaEus() {
        return izenaEus;
    }
    public float getPrezioa() {
        return prezioa;
    }
    public int getStoka() {
        return stoka;
    }
    public float getPisua() {
        return pisua;
    }
    public int getKantitatea() {
        return kantitatea;
    }
    public BezClass getBez() {
        return bez;
    }
    public ArgazkiaClass getArgazkia() {
        return argazkia;
    }

    // Setters
    public void setKodProduktua(int kodProduktua) {
        this.kodProduktua = kodProduktua;
    }
    public void setIzenaEus(String izenaEus) {
        this.izenaEus = izenaEus;
    }
    public void setPrezioa(float prezioa) {
        this.prezioa = prezioa;
    }
    public void setStoka(int stoka) {
        this.stoka = stoka;
    }
    public void setPisua(float pisua) {
        this.pisua = pisua;
    }
    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }
    public void setBez(BezClass bez) {
        this.bez = bez;
    }
    public void setArgazkia(ArgazkiaClass argazkia) {
        this.argazkia = argazkia;
    }

}
