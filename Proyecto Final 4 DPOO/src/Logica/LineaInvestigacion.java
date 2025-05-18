package Logica;

import java.util.ArrayList;

import Excepciones.CadenaNoValidaException;

public class LineaInvestigacion {

	private String nombre;
	private ArrayList<Investigador> investigadores;



	//Constructor
	public LineaInvestigacion(String nombre) {

		setNombre(nombre);
		investigadores = new ArrayList<Investigador>();
	}



	//Getters
	public String getNombre() {
		return nombre;
	}

	public ArrayList<Investigador> getInvestigadores() {
		return investigadores;
	}

	

	//Setters
	public void setNombre(String nombre) {
		
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre de la línea de investigación no puede estar vacio");
		
		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre de la línea de investigación solo puede tener letras y espacios");	
		
		this.nombre = nombre;
	}
	
	
	
	//Metodos
	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
				(o instanceof LineaInvestigacion &&
						nombre.equals(((LineaInvestigacion)o).getNombre())));
	}


}
