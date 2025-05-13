package Excepciones;

public class CadenaNoValidaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CadenaNoValidaException(String m){
		
		super(m);
	}

}
