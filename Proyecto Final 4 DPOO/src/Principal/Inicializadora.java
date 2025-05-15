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
		
		Docente d1 = new Docente("Manuel", "Alfonso", CategoriaCientifica.Doctor, CategoriaDocente.ProfesorTitular);
		Docente d2 = new Docente("Ryan", "Negrete", CategoriaCientifica.Master, CategoriaDocente.ProfesorTitular);
		Docente d3 = new Docente("Manuel", "Alfonso", CategoriaCientifica.Doctor, CategoriaDocente.ProfesorTitular);

		
		CursoPosgrado c = new CursoPosgrado("Mujeres", obj, 5, d1);
		c.agregarParticipante(d2);
		c.emitirNota(d1, d2, 4);
		
		
		
		if(DocenteUtils.iguales(d1, d3)) //UBICATE AQUI Y MIRA LAS INSTANCIAS QUE SE ESTAN COMPARANDO
			System.out.println("ñ");
	}

}
