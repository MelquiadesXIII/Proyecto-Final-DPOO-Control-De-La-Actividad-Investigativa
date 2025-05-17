package Logica;

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
	public void agregarResultado(ResultadoInvestigativo resultado){
		
		
	}
	
	
	
}
