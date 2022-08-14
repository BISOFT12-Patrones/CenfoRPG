package com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaMago;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaArquero;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaCaballero;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoConcreto.Arquero;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoConcreto.Mago;

public class FabricaCharacter {

    private static Character arCharacter;

    public FabricaCharacter() {
        processFuntion(2);
    }

    public static String CreateFabricaCharacter(GameCharacter pFabrica) {
        Character objCharacter = pFabrica.createCharacter();
        arCharacter = objCharacter;
        return objCharacter.info_Character();
    }


    public static String get_information_Character() {
        String msDatos = "";

        msDatos = msDatos + arCharacter.info_Character() + "\n";

        /*for(int i = 0; i < arCharacter.size(); ++i) {
            msDatos = msDatos + ((Character)arCharacter.get(i)).info_Character() + "\n";
        }*/

        return msDatos;
    }

    public Character getCharacter() {
        return arCharacter;
    }

    public static String processFuntion(int pOpc) {
        String sMessage = "";
        switch (pOpc) {
            case 1:
                GameCharacter tiChara = new FabricaArquero();
                sMessage = CreateFabricaCharacter(tiChara);
                break;
            case 2:
                GameCharacter tiChara1 = new FabricaCaballero();
                sMessage = CreateFabricaCharacter(tiChara1);
                break;
            case 3:
                GameCharacter tiChara2 = new FabricaMago();
                sMessage = CreateFabricaCharacter(tiChara2);
                break;
            case 4:
                sMessage = get_information_Character();
                break;
            case 5:
                sMessage = "Thank you for using the software";
                break;
            default:
                sMessage = "Invalid option";
        }

        return sMessage;
    }


}
