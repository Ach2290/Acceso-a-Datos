package Ejercicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//HACER UN PROGRAMA QUE LEA BYTE A BYTE UN ARCHIVO Y MUESTRE AL FINAL EL RECUENTO DE LETRAS DE ESTE ARCHIVO [A-Z a-z]
		
		try {

			File archivo = new File("archivo.txt");
			InputStream is = new FileInputStream(archivo);
			long i = archivo.length();
			int byteLeido;
			int total = 0;

			while (i != 0) {

				byteLeido = is.read();

				if (((char) byteLeido >= 'A' && (char) byteLeido <= 'Z') || ((char) byteLeido >= 'a' && (char) byteLeido <= 'z')) {
					
					total++;
				}

				i--;

			}

			System.out.println("Hay " + total + " letras en el archivo");

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//PEDIR AL USUARIO UNA CADENA Y CONTAR CUANTAS VECES ESTÁ ESTA EN EL ARCHIVO
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca una cadena: ");
		String cadena = sc.nextLine();
		
		cadena.charAt(0);
		
		
		
		
		
		

	}

}
