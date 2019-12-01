package ar.edu.uade.TPONeo4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println( "Consultas: " );
        System.out.println( "1 - Duenios de las Unidades del Edificio 1" );
        System.out.println( "2 - Unidades Alquiladas con sus Inquilinos" );
        System.out.println( "3 - Unidad donde el Inquilino es Carlos" ); 
        System.out.println( "4 - Cantidad de Inquilinos del Edificio 1" );
        System.out.println( "5 - Unidades de cada Inquilino" );
        System.out.println( "6 - Monto a pagar de expensas por el Duenio por sus Unidades" );
        System.out.println("Ingrese una opcion: ");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println("Ingresaste: " + s);
        
        try {
            int i = Integer.parseInt(br.readLine());
        } catch(NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        if(s.equals("1")) {
    		try {
    			
    			PreparedStatement stat = Conexion.getConexion().prepareStatement("MATCH (e:Edificio)-[:TIENE]->(u:Unidad)<-[:POSEE]-(d:Duenio) WHERE e.name= Edificio1 return d.name");
    			ResultSet res = stat.executeQuery();
    			while(res.next()) {
    				System.out.println(res.getString(1));
    			}
    			
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
        }
        else {
        	if(s.equals("2")) {
        		try {
        			
        			PreparedStatement stat = Conexion.getConexion().prepareStatement("MATCH (e:Edificio)-[:TIENE]->(u:Unidad)<-[:ALQUILA]-(inq:Inquilino) WHERE exists ((:Inquilino)-[:ALQUILA]->(u)) RETURN u.name, inq.name");
        			ResultSet res = stat.executeQuery();
        			while(res.next()) {
        				System.out.println(res.getString(1) + "," + res.getString(2));
        			}
        			
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
        	}
        	else {
        		if(s.equals("3")) {
        			try {
            			
            			PreparedStatement stat = Conexion.getConexion().prepareStatement("MATCH (e:Edificio)-[:TIENE]->(u:Unidad)<-[:ALQUILA]-(inq:Inquilino) WHERE  inq.name contains 'Carlos' RETURN u.name, inq.name");
            			ResultSet res = stat.executeQuery();
            			while(res.next()) {
            				System.out.println(res.getString(1) + "," + res.getString(2));
            			}
            			
            		} catch (SQLException e) {
            			e.printStackTrace();
            		}
        		}
        		else {
        			if(s.equals("4")) {
        				try {
                			
                			PreparedStatement stat = Conexion.getConexion().prepareStatement("MATCH (e:Edificio)-[:TIENE]->(u:Unidad)<-[:ALQUILA]-(inq:Inquilino) WHERE e.name='Edificio1' RETURN COUNT(inq)");
                			ResultSet res = stat.executeQuery();
                			while(res.next()) {
                				System.out.println(res.getString(1));
                			}
                			
                		} catch (SQLException e) {
                			e.printStackTrace();
                		}
        			}
        			else {
        				if(s.equals("5")) {
        					try {
                    			
                    			PreparedStatement stat = Conexion.getConexion().prepareStatement("MATCH (e:Edificio)-[:TIENE]->(u:Unidad)<-[:ALQUILA]-(inq:Inquilino) WHERE exists ((:Inquilino)-[:ALQUILA]->(u)) RETURN  inq.name, u.name");
                    			ResultSet res = stat.executeQuery();
                    			while(res.next()) {
                    				System.out.println(res.getString(1) + "," + res.getString(2));
                    			}
                    			
                    		} catch (SQLException e) {
                    			e.printStackTrace();
                    		}
        				}
        				else {
        					if(s.equals("6")) {
        						try {
                        			
                        			PreparedStatement stat = Conexion.getConexion().prepareStatement("MATCH (e:Edificio)-[:TIENE]->(u:Unidad)<-[:POSEE]-(d:Duenio) RETURN d.name ,sum(u.exp)");
                        			ResultSet res = stat.executeQuery();
                        			while(res.next()) {
                        				System.out.println(res.getString(1) + "," + res.getString(2));
                        			}
                        			
                        		} catch (SQLException e) {
                        			e.printStackTrace();
                        		}
        					}
        					else {
                				System.out.println("Opcion invalida");
                			}
        				}
        			}
        		}
        	}
        }
    } 
}

