package Logica;

public enum CategoriaDocente {

	INSTRUCTOR("Instructor"),
	ASISTENTE("Asistente"),
	PROFESOR_AUXILIAR("Profesor auxiliar"),
	PROFESOR_TITULAR("Profesor titular");

	private final String categoria;

	CategoriaDocente(String categoria){
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}
}
