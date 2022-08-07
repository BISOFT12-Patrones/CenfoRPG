package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class LluviaDeFlechas extends TipoArma {
    private int id;

    public LluviaDeFlechas() {
        this.setNombre("Lluvia de flechas");
        this.setPrecio(600);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
