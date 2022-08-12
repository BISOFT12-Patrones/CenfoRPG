package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Principal;

public class Main {
    private static GestorPrototipo gGestor;

    public static void main(String[] args) {
        gGestor = new GestorPrototipo(100, 200, 300, 400);
        gGestor.nuevaArma(0);
        gGestor.nuevaArma(1);
        gGestor.nuevaArma(2);
        System.out.println(gGestor.obtenerDatos());
    }
}
