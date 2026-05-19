package juego;

public class Letra {

	EstadoPalabra estado;
	char letra;

	public Letra(char usuario, EstadoPalabra estado) {
		this.letra = usuario;
		this.estado = estado;
	}
	
	public EstadoPalabra getEstado() {
		return estado;
	}

	public char getLetra() {
		return letra;
	}
	
}
