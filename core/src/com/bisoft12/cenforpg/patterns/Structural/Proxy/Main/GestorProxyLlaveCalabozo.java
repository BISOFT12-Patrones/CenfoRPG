package com.bisoft12.cenforpg.patterns.Structural.Proxy.Main;

import com.bisoft12.cenforpg.patterns.Structural.Proxy.Implementacion.DocumentoProxyLlaveCalabozo;
import com.bisoft12.cenforpg.patterns.Structural.Proxy.Interface.ILLaveCalabozo;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

public class GestorProxyLlaveCalabozo {
    ILLaveCalabozo Illave = new DocumentoProxyLlaveCalabozo();


    public boolean dungeonAcces(Character player){

    return Illave.acceder(player);
    }

}
