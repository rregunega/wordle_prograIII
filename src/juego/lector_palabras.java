package juego;

import java.io.*;
import java.util.*;

public class lector_palabras {
	List<String> listaDePalabras = new ArrayList<>();
	File palabras;
	Scanner scan;

	public lector_palabras() {
		inicializar();
		leer();
	}

	public void inicializar() {
		try {
			InputStream palabras = getClass().getResourceAsStream("/recursosUtilizados/palabras.txt");
			scan = new Scanner(palabras);
		}

		catch (Exception e) {
			System.out.println("¡Error! No encontré el archivo: " + e.getMessage());
		}
	}

	public void leer() {
		while (scan.hasNextLine()) {
			listaDePalabras.add(scan.nextLine());
		}
	}

	public String devolverPalabra() {
		int numero = (int) ((this.listaDePalabras.size() - 1) * Math.random());
		return listaDePalabras.get(numero);

	}

}
