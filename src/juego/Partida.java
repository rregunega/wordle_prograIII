package juego;

import java.util.Scanner;

public class Partida {

	boolean gano = false;
	int intentos = 5;
	lector_palabras palabras = new lector_palabras();
	public String palabra;
	String entrada;
	Scanner sc;

	public Partida() {
		this.palabra = palabras.devolverPalabra().toUpperCase();
		sc = new Scanner(System.in);
	}

	public void intento() {

		while (intentos > 0 && !gano) {
			System.out.println("ingrese una palabra de cinco letras maximo");
			entrada = sc.nextLine().toUpperCase();

			if (!verificarPalabra()) {
				continue;
			}

			modificadores.rellenarPalabra(entrada);

			if (!palabraEQentrada()) {
				ganoJuego();
				return;
			}
			intentos -= 1;
		}

		if (intentos == 0 && !gano) {
			perderJuego();
		}
	}

	public Letra[] verificarLetra(String PalabraUsuario) {
		String PalabraMaquina=this.palabra;
		Letra[] letras = new Letra[5];
		
		for (int indice = 0; indice < PalabraUsuario.length(); indice++) {
			char usuario = PalabraUsuario.charAt(indice);
			char maquina = PalabraMaquina.charAt(indice);
			
				if (usuario == maquina) {
					letras[indice] = new Letra(usuario, Estado.VERDE);
					PalabraMaquina=PalabraMaquina.replaceFirst(String.valueOf(maquina)," " );
					System.out.println("agregado");
					continue;
				}
		}

		for (int indice = 0; indice < PalabraUsuario.length(); indice++) {
			
			char usuario = PalabraUsuario.charAt(indice);
			
			
			if(letras[indice] != null) {continue;}
			if (PalabraMaquina.contains(String.valueOf(usuario))) {
					letras[indice] = new Letra(usuario, Estado.AMARILLO);
					PalabraMaquina=PalabraMaquina.replaceFirst(String.valueOf(usuario)," " );
					continue;
				}
			letras[indice] = new Letra(usuario, Estado.GRIS);
			continue;

		}

		return letras;
	}

	private boolean palabraEQentrada() {
		if (palabra.equals(entrada)) {
			this.gano = true;
			return true;
		}
		return false;
	}

	private boolean verificarPalabra() {
		if (this.entrada.length() > 5 || this.entrada.length() < 1) {
			System.out.println("palabra invalida (muy larga o muy corta\n recuerde que debe ser de 5 letras maximo)");
			return false;
		}
		return true;
	}

	public void perderJuego() {
		System.out.println("Perdiste: " + palabra);
	}

	public static void ganoJuego() {
		System.out.println("Ganaste!");
	}

}
