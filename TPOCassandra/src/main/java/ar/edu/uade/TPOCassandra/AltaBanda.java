package ar.edu.uade.TPOCassandra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class AltaBanda {

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
        System.out.println("Nombre Usuario: ");
        String nombreusuario = br.readLine();
        System.out.println("Apellido Usuario: ");
        String apellidousuario = br.readLine();
        System.out.println("Mail Usuario: ");
        String mailusuario = br.readLine();
        System.out.println("Password Usuario: ");
        String passwordusuario = br.readLine();
        System.out.println("ID Lista de Reproduccion: ");
        String idlista = br.readLine();
        System.out.println("ID Banda: ");
        String idbanda = br.readLine();
        System.out.println("Nombre Banda: ");
        String nombrebanda = br.readLine();
        sesion.execute("INSERT INTO usuarios_bandas "
        		+ "(id_usuario, nombre_usuario, apellido_usuario, mail_usuario, password_usuario, id_lista_reproduccion, id_musico_banda, nombre_musico_banda) "
        		+ "VALUES ("+ idusuario + "," + nombreusuario + "," + apellidousuario + ","+ mailusuario + "," + passwordusuario + "," + idlista + "," + idbanda + "," + nombrebanda +")");
        
        
        System.out.println( "Fin. \n 1 - Insertar otro \n 2 - Menu" );
		 String flag = br.readLine();
		 int a = Integer.valueOf(flag);
		 if(a==1) {
			 AltaBanda.main(args);
		 }
		 else {
			 Menu.main(args);
		 }
	}

}
