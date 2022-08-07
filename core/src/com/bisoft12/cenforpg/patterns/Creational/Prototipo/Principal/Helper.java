package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Principal;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma.*;

public class Helper {
    public static TipoArma definirArma(int pNum) {
        TipoArma tipoArma = null;
        switch (pNum) {
            case 1:
                tipoArma = new Armadura();
                break;
            case 2:
                tipoArma = new DobleFlecha();
                break;
            case 3:
                tipoArma = new DobleMano();
                break;
            case 4:
                tipoArma = new EspadaHierro();
                break;
            case 5:
                tipoArma = new EspadaPlata();
                break;
            case 6:
                tipoArma = new FlechaBomba();
                break;
            case 7:
                tipoArma = new FlechaSimple();
                break;
            case 8:
                tipoArma = new HachaHierro();
                break;
            case 9:
                tipoArma = new HachaPlata();
                break;
            case 10:
                tipoArma = new Joyeria();
                break;
            case 11:
                tipoArma = new Magica();
                break;
            case 12:
                tipoArma = new TripleFlecha();
                break;
            default:
                break;
        }
        return tipoArma;
    }

}
