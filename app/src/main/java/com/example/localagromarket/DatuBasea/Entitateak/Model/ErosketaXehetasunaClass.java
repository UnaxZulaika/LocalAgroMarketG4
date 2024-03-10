package com.example.localagromarket.DatuBasea.Entitateak.Model;

public class ErosketaXehetasunaClass {
    private ErosketaClass erosketa = new ErosketaClass();
    private ProduktuClass produktua = new ProduktuClass();
    private int kantitatea;
    private float prezioa;

    // Constructors
    public ErosketaXehetasunaClass(ErosketaClass erosketa, ProduktuClass produktua, int kantitatea, float prezioa) {
        this.erosketa = erosketa;
        this.produktua = produktua;
        this.kantitatea = kantitatea;
        this.prezioa = prezioa;
    }
    public ErosketaXehetasunaClass(){}

    // Getters
    public ErosketaClass getErosketa() {
        return erosketa;
    }
    public ProduktuClass getProduktua() {
        return produktua;
    }
    public int getKantitatea() {
        return kantitatea;
    }
    public float getPrezioa() {
        return prezioa;
    }

    // Setters
    public void setErosketa(ErosketaClass erosketa) {
        this.erosketa = erosketa;
    }
    public void setProduktua(ProduktuClass produktua) {
        this.produktua = produktua;
    }
    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }
    public void setPrezioa(float prezioa) {
        this.prezioa = prezioa;
    }
}
