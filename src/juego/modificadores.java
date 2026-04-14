package juego;

public class modificadores {

	public void acierto() {
	}

	public void falla() {
	}

	public static void rellenarPalabra(String entrada) {

		if (entrada.length() < 5) {
			StringBuilder salida = new StringBuilder(entrada);

			int numero_relleno = 5 - entrada.length();

			for (int i = 0; i < numero_relleno; i++) {
				salida.append(" ");
			}
			entrada = salida.toString();
		}
	}

}
