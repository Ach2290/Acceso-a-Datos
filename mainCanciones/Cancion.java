package main;

public class Cancion {
	private int id;
	private String titulo;
	private String artista;
	private int duracionMin;
	private String album;
	private String path_archivo;
	
	public Cancion(int id, String titulo, String artista, int duracionMin, String album, String path_archivo) {
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.duracionMin = duracionMin;
		this.album = album;
		this.path_archivo = path_archivo;
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

	public int getDuracionMin() {
		return duracionMin;
	}

	public void setDuracionMin(int duracionMin) {
		this.duracionMin = duracionMin;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getPath_archivo() {
		return path_archivo;
	}

	public void setPath_archivo(String path_archivo) {
		this.path_archivo = path_archivo;
	}
	
	
}
