package Principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

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

				//Aqui se crean 300 docentes y se agregan al vicedecanato
				
				//Docentes del departamento 1
				Docente d1 = new Docente("Mae", "López", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d2 = new Docente("Rodolfo", "Remesar Martin", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d3 = new Docente("Sonia", "Pérez Lovelle", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d4 = new Docente("Ana", "Ruiz", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
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
				Docente d61 = new Docente("Amadeo", "Villalba Montes", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d62 = new Docente("Belisario", "Narváez Roldán", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d63 = new Docente("Casimira", "Del Valle Ponce", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d64 = new Docente("Dacio", "Zambrano Alarcón", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d65 = new Docente("Eulalia", "Barros Quintana", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d66 = new Docente("Fructuoso", "Mesa Córdoba", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d67 = new Docente("Griselda", "Pizarro Valverde", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d68 = new Docente("Hermógenes", "Lagos Espinosa", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d69 = new Docente("Ifigenia", "Maldonado Rivas", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d70 = new Docente("Jovito", "Carrasco Lago", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d71 = new Docente("Kilian", "Roldán Páez", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d72 = new Docente("Lucrecia", "Sarmiento Montes", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d73 = new Docente("Mamerto", "Vega Otero", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d74 = new Docente("Nemesio", "Galindo Valle", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d75 = new Docente("Otilia", "Castañeda Ríos", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d76 = new Docente("Pánfilo", "Miranda Lago", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d77 = new Docente("Querubín", "Aguirre Pino", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d78 = new Docente("Régulo", "Solano Roldán", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d79 = new Docente("Serafina", "Montenegro Páez", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d80 = new Docente("Tadeo", "Cervantes Espinoza", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d81 = new Docente("Úrsula", "Ojeda Valdivia", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d82 = new Docente("Verenice", "Lara Montesinos", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d83 = new Docente("Wálter", "Méndez Ríos", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d84 = new Docente("Ximena", "Cortés Ocampo", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d85 = new Docente("Yolando", "Peralta Villalba", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d86 = new Docente("Zenaida", "Ríos Zambrano", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d87 = new Docente("Anacleto", "Montes Pizarro", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d88 = new Docente("Brígida", "Alarcón Narváez", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d89 = new Docente("Cándido", "Quintana Barros", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d90 = new Docente("Dorotea", "Córdoba Mesa", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d91 = new Docente("Eleuterio", "Valverde Lagos", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d92 = new Docente("Fidelia", "Espinosa Maldonado", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d93 = new Docente("Gervasio", "Rivas Carrasco", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d94 = new Docente("Hilario", "Lago Roldán", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d95 = new Docente("Isidora", "Páez Sarmiento", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d96 = new Docente("Jacinto", "Montes Vega", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d97 = new Docente("Leocadia", "Valle Galindo", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d98 = new Docente("Macario", "Ríos Castañeda", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d99 = new Docente("Natalicio", "Lago Miranda", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d100 = new Docente("Olegario", "Pino Aguirre", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				
				//Docentes del departamento 2
				Docente d101 = new Docente("Pacífica", "Roldán Solano", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d102 = new Docente("Quirino", "Páez Montenegro", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d103 = new Docente("Rosalía", "Espinoza Cervantes", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d104 = new Docente("Saturnino", "Valdivia Ojeda", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d105 = new Docente("Teodosia", "Montesinos Lara", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d106 = new Docente("Ulpiano", "Ríos Méndez", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d107 = new Docente("Venancia", "Ocampo Cortés", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d108 = new Docente("Wenceslao", "Villalba Peralta", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d109 = new Docente("Xenia", "Zambrano Ríos", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d110 = new Docente("Yago", "Pizarro Montes", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d111 = new Docente("Zoraida", "Narváez Alarcón", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d112 = new Docente("Adelio", "Barros Quintana", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d113 = new Docente("Berta", "Mesa Córdoba", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d114 = new Docente("Celso", "Valverde Pizarro", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d115 = new Docente("Dina", "Lagos Espinosa", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d116 = new Docente("Eligio", "Maldonado Rivas", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d117 = new Docente("Fabiola", "Carrasco Lago", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d118 = new Docente("Galo", "Roldán Páez", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d119 = new Docente("Herminia", "Sarmiento Montes", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d120 = new Docente("Inocencio", "Vega Otero", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d121 = new Docente("Jovita", "Galindo Valle", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d122 = new Docente("Lauro", "Castañeda Ríos", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d123 = new Docente("Melania", "Miranda Lago", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d124 = new Docente("Narciso", "Aguirre Pino", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d125 = new Docente("Otilio", "Solano Roldán", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d126 = new Docente("Palmira", "Montenegro Páez", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d127 = new Docente("Quintín", "Cervantes Espinoza", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d128 = new Docente("Rita", "Ojeda Valdivia", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d129 = new Docente("Silvano", "Lara Montesinos", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d130 = new Docente("Tarsila", "Méndez Ríos", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d131 = new Docente("Urbano", "Cortés Ocampo", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d132 = new Docente("Viviana", "Peralta Villalba", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d133 = new Docente("Wilfredo", "Ríos Zambrano", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d134 = new Docente("Ximena", "Montes Pizarro", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d135 = new Docente("Yolando", "Alarcón Narváez", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d136 = new Docente("Zacarías", "Quintana Barros", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d137 = new Docente("Adelaida", "Córdoba Mesa", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d138 = new Docente("Baldomero", "Valverde Lagos", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d139 = new Docente("Cándida", "Espinosa Maldonado", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d140 = new Docente("Demetrio", "Rivas Carrasco", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d141 = new Docente("Esmeralda", "Lago Roldán", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d142 = new Docente("Fulgencio", "Páez Sarmiento", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d143 = new Docente("Gertrudis", "Montes Vega", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d144 = new Docente("Hilarión", "Valle Galindo", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d145 = new Docente("Ildefonso", "Ríos Castañeda", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d146 = new Docente("Jacinta", "Lago Miranda", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d147 = new Docente("Leandro", "Pino Aguirre", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d148 = new Docente("Marcelina", "Roldán Solano", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d149 = new Docente("Nicanor", "Páez Montenegro", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d150 = new Docente("Olimpia", "Espinoza Cervantes", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d151 = new Docente("Pancracio", "Valdivia Ojeda", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d152 = new Docente("Querubina", "Montesinos Lara", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d153 = new Docente("Ramiro", "Ríos Méndez", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d154 = new Docente("Salustiana", "Ocampo Cortés", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d155 = new Docente("Tiburcio", "Villalba Peralta", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d156 = new Docente("Ubaldo", "Zambrano Ríos", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d157 = new Docente("Valeria", "Pizarro Montes", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d158 = new Docente("Waldemar", "Narváez Alarcón", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d159 = new Docente("Xavier", "Barros Quintana", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d160 = new Docente("Yolanda", "Mesa Córdoba", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d161 = new Docente("Zósimo", "Valverde Pizarro", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d162 = new Docente("Amparo", "Lagos Espinosa", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d163 = new Docente("Bernabé", "Maldonado Rivas", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d164 = new Docente("Cleto", "Carrasco Lago", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d165 = new Docente("Dionisia", "Roldán Páez", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d166 = new Docente("Eusebio", "Sarmiento Montes", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d167 = new Docente("Fidencia", "Vega Otero", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d168 = new Docente("Gumersindo", "Galindo Valle", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d169 = new Docente("Honorina", "Castañeda Ríos", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d170 = new Docente("Inocencia", "Miranda Lago", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d171 = new Docente("Justino", "Aguirre Pino", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d172 = new Docente("Leticia", "Solano Roldán", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d173 = new Docente("Macario", "Montenegro Páez", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d174 = new Docente("Natalia", "Cervantes Espinoza", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d175 = new Docente("Ovidio", "Ojeda Valdivia", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d176 = new Docente("Priscila", "Lara Montesinos", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d177 = new Docente("Quirino", "Méndez Ríos", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d178 = new Docente("Rosendo", "Cortés Ocampo", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d179 = new Docente("Simeón", "Peralta Villalba", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d180 = new Docente("Teodora", "Ríos Zambrano", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d181 = new Docente("Ulises", "Montes Pizarro", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d182 = new Docente("Venancio", "Alarcón Narváez", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d183 = new Docente("Wenceslada", "Quintana Barros", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d184 = new Docente("Xenón", "Córdoba Mesa", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d185 = new Docente("Yolanda", "Valverde Lagos", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d186 = new Docente("Zenaido", "Espinosa Maldonado", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d187 = new Docente("Adolfo", "Rivas Carrasco", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d188 = new Docente("Benigna", "Lago Roldán", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d189 = new Docente("Celestino", "Páez Sarmiento", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d190 = new Docente("Doroteo", "Montes Vega", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d191 = new Docente("Eufemia", "Valle Galindo", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d192 = new Docente("Froilán", "Ríos Castañeda", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d193 = new Docente("Gervasia", "Lago Miranda", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d194 = new Docente("Higinio", "Pino Aguirre", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d195 = new Docente("Isaura", "Roldán Solano", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d196 = new Docente("Juliano", "Páez Montenegro", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d197 = new Docente("Leonila", "Espinoza Cervantes", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d198 = new Docente("Martín", "Valdivia Ojeda", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d199 = new Docente("Natalia", "Montesinos Lara", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d200 = new Docente("Otilio", "Ríos Méndez", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				
				//Docentes del departamento 3
				Docente d201 = new Docente("Pascuala", "Ocampo Cortés", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d202 = new Docente("Quintiliano", "Villalba Peralta", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d203 = new Docente("Ruperta", "Zambrano Ríos", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d204 = new Docente("Secundino", "Pizarro Montes", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d205 = new Docente("Teófila", "Narváez Alarcón", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d206 = new Docente("Urbana", "Barros Quintana", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d207 = new Docente("Valentín", "Mesa Córdoba", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d208 = new Docente("Wilfreda", "Valverde Pizarro", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d209 = new Docente("Xavier", "Lagos Espinosa", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d210 = new Docente("Yolanda", "Maldonado Rivas", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d211 = new Docente("Zacarías", "Carrasco Lago", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d212 = new Docente("Adela", "Roldán Páez", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d213 = new Docente("Balduino", "Sarmiento Montes", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d214 = new Docente("Carmelita", "Vega Otero", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d215 = new Docente("Damián", "Galindo Valle", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d216 = new Docente("Eleuteria", "Castañeda Ríos", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d217 = new Docente("Fortunato", "Miranda Lago", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d218 = new Docente("Gertrudis", "Aguirre Pino", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d219 = new Docente("Hilario", "Solano Roldán", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d220 = new Docente("Inés", "Montenegro Páez", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d221 = new Docente("Jacobo", "Cervantes Espinoza", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d222 = new Docente("Leocadia", "Ojeda Valdivia", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d223 = new Docente("Marcial", "Lara Montesinos", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d224 = new Docente("Nemesio", "Méndez Ríos", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d225 = new Docente("Olegaria", "Cortés Ocampo", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d226 = new Docente("Pánfilo", "Peralta Villalba", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d227 = new Docente("Quiteria", "Ríos Zambrano", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d228 = new Docente("Raimundo", "Montes Pizarro", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d229 = new Docente("Salomé", "Alarcón Narváez", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d230 = new Docente("Tadeo", "Quintana Barros", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d231 = new Docente("Ubalda", "Córdoba Mesa", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d232 = new Docente("Vicenta", "Valverde Lagos", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d233 = new Docente("Waldino", "Espinosa Maldonado", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d234 = new Docente("Ximena", "Rivas Carrasco", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d235 = new Docente("Yago", "Lago Roldán", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d236 = new Docente("Zenaida", "Páez Sarmiento", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d237 = new Docente("Ambrocio", "Montes Vega", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d238 = new Docente("Bibiana", "Valle Galindo", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d239 = new Docente("Cipriano", "Ríos Castañeda", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d240 = new Docente("Dorila", "Lago Miranda", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d241 = new Docente("Eusebia", "Pino Aguirre", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d242 = new Docente("Fidel", "Roldán Solano", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d243 = new Docente("Gaudencia", "Páez Montenegro", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d244 = new Docente("Humberto", "Espinoza Cervantes", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d245 = new Docente("Ildefonsa", "Valdivia Ojeda", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d246 = new Docente("Jacinta", "Montesinos Lara", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d247 = new Docente("Leocadio", "Ríos Méndez", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d248 = new Docente("Marcela", "Ocampo Cortés", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d249 = new Docente("Narcisa", "Villalba Peralta", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d250 = new Docente("Otilia", "Zambrano Ríos", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d251 = new Docente("Pío", "Pizarro Montes", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d252 = new Docente("Querubina", "Narváez Alarcón", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d253 = new Docente("Ruperto", "Barros Quintana", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d254 = new Docente("Silvestra", "Mesa Córdoba", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d255 = new Docente("Teófilo", "Valverde Pizarro", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d256 = new Docente("Urbano", "Lagos Espinosa", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d257 = new Docente("Viviana", "Maldonado Rivas", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d258 = new Docente("Wilfredo", "Carrasco Lago", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d259 = new Docente("Xenia", "Roldán Páez", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d260 = new Docente("Yolando", "Sarmiento Montes", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d261 = new Docente("Zacarías", "Vega Otero", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d262 = new Docente("Adela", "Galindo Valle", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d263 = new Docente("Baldomero", "Castañeda Ríos", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d264 = new Docente("Carmelo", "Miranda Lago", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d265 = new Docente("Dolores", "Aguirre Pino", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d266 = new Docente("Eleuterio", "Solano Roldán", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d267 = new Docente("Fidencia", "Montenegro Páez", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d268 = new Docente("Gervasio", "Cervantes Espinoza", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d269 = new Docente("Honorina", "Ojeda Valdivia", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d270 = new Docente("Inocencio", "Lara Montesinos", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d271 = new Docente("Jacinto", "Méndez Ríos", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d272 = new Docente("Leocadia", "Cortés Ocampo", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d273 = new Docente("Macario", "Peralta Villalba", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d274 = new Docente("Natalia", "Ríos Zambrano", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d275 = new Docente("Olegario", "Montes Pizarro", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d276 = new Docente("Pacífica", "Alarcón Narváez", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d277 = new Docente("Quirino", "Quintana Barros", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d278 = new Docente("Rosalía", "Córdoba Mesa", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d279 = new Docente("Saturnino", "Valverde Lagos", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d280 = new Docente("Teodosia", "Espinosa Maldonado", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d281 = new Docente("Ulpiano", "Rivas Carrasco", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d282 = new Docente("Venancia", "Lago Roldán", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d283 = new Docente("Wenceslao", "Páez Sarmiento", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d284 = new Docente("Xenia", "Montes Vega", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d285 = new Docente("Yago", "Valle Galindo", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d286 = new Docente("Zoraida", "Ríos Castañeda", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d287 = new Docente("Adelio", "Lago Miranda", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d288 = new Docente("Berta", "Pino Aguirre", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);
				Docente d289 = new Docente("Celso", "Roldán Solano", CategoriaCientifica.NINGUNA, CategoriaDocente.INSTRUCTOR);
				Docente d290 = new Docente("Dina", "Páez Montenegro", CategoriaCientifica.MASTER, CategoriaDocente.ASISTENTE);
				Docente d291 = new Docente("Eligio", "Espinoza Cervantes", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d292 = new Docente("Fabiola", "Valdivia Ojeda", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_TITULAR);
				Docente d293 = new Docente("Galo", "Montesinos Lara", CategoriaCientifica.MASTER, CategoriaDocente.INSTRUCTOR);
				Docente d294 = new Docente("Herminia", "Ríos Méndez", CategoriaCientifica.DOCTOR, CategoriaDocente.ASISTENTE);
				Docente d295 = new Docente("Inocencio", "Ocampo Cortés", CategoriaCientifica.NINGUNA, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d296 = new Docente("Jovita", "Villalba Peralta", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR);
				Docente d297 = new Docente("Lauro", "Zambrano Ríos", CategoriaCientifica.DOCTOR, CategoriaDocente.INSTRUCTOR);
				Docente d298 = new Docente("Melania", "Pizarro Montes", CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE);
				Docente d299 = new Docente("Narciso", "Narváez Alarcón", CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_AUXILIAR);
				Docente d300 = new Docente("Otilio", "Barros Quintana", CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_TITULAR);

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
				vicedecanato.agregarDocente(d61); vicedecanato.agregarDocente(d62); vicedecanato.agregarDocente(d63);
				vicedecanato.agregarDocente(d64); vicedecanato.agregarDocente(d65); vicedecanato.agregarDocente(d66);
				vicedecanato.agregarDocente(d67); vicedecanato.agregarDocente(d68); vicedecanato.agregarDocente(d69);
				vicedecanato.agregarDocente(d70); vicedecanato.agregarDocente(d71); vicedecanato.agregarDocente(d72);
				vicedecanato.agregarDocente(d73); vicedecanato.agregarDocente(d74); vicedecanato.agregarDocente(d75);
				vicedecanato.agregarDocente(d76); vicedecanato.agregarDocente(d77); vicedecanato.agregarDocente(d78);
				vicedecanato.agregarDocente(d79); vicedecanato.agregarDocente(d80); vicedecanato.agregarDocente(d81);
				vicedecanato.agregarDocente(d82); vicedecanato.agregarDocente(d83); vicedecanato.agregarDocente(d84);
				vicedecanato.agregarDocente(d85); vicedecanato.agregarDocente(d86); vicedecanato.agregarDocente(d87);
				vicedecanato.agregarDocente(d88); vicedecanato.agregarDocente(d89); vicedecanato.agregarDocente(d90);
				vicedecanato.agregarDocente(d91); vicedecanato.agregarDocente(d92); vicedecanato.agregarDocente(d93);
				vicedecanato.agregarDocente(d94); vicedecanato.agregarDocente(d95); vicedecanato.agregarDocente(d96);
				vicedecanato.agregarDocente(d97); vicedecanato.agregarDocente(d98); vicedecanato.agregarDocente(d99);
				vicedecanato.agregarDocente(d100); vicedecanato.agregarDocente(d101); vicedecanato.agregarDocente(d102);
				vicedecanato.agregarDocente(d103); vicedecanato.agregarDocente(d104); vicedecanato.agregarDocente(d105);
				vicedecanato.agregarDocente(d106); vicedecanato.agregarDocente(d107); vicedecanato.agregarDocente(d108);
				vicedecanato.agregarDocente(d109); vicedecanato.agregarDocente(d110); vicedecanato.agregarDocente(d111);
				vicedecanato.agregarDocente(d112); vicedecanato.agregarDocente(d113); vicedecanato.agregarDocente(d114);
				vicedecanato.agregarDocente(d115); vicedecanato.agregarDocente(d116); vicedecanato.agregarDocente(d117);
				vicedecanato.agregarDocente(d118); vicedecanato.agregarDocente(d119); vicedecanato.agregarDocente(d120);
				vicedecanato.agregarDocente(d121); vicedecanato.agregarDocente(d122); vicedecanato.agregarDocente(d123);
				vicedecanato.agregarDocente(d124); vicedecanato.agregarDocente(d125); vicedecanato.agregarDocente(d126);
				vicedecanato.agregarDocente(d127); vicedecanato.agregarDocente(d128); vicedecanato.agregarDocente(d129);
				vicedecanato.agregarDocente(d130); vicedecanato.agregarDocente(d131); vicedecanato.agregarDocente(d132);
				vicedecanato.agregarDocente(d133); vicedecanato.agregarDocente(d134); vicedecanato.agregarDocente(d135);
				vicedecanato.agregarDocente(d136); vicedecanato.agregarDocente(d137); vicedecanato.agregarDocente(d138);
				vicedecanato.agregarDocente(d139); vicedecanato.agregarDocente(d140); vicedecanato.agregarDocente(d141);
				vicedecanato.agregarDocente(d142); vicedecanato.agregarDocente(d143); vicedecanato.agregarDocente(d144);
				vicedecanato.agregarDocente(d145); vicedecanato.agregarDocente(d146); vicedecanato.agregarDocente(d147);
				vicedecanato.agregarDocente(d148); vicedecanato.agregarDocente(d149); vicedecanato.agregarDocente(d150);
				vicedecanato.agregarDocente(d151); vicedecanato.agregarDocente(d152); vicedecanato.agregarDocente(d153);
				vicedecanato.agregarDocente(d154); vicedecanato.agregarDocente(d155); vicedecanato.agregarDocente(d156);
				vicedecanato.agregarDocente(d157); vicedecanato.agregarDocente(d158); vicedecanato.agregarDocente(d159);
				vicedecanato.agregarDocente(d160); vicedecanato.agregarDocente(d161); vicedecanato.agregarDocente(d162);
				vicedecanato.agregarDocente(d163); vicedecanato.agregarDocente(d164); vicedecanato.agregarDocente(d165);
				vicedecanato.agregarDocente(d166); vicedecanato.agregarDocente(d167); vicedecanato.agregarDocente(d168);
				vicedecanato.agregarDocente(d169); vicedecanato.agregarDocente(d170); vicedecanato.agregarDocente(d171);
				vicedecanato.agregarDocente(d172); vicedecanato.agregarDocente(d173); vicedecanato.agregarDocente(d174);
				vicedecanato.agregarDocente(d175); vicedecanato.agregarDocente(d176); vicedecanato.agregarDocente(d177);
				vicedecanato.agregarDocente(d178); vicedecanato.agregarDocente(d179); vicedecanato.agregarDocente(d180);
				vicedecanato.agregarDocente(d181); vicedecanato.agregarDocente(d182); vicedecanato.agregarDocente(d183);
				vicedecanato.agregarDocente(d184); vicedecanato.agregarDocente(d185); vicedecanato.agregarDocente(d186);
				vicedecanato.agregarDocente(d187); vicedecanato.agregarDocente(d188); vicedecanato.agregarDocente(d189);
				vicedecanato.agregarDocente(d190); vicedecanato.agregarDocente(d191); vicedecanato.agregarDocente(d192);
				vicedecanato.agregarDocente(d193); vicedecanato.agregarDocente(d194); vicedecanato.agregarDocente(d195);
				vicedecanato.agregarDocente(d196); vicedecanato.agregarDocente(d197); vicedecanato.agregarDocente(d198);
				vicedecanato.agregarDocente(d199); vicedecanato.agregarDocente(d200); vicedecanato.agregarDocente(d201);
				vicedecanato.agregarDocente(d202); vicedecanato.agregarDocente(d203); vicedecanato.agregarDocente(d204);
				vicedecanato.agregarDocente(d205); vicedecanato.agregarDocente(d206); vicedecanato.agregarDocente(d207);
				vicedecanato.agregarDocente(d208); vicedecanato.agregarDocente(d209); vicedecanato.agregarDocente(d210);
				vicedecanato.agregarDocente(d211); vicedecanato.agregarDocente(d212); vicedecanato.agregarDocente(d213);
				vicedecanato.agregarDocente(d214); vicedecanato.agregarDocente(d215); vicedecanato.agregarDocente(d216);
				vicedecanato.agregarDocente(d217); vicedecanato.agregarDocente(d218); vicedecanato.agregarDocente(d219);
				vicedecanato.agregarDocente(d220); vicedecanato.agregarDocente(d221); vicedecanato.agregarDocente(d222);
				vicedecanato.agregarDocente(d223); vicedecanato.agregarDocente(d224); vicedecanato.agregarDocente(d225);
				vicedecanato.agregarDocente(d226); vicedecanato.agregarDocente(d227); vicedecanato.agregarDocente(d228);
				vicedecanato.agregarDocente(d229); vicedecanato.agregarDocente(d230); vicedecanato.agregarDocente(d231);
				vicedecanato.agregarDocente(d232); vicedecanato.agregarDocente(d233); vicedecanato.agregarDocente(d234);
				vicedecanato.agregarDocente(d235); vicedecanato.agregarDocente(d236); vicedecanato.agregarDocente(d237);
				vicedecanato.agregarDocente(d238); vicedecanato.agregarDocente(d239); vicedecanato.agregarDocente(d240);
				vicedecanato.agregarDocente(d241); vicedecanato.agregarDocente(d242); vicedecanato.agregarDocente(d243);
				vicedecanato.agregarDocente(d244); vicedecanato.agregarDocente(d245); vicedecanato.agregarDocente(d246);
				vicedecanato.agregarDocente(d247); vicedecanato.agregarDocente(d248); vicedecanato.agregarDocente(d249);
				vicedecanato.agregarDocente(d250); vicedecanato.agregarDocente(d251); vicedecanato.agregarDocente(d252);
				vicedecanato.agregarDocente(d253); vicedecanato.agregarDocente(d254); vicedecanato.agregarDocente(d255);
				vicedecanato.agregarDocente(d256); vicedecanato.agregarDocente(d257); vicedecanato.agregarDocente(d258);
				vicedecanato.agregarDocente(d259); vicedecanato.agregarDocente(d260); vicedecanato.agregarDocente(d261);
				vicedecanato.agregarDocente(d262); vicedecanato.agregarDocente(d263); vicedecanato.agregarDocente(d264);
				vicedecanato.agregarDocente(d265); vicedecanato.agregarDocente(d266); vicedecanato.agregarDocente(d267);
				vicedecanato.agregarDocente(d268); vicedecanato.agregarDocente(d269); vicedecanato.agregarDocente(d270);
				vicedecanato.agregarDocente(d271); vicedecanato.agregarDocente(d272); vicedecanato.agregarDocente(d273);
				vicedecanato.agregarDocente(d274); vicedecanato.agregarDocente(d275); vicedecanato.agregarDocente(d276);
				vicedecanato.agregarDocente(d277); vicedecanato.agregarDocente(d278); vicedecanato.agregarDocente(d279);
				vicedecanato.agregarDocente(d280); vicedecanato.agregarDocente(d281); vicedecanato.agregarDocente(d282);
				vicedecanato.agregarDocente(d283); vicedecanato.agregarDocente(d284); vicedecanato.agregarDocente(d285);
				vicedecanato.agregarDocente(d286); vicedecanato.agregarDocente(d287); vicedecanato.agregarDocente(d288);
				vicedecanato.agregarDocente(d289); vicedecanato.agregarDocente(d290); vicedecanato.agregarDocente(d291);
				vicedecanato.agregarDocente(d292); vicedecanato.agregarDocente(d293); vicedecanato.agregarDocente(d294);
				vicedecanato.agregarDocente(d295); vicedecanato.agregarDocente(d296); vicedecanato.agregarDocente(d297);
				vicedecanato.agregarDocente(d298); vicedecanato.agregarDocente(d299); vicedecanato.agregarDocente(d300);

				depto1.agregarDocente(d1); depto1.agregarDocente(d2); depto1.agregarDocente(d3); depto1.agregarDocente(d4); 
				depto1.agregarDocente(d5); depto1.agregarDocente(d6); depto1.agregarDocente(d7); depto1.agregarDocente(d8); 
				depto1.agregarDocente(d9); depto1.agregarDocente(d10); depto1.agregarDocente(d11); depto1.agregarDocente(d12); 
				depto1.agregarDocente(d13); depto1.agregarDocente(d14); depto1.agregarDocente(d15); depto1.agregarDocente(d16); 
				depto1.agregarDocente(d17); depto1.agregarDocente(d18); depto1.agregarDocente(d19); depto1.agregarDocente(d20); 
				depto1.agregarDocente(d21); depto1.agregarDocente(d22); depto1.agregarDocente(d23); depto1.agregarDocente(d24); 
				depto1.agregarDocente(d25); depto1.agregarDocente(d26); depto1.agregarDocente(d27); depto1.agregarDocente(d28); 
				depto1.agregarDocente(d29); depto1.agregarDocente(d30); depto1.agregarDocente(d31); depto1.agregarDocente(d32); 
				depto1.agregarDocente(d33); depto1.agregarDocente(d34); depto1.agregarDocente(d35); depto1.agregarDocente(d36); 
				depto1.agregarDocente(d37); depto1.agregarDocente(d38); depto1.agregarDocente(d39); depto1.agregarDocente(d40); 
				depto1.agregarDocente(d41); depto1.agregarDocente(d42); depto1.agregarDocente(d43); depto1.agregarDocente(d44); 
				depto1.agregarDocente(d45); depto1.agregarDocente(d46); depto1.agregarDocente(d47); depto1.agregarDocente(d48); 
				depto1.agregarDocente(d49); depto1.agregarDocente(d50); depto1.agregarDocente(d51); depto1.agregarDocente(d52); 
				depto1.agregarDocente(d53); depto1.agregarDocente(d54); depto1.agregarDocente(d55); depto1.agregarDocente(d56); 
				depto1.agregarDocente(d57); depto1.agregarDocente(d58); depto1.agregarDocente(d59); depto1.agregarDocente(d60); 
				depto1.agregarDocente(d61); depto1.agregarDocente(d62); depto1.agregarDocente(d63); depto1.agregarDocente(d64); 
				depto1.agregarDocente(d65); depto1.agregarDocente(d66); depto1.agregarDocente(d67); depto1.agregarDocente(d68); 
				depto1.agregarDocente(d69); depto1.agregarDocente(d70); depto1.agregarDocente(d71); depto1.agregarDocente(d72); 
				depto1.agregarDocente(d73); depto1.agregarDocente(d74); depto1.agregarDocente(d75); depto1.agregarDocente(d76); 
				depto1.agregarDocente(d77); depto1.agregarDocente(d78); depto1.agregarDocente(d79); depto1.agregarDocente(d80); 
				depto1.agregarDocente(d81); depto1.agregarDocente(d82); depto1.agregarDocente(d83); depto1.agregarDocente(d84); 
				depto1.agregarDocente(d85); depto1.agregarDocente(d86); depto1.agregarDocente(d87); depto1.agregarDocente(d88); 
				depto1.agregarDocente(d89); depto1.agregarDocente(d90); depto1.agregarDocente(d91); depto1.agregarDocente(d92); 
				depto1.agregarDocente(d93); depto1.agregarDocente(d94); depto1.agregarDocente(d95); depto1.agregarDocente(d96); 
				depto1.agregarDocente(d97); depto1.agregarDocente(d98); depto1.agregarDocente(d99); depto1.agregarDocente(d100);

				depto2.agregarDocente(d101); depto2.agregarDocente(d102); depto2.agregarDocente(d103); depto2.agregarDocente(d104); 
				depto2.agregarDocente(d105); depto2.agregarDocente(d106); depto2.agregarDocente(d107); depto2.agregarDocente(d108); 
				depto2.agregarDocente(d109); depto2.agregarDocente(d110); depto2.agregarDocente(d111); depto2.agregarDocente(d112); 
				depto2.agregarDocente(d113); depto2.agregarDocente(d114); depto2.agregarDocente(d115); depto2.agregarDocente(d116); 
				depto2.agregarDocente(d117); depto2.agregarDocente(d118); depto2.agregarDocente(d119); depto2.agregarDocente(d120); 
				depto2.agregarDocente(d121); depto2.agregarDocente(d122); depto2.agregarDocente(d123); depto2.agregarDocente(d124); 
				depto2.agregarDocente(d125); depto2.agregarDocente(d126); depto2.agregarDocente(d127); depto2.agregarDocente(d128); 
				depto2.agregarDocente(d129); depto2.agregarDocente(d130); depto2.agregarDocente(d131); depto2.agregarDocente(d132); 
				depto2.agregarDocente(d133); depto2.agregarDocente(d134); depto2.agregarDocente(d135); depto2.agregarDocente(d136); 
				depto2.agregarDocente(d137); depto2.agregarDocente(d138); depto2.agregarDocente(d139); depto2.agregarDocente(d140); 
				depto2.agregarDocente(d141); depto2.agregarDocente(d142); depto2.agregarDocente(d143); depto2.agregarDocente(d144); 
				depto2.agregarDocente(d145); depto2.agregarDocente(d146); depto2.agregarDocente(d147); depto2.agregarDocente(d148); 
				depto2.agregarDocente(d149); depto2.agregarDocente(d150); depto2.agregarDocente(d151); depto2.agregarDocente(d152); 
				depto2.agregarDocente(d153); depto2.agregarDocente(d154); depto2.agregarDocente(d155); depto2.agregarDocente(d156); 
				depto2.agregarDocente(d157); depto2.agregarDocente(d158); depto2.agregarDocente(d159); depto2.agregarDocente(d160); 
				depto2.agregarDocente(d161); depto2.agregarDocente(d162); depto2.agregarDocente(d163); depto2.agregarDocente(d164); 
				depto2.agregarDocente(d165); depto2.agregarDocente(d166); depto2.agregarDocente(d167); depto2.agregarDocente(d168); 
				depto2.agregarDocente(d169); depto2.agregarDocente(d170); depto2.agregarDocente(d171); depto2.agregarDocente(d172); 
				depto2.agregarDocente(d173); depto2.agregarDocente(d174); depto2.agregarDocente(d175); depto2.agregarDocente(d176); 
				depto2.agregarDocente(d177); depto2.agregarDocente(d178); depto2.agregarDocente(d179); depto2.agregarDocente(d180); 
				depto2.agregarDocente(d181); depto2.agregarDocente(d182); depto2.agregarDocente(d183); depto2.agregarDocente(d184); 
				depto2.agregarDocente(d185); depto2.agregarDocente(d186); depto2.agregarDocente(d187); depto2.agregarDocente(d188); 
				depto2.agregarDocente(d189); depto2.agregarDocente(d190); depto2.agregarDocente(d191); depto2.agregarDocente(d192); 
				depto2.agregarDocente(d193); depto2.agregarDocente(d194); depto2.agregarDocente(d195); depto2.agregarDocente(d196); 
				depto2.agregarDocente(d197); depto2.agregarDocente(d198); depto2.agregarDocente(d199); depto2.agregarDocente(d200);

				depto3.agregarDocente(d201); depto3.agregarDocente(d202); depto3.agregarDocente(d203); depto3.agregarDocente(d204); 
				depto3.agregarDocente(d205); depto3.agregarDocente(d206); depto3.agregarDocente(d207); depto3.agregarDocente(d208); 
				depto3.agregarDocente(d209); depto3.agregarDocente(d210); depto3.agregarDocente(d211); depto3.agregarDocente(d212); 
				depto3.agregarDocente(d213); depto3.agregarDocente(d214); depto3.agregarDocente(d215); depto3.agregarDocente(d216); 
				depto3.agregarDocente(d217); depto3.agregarDocente(d218); depto3.agregarDocente(d219); depto3.agregarDocente(d220); 
				depto3.agregarDocente(d221); depto3.agregarDocente(d222); depto3.agregarDocente(d223); depto3.agregarDocente(d224); 
				depto3.agregarDocente(d225); depto3.agregarDocente(d226); depto3.agregarDocente(d227); depto3.agregarDocente(d228); 
				depto3.agregarDocente(d229); depto3.agregarDocente(d230); depto3.agregarDocente(d231); depto3.agregarDocente(d232); 
				depto3.agregarDocente(d233); depto3.agregarDocente(d234); depto3.agregarDocente(d235); depto3.agregarDocente(d236); 
				depto3.agregarDocente(d237); depto3.agregarDocente(d238); depto3.agregarDocente(d239); depto3.agregarDocente(d240); 
				depto3.agregarDocente(d241); depto3.agregarDocente(d242); depto3.agregarDocente(d243); depto3.agregarDocente(d244); 
				depto3.agregarDocente(d245); depto3.agregarDocente(d246); depto3.agregarDocente(d247); depto3.agregarDocente(d248); 
				depto3.agregarDocente(d249); depto3.agregarDocente(d250); depto3.agregarDocente(d251); depto3.agregarDocente(d252); 
				depto3.agregarDocente(d253); depto3.agregarDocente(d254); depto3.agregarDocente(d255); depto3.agregarDocente(d256); 
				depto3.agregarDocente(d257); depto3.agregarDocente(d258); depto3.agregarDocente(d259); depto3.agregarDocente(d260); 
				depto3.agregarDocente(d261); depto3.agregarDocente(d262); depto3.agregarDocente(d263); depto3.agregarDocente(d264); 
				depto3.agregarDocente(d265); depto3.agregarDocente(d266); depto3.agregarDocente(d267); depto3.agregarDocente(d268); 
				depto3.agregarDocente(d269); depto3.agregarDocente(d270); depto3.agregarDocente(d271); depto3.agregarDocente(d272); 
				depto3.agregarDocente(d273); depto3.agregarDocente(d274); depto3.agregarDocente(d275); depto3.agregarDocente(d276); 
				depto3.agregarDocente(d277); depto3.agregarDocente(d278); depto3.agregarDocente(d279); depto3.agregarDocente(d280); 
				depto3.agregarDocente(d281); depto3.agregarDocente(d282); depto3.agregarDocente(d283); depto3.agregarDocente(d284); 
				depto3.agregarDocente(d285); depto3.agregarDocente(d286); depto3.agregarDocente(d287); depto3.agregarDocente(d288); 
				depto3.agregarDocente(d289); depto3.agregarDocente(d290); depto3.agregarDocente(d291); depto3.agregarDocente(d292); 
				depto3.agregarDocente(d293); depto3.agregarDocente(d294); depto3.agregarDocente(d295); depto3.agregarDocente(d296); 
				depto3.agregarDocente(d297); depto3.agregarDocente(d298); depto3.agregarDocente(d299); depto3.agregarDocente(d300);

				//Aqui se crean los estudiantes y se agregan
				Estudiante e1 = new Estudiante("Ryan", "Negrete Menchaca", "G21");
				Estudiante e2 = new Estudiante("Darell", "Perdomo Gónzalez", "G13");
				Estudiante e3 = new Estudiante("Eriet Darío", "Armas Gónzalez", "G14");
				Estudiante e4 = new Estudiante("Alison", "Hidalgo Guerra", "G14");
				Estudiante e5 = new Estudiante("Marlon Miguel", "Gónzalez Llerandi", "G13");
				Estudiante e6 = new Estudiante("Liz Elena", "Cruz Zerquera", "G13");
				Estudiante e7 = new Estudiante("Nelson Alejandro", "Monroy Rodríguez", "G14");
				Estudiante e8 = new Estudiante("Amaury", "Diéguez Pérez", "G13");
				Estudiante e9 = new Estudiante("Isaac Alef", "García Batista", "G13");
				Estudiante e10 = new Estudiante("Leonardo David", "Guirado García", "G13");
				Estudiante e11 = new Estudiante("Luis Alberto", "Pérez Álvarez", "G13");
				Estudiante e12 = new Estudiante("Kevin", "de la Cruz Pérez", "G11");
				Estudiante e13 = new Estudiante("Lian Carlos", "Gené Galvez", "G13");
				Estudiante e14 = new Estudiante("Kim", "Kardashian", "G41");
				Estudiante e15 = new Estudiante("Ernesto Javier", "Diego Rodríguez", "G13");
				Estudiante e16 = new Estudiante("Francisco Daniel", "Garófalo Jerez", "G13");
				Estudiante e17 = new Estudiante("Angel Darío", "Gónzalez Vázquez", "G13");
				Estudiante e18 = new Estudiante("Michael", "Jackson", "G12");
				Estudiante e19 = new Estudiante("Lebron", "James", "G31");
				Estudiante e20 = new Estudiante("Aleksandr", "Castañeda Morales", "G12");
				Estudiante e21 = new Estudiante("Alexandro", "Váldes Piñeda", "G12");
				Estudiante e22 = new Estudiante("Gloria", "Santos Rosado", "G12");
				Estudiante e23 = new Estudiante("Aylin", "Vázquez Álvarez", "G12");
				Estudiante e24 = new Estudiante("Frank Abel", "Martínez Rodríguez", "G11");
				Estudiante e25 = new Estudiante("Gabriel Esteban", "Rodríguez Delgado", "G13");
				Estudiante e26 = new Estudiante("Patricia", "Mieres Díaz", "G21");
				Estudiante e27 = new Estudiante("Neldris", "Figueredo Acosta", "G22");
				Estudiante e28 = new Estudiante("Maikel Alejandro", "García Bolívar", "G14");
				Estudiante e29 = new Estudiante("Jonathan", "Váldes Bogaert", "G14");
				Estudiante e30 = new Estudiante("Zamira", "Manzano Sánchez", "G12");
				Estudiante e31 = new Estudiante("Erika", "Risco García", "G11");
				Estudiante e32 = new Estudiante("Alejandro José", "Sardiñas Salomón", "G31");
				Estudiante e33 = new Estudiante("Javier", "Otero Olave", "G13");
				Estudiante e34 = new Estudiante("Diego", "Fernández Rego", "G13");
				Estudiante e35 = new Estudiante("Pedro", "Ramírez Falcón", "G31");
				Estudiante e36 = new Estudiante("Daniela", "Quintero Delfín", "G14");
				Estudiante e37 = new Estudiante("Jhonathan", "Salgado Torres", "G13");
				Estudiante e38 = new Estudiante("Lionelis", "Tornés Miró", "G13");
				Estudiante e39 = new Estudiante("Eniley", "Peñalver Abreu", "G11");
				Estudiante e40 = new Estudiante("Sharlenee", "Calvo Martínez", "G14");

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

				depto1.agregarEstudiante(e1); 
				depto1.agregarEstudiante(e2); 
				depto1.agregarEstudiante(e3);
				depto1.agregarEstudiante(e4); 
				depto1.agregarEstudiante(e5); 
				depto1.agregarEstudiante(e6);
				depto1.agregarEstudiante(e7); 
				depto1.agregarEstudiante(e8); 
				depto1.agregarEstudiante(e9);
				depto1.agregarEstudiante(e10); 
				depto1.agregarEstudiante(e11); 
				depto1.agregarEstudiante(e12);
				depto1.agregarEstudiante(e13); 
				
				depto2.agregarEstudiante(e14); 
				depto2.agregarEstudiante(e15);
				depto2.agregarEstudiante(e16); 
				depto2.agregarEstudiante(e17); 
				depto2.agregarEstudiante(e18);
				depto2.agregarEstudiante(e19); 
				depto2.agregarEstudiante(e20); 
				depto2.agregarEstudiante(e21); 
				depto2.agregarEstudiante(e22); 
				depto2.agregarEstudiante(e23);
				depto2.agregarEstudiante(e24); 
				depto2.agregarEstudiante(e25); 
				depto2.agregarEstudiante(e26);
				depto2.agregarEstudiante(e27); 
				
				depto3.agregarEstudiante(e28); 
				depto3.agregarEstudiante(e29);
				depto3.agregarEstudiante(e30); 
				depto3.agregarEstudiante(e31); 
				depto3.agregarEstudiante(e32);
				depto3.agregarEstudiante(e33); 
				depto3.agregarEstudiante(e34); 
				depto3.agregarEstudiante(e35);
				depto3.agregarEstudiante(e36); 
				depto3.agregarEstudiante(e37); 
				depto3.agregarEstudiante(e38);
				depto3.agregarEstudiante(e39); 
				depto3.agregarEstudiante(e40);

				//Maestrias del departamento 1
				Maestria m1d1 = new Maestria("Maestría en Inteligencia Artificial", 24, "Ciencias de la Computación");
				Maestria m2d1 = new Maestria("Maestría en Ciberseguridad y Redes", 18,"Seguridad Informática");
				Maestria m3d1 = new Maestria("Maestría en Ciencia de Datos", 24, "Análisis de Datos");

				depto1.agregarMaestria(m1d1); 
				depto1.agregarMaestria(m2d1); 
				depto1.agregarMaestria(m3d1);

				//Maestrias del departamento 2
				Maestria m1d2 = new Maestria("Maestría en Sistemas de Potencia", 24, "Energía Eléctrica");
				Maestria m2d2 = new Maestria("Maestría en Automatización Industrial", 18, "Control de Procesos");
				Maestria m3d2 = new Maestria("Maestría en Telecomunicaciones", 24, "Comunicaciones Digitales");
				Maestria m4d2 = new Maestria("Maestría en Electrónica de Potencia", 18, "Electrónica Industrial");

				depto2.agregarMaestria(m1d2); 
				depto2.agregarMaestria(m2d2); 
				depto2.agregarMaestria(m3d2); 
				depto2.agregarMaestria(m4d2);

				//Maestrias del departamento 3
				Maestria m1d3 = new Maestria("Maestría en Matemática Aplicada", 24, "Modelos Matemáticos");
				Maestria m2d3 = new Maestria("Maestría en Estadística Avanzada", 18, "Análisis Estadístico");
				Maestria m3d3 = new Maestria("Maestría en Investigación Operativa", 24, "Optimización Matemática");
				Maestria m4d3 = new Maestria("Maestría en Matemática Financiera", 18, "Modelos Financieros");
				Maestria m5d3 = new Maestria("Maestría en Criptografía", 24, "Seguridad Matemática");

				depto3.agregarMaestria(m1d3); 
				depto3.agregarMaestria(m2d3); 
				depto3.agregarMaestria(m3d3); 
				depto3.agregarMaestria(m4d3); 
				depto3.agregarMaestria(m5d3);

				//Cursos de la maestria 1 del departamento 1
				CursoPosgrado c1m1d1 = new CursoPosgrado("Fundamentos de Inteligencia Artificial", new ArrayList<String>() {{ add("Comprender los fundamentos teóricos de la IA"); add("Aplicar algoritmos de aprendizaje automático"); }}, 4, d1);
				CursoPosgrado c2m1d1 = new CursoPosgrado("Redes Neuronales y Deep Learning", new ArrayList<String>() {{ add("Desarrollar modelos de redes neuronales"); add("Implementar soluciones de deep learning"); }}, 5, d1);
				CursoPosgrado c3m1d1 = new CursoPosgrado("Procesamiento de Lenguaje Natural", new ArrayList<String>() {{ add("Analizar problemas de procesamiento de lenguaje natural"); add("Implementar soluciones de NLP");}}, 4, d3);
				CursoPosgrado c4m1d1 = new CursoPosgrado("Visión por Computadora", new ArrayList<String>() {{add("Entender los principios de visión por computadora");add("Desarrollar aplicaciones de reconocimiento de imágenes"); }}, 5, d5);

				m1d1.agregarCursoPosgrado(c1m1d1);
				m1d1.agregarCursoPosgrado(c2m1d1);
				m1d1.agregarCursoPosgrado(c3m1d1);
				m1d1.agregarCursoPosgrado(c4m1d1);

				//Cursos de la maestria 2 del departamento 1
				CursoPosgrado c1m2d1 = new CursoPosgrado("Fundamentos de Ciberseguridad", new ArrayList<String>() {{ add("Comprender los principios de seguridad informática"); add("Analizar vulnerabilidades en sistemas"); }}, 4, d6);
				CursoPosgrado c2m2d1 = new CursoPosgrado("Criptografía Avanzada", new ArrayList<String>() {{ add("Implementar técnicas de criptografía moderna"); add("Analizar protocolos de seguridad"); }}, 5, d8);
				CursoPosgrado c3m2d1 = new CursoPosgrado("Seguridad en Redes", new ArrayList<String>() {{ add("Identificar amenazas en redes"); add("Diseñar redes seguras"); }}, 4, d13);

				m2d1.agregarCursoPosgrado(c1m2d1);
				m2d1.agregarCursoPosgrado(c2m2d1);
				m2d1.agregarCursoPosgrado(c3m2d1);

				//Cursos de la maestria 3 del departamento 1
				CursoPosgrado c1m3d1 = new CursoPosgrado("Análisis Exploratorio de Datos", new ArrayList<String>() {{ add("Manejar técnicas de análisis exploratorio de datos"); add("Visualizar datos efectivamente"); }}, 4, d31);
				CursoPosgrado c2m3d1 = new CursoPosgrado("Machine Learning Aplicado", new ArrayList<String>() {{ add("Aplicar algoritmos de aprendizaje automático"); add("Evaluar modelos predictivos"); }}, 5, d28);
				CursoPosgrado c3m3d1 = new CursoPosgrado("Big Data y Procesamiento Distribuido", new ArrayList<String>() {{ add("Procesar grandes volúmenes de datos"); add("Diseñar pipelines de datos"); }}, 5, d23);
				CursoPosgrado c4m3d1 = new CursoPosgrado("Visualización de Datos", new ArrayList<String>() {{ add("Visualizar datos complejos"); add("Comunicar hallazgos efectivamente"); }}, 4, d20);
				CursoPosgrado c5m3d1 = new CursoPosgrado("Gestión de Proyectos de Datos", new ArrayList<String>() {{ add("Gestionar proyectos de ciencia de datos"); add("Aplicar ética en el manejo de datos"); }}, 3, d21);

				m3d1.agregarCursoPosgrado(c1m3d1);
				m3d1.agregarCursoPosgrado(c2m3d1);
				m3d1.agregarCursoPosgrado(c3m3d1);
				m3d1.agregarCursoPosgrado(c4m3d1);
				m3d1.agregarCursoPosgrado(c5m3d1);

				//Cursos de la maestria 1 del departamento 2
				CursoPosgrado c1m1d2 = new CursoPosgrado("Análisis de Sistemas de Potencia", new ArrayList<String>() {{ add("Analizar flujos de carga en sistemas eléctricos"); add("Evaluar estabilidad en sistemas de potencia");}}, 4, d102);
				CursoPosgrado c2m1d2 = new CursoPosgrado("Protecciones Eléctricas", new ArrayList<String>() {{ add("Diseñar esquemas de protección para sistemas eléctricos"); add("Analizar fallas en sistemas de potencia"); }}, 5, d105);
				CursoPosgrado c3m1d2 = new CursoPosgrado("Generación Distribuida", new ArrayList<String>() {{ add("Evaluar impactos de generación distribuida"); add("Diseñar sistemas con fuentes renovables"); }}, 4, d108);

				m1d2.agregarCursoPosgrado(c1m1d2);
				m1d2.agregarCursoPosgrado(c2m1d2);
				m1d2.agregarCursoPosgrado(c3m1d2);

				//Cursos de la maestria 2 del departamento 2
				CursoPosgrado c1m2d2 = new CursoPosgrado("Control de Procesos Industriales", new ArrayList<String>() {{ add("Diseñar sistemas de control para procesos industriales"); add("Implementar estrategias de control PID"); }}, 4, d117);
				CursoPosgrado c2m2d2 = new CursoPosgrado("Sistemas SCADA", new ArrayList<String>() {{ add("Configurar sistemas SCADA industriales"); add("Implementar monitoreo remoto de procesos"); }}, 5, d120);
				CursoPosgrado c3m2d2 = new CursoPosgrado("Robótica Industrial", new ArrayList<String>() {{ add("Programar robots industriales"); add("Diseñar células de trabajo automatizadas"); }}, 4, d126);

				m2d2.agregarCursoPosgrado(c1m2d2);
				m2d2.agregarCursoPosgrado(c2m2d2);
				m2d2.agregarCursoPosgrado(c3m2d2);

				//Cursos de la maestria 3 del departamento 2
				CursoPosgrado c1m3d2 = new CursoPosgrado("Redes de Telecomunicaciones", new ArrayList<String>() {{ add("Diseñar arquitecturas de redes de telecomunicaciones"); add("Analizar protocolos de comunicación"); }}, 4, d129);
				CursoPosgrado c2m3d2 = new CursoPosgrado("Comunicaciones Digitales", new ArrayList<String>() {{ add("Implementar sistemas de modulación digital"); add("Analizar desempeño de sistemas de comunicación"); }}, 5, d132);
				CursoPosgrado c3m3d2 = new CursoPosgrado("Redes FiveG", new ArrayList<String>() {{ add("Evaluar tecnologías para redes FiveG"); add("Diseñar redes de nueva generación"); }}, 4, d35);
				CursoPosgrado c4m3d2 = new CursoPosgrado("Fibra Óptica", new ArrayList<String>() {{ add("Diseñar sistemas de transmisión por fibra óptica"); add("Analizar parámetros de desempeño en fibras"); }}, 4, d135);

				m3d2.agregarCursoPosgrado(c1m3d2);
				m3d2.agregarCursoPosgrado(c2m3d2);
				m3d2.agregarCursoPosgrado(c3m3d2);
				m3d2.agregarCursoPosgrado(c4m3d2);

				//Cursos de la maestria 4 del departamento 2
				CursoPosgrado c1m4d2 = new CursoPosgrado("Convertidores Electrónicos", new ArrayList<String>() {{add("Diseñar convertidores CC CC y CC CA"); add("Analizar topologías de conversión"); }}, 4, d153);
				CursoPosgrado c2m4d2 = new CursoPosgrado("Accionamientos Eléctricos", new ArrayList<String>() {{add("Implementar control de motores eléctricos"); add("Diseñar sistemas de accionamiento variable"); }}, 5, d156);
				CursoPosgrado c3m4d2 = new CursoPosgrado("Calidad de Energía", new ArrayList<String>() {{add("Analizar problemas de calidad de energía"); add("Diseñar sistemas de compensación");}}, 4, d159);

				m4d2.agregarCursoPosgrado(c1m4d2);
				m4d2.agregarCursoPosgrado(c2m4d2);
				m4d2.agregarCursoPosgrado(c3m4d2);
				
				// Cursos de la maestria 1 del departamento 3
				CursoPosgrado c1m1d3 = new CursoPosgrado("Modelos Matemáticos Avanzados", new ArrayList<String>() {{ add("Aplicar modelos matemáticos a problemas complejos"); add("Desarrollar soluciones basadas en modelación matemática");  }}, 4, d201);
				CursoPosgrado c2m1d3 = new CursoPosgrado("Ecuaciones Diferenciales", new ArrayList<String>() {{ add("Resolver ecuaciones diferenciales complejas"); add("Aplicar ecuaciones diferenciales en modelado físico"); }}, 5, d204);
				CursoPosgrado c3m1d3 = new CursoPosgrado("Análisis Numérico", new ArrayList<String>() {{ add("Implementar métodos numéricos para resolver problemas matemáticos");add("Analizar errores en cálculos numéricos");}}, 4, d207);

				m1d3.agregarCursoPosgrado(c1m1d3);
				m1d3.agregarCursoPosgrado(c2m1d3);
				m1d3.agregarCursoPosgrado(c3m1d3);

				// Cursos de la maestria 2 del departamento 3
				CursoPosgrado c1m2d3 = new CursoPosgrado("Estadística Multivariante", new ArrayList<String>() {{ add("Aplicar técnicas estadísticas multivariantes"); add("Interpretar resultados de análisis multivariados"); }}, 4, d210);
				CursoPosgrado c2m2d3 = new CursoPosgrado("Diseño de Experimentos", new ArrayList<String>() {{ add("Planificar diseños experimentales eficientes");add("Analizar datos de experimentos científicos"); }}, 5, d213);
			    CursoPosgrado c3m2d3 = new CursoPosgrado("Series Temporales", new ArrayList<String>() {{add("Modelar y predecir series temporales");add("Aplicar técnicas de suavizado y descomposición"); }}, 4, d216);

				m2d3.agregarCursoPosgrado(c1m2d3);
				m2d3.agregarCursoPosgrado(c2m2d3);
				m2d3.agregarCursoPosgrado(c3m2d3);

				// Cursos de la maestria 3 del departamento 3
				CursoPosgrado c1m3d3 = new CursoPosgrado("Optimización Lineal", new ArrayList<String>() {{ add("Formular problemas de optimización lineal"); add("Resolver modelos usando métodos simplex"); }}, 4, d219);			    
				CursoPosgrado c2m3d3 = new CursoPosgrado("Programación Dinámica", new ArrayList<String>() {{ add("Aplicar principios de programación dinámica");add("Resolver problemas de optimización multietapa"); }}, 5, d222);   
				CursoPosgrado c3m3d3 = new CursoPosgrado("Teoría de Juegos", new ArrayList<String>() {{add("Analizar estrategias en situaciones competitivas"); add("Aplicar modelos de teoría de juegos");}}, 4, d225);    
				CursoPosgrado c4m3d3 = new CursoPosgrado("Optimización en Redes", new ArrayList<String>() {{add("Resolver problemas de flujo en redes"); add("Aplicar algoritmos de optimización en grafos");}}, 4, d228);

				m3d3.agregarCursoPosgrado(c1m3d3);
				m3d3.agregarCursoPosgrado(c2m3d3);
				m3d3.agregarCursoPosgrado(c3m3d3);
				m3d3.agregarCursoPosgrado(c4m3d3);

				// Cursos de la maestria 4 del departamento 3
				CursoPosgrado c1m4d3 = new CursoPosgrado("Modelos Financieros Avanzados", new ArrayList<String>() {{add("Desarrollar modelos matemáticos para finanzas");add("Evaluar riesgos en instrumentos financieros"); }}, 4, d231);		    
				CursoPosgrado c2m4d3 = new CursoPosgrado("Derivados Financieros", new ArrayList<String>() {{add("Valorar instrumentos derivados"); add("Aplicar modelos de fijación de precios"); }}, 5, d234);
				CursoPosgrado c3m4d3 = new CursoPosgrado("Gestión de Riesgos", new ArrayList<String>() {{add("Cuantificar riesgos financieros");add("Implementar estrategias de cobertura"); }}, 4, d237);

				m4d3.agregarCursoPosgrado(c1m4d3);
				m4d3.agregarCursoPosgrado(c2m4d3);
				m4d3.agregarCursoPosgrado(c3m4d3);

				// Cursos de la maestria 5 del departamento 3
				CursoPosgrado c1m5d3 = new CursoPosgrado("Algoritmos Criptográficos", new ArrayList<String>() {{ add("Implementar algoritmos criptográficos modernos");add("Analizar fortalezas de sistemas criptográficos");}}, 4, d240);	    
				CursoPosgrado c2m5d3 = new CursoPosgrado("Seguridad Computacional",  new ArrayList<String>() {{ add("Evaluar vulnerabilidades en sistemas informáticos"); add("Diseñar protocolos seguros"); }}, 5, d243);
				CursoPosgrado c3m5d3 = new CursoPosgrado("Teoría de Números Aplicada", new ArrayList<String>() {{add("Aplicar conceptos avanzados de teoría de números");add("Resolver problemas criptográficos con métodos numéricos");}}, 4, d246);
				CursoPosgrado c4m5d3 = new CursoPosgrado("Firma Digital y Autenticación", new ArrayList<String>() {{add("Implementar sistemas de firma digital"); add("Diseñar protocolos de autenticación segura"); }}, 4, d252);

				m5d3.agregarCursoPosgrado(c1m5d3);
				m5d3.agregarCursoPosgrado(c2m5d3);
				m5d3.agregarCursoPosgrado(c3m5d3);
				m5d3.agregarCursoPosgrado(c4m5d3);
				
				//Matricular docentes en maestrias del departamento 1
				m1d1.agregarMatriculado(d4);
				m1d1.agregarMatriculado(d9);
				m1d1.agregarMatriculado(d14);
				m1d1.agregarMatriculado(d19);
				m1d1.agregarMatriculado(d24);
				m1d1.agregarMatriculado(d29);
				m1d1.agregarMatriculado(d34);
				m1d1.agregarMatriculado(d39);
				m1d1.agregarMatriculado(d44);
				m1d1.agregarMatriculado(d49);
				
				m2d1.agregarMatriculado(d54);
				m2d1.agregarMatriculado(d59);
				m2d1.agregarMatriculado(d61);
				m2d1.agregarMatriculado(d64);
				m2d1.agregarMatriculado(d67);
				m2d1.agregarMatriculado(d70);
				m2d1.agregarMatriculado(d73);
				m2d1.agregarMatriculado(d76);
				m2d1.agregarMatriculado(d79);
				
				m3d1.agregarMatriculado(d82);
				m3d1.agregarMatriculado(d85);
				m3d1.agregarMatriculado(d88);
				m3d1.agregarMatriculado(d91);
				m3d1.agregarMatriculado(d94);
				m3d1.agregarMatriculado(d97);
				m3d1.agregarMatriculado(d100);
				
				//Matricular docentes en maestrias del departamento 2
				m1d2.agregarMatriculado(d103);
				m1d2.agregarMatriculado(d106);
				m1d2.agregarMatriculado(d109);
				m1d2.agregarMatriculado(d112);
				m1d2.agregarMatriculado(d115);
				m1d2.agregarMatriculado(d118);
				m1d2.agregarMatriculado(d121);
				m1d2.agregarMatriculado(d124);
				m1d2.agregarMatriculado(d127);
				
				m2d2.agregarMatriculado(d130);
				m2d2.agregarMatriculado(d133);
				m2d2.agregarMatriculado(d136);
				m2d2.agregarMatriculado(d139);
				m2d2.agregarMatriculado(d142);
				m2d2.agregarMatriculado(d145);
				m2d2.agregarMatriculado(d148);
				m2d2.agregarMatriculado(d151);
				m2d2.agregarMatriculado(d154);
				
				m3d2.agregarMatriculado(d157);
				m3d2.agregarMatriculado(d160);
				m3d2.agregarMatriculado(d163);
				m3d2.agregarMatriculado(d166);
				m3d2.agregarMatriculado(d169);
				m3d2.agregarMatriculado(d172);
				m3d2.agregarMatriculado(d175);
				m3d2.agregarMatriculado(d178);
				
				m4d2.agregarMatriculado(d181);
				m4d2.agregarMatriculado(d184);
				m4d2.agregarMatriculado(d187);
				m4d2.agregarMatriculado(d190);
				m4d2.agregarMatriculado(d193);
				m4d2.agregarMatriculado(d196);
				m4d2.agregarMatriculado(d199);
				
				//Matricular docentes en maestrias del departamento 3
				m1d3.agregarMatriculado(d202);
				m1d3.agregarMatriculado(d205);
				m1d3.agregarMatriculado(d208);
				m1d3.agregarMatriculado(d211);
				m1d3.agregarMatriculado(d214);
				m1d3.agregarMatriculado(d217);
				m1d3.agregarMatriculado(d220);
				
				m2d3.agregarMatriculado(d223);
				m2d3.agregarMatriculado(d226);
				m2d3.agregarMatriculado(d229);
				m2d3.agregarMatriculado(d232);
				m2d3.agregarMatriculado(d235);
				m2d3.agregarMatriculado(d238);
				m2d3.agregarMatriculado(d241);
				
				m3d3.agregarMatriculado(d244);
				m3d3.agregarMatriculado(d247);
				m3d3.agregarMatriculado(d250);
				m3d3.agregarMatriculado(d253);
				m3d3.agregarMatriculado(d256);
				m3d3.agregarMatriculado(d259);
				
				m4d3.agregarMatriculado(d262);
				m4d3.agregarMatriculado(d265);
				m4d3.agregarMatriculado(d268);
				m4d3.agregarMatriculado(d271);
				m4d3.agregarMatriculado(d274);
				m4d3.agregarMatriculado(d277);
				m4d3.agregarMatriculado(d280);
				
				m5d3.agregarMatriculado(d283);
				m5d3.agregarMatriculado(d286);
				m5d3.agregarMatriculado(d289);
				m5d3.agregarMatriculado(d292);
				m5d3.agregarMatriculado(d295);
				m5d3.agregarMatriculado(d298);
				
				//Agregar participantes a cursos de Maestrias de Departamento 1
				c1m1d1.agregarParticipante(d4);
				c1m1d1.agregarParticipante(d9);
				c1m1d1.agregarParticipante(d14);
				c1m1d1.agregarParticipante(d19);
				c1m1d1.agregarParticipante(d24);
				c1m1d1.agregarParticipante(d29);
				c1m1d1.agregarParticipante(d34);
				c1m1d1.agregarParticipante(d39);
				c1m1d1.agregarParticipante(d44);
				c1m1d1.agregarParticipante(d49);

				c2m1d1.agregarParticipante(d4);
				c2m1d1.agregarParticipante(d9);
				c2m1d1.agregarParticipante(d14);
				c2m1d1.agregarParticipante(d19);
				c2m1d1.agregarParticipante(d24);
				c2m1d1.agregarParticipante(d29);
				c2m1d1.agregarParticipante(d34);
				c2m1d1.agregarParticipante(d39);
				c2m1d1.agregarParticipante(d44);
				c2m1d1.agregarParticipante(d49);

				c3m1d1.agregarParticipante(d4);
				c3m1d1.agregarParticipante(d9);
				c3m1d1.agregarParticipante(d14);
				c3m1d1.agregarParticipante(d19);
				c3m1d1.agregarParticipante(d24);
				c3m1d1.agregarParticipante(d29);
				c3m1d1.agregarParticipante(d34);
				c3m1d1.agregarParticipante(d39);
				c3m1d1.agregarParticipante(d44);
				c3m1d1.agregarParticipante(d49);

				c4m1d1.agregarParticipante(d4);
				c4m1d1.agregarParticipante(d9);
				c4m1d1.agregarParticipante(d14);
				c4m1d1.agregarParticipante(d19);
				c4m1d1.agregarParticipante(d24);
				c4m1d1.agregarParticipante(d29);
				c4m1d1.agregarParticipante(d34);
				c4m1d1.agregarParticipante(d39);
				c4m1d1.agregarParticipante(d44);
				c4m1d1.agregarParticipante(d49);

				c1m2d1.agregarParticipante(d54);
				c1m2d1.agregarParticipante(d59);
				c1m2d1.agregarParticipante(d61);
				c1m2d1.agregarParticipante(d64);
				c1m2d1.agregarParticipante(d67);
				c1m2d1.agregarParticipante(d70);
				c1m2d1.agregarParticipante(d73);
				c1m2d1.agregarParticipante(d76);
				c1m2d1.agregarParticipante(d79);

				c2m2d1.agregarParticipante(d54);
				c2m2d1.agregarParticipante(d59);
				c2m2d1.agregarParticipante(d61);
				c2m2d1.agregarParticipante(d64);
				c2m2d1.agregarParticipante(d67);
				c2m2d1.agregarParticipante(d70);
				c2m2d1.agregarParticipante(d73);
				c2m2d1.agregarParticipante(d76);
				c2m2d1.agregarParticipante(d79);

				c3m2d1.agregarParticipante(d54);
				c3m2d1.agregarParticipante(d59);
				c3m2d1.agregarParticipante(d61);
				c3m2d1.agregarParticipante(d64);
				c3m2d1.agregarParticipante(d67);
				c3m2d1.agregarParticipante(d70);
				c3m2d1.agregarParticipante(d73);
				c3m2d1.agregarParticipante(d76);
				c3m2d1.agregarParticipante(d79);

				c1m3d1.agregarParticipante(d82);
				c1m3d1.agregarParticipante(d85);
				c1m3d1.agregarParticipante(d88);
				c1m3d1.agregarParticipante(d91);
				c1m3d1.agregarParticipante(d94);
				c1m3d1.agregarParticipante(d97);
				c1m3d1.agregarParticipante(d100);

				c2m3d1.agregarParticipante(d82);
				c2m3d1.agregarParticipante(d85);
				c2m3d1.agregarParticipante(d88);
				c2m3d1.agregarParticipante(d91);
				c2m3d1.agregarParticipante(d94);
				c2m3d1.agregarParticipante(d97);
				c2m3d1.agregarParticipante(d100);

				c3m3d1.agregarParticipante(d82);
				c3m3d1.agregarParticipante(d85);
				c3m3d1.agregarParticipante(d88);
				c3m3d1.agregarParticipante(d91);
				c3m3d1.agregarParticipante(d94);
				c3m3d1.agregarParticipante(d97);
				c3m3d1.agregarParticipante(d100);

				c4m3d1.agregarParticipante(d82);
				c4m3d1.agregarParticipante(d85);
				c4m3d1.agregarParticipante(d88);
				c4m3d1.agregarParticipante(d91);
				c4m3d1.agregarParticipante(d94);
				c4m3d1.agregarParticipante(d97);
				c4m3d1.agregarParticipante(d100);

				c5m3d1.agregarParticipante(d82);
				c5m3d1.agregarParticipante(d85);
				c5m3d1.agregarParticipante(d88);
				c5m3d1.agregarParticipante(d91);
				c5m3d1.agregarParticipante(d94);
				c5m3d1.agregarParticipante(d97);
				c5m3d1.agregarParticipante(d100);
				
				
				//Agregar participantes a cursos de Maestrías del departamento 2
				c1m1d2.agregarParticipante(d103);
				c1m1d2.agregarParticipante(d106);
				c1m1d2.agregarParticipante(d109);
				c1m1d2.agregarParticipante(d112);
				c1m1d2.agregarParticipante(d115);
				c1m1d2.agregarParticipante(d118);
				c1m1d2.agregarParticipante(d121);
				c1m1d2.agregarParticipante(d124);
				c1m1d2.agregarParticipante(d127);

				c2m1d2.agregarParticipante(d103);
				c2m1d2.agregarParticipante(d106);
				c2m1d2.agregarParticipante(d109);
				c2m1d2.agregarParticipante(d112);
				c2m1d2.agregarParticipante(d115);
				c2m1d2.agregarParticipante(d118);
				c2m1d2.agregarParticipante(d121);
				c2m1d2.agregarParticipante(d124);
				c2m1d2.agregarParticipante(d127);

				c3m1d2.agregarParticipante(d103);
				c3m1d2.agregarParticipante(d106);
				c3m1d2.agregarParticipante(d109);
				c3m1d2.agregarParticipante(d112);
				c3m1d2.agregarParticipante(d115);
				c3m1d2.agregarParticipante(d118);
				c3m1d2.agregarParticipante(d121);
				c3m1d2.agregarParticipante(d124);
				c3m1d2.agregarParticipante(d127);

				c1m2d2.agregarParticipante(d130);
				c1m2d2.agregarParticipante(d133);
				c1m2d2.agregarParticipante(d136);
				c1m2d2.agregarParticipante(d139);
				c1m2d2.agregarParticipante(d142);
				c1m2d2.agregarParticipante(d145);
				c1m2d2.agregarParticipante(d148);
				c1m2d2.agregarParticipante(d151);
				c1m2d2.agregarParticipante(d154);

				c2m2d2.agregarParticipante(d130);
				c2m2d2.agregarParticipante(d133);
				c2m2d2.agregarParticipante(d136);
				c2m2d2.agregarParticipante(d139);
				c2m2d2.agregarParticipante(d142);
				c2m2d2.agregarParticipante(d145);
				c2m2d2.agregarParticipante(d148);
				c2m2d2.agregarParticipante(d151);
				c2m2d2.agregarParticipante(d154);

				c3m2d2.agregarParticipante(d130);
				c3m2d2.agregarParticipante(d133);
				c3m2d2.agregarParticipante(d136);
				c3m2d2.agregarParticipante(d139);
				c3m2d2.agregarParticipante(d142);
				c3m2d2.agregarParticipante(d145);
				c3m2d2.agregarParticipante(d148);
				c3m2d2.agregarParticipante(d151);
				c3m2d2.agregarParticipante(d154);

				c1m3d2.agregarParticipante(d157);
				c1m3d2.agregarParticipante(d160);
				c1m3d2.agregarParticipante(d163);
				c1m3d2.agregarParticipante(d166);
				c1m3d2.agregarParticipante(d169);
				c1m3d2.agregarParticipante(d172);
				c1m3d2.agregarParticipante(d175);
				c1m3d2.agregarParticipante(d178);

				c2m3d2.agregarParticipante(d157);
				c2m3d2.agregarParticipante(d160);
				c2m3d2.agregarParticipante(d163);
				c2m3d2.agregarParticipante(d166);
				c2m3d2.agregarParticipante(d169);
				c2m3d2.agregarParticipante(d172);
				c2m3d2.agregarParticipante(d175);
				c2m3d2.agregarParticipante(d178);

				c3m3d2.agregarParticipante(d157);
				c3m3d2.agregarParticipante(d160);
				c3m3d2.agregarParticipante(d163);
				c3m3d2.agregarParticipante(d166);
				c3m3d2.agregarParticipante(d169);
				c3m3d2.agregarParticipante(d172);
				c3m3d2.agregarParticipante(d175);
				c3m3d2.agregarParticipante(d178);

				c4m3d2.agregarParticipante(d157);
				c4m3d2.agregarParticipante(d160);
				c4m3d2.agregarParticipante(d163);
				c4m3d2.agregarParticipante(d166);
				c4m3d2.agregarParticipante(d169);
				c4m3d2.agregarParticipante(d172);
				c4m3d2.agregarParticipante(d175);
				c4m3d2.agregarParticipante(d178);

				c1m4d2.agregarParticipante(d181);
				c1m4d2.agregarParticipante(d184);
				c1m4d2.agregarParticipante(d187);
				c1m4d2.agregarParticipante(d190);
				c1m4d2.agregarParticipante(d193);
				c1m4d2.agregarParticipante(d196);
				c1m4d2.agregarParticipante(d199);

				c2m4d2.agregarParticipante(d181);
				c2m4d2.agregarParticipante(d184);
				c2m4d2.agregarParticipante(d187);
				c2m4d2.agregarParticipante(d190);
				c2m4d2.agregarParticipante(d193);
				c2m4d2.agregarParticipante(d196);
				c2m4d2.agregarParticipante(d199);

				c3m4d2.agregarParticipante(d181);
				c3m4d2.agregarParticipante(d184);
				c3m4d2.agregarParticipante(d187);
				c3m4d2.agregarParticipante(d190);
				c3m4d2.agregarParticipante(d193);
				c3m4d2.agregarParticipante(d196);
				c3m4d2.agregarParticipante(d199);
				
				//Agregar participantes a cursos de Maestrías del departamento 3
				c1m1d3.agregarParticipante(d202);
				c1m1d3.agregarParticipante(d205);
				c1m1d3.agregarParticipante(d208);
				c1m1d3.agregarParticipante(d211);
				c1m1d3.agregarParticipante(d214);
				c1m1d3.agregarParticipante(d217);
				c1m1d3.agregarParticipante(d220);

				c2m1d3.agregarParticipante(d202);
				c2m1d3.agregarParticipante(d205);
				c2m1d3.agregarParticipante(d208);
				c2m1d3.agregarParticipante(d211);
				c2m1d3.agregarParticipante(d214);
				c2m1d3.agregarParticipante(d217);
				c2m1d3.agregarParticipante(d220);

				c3m1d3.agregarParticipante(d202);
				c3m1d3.agregarParticipante(d205);
				c3m1d3.agregarParticipante(d208);
				c3m1d3.agregarParticipante(d211);
				c3m1d3.agregarParticipante(d214);
				c3m1d3.agregarParticipante(d217);
				c3m1d3.agregarParticipante(d220);
				
				c1m2d3.agregarParticipante(d223);
				c1m2d3.agregarParticipante(d226);
				c1m2d3.agregarParticipante(d229);
				c1m2d3.agregarParticipante(d232);
				c1m2d3.agregarParticipante(d235);
				c1m2d3.agregarParticipante(d238);
				c1m2d3.agregarParticipante(d241);

				c2m2d3.agregarParticipante(d223);
				c2m2d3.agregarParticipante(d226);
				c2m2d3.agregarParticipante(d229);
				c2m2d3.agregarParticipante(d232);
				c2m2d3.agregarParticipante(d235);
				c2m2d3.agregarParticipante(d238);
				c2m2d3.agregarParticipante(d241);

				c3m2d3.agregarParticipante(d223);
				c3m2d3.agregarParticipante(d226);
				c3m2d3.agregarParticipante(d229);
				c3m2d3.agregarParticipante(d232);
				c3m2d3.agregarParticipante(d235);
				c3m2d3.agregarParticipante(d238);
				c3m2d3.agregarParticipante(d241);

				c1m3d3.agregarParticipante(d244);
				c1m3d3.agregarParticipante(d247);
				c1m3d3.agregarParticipante(d250);
				c1m3d3.agregarParticipante(d253);
				c1m3d3.agregarParticipante(d256);
				c1m3d3.agregarParticipante(d259);

				c2m3d3.agregarParticipante(d244);
				c2m3d3.agregarParticipante(d247);
				c2m3d3.agregarParticipante(d250);
				c2m3d3.agregarParticipante(d253);
				c2m3d3.agregarParticipante(d256);
				c2m3d3.agregarParticipante(d259);

				c3m3d3.agregarParticipante(d244);
				c3m3d3.agregarParticipante(d247);
				c3m3d3.agregarParticipante(d250);
				c3m3d3.agregarParticipante(d253);
				c3m3d3.agregarParticipante(d256);
				c3m3d3.agregarParticipante(d259);

				c4m3d3.agregarParticipante(d244);
				c4m3d3.agregarParticipante(d247);
				c4m3d3.agregarParticipante(d250);
				c4m3d3.agregarParticipante(d253);
				c4m3d3.agregarParticipante(d256);
				c4m3d3.agregarParticipante(d259);

				c1m4d3.agregarParticipante(d262);
				c1m4d3.agregarParticipante(d265);
				c1m4d3.agregarParticipante(d268);
				c1m4d3.agregarParticipante(d271);
				c1m4d3.agregarParticipante(d274);
				c1m4d3.agregarParticipante(d277);
				c1m4d3.agregarParticipante(d280);

				c2m4d3.agregarParticipante(d262);
				c2m4d3.agregarParticipante(d265);
				c2m4d3.agregarParticipante(d268);
				c2m4d3.agregarParticipante(d271);
				c2m4d3.agregarParticipante(d274);
				c2m4d3.agregarParticipante(d277);
				c2m4d3.agregarParticipante(d280);

				c3m4d3.agregarParticipante(d262);
				c3m4d3.agregarParticipante(d265);
				c3m4d3.agregarParticipante(d268);
				c3m4d3.agregarParticipante(d271);
				c3m4d3.agregarParticipante(d274);
				c3m4d3.agregarParticipante(d277);
				c3m4d3.agregarParticipante(d280);

				c1m5d3.agregarParticipante(d283);
				c1m5d3.agregarParticipante(d286);
				c1m5d3.agregarParticipante(d289);
				c1m5d3.agregarParticipante(d292);
				c1m5d3.agregarParticipante(d295);
				c1m5d3.agregarParticipante(d298);

				c2m5d3.agregarParticipante(d283);
				c2m5d3.agregarParticipante(d286);
				c2m5d3.agregarParticipante(d289);
				c2m5d3.agregarParticipante(d292);
				c2m5d3.agregarParticipante(d295);
				c2m5d3.agregarParticipante(d298);

				c3m5d3.agregarParticipante(d283);
				c3m5d3.agregarParticipante(d286);
				c3m5d3.agregarParticipante(d289);
				c3m5d3.agregarParticipante(d292);
				c3m5d3.agregarParticipante(d295);
				c3m5d3.agregarParticipante(d298);

				c4m5d3.agregarParticipante(d283);
				c4m5d3.agregarParticipante(d286);
				c4m5d3.agregarParticipante(d289);
				c4m5d3.agregarParticipante(d292);
				c4m5d3.agregarParticipante(d295);
				c4m5d3.agregarParticipante(d298);
				
				//Se crean lineas de investigacion y se agregan al departamento 1
				LineaInvestigacion li1d1 = new LineaInvestigacion("Inteligencia Artificial y Aprendizaje Automático");
				LineaInvestigacion li2d1 = new LineaInvestigacion("Ciberseguridad y Redes Avanzadas");
				LineaInvestigacion li3d1 = new LineaInvestigacion("Ciencia de Datos y Big Data");

				depto1.agregarLineaInvestigacion(li1d1);
				depto1.agregarLineaInvestigacion(li2d1);
				depto1.agregarLineaInvestigacion(li3d1);

				//Se crean lineas de investigacion y se agregan al departamento 2
				LineaInvestigacion li1d2 = new LineaInvestigacion("Sistemas de Energía y Potencia");
				LineaInvestigacion li2d2 = new LineaInvestigacion("Automatización y Control Industrial");
				LineaInvestigacion li3d2 = new LineaInvestigacion("Telecomunicaciones y Redes Inteligentes");
				LineaInvestigacion li4d2 = new LineaInvestigacion("Electrónica de Potencia y Convertidores");

				depto2.agregarLineaInvestigacion(li1d2);
				depto2.agregarLineaInvestigacion(li2d2);
				depto2.agregarLineaInvestigacion(li3d2);
				depto2.agregarLineaInvestigacion(li4d2);

				//Se crean lineas de investigacion y se agregan al departamento 3
				LineaInvestigacion li1d3 = new LineaInvestigacion("Modelación Matemática y Simulación");
				LineaInvestigacion li2d3 = new LineaInvestigacion("Estadística Avanzada y Análisis de Datos");
				LineaInvestigacion li3d3 = new LineaInvestigacion("Investigación Operativa y Optimización");
				LineaInvestigacion li4d3 = new LineaInvestigacion("Matemática Financiera y Actuarial");
				LineaInvestigacion li5d3 = new LineaInvestigacion("Criptografía y Seguridad Informática");

				depto3.agregarLineaInvestigacion(li1d3);
				depto3.agregarLineaInvestigacion(li2d3);
				depto3.agregarLineaInvestigacion(li3d3);
				depto3.agregarLineaInvestigacion(li4d3);
				depto3.agregarLineaInvestigacion(li5d3);
				
				//Agregando investigadores a las lineas del departamento 1, empezamos con los estudiantes que son la menor cantidad
				li1d1.agregarInvestigador(e1);  
				li1d1.agregarInvestigador(e4);  
				li1d1.agregarInvestigador(e7); 
				li1d1.agregarInvestigador(e10); 
				li1d1.agregarInvestigador(e13); 
				
				li2d1.agregarInvestigador(e2);  
				li2d1.agregarInvestigador(e5); 
				li2d1.agregarInvestigador(e8);  
				li2d1.agregarInvestigador(e11); 

				li3d1.agregarInvestigador(e3); 
				li3d1.agregarInvestigador(e6);  
				li3d1.agregarInvestigador(e9);  
				li3d1.agregarInvestigador(e12); 
				
				//Departamento 2 continua:
				li1d2.agregarInvestigador(e15);  
				li1d2.agregarInvestigador(e18);  
				li1d2.agregarInvestigador(e22);  
				li1d2.agregarInvestigador(e25);  

				li2d2.agregarInvestigador(e16); 
				li2d2.agregarInvestigador(e19);  
				li2d2.agregarInvestigador(e23);  
				li2d2.agregarInvestigador(e26); 

				li3d2.agregarInvestigador(e14); 
				li3d2.agregarInvestigador(e17);  
				li3d2.agregarInvestigador(e20);  
				li3d2.agregarInvestigador(e24);  

				li4d2.agregarInvestigador(e21); 
				li4d2.agregarInvestigador(e27);
				
				//Finalizamos con departamento 3:
				li1d3.agregarInvestigador(e28); 
				li1d3.agregarInvestigador(e33);  
				li1d3.agregarInvestigador(e38);  

				li2d3.agregarInvestigador(e29); 
				li2d3.agregarInvestigador(e34);  
				li2d3.agregarInvestigador(e39); 
			
				li3d3.agregarInvestigador(e30);
				li3d3.agregarInvestigador(e35); 
				li3d3.agregarInvestigador(e40); 

				li4d3.agregarInvestigador(e31);
				li4d3.agregarInvestigador(e36);  

				li5d3.agregarInvestigador(e32); 
				li5d3.agregarInvestigador(e37);
				
				//Empezar a agregar a los docentes
				li1d1.agregarInvestigador(d1); li1d1.agregarInvestigador(d4); li1d1.agregarInvestigador(d7); 
				li1d1.agregarInvestigador(d10); li1d1.agregarInvestigador(d13); li1d1.agregarInvestigador(d16); 
				li1d1.agregarInvestigador(d19); li1d1.agregarInvestigador(d22); li1d1.agregarInvestigador(d25); 
				li1d1.agregarInvestigador(d28); li1d1.agregarInvestigador(d31); li1d1.agregarInvestigador(d34); 
				li1d1.agregarInvestigador(d37); li1d1.agregarInvestigador(d40); li1d1.agregarInvestigador(d43); 
				li1d1.agregarInvestigador(d46); li1d1.agregarInvestigador(d49); li1d1.agregarInvestigador(d52); 
				li1d1.agregarInvestigador(d55); li1d1.agregarInvestigador(d58); li1d1.agregarInvestigador(d61); 
				li1d1.agregarInvestigador(d64); li1d1.agregarInvestigador(d67); li1d1.agregarInvestigador(d70); 
				li1d1.agregarInvestigador(d73);

				li2d1.agregarInvestigador(d2); li2d1.agregarInvestigador(d5); li2d1.agregarInvestigador(d8); 
				li2d1.agregarInvestigador(d11); li2d1.agregarInvestigador(d14); li2d1.agregarInvestigador(d17); 
				li2d1.agregarInvestigador(d20); li2d1.agregarInvestigador(d23); li2d1.agregarInvestigador(d26); 
				li2d1.agregarInvestigador(d29); li2d1.agregarInvestigador(d32); li2d1.agregarInvestigador(d35); 
				li2d1.agregarInvestigador(d38); li2d1.agregarInvestigador(d41); li2d1.agregarInvestigador(d44); 
				li2d1.agregarInvestigador(d47); li2d1.agregarInvestigador(d50); li2d1.agregarInvestigador(d53);

				li3d1.agregarInvestigador(d3); li3d1.agregarInvestigador(d6); li3d1.agregarInvestigador(d9); 
				li3d1.agregarInvestigador(d12); li3d1.agregarInvestigador(d15); li3d1.agregarInvestigador(d18); 
				li3d1.agregarInvestigador(d21); li3d1.agregarInvestigador(d24); li3d1.agregarInvestigador(d27); 
				li3d1.agregarInvestigador(d30); li3d1.agregarInvestigador(d33); li3d1.agregarInvestigador(d36); 
				li3d1.agregarInvestigador(d39); li3d1.agregarInvestigador(d42); li3d1.agregarInvestigador(d45); 
				li3d1.agregarInvestigador(d48); li3d1.agregarInvestigador(d51); li3d1.agregarInvestigador(d54); 
				li3d1.agregarInvestigador(d57); li3d1.agregarInvestigador(d60); li3d1.agregarInvestigador(d63); 
				li3d1.agregarInvestigador(d66);
				
				//Se continua con los del departamento 2
				li1d2.agregarInvestigador(d101); li1d2.agregarInvestigador(d105); li1d2.agregarInvestigador(d109);
				li1d2.agregarInvestigador(d113); li1d2.agregarInvestigador(d117); li1d2.agregarInvestigador(d121);
				li1d2.agregarInvestigador(d125); li1d2.agregarInvestigador(d129); li1d2.agregarInvestigador(d133);
				li1d2.agregarInvestigador(d137); li1d2.agregarInvestigador(d141); li1d2.agregarInvestigador(d145);
				li1d2.agregarInvestigador(d149); li1d2.agregarInvestigador(d153); li1d2.agregarInvestigador(d157);
				li1d2.agregarInvestigador(d161); li1d2.agregarInvestigador(d165); li1d2.agregarInvestigador(d169);
				li1d2.agregarInvestigador(d173); li1d2.agregarInvestigador(d177); li1d2.agregarInvestigador(d181);
				li1d2.agregarInvestigador(d185);

				li2d2.agregarInvestigador(d102); li2d2.agregarInvestigador(d106); li2d2.agregarInvestigador(d110);
				li2d2.agregarInvestigador(d114); li2d2.agregarInvestigador(d118); li2d2.agregarInvestigador(d122);
				li2d2.agregarInvestigador(d126); li2d2.agregarInvestigador(d130); li2d2.agregarInvestigador(d134);
				li2d2.agregarInvestigador(d138); li2d2.agregarInvestigador(d142); li2d2.agregarInvestigador(d146);
				li2d2.agregarInvestigador(d150); li2d2.agregarInvestigador(d154); li2d2.agregarInvestigador(d158);
				li2d2.agregarInvestigador(d162); li2d2.agregarInvestigador(d166); li2d2.agregarInvestigador(d170);

				li3d2.agregarInvestigador(d103); li3d2.agregarInvestigador(d107); li3d2.agregarInvestigador(d111);
				li3d2.agregarInvestigador(d115); li3d2.agregarInvestigador(d119); li3d2.agregarInvestigador(d123);
				li3d2.agregarInvestigador(d127); li3d2.agregarInvestigador(d131); li3d2.agregarInvestigador(d135);
				li3d2.agregarInvestigador(d139); li3d2.agregarInvestigador(d143); li3d2.agregarInvestigador(d147);
				li3d2.agregarInvestigador(d151); li3d2.agregarInvestigador(d155); li3d2.agregarInvestigador(d159);
				li3d2.agregarInvestigador(d163); li3d2.agregarInvestigador(d167); li3d2.agregarInvestigador(d171);
				li3d2.agregarInvestigador(d175); li3d2.agregarInvestigador(d179); li3d2.agregarInvestigador(d183);
				li3d2.agregarInvestigador(d187); li3d2.agregarInvestigador(d191); li3d2.agregarInvestigador(d195);

				li4d2.agregarInvestigador(d104); li4d2.agregarInvestigador(d108); li4d2.agregarInvestigador(d112);
				li4d2.agregarInvestigador(d116); li4d2.agregarInvestigador(d120); li4d2.agregarInvestigador(d124);
				li4d2.agregarInvestigador(d128); li4d2.agregarInvestigador(d132); li4d2.agregarInvestigador(d136);
				li4d2.agregarInvestigador(d140); li4d2.agregarInvestigador(d144); li4d2.agregarInvestigador(d148);
				li4d2.agregarInvestigador(d152); li4d2.agregarInvestigador(d156); li4d2.agregarInvestigador(d160);
				li4d2.agregarInvestigador(d164);
				
				//Departamento 3
				li1d3.agregarInvestigador(d201); li1d3.agregarInvestigador(d206); li1d3.agregarInvestigador(d211);
				li1d3.agregarInvestigador(d216); li1d3.agregarInvestigador(d221); li1d3.agregarInvestigador(d226);
				li1d3.agregarInvestigador(d231); li1d3.agregarInvestigador(d236); li1d3.agregarInvestigador(d241);
				li1d3.agregarInvestigador(d246); li1d3.agregarInvestigador(d251); li1d3.agregarInvestigador(d256);
				li1d3.agregarInvestigador(d261); li1d3.agregarInvestigador(d266); li1d3.agregarInvestigador(d271);
				li1d3.agregarInvestigador(d276); li1d3.agregarInvestigador(d281); li1d3.agregarInvestigador(d286);
				li1d3.agregarInvestigador(d291); li1d3.agregarInvestigador(d296); li1d3.agregarInvestigador(d202);
				li1d3.agregarInvestigador(d207);

				li2d3.agregarInvestigador(d203); li2d3.agregarInvestigador(d208); li2d3.agregarInvestigador(d213);
				li2d3.agregarInvestigador(d218); li2d3.agregarInvestigador(d223); li2d3.agregarInvestigador(d228);
				li2d3.agregarInvestigador(d233); li2d3.agregarInvestigador(d238); li2d3.agregarInvestigador(d243);
				li2d3.agregarInvestigador(d248); li2d3.agregarInvestigador(d253); li2d3.agregarInvestigador(d258);
				li2d3.agregarInvestigador(d263); li2d3.agregarInvestigador(d268); li2d3.agregarInvestigador(d273);
				li2d3.agregarInvestigador(d278); li2d3.agregarInvestigador(d283); li2d3.agregarInvestigador(d288);

				li3d3.agregarInvestigador(d204); li3d3.agregarInvestigador(d209); li3d3.agregarInvestigador(d214);
				li3d3.agregarInvestigador(d219); li3d3.agregarInvestigador(d224); li3d3.agregarInvestigador(d229);
				li3d3.agregarInvestigador(d234); li3d3.agregarInvestigador(d239); li3d3.agregarInvestigador(d244);
				li3d3.agregarInvestigador(d249); li3d3.agregarInvestigador(d254); li3d3.agregarInvestigador(d259);
				li3d3.agregarInvestigador(d264); li3d3.agregarInvestigador(d269); li3d3.agregarInvestigador(d274);
				li3d3.agregarInvestigador(d279); li3d3.agregarInvestigador(d284); li3d3.agregarInvestigador(d289);
				li3d3.agregarInvestigador(d294); li3d3.agregarInvestigador(d299);

				li4d3.agregarInvestigador(d205); li4d3.agregarInvestigador(d210); li4d3.agregarInvestigador(d215);
				li4d3.agregarInvestigador(d220); li4d3.agregarInvestigador(d225); li4d3.agregarInvestigador(d230);
				li4d3.agregarInvestigador(d235); li4d3.agregarInvestigador(d240); li4d3.agregarInvestigador(d245);
				li4d3.agregarInvestigador(d250); li4d3.agregarInvestigador(d255); li4d3.agregarInvestigador(d260);
				li4d3.agregarInvestigador(d265); li4d3.agregarInvestigador(d270); li4d3.agregarInvestigador(d275);
				li4d3.agregarInvestigador(d280);

				li5d3.agregarInvestigador(d212); li5d3.agregarInvestigador(d217); li5d3.agregarInvestigador(d222);
				li5d3.agregarInvestigador(d227); li5d3.agregarInvestigador(d232); li5d3.agregarInvestigador(d237);
				li5d3.agregarInvestigador(d242); li5d3.agregarInvestigador(d247); li5d3.agregarInvestigador(d252);
				li5d3.agregarInvestigador(d257); li5d3.agregarInvestigador(d262); li5d3.agregarInvestigador(d267);
				li5d3.agregarInvestigador(d272); li5d3.agregarInvestigador(d277);
				
				//Resultados de los investigadores del departamento 1
				Articulo art1 = new Articulo("Machine Learning Applications", 1, 10, "2020", 15, GrupoImpacto.WoS);
				Articulo art2 = new Articulo("Cybersecurity Trends", 2, 5, "2019", 20, GrupoImpacto.GRUPO_1);
				Articulo art3 = new Articulo("Data Science Methods", 3, 8, "2021", 12, GrupoImpacto.GRUPO_2);
				Articulo art4 = new Articulo("Artificial Neural Networks", 4, 12, "2018", 18, GrupoImpacto.GRUPO_3);
				Articulo art5 = new Articulo("Blockchain Technology", 5, 7, "2022", 14, GrupoImpacto.GRUPO_4);
				Articulo art6 = new Articulo("Quantum Computing", 6, 9, "2020", 22, GrupoImpacto.WoS);
				Articulo art7 = new Articulo("Cloud Computing Security", 7, 3, "2019", 16, GrupoImpacto.GRUPO_1);
				Articulo art8 = new Articulo("Natural Language Processing", 8, 11, "2021", 13, GrupoImpacto.GRUPO_2);
				Articulo art9 = new Articulo("Computer Vision", 9, 6, "2018", 19, GrupoImpacto.GRUPO_3);
				Articulo art10 = new Articulo("Internet of Things", 10, 4, "2022", 17, GrupoImpacto.GRUPO_4);
				Articulo art11 = new Articulo("Deep Learning Advances", 11, 10, "2020", 21, GrupoImpacto.WoS);
				Articulo art12 = new Articulo("Network Protocols", 12, 5, "2019", 14, GrupoImpacto.GRUPO_1);
				Articulo art13 = new Articulo("Predictive Analytics", 13, 8, "2021", 16, GrupoImpacto.GRUPO_2);
				Articulo art14 = new Articulo("Robotics Automation", 14, 12, "2018", 20, GrupoImpacto.GRUPO_3);
				Articulo art15 = new Articulo("Software Engineering", 15, 7, "2022", 18, GrupoImpacto.GRUPO_4);
				Articulo art16 = new Articulo("Human Computer Interaction", 16, 9, "2020", 15, GrupoImpacto.WoS);
				Articulo art17 = new Articulo("Information Systems", 17, 3, "2019", 13, GrupoImpacto.GRUPO_1);
				Articulo art18 = new Articulo("Data Visualization", 18, 11, "2021", 17, GrupoImpacto.GRUPO_2);
				Articulo art19 = new Articulo("Augmented Reality", 19, 6, "2018", 14, GrupoImpacto.GRUPO_3);
				Articulo art20 = new Articulo("Virtual Reality", 20, 4, "2022", 16, GrupoImpacto.GRUPO_4);
				Articulo art21 = new Articulo("Autonomous Systems", 21, 10, "2020", 19, GrupoImpacto.WoS);
				Articulo art22 = new Articulo("Wireless Networks", 22, 5, "2019", 12, GrupoImpacto.GRUPO_1);
				Articulo art23 = new Articulo("Distributed Systems", 23, 8, "2021", 18, GrupoImpacto.GRUPO_2);
				Articulo art24 = new Articulo("Embedded Systems", 24, 12, "2018", 15, GrupoImpacto.GRUPO_3);
				Articulo art25 = new Articulo("Mobile Computing", 25, 7, "2022", 14, GrupoImpacto.GRUPO_4);
				Articulo art26 = new Articulo("Computer Graphics", 26, 9, "2020", 17, GrupoImpacto.WoS);
				Articulo art27 = new Articulo("Database Systems", 27, 3, "2019", 20, GrupoImpacto.GRUPO_1);
				Articulo art28 = new Articulo("Operating Systems", 28, 11, "2021", 16, GrupoImpacto.GRUPO_2);
				Articulo art29 = new Articulo("Parallel Computing", 29, 6, "2018", 13, GrupoImpacto.GRUPO_3);
				Articulo art30 = new Articulo("Computer Architecture", 30, 4, "2022", 19, GrupoImpacto.GRUPO_4);
				Articulo art31 = new Articulo("Bioinformatics", 31, 10, "2020", 14, GrupoImpacto.WoS);
				Articulo art32 = new Articulo("Computational Biology", 32, 5, "2019", 18, GrupoImpacto.GRUPO_1);
				Articulo art33 = new Articulo("Health Informatics", 33, 8, "2021", 15, GrupoImpacto.GRUPO_2);
				Articulo art34 = new Articulo("Medical Imaging", 34, 12, "2018", 17, GrupoImpacto.GRUPO_3);
				Articulo art35 = new Articulo("Telemedicine", 35, 7, "2022", 16, GrupoImpacto.GRUPO_4);
				Articulo art36 = new Articulo("E Learning Systems", 36, 9, "2020", 20, GrupoImpacto.WoS);
				Articulo art37 = new Articulo("Educational Technology", 37, 3, "2019", 14, GrupoImpacto.GRUPO_1);
				Articulo art38 = new Articulo("Digital Libraries", 38, 11, "2021", 13, GrupoImpacto.GRUPO_2);
				Articulo art39 = new Articulo("Information Retrieval", 39, 6, "2018", 18, GrupoImpacto.GRUPO_3);
				Articulo art40 = new Articulo("Knowledge Management", 40, 4, "2022", 15, GrupoImpacto.GRUPO_4);
				Articulo art41 = new Articulo("Semantic Web", 41, 10, "2020", 17, GrupoImpacto.WoS);
				Articulo art42 = new Articulo("Web Technologies", 42, 5, "2019", 16, GrupoImpacto.GRUPO_1);
				Articulo art43 = new Articulo("Cloud Storage", 43, 8, "2021", 14, GrupoImpacto.GRUPO_2);
				Articulo art44 = new Articulo("Edge Computing", 44, 12, "2018", 19, GrupoImpacto.GRUPO_3);
				Articulo art45 = new Articulo("Fog Computing", 45, 7, "2022", 13, GrupoImpacto.GRUPO_4);
				Articulo art46 = new Articulo("Network Security", 46, 9, "2020", 18, GrupoImpacto.WoS);
				Articulo art47 = new Articulo("Cryptography", 47, 3, "2019", 15, GrupoImpacto.GRUPO_1);
				Articulo art48 = new Articulo("Digital Forensics", 48, 11, "2021", 17, GrupoImpacto.GRUPO_2);
				Articulo art49 = new Articulo("Malware Analysis", 49, 6, "2018", 14, GrupoImpacto.GRUPO_3);
				Articulo art50 = new Articulo("Intrusion Detection", 50, 4, "2022", 16, GrupoImpacto.GRUPO_4);
				Articulo art51 = new Articulo("Biometric Systems", 51, 10, "2020", 19, GrupoImpacto.WoS);
				Articulo art52 = new Articulo("Access Control", 52, 5, "2019", 13, GrupoImpacto.GRUPO_1);
				Articulo art53 = new Articulo("Risk Management", 53, 8, "2021", 18, GrupoImpacto.GRUPO_2);
				Articulo art54 = new Articulo("Security Policies", 54, 12, "2018", 15, GrupoImpacto.GRUPO_3);
				Articulo art55 = new Articulo("Privacy Protection", 55, 7, "2022", 17, GrupoImpacto.GRUPO_4);
				Articulo art56 = new Articulo("Secure Coding", 56, 9, "2020", 14, GrupoImpacto.WoS);
				Articulo art57 = new Articulo("Vulnerability Assessment", 57, 3, "2019", 16, GrupoImpacto.GRUPO_1);
				Articulo art58 = new Articulo("Penetration Testing", 58, 11, "2021", 19, GrupoImpacto.GRUPO_2);
				Articulo art59 = new Articulo("Security Audits", 59, 6, "2018", 13, GrupoImpacto.GRUPO_3);
				Articulo art60 = new Articulo("Incident Response", 60, 4, "2022", 18, GrupoImpacto.GRUPO_4);
				Articulo art61 = new Articulo("Threat Intelligence", 61, 10, "2020", 15, GrupoImpacto.WoS);
				Articulo art62 = new Articulo("Cyber Warfare", 62, 5, "2019", 17, GrupoImpacto.GRUPO_1);
				Articulo art63 = new Articulo("Social Engineering", 63, 8, "2021", 14, GrupoImpacto.GRUPO_2);
				Articulo art64 = new Articulo("Phishing Attacks", 64, 12, "2018", 16, GrupoImpacto.GRUPO_3);
				Articulo art65 = new Articulo("Ransomware Protection", 65, 7, "2022", 19, GrupoImpacto.GRUPO_4);
				Articulo art66 = new Articulo("Zero Trust Security", 66, 9, "2020", 13, GrupoImpacto.WoS);
				Articulo art67 = new Articulo("Cloud Security", 67, 3, "2019", 18, GrupoImpacto.GRUPO_1);
				Articulo art68 = new Articulo("IoT Security", 68, 11, "2021", 15, GrupoImpacto.GRUPO_2);
				Articulo art69 = new Articulo("AI Security", 69, 6, "2018", 17, GrupoImpacto.GRUPO_3);
				Articulo art70 = new Articulo("Blockchain Security", 70, 4, "2022", 14, GrupoImpacto.GRUPO_4);

				CapituloLibro cap1 = new CapituloLibro("Advanced Machine Learning", new ArrayList<String>(Arrays.asList("John Smith", "Maria Garcia")), new ArrayList<String>(Arrays.asList("Robert Johnson")), "Tech Publishing", "12345678", "5");
				CapituloLibro cap2 = new CapituloLibro("Cybersecurity Essentials", new ArrayList<String>(Arrays.asList("David Wilson", "Emma Davis")),new ArrayList<String>(Arrays.asList("Michael Brown")),  "Security Press", "87654321", "3");
				CapituloLibro cap3 = new CapituloLibro("Data Science Fundamentals", new ArrayList<String>(Arrays.asList("Sarah Miller", "James Taylor")), new ArrayList<String>(Arrays.asList("Patricia Anderson")),  "Data Books", "23456789", "7");
				CapituloLibro cap4 = new CapituloLibro("Artificial Intelligence Today", new ArrayList<String>(Arrays.asList("Richard Moore", "Jennifer Lee")), new ArrayList<String>(Arrays.asList("Thomas Martin")), "AI Publications", "34567890", "2");
				CapituloLibro cap5 = new CapituloLibro("Network Security Protocols", new ArrayList<String>(Arrays.asList("Daniel Clark", "Lisa Rodriguez")), new ArrayList<String>(Arrays.asList("Christopher Lewis")), "Network Press", "45678901", "4");
				CapituloLibro cap6 = new CapituloLibro("Cloud Computing Architectures",new ArrayList<String>(Arrays.asList("Matthew Walker", "Nancy Hall")), new ArrayList<String>(Arrays.asList("George Allen")),  "Cloud Publishing", "56789012", "6");
				CapituloLibro cap7 = new CapituloLibro("Big Data Analytics", new ArrayList<String>(Arrays.asList("Kevin Young", "Susan King")), new ArrayList<String>(Arrays.asList("Edward Wright")), "Analytics Press", "67890123", "8");
				CapituloLibro cap8 = new CapituloLibro("Quantum Computing Basics", new ArrayList<String>(Arrays.asList("Brian Scott", "Jessica Green")), new ArrayList<String>(Arrays.asList("Ronald Baker")), "Quantum Books", "78901234", "1");
				CapituloLibro cap9 = new CapituloLibro("Internet of Things Security",  new ArrayList<String>(Arrays.asList("Gary Adams", "Amanda Nelson")),new ArrayList<String>(Arrays.asList("Jason Carter")),  "IoT Publications", "89012345", "9");
				CapituloLibro cap10 = new CapituloLibro("Blockchain Technologies", new ArrayList<String>(Arrays.asList("Timothy Hill", "Rebecca Mitchell")), new ArrayList<String>(Arrays.asList("Jeffrey Roberts")), "Blockchain Press", "90123456", "10");

				PonenciaEvento pon1 = new PonenciaEvento("AI Future Trends", LocalDate.of(2020, 5, 15), "Boston Conference Center", "9781234567890");
				PonenciaEvento pon2 = new PonenciaEvento("Cybersecurity Challenges", LocalDate.of(2019, 7, 22), "San Francisco Tech Center", "9782345678901");
				PonenciaEvento pon3 = new PonenciaEvento("Data Privacy Regulations", LocalDate.of(2021, 9, 10), "Berlin Congress Hall", "9783456789012");
				PonenciaEvento pon4 = new PonenciaEvento("Machine Learning Ethics", LocalDate.of(2018, 3, 5), "London Innovation Hub", "9784567890123");
				PonenciaEvento pon5 = new PonenciaEvento("Cloud Security Best Practices", LocalDate.of(2022, 11, 18), "Seattle Convention Center", "9785678901234");
				PonenciaEvento pon6 = new PonenciaEvento("Quantum Computing Advances", LocalDate.of(2020, 6, 30), "Tokyo Tech Forum", "9786789012345");
				PonenciaEvento pon7 = new PonenciaEvento("IoT Network Architectures", LocalDate.of(2019, 8, 12), "Barcelona Tech Summit", "9787890123456");
				PonenciaEvento pon8 = new PonenciaEvento("Blockchain in Finance", LocalDate.of(2021, 4, 25), "New York Financial Center", "9788901234567");
				PonenciaEvento pon9 = new PonenciaEvento("Edge Computing Solutions", LocalDate.of(2018, 10, 7), "Paris Digital Forum", "9789012345678");
				PonenciaEvento pon10 = new PonenciaEvento("FiveG Security Considerations", LocalDate.of(2022, 2, 14), "Singapore Telecom Expo", "9780123456789");
				PonenciaEvento pon11 = new PonenciaEvento("AI in Healthcare", LocalDate.of(2020, 7, 19), "Chicago Medical Center", "9781234509876");
				PonenciaEvento pon12 = new PonenciaEvento("Cyber Threat Intelligence", LocalDate.of(2019, 9, 3), "Washington Security Summit", "9782345610987");
				PonenciaEvento pon13 = new PonenciaEvento("Data Governance Frameworks", LocalDate.of(2021, 5, 28), "Sydney Data Forum", "9783456721098");
				PonenciaEvento pon14 = new PonenciaEvento("Ethical Hacking Techniques", LocalDate.of(2018, 4, 16), "Amsterdam Security Conference", "9784567832109");
				PonenciaEvento pon15 = new PonenciaEvento("Cloud Native Applications", LocalDate.of(2022, 8, 9), "Austin Developer Conference", "9785678943210");
				PonenciaEvento pon16 = new PonenciaEvento("Quantum Cryptography", LocalDate.of(2020, 10, 22), "Zurich Research Symposium", "9786789054321");
				PonenciaEvento pon17 = new PonenciaEvento("Smart City Security", LocalDate.of(2019, 6, 11), "Dubai Future Forum", "9787890165432");
				PonenciaEvento pon18 = new PonenciaEvento("Decentralized Finance", LocalDate.of(2021, 3, 7), "Hong Kong Fintech Week", "9788901276543");
				PonenciaEvento pon19 = new PonenciaEvento("AI Regulation Policies", LocalDate.of(2018, 11, 30), "Brussels Policy Center", "9789012387654");
				PonenciaEvento pon20 = new PonenciaEvento("Network Virtualization", LocalDate.of(2022, 1, 25), "Seoul Tech Conference", "9780123498765");
				
				d1.agregarResultado(art1); d3.agregarResultado(art2); e1.agregarResultado(art3); 
				d5.agregarResultado(art4); d7.agregarResultado(art5); e3.agregarResultado(art6);
				d9.agregarResultado(art7); d11.agregarResultado(art8); e5.agregarResultado(art9);
				d13.agregarResultado(art10); d15.agregarResultado(art11); e7.agregarResultado(art12);
				d17.agregarResultado(art13); d19.agregarResultado(art14); e9.agregarResultado(art15);
				d21.agregarResultado(art16); d23.agregarResultado(art17); e11.agregarResultado(art18);
				d25.agregarResultado(art19); d27.agregarResultado(art20); e13.agregarResultado(art21);
				d29.agregarResultado(art22); d31.agregarResultado(art23); d2.agregarResultado(art24);
				d33.agregarResultado(art25); d35.agregarResultado(art26); e2.agregarResultado(art27);
				d37.agregarResultado(art28); d39.agregarResultado(art29); e4.agregarResultado(art30);
				d41.agregarResultado(art31); d43.agregarResultado(art32); e6.agregarResultado(art33);
				d45.agregarResultado(art34); d47.agregarResultado(art35); e8.agregarResultado(art36);
				d49.agregarResultado(art37); d51.agregarResultado(art38); e10.agregarResultado(art39);
				d53.agregarResultado(art40); d55.agregarResultado(art41); e12.agregarResultado(art42);
				d57.agregarResultado(art43); d59.agregarResultado(art44); d4.agregarResultado(art45);
				d61.agregarResultado(art46); d63.agregarResultado(art47); d6.agregarResultado(art48);
				d65.agregarResultado(art49); d67.agregarResultado(art50); d8.agregarResultado(art51);
				d69.agregarResultado(art52); d71.agregarResultado(art53); d10.agregarResultado(art54);
				d12.agregarResultado(art55); d14.agregarResultado(art56); d16.agregarResultado(art57);
				d18.agregarResultado(art58); d20.agregarResultado(art59); d22.agregarResultado(art60);
				d24.agregarResultado(art61); d26.agregarResultado(art62); d28.agregarResultado(art63);
				d30.agregarResultado(art64); d32.agregarResultado(art65); d34.agregarResultado(art66);
				d36.agregarResultado(art67); d38.agregarResultado(art68); d40.agregarResultado(art69);
				d42.agregarResultado(art70);

				d1.agregarResultado(cap1); d3.agregarResultado(cap2); e1.agregarResultado(cap3);
				d5.agregarResultado(cap4); d7.agregarResultado(cap5); e3.agregarResultado(cap6);
				d9.agregarResultado(cap7); d11.agregarResultado(cap8); e5.agregarResultado(cap9);
				d13.agregarResultado(cap10);

				d2.agregarResultado(pon1); d4.agregarResultado(pon2); e2.agregarResultado(pon3);
				d6.agregarResultado(pon4); d8.agregarResultado(pon5); e4.agregarResultado(pon6);
				d10.agregarResultado(pon7); d12.agregarResultado(pon8); e6.agregarResultado(pon9);
				d14.agregarResultado(pon10); d16.agregarResultado(pon11); e8.agregarResultado(pon12);
				d18.agregarResultado(pon13); d20.agregarResultado(pon14); e10.agregarResultado(pon15);
				d22.agregarResultado(pon16); d24.agregarResultado(pon17); e12.agregarResultado(pon18);
				d26.agregarResultado(pon19); d28.agregarResultado(pon20);
				
				//Resultados de los investigadores del departamento 2
				Articulo art71 = new Articulo("Machine Learning Applications", 15, 3, "2020", 25, GrupoImpacto.WoS);
				Articulo art72 = new Articulo("Quantum Computing Advances", 8, 2, "2019", 18, GrupoImpacto.GRUPO_1);
				Articulo art73 = new Articulo("Blockchain Technology Review", 12, 4, "2021", 22, GrupoImpacto.GRUPO_2);
				Articulo art74 = new Articulo("Neural Networks Optimization", 7, 1, "2018", 15, GrupoImpacto.GRUPO_3);
				Articulo art75 = new Articulo("Data Privacy Challenges", 9, 2, "2020", 20, GrupoImpacto.GRUPO_4);
				Articulo art76 = new Articulo("IoT Security Protocols", 11, 3, "2021", 24, GrupoImpacto.WoS);
				Articulo art77 = new Articulo("Cloud Computing Trends", 6, 1, "2019", 16, GrupoImpacto.GRUPO_1);
				Articulo art78 = new Articulo("FiveG Network Analysis", 14, 4, "2022", 26, GrupoImpacto.GRUPO_2);
				Articulo art79 = new Articulo("AI Ethics Considerations", 5, 1, "2020", 14, GrupoImpacto.GRUPO_3);
				Articulo art80 = new Articulo("Computer Vision Advances", 10, 2, "2021", 21, GrupoImpacto.GRUPO_4);
				Articulo art81 = new Articulo("Natural Language Processing", 13, 3, "2022", 23, GrupoImpacto.WoS);
				Articulo art82 = new Articulo("Robotics Innovations", 4, 1, "2019", 12, GrupoImpacto.GRUPO_1);
				Articulo art83 = new Articulo("Edge Computing Solutions", 16, 4, "2023", 27, GrupoImpacto.GRUPO_2);
				Articulo art84 = new Articulo("Cybersecurity Threats", 8, 2, "2020", 19, GrupoImpacto.GRUPO_3);
				Articulo art85 = new Articulo("Augmented Reality Studies", 11, 3, "2021", 22, GrupoImpacto.GRUPO_4);
				Articulo art86 = new Articulo("Data Mining Techniques", 9, 2, "2020", 18, GrupoImpacto.WoS);
				Articulo art87 = new Articulo("Software Engineering Best Practices", 7, 1, "2019", 16, GrupoImpacto.GRUPO_1);
				Articulo art88 = new Articulo("Distributed Systems Design", 12, 3, "2021", 24, GrupoImpacto.GRUPO_2);
				Articulo art89 = new Articulo("Human Computer Interaction", 6, 1, "2020", 15, GrupoImpacto.GRUPO_3);
				Articulo art90 = new Articulo("Autonomous Vehicles Research", 14, 4, "2022", 26, GrupoImpacto.GRUPO_4);
				Articulo art91 = new Articulo("Bioinformatics Algorithms", 10, 2, "2021", 20, GrupoImpacto.WoS);
				Articulo art92 = new Articulo("Wireless Sensor Networks", 8, 2, "2020", 18, GrupoImpacto.GRUPO_1);
				Articulo art93 = new Articulo("Cryptography Methods", 13, 3, "2022", 23, GrupoImpacto.GRUPO_2);
				Articulo art94 = new Articulo("Virtual Reality Applications", 5, 1, "2019", 14, GrupoImpacto.GRUPO_3);
				Articulo art95 = new Articulo("Database Optimization", 11, 3, "2021", 22, GrupoImpacto.GRUPO_4);
				Articulo art96 = new Articulo("AI in Healthcare", 9, 2, "2020", 19, GrupoImpacto.WoS);
				Articulo art97 = new Articulo("Network Protocols Analysis", 15, 4, "2023", 25, GrupoImpacto.GRUPO_1);
				Articulo art98 = new Articulo("Computer Graphics Advances", 7, 1, "2020", 17, GrupoImpacto.GRUPO_2);
				Articulo art99 = new Articulo("Embedded Systems Design", 12, 3, "2021", 21, GrupoImpacto.GRUPO_3);
				Articulo art100 = new Articulo("Quantum Algorithms", 10, 2, "2022", 20, GrupoImpacto.GRUPO_4);

				CapituloLibro cap11 = new CapituloLibro("Deep Learning Fundamentals", new ArrayList<String>(Arrays.asList("John Smith", "Maria Garcia")), new ArrayList<String>(Arrays.asList("Robert Johnson", "Emily Chen")), "Tech Publishing", "12345678", "5");
				CapituloLibro cap12 = new CapituloLibro("Cybersecurity Essentials", new ArrayList<String>(Arrays.asList("David Wilson", "Sarah Lee")), new ArrayList<String>(Arrays.asList("Michael Brown", "Jessica Wong")), "Security Press", "87654321", "3");
				CapituloLibro cap13 = new CapituloLibro("Data Science Handbook", new ArrayList<String>(Arrays.asList("James Miller", "Emma Davis")), new ArrayList<String>(Arrays.asList("Daniel Taylor", "Olivia Martinez")), "Data World", "23456789", "2");
				CapituloLibro cap14 = new CapituloLibro("AI Ethics and Society", new ArrayList<String>(Arrays.asList("William Anderson", "Sophia Thomas")), new ArrayList<String>(Arrays.asList("Christopher Hernandez", "Ava Moore")), "Ethics Publishing", "34567890", "4");
				CapituloLibro cap15 = new CapituloLibro("Cloud Architecture Patterns", new ArrayList<String>(Arrays.asList("Matthew Jackson", "Isabella White")), new ArrayList<String>(Arrays.asList("Andrew Harris", "Mia Clark")), "Cloud Editions", "45678901", "1");
				CapituloLibro cap16 = new CapituloLibro("Quantum Computing Explained", new ArrayList<String>(Arrays.asList("Joseph Martin", "Charlotte Lewis")), new ArrayList<String>(Arrays.asList("Joshua Walker", "Amelia Young")), "Quantum Press", "56789012", "3");
				CapituloLibro cap17 = new CapituloLibro("IoT Security Challenges", new ArrayList<String>(Arrays.asList("Daniel Hall", "Harper Allen")), new ArrayList<String>(Arrays.asList("Christopher King", "Evelyn Scott")), "IoT Publications", "67890123", "2");
				CapituloLibro cap18 = new CapituloLibro("Blockchain Applications", new ArrayList<String>(Arrays.asList("Ryan Wright", "Abigail Green")), new ArrayList<String>(Arrays.asList("Nicholas Adams", "Elizabeth Baker")), "Blockchain Books", "78901234", "4");
				CapituloLibro cap19 = new CapituloLibro("Human Centered AI", new ArrayList<String>(Arrays.asList("Tyler Nelson", "Sofia Carter")), new ArrayList<String>(Arrays.asList("Brandon Mitchell", "Avery Phillips")), "AI Publications", "89012345", "1");
				CapituloLibro cap20 = new CapituloLibro("Edge Computing Paradigms", new ArrayList<String>(Arrays.asList("Christian Roberts", "Scarlett Turner")), new ArrayList<String>(Arrays.asList("Samuel Parker", "Victoria Parker")), "Edge Tech Press", "90123456", "3");
		
				PonenciaEvento pon21 = new PonenciaEvento("AI Future Trends", LocalDate.of(2022, 5, 15), "Barcelona", "9781234567890");
				PonenciaEvento pon22 = new PonenciaEvento("Cybersecurity Innovations", LocalDate.of(2021, 10, 22), "Berlin", "9782345678901");
				PonenciaEvento pon23 = new PonenciaEvento("Data Privacy Regulations", LocalDate.of(2020, 7, 30), "Paris", "9783456789012");
				PonenciaEvento pon24 = new PonenciaEvento("Quantum Computing Breakthroughs", LocalDate.of(2023, 3, 18), "Tokyo", "9784567890123");
				PonenciaEvento pon25 = new PonenciaEvento("IoT in Smart Cities", LocalDate.of(2022, 9, 5), "Singapore", "9785678901234");
				PonenciaEvento pon26 = new PonenciaEvento("Blockchain for Finance", LocalDate.of(2021, 11, 12), "New York", "9786789012345");
				PonenciaEvento pon27 = new PonenciaEvento("Machine Learning Ethics", LocalDate.of(2020, 6, 25), "London", "9787890123456");
				PonenciaEvento pon28 = new PonenciaEvento("FiveG Network Security", LocalDate.of(2023, 4, 8), "Seoul", "9788901234567");
				PonenciaEvento pon29 = new PonenciaEvento("Computer Vision Applications", LocalDate.of(2022, 8, 14), "San Francisco", "9789012345678");
				PonenciaEvento pon30 = new PonenciaEvento("Natural Language Processing Advances", LocalDate.of(2021, 12, 3), "Boston", "9780123456789");
				PonenciaEvento pon31 = new PonenciaEvento("Cloud Computing Security", LocalDate.of(2020, 5, 19), "Chicago", "9781234509876");
				PonenciaEvento pon32 = new PonenciaEvento("Edge Computing Challenges", LocalDate.of(2023, 2, 28), "Sydney", "9782345610987");
				PonenciaEvento pon33 = new PonenciaEvento("AI in Healthcare Applications", LocalDate.of(2022, 7, 11), "Toronto", "9783456721098");
				PonenciaEvento pon34 = new PonenciaEvento("Cybersecurity Best Practices", LocalDate.of(2021, 9, 23), "Madrid", "9784567832109");
				PonenciaEvento pon35 = new PonenciaEvento("Data Science in Business", LocalDate.of(2020, 4, 17), "Amsterdam", "9785678943210");
				PonenciaEvento pon36 = new PonenciaEvento("Quantum Algorithms Research", LocalDate.of(2023, 1, 9), "Zurich", "9786789054321");
				PonenciaEvento pon37 = new PonenciaEvento("IoT Security Standards", LocalDate.of(2022, 6, 22), "Dubai", "9787890165432");
				PonenciaEvento pon38 = new PonenciaEvento("Blockchain Scalability", LocalDate.of(2021, 10, 15), "Hong Kong", "9788901276543");
				PonenciaEvento pon39 = new PonenciaEvento("AI for Climate Change", LocalDate.of(2020, 3, 8), "Stockholm", "9789012387654");
				PonenciaEvento pon40 = new PonenciaEvento("Computer Networks Optimization", LocalDate.of(2023, 5, 30), "Vienna", "9780123498765");
				PonenciaEvento pon41 = new PonenciaEvento("Machine Learning in Finance", LocalDate.of(2022, 10, 12), "Frankfurt", "9781234509876");
				PonenciaEvento pon42 = new PonenciaEvento("Cybersecurity in IoT", LocalDate.of(2021, 8, 7), "Milan", "9782345610987");
				PonenciaEvento pon43 = new PonenciaEvento("Data Visualization Techniques", LocalDate.of(2020, 7, 19), "Barcelona", "9783456721098");
				PonenciaEvento pon44 = new PonenciaEvento("Quantum Cryptography", LocalDate.of(2023, 4, 5), "Berlin", "9784567832109");
				PonenciaEvento pon45 = new PonenciaEvento("AI in Education", LocalDate.of(2022, 9, 28), "Paris", "9785678943210");
				PonenciaEvento pon46 = new PonenciaEvento("Cloud Native Applications", LocalDate.of(2021, 11, 14), "Tokyo", "9786789054321");
				PonenciaEvento pon47 = new PonenciaEvento("FiveG and Edge Computing", LocalDate.of(2020, 6, 9), "Singapore", "9787890165432");
				PonenciaEvento pon48 = new PonenciaEvento("Blockchain for Supply Chain", LocalDate.of(2023, 3, 22), "New York", "9788901276543");
				PonenciaEvento pon49 = new PonenciaEvento("Computer Vision in Robotics", LocalDate.of(2022, 8, 17), "London", "9789012387654");
				PonenciaEvento pon50 = new PonenciaEvento("NLP for Customer Service", LocalDate.of(2021, 12, 5), "Seoul", "9780123498765");
				PonenciaEvento pon51 = new PonenciaEvento("AI Governance Frameworks", LocalDate.of(2020, 5, 21), "San Francisco", "9781234509876");
				PonenciaEvento pon52 = new PonenciaEvento("Cybersecurity Awareness", LocalDate.of(2023, 2, 14), "Boston", "9782345610987");
				PonenciaEvento pon53 = new PonenciaEvento("Data Engineering Trends", LocalDate.of(2022, 7, 8), "Chicago", "9783456721098");
				PonenciaEvento pon54 = new PonenciaEvento("Quantum Machine Learning", LocalDate.of(2021, 9, 30), "Sydney", "9784567832109");
				PonenciaEvento pon55 = new PonenciaEvento("IoT in Agriculture", LocalDate.of(2020, 4, 12), "Toronto", "9785678943210");
				PonenciaEvento pon56 = new PonenciaEvento("Blockchain Identity Solutions", LocalDate.of(2023, 1, 25), "Madrid", "9786789054321");
				PonenciaEvento pon57 = new PonenciaEvento("AI for Social Good", LocalDate.of(2022, 6, 18), "Amsterdam", "9787890165432");
				PonenciaEvento pon58 = new PonenciaEvento("Network Security Protocols", LocalDate.of(2021, 10, 11), "Zurich", "9788901276543");
				PonenciaEvento pon59 = new PonenciaEvento("Computer Vision in Healthcare", LocalDate.of(2020, 3, 4), "Dubai", "9789012387654");
				PonenciaEvento pon60 = new PonenciaEvento("NLP for Legal Documents", LocalDate.of(2023, 5, 27), "Hong Kong", "9780123498765");
				PonenciaEvento pon61 = new PonenciaEvento("AI in Financial Services", LocalDate.of(2022, 10, 19), "Stockholm", "9781234509876");
				PonenciaEvento pon62 = new PonenciaEvento("Cybersecurity Risk Management", LocalDate.of(2021, 8, 3), "Vienna", "9782345610987");
				PonenciaEvento pon63 = new PonenciaEvento("Data Science Ethics", LocalDate.of(2020, 7, 16), "Frankfurt", "9783456721098");
				PonenciaEvento pon64 = new PonenciaEvento("Quantum Networking", LocalDate.of(2023, 4, 9), "Milan", "9784567832109");
				PonenciaEvento pon65 = new PonenciaEvento("AI in Manufacturing", LocalDate.of(2022, 9, 22), "Barcelona", "9785678943210");
				PonenciaEvento pon66 = new PonenciaEvento("Cloud Security Best Practices", LocalDate.of(2021, 11, 8), "Berlin", "9786789054321");
				PonenciaEvento pon67 = new PonenciaEvento("FiveG Network Optimization", LocalDate.of(2020, 6, 1), "Paris", "9787890165432");
				PonenciaEvento pon68 = new PonenciaEvento("Blockchain for Healthcare", LocalDate.of(2023, 3, 14), "Tokyo", "9788901276543");
				PonenciaEvento pon69 = new PonenciaEvento("Computer Vision in Retail", LocalDate.of(2022, 8, 7), "Singapore", "9789012387654");
				PonenciaEvento pon70 = new PonenciaEvento("NLP for Sentiment Analysis", LocalDate.of(2021, 12, 20), "New York", "9780123498765");
				PonenciaEvento pon71 = new PonenciaEvento("AI in Transportation", LocalDate.of(2020, 5, 13), "London", "9781234509876");
				PonenciaEvento pon72 = new PonenciaEvento("Cybersecurity for SMEs", LocalDate.of(2023, 2, 6), "Seoul", "9782345610987");
				PonenciaEvento pon73 = new PonenciaEvento("Data Science in Healthcare", LocalDate.of(2022, 7, 29), "San Francisco", "9783456721098");
				PonenciaEvento pon74 = new PonenciaEvento("Quantum Error Correction", LocalDate.of(2021, 9, 12), "Boston", "9784567832109");
				PonenciaEvento pon75 = new PonenciaEvento("IoT in Smart Homes", LocalDate.of(2020, 4, 5), "Chicago", "9785678943210");
				PonenciaEvento pon76 = new PonenciaEvento("Blockchain for Voting Systems", LocalDate.of(2023, 1, 18), "Sydney", "9786789054321");
				PonenciaEvento pon77 = new PonenciaEvento("AI for Cybersecurity", LocalDate.of(2022, 6, 11), "Toronto", "9787890165432");
				PonenciaEvento pon78 = new PonenciaEvento("Network Performance Analysis", LocalDate.of(2021, 10, 4), "Madrid", "9788901276543");
				PonenciaEvento pon79 = new PonenciaEvento("Computer Vision in Sports", LocalDate.of(2020, 3, 27), "Amsterdam", "9789012387654");
				PonenciaEvento pon80 = new PonenciaEvento("NLP for Chatbots", LocalDate.of(2023, 5, 20), "Zurich", "9780123498765");
				
				d101.agregarResultado(art71); e15.agregarResultado(art72); d103.agregarResultado(art73);
				d105.agregarResultado(art74); e17.agregarResultado(art75); d107.agregarResultado(art76);
				d109.agregarResultado(art77); e19.agregarResultado(art78); d111.agregarResultado(art79);
				d113.agregarResultado(art80); e21.agregarResultado(art81); d115.agregarResultado(art82);
				d117.agregarResultado(art83); e23.agregarResultado(art84); d119.agregarResultado(art85);
				d121.agregarResultado(art86); e25.agregarResultado(art87); d123.agregarResultado(art88);
				d125.agregarResultado(art89); e14.agregarResultado(art90); d127.agregarResultado(art91);
				d129.agregarResultado(art92); e16.agregarResultado(art93); d131.agregarResultado(art94);
				d133.agregarResultado(art95); e18.agregarResultado(art96); d135.agregarResultado(art97);
				d137.agregarResultado(art98); e20.agregarResultado(art99); d139.agregarResultado(art100);

				d102.agregarResultado(cap11); e22.agregarResultado(cap12); d104.agregarResultado(cap13);
				d106.agregarResultado(cap14); e24.agregarResultado(cap15); d108.agregarResultado(cap16);
				d110.agregarResultado(cap17); e26.agregarResultado(cap18); d112.agregarResultado(cap19);
				d114.agregarResultado(cap20);

				d116.agregarResultado(pon21); e15.agregarResultado(pon22); d118.agregarResultado(pon23);
				e17.agregarResultado(pon24); d120.agregarResultado(pon25); e19.agregarResultado(pon26);
				d122.agregarResultado(pon27); e21.agregarResultado(pon28); d124.agregarResultado(pon29);
				e23.agregarResultado(pon30); d126.agregarResultado(pon31); e25.agregarResultado(pon32);
				d128.agregarResultado(pon33); e14.agregarResultado(pon34); d130.agregarResultado(pon35);
				e16.agregarResultado(pon36); d132.agregarResultado(pon37); e18.agregarResultado(pon38);
				d134.agregarResultado(pon39); e20.agregarResultado(pon40); d136.agregarResultado(pon41);
				e22.agregarResultado(pon42); d138.agregarResultado(pon43); e24.agregarResultado(pon44);
				d140.agregarResultado(pon45); e26.agregarResultado(pon46); d142.agregarResultado(pon47);
				d141.agregarResultado(pon48); d143.agregarResultado(pon49); d144.agregarResultado(pon50);
				d145.agregarResultado(pon51); d146.agregarResultado(pon52); d147.agregarResultado(pon53);
				d148.agregarResultado(pon54); d149.agregarResultado(pon55); d150.agregarResultado(pon56);
				d151.agregarResultado(pon57); d152.agregarResultado(pon58); d153.agregarResultado(pon59);
				d154.agregarResultado(pon60); d155.agregarResultado(pon61); d156.agregarResultado(pon62);
				d157.agregarResultado(pon63); d158.agregarResultado(pon64); d159.agregarResultado(pon65);
				d160.agregarResultado(pon66); d161.agregarResultado(pon67); d162.agregarResultado(pon68);
				d163.agregarResultado(pon69); d164.agregarResultado(pon70); d165.agregarResultado(pon71);
				d166.agregarResultado(pon72); d167.agregarResultado(pon73); d168.agregarResultado(pon74);
				d169.agregarResultado(pon75); d170.agregarResultado(pon76); d171.agregarResultado(pon77);
				d172.agregarResultado(pon78); d173.agregarResultado(pon79); d174.agregarResultado(pon80);
				
				//Resultados de los investigadores del departamento 3
				Articulo art101 = new Articulo("Advanced Neural Architectures", 16, 4, "2023", 28, GrupoImpacto.WoS);
				Articulo art102 = new Articulo("Post Quantum Cryptography", 9, 2, "2022", 19, GrupoImpacto.GRUPO_1);
				Articulo art103 = new Articulo("Federated Learning Systems", 11, 3, "2023", 23, GrupoImpacto.GRUPO_2);
				Articulo art104 = new Articulo("Explainable AI Methods", 6, 1, "2022", 16, GrupoImpacto.GRUPO_3);
				Articulo art105 = new Articulo("Edge AI Applications", 13, 3, "2023", 25, GrupoImpacto.GRUPO_4);
				Articulo art106 = new Articulo("SixG Network Prospects", 8, 2, "2022", 18, GrupoImpacto.WoS);
				Articulo art107 = new Articulo("AI for Climate Modeling", 14, 4, "2023", 26, GrupoImpacto.GRUPO_1);
				Articulo art108 = new Articulo("Blockchain Interoperability", 7, 1, "2022", 17, GrupoImpacto.GRUPO_2);
				Articulo art109 = new Articulo("Generative AI Ethics", 12, 3, "2023", 24, GrupoImpacto.GRUPO_3);
				Articulo art110 = new Articulo("Digital Twin Technology", 5, 1, "2022", 15, GrupoImpacto.GRUPO_4);
				Articulo art111 = new Articulo("Autonomous Drone Systems", 15, 4, "2023", 27, GrupoImpacto.WoS);
				Articulo art112 = new Articulo("AI in Drug Discovery", 10, 2, "2022", 20, GrupoImpacto.GRUPO_1);
				Articulo art113 = new Articulo("Metaverse Security", 9, 2, "2023", 21, GrupoImpacto.GRUPO_2);
				Articulo art114 = new Articulo("Neuromorphic Computing", 11, 3, "2023", 22, GrupoImpacto.GRUPO_3);
				Articulo art115 = new Articulo("AI for Cybersecurity", 7, 1, "2022", 16, GrupoImpacto.GRUPO_4);
				Articulo art116 = new Articulo("Quantum Machine Learning", 13, 3, "2023", 24, GrupoImpacto.WoS);
				Articulo art117 = new Articulo("Sustainable AI", 8, 2, "2022", 18, GrupoImpacto.GRUPO_1);
				Articulo art118 = new Articulo("Digital Forensics", 14, 4, "2023", 26, GrupoImpacto.GRUPO_2);
				Articulo art119 = new Articulo("AI in Agriculture", 6, 1, "2022", 15, GrupoImpacto.GRUPO_3);
				Articulo art120 = new Articulo("Smart Contract Analysis", 12, 3, "2023", 23, GrupoImpacto.GRUPO_4);
				Articulo art121 = new Articulo("Multi Agent Systems", 10, 2, "2022", 20, GrupoImpacto.WoS);
				Articulo art122 = new Articulo("AI for Education", 9, 2, "2023", 21, GrupoImpacto.GRUPO_1);
				Articulo art123 = new Articulo("Cloud Native Security", 15, 4, "2023", 27, GrupoImpacto.GRUPO_2);
				Articulo art124 = new Articulo("Computer Vision in Medicine", 7, 1, "2022", 17, GrupoImpacto.GRUPO_3);
				Articulo art125 = new Articulo("NLP for Legal Tech", 11, 3, "2023", 22, GrupoImpacto.GRUPO_4);
				Articulo art126 = new Articulo("AI Hardware Acceleration", 8, 2, "2022", 19, GrupoImpacto.WoS);
				Articulo art127 = new Articulo("Decentralized AI", 13, 3, "2023", 25, GrupoImpacto.GRUPO_1);
				Articulo art128 = new Articulo("Robotic Process Automation", 5, 1, "2022", 14, GrupoImpacto.GRUPO_2);
				Articulo art129 = new Articulo("AI for Renewable Energy", 12, 3, "2023", 23, GrupoImpacto.GRUPO_3);
				Articulo art130 = new Articulo("WebThree Security Challenges", 10, 2, "2023", 21, GrupoImpacto.GRUPO_4);

				CapituloLibro cap21 = new CapituloLibro("AI in Healthcare Innovations", new ArrayList<String>(Arrays.asList("Alexander Reed", "Lily Cooper")), new ArrayList<String>(Arrays.asList("Benjamin Brooks", "Chloe Bennett")), "Health Tech Press", "11223344", "6");
				CapituloLibro cap22 = new CapituloLibro("Cybersecurity in Finance", new ArrayList<String>(Arrays.asList("Nathan Hughes", "Zoe Richardson")), new ArrayList<String>(Arrays.asList("Samuel Powell", "Hannah Russell")), "Finance Security", "22334455", "4");
				CapituloLibro cap23 = new CapituloLibro("Quantum Computing Algorithms", new ArrayList<String>(Arrays.asList("Gabriel Foster", "Ella Howard")), new ArrayList<String>(Arrays.asList("Dylan Sanders", "Layla Simmons")), "Quantum Science", "33445566", "2");
				CapituloLibro cap24 = new CapituloLibro("Edge AI Deployment", new ArrayList<String>(Arrays.asList("Julian Bryant", "Nora Coleman")), new ArrayList<String>(Arrays.asList("Carter Jenkins", "Ellie Ward")), "Edge Publications", "44556677", "5");
				CapituloLibro cap25 = new CapituloLibro("Blockchain for Business", new ArrayList<String>(Arrays.asList("Luke Griffin", "Stella Fisher")), new ArrayList<String>(Arrays.asList("Isaiah Henderson", "Violet Barnes")), "Blockchain Solutions", "55667788", "3");
				CapituloLibro cap26 = new CapituloLibro("AI Governance Frameworks", new ArrayList<String>(Arrays.asList("Christian Porter", "Penelope Long")), new ArrayList<String>(Arrays.asList("Josiah Patterson", "Clara Price")), "AI Policy Press", "66778899", "1");
				CapituloLibro cap27 = new CapituloLibro("Computer Vision in Industry", new ArrayList<String>(Arrays.asList("Dominic Flores", "Aurora Ross")), new ArrayList<String>(Arrays.asList("Brayden Washington", "Skylar Henderson")), "Industrial Tech", "77889900", "4");
				CapituloLibro cap28 = new CapituloLibro("NLP for Business Intelligence", new ArrayList<String>(Arrays.asList("Austin Perry", "Savannah Coleman")), new ArrayList<String>(Arrays.asList("Elias James", "Madeline Foster")), "Business AI Press", "88990011", "2");
				CapituloLibro cap29 = new CapituloLibro("IoT Security Protocols", new ArrayList<String>(Arrays.asList("Colton Simmons", "Bella Patterson")), new ArrayList<String>(Arrays.asList("Miles Bryant", "Natalie Griffin")), "IoT Security", "99001122", "5");
				CapituloLibro cap30 = new CapituloLibro("Cloud Native AI Systems", new ArrayList<String>(Arrays.asList("Xavier Howard", "Leah Jenkins")), new ArrayList<String>(Arrays.asList("Vincent Ward", "Hailey Sanders")), "Cloud AI Press", "00112233", "3");

				PonenciaEvento pon81 = new PonenciaEvento("AI in Financial Forecasting", LocalDate.of(2023, 6, 12), "Lisbon", "9781122334455");
				PonenciaEvento pon82 = new PonenciaEvento("Next Gen Cybersecurity", LocalDate.of(2022, 11, 8), "Brussels", "9782233445566");
				PonenciaEvento pon83 = new PonenciaEvento("Quantum Networking Advances", LocalDate.of(2021, 9, 15), "Oslo", "9783344556677");
				PonenciaEvento pon84 = new PonenciaEvento("Edge Computing in FiveG", LocalDate.of(2023, 4, 22), "Prague", "9784455667788");
				PonenciaEvento pon85 = new PonenciaEvento("Blockchain for Digital Identity", LocalDate.of(2022, 10, 5), "Warsaw", "9785566778899");
				PonenciaEvento pon86 = new PonenciaEvento("AI for Predictive Maintenance", LocalDate.of(2021, 8, 18), "Dublin", "9786677889900");
				PonenciaEvento pon87 = new PonenciaEvento("Computer Vision in Manufacturing", LocalDate.of(2023, 5, 30), "Athens", "9787788990011");
				PonenciaEvento pon88 = new PonenciaEvento("NLP for Healthcare", LocalDate.of(2022, 12, 14), "Helsinki", "9788899001122");
				PonenciaEvento pon89 = new PonenciaEvento("IoT in Smart Grids", LocalDate.of(2021, 7, 7), "Copenhagen", "9789900112233");
				PonenciaEvento pon90 = new PonenciaEvento("Cloud Security Innovations", LocalDate.of(2023, 3, 19), "Budapest", "9780011223344");
				PonenciaEvento pon91 = new PonenciaEvento("AI in Retail Personalization", LocalDate.of(2022, 9, 2), "Luxembourg", "9781122334455");
				PonenciaEvento pon92 = new PonenciaEvento("Cybersecurity for Critical Infrastructure", LocalDate.of(2021, 6, 25), "Riga", "9782233445566");
				PonenciaEvento pon93 = new PonenciaEvento("Quantum AI Applications", LocalDate.of(2023, 2, 8), "Vilnius", "9783344556677");
				PonenciaEvento pon94 = new PonenciaEvento("Edge AI for Autonomous Vehicles", LocalDate.of(2022, 8, 21), "Tallinn", "9784455667788");
				PonenciaEvento pon95 = new PonenciaEvento("Blockchain for Supply Chain Transparency", LocalDate.of(2021, 5, 14), "Bratislava", "9785566778899");
				PonenciaEvento pon96 = new PonenciaEvento("AI for Environmental Monitoring", LocalDate.of(2023, 1, 27), "Ljubljana", "9786677889900");
				PonenciaEvento pon97 = new PonenciaEvento("Computer Vision in Agriculture", LocalDate.of(2022, 7, 10), "Zagreb", "9787788990011");
				PonenciaEvento pon98 = new PonenciaEvento("NLP for Financial Reports", LocalDate.of(2021, 4, 3), "Sofia", "9788899001122");
				PonenciaEvento pon99 = new PonenciaEvento("IoT in Healthcare", LocalDate.of(2023, 11, 16), "Bucharest", "9789900112233");
				PonenciaEvento pon100 = new PonenciaEvento("Cloud Native Security Patterns", LocalDate.of(2022, 6, 9), "Belgrade", "9780011223344");
				PonenciaEvento pon101 = new PonenciaEvento("AI for Smart Cities", LocalDate.of(2021, 3, 22), "Kiev", "9781122334455");
				PonenciaEvento pon102 = new PonenciaEvento("Zero Trust Architecture", LocalDate.of(2023, 10, 15), "Minsk", "9782233445566");
				PonenciaEvento pon103 = new PonenciaEvento("Post Quantum Cryptography Standards", LocalDate.of(2022, 5, 8), "Warsaw", "9783344556677");
				PonenciaEvento pon104 = new PonenciaEvento("Edge Computing for IoT", LocalDate.of(2021, 2, 1), "Prague", "9784455667788");
				PonenciaEvento pon105 = new PonenciaEvento("Blockchain for Digital Art", LocalDate.of(2023, 9, 24), "Berlin", "9785566778899");
				PonenciaEvento pon106 = new PonenciaEvento("AI for Fraud Detection", LocalDate.of(2022, 4, 17), "Paris", "9786677889900");
				PonenciaEvento pon107 = new PonenciaEvento("Computer Vision in Security", LocalDate.of(2021, 1, 10), "Rome", "9787788990011");
				PonenciaEvento pon108 = new PonenciaEvento("NLP for Social Media Analysis", LocalDate.of(2023, 8, 3), "Madrid", "9788899001122");
				PonenciaEvento pon109 = new PonenciaEvento("IoT in Industrial Automation", LocalDate.of(2022, 3, 26), "Barcelona", "9789900112233");
				PonenciaEvento pon110 = new PonenciaEvento("Cloud Cost Optimization", LocalDate.of(2021, 12, 19), "Milan", "9780011223344");
				PonenciaEvento pon111 = new PonenciaEvento("AI in Legal Tech", LocalDate.of(2023, 7, 12), "Vienna", "9781122334455");
				PonenciaEvento pon112 = new PonenciaEvento("Threat Intelligence Sharing", LocalDate.of(2022, 2, 5), "Brussels", "9782233445566");
				PonenciaEvento pon113 = new PonenciaEvento("Quantum Error Correction", LocalDate.of(2021, 11, 28), "Amsterdam", "9783344556677");
				PonenciaEvento pon114 = new PonenciaEvento("Edge AI Chipsets", LocalDate.of(2023, 6, 21), "Dublin", "9784455667788");
				PonenciaEvento pon115 = new PonenciaEvento("Blockchain for Healthcare Data", LocalDate.of(2022, 1, 14), "Stockholm", "9785566778899");
				PonenciaEvento pon116 = new PonenciaEvento("AI for Customer Service", LocalDate.of(2021, 10, 7), "Helsinki", "9786677889900");
				PonenciaEvento pon117 = new PonenciaEvento("Computer Vision in Logistics", LocalDate.of(2023, 5, 30), "Oslo", "9787788990011");
				PonenciaEvento pon118 = new PonenciaEvento("NLP for Multilingual Applications", LocalDate.of(2022, 12, 23), "Copenhagen", "9788899001122");
				PonenciaEvento pon119 = new PonenciaEvento("IoT for Smart Buildings", LocalDate.of(2021, 9, 16), "Zurich", "9789900112233");
				PonenciaEvento pon120 = new PonenciaEvento("Serverless Security", LocalDate.of(2023, 4, 9), "Geneva", "9780011223344");
				PonenciaEvento pon121 = new PonenciaEvento("AI in Human Resources", LocalDate.of(2022, 11, 2), "Luxembourg", "9781122334455");
				PonenciaEvento pon122 = new PonenciaEvento("Cyber Threat Hunting", LocalDate.of(2021, 8, 25), "Riga", "9782233445566");
				PonenciaEvento pon123 = new PonenciaEvento("Quantum Machine Learning", LocalDate.of(2023, 3, 18), "Vilnius", "9783344556677");
				PonenciaEvento pon124 = new PonenciaEvento("Edge Computing for AR VR", LocalDate.of(2022, 10, 11), "Tallinn", "9784455667788");
				PonenciaEvento pon125 = new PonenciaEvento("Blockchain for Digital Identity", LocalDate.of(2021, 7, 4), "Bratislava", "9785566778899");
				PonenciaEvento pon126 = new PonenciaEvento("AI for Predictive Analytics", LocalDate.of(2023, 2, 27), "Ljubljana", "9786677889900");
				PonenciaEvento pon127 = new PonenciaEvento("Computer Vision in Retail", LocalDate.of(2022, 9, 20), "Zagreb", "9787788990011");
				PonenciaEvento pon128 = new PonenciaEvento("NLP for Voice Assistants", LocalDate.of(2021, 6, 13), "Sofia", "9788899001122");
				PonenciaEvento pon129 = new PonenciaEvento("IoT in Smart Agriculture", LocalDate.of(2023, 1, 6), "Bucharest", "9789900112233");
				PonenciaEvento pon130 = new PonenciaEvento("Multi Cloud Security", LocalDate.of(2022, 8, 30), "Belgrade", "9780011223344");
				PonenciaEvento pon131 = new PonenciaEvento("AI for Content Moderation", LocalDate.of(2021, 5, 23), "Kiev", "9781122334455");
				PonenciaEvento pon132 = new PonenciaEvento("Cybersecurity Awareness Training", LocalDate.of(2023, 12, 16), "Minsk", "9782233445566");
				PonenciaEvento pon133 = new PonenciaEvento("Quantum Cryptography Protocols", LocalDate.of(2022, 7, 9), "Warsaw", "9783344556677");
				PonenciaEvento pon134 = new PonenciaEvento("Edge AI for Healthcare", LocalDate.of(2021, 4, 2), "Prague", "9784455667788");
				PonenciaEvento pon135 = new PonenciaEvento("Blockchain for Voting Systems", LocalDate.of(2023, 11, 25), "Berlin", "9785566778899");
				PonenciaEvento pon136 = new PonenciaEvento("AI for Medical Diagnosis", LocalDate.of(2022, 6, 18), "Paris", "9786677889900");
				PonenciaEvento pon137 = new PonenciaEvento("Computer Vision in Sports", LocalDate.of(2021, 3, 11), "Rome", "9787788990011");
				PonenciaEvento pon138 = new PonenciaEvento("NLP for Sentiment Analysis", LocalDate.of(2023, 10, 4), "Madrid", "9788899001122");
				PonenciaEvento pon139 = new PonenciaEvento("IoT in Energy Management", LocalDate.of(2022, 5, 28), "Barcelona", "9789900112233");
				PonenciaEvento pon140 = new PonenciaEvento("Cloud Compliance Frameworks", LocalDate.of(2021, 2, 19), "Milan", "9780011223344");
				PonenciaEvento pon141 = new PonenciaEvento("AI for Financial Risk Assessment", LocalDate.of(2023, 9, 12), "Vienna", "9781122334455");
				PonenciaEvento pon142 = new PonenciaEvento("Ransomware Protection Strategies", LocalDate.of(2022, 4, 5), "Brussels", "9782233445566");
				PonenciaEvento pon143 = new PonenciaEvento("Quantum Computing Benchmarks", LocalDate.of(2021, 1, 28), "Amsterdam", "9783344556677");
				PonenciaEvento pon144 = new PonenciaEvento("Edge AI for Smart Cities", LocalDate.of(2023, 8, 21), "Dublin", "9784455667788");
				PonenciaEvento pon145 = new PonenciaEvento("Blockchain for Real Estate", LocalDate.of(2022, 3, 14), "Stockholm", "9785566778899");
				PonenciaEvento pon146 = new PonenciaEvento("AI for Supply Chain Optimization", LocalDate.of(2021, 12, 7), "Helsinki", "9786677889900");
				PonenciaEvento pon147 = new PonenciaEvento("Computer Vision in Quality Control", LocalDate.of(2023, 7, 30), "Oslo", "9787788990011");
				PonenciaEvento pon148 = new PonenciaEvento("NLP for Legal Document Analysis", LocalDate.of(2022, 2, 22), "Copenhagen", "9788899001122");
				PonenciaEvento pon149 = new PonenciaEvento("IoT in Water Management", LocalDate.of(2021, 11, 15), "Zurich", "9789900112233");
				PonenciaEvento pon150 = new PonenciaEvento("Hybrid Cloud Security", LocalDate.of(2023, 6, 8), "Geneva", "9780011223344");
		
				d201.agregarResultado(art101); e28.agregarResultado(art102); d203.agregarResultado(art103);
				d206.agregarResultado(art104); e29.agregarResultado(art105); d208.agregarResultado(art106);
				d211.agregarResultado(art107); e30.agregarResultado(art108); d213.agregarResultado(art109);
				d216.agregarResultado(art110); e31.agregarResultado(art111); d218.agregarResultado(art112);
				d221.agregarResultado(art113); e32.agregarResultado(art114); d223.agregarResultado(art115);
				d226.agregarResultado(art116); e33.agregarResultado(art117); d228.agregarResultado(art118);
				d231.agregarResultado(art119); e34.agregarResultado(art120); d233.agregarResultado(art121);
				d236.agregarResultado(art122); e35.agregarResultado(art123); d238.agregarResultado(art124);
				d241.agregarResultado(art125); e36.agregarResultado(art126); d243.agregarResultado(art127);
				d246.agregarResultado(art128); e37.agregarResultado(art129); d248.agregarResultado(art130);

				d202.agregarResultado(cap21); e38.agregarResultado(cap22); d204.agregarResultado(cap23);
				d207.agregarResultado(cap24); e39.agregarResultado(cap25); d209.agregarResultado(cap26);
				d212.agregarResultado(cap27); e40.agregarResultado(cap28); d214.agregarResultado(cap29);
				d217.agregarResultado(cap30);

				d205.agregarResultado(pon81); e28.agregarResultado(pon82); d210.agregarResultado(pon83);
				e29.agregarResultado(pon84); d215.agregarResultado(pon85); e30.agregarResultado(pon86);
				d220.agregarResultado(pon87); e31.agregarResultado(pon88); d225.agregarResultado(pon89);
				e32.agregarResultado(pon90); d230.agregarResultado(pon91); e33.agregarResultado(pon92);
				d235.agregarResultado(pon93); e34.agregarResultado(pon94); d240.agregarResultado(pon95);
				e35.agregarResultado(pon96); d245.agregarResultado(pon97); e36.agregarResultado(pon98);
				d250.agregarResultado(pon99); e37.agregarResultado(pon100); d255.agregarResultado(pon101);
				e38.agregarResultado(pon102); d260.agregarResultado(pon103); e39.agregarResultado(pon104);
				d265.agregarResultado(pon105); e40.agregarResultado(pon106); d270.agregarResultado(pon107);
				d201.agregarResultado(pon108); d202.agregarResultado(pon109); d203.agregarResultado(pon110);
				d204.agregarResultado(pon111); d205.agregarResultado(pon112); d206.agregarResultado(pon113);
				d207.agregarResultado(pon114); d208.agregarResultado(pon115); d209.agregarResultado(pon116);
				d210.agregarResultado(pon117); d211.agregarResultado(pon118); d212.agregarResultado(pon119);
				d213.agregarResultado(pon120); d214.agregarResultado(pon121); d215.agregarResultado(pon122);
				d216.agregarResultado(pon123); d217.agregarResultado(pon124); d218.agregarResultado(pon125);
				d219.agregarResultado(pon126); d220.agregarResultado(pon127); d221.agregarResultado(pon128);
				d222.agregarResultado(pon129); d223.agregarResultado(pon130); d224.agregarResultado(pon131);
				d225.agregarResultado(pon132); d226.agregarResultado(pon133); d227.agregarResultado(pon134);
				d228.agregarResultado(pon135); d229.agregarResultado(pon136); d230.agregarResultado(pon137);
				d231.agregarResultado(pon138); d232.agregarResultado(pon139); d233.agregarResultado(pon140);
				d234.agregarResultado(pon141); d235.agregarResultado(pon142); d236.agregarResultado(pon143);
				d237.agregarResultado(pon144); d238.agregarResultado(pon145); d239.agregarResultado(pon146);
				d240.agregarResultado(pon147); d241.agregarResultado(pon148); d242.agregarResultado(pon149);
				d243.agregarResultado(pon150);
				
				new VentanaPrincipal(vicedecanato);
			}
		});
	}
}
