package com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma.TipoArma;

public abstract class Arma {
    private int id;
    private String nombre;
    private TipoArma tipo;

    private String informacion;
    private int ataque;
    private int magia;

    private int defensa;

    public Arma() {

    }

    //GETS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoArma getTipo() {
        return tipo;
    }


    public String getInformacion() {
        return informacion;
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
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoArma tipo) {
        this.tipo = tipo;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
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

    public abstract Arma clone();
}
