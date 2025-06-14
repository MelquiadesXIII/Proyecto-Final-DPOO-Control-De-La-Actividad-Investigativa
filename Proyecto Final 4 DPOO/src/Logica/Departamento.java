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
			throw new NoExistenciaException("El docente que desea remover no se encuentra registrado");

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
			throw new DuplicacionException("El profesor ya se encuentra presente en el departamento");

		docentes.add(d);
	}

	public void removerEstudiante(Estudiante e) {

		if(estudiantes.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover al estudiante esta vac�a");

		if(!estudiantes.contains(e))
			throw new NoExistenciaException("El estudiante que desea remover no se encuentra registrado");

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
			throw new DuplicacionException("El estudiante ya se encuentra presente en el departamento");

		estudiantes.add(e);
	}

	public void agregarMaestria(Maestria m) {

		if(m == null)
			throw new NullPointerException("La maestr�a no puede tener valor null");

		if(maestrias.contains(m))
			throw new DuplicacionException("La maestr�a ya se encuentra registrada en el departamento");

		maestrias.add(m);
	}

	public void agregarLineaInvestigacion(LineaInvestigacion l) {

		if(l == null)
			throw new NullPointerException("La l�nea de investigaci�n no puede tener valor null");

		if(lineasInvestigacion.contains(l))
			throw new DuplicacionException("La l�nea de investigaci�n ya se encuentra registrada en el departamento");

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

	public boolean solicitudValidaIngresoDocenteAMaestria(Docente d){

		boolean noContenido = true;

		int i = 0;
		while(i < maestrias.size() && noContenido){

			if(maestrias.get(i).contieneMatriculado(d))
				noContenido = false;

			i++;
		}

		return noContenido;
	}

	public boolean contieneDocente(Docente d){

		return docentes.contains(d);
	}

	public boolean contieneEstudiante(Estudiante e){

		return estudiantes.contains(e);
	}

	@Override
	public String toString() {
		return this.nombre; 
	}
	
	public void crearMaestria(String nombre, String campoEstudio, int duracionMeses){
		
		Maestria m = new Maestria(nombre, duracionMeses, campoEstudio);
		
		agregarMaestria(m);
	}
	
	public void crearLineaInvestigacion(String nombre, Docente responsable){
		
		LineaInvestigacion l = new LineaInvestigacion(nombre, responsable);
		
		agregarLineaInvestigacion(l);
	}
	
	public boolean solicitudValidaIngresoInvestigadorALineaDeInvestigacion(Investigador inv){
		
		boolean noContenido = true;

		int i = 0;
		while(i < lineasInvestigacion.size() && noContenido){

			if(lineasInvestigacion.get(i).contieneInvestigador(inv))
				noContenido = false;

			i++;
		}

		return noContenido;
	}
	
	public ArrayList<Investigador> obtenerInvestigadoresNoRegistradosLineasDeInvestigacion(){
		
		ArrayList<Investigador> noRegistrados = new ArrayList<>();
		
		for(Docente d: docentes){
			
			if(solicitudValidaIngresoInvestigadorALineaDeInvestigacion(d)){
				noRegistrados.add(d);
			}
		}
		
		for(Estudiante e: estudiantes){
			
			if(solicitudValidaIngresoInvestigadorALineaDeInvestigacion(e)){
				noRegistrados.add(e);
			}
		}
		
		return noRegistrados;
	}
	
	public boolean solicitudValidaMatriculaMaestria(Docente d){
		
		boolean noContenido = true;

		int i = 0;
		while(i < maestrias.size() && noContenido){

			if(maestrias.get(i).contieneMatriculado(d))
				noContenido = false;

			i++;
		}

		return noContenido;
	}
}
