package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto;
import com.badlogic.gdx.utils.Timer;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.abstracto.Estado;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.objeto.Casa;

import java.sql.Time;

public class Recuperar extends Estado {

    private Casa casa;
    @Override
    public String activarEstado() {
        return "Recuperando vidas. \n" + detenerJuego();
    }
    private String detenerJuego() {
        this.casa = casa;

        Timer timer = new Timer();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                Recuperar.this.casa.setEstado(new Pelear());
            }
        }, 5000);

        return ("Necesitas recuperarte antes de pelear");
    }

}//
