package Interfaz;


import javax.swing.*;

import Interfaz.MensajeDialog.Tipo;
import Logica.*;

import java.util.ArrayList;
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
	private JButton botonReportes;
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
	private ArrayList<JButton> botonesNavegacion;
	private JButton botonSeleccionadoActual;
	private final Color COLOR_DEFAULT = new Color(30, 40, 50);
	private final Color COLOR_HOVER = new Color(50, 60, 70); 
	private final Color COLOR_SELECTED = new Color(70, 80, 90);
	private final Color COLOR_HEADER_BACKGROUND = new Color(45, 55, 65);
	private JPanel panelReportes; 
	
	public VentanaPrincipal(Vicedecanato vicedecanato){
		
		this.vicedecanato = vicedecanato;
		inicializarConfiguracionUI();
		crearPanelPrincipal();
		crearPanelNavegacion();
		
		if (this.botonInicio != null) {
			actualizarAparienciaBotones(this.botonInicio);
		}
		
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
		this.botonesNavegacion = new ArrayList<JButton>();
		
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
		panelBotones.setBackground(new Color(30, 40, 50)); //new Color(30, 40, 50)
		panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		panelNavegacion.add(panelBotones);
		
		botonInicio = crearBoton("Inicio");
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelInicio");
				actualizarAparienciaBotones(botonInicio);
			}
		});
		
		botonDepartamentos = crearBoton("Departamentos");
		botonDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelDepartamentos");
				actualizarAparienciaBotones(botonDepartamentos);
			}
		});
		
		botonDocentes = crearBoton("Docentes");
		botonDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelDocentes");
				actualizarAparienciaBotones(botonDocentes);
			}
		});
		
		botonEstudiantes = crearBoton("Estudiantes");
		botonEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelEstudiantes");
				actualizarAparienciaBotones(botonEstudiantes);
			}
		});
		
		botonReportes = crearBoton("Reportes");
		botonReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelReportes");
				actualizarAparienciaBotones(botonReportes);
			}
		});
		
		botonAyuda = crearBoton("Ayuda");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarAparienciaBotones(botonAyuda);
			}
		});
		
		botonSalir = crearBoton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarAparienciaBotones(botonSalir);
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
		
		panelBotones.add(Box.createRigidArea(new Dimension(0, 40)));
		panelBotones.add(boton);
		this.botonesNavegacion.add(boton);
		
		return boton;
	}
	
	private void crearPanelPrincipal(){
		
		cardLayout = new CardLayout();
		panelPrincipal = new JPanel(cardLayout);
		panelPrincipal.setBackground(Color.DARK_GRAY);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
	}

	private void crearPaneles(){
		
		panelInicio = crearPanelesConEncabezado("Bienvenido");
		panelPrincipal.add(panelInicio, "panelInicio");
		//panelInicio.setBackground(Color.DARK_GRAY);

		panelDocentes = crearPanelesConEncabezado("Docentes registrados en el vicedecanato:");
		panelPrincipal.add(panelDocentes, "panelDocentes");
		//panelDocentes.setBackground(Color.DARK_GRAY);
		
		panelEstudiantes = crearPanelesConEncabezado("Estudiantes registrados en el vicedecanato");
		panelPrincipal.add(panelEstudiantes, "panelEstudiantes");
		panelEstudiantes.setBackground(Color.DARK_GRAY);

		panelDepartamentos = crearPanelesConEncabezado("Departamentos:");
		panelPrincipal.add(panelDepartamentos, "panelDepartamentos");
		//panelDepartamentos.setBackground(Color.DARK_GRAY);
		
		panelReportes = crearPanelesConEncabezado("Listado de reportes");
		panelPrincipal.add(panelReportes, "panelReportes");
		//panelReportes.setBackground(Color.DARK_GRAY);
		
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
	     
	    // Crear el encabezado
	    JPanel encabezado = new JPanel();
	    encabezado.setBackground(COLOR_HEADER_BACKGROUND);
	    encabezado.setPreferredSize(new Dimension(0, 50)); // Altura del encabezado
	    JLabel lblTitulo = new JLabel(titulo);
	    lblTitulo.setForeground(Color.WHITE);
	    lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
	    encabezado.add(lblTitulo);
	    
	    // Agregar el encabezado al panel
	    panel.add(encabezado, BorderLayout.NORTH);
	    
	    return panel;
	}
	
}
