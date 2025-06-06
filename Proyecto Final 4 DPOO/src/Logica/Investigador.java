package Logica;

import Excepciones.CadenaNoValidaException;
import Excepciones.DuplicacionException;
import Excepciones.ListaVaciaException;
import Excepciones.NoExistenciaException;

import java.util.ArrayList;

public abstract class Investigador {

	protected String nombre;
	protected String apellidos;
	protected ArrayList<ResultadoInvestigativo> resultados;


	
	//Constructor
	public Investigador(String nombre, String apellidos) {

		setNombre(nombre);
		setApellidos(apellidos);
		resultados = new ArrayList<ResultadoInvestigativo>();

	}

	//Getters
	public ArrayList<ResultadoInvestigativo> getResultados() {
		return resultados;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	//Setters
	public void setNombre(String nombre) 
	{
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre no puede estar vacío");
		
		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre solo puede tener letras y espacios");	

		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) 
	{
		if(apellidos.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del docente no puede estar vacío");

		if(!apellidos.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener numeros");

		if(!apellidos.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener caracteres especiales o símbolos");	

		this.apellidos = apellidos;
	}
	
	//Metodos
	public void agregarResultado(ResultadoInvestigativo r){

		if(resultados.contains(r))
			throw new DuplicacionException("El resultado ya se encuentra registrado");

		resultados.add(r);
	}

	public void removerResultado(ResultadoInvestigativo r){

		if(resultados.isEmpty())
			throw new ListaVaciaException("El registro de los resultados investigativos esta vacío");

		if(!resultados.contains(r))
			throw new NoExistenciaException("El resultado investigativo que intenta eliminar no se encuentra registrado");

		resultados.remove(r);
	}
	
	public int calcularPuntajeInvestigativo(){

		int puntaje = 0;

		for (ResultadoInvestigativo r: resultados){

			puntaje += r.aportarPuntaje();
		}

		return puntaje;
	}
	
}
