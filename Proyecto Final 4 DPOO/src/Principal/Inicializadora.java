package Principal;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Logica.CategoriaCientifica;
import Logica.CategoriaDocente;
import Logica.CursoPosgrado;
import Logica.Docente;
import Logica.Vicedecanato;

public class Inicializadora {

	public static void main(String[] args) {
		
		ArrayList<String> obj = new ArrayList<>();
		
		obj.add("Programar");
		obj.add("Hacer dinero");
		
		Docente d1 = new Docente("Manuel", "Alfonso", CategoriaCientifica.Master, CategoriaDocente.ProfesorTitular);
		Docente d2 = new Docente("Ryan", "Negrete", CategoriaCientifica.Master, CategoriaDocente.ProfesorTitular);
		
		CursoPosgrado c = new CursoPosgrado("Mujeres", obj, 5, d1);
		c.agregarParticipante(d2);
		c.emitirNota(d1, d2, 4);
		
		System.out.println(d2.getCursosRecibidos().get(0).getCreditosRecibidos());
	}

}
