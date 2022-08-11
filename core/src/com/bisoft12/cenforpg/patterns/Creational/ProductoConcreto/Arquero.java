package com.bisoft12.cenforpg.patterns.Creational.ProductoConcreto;

import com.bisoft12.cenforpg.patterns.Creational.ProductoAbstracto.Character;



public class Arquero implements Character {


    private int level;//experiencia /100
    private int experience;
    private int defense;
    private int attack;
    private boolean key;
    private int coin;

    private static final String tipeCharacter= "Arquero";
    public Arquero(){
    }

    public void setLevel(int level){this.level =0;}
    public int getLevel() {return level;}
    public void setExperience(int experience){this.experience =0;}
    public int getExperience() {return experience;}
    public void setDefense(int defense){this.defense =0;}
    public int getDefense() {return defense;}
    public void setAttack(int attacK){this.attack =0;}
    public int getAttack() {return attack;}
    public void setCoin(int coin){this.coin =0;}
    public int getCoin() {return coin;}


    public String getTipeCharacter(){return "Arquero";}


    public String info_Character() {
        return "Tipe of Character is: " + this.getTipeCharacter() + ", This Level is : " + this.getLevel() + ", This experience is : " + this.getExperience()
                + ", This defense is : " + this.getDefense() + ", This attack is : " + this.getAttack()+ ", This coin is : " + this.getCoin() ;

    }



}
