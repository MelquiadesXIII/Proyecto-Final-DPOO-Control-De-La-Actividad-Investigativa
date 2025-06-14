package Interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Interfaz.MensajeDialog.Tipo;
import Logica.*;
import Excepciones.*;

import javax.swing.*;

public class VentanaGestionDepartamento extends JDialog{

	private static final long serialVersionUID = 1L;
	private final Color COLOR_DEFAULT = new Color(30, 40, 50);
	private final Color COLOR_HOVER = new Color(50, 60, 70); 
	private final Color COLOR_SELECTED = new Color(70, 80, 90);
	private final Color COLOR_HEADER_BACKGROUND = new Color(45, 55, 65);
	private Departamento dptoActual;
	private Vicedecanato vicedecanato;
	private ArrayList<JButton> botonesNavegacion;
	private JPanel panelNavegacion;
	private JPanel panelBotones;
	protected JButton botonSeleccionadoActual;
	private CardLayout cardLayout;
	private JPanel panelPrincipal;
	private JFrame parent;
	private JButton botonLineas;
	private JButton botonMaestrias;
	private JButton botonEstudiantes;
	private JButton botonDocentes;
	private JButton botonInicio;
	private JButton botonSalir;
	
	
	
	public VentanaGestionDepartamento(JFrame parent, final Departamento dptoActual, final Vicedecanato vicedecanato){
		
		super(parent, "Gestión de " + dptoActual.getNombre(), true);
		this.dptoActual = dptoActual;
		this.vicedecanato = vicedecanato;
		this.parent = parent;
		
		inicializarConfiguracionUI();
		crearPanelPrincipal();
		configurarPanelNavegacion();
		
		
		
		this.parent.setVisible(false);
		setVisible(true);
	}
	
	private void inicializarConfiguracionUI(){

		setBackground(Color.WHITE);
		setTitle("Sistema Integral de Gestión Investigativa y de Posgrado: Ventana de Gestión de " + dptoActual.getNombre());
		setSize(new Dimension(1080, 720));
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setLocationRelativeTo(this.parent);
		getContentPane().setLayout(new BorderLayout());
		this.botonesNavegacion = new ArrayList<JButton>();
	}
	
	private void configurarPanelNavegacion(){

		panelNavegacion = new JPanel();
		panelNavegacion.setBackground(new Color(30, 40, 50));
		panelNavegacion.setLayout(new BoxLayout(panelNavegacion, BoxLayout.Y_AXIS));
		panelNavegacion.setPreferredSize(new Dimension(250, getHeight())); 

		JLabel titulo = new JLabel("SIGIP");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		panelNavegacion.add(titulo);

		getContentPane().add(panelNavegacion, BorderLayout.WEST);

		panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		panelBotones.setBackground(new Color(30, 40, 50)); //new Color(30, 40, 50)
		panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		panelNavegacion.add(panelBotones);
		
		botonInicio = crearBotonNavegacion("Inicio");
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelInicio");
				actualizarAparienciaBotones(botonInicio);
			}
		});
		
		botonDocentes = crearBotonNavegacion("Docentes");
		botonDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelDocentes");
				actualizarAparienciaBotones(botonDocentes);
			}
		});

		botonEstudiantes = crearBotonNavegacion("Estudiantes");
		botonEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelEstudiantes");
				actualizarAparienciaBotones(botonEstudiantes);
			}
		});

		botonMaestrias = crearBotonNavegacion("Maestrías");
		botonMaestrias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelDepartamentos");
				actualizarAparienciaBotones(botonMaestrias);
			}
		});
		
		botonLineas = crearBotonNavegacion("Lineas Inv.");
		botonLineas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelDepartamentos");
				actualizarAparienciaBotones(botonLineas);
			}
		});

		botonSalir = crearBotonNavegacion("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarAparienciaBotones(botonSalir);
				MensajeDialog dialog = new MensajeDialog(parent, "¿Desea salir de la ventana actual?", Tipo.CONFIRMACION);
				dialog.setVisible(true);

				if (dialog.isConfirmado()) {
					dispose();
					parent.setVisible(true);
				}
			}
		});
	}
	
	private JButton crearBotonNavegacion(String nombre){

		final JButton boton = new JButton(nombre);
		boton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		boton.setBackground(new Color(30, 40, 50));
		boton.setForeground(Color.WHITE);
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		boton.setFocusPainted(false);
		boton.setBorderPainted(false);

		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (boton != botonSeleccionadoActual) { 
					boton.setBackground(COLOR_HOVER);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (boton != botonSeleccionadoActual) { 
					boton.setBackground(COLOR_DEFAULT);
				}
			}
		});

		panelBotones.add(Box.createRigidArea(new Dimension(0, 53)));
		panelBotones.add(boton);
		this.botonesNavegacion.add(boton);

		return boton;
	}
	
	private void actualizarAparienciaBotones(JButton botonActivo) {
		botonSeleccionadoActual = botonActivo;
		for (JButton btn : botonesNavegacion) {
			if (btn == botonSeleccionadoActual && !btn.equals(botonSalir)) {
				btn.setBackground(COLOR_SELECTED);
			} else {
				btn.setBackground(COLOR_DEFAULT);
			}
		}
	}
	
	private JPanel crearPanelesConEncabezado(String titulo){

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);

		JPanel encabezado = new JPanel();
		encabezado.setBackground(COLOR_HEADER_BACKGROUND);
		encabezado.setPreferredSize(new Dimension(0, 50)); 
		JLabel lblTitulo = new JLabel(titulo);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);

		panel.add(encabezado, BorderLayout.NORTH);

		return panel;
	}

	private void crearPanelPrincipal(){

		cardLayout = new CardLayout();
		panelPrincipal = new JPanel(cardLayout);
		panelPrincipal.setBackground(Color.DARK_GRAY);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
	}
}
