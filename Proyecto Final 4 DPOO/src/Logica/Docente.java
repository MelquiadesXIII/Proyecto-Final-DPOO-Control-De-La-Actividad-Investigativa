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
	public Docente(String nombre, String apellidos, CategoriaCientifica catCientifica, CategoriaDocente catDocente, ArrayList<CursoPosgrado> cursosImpartidos, ArrayList<CursoRecibido> cursosRecibidos) {

		super();

		cursosImpartidos = new ArrayList<CursoPosgrado>();
		cursosRecibidos = new ArrayList<CursoRecibido>();

		setNombre(nombre);
		setApellidos(apellidos);
		setCatCientifica(catCientifica);
		setCatDocente(catDocente);
	}



	public void setApellidos(String apellidos) 
	{
		if(apellidos != null){




		}else
			throw new NullPointerException("El apellido no puede ser null");

	}



	//Getters
	public String getNombre() 
	{
		return nombre;
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
		if(nombre != null){

			char[] nombreAux = new char[nombre.length()];



		}else
			throw new NullPointerException("El nombre no puede ser null");
	}

	public void setCatCientifica(CategoriaCientifica catCientifica) 
	{
		if(catCientifica != null)
			this.catCientifica = catCientifica;

		else
			throw new NullPointerException("La categoria cientifica no puede ser null");
	}

	public void setCatDocente(CategoriaDocente catDocente) 
	{
		if(catDocente != null)
			this.catDocente = catDocente;

		else
			throw new NullPointerException("La categoria docente no puede ser null");
	}
}
