package juego;
import java.util.Scanner;

public class Principal {
	static boolean gano=false;
	static int intentos=5;
	static lector_palabras palabras = new lector_palabras();
	
	public static void perderJuego() {
		System.out.println("perdio");
	}
	
	
	public static void ganoJuego() {
			gano=true;
			System.out.println("gano");
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
	


	public static void main(String[] args) {
		
	
	String palabra=palabras.devolverPalabra().toLowerCase();
	String entrada;
	Scanner sc=new Scanner(System.in);
	
	while(intentos>0 && !gano) {
		System.out.println("ingrese una palabra de cinco letras maximo");
		entrada=sc.nextLine().toLowerCase();
		
		if(entrada.length()>5 || entrada.length()<1) {
			System.out.println("palabra invalida (muy larga o muy corta\n recuerde que debe ser de 5 letras maximo)");
			continue;
		}
		
		modificadores.rellenarPalabra(entrada);
		
		if(palabra.toLowerCase().equals(entrada)) {
			ganoJuego();
			return;}
		mostrarLetras(entrada,verificarLetra(entrada,palabra));
		intentos-=1;
	}
	if(intentos==0) {perderJuego();}
	
	}


}
