package com.bisoft12.cenforpg.patterns.Structural.Decorator.ConcreteDecorator;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;
import com.bisoft12.cenforpg.patterns.Structural.Decorator.Decorator.DecoratedPlayer;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import java.util.ArrayList;

public class armedCharacter extends DecoratedPlayer {

    private int addAttack = 15;
    private int addDefense = 15;

    public armedCharacter(Character pCharacter){
        this.cCharacter = pCharacter;
    }

    public armedCharacter(Character pCharacter, int pAttack, int pDefense){
        this.cCharacter = pCharacter;
        this.addAttack = pAttack;
        this.addDefense = pDefense;
    }

    @Override
    public String getTipeCharacter() {
        return this.cCharacter.getTipeCharacter();
    }

    @Override
    public int getLevel() {
       return this.cCharacter.getLevel();
    }

    @Override
    public String info_Character() {
        return this.cCharacter.info_Character();
    }

    @Override
    public boolean isKey() {
        return this.cCharacter.isKey();
    }

    @Override
    public void setKey(boolean pKey) {
        this.cCharacter.setKey(pKey);
    }

    @Override
    public void setLevel(int pDif) {
        this.cCharacter.setLevel(pDif);
    }

    @Override
    public void setExperience(int experience) {
        this.cCharacter.setExperience(experience);
    }

    @Override
    public int getExperience() {
        return this.cCharacter.getExperience();
    }

    @Override
    public void setDefense(int defense) {
         this.cCharacter.setDefense(defense);
    }

    @Override
    public int getDefense() {
        return this.cCharacter.getDefense() + addDefense;
    }

    @Override
    public void setAttack(int attacK) {
        this.cCharacter.setAttack(attacK);
    }

    @Override
    public int getAttack() {
       return this.cCharacter.getAttack() + addAttack;
    }

    @Override
    public void setCoin(int coin) {
        this.cCharacter.setCoin(coin);
    }

    @Override
    public int getCoin() {
       return this.cCharacter.getCoin();
    }

    @Override
    public ArrayList<Arma> getArmas() {
       return this.cCharacter.getArmas();
    }

    @Override
    public void setArma(Arma pArma) {
        this.cCharacter.setArma(pArma);
    }

    @Override
    public boolean isDungeon() {
        return this.cCharacter.isDungeon();
    }

    @Override
    public void setDungeon(boolean pDungeon) {
        this.cCharacter.setDungeon(pDungeon);
    }

    @Override
    public void setFight(boolean pFight) {
        this.cCharacter.setFight(pFight);
    }

    @Override
    public boolean isFight() {
        return this.cCharacter.isFight();
    }

    @Override
    public void setJefe(boolean pFeje) {
        this.cCharacter.setJefe(pFeje);
    }

    @Override
    public boolean isFeje() {
        return this.cCharacter.isFeje();
    }
}
