package org.generation.italy.eventi;

import java.time.LocalDate;

public class Evento {
	
	// attributi
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;
	
	//costruttori
	public Evento(String titolo, LocalDate data, int postiTotali) {
		
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		
		if (!isValidData(data)) {
			System.out.println("ERRORE: data non valida.");
		}
		if (!isValidPostiTotali(postiTotali)) {
			System.out.println("ERRORE: posti totali non validi.");
		}
		
	}

	// metodi pubblici
	public void prenota(int postiDaPrenotare) {
		int postiLiberi = postiTotali - postiPrenotati;
		if (postiDaPrenotare > postiLiberi) {
			System.out.println("ERRORE: posti non disponibili");
		} else {
			postiPrenotati += postiDaPrenotare;
		}
		
	}
	
	public void disdici(int postiDaDisdire) {
		if (postiDaDisdire > postiPrenotati) {
			System.out.println("ERRORE: non ci sono così tanti posti prenotati");
		} else {
			postiPrenotati -= postiDaDisdire;
		}
	}
	
	@Override
	public String toString() { // manca da formattare la data
		return data.toString() + " - " + titolo;
	}
	
	// getter/setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public int getPostiLiberi() {
		return postiTotali - postiPrenotati;
	}
	
	// validatori
	private boolean isValidData(LocalDate data) {
		return data.isAfter(LocalDate.now());
	}

	private boolean isValidPostiTotali(int postiTotali) {
		return postiTotali > 0;
	}
	
}
