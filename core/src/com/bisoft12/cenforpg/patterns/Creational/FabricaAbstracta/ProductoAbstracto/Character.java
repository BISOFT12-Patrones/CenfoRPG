package com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto;

public interface Character {


    String getTipeCharacter();

    int getLevel();

    String info_Character();

    boolean isKey();

    void setKey(boolean pKey);

    void setLevel();

    void setExperience(int experience);

    int getExperience();

    void setDefense(int defense);

    int getDefense();

    void setAttack(int attacK);

    int getAttack();

    void setCoin(int coin);

    int getCoin();


}
