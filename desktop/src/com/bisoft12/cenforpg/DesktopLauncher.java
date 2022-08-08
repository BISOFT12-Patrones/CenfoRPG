package com.bisoft12.cenforpg;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.bisoft12.cenforpg.patterns.Creational.Gestor.FabricaCharacter;
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
		new Lwjgl3Application(new StartGame(), config);
	}
}// End of Main



	/* MAIN Consola para verificar Creacion de Personaje
	static {
		scan = new Scanner(System.in);
	}

	public static void main (String[] arg) {
		int iOpc = 0;
		do {
			iOpc = mostrarMenu();
			System.out.print(FabricaCharacter.processFuntion(iOpc));
		} while (iOpc !=5 );
	}
	private static int mostrarMenu() {
		String cad="";
		cad=cad+"\n";
		cad=cad+"Ingrese la opcion correspondiente: \n";
		cad=cad+"1. Crear un Arquero \n";
		cad=cad+"2. Crear un nuevo Caballero\n";
		cad=cad+"3. Crear un nuevo Mago\n";
		cad=cad+"4. Imprimir Codigos existentes\n";
		cad=cad+"5. Salir \n";
		cad=cad+"\n";
		System.out.println(cad);
		return scan.nextInt();
	} */



