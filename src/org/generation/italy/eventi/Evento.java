package org.generation.italy.eventi;

import java.time.LocalDate;

public class Evento {
	
	// attributi
	String titolo;
	LocalDate data;
	int postiTotali;
	int postiPrenotati = 0;
	
	//costruttori
	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception {
		
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		
		if (!isValidData(data) || !isValidPostiTotali(postiTotali)) {
			throw new Exception("uno dei dati è errato");
			// da rivedere
		}
		
	}

	// validatori
	private boolean isValidData(LocalDate data) {
		LocalDate dataOdierna = LocalDate.now();
		return data.isAfter(dataOdierna);
	}

	private boolean isValidPostiTotali(int postiTotali) {
		return postiTotali > 0;
	}
	
}
