package com.bisoft12.cenforpg.io;

import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;


public class Dialogs {
    private Images image;
    private Text text;



    public Dialogs() {
        this.image = new Images(Resources.DIALOGS_BACKGROUND);
        this.text = new Text();
    }

    public Images getImage() {
        return image;
    }

    public String getText() {
        return text.getText();
    }

    public void setImage(Images image) {
        this.image = image;
    }

    public void setText(String pText) {
        this.text.setText(pText);
    }

    public void draw() {
        this.image.draw();
        this.text.drawWrapped();
    }

    public void setCoordinates() {
        this.image.setCoordinates(0, 0);
        this.text.setCoordinates(20, 125);
    }


    public String getCoordinates() {
        return this.image.getX() + "\n" + this.image.getY();
    }

    public void dispose() {
        this.text.setText("");
        this.image.dispose();
    }
}
