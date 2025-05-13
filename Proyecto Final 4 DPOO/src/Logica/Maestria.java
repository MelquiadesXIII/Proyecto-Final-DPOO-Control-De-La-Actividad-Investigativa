package Logica;

import java.util.ArrayList;

import Complementos.CursoUtils;
import Complementos.DocenteUtils;
import Excepciones.DuplicacionException;

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

		if(!DocenteUtils.listaContieneDocente(matriculados, matriculado))
			throw new IllegalArgumentException("La lista de matriculados no contiene al docente");

		matriculados.remove(matriculado);

		for(CursoPosgrado c: cursos){
			
				c.removerParticipante(matriculado);
		}

	}

	public void agregarCursoPosgrado(CursoPosgrado c)
	{
		if(CursoUtils.listaContieneCurso(cursos, c))
			throw new DuplicacionException("El curso que intenta agregar ya se encuentra en la lista, no lo puede duplicar");

		cursos.add(new CursoPosgrado(c.getTema(), c.getObjetivos(), c.getCantCreditos(), c.getProfesor()));	
	}

	public boolean recibirVistoBueno(Docente d){

		return creditosObtenidosCursosRecibidos(d) == creditosTotalesCursos();
	}

	public int creditosObtenidosCursosRecibidos(Docente d){

		int suma = 0;
		ArrayList<CursoRecibido> cursosR = d.getCursosRecibidos();

		for(CursoRecibido c: cursosR)
			suma += c.getCreditosRecibidos();

		return suma;
	}

	private int creditosTotalesCursos(){

		int total = 0;

		for(CursoPosgrado c: cursos)
			total += c.getCantCreditos();

		return total;
	}

}
