package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Excepciones.DuplicacionException;
import Excepciones.ListaVaciaException;
import Excepciones.NoExistenciaException;

public class Vicedecanato {

	private ArrayList<Docente> docentes;
	private ArrayList<Estudiante> estudiantes;
	private ArrayList<Departamento> departamentos;
	private static Vicedecanato vicedecanato;



	//Constructor
	private Vicedecanato()
	{
		docentes = new ArrayList<Docente>();
		estudiantes = new ArrayList<Estudiante>();
		departamentos = new ArrayList<Departamento>();
	}



	//Getters
	public static Vicedecanato getVicedecanato(){

		if(vicedecanato == null)
			vicedecanato = new Vicedecanato();

		return vicedecanato; 
	}
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
			throw new DuplicacionException("El estudiante ya se encuentra en el vicedecanato");

		estudiantes.add(e);
	}

	public void agregarDepartamento(Departamento d)
	{
		if(departamentos.contains(d))
			throw new DuplicacionException("El departamento ya se encuentra en el vicedecanato");

		departamentos.add(d);
	}

	public void removerDocente(Docente d){

		if(docentes.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover al docente esta vacía");

		if(!docentes.contains(d))
			throw new NoExistenciaException("El docente que desea remover no se encuentra registrado en el vicedecanato");

		docentes.remove(d);

		for(Departamento depto: departamentos){

			if(depto.getDocentes().contains(d))
				depto.removerDocente(d);
		}
	}

	public void removerEstudiante(Estudiante e) {

		if(estudiantes.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover al estudiante esta vacía");

		if(!estudiantes.contains(e))
			throw new NoExistenciaException("El estudiante que desea remover no se encuentra registrado en el vicedecanato");

		estudiantes.remove(e);

		for(Departamento depto: departamentos) {

			if(depto.getEstudiantes().contains(e))
				depto.removerEstudiante(e);
		}
	}

	public void removerDepartamento(Departamento d) {

		if(departamentos.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover el departamento esta vacía");

		if(!departamentos.contains(d))
			throw new NoExistenciaException("El departamento que desea remover no se encuentra registrado en el vicedecanato");

		departamentos.remove(d);
	}

	public boolean darVistoBuenoMaestria(Maestria m, Docente d) {

		if(!m.contieneMatriculado(d))
			throw new NoExistenciaException("El docente no se encuentra matriculado en la maestría");

		return d.getCreditosObtenidosCursosRecibidos() >= m.getCreditosTotalesCursos();
	}

	public void generarDatosReporte1(ArrayList<Investigador> ranking, Departamento depto){

		ranking.clear();

		for(LineaInvestigacion l: depto.getLineasInvestigacion()){
			for(Investigador i: l.getInvestigadores()){

				ranking.add(i);

			}
		}

		Collections.sort(ranking, new Comparator<Investigador>() {
			@Override
			public int compare(Investigador i1, Investigador i2) {
				return Integer.compare(i2.calcularPuntajeInvestigativo(), i1.calcularPuntajeInvestigativo());

			}
		});
	}

	public void crearDocente(String nombre, String apellidos, CategoriaCientifica catCientifica, CategoriaDocente catDocente, Departamento depto){

		Docente d = new Docente(nombre, apellidos, catCientifica, catDocente);

		agregarDocente(d);
		depto.agregarDocente(d);
	}

	public void crearEstudiante(String nombre, String apellidos, String grupo, Departamento depto){

		Estudiante e = new Estudiante(nombre, apellidos, grupo);

		agregarEstudiante(e);
		depto.agregarEstudiante(e);
	}

	public void crearDepartamento(String nombre){

		Departamento depto = new Departamento(nombre);

		agregarDepartamento(depto);
	}

	public boolean solicitudValidaIngresoDocenteADepartamento(Docente d){

		boolean noContenido = true;

		int i = 0;
		while(i < departamentos.size() && noContenido){

			if(departamentos.get(i).contieneDocente(d))
				noContenido = false;

			i++;
		}

		return noContenido;
	}

	public boolean solicitudValidaIngresoEstudianteADepartamento(Estudiante e){

		boolean noContenido = true;

		int i = 0;
		while(i < departamentos.size() && noContenido){

			if(departamentos.get(i).contieneEstudiante(e))
				noContenido = false;

			i++;
		}

		return noContenido;
	}
}
