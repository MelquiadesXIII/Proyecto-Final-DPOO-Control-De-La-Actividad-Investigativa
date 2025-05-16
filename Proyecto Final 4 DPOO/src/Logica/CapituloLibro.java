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
	
	
	@Override
	public int calcularPuntaje(){
		
		return puntos;
	}
}
