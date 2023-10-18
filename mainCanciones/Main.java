package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static 
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;
		boolean salir;
		boolean error;
		
		do {
			error=false;
			salir=true;
			System.out.println("Menu:");
			System.out.println("(1) Aniadir cancion nueva");
			System.out.println("(2) Borrar cancion");
			System.out.print("(3) Modificar cancion\n>> ");
			try {
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion) {
			case 1: 
				File canciones = new File("canciones.txt");
				FileReader fr;
				BufferedReader br;
				int id=1;

				if(!canciones.exists()) {
					try {
						canciones.createNewFile();
					} catch (IOException e) {
						System.err.println("ERROR. NO SE PUDO CREAR \""+canciones.getPath()+"\".");
					}
				}
				
				try {
					fr = new FileReader(canciones);
					br = new BufferedReader(fr);
					String linea;
					while((linea=br.readLine())!=null) {
						id++;
					}
					
				} catch (FileNotFoundException e) {
					System.err.println("ERROR. ARCHIVO NO ENCONTRADO.");
				} catch (IOException e) {
					System.err.println("ERROR. NO SE PUDO LEER EL ARCHVIVO.");
				}
				
				aniadirCancion(canciones,id);
				break;
			case 2: 
				break;
			case 3: 
				break;
				default:
					error=true;
			}
			
			}catch(InputMismatchException ex) {
				sc.nextLine();
				error=true;
			}
			
			if(error) {
				salir=false;
				System.err.println("ERROR. OPCION INCORRECTA.");
			}
			
			
		}while(!salir);
		
	}
	
	public static void aniadirCancion(File archivo,int id) {
		File lyricsTxt;
		boolean salir;
		String titulo;
		String artista;
		int duracionMin=0;
		String album;
		System.out.println("NUEVA CANCION");
		System.out.print("Titulo: ");
		titulo = sc.nextLine();
		
		
		lyricsTxt = new File(titulo+"_lyrics.txt");
		
		System.out.print("Artista: ");
		artista = sc.nextLine();
		
		do {
			salir=true;
		try {
		System.out.print("Duracion (min): ");
		duracionMin = sc.nextInt();
		sc.nextLine();
		}catch(InputMismatchException ex) {
			sc.nextLine();
			salir=false;
			System.err.println("ERROR. NUMERO INCORRECTO.");
		}
		}while(!salir);
		
		System.out.print("Album: ");
		album = sc.nextLine();
		
		aniadirLyrics(lyricsTxt);
		
		FileWriter fw;
		PrintWriter pw;
		
		try {
			fw = new FileWriter(archivo,true);
			pw = new PrintWriter(fw);
			
			pw.println(id+","+titulo+","+artista+","+duracionMin+","+album+","+lyricsTxt.getPath());
			pw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println("ERROR. NO SE PUDO ESCRIBIR EN EL ARCHIVO.");
		}
		
		
		
	}
	
	public static void aniadirLyrics(File lyricsTxt) {
		String lyrics;
		FileWriter fw;
		PrintWriter pw;
		System.out.print("Lyrics: ");
		lyrics = sc.nextLine();
		
		if(!lyricsTxt.exists()) {
			try {
				lyricsTxt.createNewFile();
				
			} catch (IOException e) {
				System.err.println("ERROR. NO SE PUDO CREAR \""+lyricsTxt.getPath()+"\".");
			}
		}
		

		try {
			fw = new FileWriter(lyricsTxt);
			pw = new PrintWriter(fw);
			pw.println(lyrics);
			pw.flush();
			pw.close();
			fw.close();
			
		} catch (IOException e) {
			System.err.println("ERROR. NO SE PUDO ESCRIBIR EN EL ARCHIVO.");
		}
		
		
	}

}
