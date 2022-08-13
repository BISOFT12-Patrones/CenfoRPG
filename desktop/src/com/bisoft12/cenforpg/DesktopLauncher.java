package com.bisoft12.cenforpg;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.bisoft12.cenforpg.patterns.Creational.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.Scanner;

public class DesktopLauncher {
	private static Scanner scan;

	static {
		scan = new Scanner(System.in);
	}


	//public static void main (String[] arg) {


	//	int iOpc = 0;

	//	do {
	//		iOpc = mostrarMenu();
	//		System.out.print(FabricaCharacter.processFuntion(iOpc));
	//	} while (iOpc !=5 );


	//}

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
	}

}
