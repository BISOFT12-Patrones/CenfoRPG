package com.bisoft12.cenforpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bisoft12.cenforpg.screen.HouseScreen;
import com.bisoft12.cenforpg.screen.MenuScreen;
import com.bisoft12.cenforpg.screen.MerchantScreen;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class StartGame extends Game {
 	@Override
	public void create() {
		Render._Batch = new SpriteBatch();
		//Resources.MAIN.setScreen(new CityScreen());
		Resources.MAIN.setScreen(new MenuScreen());
		//Resources.MAIN.setScreen(new MerchantScreen());
	}
}//End of class
