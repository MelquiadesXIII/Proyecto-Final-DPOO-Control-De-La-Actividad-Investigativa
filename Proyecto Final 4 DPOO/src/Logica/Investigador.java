package Logica;

import Excepciones.DuplicacionException;
import Excepciones.ListaVaciaException;
import Excepciones.NoExistenciaException;

import java.util.ArrayList;

public abstract class Investigador {

	protected ArrayList<ResultadoInvestigativo> resultados;


	
	//Constructor
	public Investigador() {

		resultados = new ArrayList<ResultadoInvestigativo>();

	}

	//Getters
	public ArrayList<ResultadoInvestigativo> getResultados() {
		return resultados;
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
