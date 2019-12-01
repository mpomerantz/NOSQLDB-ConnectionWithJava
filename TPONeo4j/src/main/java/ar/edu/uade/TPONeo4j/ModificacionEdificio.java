package ar.edu.uade.TPONeo4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificacionEdificio {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Nombre del Edificio que desea editar: ");
			String nombre = br.readLine();
			System.out.println("Nueva direccion: ");
			String direccion = br.readLine();
			
			PreparedStatement stat = Conexion.getConexion().prepareStatement("MATCH (ed:Edificio {nombre:?})");
			stat.setString(1, nombre);
			stat.executeQuery();
			PreparedStatement stat2 = Conexion.getConexion().prepareStatement("SET ed:Edificio = {direccion:?})");
			stat2.setString(1, direccion);
			stat2.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
