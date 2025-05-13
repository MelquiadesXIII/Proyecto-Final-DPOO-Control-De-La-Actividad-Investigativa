package Errores;

import javax.swing.JOptionPane;

public class ErroresCursoPosgrado {
	
	public static void cantCreditosNoPositiva(){
		JOptionPane.showMessageDialog(null, "La cantidad de creditos proporcionados por un curso debe ser una cantidad positiva", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void profesoresIguales(){
		JOptionPane.showMessageDialog(null, "Ha intentado asignar al mismo profesor que imparte el curso", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void categoriaCientificaNoValida(){
		JOptionPane.showMessageDialog(null, "El profesor que imparte el curso debe tener categoria cientifica Doctor", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void profesorImpartidorComoParticipante(){
		JOptionPane.showMessageDialog(null, "El profesor que imparte el curso no puede ser uno de los participantes", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void participanteDuplicado(){
		JOptionPane.showMessageDialog(null, "El profesor no se puede agregar porque ya se encuentra en el curso", "Error", JOptionPane.ERROR_MESSAGE);
	}

}
