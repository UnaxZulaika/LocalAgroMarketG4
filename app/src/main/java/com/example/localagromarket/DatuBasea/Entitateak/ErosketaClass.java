package com.example.localagromarket.DatuBasea.Entitateak;

import java.util.Date;

public class ErosketaClass {
    private int kodErosketa;
    private Date erosketaData;
    private float totala;
    private SaltzaileaClass saltzailea = new SaltzaileaClass();

    // Constructor
    public ErosketaClass(int kodErosketa, Date erosketaData, float totala, SaltzaileaClass saltzailea) {
        this.kodErosketa = kodErosketa;
        this.erosketaData = erosketaData;
        this.totala = totala;
        this.saltzailea = saltzailea;
    }
    public ErosketaClass(){}

    // Getters
    public int getKodErosketa() {
        return kodErosketa;
    }
    public Date getErosketaData() {
        return erosketaData;
    }
    public float getTotala() {
        return totala;
    }
    public SaltzaileaClass getSaltzailea() {
        return saltzailea;
    }

    // Setter
    public void setKodErosketa(int kodErosketa) {
        this.kodErosketa = kodErosketa;
    }
    public void setErosketaData(Date erosketaData) {
        this.erosketaData = erosketaData;
    }
    public void setTotala(float totala) {
        this.totala = totala;
    }
    public void setSaltzailea(SaltzaileaClass saltzailea) {
        this.saltzailea = saltzailea;
    }
}
