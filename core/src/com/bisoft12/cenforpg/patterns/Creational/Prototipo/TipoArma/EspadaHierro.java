package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class EspadaHierro extends TipoArma{
    private int id;

    public EspadaHierro(){
        this.setNombre("Espada de Hierro");
        this.setAtaque(15);
        this.setMagia(0);
        this.setDefensa(5);
        this.setPrecio(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
