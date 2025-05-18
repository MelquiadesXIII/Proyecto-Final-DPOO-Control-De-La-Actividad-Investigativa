package Logica;

import java.time.LocalDate;
import java.time.Year;

import Excepciones.CadenaNoValidaException;
import Excepciones.ValorNoValidoException;

public class PonenciaEvento extends ResultadoInvestigativo{

	private String nombre;
	private String anio;
	private LocalDate fecha;
	private String lugar;
	private String ISBN;
	private static int puntos = 1;



	//Constructor
	public PonenciaEvento(String nombre, LocalDate fecha, String lugar, String iSBN) {

		super();

		setNombre(nombre);
		setFecha(fecha);
		setISBN(iSBN);
		setLugar(lugar);
	}


	//Getters
	public static int getPuntos() {
		return puntos;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getLugar() {
		return lugar;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getAnio() {
		return anio;
	}

	public String getNombre() {
		return nombre;
	}



	//Setters
	public void setFecha(LocalDate fecha) {
		// LocalDate fechaLocal = fechaSeleccionada.toInstant()
		//            .atZone(ZoneId.systemDefault())
		//            .toLocalDate();  -> esto se va a usar en la interfaz para convertir la fecha seleccionada en un LocalDate
		int anyoMaximo = Year.now().getValue() - 1;
		int anyoMinimo = 1900;

		if(fecha.getYear() < anyoMinimo)
			throw new ValorNoValidoException("La fecha seleccionada no puede ser anterior a 1900");

		if(fecha.getYear() > anyoMaximo)
			throw new ValorNoValidoException("La fecha seleccionada no puede ser después del año " +anyoMaximo);

		this.fecha = fecha;
		anio = Integer.toString(fecha.getYear()); //Inicializado aqui para garantizar la coherencia
	}

	public void setNombre(String nombre) {

		if(nombre.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre de la ponencia no puede estar vacio");

		if(!nombre.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre de la ponencia solo puede tener letras y espacios");	

		this.nombre = nombre;
	}

	public void setLugar(String lugar) {

		if(lugar.trim().isEmpty())
			throw new CadenaNoValidaException("El nombre del lugar no puede estar vacio");

		if(!lugar.matches("^[\\p{L}\\s]+$"))
			throw new CadenaNoValidaException("El nombre del lugar solo puede tener letras y espacios");

		this.lugar = lugar;
	}

	public void setISBN(String ISBN) {

		if(ISBN.length() < 13 || ISBN.length() > 13)
			throw new CadenaNoValidaException("El ISBN solo puede tener una longitud de 13 dígitos, la longitud de lo que usted ingresó es " +ISBN.length());

		if(!ISBN.matches("^\\d+$"))
			throw new CadenaNoValidaException("El ISBN solo puede estar conformado por números");

		this.ISBN = ISBN;
	}

	//Metodos
	@Override
	public boolean equals(Object o) {
		return o != null &&
				(this == o ||
				(o instanceof PonenciaEvento &&
						nombre.equals(((PonenciaEvento)o).getNombre()) &&
						anio.equals(((PonenciaEvento)o).getAnio()) &&
						fecha.equals(((PonenciaEvento)o).getFecha()) &&
						lugar.equals(((PonenciaEvento)o).getLugar()) &&
						ISBN.equals(((PonenciaEvento)o).getISBN())));
	}

	@Override
	public int aportarPuntaje(){

		return puntos;
	}

}
