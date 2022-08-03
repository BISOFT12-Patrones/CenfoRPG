package com.bisoft12.cenforpg.patterns.Structural.Proxy.Implementacion;

import com.bisoft12.cenforpg.patterns.Structural.Proxy.Interface.ILLaveCalabozo;

public class DocumentoProxyLlaveCalabozo implements ILLaveCalabozo {
    private DocumentoLLaveCalabozo doc = new DocumentoLLaveCalabozo();
    private boolean apertura;

    @Override
    public void acceder(boolean pLlave) {
        if (pLlave) {
            this.apertura = true;
            this.doc.acceder(pLlave);
        } else {
            this.apertura = false;
        }
    }
}
