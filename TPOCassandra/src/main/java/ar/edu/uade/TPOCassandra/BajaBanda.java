package ar.edu.uade.TPOCassandra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class BajaBanda {
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
		
        System.out.println("ID Usuario: ");
        String idusuario = br.readLine();
        System.out.println("ID Lista de Reproduccion: ");
        String idlista = br.readLine();
        System.out.println("ID Banda: ");
        String idbanda = br.readLine();
        sesion.execute("DELETE FROM musico_temas "
        		+ "WHERE id_usuario = '" + idusuario +"' AND id_lista = '" + idlista + "' AND id_banda = '" + idbanda +"'");
        
        
        System.out.println( "Fin. \n 1 - Eliminar otro \n 2 - Menu" );
		 String flag = br.readLine();
		 int a = Integer.valueOf(flag);
		 if(a==1) {
			 BajaBanda.main(args);
		 }
		 else {
			 Menu.main(args);
		 }
	}
}
