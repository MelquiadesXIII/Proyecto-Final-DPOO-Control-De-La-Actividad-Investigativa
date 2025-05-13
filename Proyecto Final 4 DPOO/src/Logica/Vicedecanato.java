package Logica;

import java.util.ArrayList;

public class Vicedecanato {

	private ArrayList<Docente> docentes;
	private ArrayList<Estudiante> estudiantes;
	private ArrayList<Departamento> departamentos;
	
	
	
	//Constructor
	public Vicedecanato()
	{
		docentes = new ArrayList<Docente>();
		estudiantes = new ArrayList<Estudiante>();
		departamentos = new ArrayList<Departamento>();
	}

	
	
	//Getters
	public ArrayList<Docente> getDocentes() 
	{
		return docentes;
	}

	public ArrayList<Estudiante> getEstudiantes() 
	{
		return estudiantes;
	}

	public ArrayList<Departamento> getDepartamentos() 
	{
		return departamentos;
	}
	
	
	
	//Metodos
	public void agregarDocente(Docente d)
	{
		if(docentes.contains(d))
			throw new IllegalArgumentException("El docente ya se encuentra en el vicedecanato");
		
		docentes.add(new Docente(d.getNombre(), d.getApellidos(), d.getCatCientifica(), d.getCatDocente()));
		
		
	}
}
