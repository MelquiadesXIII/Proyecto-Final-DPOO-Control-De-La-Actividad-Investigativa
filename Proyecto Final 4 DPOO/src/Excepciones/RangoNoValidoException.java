package Excepciones;

public class RangoNoValidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RangoNoValidoException(String m) {
		
		super(m);
	}

}
