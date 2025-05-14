package Excepciones;

public class ValorNoValidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ValorNoValidoException(String m) {
		
		super(m);
	}

}
