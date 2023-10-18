package mainLectura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//LECTURA DE ARCHIVOS BYTE A BYTE
		
		try {
			
			File archivo = new File("archivo.txt");
			InputStream is = new FileInputStream(archivo);
			long i = archivo.length();
			int byteLeido;
			
			while (i != 0) {
				
				byteLeido = is.read();
				System.out.println((char) byteLeido);
				i--;
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		try {
			
			File archivo = new File("archivo.txt");
			InputStream is = new FileInputStream(archivo);
			byte[] bytesLeidos = new byte[(int) archivo.length()]; //CONVERTIR UN TIPO DE DATO A OTRO
			int byteLeido;
			
			is.read(bytesLeidos);
			
			System.out.println(Arrays.toString(bytesLeidos));
			System.out.println(new String(bytesLeidos));
			
			System.out.println(is.read(bytesLeidos));
			
			is.close();

			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}

}
