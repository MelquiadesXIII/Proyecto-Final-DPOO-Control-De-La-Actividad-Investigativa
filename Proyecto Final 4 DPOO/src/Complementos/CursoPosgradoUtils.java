package Complementos;

import java.util.ArrayList;

import Logica.CursoPosgrado;

public class CursoPosgradoUtils {

	public static boolean iguales(CursoPosgrado c1, CursoPosgrado c2){

		return (c1 != null && c2 != null) &&
				(c1 == c2) || 
				(c1.getObjetivos().equals(c2.getObjetivos()) &&
						c1.getCantCreditos() == c2.getCantCreditos() &&
						c1.getTema().equals(c2.getTema()) &&
						DocenteUtils.iguales(c1.getProfesor(), c2.getProfesor()));
	}

	public static boolean listaContieneCurso(ArrayList<CursoPosgrado> lista, CursoPosgrado c){

		return indiceDe(lista, c) >= 0;
	}
	
	public static int indiceDe(ArrayList<CursoPosgrado> lista, CursoPosgrado c){
		
		boolean encontrado = false;
		int indice = -1;

		if(c != null && lista != null && lista.size() > 0){

			int i = 0;
			while(i < lista.size() && !encontrado){

				if(iguales(lista.get(i), c)){
					encontrado = true;
					indice = i;

				}else
					i++;
			}
		}
		return indice;
	}

}
