package juego;

import java.util.Scanner;

public class Partida {

	boolean gano=false;
	int intentos=5;
	lector_palabras palabras = new lector_palabras();
	String palabra=palabras.devolverPalabra().toLowerCase();
	String entrada;
	Scanner sc;
	
	public Partida() {
		palabra=palabras.devolverPalabra().toLowerCase();
		sc=new Scanner(System.in);
	}
	
	public void intento() {
		
		while(intentos>0 && !gano) {
			System.out.println("ingrese una palabra de cinco letras maximo");
			entrada=sc.nextLine().toLowerCase();
			
			if(!verificarPalabra()) {continue;}
			
			modificadores.rellenarPalabra(entrada);
			
			if(!palabraEQentrada()) {
				ganoJuego();
				return;
			}
			intentos-=1;
		}
		
		if(intentos==0 && !gano){
			perderJuego();
		}	
	}
	
	public static Letra[] verificarLetra(String PalabraUsuario,String PalabraMaquina ){
		Letra[] letras= new Letra[5]; 

		for(int indice=0; indice<PalabraUsuario.length(); indice++) {
			
			char usuario=PalabraUsuario.charAt(indice);
			char maquina=PalabraMaquina.charAt(indice);
			
			if(PalabraMaquina.toLowerCase().contains(String.valueOf(usuario))) {	
			if(usuario==maquina) {
				letras[indice]=new Letra(usuario, Estado.Verde);
				continue;}
			else {	
				letras[indice]=new Letra(usuario, Estado.amarillo);
				continue;}
			}
			
			letras[indice]=new Letra(usuario, Estado.gris);
			continue;
				
		}
		
		return letras;
		}
	

	private boolean palabraEQentrada() {
		if(palabra.toLowerCase().equals(entrada)) {
			this.gano=true;
			return true;
			}
		return false;
	}
	

	private boolean verificarPalabra() {
		if(this.entrada.length()>5 || this.entrada.length()<1) {
			System.out.println("palabra invalida (muy larga o muy corta\n recuerde que debe ser de 5 letras maximo)");
			return false;
		}
		return true;
	}
	
	public void perderJuego() {
		System.out.println("Perdiste: " + palabra.toUpperCase());
	}
	
	
	public static void ganoJuego() {
			System.out.println("Ganaste!");
	}
	
	
}
