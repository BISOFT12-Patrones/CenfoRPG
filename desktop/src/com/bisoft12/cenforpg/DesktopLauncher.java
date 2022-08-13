package com.bisoft12.cenforpg;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.bisoft12.cenforpg.utils.Resources;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle(Resources.APP_TITLE);
		config.setWindowIcon(Files.FileType.Internal,"icons/icon_game.png");
		config.setTitle("Orden Del Tiempo");
		config.setResizable(false);
		config.setWindowedMode(Resources.WIDTH, Resources.HEIGHT);
		new Lwjgl3Application(Resources.MAIN, config);
		//new Lwjgl3Application(new StartGame(), config);
	}
}// End of Main





