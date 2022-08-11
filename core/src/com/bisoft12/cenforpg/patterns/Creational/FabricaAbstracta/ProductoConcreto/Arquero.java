package com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoConcreto;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

import java.util.ArrayList;


public class Arquero implements Character {


    private int level;//experiencia /100
    private int experience;
    private int defense;
    private int attack;
    private boolean key;
    private int coin;

    private static final String tipeCharacter = "Arquero";

    public Arquero() {
    }

    public void setLevel() {
        this.level++;
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