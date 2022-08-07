package com.bisoft12.cenforpg.patterns.Structural.Proxy.Main;

import com.bisoft12.cenforpg.patterns.Structural.Proxy.Implementacion.DocumentoProxyLlaveCalabozo;
import com.bisoft12.cenforpg.patterns.Structural.Proxy.Interface.ILLaveCalabozo;

public class GestorProxyLlaveCalabozo {
    ILLaveCalabozo Illave = new DocumentoProxyLlaveCalabozo();

    /*public void dungeonAcces(MainPlayer player){
        Illave.acceder(player.isLlave);
    }*/

}
