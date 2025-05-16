package Logica;

public class PonenciaEvento extends ResultadoInvestigativo{

	private String nombre;
	private String anio;
	private String fecha;
	private String lugar;
	private String ISBN;
	private static int puntos = 1;
	
	
	@Override
	public int calcularPuntaje(){
		
		return puntos;
	}
}
