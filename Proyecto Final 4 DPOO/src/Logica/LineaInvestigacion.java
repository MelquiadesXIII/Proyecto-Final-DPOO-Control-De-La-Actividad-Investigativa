package Logica;

import java.util.ArrayList;

public class LineaInvestigacion {

	private String nombre;
	private ArrayList<ResultadoInvestigativo> resultados;
	private ArrayList<Investigador> investigadores;



	//Constructor



	//Getters
	public String getNombre() {
		return nombre;
	}



	//Metodos
	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
						(o instanceof LineaInvestigacion &&
								nombre.equals(((LineaInvestigacion)o).getNombre())));
	}
}
