package com.bisoft12.cenforpg;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.bisoft12.cenforpg.StartGame;
import com.bisoft12.cenforpg.utils.Resources;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle(Resources.APP_TITLE);
		config.setWindowedMode(Resources.WIDTH, Resources.HEIGHT); //para la resolucion de la pantalla
		//config.setWindowIcon(Files.FileType.Internal, Resources.APP_LOGO);
		new Lwjgl3Application(Resources.MAIN, config);
	}
}
