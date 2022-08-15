package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class RamaAfilada extends TipoArma{
    private int id;

    public RamaAfilada(){
        this.setNombre("Rama Afilada");
        this.setAtaque(60);
        this.setDefensa(25);
        this.setMagia(35);
        this.setPrecio(150);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
