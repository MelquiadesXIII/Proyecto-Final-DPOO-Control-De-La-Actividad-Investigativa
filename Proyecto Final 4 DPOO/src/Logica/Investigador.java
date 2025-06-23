package Logica;

import Excepciones.CadenaNoValidaException;
import Excepciones.DuplicacionException;
import Excepciones.ListaVaciaException;
import Excepciones.NoExistenciaException;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Investigador {

	protected String nombre;
	protected String apellidos;
	protected ArrayList<ResultadoInvestigativo> resultados;



	//Constructor
	public Investigador(String nombre, String apellidos) {

		setNombre(nombre);
		setApellidos(apellidos);
		resultados = new ArrayList<ResultadoInvestigativo>();

	}

	//Getters
	public ArrayList<ResultadoInvestigativo> getResultados() {
		return resultados;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getTotalArticulos(){

		int suma = 0;

		for(ResultadoInvestigativo r: resultados){

			if(r instanceof Articulo)
				suma++;
		}

		return suma;
	}

	public int getTotalCapitulosLibros(){

		int suma = 0;

		for(ResultadoInvestigativo r: resultados){

			if(r instanceof CapituloLibro)
				suma++;
		}

		return suma;
	}

	public int getTotalPonencias(){

		int suma = 0;

		for(ResultadoInvestigativo r: resultados){

			if(r instanceof PonenciaEvento)
				suma++;
		}

		return suma;
	}

	//Setters
	public void setNombre(String nombre) 
	{
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre no puede estar vacío");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre solo puede tener letras y espacios");	

		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) 
	{
		if(apellidos.trim().isEmpty())
			throw new CadenaNoValidaException("Los apellidos no pueden estar vacíos");

		this.apellidos = apellidos;
	}

	//Metodos
	public void agregarResultado(ResultadoInvestigativo r){

		if(resultados.contains(r))
			throw new DuplicacionException("El resultado ya se encuentra registrado");

		resultados.add(r);
	}

	public void removerResultado(ResultadoInvestigativo r){

		if(resultados.isEmpty())
			throw new ListaVaciaException("El registro de los resultados investigativos esta vacío");

		if(!resultados.contains(r))
			throw new NoExistenciaException("El resultado investigativo que intenta eliminar no se encuentra registrado");

		resultados.remove(r);
	}

	public int calcularPuntajeInvestigativo(){

		int puntaje = 0;

		for (ResultadoInvestigativo r: resultados){

			puntaje += r.aportarPuntaje();
		}

		return puntaje;
	}

	public void crearArticulo(String titulo, int numero, int volumen, String anioPublicacion, int paginas, GrupoImpacto grupo){

		Articulo a = new Articulo(titulo, numero, volumen, anioPublicacion, paginas, grupo);

		agregarResultado(a);
	}

	public void crearPonenciaEvento(String nombre, LocalDate fecha, String lugar, String ISBN){

		PonenciaEvento p = new PonenciaEvento(nombre, fecha, lugar, ISBN);

		agregarResultado(p);
	}

	public void crearCapituloLibro(String titulo, ArrayList<String> autores, ArrayList<String> nombresEditores, String editorial, String iSSN, String volumen){

		CapituloLibro c = new CapituloLibro(titulo, autores, nombresEditores, editorial, iSSN, volumen);

		agregarResultado(c);
	}

	public boolean contieneResultado(ResultadoInvestigativo r){

		return resultados.contains(r);
	}

}
