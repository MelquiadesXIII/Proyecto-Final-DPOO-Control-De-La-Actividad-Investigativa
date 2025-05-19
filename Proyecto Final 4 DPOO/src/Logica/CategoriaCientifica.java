package Logica;

public enum CategoriaCientifica {

	MASTER("Master"),
	DOCTOR("Doctor"),
	NINGUNA("Ninguna");

	private final String categoria;

	CategoriaCientifica(String categoria){
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}
}
