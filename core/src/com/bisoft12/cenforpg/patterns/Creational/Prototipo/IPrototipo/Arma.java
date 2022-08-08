package com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma.TipoArma;

public abstract class Arma {
    private int id;
    private String nombre;
    private TipoArma tipo;
    private String informacion;
    private int dano;

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

    public int getDano() {
        return dano;
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

    public void setDano(int dano) {
        this.dano = dano;
    }

    public abstract Arma clone();
}
