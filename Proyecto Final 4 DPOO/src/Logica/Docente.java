package Logica;

import java.util.ArrayList;

public class Docente extends Investigador{

	private String nombre;
	private CategoriaCientifica catCientifica;
	private CategoriaDocente catDocente;
	private ArrayList<CursoPosgrado> cursosImpartidos;
	private ArrayList<CursoRecibido> cursosRecibidos;
	
	
	
	//Constructor
	public Docente(String nombre, CategoriaCientifica catCientifica, CategoriaDocente catDocente, ArrayList<CursoPosgrado> cursosImpartidos, ArrayList<CursoRecibido> cursosRecibidos) {
		
		super();
		
		setNombre(nombre);
		setCatCientifica(catCientifica);
		setCatDocente(catDocente);
		
		cursosImpartidos = new ArrayList<CursoPosgrado>();
		cursosRecibidos = new ArrayList<CursoRecibido>();
		
	}
		
	
	//Getters
	public String getNombre() {
		return nombre;
	}

	public CategoriaCientifica getCatCientifica() {
		return catCientifica;
	}

	public CategoriaDocente getCatDocente() {
		return catDocente;
	}

	public ArrayList<CursoPosgrado> getCursosImpartidos() {
		return cursosImpartidos;
	}

	public ArrayList<CursoRecibido> getCursosRecibidos() {
		return cursosRecibidos;
	}

	
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCatCientifica(CategoriaCientifica catCientifica) {
		
		if(catCientifica != null){

			this.catCientifica = catCientifica;
			
		}else{
			
			throw new NullPointerException("La categoria cientifica no puede ser null");
			
		}
	}

	public void setCatDocente(CategoriaDocente catDocente) {
	
		if(catDocente != null){

			this.catDocente = catDocente;
			
		}else{
			
			throw new NullPointerException("La categoria docente no puede ser null");
			
		}
	}
	
	
	
	
}
