package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	// attributi
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;
	
	//costruttori
	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception {
		
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		
		if (!isValidData(data)) {
			throw new Exception("La data inserita è già trascorsa.");
		}
		if (!isValidPostiTotali(postiTotali)) {
			throw new Exception("Il numero inserito è minore o uguale a 0.");
		}
		
	}

	// metodi pubblici
	public void prenota(LocalDate data, int postiDaPrenotare) throws Exception {
		
		if (!isValidData(data)) {
			throw new Exception("La data inserita è già trascorsa.");
		}
		
		int postiLiberi = postiTotali - postiPrenotati;
		if (postiDaPrenotare > postiLiberi) {
			throw new Exception("Il numero di posti selezionati non è disponibile.");
		} else {
			postiPrenotati += postiDaPrenotare;
		}
		
	}
	
	public void disdici(LocalDate data, int postiDaDisdire) throws Exception {
		
		if (!isValidData(data)) {
			throw new Exception("La data inserita è già trascorsa.");
		}
		
		if (postiDaDisdire > postiPrenotati) {
			throw new Exception("Il numero di posti prenotati è inferiore a quello inserito.");
		} else {
			postiPrenotati -= postiDaDisdire;
		}
		
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormattata = data.format(formatter);
		return dataFormattata + " - " + titolo;
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
