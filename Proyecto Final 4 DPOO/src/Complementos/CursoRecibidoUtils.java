package Complementos;

import java.util.ArrayList;

import Logica.CursoPosgrado;
import Logica.CursoRecibido;

public class CursoRecibidoUtils {

	public static boolean iguales(CursoRecibido c1, CursoRecibido c2){

		return (c1 != null && c2 != null) &&
				(c1 == c2) || 
				(c1.getNota() == c2.getNota() &&
				c1.getCreditosRecibidos() == c2.getCreditosRecibidos() &&
				CursoPosgradoUtils.iguales(c1.getCurso(), c2.getCurso()));
	}

	public static boolean listaContieneCurso(ArrayList<CursoPosgrado> lista, CursoPosgrado c){

		return indiceDe(lista, c) >= 0;
	}

	public static int indiceDe(ArrayList<CursoRecibido> lista, CursoRecibido c){

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
