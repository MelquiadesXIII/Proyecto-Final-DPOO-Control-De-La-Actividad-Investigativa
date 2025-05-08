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
		objetivos = new ArrayList<String>();
		
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
		if(tema != null)
			this.tema = tema;

		else
			throw new NullPointerException("El tema no puede tener valor null");
	}

	public void setObjetivos(ArrayList<String> objetivos) 
	{
		if(objetivos != null){

			for(String o: objetivos){

				this.objetivos.add(o);
			}

		}else
			throw new NullPointerException("Los objetivos no pueden tener valor null");
	}

	public void setCantCreditos(int cantCreditos) 
	{
		if(cantCreditos > 0)
			this.cantCreditos = cantCreditos;

		else
			throw new IllegalArgumentException("La cantidad de creditos proporcionados por un curso debe ser una cantidad positiva");
	}

	public void setProfesor(Docente profesor) 
	{
		if(profesor != null){

			if(profesor.getCatCientifica() == CategoriaCientifica.Doctor)
				this.profesor = profesor;

			else
				throw new IllegalArgumentException("El profesor que imparte el curso debe tener la categoria cientifica Doctor");

		}else
			throw new NullPointerException("El profesor no puede tener valor null");
	}
	
	
	
	//Metodos
	public void agregarParticipante(Docente d) 
	{
		if(d != null){

			participantes.add(d);

		}else
			throw new NullPointerException("Los docentes participantes no pueden tener valor null");
	}

	//Implementar
	public void emitirNota(Docente evaluador, Docente participante, int nota)
	{


	}





}
