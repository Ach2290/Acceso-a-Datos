package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainEscritura {

	public static void main(String[] args) {

		File archivoDestino = new File("archivoEscrito.txt");
		OutputStream os;
		byte[] bytesEscribir = "Esto se va a escribir".getBytes();

		try {

			if (!archivoDestino.exists()) {
				System.out.println("Creando archivo...");
				archivoDestino.createNewFile();				
			}
			
			//SI USAMOS TRUE COMO SEGUNDO ARGUMENTO ENTONCES SE AÑADE AL FINAL DEL ARCHIVO.
			//EN CASO CONTRARIO SE SOBREESCRIBE.
			os = new FileOutputStream(archivoDestino,true);
			
			os.write(49);  //os.write((int) '1')
			os.write(50);
			os.write(51);
			os.write(bytesEscribir);
			
			os.flush();
			os.close();

		} catch (IOException e) {
			
			System.out.println("NO se pudo crear el archivo");		
			
		}

	}

}
