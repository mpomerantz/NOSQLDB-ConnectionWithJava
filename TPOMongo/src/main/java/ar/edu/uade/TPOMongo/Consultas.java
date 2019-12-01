package ar.edu.uade.TPOMongo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Consultas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println( "Consultas: " );
        System.out.println( "1 - Inversion con mas operaciones" );
        System.out.println( "2 - Mayor ganancia de cada Inversion" );
        System.out.println( "3 - Asesor con mas recomendaciones para la Inversion n4" ); 
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
        	MongoClient mongoClient = MongoClients.create();
    		MongoDatabase database = mongoClient.getDatabase("Inversiones");
    		MongoCollection<Document> collection = database.getCollection("Inversiones");
    		
    		//Aca iria la consulta en Java 
        }
        else {
        	if(s.equals("2")) {
        		MongoClient mongoClient = MongoClients.create();
        		MongoDatabase database = mongoClient.getDatabase("Inversiones");
        		MongoCollection<Document> collection = database.getCollection("Inversiones");
        		
        		//Aca iria la consulta en Java 
        	}
        	else {
        		if(s.equals("3")) {
        			MongoClient mongoClient = MongoClients.create();
        			MongoDatabase database = mongoClient.getDatabase("Inversiones");
        			MongoCollection<Document> collection = database.getCollection("Inversiones");
        			
        			//Aca iria la consulta en Java 
        		}
        	}
        }
	}
}
