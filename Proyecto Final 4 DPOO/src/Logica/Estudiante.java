package Logica;

import Excepciones.CadenaNoValidaException;

public class Estudiante extends Investigador{

	private String nombre;
	private String apellidos;
	private String grupo;
	
	
	
	//Constructor
	public Estudiante(String nombre, String apellidos, String grupo) {
		
		super();

		setNombre(nombre);
		setApellidos(apellidos);
		setGrupo(grupo);
	}
	
	
	
	//Getters
	public String getNombre() 
	{
		return nombre;
	}
	
	public String getApellidos()
	{
		return apellidos;
	}

	public String getGrupo() 
	{
		return grupo;
	}


	
	//Setters
	public void setNombre(String nombre) 
	{
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del estudiante no puede estar vacío");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del estudiante solo puede tener letras y espacios");	

		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) 
	{
		if(apellidos.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del estudiante no puede estar vacío");

		if(!apellidos.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del estudiante solo puede tener letras y espacios");	

		this.apellidos = apellidos;
	}

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
