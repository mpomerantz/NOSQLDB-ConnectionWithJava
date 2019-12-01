package ar.edu.uade.TPOCassandra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class Consultas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Cluster cluster1 = Cluster.builder().addContactPoints("172.30.210.11","172.30.210.12").build();
		Session sesion = cluster1.connect("musica");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int i = Integer.parseInt(br.readLine());
        } catch(NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        
        System.out.println("Consultas: ");
        System.out.println("1 - Bandas de un usuario");
        System.out.println("2 - Autor de la letra de una cancion");
        System.out.println("3 - Musico con mas temas interpretados");
        System.out.println("4 - Albumes de una discografica");
        System.out.println("5 - Todos los temas de un album");
        System.out.println("6 - Todos los albumes que contengan un tema determinado");
        String opcion = br.readLine();
		 int opc = Integer.valueOf(opcion);
        
		 if(opc==1) {
			 System.out.println("Bandas de un usuario");
			 System.out.println("Usuario: ");
			 String usu = br.readLine();
			 
			 ResultSet rs = sesion.execute("SELECT * FROM usuarios_bandas WHERE nombre_usuario=" + usu + " ALLOW FILTERING");
			 Iterator<Row> iterador = rs.iterator();
			 while (iterador.hasNext()){
			    System.out.println(iterador.next().getString("nombre_musico_banda"));
			 }
			 
		 }
		 else {
			 if(opc==2) {				 
				 System.out.println("Autor de la letra de una cancion");
				 System.out.println("Cancion: ");
				 String can = br.readLine();			 
				 
				 
				 ResultSet rs = sesion.execute("SELECT * FROM musico_letra WHERE nombre_cancion=" + can + " ALLOW FILTERING");
				 Iterator<Row> iterador = rs.iterator();
				 while (iterador.hasNext()){
				    System.out.println(iterador.next().getString("nombre_musico_letra"));
				 }
				 
			 }
			 else {
				if(opc==3) {
					System.out.println("Musico con mas temas interpretados: ");
					 
					 ResultSet rs = sesion.execute("SELECT *, COUNT(*) FROM musico_temas GROUP BY id_musico_interprete LIMIT 1");
					 Iterator<Row> iterador = rs.iterator();
					 while (iterador.hasNext()){
					    System.out.println(iterador.next().getString("nombre_musico_interprete"));
					 }
					
					
				}
				else {
					if(opc==4) {
						System.out.println("Albumes de una discografica");
						 System.out.println("Discografica: ");
						 String dis = br.readLine();			 
						 
						 
						 ResultSet rs = sesion.execute("SELECT * FROM album_discografica WHERE nombre_discografica=" + dis + " ALLOW FILTERING");
						 Iterator<Row> iterador = rs.iterator();
						 while (iterador.hasNext()){
						    System.out.println(iterador.next().getString("nombre_album"));
						 }
						
					}
					else {
						if(opc==5) {
							System.out.println("Todos los temas de un album");
							 System.out.println("Album: ");
							 String alb = br.readLine();			 
							 
							 
							 ResultSet rs = sesion.execute("SELECT * FROM temas_album WHERE nombre_album=" + alb + " ALLOW FILTERING");
							 Iterator<Row> iterador = rs.iterator();
							 while (iterador.hasNext()){
							    System.out.println(iterador.next().getString("nombre_cancion"));
							 }
							
						}
						else {
							if(opc==6) {
								System.out.println("Todos los albumes que contienen un tema determinado");
								 System.out.println("Cancion: ");
								 String can = br.readLine();			 
								 
								 
								 ResultSet rs = sesion.execute("SELECT * FROM temas_album WHERE nombre_cancion=" + can + " ALLOW FILTERING");
								 Iterator<Row> iterador = rs.iterator();
								 while (iterador.hasNext()){
								    System.out.println(iterador.next().getString("nombre_album"));
								 	}
							}
							else {
								System.out.println("Opcion no valida");
							}
						}
					}
				}
			 }
		 }
		 
		 System.out.println( "Fin. \n 1 - Realizar otra consulta \n 2 - Menu" );
		 String flag = br.readLine();
		 int a = Integer.valueOf(flag);
		 if(a==1) {
			 Consultas.main(args);
		 }
		 else {
			 Menu.main(args);
		 }
	}

}
