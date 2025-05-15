package Complementos;

import java.util.ArrayList;

import Logica.Docente;

public class DocenteUtils {

	public static boolean iguales(Docente docente1, Docente docente2){

		return (docente1 != null && docente2 != null) && 
				(docente1 == docente2 || 
						(docente1.getNombre().equals(docente2.getNombre()) && 
								docente1.getApellidos().equals(docente2.getApellidos()) && 
								docente1.getCatCientifica() == docente2.getCatCientifica() && 
								docente1.getCatDocente() == docente2.getCatDocente()));
	}


	public static boolean listaContieneDocente(ArrayList<Docente> lista, Docente d){

		return indiceDe(lista, d) >= 0;
	}

	public static int indiceDe(ArrayList<Docente> lista, Docente d){

		boolean encontrado = false;
		int indice = -1;

		if(d != null && lista != null && lista.size() > 0){

			int i = 0;
			while(i < lista.size() && !encontrado){

				if(iguales(lista.get(i), d)){
					encontrado = true;
					indice = i;

				}else
					i++;
			}
		}
		return indice;
	}
}
