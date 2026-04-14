package juego;

public class Principal {

	public static void main(String[] args) {

		while (true) {
			Partida partida = new Partida();
			partida.intento();

			System.out.println("jugar otra vez?");
		}
	}
}
