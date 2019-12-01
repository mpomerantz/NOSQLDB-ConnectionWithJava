package ar.edu.uade.TPOMongo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println( "Menu: " );
        System.out.println( "1 - Alta de Inversiones" );
        System.out.println( "2 - Baja de Inversiones" );
        System.out.println( "3 - Modificacion de Inversiones" );
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
        	AltaInversion.main(args);
        }
        else {
        	if(s.equals("2")) {
        		BajaInversion.main(args);
        	}
        	else {
        		if(s.equals("3")) {
        			ModificacionInversion.main(args);
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
