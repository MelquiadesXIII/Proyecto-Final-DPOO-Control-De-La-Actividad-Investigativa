package Logica;

public class Articulo extends ResultadoInvestigativo{

	private String titulo;
	private String numero;
	private String volumen;
	private String anioPublicacion;
	private int paginas;
	private GrupoImpacto grupo;
	private static int puntos = 1;
	
	
	@Override
	public int calcularPuntaje(){

		return grupo.getPuntos();
	}
}
