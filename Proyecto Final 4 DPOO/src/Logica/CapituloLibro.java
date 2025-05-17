package Logica;

import java.util.ArrayList;

public class CapituloLibro extends ResultadoInvestigativo{

	private String titulo;
	private ArrayList<String> autores;
	private ArrayList<String> nombresEditores;
	private String editorial;
	private String ISSN;
	private String nombre;
	private String volumen;
	private static int puntos = 3;
	
	

	//Constructor



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

	public String getNombre() {
		return nombre;
	}

	public String getVolumen() {
		return volumen;
	}

	public static int getPuntos() {
		return puntos;
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
								nombre.equals(((CapituloLibro)o).getNombre()) &&
								volumen.equals(((CapituloLibro)o).getVolumen())));
	}

	@Override
	public int aportarPuntaje(){

		return puntos;
	}
}
