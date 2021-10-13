package baseDatos.OpcionMenu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import baseDatos.Conexion.Conexion;
import baseDatos.Datos.Datos;
import baseDatos.Persona.Persona;

public class OpcionMenu {

	static Scanner sc = new Scanner(System.in);

	static int opcion = Datos.opcion;

	public static void insertar() {

		Connection con = null;

		System.out.println("Agregar nuevo registro VALUES (id, nombre, fechaNAcimiento): ");

		System.out.println("Inserte Nombre ");
		String nombre = sc.nextLine();

		System.out.println("Inserte FechaNacimiento yyyy-mm-dd");
		String FechaNacimiento = sc.nextLine();

		System.out.println("Inserte id ");
		int id = sc.nextInt();

		try {
			con = Conexion.conexion();

			Statement miStmt = con.createStatement();
			String instruccionSQL = "INSERT INTO " + Datos.tabla + " VALUES (" + id + ", '" + nombre + "', '"
					+ FechaNacimiento + "')";

			System.out.println(instruccionSQL);

			miStmt.executeUpdate(instruccionSQL);

			System.out.println("NUEVOS DATOS AÑADIDOS CORRECTAMENTE"); // mensaje

			con.close();
			miStmt.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void listar() {

		// inicializar las variables
		Connection con = null;

		Statement stm = null;

		ResultSet rs = null;

		List<Persona> listaPersona = new ArrayList<Persona>();

		try {

			con = Conexion.conexion(); // llamo al metodo conexion y conecta con la bbdd

			stm = con.createStatement();
			rs = stm.executeQuery("select * from  persona");

			// recorrer la lista y crear un objeto persona

			while (rs.next()) {
				Persona p = new Persona();

				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setFechaNacimiento(rs.getDate(3).toLocalDate()); // para pasarlo a local date

				listaPersona.add(p);
			}

			for (Persona persona : listaPersona) {
				System.out.println(persona.toString());
			}

			con.close();
			stm.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void eliminar() {
		Connection con = null;

		Statement stm = null;

		try {

			con = Conexion.conexion();
			stm = con.createStatement();

			System.out.print("Introduzca el codigo del  id a eliminar (DELETE): ");
			int insert = sc.nextInt();

			String instruccionSQL = "DELETE FROM " + Datos.tabla + " WHERE ID =  " + insert;
			System.out.println(instruccionSQL);

			System.out.println("REGISTRO ELIMINADO CORRECTAMENTE DE LA TABLA "); // mensaje

			stm.executeUpdate(instruccionSQL);

			con.close();
			stm.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void modificar () {
		
		Connection con = null;
		Statement stm = null;
		
		try {
			
			con = Conexion.conexion();
			stm = con.createStatement();

			System.out.println("Introduce el ID de la persona que quieres modificar ");
			int id = sc.nextInt();
			
			System.out.println("cual es su nueva fecha de nacimiento  yyyy-mm-dd");
			String fechaNacimiento = sc.next();
			
			System.out.println("Cual es su nuevo nombre");
			String nombre= sc.next();
			
		
	
			
			String instruccionSQL = "UPDATE `persona` SET `nombre`='"+nombre+"',`fechaNacimiento`='"+fechaNacimiento+"' WHERE id='"+id+"'";

			System.out.println(instruccionSQL);

			System.out.println("DATOS MODIFICADOS CORRECTAMENTE"); // mensaje

			stm.executeUpdate(instruccionSQL);

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		
		
		
	}

}
