package baseDatos.Datos;

import java.util.Scanner;

public class Datos {

	static Scanner teclado = new Scanner(System.in);

	public static String usuario = "root";
	public static   String pass = "";
	public static  String bbdd = "BaseDatos";
	public static  String tabla = "persona";
	public static  String zonaHoraria = "?serverTimezone=UTC";
	public static int opcion;
	

	// datos URL
	public static String driver = "jdbc:mysql";
	public static String localHost = "localhost";
	public static String puerto = "3306";

	public static String URL = driver + "://" + localHost + ":" + puerto + "/" + bbdd + "?" + zonaHoraria;

	

}
