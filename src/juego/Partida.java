package juego;

public class Partida {

	private boolean gano = false;
	private int intentosRestantes;
	private int intentosMaximos;
	private LectorPalabras palabras;
	private String palabra;
	private Dificultad dificultad;
	private Idioma idioma;
	private long inicio;
	private long fin;

	public Partida() {
		this(Dificultad.FACIL, Idioma.ESPANOL);
	}

	public Partida(Dificultad dificultad, Idioma idioma) {
		this.dificultad = dificultad;
		this.idioma = idioma;
		this.intentosMaximos = dificultad.getIntentos();
		this.intentosRestantes = intentosMaximos;
		this.palabras = new LectorPalabras(dificultad, idioma);
		this.palabra = palabras.devolverPalabra().toUpperCase();
		this.inicio = System.currentTimeMillis();
		this.fin = 0;
	}

	public String devolverPalabraSecreta() {
		return this.palabra;
	}

	public Letra[] verificarLetra(String palabraUsuario) {
		String palabraMaquina = this.palabra;
		palabraUsuario = palabraUsuario.toUpperCase();
		Letra[] letras = new Letra[5];
		char[] letrasDisponibles = palabraMaquina.toCharArray();
		verificarVictoria(palabraUsuario);

		for (int indice = 0; indice < palabraUsuario.length(); indice++) {
			char usuario = palabraUsuario.charAt(indice);
			char maquina = palabraMaquina.charAt(indice);

			if (usuario == maquina) {
				letras[indice] = new Letra(usuario, EstadoPalabra.CORRECTA);
				letrasDisponibles[indice] = ' ';
			}
		}

		for (int indice = 0; indice < palabraUsuario.length(); indice++) {
			char usuario = palabraUsuario.charAt(indice);
			if (letras[indice] != null) {
				continue;
			}
			int posicionEncontrada = buscarLetra(letrasDisponibles, usuario);
			if (posicionEncontrada >= 0) {
				letras[indice] = new Letra(usuario, EstadoPalabra.DESPLAZADA);
				letrasDisponibles[posicionEncontrada] = ' ';
				continue;
			}
			letras[indice] = new Letra(usuario, EstadoPalabra.INCORRECTA);
		}
		verificarDerrota();
		return letras;
	}

	private int buscarLetra(char[] letrasDisponibles, char letra) {
		for (int i = 0; i < letrasDisponibles.length; i++) {
			if (letrasDisponibles[i] == letra) {
				return i;
			}
		}
		return -1;
	}

	private void verificarVictoria(String palabraUsuario) {
		if (palabra.equals(palabraUsuario)) {
			this.gano = true;
			this.fin = System.currentTimeMillis();
			MejorTiempo.registrar(dificultad, idioma, getTiempoEnSegundos());
		}
	}

	private void verificarDerrota() {
		if (!gano) {
			this.intentosRestantes--;
		}
	}

	public boolean perdio() {
		if (intentosRestantes == 0 && !gano) {
			return true;
		}
		return false;
	}

	public boolean gano() {
		return gano;
	}

	public String getPalabraSecreta() {
		return palabra;
	}

	public int getIntentosMaximos() {
		return intentosMaximos;
	}

	public int getIntentosRestantes() {
		return intentosRestantes;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public long getTiempoEnSegundos() {
		long tiempoFinal;
		if (fin > 0) {
			tiempoFinal = fin;
		} else {
			tiempoFinal = System.currentTimeMillis();
		}
		return (tiempoFinal - inicio) / 1000;
	}

	public long getMejorTiempo() {
		return MejorTiempo.obtener(dificultad, idioma);
	}
}
