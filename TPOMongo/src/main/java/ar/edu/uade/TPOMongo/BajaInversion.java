package ar.edu.uade.TPOMongo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class BajaInversion {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 MongoClient mongoClient = MongoClients.create();
		 MongoDatabase database = mongoClient.getDatabase("Inversiones");
		 MongoCollection<Document> collection = database.getCollection("Inversiones");
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        try {
	            int i = Integer.parseInt(br.readLine());
	        } catch(NumberFormatException nfe) {
	            System.err.println("Invalid Format!");
	        }
	    
	    System.out.println("Ingrese el numero de la Innversion que desea eliminar: ");
	    String id = br.readLine();	    
		
		collection.deleteOne(eq("_id", id));
		
		System.out.println( "Fin. \n 1 - Eliminar otra inversion \n 2 - Menu" );
		 String flag = br.readLine();
		 int a = Integer.valueOf(flag);
		 if(a==1) {
			 BajaInversion.main(args);
		 }
		 else {
			 Menu.main(args);
		 }
	}

}
