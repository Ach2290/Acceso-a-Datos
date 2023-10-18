package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Cancion;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File textocanciones = new File("canciones.txt");
		ArrayList<Cancion> canciones = new ArrayList<>();

		try {

			if (!textocanciones.exists()) {
				System.out.println("Creando archivo...");
				textocanciones.createNewFile();
			}

			FileReader fr = new FileReader("canciones.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea= "4";
			String atributos[];
			boolean repetir = true;
			while ((linea = br.readLine()) != null) {

				Cancion nueva = new Cancion(); 
				atributos = linea.split(","); 
				
				nueva.setId(Integer.parseInt(atributos[0])); 
				nueva.setArtista(atributos[1]);
				nueva.setAlbum(atributos[2]);
				nueva.setDuracion(Double.parseDouble(atributos[3]));
				nueva.setTitulo(atributos[4]);
				nueva.setLetra(atributos[5]);

				canciones.add(nueva);

			}
			do {

				System.out.println(
						"\n1, Ver canciones que hay guardadas \n2, Añade una cancion \n3, Modifica una cancion \n4, Borra una cancion, \n5 Salir");

				int opciones = sc.nextInt();
				sc.nextLine();
				switch (opciones) {
				case 1:
					System.out.println("Canciones: ");

					for (int i = 0; i < canciones.size(); i++) {

						System.out.println(canciones.get(i).getId() + ", " + canciones.get(i).getArtista() + ", "
								+ canciones.get(i).getAlbum() + ", " + canciones.get(i).getDuracion() + ", "
								+ canciones.get(i).getTitulo() + ", " + canciones.get(i).getLetra());

					}
					break;
				case 2:
					añadir(canciones);
					
					break;

				case 3:
					modificar(canciones);
					
					
					break;
				case 4:
					borrar(canciones);
					
					break;
				case 5:
					repetir = false;
					

				}

			} while (repetir == true);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void añadir(ArrayList<Cancion> canciones) {
		Scanner sc = new Scanner(System.in);
		FileWriter fw;
		try {
			fw = new FileWriter("canciones.txt",true);
			PrintWriter pw = new PrintWriter(fw, true);
			Cancion nueva = new Cancion();
			int id = 1;

			for (int i = 0; i < canciones.size(); i++) {
				id++;
			}
			nueva.setId(id);
			System.out.println("introduce el titulo de la cancion");
			String Titulo = sc.nextLine();

			nueva.setTitulo(Titulo);

			System.out.println("Intrdce el nombre del artista");
			String Artista = sc.nextLine();

			nueva.setArtista(Artista);

			System.out.println("Introduce el nombre del album");
			String Album = sc.nextLine();

			nueva.setAlbum(Album);

			double Duracion = 0;
			do {
				System.out.println("Introduce la duracion de la cancion en minutos");
				Duracion = sc.nextDouble();
				sc.nextLine();

			} while (Duracion < 0 || Duracion >= 600);

			nueva.setDuracion(Duracion);

			nueva.setLetra(Titulo + ".txt");

			canciones.add(nueva);

			File letra = new File(nueva.getLetra());
			letra.createNewFile();

			pw.println(nueva.getId() + "," + nueva.getArtista() + "," + nueva.getAlbum() + "," + nueva.getDuracion()
					+ "," + nueva.getTitulo() + "," + nueva.getLetra());

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void modificar(ArrayList<Cancion> canciones) {

		Scanner sc = new Scanner(System.in);
		FileWriter fw;
		try {
			fw = new FileWriter("canciones.txt");
			PrintWriter pw = new PrintWriter(fw, true);

			System.out.println("Selecciona la cancion que quieres modificar");

			for (int i = 0; i < canciones.size(); i++) {

				System.out.println(canciones.get(i).getId() + ", " + canciones.get(i).getArtista() + ", "
						+ canciones.get(i).getAlbum() + ", " + canciones.get(i).getDuracion() + ", "
						+ canciones.get(i).getTitulo()+canciones.get(i).getLetra());

			}
			int seleccion = sc.nextInt();
			sc.nextLine();

			System.out.println("Selecciona la parte que quieres modificar");
			System.out.println("1 CAMBIAR ARTISTA");
			System.out.println("2 cAMBIAR ALBUM");
			System.out.println("3 CAMBIAR DURACION");
			System.out.println("4 CAMBIAR TITULO");

			int eleccion = sc.nextInt();
			sc.nextLine();
			switch (eleccion) {
			case 1:
				System.out.println("Nuevo Artista");
				String NuevoArtista = sc.nextLine();
				canciones.get(seleccion - 1).setArtista(NuevoArtista);

				break;
			case 2:
				System.out.println("Nuevo Album");
				String NuevoAlbum = sc.nextLine();
				canciones.get(seleccion - 1).setAlbum(NuevoAlbum);
				break;
			case 3:
				System.out.println("Nueva Duracion de la cancion");
				int NuevoDuracion = sc.nextInt();
				canciones.get(seleccion - 1).setDuracion(NuevoDuracion);
				;
				break;
			case 4:
				System.out.println("Nuevo Titulo de la Cancion");
				String NUevoTitulo = sc.nextLine();
				canciones.get(seleccion - 1).setTitulo(NUevoTitulo);
				break;

			}
			for (int i = 0; i < canciones.size(); i++) {

				System.out.println(canciones.get(i).getId() + ", " + canciones.get(i).getArtista() + ", "
						+ canciones.get(i).getAlbum() + ", " + canciones.get(i).getDuracion() + ", "
						+ canciones.get(i).getTitulo()+canciones.get(i).getLetra());

			}
			for (int i = 0; i < canciones.size(); i++) {
				
				pw.println(canciones.get(i).getId() + "," + canciones.get(i).getArtista() + "," + canciones.get(i).getAlbum() + "," + canciones.get(i).getDuracion()
				+ "," + canciones.get(i).getTitulo() + "," + canciones.get(i).getLetra());
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void borrar(ArrayList<Cancion> canciones) {

		Scanner sc = new Scanner(System.in);
		FileWriter fw;
		try {
			fw = new FileWriter("canciones.txt");
			PrintWriter pw = new PrintWriter(fw, true);
			System.out.println("Selecciona la cancion que quieres borrar");

			for (int i = 0; i < canciones.size(); i++) {

				System.out.println(canciones.get(i).getId() + ", " + canciones.get(i).getArtista() + ", "
						+ canciones.get(i).getAlbum() + ", " + canciones.get(i).getDuracion() + ", "
						+ canciones.get(i).getTitulo()+canciones.get(i).getLetra());
			}
			int borrar = sc.nextInt();
			canciones.remove(borrar - 1);
			
			for (int i = 0; i < canciones.size(); i++) {
				
				pw.println(canciones.get(i).getId() + "," + canciones.get(i).getArtista() + "," + canciones.get(i).getAlbum() + "," + canciones.get(i).getDuracion()
				+ "," + canciones.get(i).getTitulo() + "," + canciones.get(i).getLetra());
			}
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
