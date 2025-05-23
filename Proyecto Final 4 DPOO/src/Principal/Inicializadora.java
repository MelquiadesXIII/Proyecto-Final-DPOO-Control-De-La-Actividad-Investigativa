package Principal;

import java.util.ArrayList;

import javax.swing.*;

import Interfaz.*;
import Logica.*;

public class Inicializadora{
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		
		        Vicedecanato vicedecanato = new Vicedecanato();

		        Departamento depto1 = new Departamento("Departamento de Ciencias Computacionales");
		        Departamento depto2 = new Departamento("Departamento de Ingeniería Eléctrica");
		        Departamento depto3 = new Departamento("Departamento de Matemáticas Aplicadas");

		        vicedecanato.agregarDepartamento(depto1);
		        vicedecanato.agregarDepartamento(depto2);
		        vicedecanato.agregarDepartamento(depto3);

		        Docente d1 = new Docente("Carlos", "Pérez", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d2 = new Docente("María", "Gómez", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d3 = new Docente("Luis", "Martínez", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d4 = new Docente("Ana", "López", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d5 = new Docente("Javier", "Rodríguez", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d6 = new Docente("Lucía", "Fernández", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d7 = new Docente("Diego", "Sánchez", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d8 = new Docente("Andrea", "Ruiz", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d9 = new Docente("Miguel", "Hernández", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d10 = new Docente("Laura", "Díaz", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d11 = new Docente("David", "Torres", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d12 = new Docente("Valentina", "Ramírez", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d13 = new Docente("Santiago", "Flores", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d14 = new Docente("Camila", "Morales", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d15 = new Docente("Daniel", "Castro", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d16 = new Docente("Natalia", "Vargas", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d17 = new Docente("Alejandro", "Ortega", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d18 = new Docente("Isabella", "Rojas", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d19 = new Docente("Mateo", "Silva", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d20 = new Docente("Daniela", "Romero", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d21 = new Docente("José", "Jiménez", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d22 = new Docente("Carolina", "Mendoza", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d23 = new Docente("Sebastián", "Cortés", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d24 = new Docente("Paula", "Guerrero", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d25 = new Docente("Fernando", "Reyes", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d26 = new Docente("Valeria", "Chávez", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d27 = new Docente("Cristian", "Navarro", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d28 = new Docente("Emily", "Medina", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d29 = new Docente("Jhon", "Cárdenas", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d30 = new Docente("Sofía", "Ramos", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d31 = new Docente("Andrés", "Molina", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d32 = new Docente("Paola", "Ávila", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d33 = new Docente("Kevin", "Peña", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d34 = new Docente("Gabriela", "Salazar", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d35 = new Docente("Oscar", "León", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d36 = new Docente("Elena", "Vega", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d37 = new Docente("Manuel", "Ibarra", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d38 = new Docente("Renata", "Zambrano", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d39 = new Docente("Emilio", "Benítez", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d40 = new Docente("Claudia", "Velasco", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d41 = new Docente("Enrique", "Rangel", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d42 = new Docente("Tatiana", "Quintero", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d43 = new Docente("Julio", "Cevallos", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d44 = new Docente("Adriana", "Cedeño", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d45 = new Docente("Ricardo", "Paredes", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d46 = new Docente("Verónica", "Duarte", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d47 = new Docente("Guillermo", "Escobar", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d48 = new Docente("Melissa", "Bustos", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d49 = new Docente("Francisco", "Palacios", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d50 = new Docente("Patricia", "Arroyo", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d51 = new Docente("Hugo", "Maldonado", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d52 = new Docente("Karen", "Carrasco", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d53 = new Docente("Mario", "Bravo", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d54 = new Docente("Yessica", "Vargas", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d55 = new Docente("Alberto", "Montoya", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
		        Docente d56 = new Docente("Jessica", "Suárez", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
		        Docente d57 = new Docente("Alex", "Correa", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
		        Docente d58 = new Docente("Liliana", "Ponce", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
		        Docente d59 = new Docente("Raúl", "Alarcón", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
		        Docente d60 = new Docente("Vanessa", "Mejía", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);

		        vicedecanato.agregarDocente(d1); vicedecanato.agregarDocente(d2); vicedecanato.agregarDocente(d3);
		        vicedecanato.agregarDocente(d4); vicedecanato.agregarDocente(d5); vicedecanato.agregarDocente(d6);
		        vicedecanato.agregarDocente(d7); vicedecanato.agregarDocente(d8); vicedecanato.agregarDocente(d9);
		        vicedecanato.agregarDocente(d10); vicedecanato.agregarDocente(d11); vicedecanato.agregarDocente(d12);
		        vicedecanato.agregarDocente(d13); vicedecanato.agregarDocente(d14); vicedecanato.agregarDocente(d15);
		        vicedecanato.agregarDocente(d16); vicedecanato.agregarDocente(d17); vicedecanato.agregarDocente(d18);
		        vicedecanato.agregarDocente(d19); vicedecanato.agregarDocente(d20); vicedecanato.agregarDocente(d21);
		        vicedecanato.agregarDocente(d22); vicedecanato.agregarDocente(d23); vicedecanato.agregarDocente(d24);
		        vicedecanato.agregarDocente(d25); vicedecanato.agregarDocente(d26); vicedecanato.agregarDocente(d27);
		        vicedecanato.agregarDocente(d28); vicedecanato.agregarDocente(d29); vicedecanato.agregarDocente(d30);
		        vicedecanato.agregarDocente(d31); vicedecanato.agregarDocente(d32); vicedecanato.agregarDocente(d33);
		        vicedecanato.agregarDocente(d34); vicedecanato.agregarDocente(d35); vicedecanato.agregarDocente(d36);
		        vicedecanato.agregarDocente(d37); vicedecanato.agregarDocente(d38); vicedecanato.agregarDocente(d39);
		        vicedecanato.agregarDocente(d40); vicedecanato.agregarDocente(d41); vicedecanato.agregarDocente(d42);
		        vicedecanato.agregarDocente(d43); vicedecanato.agregarDocente(d44); vicedecanato.agregarDocente(d45);
		        vicedecanato.agregarDocente(d46); vicedecanato.agregarDocente(d47); vicedecanato.agregarDocente(d48);
		        vicedecanato.agregarDocente(d49); vicedecanato.agregarDocente(d50); vicedecanato.agregarDocente(d51);
		        vicedecanato.agregarDocente(d52); vicedecanato.agregarDocente(d53); vicedecanato.agregarDocente(d54);
		        vicedecanato.agregarDocente(d55); vicedecanato.agregarDocente(d56); vicedecanato.agregarDocente(d57);
		        vicedecanato.agregarDocente(d58); vicedecanato.agregarDocente(d59); vicedecanato.agregarDocente(d60);

		        depto1.agregarDocente(d1); depto1.agregarDocente(d2); depto1.agregarDocente(d3); depto1.agregarDocente(d4);
		        depto1.agregarDocente(d5); depto1.agregarDocente(d6); depto1.agregarDocente(d7); depto1.agregarDocente(d8);
		        depto1.agregarDocente(d9); depto1.agregarDocente(d10); depto1.agregarDocente(d11); depto1.agregarDocente(d12);
		        depto1.agregarDocente(d13); depto1.agregarDocente(d14); depto1.agregarDocente(d15); depto1.agregarDocente(d16);
		        depto1.agregarDocente(d17); depto1.agregarDocente(d18); depto1.agregarDocente(d19); depto1.agregarDocente(d20);

		        depto2.agregarDocente(d21); depto2.agregarDocente(d22); depto2.agregarDocente(d23); depto2.agregarDocente(d24);
		        depto2.agregarDocente(d25); depto2.agregarDocente(d26); depto2.agregarDocente(d27); depto2.agregarDocente(d28);
		        depto2.agregarDocente(d29); depto2.agregarDocente(d30); depto2.agregarDocente(d31); depto2.agregarDocente(d32);
		        depto2.agregarDocente(d33); depto2.agregarDocente(d34); depto2.agregarDocente(d35); depto2.agregarDocente(d36);
		        depto2.agregarDocente(d37); depto2.agregarDocente(d38); depto2.agregarDocente(d39); depto2.agregarDocente(d40);

		        depto3.agregarDocente(d41); depto3.agregarDocente(d42); depto3.agregarDocente(d43); depto3.agregarDocente(d44);
		        depto3.agregarDocente(d45); depto3.agregarDocente(d46); depto3.agregarDocente(d47); depto3.agregarDocente(d48);
		        depto3.agregarDocente(d49); depto3.agregarDocente(d50); depto3.agregarDocente(d51); depto3.agregarDocente(d52);
		        depto3.agregarDocente(d53); depto3.agregarDocente(d54); depto3.agregarDocente(d55); depto3.agregarDocente(d56);
		        depto3.agregarDocente(d57); depto3.agregarDocente(d58); depto3.agregarDocente(d59); depto3.agregarDocente(d60);

		        Estudiante e1 = new Estudiante("Jorge", "Muñoz", "Grupo de Investigación A");
		        Estudiante e2 = new Estudiante("Mariana", "Santos", "Grupo de Investigación B");
		        Estudiante e3 = new Estudiante("Roberto", "Vera", "Grupo de Investigación C");
		        Estudiante e4 = new Estudiante("Carla", "Cabrera", "Grupo de Investigación D");
		        Estudiante e5 = new Estudiante("Ignacio", "Rojas", "Grupo de Investigación E");
		        Estudiante e6 = new Estudiante("Daniela", "Espinoza", "Grupo de Investigación F");
		        Estudiante e7 = new Estudiante("Tomás", "Vidal", "Grupo de Investigación G");
		        Estudiante e8 = new Estudiante("Florencia", "Tapia", "Grupo de Investigación H");
		        Estudiante e9 = new Estudiante("Esteban", "Carrillo", "Grupo de Investigación I");
		        Estudiante e10 = new Estudiante("Valentina", "Contreras", "Grupo de Investigación J");
		        Estudiante e11 = new Estudiante("Matías", "Pastor", "Grupo de Investigación K");
		        Estudiante e12 = new Estudiante("Catalina", "Pinto", "Grupo de Investigación L");
		        Estudiante e13 = new Estudiante("Felipe", "Olivares", "Grupo de Investigación M");
		        Estudiante e14 = new Estudiante("Lucía", "Parra", "Grupo de Investigación N");
		        Estudiante e15 = new Estudiante("Sergio", "Delgado", "Grupo de Investigación O");
		        Estudiante e16 = new Estudiante("Camila", "Soto", "Grupo de Investigación P");
		        Estudiante e17 = new Estudiante("Andrés", "Mora", "Grupo de Investigación Q");
		        Estudiante e18 = new Estudiante("Antonia", "Fuentes", "Grupo de Investigación R");
		        Estudiante e19 = new Estudiante("Nicolás", "Cisterna", "Grupo de Investigación S");
		        Estudiante e20 = new Estudiante("Javiera", "Godoy", "Grupo de Investigación T");
		        Estudiante e21 = new Estudiante("Francisco", "Araya", "Grupo de Investigación U");
		        Estudiante e22 = new Estudiante("Macarena", "Sepúlveda", "Grupo de Investigación V");
		        Estudiante e23 = new Estudiante("Rodrigo", "Cerda", "Grupo de Investigación W");
		        Estudiante e24 = new Estudiante("Belén", "Méndez", "Grupo de Investigación X");
		        Estudiante e25 = new Estudiante("Gabriel", "Urrutia", "Grupo de Investigación Y");
		        Estudiante e26 = new Estudiante("Constanza", "Navarro", "Grupo de Investigación Z");
		        Estudiante e27 = new Estudiante("Cristóbal", "Cordero", "Grupo de Investigación A");
		        Estudiante e28 = new Estudiante("Barbara", "Munizaga", "Grupo de Investigación B");
		        Estudiante e29 = new Estudiante("Juan", "Figueroa", "Grupo de Investigación C");
		        Estudiante e30 = new Estudiante("Isabel", "Poblete", "Grupo de Investigación D");
		        Estudiante e31 = new Estudiante("Rafael", "Mardones", "Grupo de Investigación E");
		        Estudiante e32 = new Estudiante("Tamara", "Cid", "Grupo de Investigación F");
		        Estudiante e33 = new Estudiante("Sebastián", "Carrasco", "Grupo de Investigación G");
		        Estudiante e34 = new Estudiante("Valeria", "Flores", "Grupo de Investigación H");
		        Estudiante e35 = new Estudiante("Diego", "Gálvez", "Grupo de Investigación I");
		        Estudiante e36 = new Estudiante("Carmen", "Moyano", "Grupo de Investigación J");
		        Estudiante e37 = new Estudiante("Ignacio", "Guzmán", "Grupo de Investigación K");
		        Estudiante e38 = new Estudiante("Marcelo", "Lagos", "Grupo de Investigación L");
		        Estudiante e39 = new Estudiante("Ximena", "Riquelme", "Grupo de Investigación M");
		        Estudiante e40 = new Estudiante("Cristina", "Vargas", "Grupo de Investigación N");

		        vicedecanato.agregarEstudiante(e1); vicedecanato.agregarEstudiante(e2); vicedecanato.agregarEstudiante(e3);
		        vicedecanato.agregarEstudiante(e4); vicedecanato.agregarEstudiante(e5); vicedecanato.agregarEstudiante(e6);
		        vicedecanato.agregarEstudiante(e7); vicedecanato.agregarEstudiante(e8); vicedecanato.agregarEstudiante(e9);
		        vicedecanato.agregarEstudiante(e10); vicedecanato.agregarEstudiante(e11); vicedecanato.agregarEstudiante(e12);
		        vicedecanato.agregarEstudiante(e13); vicedecanato.agregarEstudiante(e14); vicedecanato.agregarEstudiante(e15);
		        vicedecanato.agregarEstudiante(e16); vicedecanato.agregarEstudiante(e17); vicedecanato.agregarEstudiante(e18);
		        vicedecanato.agregarEstudiante(e19); vicedecanato.agregarEstudiante(e20); vicedecanato.agregarEstudiante(e21);
		        vicedecanato.agregarEstudiante(e22); vicedecanato.agregarEstudiante(e23); vicedecanato.agregarEstudiante(e24);
		        vicedecanato.agregarEstudiante(e25); vicedecanato.agregarEstudiante(e26); vicedecanato.agregarEstudiante(e27);
		        vicedecanato.agregarEstudiante(e28); vicedecanato.agregarEstudiante(e29); vicedecanato.agregarEstudiante(e30);
		        vicedecanato.agregarEstudiante(e31); vicedecanato.agregarEstudiante(e32); vicedecanato.agregarEstudiante(e33);
		        vicedecanato.agregarEstudiante(e34); vicedecanato.agregarEstudiante(e35); vicedecanato.agregarEstudiante(e36);
		        vicedecanato.agregarEstudiante(e37); vicedecanato.agregarEstudiante(e38); vicedecanato.agregarEstudiante(e39);
		        vicedecanato.agregarEstudiante(e40);

		        depto1.agregarEstudiante(e1); depto1.agregarEstudiante(e2); depto1.agregarEstudiante(e3);
		        depto1.agregarEstudiante(e4); depto1.agregarEstudiante(e5); depto1.agregarEstudiante(e6);
		        depto1.agregarEstudiante(e7); depto1.agregarEstudiante(e8); depto1.agregarEstudiante(e9);
		        depto1.agregarEstudiante(e10); depto1.agregarEstudiante(e11); depto1.agregarEstudiante(e12);
		        depto1.agregarEstudiante(e13); depto1.agregarEstudiante(e14); depto1.agregarEstudiante(e15);
		        depto1.agregarEstudiante(e16); depto1.agregarEstudiante(e17); depto1.agregarEstudiante(e18);
		        depto1.agregarEstudiante(e19); depto1.agregarEstudiante(e20);

		        depto2.agregarEstudiante(e21); depto2.agregarEstudiante(e22); depto2.agregarEstudiante(e23);
		        depto2.agregarEstudiante(e24); depto2.agregarEstudiante(e25); depto2.agregarEstudiante(e26);
		        depto2.agregarEstudiante(e27); depto2.agregarEstudiante(e28); depto2.agregarEstudiante(e29);
		        depto2.agregarEstudiante(e30); depto2.agregarEstudiante(e31); depto2.agregarEstudiante(e32);
		        depto2.agregarEstudiante(e33); depto2.agregarEstudiante(e34); depto2.agregarEstudiante(e35);
		        depto2.agregarEstudiante(e36); depto2.agregarEstudiante(e37); depto2.agregarEstudiante(e38);
		        depto2.agregarEstudiante(e39); depto2.agregarEstudiante(e40);

		        depto3.agregarEstudiante(e1); depto3.agregarEstudiante(e2); depto3.agregarEstudiante(e3);
		        depto3.agregarEstudiante(e4); depto3.agregarEstudiante(e5); depto3.agregarEstudiante(e6);
		        depto3.agregarEstudiante(e7); depto3.agregarEstudiante(e8); depto3.agregarEstudiante(e9);
		        depto3.agregarEstudiante(e10); depto3.agregarEstudiante(e11); depto3.agregarEstudiante(e12);
		        depto3.agregarEstudiante(e13); depto3.agregarEstudiante(e14); depto3.agregarEstudiante(e15);
		        depto3.agregarEstudiante(e16); depto3.agregarEstudiante(e17); depto3.agregarEstudiante(e18);
		        depto3.agregarEstudiante(e19); depto3.agregarEstudiante(e20);

		       
				


			}
		});
	}
}
