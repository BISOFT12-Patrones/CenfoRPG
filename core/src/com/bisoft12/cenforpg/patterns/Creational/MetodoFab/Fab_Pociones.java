package com.bisoft12.cenforpg.patterns.Creational.MetodoFab;

public class Fab_Pociones implements MetodoFab_Pocion{
    @Override
    public Pocion crearPocion(int pTipo) {
        if (pTipo == 1)
            return new Pocion_LanzaLlamas();
        else if (pTipo == 2)
            return new Pocion_SoploHielo();
        else if (pTipo == 3)
            return new Pocion_Recuperativa();
        else
            return new Pocion_VitalidadGrupal();
    }

}//
