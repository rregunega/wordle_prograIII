package juego;

public enum Idioma {
	ESPANOL("Español", "ES"),
	INGLES("English", "EN");

	private String nombre;
	private String codigo;

	private Idioma(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String toString() {
		return nombre;
	}
}
