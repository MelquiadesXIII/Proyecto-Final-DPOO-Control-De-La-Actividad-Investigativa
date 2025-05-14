package Logica;

import java.util.ArrayList;

import Complementos.DocenteUtils;
import Excepciones.CadenaNoValidaException;
import Excepciones.DuplicacionException;
import Excepciones.InstanciaNoValidaException;
import Excepciones.ListaVaciaException;
import Excepciones.NoExistenciaException;
import Excepciones.RangoNoValidoException;

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

		if(tema.trim().isEmpty())
			throw new CadenaNoValidaException("El tema no puede estar vacio");

		if(!tema.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El tema del curso no puede tener numeros");

		this.tema = tema;	
	}

	public void setObjetivos(ArrayList<String> objetivos) 
	{
		if(objetivos == null)
			throw new NullPointerException("Los objetivos no pueden tener valor null");

		this.objetivos.clear();

		for(String o: objetivos){

			if(o.trim().isEmpty())
				throw new CadenaNoValidaException("Un objetivo del curso no puede estar vacio");

			if(!o.matches("^[^0-9]*$"))
				throw new CadenaNoValidaException("Un objetivo del curso no puede tener numeros");

			this.objetivos.add(o);	
		}
	}

	public void setCantCreditos(int cantCreditos) 
	{
		if(cantCreditos <= 0)
			throw new IllegalArgumentException("La cantidad de creditos proporcionados por un curso debe ser una cantidad positiva");

		this.cantCreditos = cantCreditos;
	}

	public void setProfesor(Docente profesor) 
	{
		if(profesor == null)
			throw new NullPointerException("El profesor no puede tener valor null");

		if(profesor.getCatCientifica() != CategoriaCientifica.Doctor)
			throw new IllegalArgumentException("El profesor que imparte el curso debe tener la categoria cientifica Doctor");

		if(this.profesor != null)
			this.profesor.removerCursoImpartido(this);

		this.profesor = profesor;

		this.profesor.agregarCursoImpartido(this);
	}



	//Metodos
	public void agregarParticipante(Docente d) 
	{
		if(d == null)
			throw new NullPointerException("Los docentes participantes no pueden tener valor null");

		if(DocenteUtils.iguales(profesor, d))
			throw new DuplicacionException("El profesor que imparte el curso no puede ser un docente participante");

		if(DocenteUtils.listaContieneDocente(participantes, d))
			throw new DuplicacionException("El profesor no se puede agregar porque ya se encuentra en el curso");

		participantes.add(d);
	}

	public void removerParticipante(Docente d){

		if(participantes.size() == 0)
			throw new ListaVaciaException("La lista del que desea remover al docente esta vacia");

		if(!DocenteUtils.listaContieneDocente(participantes, d))
			throw new NoExistenciaException("El docente que desea remover no se encuentra entre los participantes del curso");

		participantes.remove(d);
	}



	//Implementar mensajes de error
	public void emitirNota(Docente evaluador, Docente participante, int nota)
	{
		if(DocenteUtils.iguales(evaluador, profesor)){

			if(DocenteUtils.listaContieneDocente(this.participantes, participante)){

				if(nota >= 2 && nota <= 5){

				int creditos = nota >= 3 ? cantCreditos : 0; 

				participante.agregarCursoRecibido(new CursoRecibido(nota, creditos, this));

				}else{
				throw new RangoNoValidoException("La nota no esta entre el rango requerido de 2 a 5");
				}
			}
		}else{
			throw new InstanciaNoValidaException("El profesor que esta emitiendo la nota no es el evaluador");
			
		}

	}







}
