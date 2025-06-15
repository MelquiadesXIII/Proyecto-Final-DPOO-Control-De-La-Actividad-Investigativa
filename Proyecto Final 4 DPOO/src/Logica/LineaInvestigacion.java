package Logica;

import java.util.ArrayList;

import Excepciones.CadenaNoValidaException;
import Excepciones.DuplicacionException;
import Excepciones.NoExistenciaException;

public class LineaInvestigacion {

	private String nombre;
	private ArrayList<Investigador> investigadores;
	private Docente responsable;



	//Constructor
	public LineaInvestigacion(String nombre, Docente responsable) {

		setNombre(nombre);
		setResponsable(responsable);
		investigadores = new ArrayList<Investigador>();
	}



	//Getters
	public String getNombre() {
		return nombre;
	}

	public ArrayList<Investigador> getInvestigadores() {
		return investigadores;
	}
	
	public Docente getResponsable() {
		return responsable;
	}



	//Setters
	public void setNombre(String nombre) {

		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre de la línea de investigación no puede estar vacío");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre de la línea de investigación solo puede tener letras y espacios");	

		this.nombre = nombre;
	}
	
	public void setResponsable(Docente responsable){
		
		this.responsable = responsable;
	}
	
	//Metodos
	public void removerInvestigador(Investigador i){
		
		if(i == null)
			throw new NullPointerException("El investigador no puede tener valor null");

		if(!investigadores.contains(i))
			throw new NoExistenciaException("El investigador no está registrado en la línea de investigación");

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



	public boolean contieneInvestigador(Investigador inv) {
		
		return investigadores.contains(inv);
	}

}
