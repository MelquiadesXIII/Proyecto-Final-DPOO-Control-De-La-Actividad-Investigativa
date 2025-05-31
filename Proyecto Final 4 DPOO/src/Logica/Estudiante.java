package Logica;

import Excepciones.CadenaNoValidaException;

public class Estudiante extends Investigador{

	private String grupo;
	
	
	
	//Constructor
	public Estudiante(String nombre, String apellidos, String grupo) {
		
		super(nombre, apellidos);
		
		setGrupo(grupo);
	}
	
	
	
	//Getters
	public String getGrupo() 
	{
		return grupo;
	}


	
	//Setters
	public void setGrupo(String grupo)
	{
		if(grupo.trim().isEmpty())
			throw new CadenaNoValidaException("El grupo del estudiante no puede estar vacío");

		/*if(!grupo.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El grupo del estudiante solo puede tener letras y espacios");*/

		this.grupo = grupo;
	}



	//Metodos
	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
						(o instanceof Estudiante &&
								nombre.equals(((Estudiante)o).getNombre()) &&
								apellidos.equals(((Estudiante)o).getApellidos()) &&
								grupo.equals(((Estudiante)o).getGrupo())));
	}
}
