package Logica;

public class Articulo extends ResultadoInvestigativo{

	private String titulo;
	private String numero;
	private String volumen;
	private String anioPublicacion;
	private int paginas;
	private GrupoImpacto grupo;
	private static int puntos = 1;

	
	
	//Constructor
	
	
	
	//Getters
	public GrupoImpacto getGrupo() {
		return grupo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getNumero() {
		return numero;
	}

	public String getVolumen() {
		return volumen;
	}

	public String getAnioPublicacion() {
		return anioPublicacion;
	}

	public int getPaginas() {
		return paginas;
	}

	public static int getPuntos() {
		return puntos;
	}

	
	
	//Metodos
	@Override
	public int calcularPuntaje(){

		return grupo.getPuntos();
	}

	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
						(o instanceof Articulo &&
								titulo.equals(((Articulo)o).getTitulo()) &&
								numero.equals(((Articulo)o).getNumero()) &&
								volumen.equals(((Articulo)o).getVolumen()) &&
								anioPublicacion.equals(((Articulo)o).getAnioPublicacion()) &&
								paginas == ((Articulo)o).getPaginas() &&
								grupo.equals(((Articulo)o).getGrupo())));
	}

	
	
	
}
