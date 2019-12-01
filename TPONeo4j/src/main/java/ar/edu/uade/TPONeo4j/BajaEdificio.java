package ar.edu.uade.TPONeo4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BajaEdificio {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Nombre del Edificio que desea eliminar: ");
			String nombre = br.readLine();
			
			PreparedStatement stat = Conexion.getConexion().prepareStatement("MATCH (ed:Edificio {nombre:?})");
			stat.setString(1, nombre);
			stat.executeQuery();
			PreparedStatement stat2 = Conexion.getConexion().prepareStatement("DETACH DELETE (ed:Edificio)");
			stat2.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
