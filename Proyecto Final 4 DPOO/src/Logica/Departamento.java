package Logica;

import java.util.ArrayList;

import Excepciones.CadenaNoValidaException;
import Excepciones.DuplicacionException;
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
		maestrias = new ArrayList<Maestria>();
		lineasInvestigacion = new ArrayList<LineaInvestigacion>();
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

	public ArrayList<Maestria> getMaestrias() {
		return maestrias;
	}

	public ArrayList<LineaInvestigacion> getLineasInvestigacion() {
		return lineasInvestigacion;
	}



	//Setters
	public void setNombre(String nombre) 
	{
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del departamento no puede estar vac�o");

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
			throw new ListaVaciaException("La lista de la que desea remover al docente esta vac�a");

		if(!docentes.contains(d))
			throw new NoExistenciaException("El docente que desea remover no se encuentra registrado en el vicedecanato");

		docentes.remove(d);

		for(Maestria m: maestrias){

			if(m.getMatriculados().contains(d))
				m.removerMatriculado(d);
		}

		for(LineaInvestigacion l: lineasInvestigacion){

			if(l.getInvestigadores().contains(d))
				l.removerInvestigador(d);
		}
	}

	public void agregarDocente(Docente d){

		if(d == null)
			throw new NullPointerException("El docente matriculado no puede tener valor null");

		if(docentes.contains(d))
			throw new DuplicacionException("El profesor no se puede agregar porque ya se encuentra presente en el departamento");

		docentes.add(d);
	}

	public void removerEstudiante(Estudiante e) {

		if(estudiantes.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover al estudiante esta vac�a");

		if(!estudiantes.contains(e))
			throw new NoExistenciaException("El estudiante que desea remover no se encuentra registrado en el departamento");

		estudiantes.remove(e);

		for(LineaInvestigacion l: lineasInvestigacion){

			if(l.getInvestigadores().contains(e))
				l.removerInvestigador(e);
		}
	}

	public void agregarEstudiante(Estudiante e){

		if(e == null)
			throw new NullPointerException("El estudiante no puede tener valor null");

		if(estudiantes.contains(e))
			throw new DuplicacionException("El estudiante no se puede agregar porque ya se encuentra presente en el departamento");

		estudiantes.add(e);
	}

	public void agregarMaestria(Maestria m) {

		if(m == null)
			throw new NullPointerException("La maestr�a no puede tener valor null");

		if(maestrias.contains(m))
			throw new DuplicacionException("La maestr�a no se puede agregar porque ya se encuentra registrada en el vicedecanato");

		maestrias.add(m);
	}

	public void agregarLineaInvestigacion(LineaInvestigacion l) {

		if(l == null)
			throw new NullPointerException("La l�nea de investigaci�n no puede tener valor null");

		if(lineasInvestigacion.contains(l))
			throw new DuplicacionException("La l�nea de investigaci�n no se puede agregar porque ya se encuentra registrada en el vicedecanato");

		lineasInvestigacion.add(l);
	}

	public void removerLineaInvestigacion(LineaInvestigacion l) {

		if(lineasInvestigacion.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover la l�nea de investigaci�n est� vac�a");

		if(!lineasInvestigacion.contains(l))
			throw new NoExistenciaException("La l�nea de investigaci�n que desea remover no se encuentra registrada en el departamento");

		lineasInvestigacion.remove(l);
	}

	public void removerMaestria(Maestria m) {

		if(maestrias.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover la maestr�a est� vac�a");

		if(!maestrias.contains(m))
			throw new NoExistenciaException("La maestr�a que desea remover no se encuentra registrada en el departamento");

		maestrias.remove(m);
	}
	
	@Override
    public String toString() {
        return this.nombre; 
    }
}
