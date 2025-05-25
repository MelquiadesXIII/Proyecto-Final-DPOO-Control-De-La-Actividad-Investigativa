package Interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FramePrincipal() {
		configurarVentanaPrincipal();
	}

	private void configurarVentanaPrincipal(){

		getContentPane().setBackground(Color.WHITE);
		setTitle("Vicedecanato de Investigacion");
		setMinimumSize(new Dimension(800,600)); //Establece el tamannio minimo
		setResizable(false);
		setSize(800, 600);;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
	}
}
