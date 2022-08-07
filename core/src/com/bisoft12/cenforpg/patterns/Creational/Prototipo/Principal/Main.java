package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Principal;

public class Main {
    private static GestorPrototipo gGestor;

    public static void main(String[] args) {
        gGestor = new GestorPrototipo(100, 200, 300, 400);
        gGestor.nuevaArma(1);
        gGestor.nuevaArma(2);
        gGestor.nuevaArma(3);
        gGestor.nuevaArma(4);
        System.out.println(gGestor.obtenerDatos());
    }
}
