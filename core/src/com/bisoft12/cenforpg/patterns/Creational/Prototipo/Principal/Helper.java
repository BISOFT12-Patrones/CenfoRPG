package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Principal;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma.*;

public class Helper {

    static int randomizer() {
        return (int) (Math.random() * 12.0) + 1;
    }

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
            case 13:
                tipoArma = new Recuperacion5();
                break;
            case 14:
                tipoArma = new SoploHielo();
                break;
            case 15:
                tipoArma = new Lanzallamas();
                break;
            case 16:
                tipoArma = new RamaAfilada();
                break;
            case 17:
                tipoArma = new Ciclon();
                break;
            case 18:
                tipoArma = new ClaridadMental();
                break;
            case 19:
                tipoArma = new Recuperacion20();
                break;
            case 20:
                tipoArma = new VitalidadGrupal();
                break;
            case 21:
                tipoArma = new BombaDeHielo();
                break;
            case 22:
                tipoArma = new Fundir();
                break;
            case 23:
                tipoArma = new GolpeMental();
                break;
            case 24:
                tipoArma = new PazMental();
                break;
            default:
                break;
        }
        return tipoArma;
    }

}
