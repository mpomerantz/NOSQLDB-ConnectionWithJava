package redisapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import redis.clients.jedis.Jedis;

public class ModificacionUnidades {
	
	private static Jedis jedis;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			jedis = new Jedis("127.0.0.1",6379);
			System.out.println("Te has conectado a la BDD!");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println( "Ingrese el ID de la Unidad que desea modificar: " );
			String id = br.readLine();
			System.out.println( "Estado: " );
			String estado = br.readLine();
			jedis.hset(id, "Estado", estado);
			if(estado == "Alquiler") {
				System.out.println( "Inquilino: " );
				String inquilino = br.readLine();
				jedis.hset(id, "Inquilino", inquilino);
			}
			
			System.out.println( "Fin. \n 1 - Modificar otra Unidad \n 2 - Menu" );
			 String flag = br.readLine();
			 int b = Integer.valueOf(flag);
			 if(b==1) {
				 ModificacionUnidades.main(args);
			 }
			 else {
				 Menu.main(args);
			 }
			
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
		
}
