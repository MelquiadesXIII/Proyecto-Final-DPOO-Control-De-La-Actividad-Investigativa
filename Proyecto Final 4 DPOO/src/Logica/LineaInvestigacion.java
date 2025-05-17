package Logica;

import java.util.ArrayList;

public class LineaInvestigacion {

	private String nombre;
	private ArrayList<ResultadoInvestigativo> resultados;
	private ArrayList<Investigador> investigadores;

	public String getNombre() {
		return nombre;
	}

	//Implementar
	public int calcularPuntajeInvestigador(Investigador i){
		
		return 0;
	}

	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
						(o instanceof LineaInvestigacion &&
								nombre.equals(((LineaInvestigacion)o).getNombre())));
	}
}
