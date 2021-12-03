package org.generation.italy.eventi;

import java.time.LocalDate;

public class Evento {
	
	// attributi
	String titolo;
	LocalDate data;
	int postiTotali;
	int postiPrenotati = 0;
	
	//costruttori
	public Evento(String titolo, LocalDate data, int postiTotali) {
		
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		
		if (!isValidData(data) || !isValidPostiTotali(postiTotali)) {
			// ERRORE
		}
		
	}

	// metodi pubblici
	public void prenota() {
		int postiLiberi = postiTotali - postiPrenotati;
		if (!isValidData(data) || postiLiberi < 1) {
			// ERRORE
		} else {
			postiPrenotati++;
		}
	}
	
	public void disdici() {
		if (!isValidData(data) || postiPrenotati < 1) {
			// ERRORE
		} else {
			postiPrenotati--;
		}
	}
	
	@Override
	public String toString() {
		return data.toString() + titolo;
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
	
	// validatori
	private boolean isValidData(LocalDate data) {
		return data.isAfter(LocalDate.now());
	}

	private boolean isValidPostiTotali(int postiTotali) {
		return postiTotali > 0;
	}
	
}
