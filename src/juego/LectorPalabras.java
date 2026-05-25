package juego;

import java.io.*;
import java.util.*;

public class LectorPalabras {
	private List<String> listaDePalabras = new ArrayList<String>();
	private Scanner scan;
	private Dificultad dificultad;
	private Idioma idioma;

	public LectorPalabras() {
		this(Dificultad.FACIL, Idioma.ESPANOL);
	}

	public LectorPalabras(Dificultad dificultad, Idioma idioma) {
		this.dificultad = dificultad;
		this.idioma = idioma;
		inicializar();
		leer();
	}

	public void inicializar() {
		try {
			InputStream palabras = getClass().getResourceAsStream(obtenerRuta());
			scan = new Scanner(palabras);
		}

		catch (Exception e) {
			System.out.println("¡Error! No encontré el archivo: " + e.getMessage());
		}
	}

	public void leer() {
		if (scan == null) {
			return;
		}
		while (scan.hasNextLine()) {
			String palabra = scan.nextLine().trim();
			if (palabra.length() == 5) {
				listaDePalabras.add(palabra.toUpperCase());
			}
		}
		scan.close();
	}

	public String devolverPalabra() {
		if (listaDePalabras.size() == 0) {
			return "ERROR";
		}
		int numero = (int) (this.listaDePalabras.size() * Math.random());
		return listaDePalabras.get(numero);

	}

	private String obtenerRuta() {
		if (idioma == Idioma.INGLES) {
			if (dificultad == Dificultad.DIFICIL) {
				return "/recursosUtilizados/palabras_en_dificil.txt";
			}
			return "/recursosUtilizados/palabras_en_facil.txt";
		}

		if (dificultad == Dificultad.DIFICIL) {
			return "/recursosUtilizados/palabras_es_dificil.txt";
		}
		return "/recursosUtilizados/palabras_es_facil.txt";
	}
}
