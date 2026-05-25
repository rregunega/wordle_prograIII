package juego;

public class Partida {

	private boolean gano = false;
	private int intentos = 6;
	private LectorPalabras palabras = new LectorPalabras();
	private String palabra;

	public Partida() {
		this.palabra = palabras.devolverPalabra().toUpperCase();
	}

	public String devolverPalabraSecreta() {
		return this.palabra;
	}

	public Letra[] verificarLetra(String PalabraUsuario) {
		String PalabraMaquina = this.palabra;
		Letra[] letras = new Letra[5];
		verificarVictoria(PalabraUsuario);

		for (int indice = 0; indice < PalabraUsuario.length(); indice++) {
			char usuario = PalabraUsuario.charAt(indice);
			char maquina = PalabraMaquina.charAt(indice);

			if (usuario == maquina) {
				letras[indice] = new Letra(usuario, EstadoPalabra.CORRECTA);
				PalabraMaquina = PalabraMaquina.replaceFirst(String.valueOf(maquina), " ");
				System.out.println("agregado");
				continue;
			}
		}
		for (int indice = 0; indice < PalabraUsuario.length(); indice++) {
			char usuario = PalabraUsuario.charAt(indice);
			if (letras[indice] != null) {
				continue;
			}
			if (PalabraMaquina.contains(String.valueOf(usuario))) {
				letras[indice] = new Letra(usuario, EstadoPalabra.DESPLAZADA);
				PalabraMaquina = PalabraMaquina.replaceFirst(String.valueOf(usuario), " ");
				continue;
			}
			letras[indice] = new Letra(usuario, EstadoPalabra.INCORRECTA);
			continue;
		}
		verificarDerrota();
		System.out.println(intentos);
		return letras;
	}

	private void verificarVictoria(String PalabraUsuario) {
		if (palabra.equals(PalabraUsuario)) {
			this.gano = true;
		}
	}

	private void verificarDerrota() {
		if (!gano) {
			this.intentos--;
		}
	}

	public boolean perdio() {
		if (intentos == 0) {
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
}
