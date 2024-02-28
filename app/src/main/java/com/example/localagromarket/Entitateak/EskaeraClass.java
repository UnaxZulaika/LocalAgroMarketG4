package com.example.localagromarket.Entitateak;

import java.util.Date;

public class EskaeraClass {
    private int kodEskaera;
    private Date eskaeraData;
    private boolean entregatuta;
    private BezeroaClass bezeroa = new BezeroaClass();

    // Constructors
    public EskaeraClass(int kodEskaera, Date eskaeraData, boolean entregatuta, BezeroaClass bezeroa) {
        this.kodEskaera = kodEskaera;
        this.eskaeraData = eskaeraData;
        this.entregatuta = entregatuta;
        this.bezeroa = bezeroa;
    }
    public EskaeraClass(){}

    // Getters
    public int getKodEskaera() {
        return kodEskaera;
    }
    public Date getEskaeraData() {
        return eskaeraData;
    }
    public boolean isEntregatuta() {
        return entregatuta;
    }
    public BezeroaClass getBezeroa() {
        return bezeroa;
    }

    // Setters
    public void setKodEskaera(int kodEskaera) {
        this.kodEskaera = kodEskaera;
    }
    public void setEskaeraData(Date eskaeraData) {
        this.eskaeraData = eskaeraData;
    }
    public void setEntregatuta(boolean entregatuta) {
        this.entregatuta = entregatuta;
    }
    public void setBezeroa(BezeroaClass bezeroa) {
        this.bezeroa = bezeroa;
    }
}
