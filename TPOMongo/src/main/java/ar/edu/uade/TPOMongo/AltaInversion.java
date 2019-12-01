package ar.edu.uade.TPOMongo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AltaInversion {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int flagCot = 1;
		int flagOper = 1;
		int flagOpi = 1;
		 
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("Inversiones");
		MongoCollection<Document> collection = database.getCollection("Inversiones");
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    try {
	    	int i = Integer.parseInt(br.readLine());
	    } catch(NumberFormatException nfe) {
	        System.err.println("Invalid Format!");
	    }
		 
		System.out.println( "ID Inversion: " );
		String id = br.readLine();
		Document document = new Document("_id", id);
		System.out.println( "Tipo Inversion: " );
		String tipo = br.readLine();
		document.append("tipo", tipo);
		System.out.println( "Cantidad: " );
		String cantidad = br.readLine();
		document.append("cantidad", cantidad);
		System.out.println( "Inversion inicial: " );
		String inversioninicial = br.readLine();
		document.append("invInicial", inversioninicial);
		
		System.out.println( "Cotizaciones: " );
		 
		 while(flagCot==1) {
			 System.out.println( "ID Cotizacion: " );
			 String cot = br.readLine();
			 System.out.println( "Fecha Cotizacion: " );
			 String fechacot = br.readLine();
			 System.out.println( "Valor Cotizacion: " );
			 String valorcot = br.readLine();
			 System.out.println( "1 - Ingresar otra cotizacion" + "\n" + "2 - Continuar" );
			 String flag = br.readLine();
			 flagCot = Integer.valueOf(flag);
			 document.append("cotizaciones", new Document("cot", cot).append("fecha", fechacot).append("valor", valorcot));
		 }		 
		 
		 System.out.println( "Operaciones: " );
		 
		 while(flagOper==1) {
			 System.out.println( "ID Operacion: " );
			 String op = br.readLine();
			 System.out.println( "Fecha de Operacion: " );
			 String fechaop = br.readLine();
			 System.out.println( "Importe: " );
			 String importeop = br.readLine();
			 System.out.println( "Tipo de operacion: " );
			 String tipoop = br.readLine();
			 System.out.println( "Operador: " );
			 String operador = br.readLine();
			 System.out.println( "Asesor: " );
			 String asesor = br.readLine();
			 System.out.println( "1 - Ingresar otra operacion" + "\n" + "2 - Continuar" );
			 String flag = br.readLine();
			 flagOper = Integer.valueOf(flag);
			 document.append("operaciones", new Document("numop", op).append("fechaOp", fechaop).append("importe", importeop).append("tipoOperacion", tipoop).append("operador", operador).append("asesor", asesor));
		 }	
		 
		 System.out.println( "Opiniones: " );
		 
		 while(flagOpi==1) {
			 System.out.println( "Asesor: " );
			 String asesor = br.readLine();
			 System.out.println( "Opinion: " );
			 String opinion = br.readLine();
			 System.out.println( "Recomendacion: " );
			 String recomendacion = br.readLine();
			 System.out.println( "1 - Ingresar otra opinion" + "\n" + "2 - Continuar" );
			 String flag = br.readLine();
			 flagOpi = Integer.valueOf(flag);
			 document.append("opiniones", new Document("asesor", asesor).append("opinion", opinion).append("recomendacion", recomendacion));
		 }	
		 
		 
		 collection.insertOne(document);
		 
		 System.out.println( "Fin. \n 1 - Ingresar otra inversion \n 2 - Menu" );
		 String flag = br.readLine();
		 int b = Integer.valueOf(flag);
		 if(b==1) {
			 AltaInversion.main(args);
		 }
		 else {
			 Menu.main(args);
		 }
		 
		
	}

}
