package ar.edu.uade.TPONeo4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ar.edu.uade.TPONeo4j.AltaEdificio;
import ar.edu.uade.TPONeo4j.BajaEdificio;
import ar.edu.uade.TPONeo4j.Consultas;
import ar.edu.uade.TPONeo4j.ModificacionEdificio;

public class Menu {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println( "Menu: " );
        System.out.println( "1 - Alta de Edificios" );
        System.out.println( "2 - Baja de Edificios" );
        System.out.println( "3 - Modificacion de Edificios" );
        System.out.println( "4 - Consultas" );
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
        	AltaEdificio.main(args);
        }
        else {
        	if(s.equals("2")) {
        		BajaEdificio.main(args);
        	}
        	else {
        		if(s.equals("3")) {
        			ModificacionEdificio.main(args);
        		}
        		else {
        			if(s.equals("4")) {
        				Consultas.main(args);
        			}
        			else {
        				System.out.println("Opcion invalida");
        			}
        		}
        	}
        }      
    }
}
