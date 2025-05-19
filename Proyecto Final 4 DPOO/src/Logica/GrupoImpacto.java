package Logica;

public enum GrupoImpacto {

	WoS(10, "Wos"),
	GRUPO_1(8, "Grupo 1"),
	GRUPO_2(6, "Grupo 2"),
	GRUPO_3(4, "Grupo 3"),
	GRUPO_4(4, "Grupo 4");

	private final int puntos;
	private final String grupo;

    GrupoImpacto(int puntos, String grupo) {
        this.puntos = puntos;
		this.grupo = grupo;
    }

	public int getPuntos() {
		return puntos;
	}

	public String getGrupo(){
		return grupo;
	}
}
