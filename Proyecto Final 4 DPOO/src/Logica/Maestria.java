package Logica;

import java.util.ArrayList;

import Excepciones.CadenaNoValidaException;
import Excepciones.CategoriaCientificaNoValidaException;
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
		setNombre(nombre);
		setCampoEstudio(campoEstudio);
		setDuracionMeses(duracionMeses);

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

	public int getCreditosTotalesCursos(){

		int total = 0;

		for(CursoPosgrado c: cursos)
			total += c.getCantCreditos();

		return total;
	}



	//Setters
	public void setNombre(String nombre) {

		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre de la maestría no puede estar vacio");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre de la maestría solo puede tener letras y espacios");	

		this.nombre = nombre;
	}

	public void setDuracionMeses(int duracionMeses) {

		if(duracionMeses <= 0)
			throw new ValorNoValidoException("La duración por meses de una maestría debe ser una cantidad positiva");

		this.duracionMeses = duracionMeses;
	}

	public void setCampoEstudio(String campoEstudio) {

		if(campoEstudio.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre no puede estar vacío");

		if(!campoEstudio.matches("^[^0-9]*$"))
			throw new CadenaNoValidaException("El nombre no puede tener números");

		if(!campoEstudio.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre no puede tener caracteres especiales o símbolos");	

		this.campoEstudio = campoEstudio;
	}



	//Metodos
	public boolean contieneMatriculado(Docente m){

		return matriculados.contains(m);
	}

	public void agregarMatriculado(Docente d)
	{
		if(d == null)
			throw new NullPointerException("El docente matriculado no puede tener valor null");

		if(d.getCatCientifica() != CategoriaCientifica.NINGUNA)
			throw new CategoriaCientificaNoValidaException("Solo un profesor sin categoría científica puede matricularse en la maestría");

		if(matriculados.contains(d))
			throw new DuplicacionException("El profesor no se puede agregar porque ya se encuentra matriculado en la maestría");

		matriculados.add(d);
		
		for(CursoPosgrado c: cursos){
			
			c.agregarParticipante(d);
		}
	}

	public void removerMatriculado(Docente d)
	{
		if(d == null)
			throw new NullPointerException("El docente matriculado no puede tener valor null");

		if(!matriculados.contains(d))
			throw new NoExistenciaException("La lista de matriculados no contiene al docente");

		matriculados.remove(d);

		for(CursoPosgrado c: cursos){

			if(c.getParticipantes().contains(d))
				c.removerParticipante(d);
		}

	}

	public void agregarCursoPosgrado(CursoPosgrado c)
	{
		if(cursos.contains(c))
			throw new DuplicacionException("El curso que intenta agregar ya está registrado");

		cursos.add(c);
	}
	
	public void crearCursoPosgrado(String tema, ArrayList<String> objetivos, int cantCreditos, Docente profesor){
		
		CursoPosgrado c = new CursoPosgrado(tema, objetivos, cantCreditos, profesor);
		
		agregarCursoPosgrado(c);
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

	@Override
	public String toString() {
		return this.nombre; 
	}
}
