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
    private static boolean fight = false;
    private static boolean jefe = false;

    private static final String tipeCharacter = "Arquero";

    private static ArrayList<Arma> armas = new ArrayList<Arma>();

    public Arquero() {
    }

    public void setLevel(int dif) {
        this.level = dif;
        this.setAttack(55 * dif);
        this.setDefense(60 * dif);
    }

    public void setExperience(int experience) {
        this.experience += experience;
        int dif = this.experience / 100;
        if (dif > getLevel()) {
            setLevel(dif);
        }
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setAttack(int attacK) {
        this.attack = attacK;
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

    public void setFight(boolean pFight) {
        this.fight = pFight;
    }

    public boolean isFight() {
        return this.fight;
    }

    public void setJefe(boolean pJefe) {
        this.jefe = pJefe;
    }

    public boolean isFeje() {
        return this.jefe;
    }

    public String info_Character() {
        return "Tipe of Character is: " + this.getTipeCharacter() + ", This Level is : " + this.getLevel() + ", This experience is : " + this.getExperience()
                + ", This defense is : " + this.getDefense() + ", This attack is : " + this.getAttack() + ", This coin is : " + this.getCoin();

    }


}
