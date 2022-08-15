package com.bisoft12.cenforpg.patterns.Structural.Proxy.Implementacion;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Structural.Proxy.Interface.ILLaveCalabozo;
import com.bisoft12.cenforpg.utils.Resources;

public class DocumentoProxyLlaveCalabozo implements ILLaveCalabozo {
    private DocumentoLLaveCalabozo doc = new DocumentoLLaveCalabozo();
    private boolean apertura;

    @Override
    public boolean acceder(Character player) {
        if (player.isKey()) {
            this.apertura = true;
            this.doc.acceder(player);
        } else {
            Resources.dialog = "No posees la llave para entrar";
            this.apertura = false;
        }
        return apertura;
    }
}
