package Logica;

import java.util.ArrayList;

public abstract class Investigador {

	protected ArrayList<ResultadoInvestigativo> resultados;


	//Constructor
	public Investigador() {

		resultados = new ArrayList<ResultadoInvestigativo>();

	}

	//Get
	public ArrayList<ResultadoInvestigativo> getResultados() {
		return resultados;
	}
	//
	
	public void agregarResultado(ResultadoInvestigativo r){
		
		getResultados().add(r);
	}
	
	
	
}
