package baseDatos.Main;

import baseDatos.Conexion.Conexion;
import baseDatos.Datos.Datos;
import baseDatos.Menu.Opcion;
import baseDatos.OpcionMenu.OpcionMenu;

public class Principal {

	public static void main(String[] args) {

		Conexion.conexion();
		Opcion.opcionMenu();
		
		
		

	}

}
