package baseDatos.Menu;

import java.util.Scanner;

import baseDatos.Datos.Datos;
import baseDatos.Datos.Datos;
import baseDatos.OpcionMenu.OpcionMenu;

public class Opcion {

	static Scanner sc = new Scanner(System.in);
	
	public static void opcionMenu() {
		System.out.println("Menu:");
		System.out.println("1. Insertar");
		System.out.println("2. Modificar/actualizar");
		System.out.println("3. Eliminar");
		System.out.println("4. Listar");
		System.out.println("5. Salir");
		
		System.out.println();
		System.out.println("Elija una opcion: ");
		int opcionMenu = sc.nextInt();
		
		Datos.opcion= opcionMenu;
		
		//menu
		switch (opcionMenu) {
		case 1: 
			OpcionMenu.insertar();
			break;
			
		case 2: 
			OpcionMenu.modificar();
			break;
			
		case 3: 
			OpcionMenu.eliminar();
			break;
			
			
		case 4: 
			OpcionMenu.listar();
			break;
			
		case 5: 
			System.out.println("Ha salida de la BBDD");
			break;
			
			
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcionMenu);
		}
		
	}
}
