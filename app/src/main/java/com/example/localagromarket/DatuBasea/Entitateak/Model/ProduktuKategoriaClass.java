package com.example.localagromarket.DatuBasea.Entitateak.Model;

import com.example.localagromarket.DatuBasea.Entitateak.Model.KategoriaClass;
import com.example.localagromarket.DatuBasea.Entitateak.Model.ProduktuClass;

public class ProduktuKategoriaClass {
    private KategoriaClass kategoria = new KategoriaClass();
    private ProduktuClass produktua = new ProduktuClass();

    // Constructors
    public ProduktuKategoriaClass(KategoriaClass kategoria, ProduktuClass produktua) {
        this.kategoria = kategoria;
        this.produktua = produktua;
    }
    public ProduktuKategoriaClass(){}

    // Getters
    public KategoriaClass getKategoria() {
        return kategoria;
    }
    public ProduktuClass getProduktua() {
        return produktua;
    }

    // Setters
    public void setKategoria(KategoriaClass kategoria) {
        this.kategoria = kategoria;
    }
    public void setProduktua(ProduktuClass produktua) {
        this.produktua = produktua;
    }
}
