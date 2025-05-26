package Interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Interfaz.MensajeDialog.Tipo;
import Logica.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel panelNavegacion;
	private JPanel panelPrincipal;
	private JButton botonDepartamentos;
	private JPanel panelBotones;
	private JButton botonDocentes;
	private JButton botonEstudiantes;
	private JButton botonAyuda;
	private JButton botonSalir;
	private JButton botonInicio;
	private CardLayout cardLayout;
	private Vicedecanato vicedecanato;
	private JPanel panelDepartamentos;
	private JPanel panelEstudiantes;
	private JPanel panelDocentes;
	private JPanel panelInicio;
	private JList<String> listaDepartamentos;
	private DefaultListModel<String> modeloDepartamentos;
	private JList<String> listaDocentes;
	private DefaultListModel<String> modeloDocentes;
	private JList<String> listaEstudiantes;
	private DefaultListModel<String> modeloEstudiantes;
	
	public VentanaPrincipal(Vicedecanato vicedecanato){
		
		this.vicedecanato = vicedecanato;
		inicializarConfiguracionUI();
		crearPanelPrincipal();
		crearPanelNavegacion();
		crearPaneles();
		crearTablaDocentes();
		crearTablaDepartamentos();
		crearTablaEstudiantes();
		crearBotones();
	}
	
	private void inicializarConfiguracionUI(){
		
		setBackground(Color.WHITE);
		setTitle("Vicedecanato: Ventana Principal");
		setSize(new Dimension(1080, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
		
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
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelInicio");
			}
		});
		
		botonDepartamentos = crearBoton("Departamentos");
		botonDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelDepartamentos");
			}
		});
		
		botonDocentes = crearBoton("Docentes");
		botonDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelDocentes");
			}
		});
		
		botonEstudiantes = crearBoton("Estudiantes");
		botonEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelEstudiantes");
			}
		});
		
		botonAyuda = crearBoton("Ayuda");
		
		botonSalir = crearBoton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MensajeDialog dialog = new MensajeDialog(VentanaPrincipal.this, "Desea salir de la aplicación?", Tipo.CONFIRMACION);
		        dialog.setVisible(true);
		        
		        if (dialog.isConfirmado()) {
		            System.exit(0);
		        }
			}
		});
	}
	
	private JButton crearBoton(String nombre){
		
		final JButton boton = new JButton(nombre);
		boton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		boton.setBackground(new Color(30, 40, 50));
		boton.setForeground(Color.WHITE);
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton.setSize(new Dimension(200, 40));
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

	private void crearPaneles(){
		
		panelInicio = new JPanel();
		panelPrincipal.add(panelInicio, "panelInicio");
		panelInicio.setBackground(Color.DARK_GRAY);

		panelDocentes = new JPanel();
		panelPrincipal.add(panelDocentes, "panelDocentes");
		panelDocentes.setBackground(Color.DARK_GRAY);
		
		panelEstudiantes = new JPanel();
		panelPrincipal.add(panelEstudiantes, "panelEstudiantes");
		panelEstudiantes.setBackground(Color.DARK_GRAY);

		panelDepartamentos = new JPanel();
		panelPrincipal.add(panelDepartamentos, "panelDepartamentos");
		panelDepartamentos.setBackground(Color.DARK_GRAY);
		panelInicio.setLayout(null);
		
		JLabel lblBienvenida = new JLabel("Bienvenido!");
		lblBienvenida.setBounds(0, 0, 794, 465);
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicio.add(lblBienvenida);
	}
	
	private void crearTablaDepartamentos(){
		
		modeloDepartamentos = new DefaultListModel<>();

		for (Departamento departamento : vicedecanato.getDepartamentos()) {
			modeloDepartamentos.addElement(departamento.getNombre());
		}
		panelDepartamentos.setLayout(null);

		listaDepartamentos = new JList<>(modeloDepartamentos);
		listaDepartamentos.setForeground(Color.WHITE);
		listaDepartamentos.setBackground(Color.DARK_GRAY);
		listaDepartamentos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JScrollPane scrollDepartamentos = new JScrollPane(listaDepartamentos);
		scrollDepartamentos.setBounds(0, 1, 650, 685);
		panelDepartamentos.add(scrollDepartamentos);
	}
	
	private void crearTablaEstudiantes(){
		
		modeloEstudiantes = new DefaultListModel<>();

		for (Estudiante estudiante : vicedecanato.getEstudiantes()) {
			modeloEstudiantes.addElement(estudiante.getNombre() + " " + estudiante.getApellidos());
		}
		panelEstudiantes.setLayout(null);

		listaEstudiantes = new JList<>(modeloEstudiantes);
		listaEstudiantes.setForeground(Color.WHITE);
		listaEstudiantes.setBackground(Color.DARK_GRAY);
		listaEstudiantes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JScrollPane scrollEstudiantes = new JScrollPane(listaEstudiantes);
		scrollEstudiantes.setBounds(0, 1, 650, 685);

		panelEstudiantes.add(scrollEstudiantes);
	}
	
	private void crearTablaDocentes(){
		
		modeloDocentes = new DefaultListModel<>();

		for (Docente docente : vicedecanato.getDocentes()) {
			modeloDocentes.addElement(docente.getNombre() + " " + docente.getApellidos());
		}
		panelDocentes.setLayout(null);

		listaDocentes = new JList<>(modeloDocentes);
		listaDocentes.setForeground(Color.WHITE);
		listaDocentes.setBackground(Color.DARK_GRAY);
		listaDocentes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JScrollPane scrollDocentes = new JScrollPane(listaDocentes);
		scrollDocentes.setBounds(0, 1, 650, 685);
		panelDocentes.add(scrollDocentes);
	}
	
	private void crearBotones(){
		
		JButton btnCrearEst = new JButton("Crear");
		btnCrearEst.setBounds(660, 13, 140, 25);
		panelEstudiantes.add(btnCrearEst);
		
		JButton btnEliminarEst = new JButton("Eliminar");
		btnEliminarEst.setBounds(660, 60, 140, 25);
		panelEstudiantes.add(btnEliminarEst);
		
		JButton btnCrearDoc = new JButton("Crear");
		btnCrearDoc.setBounds(660, 13, 140, 25);
		panelDocentes.add(btnCrearDoc);

		JButton btnEliminarDoc = new JButton("Eliminar");
		btnEliminarDoc.setBounds(660, 60, 140, 25);
		panelDocentes.add(btnEliminarDoc);
		
		JButton btnCrearDep = new JButton("Crear");
		btnCrearDep.setBounds(660, 13, 140, 25);
		panelDepartamentos.add(btnCrearDep);

		JButton btnEliminarDep = new JButton("Eliminar");
		btnEliminarDep.setBounds(660, 60, 140, 25);
		panelDepartamentos.add(btnEliminarDep);
	}
	
	
}
