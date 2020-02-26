package javaapplication4;
import java.util.Scanner;

public class InicioApp {

	
	final String TEXTO_LETRAS= "Las letras que se repiten son:";
	final String TEXTO_PALABRAS= "Se han ingresado ";
	final String TEXTO_FINAL_PALABRAS= " palabras.";
	final String TEXTO_TOTAL_CARACTERES_SIN_BLANCOS= "Se han introducido un total de ";
	final String TEXTO_FINAL_TOTAL_CARACTERES_SIN_BLANCOS= " caracteres(sin contar los blancos).";
	static final String TEXTO_PEDIR_CADENA= "Introduzca un conjunto de caracteres:";
				
	public static int contarCaracteresTotal(String cadena) {
		int contador = 0;
		char car;
		
		for (int i = 0; i < cadena.length(); i++) {
			car = cadena.charAt(i);
			if (car != ' ')
				contador++;
		}
		return contador;
	}
	public static int contarNumeroPalabras(String cadena) {
		int palabras = 1;
		char car;
		
		 for (int i = 0; i < cadena.length(); i++) {
			 car = cadena.charAt(i);
			 if (car == ' ')
				 palabras++;
		 }
		 
		 if (cadena.trim().compareTo("")==0)
			 palabras = 0;
		return palabras;
	}
	
	public static String textoCaracteresTotal (int total) {
		String s;
		s = "el numero de caracteres es "+ total;
		return s;
	}
	
	public static String textoNumeroPalabras(int total) {
		String s;
		s = "el numero de palabras es " + total;
		return s;
	}
	
	public static int[ ] contarTodosCaracteres(String cadena) {
		int [] contador = new int[65536];
		for (int i = 0;i<cadena.length();i++){ //recorro la cadena
			char car = cadena.charAt(i); //obtengo el valor de la posición de i en la cadena
			int ascii = car; //¿Esto qué es?
			contador[ascii]++; //añado uno al contador de ese caracter
 		}
		return contador;
	}
	public static String textoTodosCaracteres (int [] contador) {
		String resultado ="";
		for (int i = 0;i<contador.length;i++) { //Recorro el array y muestro todo.
			char guardar = (char) i;
			if (contador[i]>0 && guardar != ' ') {
				if (contador[i]==1)
					resultado += ""+guardar+ "-->" + contador[i] + " vez.\n";
				else
					resultado += ""+guardar+ "-->" + contador[i] + " veces.\n";
			}
		}
		System.out.println(resultado);
		return resultado;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(TEXTO_PEDIR_CADENA);
		String cadena = scan.nextLine().trim();
		
		int caracteres = contarCaracteresTotal(cadena);
		System.out.println (textoCaracteresTotal(caracteres));
		int palabra = contarNumeroPalabras(cadena);
		System.out.println (textoNumeroPalabras(palabra));
		
		
		int [] contador = contarTodosCaracteres(cadena);
		textoTodosCaracteres(contador);
		
		
		scan.close();
	
	}

}