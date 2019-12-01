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
import static com.mongodb.client.model.Updates.*;

public class ModificacionInversion {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MongoClient mongoClient = MongoClients.create();
		 MongoDatabase database = mongoClient.getDatabase("tpo");
		 MongoCollection<Document> collection = database.getCollection("inversiones");
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        try {
	            int i = Integer.parseInt(br.readLine());
	        } catch(NumberFormatException nfe) {
	            System.err.println("Invalid Format!");
	        }
	        
	        System.out.println( "Ingrese el numero de la Inversion que desea modificar: " );
			 String modificar = br.readLine();
			 System.out.println( "Que desea modificar?" );
			 System.out.println( "1 - Tipo de la inversion" );
			 System.out.println( "2 - Cantidad" );
			 System.out.println( "3 - Valor Inicial" );
			 
			 String opcion = br.readLine();
			 int opc = Integer.valueOf(opcion);
			 
			 if(opc == 1) {
				 System.out.println( "Ingrese el nuevo Tipo: " );
				 String valor = br.readLine();
				 collection.updateOne(eq("_id", modificar),
	             combine(set("tipo", valor)));
			 }
			 else {
				 if(opc == 2) {
					 System.out.println( "Ingrese la nueva Cantidad: " );
					 String valor = br.readLine();
					 collection.updateOne(eq("_id", modificar),
		             combine(set("cantidad", valor)));
				 }
				 else {
					 if(opc == 3) {
						 System.out.println( "Ingrese el nuevo valor Inicial: " );
						 String valor = br.readLine();
						 collection.updateOne(eq("_id", modificar),
			             combine(set("valinicial", valor)));
					 }
					 else {
						 System.out.println( "Opcion no valida" );
					 }
				 }
			 }
			 
		System.out.println( "Fin. \n 1 - Actualizar otra inversion \n 2 - Menu" );
		 String flag = br.readLine();
		 int a = Integer.valueOf(flag);
		 if(a==1) {
			 ModificacionInversion.main(args);
		 }
		 else {
			 Menu.main(args);
		 }
	}

}
