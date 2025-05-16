package Logica;

public enum GrupoImpacto {

	WoS(10),
	Grupo1(8),
	Grupo2(6),
	Grupo3(4),
	Grupo4(4);

	private final int puntos;

    GrupoImpacto(int puntos) {
        this.puntos = puntos;
    }

	public int getPuntos() {
		return puntos;
	}
}
