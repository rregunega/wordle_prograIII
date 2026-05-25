package juego;

public class MejorTiempo {

	// Cada variable guarda el mejor tiempo de una combinacion de idioma y dificultad.
	// El valor 0 significa que todavia no hay ningun tiempo registrado.
	private static long mejorTiempoFacilEspanol = 0;
	private static long mejorTiempoDificilEspanol = 0;
	private static long mejorTiempoFacilIngles = 0;
	private static long mejorTiempoDificilIngles = 0;

	public static void registrar(Dificultad dificultad, Idioma idioma, long segundos) {
		// Evitamos guardar tiempos invalidos.
		if (segundos <= 0) {
			return;
		}

		long actual = obtener(dificultad, idioma);

		// Se guarda el tiempo si es el primero, o si mejora al anterior.
		if (actual == 0 || segundos < actual) {
			guardar(dificultad, idioma, segundos);
		}
	}

	public static long obtener(Dificultad dificultad, Idioma idioma) {
		// Devuelve el tiempo correspondiente segun idioma y dificultad.
		if (idioma == Idioma.INGLES) {
			if (dificultad == Dificultad.DIFICIL) {
				return mejorTiempoDificilIngles;
			}
			return mejorTiempoFacilIngles;
		}

		if (dificultad == Dificultad.DIFICIL) {
			return mejorTiempoDificilEspanol;
		}
		return mejorTiempoFacilEspanol;
	}

	private static void guardar(Dificultad dificultad, Idioma idioma, long segundos) {
		// Actualiza solamente la variable que corresponde a la partida ganada.
		if (idioma == Idioma.INGLES) {
			if (dificultad == Dificultad.DIFICIL) {
				mejorTiempoDificilIngles = segundos;
			} else {
				mejorTiempoFacilIngles = segundos;
			}
			return;
		}

		if (dificultad == Dificultad.DIFICIL) {
			mejorTiempoDificilEspanol = segundos;
		} else {
			mejorTiempoFacilEspanol = segundos;
		}
	}
}
