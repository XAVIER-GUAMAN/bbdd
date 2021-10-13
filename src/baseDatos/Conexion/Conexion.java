package baseDatos.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import baseDatos.Datos.Datos;

public class Conexion {

	// Datos para la conexion con la Base de Datos

	public static Connection conexion() {

		String URL = "jdbc:mysql://localhost:3306/BaseDatos?serverTimezone=UTC";
		//String URL= Constantes.URL;
		Connection miConexion = null;

		try {

			miConexion = DriverManager.getConnection(URL,Datos.usuario, Datos.pass);
			if (miConexion != null) {
				System.out.println("Conectado correctamente");

			}

		} catch (Exception e) {

			System.out.println("NO CONECTA"); // MENSAJE DE ERROR
			e.printStackTrace();

		}

		return miConexion;
	}

}
