package com.bisoft12.cenforpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bisoft12.cenforpg.screen.*;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class StartGame extends Game {

    @Override
    public void create() {
        Render.Batch = new SpriteBatch();

        Resources.MAIN.setScreen(new MenuScreen());
    }


}//End of class
