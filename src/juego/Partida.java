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
			mostrarLetras(entrada,verificarLetra(entrada,palabra));
			intentos-=1;}
		}
		
		if(intentos==0) {perderJuego();}
		
	}
	
	public static String[] verificarLetra(String PalabraUsuario,String PalabraMaquina ){
		String[] estados= new String[5]; 

		for(int indice=0; indice<PalabraUsuario.length(); indice++) {
			
			char usuario=PalabraUsuario.charAt(indice);
			char maquina=PalabraMaquina.charAt(indice);
			
			if(PalabraMaquina.toLowerCase().contains(String.valueOf(usuario))) {	
			if(usuario==maquina) {
				estados[indice]=Estado.Verde;
				continue;}
			else {	
				estados[indice]=Estado.amarillo;
				continue;}
			}
			
			estados[indice]=Estado.gris;;
			continue;
				
		}
		
		return estados;
		}
	
	private static void mostrarLetras(String entrada, String[] estado) {
		for(int indice=0; indice<entrada.length(); indice++) {
			System.out.println(entrada.charAt(indice)+ " se muestra en = "+ estado[indice]+"\n");
		}
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
	
	public static void perderJuego() {
		System.out.println("perdio");
	}
	
	
	public static void ganoJuego() {
			System.out.println("gano");
	}
	
	
}
