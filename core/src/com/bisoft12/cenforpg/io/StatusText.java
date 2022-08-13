package com.bisoft12.cenforpg.io;

import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.utils.Resources;

public class StatusText{
    private Text text;
    private FabricaCharacter gestor = new FabricaCharacter();

    public StatusText() {
        this.text = new Text(Resources.PLAYER_HEALTH_FONT);
        this.text.setCoordinates(600, 595);
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String pText) {
        this.text.setText(pText);
    }

    public void draw() {
        this.text.setText("Level: " + Integer.toString(gestor.getCharacter().getLevel()) + "   Coin: " + Integer.toString(gestor.getCharacter().getCoin()) + "   Attack:" + Integer.toString(gestor.getCharacter().getAttack()));
        this.text.drawWrapped();
    }
}
