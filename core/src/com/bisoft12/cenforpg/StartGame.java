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

		Resources.MAIN.setScreen(new CityScreen());
		//Resources.MAIN.setScreen(new CreateCharacterScreen());
		// 3 Resources.MAIN.setScreen(new DungeonScreen());
		// 4 Resources.MAIN.setScreen(new FightScreen());
		// 5 Resources.MAIN.setScreen(new LoadScreen());
		 //Resources.MAIN.setScreen(new LoreScreen());
		 // Resources.MAIN.setScreen(new MenuScreen())
		 // 8 Resources.MAIN.setScreen(new MerchantScreen());
		// 9 Resources.MAIN.setScreen(new TerrainMonster());
		// 10 Resources.MAIN.setScreen(new TownScreen());
		// 11 Resources.MAIN.setScreen(new HouseScreen()); //VALIDAR FUNCION
	;




	}




}//End of class
