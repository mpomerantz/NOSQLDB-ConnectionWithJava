package redisapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Consultas {
private static Jedis jedis;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "Consultas: " );
        System.out.println( "1 - Unidades sin Inquilinos" );
        System.out.println( "2 - Unidades en Venta" );
        System.out.println( "3 - Duenios con mas de 5 unidades" ); 
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
        	jedis = new Jedis("127.0.0.1",6379);
			System.out.println("Te has conectado a la BDD!");
			
			Set<String> keys = jedis.keys("unidad:*");
			ArrayList<String> unidadessininquilinos = new ArrayList<String>();
			
			for(String key : keys){
				if(jedis.hget(key, "Inquilino") == "0"){
				   unidadessininquilinos.add(key);
				}
			}
			
			System.out.println(unidadessininquilinos);
        }
        else {
        	if(s.equals("2")) {
        		jedis = new Jedis("127.0.0.1",6379);
    			System.out.println("Te has conectado a la BDD!");
    			
    			Set<String> keys = jedis.keys("unidad:*");
    			ArrayList<String> unidadesenventa = new ArrayList<String>();
    			
    			for(String key : keys){
    				if(jedis.hget(key, "Estado") == "Venta"){
    				   unidadesenventa.add(key);
    				}
    			}
    			
    			System.out.println(unidadesenventa);
        	}
        	else {
        		if(s.equals("3")) {
        			jedis = new Jedis("127.0.0.1",6379);
        			System.out.println("Te has conectado a la BDD!");
        			
        			Set<String> keys = jedis.keys("duenio:*:unidades");
        			ArrayList<String> dueniosmascinco = new ArrayList<String>();
        			
        			for(String key : keys){
        				if(jedis.scard(key) > 5){
        				   dueniosmascinco.add(key);
        				}
        			}
        			
        			System.out.println(dueniosmascinco);
        		}
        		else {
        				System.out.println("Opcion invalida");
        			}
        		}
        	}
        } 
}
