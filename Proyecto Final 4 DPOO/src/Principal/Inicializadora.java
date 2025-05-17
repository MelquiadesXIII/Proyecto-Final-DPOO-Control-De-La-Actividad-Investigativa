package Principal;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Complementos.DocenteUtils;
import Logica.CategoriaCientifica;
import Logica.CategoriaDocente;
import Logica.CursoPosgrado;
import Logica.Docente;

public class Inicializadora {

	public static void main(String[] args) {
		
		ArrayList<String> obj = new ArrayList<>();
		
		obj.add("Programar");
		obj.add("Ir a Varadero");
		
		Docente d1 = new Docente("Manuel", "Alfonso", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		Docente d2 = new Docente("Ryan", "Negrete", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
		Docente d3 = new Docente("Manuel", "Alfonso", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);

		
		CursoPosgrado c = new CursoPosgrado("Mujeres", obj, 5, d1);
		c.agregarParticipante(d2);
		c.emitirNota(d1, d2, 2);
		
		if(d1.equals(d1))
			System.out.println("hola");
	}

}
