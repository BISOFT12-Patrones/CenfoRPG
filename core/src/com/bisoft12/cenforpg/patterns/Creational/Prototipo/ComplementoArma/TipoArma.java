package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public abstract class TipoArma {
    private String nombre;
    private int precio;

    //CONSTRUCTOR
    public TipoArma(){

    }

    //GETS
    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    //SETS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
