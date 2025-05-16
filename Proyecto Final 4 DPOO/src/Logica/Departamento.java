package Logica;

import java.util.ArrayList;

import Excepciones.CadenaNoValidaException;

public class Departamento {

	private String nombre;
	private ArrayList<Docente> docentes;
	private	ArrayList<Estudiante> estudiantes;

	public Departamento(String nombre){

		docentes = new ArrayList<Docente>();
		estudiantes = new ArrayList<Estudiante>();
		
		setNombre(nombre);
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
			throw new CadenaNoValidaException("El nombre del docente no puede estar vacio");

		if(!nombre.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener numeros");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener caracteres especiales o simbolos");	

		this.nombre = nombre;
	}
}
