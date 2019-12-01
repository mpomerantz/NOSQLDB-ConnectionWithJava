package ar.edu.uade.TPONeo4j;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexion {

	public Conexion() {}

	public static Connection getConexion() throws SQLException {
		// TODO Auto-generated method stub
		Connection conexion;
		conexion = DriverManager.getConnection("jdbc:neo4j:bolt://localhost:7687", "neo4j", "123456");
		return conexion;
	}

}
