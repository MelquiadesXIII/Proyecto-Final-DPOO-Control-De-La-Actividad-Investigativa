package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public Login() {
		
		setTitle("Vicedecanato: Iniciar sesión o registrarse");
		setResizable(false);
		setSize(1080, 720);;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.BLACK);
		
		setVisible(true);
	}

}
