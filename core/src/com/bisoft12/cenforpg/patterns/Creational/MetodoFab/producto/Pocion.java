package com.bisoft12.cenforpg.patterns.Creational.MetodoFab.producto;

public abstract class Pocion {
    private int id;
    private String nombre;

 public Pocion (int id,String nombre) {
     setId (id);
     setNombre(nombre);
}

public Pocion() {
    setId (0);
    setNombre("Pocion");
}

 /********************* SECCION: GETS ************************/
 public int getId () {
        return id;
    }
 public String getNombre() {
        return nombre;
    }

/********************* SECCION: SETS ************************/
public void setId (int id) {
    this.id = id;
}
public void setNombre(String nombre) {
        this.nombre = nombre;
    }

/********************SECCION: ABSTRACTAS *********************/


}//
