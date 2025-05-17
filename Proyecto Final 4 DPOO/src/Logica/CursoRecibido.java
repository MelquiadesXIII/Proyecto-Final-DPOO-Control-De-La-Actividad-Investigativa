package Logica;

import Excepciones.RangoNoValidoException;
import Excepciones.ValorNoValidoException;

public class CursoRecibido {

	private int nota;
	private int creditosRecibidos;
	private CursoPosgrado curso;



	//Constructor
	public CursoRecibido(int nota, int creditosRecibidos, CursoPosgrado curso)
	{
		setNota(nota);
		setCurso(curso);
		setCreditosRecibidos(creditosRecibidos);
	}



	//Getters
	public int getNota() 
	{
		return nota;
	}

	public int getCreditosRecibidos() 
	{
		return creditosRecibidos;
	}

	public CursoPosgrado getCurso() 
	{
		return curso;
	}



	//Setters
	public void setNota(int nota) {
		
		if(nota < 2 || nota > 5)
			throw new RangoNoValidoException("La nota no esta entre el rango requerido de 2 a 5, su valor es " +nota);
		
		this.nota = nota;
	}

	public void setCreditosRecibidos(int creditosRecibidos) {
		
		if(creditosRecibidos <= 0)
			throw new ValorNoValidoException("Los creditos recibidos deben ser una cantidad positiva");
		
		this.creditosRecibidos = creditosRecibidos;
	}

	public void setCurso(CursoPosgrado curso) {
		this.curso = curso;
	}

	public boolean equals(Object c) {
		return c != null &&
				(this == c ||
						(c instanceof CursoRecibido &&
								nota == ((CursoRecibido)c).getNota() &&
								creditosRecibidos == ((CursoRecibido)c).getCreditosRecibidos() &&
								curso.equals(((CursoRecibido)c).getCurso())));
	}
}
