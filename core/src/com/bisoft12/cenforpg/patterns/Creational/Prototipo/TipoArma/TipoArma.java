package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public abstract class TipoArma {
    private String nombre;
    private int precio;
    private int ataque;
    private int magia;
    private int defensa;

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

    public int getAtaque() {
        return ataque;
    }

    public int getMagia() {
        return magia;
    }

    public int getDefensa() {
        return defensa;
    }

    //SETS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}
