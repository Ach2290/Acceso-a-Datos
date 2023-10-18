package objects;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cancion {
	private int id;
	private String titulo;
	private String artista;
	private double duracion;
	private String album;
	private String letra;
	
	public Cancion(int id, String titulo, String artista, double duracion, String album, String letra) {
		
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
		this.album = album;
		this.letra = letra;
	}
	
	public Cancion() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	
	public void añadir() {
		
		Scanner sc = new Scanner(System.in);
		Cancion c1 = new Cancion();

		try {
			
			FileWriter fw = new FileWriter("canciones.txt", true);
			PrintWriter pw = new PrintWriter(fw, true);

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		System.out.print("Introduzca el nombre de la cancion:");
		
	}
	
	
}
