package main;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		File archivo = new File("test.txt");
		File padre = archivo.getParentFile();
		File creado = new File("creado.txt");
		File carpeta = new File(".");
		File[] hijos = carpeta.listFiles();
		long tamano = 0;
		
		if (creado.exists()){
			
			System.out.println("El archivo ya existe");
			
		}else {
			
			System.out.println("El archivo no existe. Creando...");
			
			try {
				
				creado.createNewFile();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		System.out.println("Ruta absoluta de test.txt: " + archivo.getAbsolutePath());
		System.out.println("El archivo test.txt es un directorio? " + (archivo.isDirectory()? "si" : "no") );
		System.out.println("El aarchivo se puede ejecutar? " + (archivo.canExecute()? "si" : "no"));
		System.out.println("El aarchivo esta oculto? " + (archivo.isHidden()? "si" : "no")); 
		System.out.println("El archivo ocupa " + archivo.length()+ " bytes");
		
		if (creado.delete()) {
			
			System.out.println("Archivo eliminado con exito.");
			
		}else {
			
			System.out.println("Archivo no eliminado.");
		}
		
		System.out.println("Crapeta el proyecto " + carpeta.getAbsolutePath());
		
		
		//CALCULAR EL TAMAÑO QUE OCUPAN TODAS LAS ARCHIVOS
		
		for(File f : hijos) {
			
			tamano += f.length(); 
		}
		
		System.out.println("Los archivos de la carpeta ocupan " + tamano + " bytes.");

	}

}
