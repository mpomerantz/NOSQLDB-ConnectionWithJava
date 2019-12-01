package redisapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import redis.clients.jedis.Jedis;

public class BajaUnidades {

	private static Jedis jedis;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			jedis = new Jedis("127.0.0.1",6379);
			System.out.println("Te has conectado a la BDD!");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println( "Ingrese el ID de la Unidad que desea eliminar: " );
			String id = br.readLine();
			
			jedis.del(id);
			
			System.out.println( "Fin. \n 1 - Eliminar otra Unidad \n 2 - Menu" );
			 String flag = br.readLine();
			 int b = Integer.valueOf(flag);
			 if(b==1) {
				 BajaUnidades.main(args);
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
