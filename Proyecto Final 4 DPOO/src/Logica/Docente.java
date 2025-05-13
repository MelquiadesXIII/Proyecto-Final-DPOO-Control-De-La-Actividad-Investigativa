package Logica;

import java.util.ArrayList;

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

		cursosImpartidos = new ArrayList<CursoPosgrado>();
		cursosRecibidos = new ArrayList<CursoRecibido>();

		setNombre(nombre);
		setApellidos(apellidos);
		setCatCientifica(catCientifica);
		setCatDocente(catDocente);
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
		if(nombre == null)
			throw new NullPointerException("El nombre no puede ser null");

		char[] nombreAux = new char[nombre.length()];

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
	
	public void setApellidos(String apellidos) 
	{
		if(apellidos == null)
			throw new NullPointerException("El apellido no puede ser null");

		this.apellidos = apellidos;
	}



	//Metodos
	public void agregarCursoImpartido(CursoPosgrado curso)
	{
		if(cursosImpartidos.contains(curso)){
			throw new IllegalArgumentException("No se puede duplicar el curso");
		}
		
		cursosImpartidos.add(curso);
	}
	
	public void removerCursoImpartido(CursoPosgrado curso)
	{
		if(curso == null)
			throw new NullPointerException("No puede remover un null de la lista de cursos impartidos");
		
		cursosImpartidos.remove(curso);
	}
	
	public void agregarCursoRecibido(CursoRecibido c)
	{
		if(c == null)
			throw new NullPointerException("No puede agregar un null a la lista de cursos recibidos");
		
		if(cursosRecibidos.contains(c))
			throw new IllegalArgumentException("No puede duplicar el curso");
			
		cursosRecibidos.add(c);
	}
	
	public boolean contieneCursoRecibido(CursoRecibido curso) {
	    return cursosRecibidos.contains(curso);
	}
}
