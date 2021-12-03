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
		Evento evento = null;
		try {
			evento = new Evento(titolo, data, postiTotali);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(evento.toString());
		
		// prenota
		System.out.print("Quanti posti vuoi prenotare? ");
		int postiDaPrenotare = scan.nextInt();
		
		try {
			evento.prenota(data, postiDaPrenotare);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Posti ancora disponibili: " + evento.getPostiLiberi());
		
		// disdici
		System.out.print("Quanti posti vuoi disdire? ");
		int postiDaDisdire = scan.nextInt();
		
		try {
			evento.disdici(data, postiDaDisdire);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Posti ancora disponibili: " + evento.getPostiLiberi());
		
		// scanner close
		scan.close();
		
	}

}
