package com.bisoft12.cenforpg.patterns.Structural.Proxy.Implementacion;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Structural.Proxy.Interface.ILLaveCalabozo;

public class DocumentoProxyLlaveCalabozo implements ILLaveCalabozo {
    private DocumentoLLaveCalabozo doc = new DocumentoLLaveCalabozo();
    private boolean apertura;

    @Override
    public boolean acceder(Character player) {
        if (player.isKey()) {
            this.apertura = true;
            this.doc.acceder(player);
        } else {
            this.apertura = false;
        }
        return apertura;
    }
}
