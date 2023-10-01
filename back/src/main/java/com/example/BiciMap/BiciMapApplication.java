package com.example.BiciMap;

import menus.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BiciMapApplication {

	/*public static void main(String[] args) {
		SpringApplication.run(BiciMapApplication.class, args);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(BiciMapApplication.class, args);


		Scanner scanner = new Scanner(System.in);
		String titulo = "*****************************************************************\n"+
				"                               ,o\n" +
				"                           __ <<<<__\n" +
				"                          (_)       (_)  ";

		// Imprimir el título

		// Imprimir el título
		System.out.println(titulo);

		System.out.println("Bienvenidos a BiciMap. Por favor, elige una de nuestras opciones:");
		System.out.println("1. Rutas Favoritas");
		System.out.println("2. Historial de Rutas");
		System.out.println("3. Usuarios");
		System.out.println("4. Rutas");
		System.out.println("5. Salir");

		int opcion = scanner.nextInt();

		switch (opcion) {
			case 1:

				FavoritosMenu.main(args);
				break;
			case 2:

				HistorialMenu.main(args);
				break;
			case 3:

				MenuPilaUsuarios.main(args);
				break;

			case 4:

				mainNodePointMenu.main(args);

				break;
			case 5:
				System.out.println("Gracias por usar BiciMap. ¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, elige una opción válida.");
				break;
		}
	}


}
