package Logica;

import Excepciones.CadenaNoValidaException;

public class Estudiante extends Investigador{

	private String nombre;
	private String apellidos;
	private String grupo;
	
	
	
	//Constructor
	public Estudiante(String nombre, String apellidos, String grupo) {
		
		super();
		
		
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
	
	
	
	//Setters
	public void setNombre(String nombre) 
	{
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del docente no puede estar vacio");

		if(!nombre.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener numeros");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener caracteres especiales o simbolos");	

		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) 
	{
		if(apellidos.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del docente no puede estar vacio");

		if(!apellidos.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener numeros");

		if(!apellidos.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del docente no puede tener caracteres especiales o simbolos");	

		this.apellidos = apellidos;
	}
}
