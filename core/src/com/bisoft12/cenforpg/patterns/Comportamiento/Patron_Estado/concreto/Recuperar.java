package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto;
import com.badlogic.gdx.utils.Timer;
import com.bisoft12.cenforpg.patterns.Comportamiento.Main.Gestor_Estado;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.abstracto.Estado;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.objeto.Casa;
import static java.lang.System.out;

public class Recuperar extends Estado {
    private Gestor_Estado gEstado = new Gestor_Estado();

    @Override
    public String activarEstado() {
        for (int contk = 10; contk >= 0; contk--) {
            out.println("Recuperando vidas");
        }
            out.println("Tiempo de Pelear!");
            gEstado.Cambiar_Estado(2);
        return "Pelear";
    }



}//
