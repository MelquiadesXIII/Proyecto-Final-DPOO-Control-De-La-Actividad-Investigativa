package Logica;

import java.util.ArrayList;

import Excepciones.CadenaNoValidaException;
import Excepciones.ListaVaciaException;
import Excepciones.NoExistenciaException;

public class Departamento {

	private String nombre;
	private ArrayList<Docente> docentes;
	private	ArrayList<Estudiante> estudiantes;
	private ArrayList<Maestria> maestrias;
	private ArrayList<LineaInvestigacion> lineasInvestigacion;



	//Constructor
	public Departamento(String nombre){

		setNombre(nombre);

		docentes = new ArrayList<Docente>();
		estudiantes = new ArrayList<Estudiante>();
	}

	
	
	//Getters
	public String getNombre() {
		return nombre;
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}


	
	//Setters
	public void setNombre(String nombre) 
	{
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del departamento no puede estar vacio");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del departamento solo puede tener letras y espacios");	

		this.nombre = nombre;
	}



	//Metodos
	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
						(o instanceof Departamento &&
								nombre.equals(((Departamento)o).getNombre())));
	}

	public void removerDocente(Docente d) {

		if(docentes.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover al docente esta vacia");

		if(!docentes.contains(d))
			throw new NoExistenciaException("El docente que desea remover no se encuentra registrado en el vicedecanato");

		docentes.remove(d);

		for(Maestria m: maestrias){

			if(m.getMatriculados().contains(d))
				m.removerMatriculado(d);
		}

		for(LineaInvestigacion l: lineasInvestigacion){ //A implemementar con los investigadores

			if(l.getInvestigadores().contains(d))
				l.removerInvestigador(d);
		}
	}
}
