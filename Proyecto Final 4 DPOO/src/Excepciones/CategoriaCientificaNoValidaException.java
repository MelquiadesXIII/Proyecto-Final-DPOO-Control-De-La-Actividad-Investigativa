package Excepciones;

public class CategoriaCientificaNoValidaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CategoriaCientificaNoValidaException(String m){

		super(m);
	}

}
