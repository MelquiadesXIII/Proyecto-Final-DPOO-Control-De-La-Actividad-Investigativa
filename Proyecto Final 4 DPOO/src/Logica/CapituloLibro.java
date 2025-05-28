package Logica;

import java.util.ArrayList;

import Excepciones.CadenaNoValidaException;

public class CapituloLibro extends ResultadoInvestigativo{

	private String titulo;
	private ArrayList<String> autores;
	private ArrayList<String> nombresEditores;
	private String editorial;
	private String ISSN;
	private String volumen;
	private static int puntos = 3;



	//Constructor
	public CapituloLibro(String titulo, ArrayList<String> autores, ArrayList<String> nombresEditores, String editorial, String iSSN, String volumen) {

		super();

		setTitulo(titulo);
		setAutores(autores);
		setNombresEditores(nombresEditores);
		setEditorial(editorial);
		setISSN(iSSN);
		setVolumen(volumen);
	}


	//Getters
	public String getTitulo() {
		return titulo;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public ArrayList<String> getNombresEditores() {
		return nombresEditores;
	}

	public String getEditorial() {
		return editorial;
	}

	public String getISSN() {
		return ISSN;
	}

	public String getVolumen() {
		return volumen;
	}



	//Setters
	public void setTitulo(String titulo) {

		if(titulo.trim().isEmpty())
			throw new CadenaNoValidaException("El título no puede estar vacío.");

		if(!titulo.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El título solo puede contener letras y espacios.");

		this.titulo = titulo;
	}

	public void setAutores(ArrayList<String> autores) {

		if(autores.isEmpty()) 
			throw new CadenaNoValidaException("La lista de autores no puede estar vacía.");

		for(String autor : autores) {

			if(autor.trim().isEmpty()) 
				throw new CadenaNoValidaException("Un autor no puede estar vacío.");

			if(!autor.matches("^[\\p{L}\\s]+$")) 
				throw new CadenaNoValidaException("Los nombres de los autores solo pueden contener letras y espacios.");
		}

		this.autores = autores;
	}

	public void setNombresEditores(ArrayList<String> nombresEditores) {

		if(nombresEditores.isEmpty()) 
			throw new CadenaNoValidaException("La lista de editores no puede estar vacía.");

		for (String editor : nombresEditores){

			if(editor.trim().isEmpty()) 
				throw new CadenaNoValidaException("Un nombre de editor no puede ser nulo o estar vacío.");

			if(!editor.matches("^[\\p{L}\\s]+$")) 
				throw new CadenaNoValidaException("Los nombres de los editores solo pueden contener letras y espacios.");

		}

		this.nombresEditores = nombresEditores;
	}

	public void setEditorial(String editorial) {

		if(editorial.trim().isEmpty()) 
			throw new CadenaNoValidaException("El nombre de la editorial no puede estar vacío.");

		if(!editorial.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre de la editorial solo puede contener letras y espacios.");

		this.editorial = editorial;
	}

	public void setISSN(String ISSN) {

		if(ISSN.trim().isEmpty())
			throw new CadenaNoValidaException("El ISSN no puede estar vacío.");

		if(!ISSN.matches("\\d+"))
			throw new CadenaNoValidaException("El ISSN debe contener solo dígitos numéricos.");

		if (ISSN.length() != 8)
			throw new CadenaNoValidaException("El ISSN debe tener exactamente 8 dígitos.");

		this.ISSN = ISSN;
	}

	public void setVolumen(String volumen){

		if(volumen.trim().isEmpty()) 
			throw new CadenaNoValidaException("El volumen no puede estar vacío.");

		if (!volumen.matches("\\d+"))
			throw new CadenaNoValidaException("El volumen debe contener solo dígitos numéricos.");

		this.volumen = volumen;
	}


	//Metodos
	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
				(o instanceof CapituloLibro &&
						titulo.equals(((CapituloLibro)o).getTitulo()) &&
						editorial.equals(((CapituloLibro)o).getEditorial()) &&
						ISSN.equals(((CapituloLibro)o).getISSN()) &&
						volumen.equals(((CapituloLibro)o).getVolumen())));
	}

	@Override
	public int aportarPuntaje(){

		return puntos;
	}
}
