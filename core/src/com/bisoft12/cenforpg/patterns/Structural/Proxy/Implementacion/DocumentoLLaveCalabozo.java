package com.bisoft12.cenforpg.patterns.Structural.Proxy.Implementacion;

import com.bisoft12.cenforpg.patterns.Structural.Proxy.Interface.ILLaveCalabozo;
import com.bisoft12.cenforpg.screen.DungeonScreen;
import com.bisoft12.cenforpg.utils.Resources;

public class DocumentoLLaveCalabozo implements ILLaveCalabozo {

    @Override
    public void acceder(boolean pLlave) {
        //Si llega a este punto es que si tiene la llave para acceder al calabozo
        Resources.MAIN.setScreen(new DungeonScreen());
    }
}
