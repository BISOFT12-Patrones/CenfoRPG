package com.bisoft12.cenforpg.patterns.Behavioral;

import com.bisoft12.cenforpg.patterns.Behavioral.Estado.abstracto.EstadoCasa;
import com.bisoft12.cenforpg.patterns.Behavioral.Estado.concreto.Est_Recuperar;
import com.bisoft12.cenforpg.patterns.Behavioral.Estado.objeto.Casa;

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

    public String Cambiar_Estado() {
        EstadoCasa estado=null;
        estado = new Est_Recuperar();
        objEstadoCasa.setEstado(estado);
        return Mostrar_Estado();
    }
    public String Mostrar_Estado() {
        return objEstadoCasa.mostrar();
    }


}//
