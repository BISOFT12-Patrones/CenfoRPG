package com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

import java.util.ArrayList;

public interface Character {


    String getTipeCharacter();

    int getLevel();

    String info_Character();

    boolean isKey();

    void setKey(boolean pKey);

    void setLevel(int pDif);

    void setExperience(int experience);

    int getExperience();

    void setDefense(int defense);

    int getDefense();

    void setAttack(int attacK);

    int getAttack();

    void setCoin(int coin);

    int getCoin();

    ArrayList<Arma> getArmas();

    void setArma(Arma pArma);

    boolean isDungeon();

    void setDungeon(boolean pDungeon);

    void setFight(boolean pFight);

    boolean isFight();

    void setJefe(boolean pFeje);

    boolean isFeje();
}
