package Login;

import Excepciones.CadenaNoValidaException;

public class Usuario {

	private String nombre;
	private String contrasenia;
	
	
	public Usuario(String nombre, String contrasenia) {
		setNombre(nombre);
		setContrasenia(contrasenia);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del usuario no puede estar vacío");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre de usuario solo puede tener letras y espacios");	

		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		
		if(contrasenia.trim().isEmpty())
			throw new CadenaNoValidaException("La contraseña no puede estar vacío");
		
		this.contrasenia = contrasenia;
	}
	
	@Override
	public boolean equals(Object o){
		
		return o != null && (this == o || nombre.equals(((Usuario)o).getNombre()) || contrasenia.equals(((Usuario)o).getContrasenia()));
	}
	
}
