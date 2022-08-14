package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class RamaAfilada extends TipoArma{
    private int id;

    public RamaAfilada(){
        this.setNombre("Rama Afilada");
        this.setAtaque(0);
        this.setDefensa(0);
        this.setMagia(0);
        this.setPrecio(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
