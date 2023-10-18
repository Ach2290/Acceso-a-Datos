package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraCaracteres {

	public static void main(String[] args) {
		
		try {
			FileWriter fw = new FileWriter("archivo.txt",true); //TRUE PARA NO SOBREESCRIBIR
			PrintWriter pw = new PrintWriter(fw, true); //TRUE PARA AUTOFLUSH
			
			pw.println("Esta es la primera linea");
			pw.println("Esta es la segunda linea");
			pw.println("Esta es la tercera linea");
			
			pw.flush();
			pw.close();
			fw.close();

			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}

}
