package Logica;

import java.util.ArrayList;

public class Maestria {

	private ArrayList<CursoPosgrado> cursos;
	private ArrayList<Docente> matriculados;



	//Constructor
	public Maestria() 
	{
		cursos = new ArrayList<CursoPosgrado>();
		matriculados = new ArrayList<Docente>();
	}



	//Getters
	public ArrayList<CursoPosgrado> getCursos() 
	{
		return cursos;
	}

	public ArrayList<Docente> getMatriculados() 
	{
		return matriculados;
	}



	//Metodos
	public void agregarMatriculado(Docente matriculado)
	{
		if(matriculado == null)
			throw new NullPointerException("El docente matriculado no puede tener valor null");

		matriculados.add(matriculado);
	}

	public void removerMatriculado(Docente matriculado)
	{
		if(matriculado == null)
			throw new NullPointerException("El docente matriculado no puede tener valor null");

		if(!matriculados.contains(matriculado))
			throw new IllegalArgumentException("La lista de matriculados no contiene al docente");

		matriculados.remove(matriculado);

		for(CursoPosgrado c: cursos){

			if(c.getParticipantes().contains(matriculado))
				c.getParticipantes().remove(matriculado);
		}

	}

	//Implementar
	public boolean recibirVistoBueno(Docente d){

		return true;
	}

	//Implementar
	public int creditosObtenidosCursosRecibidos(Docente d){

		return 0;
	}








}
