package Principal;

import java.util.ArrayList;

import javax.swing.*;

import Interfaz.*;
import Logica.*;

public class Inicializadora{
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("serial")
			public void run() {

				Vicedecanato vicedecanato = new Vicedecanato();
	     
	            Departamento depto1 = new Departamento("Departamento de Ciencias Computacionales");
	            Departamento depto2 = new Departamento("Departamento de Ingeniería Eléctrica");
	            Departamento depto3 = new Departamento("Departamento de Matemáticas Aplicadas");
	            
	            vicedecanato.agregarDepartamento(depto1);
	            vicedecanato.agregarDepartamento(depto2);
	            vicedecanato.agregarDepartamento(depto3);

				
			}
		});
	}
}
