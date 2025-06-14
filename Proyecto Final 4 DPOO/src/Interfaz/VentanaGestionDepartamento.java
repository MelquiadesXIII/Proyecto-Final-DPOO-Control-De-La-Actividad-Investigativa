package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import Logica.*;
import Excepciones.*;

import javax.swing.*;

public class VentanaGestionDepartamento extends JDialog{

	private static final long serialVersionUID = 1L;
	private JFrame parent;
	private Departamento dptoActual;
	private Vicedecanato vicedecanato;
	private ArrayList<JButton> botonesNavegacion;
	
	
	
	public VentanaGestionDepartamento(JFrame parent, Departamento dptoActual, Vicedecanato vicedecanato){
		
		this.parent = parent;
		this.dptoActual = dptoActual;
		this.vicedecanato = vicedecanato;
		
		this.parent.setVisible(false);
		setVisible(true);
	}
	
	private void inicializarConfiguracionUI(){

		setBackground(Color.WHITE);
		setTitle("Sistema Integral de Gestión Investigativa y de Posgrado: Ventana Principal");
		setSize(new Dimension(1080, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		this.botonesNavegacion = new ArrayList<JButton>();
	}
}
