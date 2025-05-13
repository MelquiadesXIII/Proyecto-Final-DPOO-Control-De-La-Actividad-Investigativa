package Logica;

import java.util.ArrayList;

public class CursoPosgrado {

	private String tema;
	private ArrayList<String> objetivos;
	private int cantCreditos;
	private ArrayList<Docente> participantes;
	private Docente profesor;



	//Constructor
	public CursoPosgrado(String tema, ArrayList<String> objetivos, int cantCreditos, Docente profesor) 
	{
		participantes = new ArrayList<Docente>();
		this.objetivos = new ArrayList<String>();

		setTema(tema);
		setObjetivos(objetivos);
		setCantCreditos(cantCreditos);
		setProfesor(profesor);
	}



	//Getters
	public String getTema() 
	{
		return tema;
	}

	public ArrayList<String> getObjetivos() 
	{
		return objetivos;
	}

	public int getCantCreditos() 
	{
		return cantCreditos;
	}

	public ArrayList<Docente> getParticipantes() 
	{
		return participantes;
	}

	public Docente getProfesor() 
	{
		return profesor;
	}



	//Setters
	public void setTema(String tema) 
	{
		if(tema == null)
			throw new NullPointerException("El tema no puede tener valor null");

		this.tema = tema;	
	}

	public void setObjetivos(ArrayList<String> objetivos) 
	{
		if(objetivos == null)
			throw new NullPointerException("Los objetivos no pueden tener valor null");

		this.objetivos.clear();

		for(String o: objetivos)
			this.objetivos.add(o);
	}

	public void setCantCreditos(int cantCreditos) 
	{
		if(cantCreditos <= 0)
			throw new IllegalArgumentException("La cantidad de creditos proporcionados por un curso debe ser una cantidad positiva");

		this.cantCreditos = cantCreditos;
	}

	public void setProfesor(Docente profesor) 
	{
		if(this.profesor != profesor){

			if(profesor == null)
				throw new NullPointerException("El profesor no puede tener valor null");

			if(profesor.getCatCientifica() != CategoriaCientifica.Doctor)
				throw new IllegalArgumentException("El profesor que imparte el curso debe tener la categoria cientifica Doctor");

			if(this.profesor != null)
				this.profesor.removerCursoImpartido(this);

			this.profesor = profesor;

			profesor.agregarCursoImpartido(this);
		}
	}



	//Metodos
	public void agregarParticipante(Docente d) 
	{
		if(d == null)
			throw new NullPointerException("Los docentes participantes no pueden tener valor null");
		
		participantes.add(d);
	}

	//Implementar mensajes de error
	public void emitirNota(Docente evaluador, Docente participante, int nota)
	{
		CursoRecibido c;
		
		if(evaluador.equals(profesor)){
			
			if(nota >= 2 && nota <= 5){
				
				c = nota >= 3 ? new CursoRecibido(nota, cantCreditos, this) : new CursoRecibido(nota, 0, this);
				
				participante.getCursosRecibidos().add(c);
			}
		}

	}





}
