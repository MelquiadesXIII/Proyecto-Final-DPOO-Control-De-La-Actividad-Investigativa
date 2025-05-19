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



	//Metodos
	public boolean equals(Object c) {
		return c != null &&
				(this == c ||
						(c instanceof CursoRecibido &&
								nota == ((CursoRecibido)c).getNota() &&
								creditosRecibidos == ((CursoRecibido)c).getCreditosRecibidos() &&
								curso.equals(((CursoRecibido)c).getCurso())));
	}
}
