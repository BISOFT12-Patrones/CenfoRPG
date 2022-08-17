package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Observador.Concreto;

import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Observador.Interfaces.Observador;
import com.bisoft12.cenforpg.screen.FightScreen;
import com.bisoft12.cenforpg.utils.Resources;

public class ObservadorC implements Observador {
    private String gNombre;

    public ObservadorC(String pN) {
        gNombre = pN;
    }

    @Override
    public void irBatalla() {
        Resources.MAIN.setScreen(new FightScreen());
    }
}
