package Interfaz;

import javax.swing.JDialog;
import javax.swing.JFrame;

import Logica.Departamento;
import Logica.Vicedecanato;

public class EditarMaestriaDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	private int duracionMeses;
	private String campoEstudio;
	private String nombre;

	public EditarMaestriaDialog(JFrame parent, Departamento dptoActual) {
	}

	public boolean isConfirmado() {
		return false;
	}
	
	public String getNombre() 
	{
		return nombre;
	}

	public int getDuracionMeses() 
	{
		return duracionMeses;
	}

	public String getCampoEstudio() 
	{
		return campoEstudio;
	}
}
