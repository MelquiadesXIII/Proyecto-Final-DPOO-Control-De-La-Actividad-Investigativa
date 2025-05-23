package Principal;

import java.util.ArrayList;

import javax.swing.*;

import Interfaz.InterfazPrincipal;
import Logica.CategoriaCientifica;
import Logica.CategoriaDocente;
import Logica.CursoPosgrado;
import Logica.Docente;

public class Inicializadora{
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
<<<<<<< HEAD
<<<<<<< Updated upstream
			
	        public void run() {
	        	
	        	ArrayList<String> obj = new ArrayList<>();
				
=======

			public void run() {

				ArrayList<String> obj = new ArrayList<>();

>>>>>>> main
				obj.add("Programar");
				obj.add("Ir a Varadero");

				Docente d1 = new Docente("Manuel", "Alfonso", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d2 = new Docente("Ryan", "Negrete", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d3 = new Docente("Manuel", "Alfonso", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);


				CursoPosgrado c = new CursoPosgrado("Mujeres", obj, 5, d1);
				c.agregarParticipante(d2);
				c.emitirNota(d1, d2, 2);
<<<<<<< HEAD
				
				if(d1.equals(d1))
					System.out.println("hola");
				
	            try {
	            	
	            	new Login();
	            	
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
		
		
		
		
		
=======

			public void run() {
				
				

			}
		});

>>>>>>> Stashed changes
	}
=======
>>>>>>> main

				if(d1.equals(d1))

				try {

					new InterfazPrincipal();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
