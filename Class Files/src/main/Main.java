package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		
		if (Files.exists(Path.of("test.txt"))){
			
			System.out.println("El archivo 'test.txt' ya existe");
			
		}else {
			
			try {
				
				Files.createFile(Path.of("test.txt"));
				System.out.println("Archivo creado con exito.");
				
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		System.out.println("Creando archivo en Escritorio...");
		
		try {
			
			Files.copy(Path.of("test.txt"), Path.of("/Users/Alumno/Desktop/test - copia.txt"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
