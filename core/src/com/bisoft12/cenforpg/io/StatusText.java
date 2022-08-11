package com.bisoft12.cenforpg.io;

import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.utils.Resources;

public class StatusText{
    private Text text;

    public StatusText() {
        this.text = new Text(Resources.DIALOGS_FONT);
        this.text.setCoordinates(600, 595);
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String pText) {
        this.text.setText(pText);
    }

    public void draw() {
        this.text.setText("Level: " + Integer.toString(Player.getLEVEL()) + "   HP: " + Integer.toString(Player.getHP()) + "   EXP:" + Integer.toString(Player.getEXP()));
        this.text.drawWrapped();
    }
}
