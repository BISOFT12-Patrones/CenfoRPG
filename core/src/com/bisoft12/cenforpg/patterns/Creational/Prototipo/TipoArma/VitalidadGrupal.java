package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class VitalidadGrupal extends TipoArma {
    private int id;

    public VitalidadGrupal() {
        this.setNombre("Vitalidad Grupal");
        this.setAtaque(0);
        this.setDefensa(40);
        this.setMagia(60);
        this.setPrecio(350);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
