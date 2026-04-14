package juego;

public class mostrarLetras {

	public static String[] marcarCasillas(String usuario, String palabraSecreta) {

		String[] colorFinal = new String[5];

		mostrarVerde(usuario, palabraSecreta, colorFinal);
		mostrarAmarillo(usuario, palabraSecreta, colorFinal);
		mostrarGris(colorFinal);

		return colorFinal;
	}

	static void mostrarVerde(String usuario, String palabraSecreta, String[] colorFinal) {
		for (int i = 0; i < 5; i++) {
			if (usuario.charAt(i) == palabraSecreta.charAt(i)) {
				colorFinal[i] = Estado.VERDE;
			}
		}
	}

	static void mostrarAmarillo(String usuario, String palabraSecreta, String[] colorFinal) {

		for (int i = 0; i < 5; i++) {
			char letra = usuario.charAt(i);
			if (colorFinal[i] == Estado.VERDE)
				continue;

			if (palabraSecreta.indexOf(letra) >= 0) {
				colorFinal[i] = Estado.AMARILLO;
			}
		}
	}

	static void mostrarGris(String[] colorFinal) {
		for (int i = 0; i < 5; i++) {
			if (colorFinal[i] == null) {
				colorFinal[i] = Estado.GRIS;
			}
		}
	}

}