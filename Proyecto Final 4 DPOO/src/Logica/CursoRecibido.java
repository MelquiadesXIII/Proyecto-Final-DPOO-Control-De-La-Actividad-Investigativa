package Logica;

public class CursoRecibido {

	private int nota;
	private int creditosRecibidos;
	private CursoPosgrado curso;



	//Constructor
	public CursoRecibido(int nota, int creditosRecibidos, CursoPosgrado curso)
	{
		this.nota = nota;
		this.creditosRecibidos = creditosRecibidos;
		this.curso = curso;
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

}
