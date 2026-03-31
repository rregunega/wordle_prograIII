package juego;
import java.util.Scanner;

public class Principal {
	static int intentos=5;
	static lector_palabras palabras = new lector_palabras();
	
	public static void verificarLetra(String PalabraUsuario,String PalabraMaquina ){
		System.out.println(PalabraMaquina);
		
		for(int indice=0; indice<PalabraUsuario.length(); indice++) {
			
			char usuario=PalabraUsuario.charAt(indice);
			char maquina=PalabraMaquina.toLowerCase().charAt(indice);
			
			if(PalabraMaquina.toLowerCase().contains(String.valueOf(usuario))) {
				
			if(usuario==maquina) { mostrarLetras.mostrarVerde(usuario);
			continue;}
			else {mostrarLetras.mostrarAmarillo(usuario);
			continue;}}
			
			mostrarLetras.mostrarGris(usuario);
			continue;
				
		}    
		}
	


	public static void main(String[] args) {
		
	
	String palabra=palabras.devolverPalabra();
	String entrada;
	Scanner sc=new Scanner(System.in);
	
	while(intentos>0) {
		System.out.println("ingrese una palabra de cinco letras maximo");
		entrada=sc.nextLine();
		
		if(entrada.length()>5 || entrada.length()<1) {
			System.out.println("palabra invalida (muy larga o muy corta\n recuerde que debe ser de 5 letras maximo)");
			continue;
		}
		modificadores.rellenarPalabra(entrada);
		verificarLetra(entrada,palabra);
		intentos-=1;
		
		
	}

	}

}
