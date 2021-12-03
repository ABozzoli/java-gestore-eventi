package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// scanner init
		Scanner scan = new Scanner(System.in);
		
		// titolo
		System.out.println("Inserire dati nuovo evento");
		System.out.print("Titolo: ");
		String titolo = scan.nextLine();
		
		// data
	    System.out.print("Data [dd/MM/yyyy]: ");
	    String dataString = scan.nextLine();
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate data = LocalDate.parse(dataString, dtf);
	 
	    // posti totali
		System.out.print("Posti totali: ");
		int postiTotali = scan.nextInt();
		
		// nuovo oggetto Evento
		Evento e = new Evento(titolo, data, postiTotali);
		
		// scanner close
		scan.close();
	}

}
