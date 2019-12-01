package redisapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class AltaUnidades {

	private static Jedis jedis;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			jedis = new Jedis("127.0.0.1",6379);
			System.out.println("Te has conectado a la BDD!");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Map<String, String> unidades = new HashMap<String, String>();
			
			System.out.println( "ID Unidad: " );
			String id = br.readLine();
			System.out.println( "Estado: " );
			String estado = br.readLine();
			unidades.put("Estado", estado);
			if(estado == "Alquiler") {
				System.out.println( "Inquilino: " );
				String inquilino = br.readLine();
				unidades.put("Inquilino", inquilino);
			}
			
			jedis.hmset(id, unidades);
			
			System.out.println( "Fin. \n 1 - Ingresar otra Unidad \n 2 - Menu" );
			 String flag = br.readLine();
			 int b = Integer.valueOf(flag);
			 if(b==1) {
				 AltaUnidades.main(args);
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
