package com.bisoft12.cenforpg.patterns.Creational.MetodoFab.creador_concreto;

import com.bisoft12.cenforpg.patterns.Creational.MetodoFab.creador.MetodoFab_Pocion;
import com.bisoft12.cenforpg.patterns.Creational.MetodoFab.producto.Pocion;
import com.bisoft12.cenforpg.patterns.Creational.MetodoFab.producto_concreto.Pocion_LanzaLlamas;
import com.bisoft12.cenforpg.patterns.Creational.MetodoFab.producto_concreto.Pocion_Recuperativa;
import com.bisoft12.cenforpg.patterns.Creational.MetodoFab.producto_concreto.Pocion_SoploHielo;
import com.bisoft12.cenforpg.patterns.Creational.MetodoFab.producto_concreto.Pocion_VitalidadGrupal;

public class Fab_Pociones implements MetodoFab_Pocion {
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
