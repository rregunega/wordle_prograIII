package juego;

public class Partida {

	private boolean gano = false;
	private int intentos = 5;
	private lector_palabras palabras = new lector_palabras();
	private String palabra;
	

	public Partida() {
		this.palabra = palabras.devolverPalabra().toUpperCase();	
	}
	
	public String devolverPalabraSecreta() {
		return this.palabra;
	}

	public void intento() {

		
	}

	public Letra[] verificarLetra(String PalabraUsuario) {
		String PalabraMaquina=this.palabra;
		Letra[] letras = new Letra[5];
		
		for (int indice = 0; indice < PalabraUsuario.length(); indice++) {
			char usuario = PalabraUsuario.charAt(indice);
			char maquina = PalabraMaquina.charAt(indice);
			
				if (usuario == maquina) {
					letras[indice] = new Letra(usuario, EstadoPalabra.CORRECTA);
					PalabraMaquina=PalabraMaquina.replaceFirst(String.valueOf(maquina)," " );
					System.out.println("agregado");
					continue;
				}
		}
		for (int indice = 0; indice < PalabraUsuario.length(); indice++) {
			char usuario = PalabraUsuario.charAt(indice);
			if(letras[indice] != null) {continue;}
			if (PalabraMaquina.contains(String.valueOf(usuario))) {
					letras[indice] = new Letra(usuario, EstadoPalabra.DESPLAZADA);
					PalabraMaquina=PalabraMaquina.replaceFirst(String.valueOf(usuario)," " );
					continue;
				}
			letras[indice] = new Letra(usuario, EstadoPalabra.INCORRECTA);
			continue;
		}
		return letras;
	}

	public boolean palabraEQentrada(String PalabraUsuario) {
		if (palabra.equals(PalabraUsuario)) {
			return true;
		}
		return false;
	}

	public void perderJuego() {
		System.out.println("Perdiste: " + palabra);
	}

	public static void ganoJuego() {
		System.out.println("Ganaste!");
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
