package Logica;

import java.time.Year;

import Excepciones.CadenaNoValidaException;
import Excepciones.ValorNoValidoException;

public class Articulo extends ResultadoInvestigativo{

	private String titulo;
	private int numero;
	private int volumen;
	private String anioPublicacion;
	private int paginas;
	private GrupoImpacto grupo;



	//Constructor
	public Articulo(String titulo, int numero, int volumen, String anioPublicacion, int paginas, GrupoImpacto grupo) {

		super();

		setTitulo(titulo);
		setNumero(numero);
		setVolumen(volumen);
		setAnioPublicacion(anioPublicacion);
		setPaginas(paginas);
		setGrupo(grupo);
	}



	//Getters
	public GrupoImpacto getGrupo() {
		return grupo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getNumero() {
		return numero;
	}

	public int getVolumen() {
		return volumen;
	}

	public String getAnioPublicacion() {
		return anioPublicacion;
	}

	public int getPaginas() {
		return paginas;
	}



	//Setters
	public void setTitulo(String titulo) {

		if(titulo.trim().isEmpty())
			throw new CadenaNoValidaException("El título no puede estar vacío.");

		if(!titulo.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El título solo puede contener letras y espacios.");

		this.titulo = titulo;
	}

	public void setNumero(int numero) {

		if(numero <= 0) 
			throw new ValorNoValidoException("Las páginas deben ser un número entero positivo mayor que cero.");

		this.numero = numero;
	}

	public void setVolumen(int volumen) {

		if(volumen <= 0) 
			throw new ValorNoValidoException("Las páginas deben ser un número entero positivo mayor que cero.");

		this.volumen = volumen;
	}

	public void setAnioPublicacion(String anioPublicacion) {

		if (anioPublicacion.trim().isEmpty())
			throw new CadenaNoValidaException("El año de publicación no puede estar vacío.");

		if (!anioPublicacion.matches("\\d+"))
			throw new CadenaNoValidaException("El año debe ser un número válido.");

		int anio = Integer.parseInt(anioPublicacion);

		if (anio < 1900 || anio >= Year.now().getValue())
			throw new CadenaNoValidaException("El año debe estar entre 1900 y " +(Year.now().getValue()-1));

		this.anioPublicacion = anioPublicacion;
	}

	public void setPaginas(int paginas) {

		if (paginas <= 0) 
			throw new ValorNoValidoException("Las páginas deben ser un número entero positivo mayor que cero.");

		this.paginas = paginas;
	}

	public void setGrupo(GrupoImpacto grupo){

		if (grupo == null)
			throw new NullPointerException("El grupo de impacto no puede ser nulo.");

		this.grupo = grupo;
	}



	//Metodos
	@Override
	public int aportarPuntaje(){

		return grupo.getPuntos();
	}

	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
				(o instanceof Articulo &&
						titulo.equals(((Articulo)o).getTitulo()) &&
						numero == ((Articulo)o).getNumero()) &&
<<<<<<< HEAD
						volumen == (((Articulo)o).getVolumen()) &&
						anioPublicacion.equals(((Articulo)o).getAnioPublicacion()) &&
						paginas == ((Articulo)o).getPaginas() &&
						grupo.equals(((Articulo)o).getGrupo()));
=======
						volumen == ((Articulo)o).getVolumen()) &&
						anioPublicacion.equals(((Articulo)o).getAnioPublicacion()) &&
						paginas == ((Articulo)o).getPaginas() &&
						grupo.equals(((Articulo)o).getGrupo());
>>>>>>> main
	}

}
