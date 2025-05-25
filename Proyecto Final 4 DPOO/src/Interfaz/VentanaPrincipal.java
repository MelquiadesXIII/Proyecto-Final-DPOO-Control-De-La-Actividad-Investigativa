package Interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel panelNavegacion;
	JPanel panelPrincipal;
	JButton botonDepartamentos;
	JPanel panelBotones;
	JButton botonDocentes;
	JButton botonEstudiantes;
	JButton botonAyuda;
	JButton botonSalir;
	JButton botonInicio;
	CardLayout cardLayout;
	
	public VentanaPrincipal(){
		
		
		inicializarConfiguracionUI();
		crearPanelPrincipal();
		crearPanelNavegacion();
	}
	
	private void inicializarConfiguracionUI(){
		
		setBackground(Color.WHITE);
		setTitle("Vicedecanato: Ventana Principal");
		setSize(new Dimension(1080, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		
		setVisible(true);
	}
	
	private void crearPanelNavegacion(){
		
		panelNavegacion = new JPanel();
		panelNavegacion.setBackground(new Color(30, 40, 50));
		panelNavegacion.setLayout(new BoxLayout(panelNavegacion, BoxLayout.Y_AXIS));
		panelNavegacion.setPreferredSize(new Dimension(250, getHeight())); 
		
		JLabel titulo = new JLabel("Vicedecanato");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		panelNavegacion.add(titulo);
		
		getContentPane().add(panelNavegacion, BorderLayout.WEST);
		
		panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		panelBotones.setBackground(new Color(30, 40, 50));
		panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		panelNavegacion.add(panelBotones);
		
		botonInicio = crearBoton("Inicio");
		
		botonDepartamentos = crearBoton("Departamentos");
		
		
		
		botonDocentes = crearBoton("Docentes");
		botonEstudiantes = crearBoton("Estudiantes");
		botonAyuda = crearBoton("Ayuda");
		botonSalir = crearBoton("Salir");
	}
	
	private JButton crearBoton(String nombre){
		
		final JButton boton = new JButton(nombre);
		boton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		boton.setBackground(new Color(30, 40, 50));
		boton.setForeground(Color.WHITE);
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton.setPreferredSize(new Dimension(200, 40));
		boton.setFocusPainted(false);
		boton.setBorderPainted(false);
		
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boton.setBackground(new Color(50, 60, 70));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boton.setBackground(new Color(30, 40, 50));
			}
		});
		
		panelBotones.add(Box.createRigidArea(new Dimension(0, 40)));
		panelBotones.add(boton);
		
		return boton;
	}
	
	private void crearPanelPrincipal(){
		
		cardLayout = new CardLayout();
		panelPrincipal = new JPanel(cardLayout);
		panelPrincipal.setBackground(Color.DARK_GRAY);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
	}
}
