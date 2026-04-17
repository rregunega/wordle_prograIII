package juego;

public class Letra {

	String estado;
	char letra;

	public Letra(char usuario, String estado) {
		this.letra = usuario;
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}

	public char getLetra() {
		return letra;
	}
	
}
