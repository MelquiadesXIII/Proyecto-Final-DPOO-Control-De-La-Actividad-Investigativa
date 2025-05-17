package Logica;

import java.util.ArrayList;

import Complementos.DocenteUtils;
import Excepciones.DuplicacionException;
import Excepciones.ListaVaciaException;
import Excepciones.NoExistenciaException;

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
			throw new DuplicacionException("El docente ya se encuentra en el vicedecanato");
		
		docentes.add(d);
	}

	public void agregarEstudiante(Estudiante e)
	{
		if(estudiantes.contains(e))
			throw new DuplicacionException("El docente ya se encuentra en el vicedecanato");

		estudiantes.add(e);
	}

	public void agregarDepartamento(Departamento d)
	{
		if(departamentos.contains(d))
			throw new DuplicacionException("El docente ya se encuentra en el vicedecanato");

		departamentos.add(d);
	}

	public void removerDocente(Docente d){

		if(docentes.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover al docente esta vacia");

		if(!docentes.contains(d))
			throw new NoExistenciaException("El docente que desea remover no se encuentra registrado en el vicedecanato");

		docentes.remove(d);

		for(Departamento depto: departamentos){

			if(depto.getDocentes().contains(d))
				depto.removerDocente(d);
		}
	}
}
