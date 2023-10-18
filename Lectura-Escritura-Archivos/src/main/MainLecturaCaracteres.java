package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainLecturaCaracteres {

	public static void main(String[] args) {

		try {

			FileReader fr = new FileReader("archivo.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
			
			br.close();
			fr.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
