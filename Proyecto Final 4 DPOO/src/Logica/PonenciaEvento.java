package Logica;

public class PonenciaEvento extends ResultadoInvestigativo{

	private String nombre;
	private String anio;
	private String fecha;
	private String lugar;
	private String ISBN;
	private static int puntos = 1;
	
	

	//Constructor



	//Getters
	public static int getPuntos() {
		return puntos;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getLugar() {
		return lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public String getAnio() {
		return anio;
	}

	public String getNombre() {
		return nombre;
	}



	//Setters



	//Metodos
	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
						(o instanceof PonenciaEvento &&
								nombre.equals(((PonenciaEvento)o).getNombre()) &&
								anio.equals(((PonenciaEvento)o).getAnio()) &&
								fecha.equals(((PonenciaEvento)o).getFecha()) &&
								lugar.equals(((PonenciaEvento)o).getLugar()) &&
								ISBN.equals(((PonenciaEvento)o).getISBN())));
	}

	@Override
	public int calcularPuntaje(){

		return puntos;
	}
}
