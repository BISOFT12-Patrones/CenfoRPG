package com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoConcreto;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

import java.util.ArrayList;


public class Arquero implements Character {


    private static int level;//experiencia /100
    private static int experience;
    private static int defense;
    private static int attack;
    private static boolean key;
    private static int coin;
    private static boolean dungeon = false;

    private static final String tipeCharacter = "Arquero";

    private static ArrayList<Arma> armas = new ArrayList<Arma>();

    public Arquero() {
    }

    public void setLevel() {
        this.level++;
        this.setAttack(50);
        this.setDefense(100);
    }

    public int getLevel() {
        return level;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setDefense(int defense) {
        this.defense += defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setAttack(int attacK) {
        this.attack += attacK;
    }

    public int getAttack() {
        return attack;
    }

    public void setCoin(int coin) {
        this.coin += coin;
    }

    public int getCoin() {
        return coin;
    }

    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void setArma(Arma pArma) {
        armas.add(pArma);
    }

    public boolean isDungeon() {
        return dungeon;
    }

    public void setDungeon(boolean pDungeon) {
        dungeon = pDungeon;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public String getTipeCharacter() {
        return "Arquero";
    }


    public String info_Character() {
        return "Tipe of Character is: " + this.getTipeCharacter() + ", This Level is : " + this.getLevel() + ", This experience is : " + this.getExperience()
                + ", This defense is : " + this.getDefense() + ", This attack is : " + this.getAttack() + ", This coin is : " + this.getCoin();

    }


}
