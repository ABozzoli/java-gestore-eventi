package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// scanner init
		Scanner scan = new Scanner(System.in);
		
		// formatter init
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		// richiedi dati per istanziamento Evento
		System.out.println("Inserire dati nuovo evento");
		System.out.print("Titolo: ");
		String titolo = scan.nextLine();
		
	    System.out.print("Data [dd/MM/yyyy]: ");
	    String dataString = scan.nextLine();
	    LocalDate data = LocalDate.parse(dataString, formatter);
	 
		System.out.print("Posti totali: ");
		int postiTotali = scan.nextInt();
		
		// nuovo oggetto Evento
		Evento evento = new Evento(titolo, data, postiTotali);
		System.out.println(evento.toString());
		
		// prenota
		System.out.print("Quanti posti vuoi prenotare? ");
		int postiDaPrenotare = scan.nextInt();
		
		evento.prenota(postiDaPrenotare);
		System.out.println("Hai prenotato " + postiDaPrenotare + " posti.");
		System.out.println("Posti ancora disponibili: " + evento.getPostiLiberi());
		
		// disdici
		System.out.print("Quanti posti vuoi disdire? ");
		int postiDaDisdire = scan.nextInt();
		
		evento.disdici(postiDaDisdire);
		System.out.println("Hai disdetto " + postiDaDisdire + " posti.");
		System.out.println("Posti ancora disponibili: " + evento.getPostiLiberi());
		
		// scanner close
		scan.close();
		
	}

}
