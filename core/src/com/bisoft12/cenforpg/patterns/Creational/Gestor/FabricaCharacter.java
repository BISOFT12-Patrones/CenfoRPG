package com.bisoft12.cenforpg.patterns.Creational.Gestor;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaConcreta.FabricaArquero;
import com.bisoft12.cenforpg.patterns.Creational.FabricaConcreta.FabricaCaballero;
import com.bisoft12.cenforpg.patterns.Creational.FabricaConcreta.FabricaMago;
import com.bisoft12.cenforpg.patterns.Creational.ProductoAbstracto.Character;

import java.util.ArrayList;

public class FabricaCharacter {

    private static ArrayList<Character> arCharacter = new ArrayList();

    public FabricaCharacter(){

    }

    public static String CreateFabricaCharacter(GameCharacter pFabrica) {
        Character objCharacter = pFabrica.createCharacter();
        add_character(objCharacter);
        return objCharacter.info_Character();
    }

    private static void add_character(Character pObjCharacter ){arCharacter.add(pObjCharacter);}


    public static String get_information_Character() {
        String msDatos = "";

        for(int i = 0; i < arCharacter.size(); ++i) {
            msDatos = msDatos + ((Character)arCharacter.get(i)).info_Character() + "\n";
        }

        return msDatos;
    }

    public static String processFuntion(int pOpc) {
        String sMessage = "";
        switch(pOpc) {
            case 1:
                GameCharacter tiChara = new FabricaArquero();
                sMessage = CreateFabricaCharacter(tiChara);
                break;
            case 2:
                GameCharacter tiChara1 = new FabricaCaballero();
                sMessage=CreateFabricaCharacter(tiChara1);
                break;
            case 3:
                GameCharacter tiChara2 = new FabricaMago();
                sMessage = CreateFabricaCharacter(tiChara2);
                break;
            case 4:
                sMessage = get_information_Character();
                break;
            case 5:
                sMessage= "Thank you for using the software";
                break;
            default:
                sMessage = "Invalid option";
        }

        return sMessage;
    }




}
