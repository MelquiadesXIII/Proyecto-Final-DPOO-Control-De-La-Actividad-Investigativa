package Logica;

import java.util.ArrayList;

import Excepciones.CadenaNoValidaException;
import Excepciones.DuplicacionException;
import Excepciones.NoExistenciaException;

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
			throw new CadenaNoValidaException("El nombre de la l�nea de investigaci�n no puede estar vacio");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre de la l�nea de investigaci�n solo puede tener letras y espacios");	

		this.nombre = nombre;
	}



	//Metodos
	public void removerInvestigador(Investigador i){
		
		if(i == null)
			throw new NullPointerException("El investigador no puede tener valor null");

		if(!investigadores.contains(i))
			throw new NoExistenciaException("El investigador no est� registrado en la l�nea de investigaci�n");

		investigadores.remove(i);
	}

	public void agregarInvestigador(Investigador i) {

		if(i == null)
			throw new NullPointerException("El investigador no puede tener valor null");

		if(investigadores.contains(i))
			throw new DuplicacionException("El investigador ya está registrado en la línea de investigación");

		investigadores.add(i);
	}
	
	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
				(o instanceof LineaInvestigacion &&
						nombre.equals(((LineaInvestigacion)o).getNombre())));
	}


}
