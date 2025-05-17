package Logica;

import java.util.ArrayList;

import Complementos.CursoPosgradoUtils;
import Complementos.CursoRecibidoUtils;
import Excepciones.CadenaNoValidaException;
import Excepciones.CategoriaCientificaNoValidaException;
import Excepciones.DuplicacionException;
import Excepciones.ListaVaciaException;
import Excepciones.NoExistenciaException;

public class Docente extends Investigador{

	private String nombre;
	private String apellidos;
	private CategoriaCientifica catCientifica;
	private CategoriaDocente catDocente;
	private ArrayList<CursoPosgrado> cursosImpartidos;
	private ArrayList<CursoRecibido> cursosRecibidos;



	//Constructor
	public Docente(String nombre, String apellidos, CategoriaCientifica catCientifica, CategoriaDocente catDocente) {

		super();
		
		setNombre(nombre);
		setApellidos(apellidos);
		setCatCientifica(catCientifica);
		setCatDocente(catDocente);

		cursosImpartidos = new ArrayList<CursoPosgrado>();
		cursosRecibidos = new ArrayList<CursoRecibido>();
	}



	//Getters
	public String getNombre() 
	{
		return nombre;
	}
	
	public String getApellidos()
	{
		return apellidos;
	}

	public CategoriaCientifica getCatCientifica() 
	{
		return catCientifica;
	}

	public CategoriaDocente getCatDocente() 
	{
		return catDocente;
	}

	public ArrayList<CursoPosgrado> getCursosImpartidos() 
	{
		return cursosImpartidos;
	}

	public ArrayList<CursoRecibido> getCursosRecibidos() 
	{
		return cursosRecibidos;
	}



	//Setters
	public void setNombre(String nombre) 
	{
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del docente no puede estar vacio");

		if(!nombre.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener numeros");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener caracteres especiales o simbolos");	

		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) 
	{
		if(apellidos.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del docente no puede estar vacio");

		if(!apellidos.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener numeros");

		if(!apellidos.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener caracteres especiales o simbolos");	

		this.apellidos = apellidos;
	}

	public void setCatCientifica(CategoriaCientifica catCientifica) 
	{
		if(catCientifica == null)
			throw new NullPointerException("La categoria cientifica no puede ser null");
			
		this.catCientifica = catCientifica;
	}

	public void setCatDocente(CategoriaDocente catDocente) 
	{
		if(catDocente == null)
			throw new NullPointerException("La categoria docente no puede ser null");

		this.catDocente = catDocente;
	}



	//Metodos
	public void agregarCursoImpartido(CursoPosgrado c)
	{
		if(catCientifica != CategoriaCientifica.DOCTOR)
			throw new CategoriaCientificaNoValidaException("El docente debe tener categoria cientifica Doctor para poder impartir un curso");

		if(cursosImpartidos.contains(c)){
			throw new DuplicacionException("El curso que esta intentando agregar ya esta registrado en el docente");
		}
		
		cursosImpartidos.add(c);
	}
	
	public void removerCursoImpartido(CursoPosgrado c)
	{
		if(c == null)
			throw new NullPointerException("No puede remover un null de la lista de cursos impartidos");

		if(cursosImpartidos.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover al curso esta vacia");

		if(!cursosImpartidos.contains(c))
			throw new NoExistenciaException("El curso que desea remover no se encuentra entre los registros de cursos");
		
		cursosImpartidos.remove(c);
	}
	
	public void agregarCursoRecibido(CursoRecibido c)
	{
		if(c == null)
			throw new NullPointerException("No puede agregar un null a la lista de cursos recibidos");
		
		if(cursosRecibidos.contains(c))
			throw new DuplicacionException("El curso que intenta agregar ya se encuentra presente en el registro");
			
		cursosRecibidos.add(c);
	}

	@Override
	public boolean equals(Object d){

		return d != null &&
				(this == d ||
						(d instanceof Docente &&
								nombre.equals(((Docente)d).getNombre()) &&
								apellidos.equals(((Docente)d).getApellidos()) &&
								catCientifica == ((Docente)d).getCatCientifica() &&
								catDocente == ((Docente)d).getCatDocente()));
	}


}
