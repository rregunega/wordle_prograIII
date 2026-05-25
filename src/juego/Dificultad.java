package juego;

public enum Dificultad {
	FACIL("Facil", 6), DIFICIL("Dificil", 4);

	private String nombre;
	private int intentos;

	private Dificultad(String nombre, int intentos) {
		this.nombre = nombre;
		this.intentos = intentos;
	}

	public String getNombre() {
		return nombre;
	}

	public int getIntentos() {
		return intentos;
	}

	public String toString() {
		return nombre;
	}

}
