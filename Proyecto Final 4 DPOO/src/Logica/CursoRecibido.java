package Logica;

public class CursoRecibido {

	private int nota;
	private int creditosRecibidos;
	private String temaCurso;



	//Constructor
	public CursoRecibido(int nota, int creditosRecibidos, String temaCurso)
	{
		this.nota = nota;
		this.creditosRecibidos = creditosRecibidos;
		this.temaCurso = temaCurso;
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

	public String getTemaCurso() 
	{
		return temaCurso;
	}



	//Metodos
	public boolean equals(Object c) {
		return c != null &&
				(this == c ||
						(c instanceof CursoRecibido &&
								nota == ((CursoRecibido)c).getNota() &&
								creditosRecibidos == ((CursoRecibido)c).getCreditosRecibidos() &&
								temaCurso.equals(((CursoRecibido)c).getTemaCurso())));
	}
}
