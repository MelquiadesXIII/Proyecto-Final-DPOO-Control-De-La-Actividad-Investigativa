package Logica;

import java.util.ArrayList;

import Complementos.CursoPosgradoUtils;
import Complementos.DocenteUtils;
import Excepciones.CadenaNoValidaException;
import Excepciones.DuplicacionException;
import Excepciones.NoExistenciaException;
import Excepciones.ValorNoValidoException;

public class Maestria {

	private String nombre;
	private int duracionMeses;
	private String campoEstudio;
	private ArrayList<CursoPosgrado> cursos;
	private ArrayList<Docente> matriculados;



	//Constructor
	public Maestria(String nombre, int duracionMeses, String campoEstudio) 
	{		
		cursos = new ArrayList<CursoPosgrado>();
		matriculados = new ArrayList<Docente>();
		
		setNombre(nombre);
		setCampoEstudio(campoEstudio);
		setDuracionMeses(duracionMeses);
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
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public int getDuracionMeses() 
	{
		return duracionMeses;
	}

	public String getCampoEstudio() 
	{
		return campoEstudio;
	}
	
	private int getCreditosTotalesCursos(){

		int total = 0;

		for(CursoPosgrado c: cursos)
			total += c.getCantCreditos();

		return total;
	}


	
	//Setters
	public void setNombre(String nombre) {
		
		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre no puede estar vacio");

		if(!nombre.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El nombre no puede tener numeros");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre no puede tener caracteres especiales o simbolos");	
		
		this.nombre = nombre;
	}

	public void setDuracionMeses(int duracionMeses) {
		
		if(duracionMeses <= 0)
			throw new ValorNoValidoException("La duracion por meses de una maestria debe ser una cantidad positiva");
		
		this.duracionMeses = duracionMeses;
	}

	public void setCampoEstudio(String campoEstudio) {
		
		if(campoEstudio.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre no puede estar vacio");

		if(!campoEstudio.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El nombre no puede tener numeros");

		if(!campoEstudio.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre no puede tener caracteres especiales o simbolos");	
		
		this.campoEstudio = campoEstudio;
	}
	
	
	
	//Metodos
	public void agregarMatriculado(Docente d)
	{
		if(d == null)
			throw new NullPointerException("El docente matriculado no puede tener valor null");

		if(matriculados.contains(d))
			throw new DuplicacionException("El profesor no se puede agregar porque ya se encuentra matriculado en la maestria");

		matriculados.add(d);
	}

	public void removerMatriculado(Docente d)
	{
		if(d == null)
			throw new NullPointerException("El docente matriculado no puede tener valor null");

		if(!matriculados.contains(d))
			throw new NoExistenciaException("La lista de matriculados no contiene al docente");

		matriculados.remove(d);

		for(CursoPosgrado c: cursos){
			
				c.removerParticipante(d);
		}

	}

	public void agregarCursoPosgrado(CursoPosgrado c)
	{
		if(cursos.contains(c))
			throw new DuplicacionException("El curso que intenta agregar ya esta registrado");

		cursos.add(c);
	}

	public boolean recibirVistoBueno(Docente d){

		return creditosObtenidosCursosRecibidos(d) == getCreditosTotalesCursos();
	}

	public int creditosObtenidosCursosRecibidos(Docente d){

		int suma = 0;

		for(CursoRecibido c: d.getCursosRecibidos())
			suma += c.getCreditosRecibidos();

		return suma;
	}

	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
						(o instanceof Maestria &&
								nombre.equals(((Maestria)o).getNombre()) &&
								duracionMeses == ((Maestria)o).getDuracionMeses() &&
								campoEstudio.equals(((Maestria)o).getCampoEstudio())));
	}

	
}
