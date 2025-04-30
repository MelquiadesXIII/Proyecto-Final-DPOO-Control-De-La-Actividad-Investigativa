package Logica;

public class Articulo extends ResultadoInvestigativo{

	private String titulo;
	private String numero;
	private String volumen;
	private String anioPublicacion;
	private int paginas;
	private GrupoImpacto grupo;
	
	
	@Override
	public int calcularPuntaje(){
		
		return 0;
	}
}
