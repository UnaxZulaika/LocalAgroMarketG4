package com.example.localagromarket.Entitateak;

public class EskaeraXehetasunaClass {
    private EskaeraClass eskaera = new EskaeraClass();
    private ProduktuClass produktua = new ProduktuClass();
    private int kantitatea;
    private float prezioa;

    // Constructor
    public EskaeraXehetasunaClass(EskaeraClass eskaera, ProduktuClass produktua, int kantitatea, float prezioa) {
        this.eskaera = eskaera;
        this.produktua = produktua;
        this.kantitatea = kantitatea;
        this.prezioa = prezioa;
    }
    public EskaeraXehetasunaClass(){}

    // Getters
    public EskaeraClass getEskaera() {
        return eskaera;
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
    public void setEskaera(EskaeraClass eskaera) {
        this.eskaera = eskaera;
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
