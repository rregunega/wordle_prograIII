package juego;

public enum EstadoPalabra {
	CORRECTA,    // Verde (Letra correcta, posición correcta)
    DESPLAZADA,  // Amarillo (Letra existe, pero en otra posición)
    INCORRECTA   // Gris (No existe en la palabra)
}
