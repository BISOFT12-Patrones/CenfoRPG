package com.bisoft12.cenforpg.patterns.Comportamiento.Main;

import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.abstracto.Estado;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto.Pelear;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto.Recuperar;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.objeto.Casa;

/************************************************************
 * Patrón: Estado
 * Función: pasar al personaje al estado Recuperacion una vez que pierde
 * Participantes:
 * Contexto (EstadoCasa)
 * Estado (Casa)
 * Estado Concreto (Est_Recuperar)
 * Gestor (Gestor_Estado)
 ************************************************************/

public class Gestor_Estado {
    private Casa objEstadoCasa ;

    public Gestor_Estado() {
        objEstadoCasa = new Casa();
    }

    public String Cambiar_Estado(int pID) {
        Estado estado=null;
        switch (pID) {
            case 1:
                estado = new Recuperar();
                break;
            case 2:
                estado = new Pelear();
                break;
        }
        objEstadoCasa.setEstado(estado);
        return Mostrar_Estado();
    }
    public String Mostrar_Estado() {
        return objEstadoCasa.activarEstado();
    }


}//
