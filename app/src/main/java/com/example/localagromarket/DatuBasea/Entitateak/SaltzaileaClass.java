package com.example.localagromarket.DatuBasea.Entitateak;

public class SaltzaileaClass {
    private int kodSaltzailea;
    private String nan;
    private String izena;
    private String abizena1;
    private String abizena2;
    private String helbidea;
    private String telefonoa;
    private String email;
    private String pasahitza;
    private String postaKodea;
    private String probintzia;
    private String herria;

    // Constructor
    public SaltzaileaClass(int kodSaltzailea, String nan, String izena, String abizena1, String abizena2, String helbidea, String telefonoa, String email, String pasahitza, String postaKodea, String probintzia, String herria) {
        this.kodSaltzailea = kodSaltzailea;
        this.nan = nan;
        this.izena = izena;
        this.abizena1 = abizena1;
        this.abizena2 = abizena2;
        this.helbidea = helbidea;
        this.telefonoa = telefonoa;
        this.email = email;
        this.pasahitza = pasahitza;
        this.postaKodea = postaKodea;
        this.probintzia = probintzia;
        this.herria = herria;
    }
    public SaltzaileaClass(){}

    // Getters
    public int getKodSaltzailea() {
        return kodSaltzailea;
    }
    public String getNan() {
        return nan;
    }
    public String getIzena() {
        return izena;
    }
    public String getAbizena1() {
        return abizena1;
    }
    public String getAbizena2() {
        return abizena2;
    }
    public String getHelbidea() {
        return helbidea;
    }
    public String getTelefonoa() {
        return telefonoa;
    }
    public String getEmail() {
        return email;
    }
    public String getPasahitza() {
        return pasahitza;
    }
    public String getPostaKodea() {
        return postaKodea;
    }
    public String getProbintzia() {
        return probintzia;
    }
    public String getHerria() {
        return herria;
    }

    // Setters
    public void setKodSaltzailea(int kodSaltzailea) {
        this.kodSaltzailea = kodSaltzailea;
    }
    public void setNan(String nan) {
        this.nan = nan;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public void setAbizena1(String abizena1) {
        this.abizena1 = abizena1;
    }
    public void setAbizena2(String abizena2) {
        this.abizena2 = abizena2;
    }
    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }
    public void setTelefonoa(String telefonoa) {
        this.telefonoa = telefonoa;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }
    public void setPostaKodea(String postaKodea) {
        this.postaKodea = postaKodea;
    }
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }
    public void setHerria(String herria) {
        this.herria = herria;
    }
}
