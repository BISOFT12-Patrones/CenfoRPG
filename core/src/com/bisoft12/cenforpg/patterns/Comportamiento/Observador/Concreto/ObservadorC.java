package com.bisoft12.cenforpg.patterns.Comportamiento.Observador.Concreto;

import com.bisoft12.cenforpg.patterns.Comportamiento.Observador.Interfaces.Observador;
import com.bisoft12.cenforpg.screen.FightScreen;
import com.bisoft12.cenforpg.utils.Resources;

public class ObservadorC implements Observador {
    private String gNombre;
    public ObservadorC(String pN) {
        gNombre=pN;
    }

    @Override
    public void irBatalla() {
        int random = (int) (Math.random() * 10);
        if (random > 3) {
            Resources.MAIN.setScreen(new FightScreen());
        }
    }
}
