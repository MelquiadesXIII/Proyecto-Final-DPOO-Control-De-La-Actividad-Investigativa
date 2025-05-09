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


	/*Aqui debes crear una copia del resultado con new para poder añadir la informacion al array y que persista 
	porque la relacion entre resultado e investigador es de composicion, y antes de hacer eso debes ver que tipo de
	resultado es para mandarle al constructor de las clases hijas los verdaderos atributos q tienen mediante los getters 
	para hacer la copia*/
	public void agregarResultado(ResultadoInvestigativo resultado){
		
		
	}
	
	
	
}
