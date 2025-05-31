package Logica;

import java.util.ArrayList;
import Excepciones.CategoriaCientificaNoValidaException;
import Excepciones.DuplicacionException;
import Excepciones.ListaVaciaException;
import Excepciones.NoExistenciaException;

public class Docente extends Investigador{

	private CategoriaCientifica catCientifica;
	private CategoriaDocente catDocente;
	private ArrayList<CursoPosgrado> cursosImpartidos;
	private ArrayList<CursoRecibido> cursosRecibidos;



	//Constructor
	public Docente(String nombre, String apellidos, CategoriaCientifica catCientifica, CategoriaDocente catDocente) {

		super(nombre, apellidos);
		
		setCatCientifica(catCientifica);
		setCatDocente(catDocente);

		cursosImpartidos = new ArrayList<CursoPosgrado>();
		cursosRecibidos = new ArrayList<CursoRecibido>();
	}



	//Getters
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

	public int getCreditosObtenidosCursosRecibidos(){

		int suma = 0;

		for(CursoRecibido c: cursosRecibidos)
			suma += c.getCreditosRecibidos();

		return suma;
	}

	//Setters
	public void setCatCientifica(CategoriaCientifica catCientifica) 
	{
		if(catCientifica == null)
			throw new NullPointerException("La categoria científica no puede ser null");
			
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
			throw new CategoriaCientificaNoValidaException("El docente debe tener categoria científica Doctor para poder impartir un curso");

		if(cursosImpartidos.contains(c)){
			throw new DuplicacionException("El curso que esta intentando agregar ya está registrado en el docente");
		}
		
		cursosImpartidos.add(c);
	}
	
	public void removerCursoImpartido(CursoPosgrado c)
	{
		if(c == null)
			throw new NullPointerException("No puede remover un null de la lista de cursos impartidos");

		if(cursosImpartidos.isEmpty())
			throw new ListaVaciaException("La lista de la que desea remover al curso esta vacía");

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
