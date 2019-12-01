package ar.edu.uade.TPONeo4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AltaEdificio {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Nombre del Edificio: ");
			String nombre = br.readLine();
			System.out.println("Dirección del Edificio: ");
			String direccion = br.readLine();
			
			PreparedStatement stat = Conexion.getConexion().prepareStatement("CREATE (ed:Edificio {nombre:?, direccion:?})");
			stat.setString(1, nombre);
			stat.setString(2, direccion);
			stat.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

