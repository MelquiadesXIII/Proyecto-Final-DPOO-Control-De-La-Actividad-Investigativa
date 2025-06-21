package Interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import Interfaz.MensajeDialog.Tipo;
import Logica.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


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
	private VentanaPrincipal parent;
	private JButton botonLineas;
	private JButton botonMaestrias;
	private JButton botonEstudiantes;
	private JButton botonDocentes;
	private JButton botonInicio;
	private JButton botonSalir;
	private JPanel panelInicio;
	private JPanel panelLineas;
	private JPanel panelMaestrias;
	private JPanel panelEstudiantes;
	private JPanel panelDocentes;
	private DefaultListModel<Object> modeloMaestrias;
	private JList<Object> listaMaestrias;
	private JPanel panelBotonesCRUDEstudiantes;
	private JPanel panelBotonesCRUDDocentes;
	private JPanel panelBotonesCRUDMaestria;
	private JPanel panelBotonesCRUDCursos;
	private JPanel panelBotonesCRUDLineas;
	private JPanel panelBotonesCRUDResultados;
	private JButton botonCursos;
	private JButton botonResultados;
	private JPanel panelCursos;
	private JPanel panelResultados;
	private JTable tablaDocentes;
	private DefaultTableModel modeloTablaDocentes;
	private ArrayList<Docente> docentesEnTabla = new ArrayList<>();
	private JScrollPane scrollTablaDocentes;
	private JTable tablaEstudiantes;
	private ArrayList<Estudiante> estudiantesEnTabla = new ArrayList<>();
	private DefaultTableModel modeloTablaEstudiantes;
	private JScrollPane scrollTablaEstudiantes;
	private JTable tablaMaestrias;
	private ArrayList<Maestria> maestriasEnTabla = new ArrayList<>();
	private JScrollPane scrollTablaMaestrias;
	private DefaultTableModel modeloTablaMaestrias;
	private DefaultTableModel modeloTablaCursos;
	private JTable tablaCursos;
	private JScrollPane scrollTablaCursos;
	private ArrayList<CursoPosgrado> cursosEnTabla = new ArrayList<>();
	private ArrayList<LineaInvestigacion> lineasEnTabla = new ArrayList<>();
	private ArrayList<ResultadoInvestigativo> resultadosEnTabla = new ArrayList<>();
	private DefaultTableModel modeloTablaLineas;
	private JTable tablaLineas;
	private JScrollPane scrollTablaLineas;
	private DefaultTableModel modeloTablaResultados;
	private JTable tablaResultados;
	private JScrollPane scrollTablaResultados;
	private Investigador investigadorActual;



	public VentanaGestionDepartamento(VentanaPrincipal parent, final Departamento dptoActual, final Vicedecanato vicedecanato){

		super(parent, "Gestión de " + dptoActual.getNombre(), true);
		this.dptoActual = dptoActual;
		this.vicedecanato = vicedecanato;
		this.parent = parent;

		inicializarConfiguracionUI();
		crearPanelPrincipal();
		configurarPanelNavegacion();

		if (this.botonInicio != null) {
			actualizarAparienciaBotones(this.botonInicio);
		}

		crearPaneles();
		configurarPanelesCRUD();
		actualizarTodasLasTablas();

		//this.parent.setVisible(false);
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

		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e){

				parent.actualizarTodasLasTablas();
			}

		});
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
				cl.show(panelPrincipal, "panelMaestrias");
				actualizarAparienciaBotones(botonMaestrias);
			}
		});

		botonCursos = crearBotonNavegacion("Cursos");
		botonCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelCursos");
				actualizarAparienciaBotones(botonCursos);
			}
		});

		botonLineas = crearBotonNavegacion("Líneas de Inv.");
		botonLineas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelLineas");
				actualizarAparienciaBotones(botonLineas);
			}
		});

		botonResultados = crearBotonNavegacion("Resultados");
		botonResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelResultados");
				actualizarAparienciaBotones(botonResultados);
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
					parent.actualizarTodasLasTablas();
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

		panelBotones.add(Box.createRigidArea(new Dimension(0, 33)));
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

	private void crearPaneles(){

		panelInicio = crearPanelesConEncabezado("Bienvenido");
		panelPrincipal.add(panelInicio, "panelInicio");
		panelInicio.setBackground(Color.DARK_GRAY);

		panelDocentes = crearPanelesConEncabezado("Docentes registrados en el departamento");
		panelPrincipal.add(panelDocentes, "panelDocentes");
		panelDocentes.setBackground(Color.DARK_GRAY);

		panelEstudiantes = crearPanelesConEncabezado("Estudiantes registrados en el departamento");
		panelPrincipal.add(panelEstudiantes, "panelEstudiantes");
		panelEstudiantes.setBackground(Color.DARK_GRAY);

		panelMaestrias = crearPanelesConEncabezado("Maestrías registradas en el departamento");
		panelPrincipal.add(panelMaestrias, "panelMaestrias");
		panelMaestrias.setBackground(Color.DARK_GRAY);

		panelCursos = crearPanelesConEncabezado("Cursos de las maestrías del departamento");
		panelPrincipal.add(panelCursos, "panelCursos");
		panelCursos.setBackground(Color.DARK_GRAY);

		panelLineas = crearPanelesConEncabezado("Líneas de investigación registradas en el departamento:");
		panelPrincipal.add(panelLineas, "panelLineas");
		panelLineas.setBackground(Color.DARK_GRAY);

		panelResultados = crearPanelesConEncabezado("Resultados investigativos de los investigadores del departamento");
		panelPrincipal.add(panelResultados, "panelResultados");
		panelResultados.setBackground(Color.DARK_GRAY);

		JLabel lblBienvenida = new JLabel("<html>" +
				"<div style='text-align: center; font-family: Segoe UI;'>" +
				"<h1>Sistema Integral de Gestión Investigativa y de Posgrado</h1>" +
				"<p><b>Facultad de Ingeniería Informática" +
				"<hr>" +
				"<p style='text-align: left;'>" +
				"Actualmente se encuentra en la gestión del <b>" + dptoActual.getNombre() + " </b> para:<br><br>" +
				"• Registrar y monitorear <b>líneas de investigación</b>.<br>" +
				"• Gestionar <b>resultados científicos</b> (artículos, capítulos, ponencias).<br>" +
				"• Administrar <b>cursos de posgrado</b> (impartidos, recibidos, créditos).<br>" +
				"• Acompañar el progreso en <b>maestrías</b> (matrículas, defensas).<br><br>" +
				"</p>" +
				"</div>" +
				"</html>");
		lblBienvenida.setBounds(0, 0, 794, 465);
		lblBienvenida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblBienvenida.setForeground(Color.WHITE);
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicio.add(lblBienvenida);
	}

	private void crearTablaDocentes(){

		docentesEnTabla.clear();

		String[] columnas = {"Nombre y apellidos", "Cat. Científica", "Cat. Docente", "Cursos Impartidos", "Cursos Recibidos", "Investigaciones"};

		modeloTablaDocentes = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Docente docente : dptoActual.getDocentes()) {


			Object[] fila = {
					docente.getNombre() + " " + docente.getApellidos(),
					docente.getCatCientifica().getCategoria(),
					docente.getCatDocente().getCategoria(),
					docente.getCursosImpartidos().size(),
					docente.getCursosRecibidos().size(),
					docente.getResultados().size()
			};

			docentesEnTabla.add(docente); //Se agregan los docentes al array list coincidiendo con el indice del docente en la tabla
			modeloTablaDocentes.addRow(fila);
		}

		tablaDocentes = new JTable(modeloTablaDocentes);

		tablaDocentes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tablaDocentes.setRowHeight(30);
		tablaDocentes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tablaDocentes.getTableHeader().setBackground(COLOR_HEADER_BACKGROUND);
		tablaDocentes.getTableHeader().setForeground(Color.WHITE);
		tablaDocentes.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaDocentes.getColumnCount(); i++) {
			tablaDocentes.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		tablaDocentes.getColumnModel().getColumn(0).setPreferredWidth(170);
		tablaDocentes.getColumnModel().getColumn(1).setPreferredWidth(95);
		tablaDocentes.getColumnModel().getColumn(2).setPreferredWidth(95);
		tablaDocentes.getColumnModel().getColumn(3).setPreferredWidth(120);
		tablaDocentes.getColumnModel().getColumn(4).setPreferredWidth(120);
		tablaDocentes.getColumnModel().getColumn(5).setPreferredWidth(120);

		scrollTablaDocentes = new JScrollPane(tablaDocentes);
		scrollTablaDocentes.setBorder(BorderFactory.createEmptyBorder());

		panelDocentes.add(scrollTablaDocentes, BorderLayout.CENTER);

	}

	public void actualizarTablaDoc() {

		panelDocentes.removeAll();

		JPanel encabezado = new JPanel();
		encabezado.setBackground(COLOR_HEADER_BACKGROUND);
		encabezado.setPreferredSize(new Dimension(0, 50));
		JLabel lblTitulo = new JLabel("Docentes registrados en el departamento");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);
		panelDocentes.add(encabezado, BorderLayout.NORTH);

		crearTablaDocentes();

		panelDocentes.add(panelBotonesCRUDDocentes, BorderLayout.SOUTH);

		panelDocentes.revalidate();
		panelDocentes.repaint();
	}

	private void crearTablaEstudiantes(){

		estudiantesEnTabla.clear();

		String[] columnas = {"Nombre y apellidos", "Grupo", "Investigaciones"};

		modeloTablaEstudiantes = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Estudiante estudiante : dptoActual.getEstudiantes()) {

			Object[] fila = {
					estudiante.getNombre() + " " + estudiante.getApellidos(), 
					estudiante.getGrupo(),
					estudiante.getResultados().size() 
			};

			estudiantesEnTabla.add(estudiante);
			modeloTablaEstudiantes.addRow(fila);
		}

		tablaEstudiantes = new JTable(modeloTablaEstudiantes);

		tablaEstudiantes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tablaEstudiantes.setRowHeight(30);
		tablaEstudiantes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tablaEstudiantes.getTableHeader().setBackground(COLOR_HEADER_BACKGROUND);
		tablaEstudiantes.getTableHeader().setForeground(Color.WHITE);
		tablaEstudiantes.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaEstudiantes.getColumnCount(); i++) {
			tablaEstudiantes.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		tablaEstudiantes.getColumnModel().getColumn(0).setPreferredWidth(200);
		tablaEstudiantes.getColumnModel().getColumn(1).setPreferredWidth(150); 
		tablaEstudiantes.getColumnModel().getColumn(2).setPreferredWidth(200);

		scrollTablaEstudiantes = new JScrollPane(tablaEstudiantes);
		scrollTablaEstudiantes.setBorder(BorderFactory.createEmptyBorder());
		panelEstudiantes.add(scrollTablaEstudiantes, BorderLayout.CENTER);

	}

	public void actualizarTablaEst() {

		panelEstudiantes.removeAll();


		JPanel encabezado = new JPanel();
		encabezado.setBackground(COLOR_HEADER_BACKGROUND);
		encabezado.setPreferredSize(new Dimension(0, 50));
		JLabel lblTitulo = new JLabel("Estudiantes registrados en el departamento");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);
		panelEstudiantes.add(encabezado, BorderLayout.NORTH);

		crearTablaEstudiantes();  

		panelEstudiantes.add(panelBotonesCRUDEstudiantes, BorderLayout.SOUTH);
		panelEstudiantes.revalidate();
		panelEstudiantes.repaint();
	}

	private void crearTablaMaestrias() {

		maestriasEnTabla.clear();
		String[] columnas = {"Nombre", "Campo de estudio", "Duración (meses)", "Matriculados", "Cursos"};

		modeloTablaMaestrias = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Maestria maestria : dptoActual.getMaestrias()) {
			Object[] fila = {
					maestria.getNombre(),
					maestria.getCampoEstudio(),
					maestria.getDuracionMeses(),
					maestria.getMatriculados().size(),
					maestria.getCursos().size()
			};
			maestriasEnTabla.add(maestria);
			modeloTablaMaestrias.addRow(fila);
		}

		tablaMaestrias = new JTable(modeloTablaMaestrias);
		tablaMaestrias.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tablaMaestrias.setRowHeight(30);
		tablaMaestrias.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tablaMaestrias.getTableHeader().setBackground(COLOR_HEADER_BACKGROUND);
		tablaMaestrias.getTableHeader().setForeground(Color.WHITE);
		tablaMaestrias.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaMaestrias.getColumnCount(); i++) {
			tablaMaestrias.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		tablaMaestrias.getColumnModel().getColumn(0).setPreferredWidth(230);
		tablaMaestrias.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablaMaestrias.getColumnModel().getColumn(2).setPreferredWidth(150);
		tablaMaestrias.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaMaestrias.getColumnModel().getColumn(4).setPreferredWidth(100);

		scrollTablaMaestrias = new JScrollPane(tablaMaestrias);
		scrollTablaMaestrias.setBorder(BorderFactory.createEmptyBorder());
		panelMaestrias.add(scrollTablaMaestrias, BorderLayout.CENTER);
	}

	public void actualizarTablaMaestrias() {
		panelMaestrias.removeAll();

		JPanel encabezado = new JPanel();
		encabezado.setBackground(COLOR_HEADER_BACKGROUND);
		encabezado.setPreferredSize(new Dimension(0, 50));
		JLabel lblTitulo = new JLabel("Maestrías registradas en el departamento");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);
		panelMaestrias.add(encabezado, BorderLayout.NORTH);

		crearTablaMaestrias();

		panelMaestrias.add(panelBotonesCRUDMaestria, BorderLayout.SOUTH);
		panelMaestrias.revalidate();
		panelMaestrias.repaint();
	}

	private void crearTablaCursos() {
		cursosEnTabla.clear();
		String[] columnas = {"Tema del curso", "Créditos", "Profesor", "Maestría"};

		modeloTablaCursos = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Maestria maestria : dptoActual.getMaestrias()) {
			for (CursoPosgrado curso : maestria.getCursos()) {
				Object[] fila = {
						curso.getTema(),
						curso.getCantCreditos(),
						curso.getProfesor().getNombre() + " " + curso.getProfesor().getApellidos(),
						maestria.getNombre()
				};
				cursosEnTabla.add(curso);
				modeloTablaCursos.addRow(fila);
			}
		}

		tablaCursos = new JTable(modeloTablaCursos);
		tablaCursos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tablaCursos.setRowHeight(30);
		tablaCursos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tablaCursos.getTableHeader().setBackground(COLOR_HEADER_BACKGROUND);
		tablaCursos.getTableHeader().setForeground(Color.WHITE);
		tablaCursos.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaCursos.getColumnCount(); i++) {
			tablaCursos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		tablaCursos.getColumnModel().getColumn(0).setPreferredWidth(250);
		tablaCursos.getColumnModel().getColumn(1).setPreferredWidth(50);
		tablaCursos.getColumnModel().getColumn(2).setPreferredWidth(200);
		tablaCursos.getColumnModel().getColumn(3).setPreferredWidth(250);

		scrollTablaCursos = new JScrollPane(tablaCursos);
		scrollTablaCursos.setBorder(BorderFactory.createEmptyBorder());
		panelCursos.add(scrollTablaCursos, BorderLayout.CENTER);
	}

	public void actualizarTablaCursos() {
		panelCursos.removeAll();

		JPanel encabezado = new JPanel();
		encabezado.setBackground(COLOR_HEADER_BACKGROUND);
		encabezado.setPreferredSize(new Dimension(0, 50));
		JLabel lblTitulo = new JLabel("Cursos registrados en las maestrías del departamento");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);
		panelCursos.add(encabezado, BorderLayout.NORTH);

		crearTablaCursos();

		panelCursos.add(panelBotonesCRUDCursos, BorderLayout.SOUTH);
		panelCursos.revalidate();
		panelCursos.repaint();
	}

	private void crearTablaLineasInvestigacion() {

		lineasEnTabla.clear();
		String[] columnas = {"Nombre de la línea", "Investigadores", "Resultados publicados", "Responsable"};

		modeloTablaLineas = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (LineaInvestigacion linea : dptoActual.getLineasInvestigacion()) {
			int totalResultados = 0;
			for (Investigador investigador : linea.getInvestigadores()) {
				totalResultados += investigador.getResultados().size();
			}

			Object[] fila = {
					linea.getNombre(),
					linea.getInvestigadores().size(),
					totalResultados,
					linea.getResponsable().getNombre() + " " + linea.getResponsable().getApellidos()
			};

			lineasEnTabla.add(linea);
			modeloTablaLineas.addRow(fila);
		}

		tablaLineas = new JTable(modeloTablaLineas);
		tablaLineas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tablaLineas.setRowHeight(30);
		tablaLineas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tablaLineas.getTableHeader().setBackground(COLOR_HEADER_BACKGROUND);
		tablaLineas.getTableHeader().setForeground(Color.WHITE);
		tablaLineas.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaLineas.getColumnCount(); i++) {
			tablaLineas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		tablaLineas.getColumnModel().getColumn(0).setPreferredWidth(280);
		tablaLineas.getColumnModel().getColumn(1).setPreferredWidth(120);
		tablaLineas.getColumnModel().getColumn(2).setPreferredWidth(130);
		tablaLineas.getColumnModel().getColumn(3).setPreferredWidth(170);

		scrollTablaLineas = new JScrollPane(tablaLineas);
		scrollTablaLineas.setBorder(BorderFactory.createEmptyBorder());
		panelLineas.add(scrollTablaLineas, BorderLayout.CENTER);
	}

	public void actualizarTablaLineas() {
		panelLineas.removeAll();

		JPanel encabezado = new JPanel();
		encabezado.setBackground(COLOR_HEADER_BACKGROUND);
		encabezado.setPreferredSize(new Dimension(0, 50));
		JLabel lblTitulo = new JLabel("Líneas de investigación registradas en el departamento");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);
		panelLineas.add(encabezado, BorderLayout.NORTH);

		crearTablaLineasInvestigacion();

		panelLineas.add(panelBotonesCRUDLineas, BorderLayout.SOUTH);
		panelLineas.revalidate();
		panelLineas.repaint();
	}

	private void crearTablaResultados() {

		resultadosEnTabla.clear();

		String[] columnas = {"Nombre", "Tipo", "Investigador", "Línea de investigación"};

		modeloTablaResultados = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for(LineaInvestigacion l: dptoActual.getLineasInvestigacion()){
			for(Investigador i: l.getInvestigadores()){
				for(ResultadoInvestigativo r: i.getResultados()){

					String nombre = r.getNombrePublicacion();
					String tipo = r.getTipo();
					Investigador inv = i;
					LineaInvestigacion linea = l;

					modeloTablaResultados.addRow(new Object[]{nombre, tipo, inv.getNombre() + " " + inv.getApellidos(), linea.getNombre()});
					resultadosEnTabla.add(r);
				}

			}
		}


		tablaResultados = new JTable(modeloTablaResultados);
		tablaResultados.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tablaResultados.setRowHeight(30);

		tablaResultados.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tablaResultados.getTableHeader().setBackground(COLOR_HEADER_BACKGROUND);
		tablaResultados.getTableHeader().setForeground(Color.WHITE);
		tablaResultados.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaResultados.getColumnCount(); i++) {
			tablaResultados.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(200);
		tablaResultados.getColumnModel().getColumn(1).setPreferredWidth(120);
		tablaResultados.getColumnModel().getColumn(2).setPreferredWidth(180);
		tablaResultados.getColumnModel().getColumn(3).setPreferredWidth(200);

		scrollTablaResultados = new JScrollPane(tablaResultados);
		panelResultados.add(scrollTablaResultados, BorderLayout.CENTER);
	}

	public void actualizarTablaResultados() {
		panelResultados.removeAll();

		JPanel encabezado = new JPanel();
		encabezado.setBackground(COLOR_HEADER_BACKGROUND);
		encabezado.setPreferredSize(new Dimension(0, 50));

		JLabel lblTitulo = new JLabel("Resultados Investigativos");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);

		panelResultados.add(panelBotonesCRUDResultados, BorderLayout.SOUTH);

		panelResultados.add(encabezado, BorderLayout.NORTH);
		crearTablaResultados();
		panelResultados.revalidate();
		panelResultados.repaint();
	}

	private void configurarPanelesCRUD(){

		configurarPanelCRUDEstudiante();

		configurarPanelCRUDDocente();

		configurarPanelCRUDMaestria();

		configurarPanelCRUDCursos();

		configurarPanelCRUDLineas();

		configurarPanelCRUDResultados();
	}

	private JButton crearBotonCRUD(String texto) {
		final JButton boton = new JButton(texto);
		boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		boton.setBackground(COLOR_DEFAULT);
		boton.setForeground(Color.WHITE);
		boton.setPreferredSize(new Dimension(130, 35));
		boton.setFocusPainted(false);
		boton.setBorderPainted(false);

		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boton.setBackground(COLOR_HOVER);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boton.setBackground(COLOR_DEFAULT);
			}
		});

		return boton;
	}

	private void configurarPanelCRUDEstudiante() {
		panelBotonesCRUDEstudiantes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotonesCRUDEstudiantes.setBackground(Color.DARK_GRAY);

		JButton btnAgregarEst = crearBotonCRUD("Agregar");
		btnAgregarEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				AgregarEstudianteDialog dialog = new AgregarEstudianteDialog(parent, vicedecanato, dptoActual);

				if(dialog.isConfirmado())
					actualizarTodasLasTablas();
			}

		});

		JButton btnEditarEst = crearBotonCRUD("Editar");
		btnEditarEst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				if(tablaEstudiantes.getSelectedRows().length == 1){

					int seleccionado = tablaEstudiantes.getSelectedRow();

					if(seleccionado != -1){

						Estudiante estudiante = estudiantesEnTabla.get(seleccionado);
						EditarEstDialog dialog = new EditarEstDialog(parent,vicedecanato,estudiante);
						dialog.setVisible(true);

						if (dialog.isConfirmado()){

							actualizarTodasLasTablas();
						}
					}else{
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debe seleccionar un estudiante para editar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}
				}
			}
		});

		JButton btnEliminarEst = crearBotonCRUD("Eliminar");
		btnEliminarEst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				if(tablaEstudiantes.getSelectedRows().length == 1){

					int seleccionado = tablaEstudiantes.getSelectedRow();

					if (seleccionado != -1) {
						Estudiante estudiante = estudiantesEnTabla.get(seleccionado);

						MensajeDialog confirmacion = new MensajeDialog(parent,"¿Está seguro que desea eliminar al estudiante seleccionado?",Tipo.CONFIRMACION);

						confirmacion.setVisible(true);

						if (confirmacion.isConfirmado()) {
							dptoActual.removerEstudiante(estudiante);

							actualizarTodasLasTablas();

							MensajeDialog mensaje = new MensajeDialog(parent,"Estudiante eliminado correctamente",Tipo.RETROALIMENTACION);
							mensaje.setVisible(true);
						}
					} else {
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar un estudiante para eliminar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}

				}
			}
		});

		panelBotonesCRUDEstudiantes.add(btnAgregarEst);
		panelBotonesCRUDEstudiantes.add(btnEditarEst);
		panelBotonesCRUDEstudiantes.add(btnEliminarEst);

		panelEstudiantes.add(panelBotonesCRUDEstudiantes, BorderLayout.SOUTH);
	}

	private void configurarPanelCRUDDocente(){

		panelBotonesCRUDDocentes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotonesCRUDDocentes.setBackground(Color.DARK_GRAY);

		JButton btnaAgregarDoc = crearBotonCRUD("Agregar");
		btnaAgregarDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				AgregarDocenteDialog dialog = new AgregarDocenteDialog(parent, vicedecanato, dptoActual);

				if(dialog.isConfirmado())
					actualizarTablaDoc();
			}

		});

		JButton btnEditarDoc = crearBotonCRUD("Editar");
		btnEditarDoc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				if(tablaDocentes.getSelectedRows().length == 1){
					int seleccionado = tablaDocentes.getSelectedRow();

					if(seleccionado != -1){
						Docente docente = docentesEnTabla.get(seleccionado);
						EditarDocDialog dialog = new EditarDocDialog(parent, vicedecanato, docente);
						dialog.setVisible(true);

						if (dialog.isConfirmado()){

							actualizarTablaDoc();

						}
					}else{
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar un docente para editar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}
				}
			}
		});

		JButton btnEliminarDoc = crearBotonCRUD("Eliminar");
		btnEliminarDoc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				if(tablaDocentes.getSelectedRows().length == 1){
					int seleccionado = tablaDocentes.getSelectedRow();

					if (seleccionado != -1) {

						Docente docente = docentesEnTabla.get(seleccionado);

						MensajeDialog confirmacion = new MensajeDialog(parent,"¿Estás seguro que deseas eliminar a"+ " " + docente.getNombre() + "?",Tipo.CONFIRMACION);

						confirmacion.setVisible(true);

						if (confirmacion.isConfirmado()) {
							dptoActual.removerDocente(docente);

							actualizarTablaDoc();

							MensajeDialog mensaje = new MensajeDialog(parent,"Docente eliminado correctamente",Tipo.RETROALIMENTACION);
							mensaje.setVisible(true);
						}
					} else {
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar un docente para eliminar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}
				}
			}
		});

		panelBotonesCRUDDocentes.add(btnaAgregarDoc);
		panelBotonesCRUDDocentes.add(btnEditarDoc);
		panelBotonesCRUDDocentes.add(btnEliminarDoc);

		panelDocentes.add(panelBotonesCRUDDocentes, BorderLayout.SOUTH);
	}

	private void configurarPanelCRUDMaestria(){

		panelBotonesCRUDMaestria = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		panelBotonesCRUDMaestria.setBackground(Color.DARK_GRAY);

		JButton btnCrearMaestria = crearBotonCRUD("Crear");
		btnCrearMaestria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				CrearMaestriaDialog dialog = new CrearMaestriaDialog(parent, dptoActual);
				dialog.setVisible(true);

				if(dialog.isConfirmado())
					actualizarTodasLasTablas();
			}

		});

		JButton btnEditarMaestria = crearBotonCRUD("Editar");
		btnEditarMaestria.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int seleccionado = listaMaestrias.getSelectedIndex();

				if(seleccionado != -1){
					EditarMaestriaDialog dialog = new EditarMaestriaDialog(parent, dptoActual);
					dialog.setVisible(true);

					if (dialog.isConfirmado()){
						String nuevoNombre = dialog.getNombre();
						String campoEstudio = dialog.getCampoEstudio();
						int duracionMeses = dialog.getDuracionMeses();


						int indexMaestria = listaMaestrias.getSelectedIndex();
						Maestria maestria = (Maestria) modeloMaestrias.get(indexMaestria);

						maestria.setNombre(nuevoNombre);
						maestria.setDuracionMeses(duracionMeses);
						maestria.setCampoEstudio(campoEstudio);
						dptoActual.agregarMaestria(maestria);

						modeloMaestrias.set(indexMaestria, maestria);

						actualizarTodasLasTablas();

					}
				}else{
					MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar una maestria para editar",Tipo.RETROALIMENTACION);
					mensajeRetroalimentacion.setVisible(true);
				}
			}
		});

		JButton btnEliminarMaestria = crearBotonCRUD("Eliminar");
		btnEliminarMaestria.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int seleccionado = listaMaestrias.getSelectedIndex();

				if (seleccionado != -1) {
					Maestria maestria = (Maestria) modeloMaestrias.getElementAt(seleccionado);

					MensajeDialog confirmacion = new MensajeDialog(parent,"¿Estás seguro que deseas eliminar a:"+ " " + maestria.getNombre() + "?",Tipo.CONFIRMACION);

					confirmacion.setVisible(true);

					if (confirmacion.isConfirmado()) {
						dptoActual.removerMaestria(maestria);

						modeloMaestrias.remove(seleccionado);

						actualizarTodasLasTablas();

						MensajeDialog mensaje = new MensajeDialog(parent,"Maestría eliminada correctamente",Tipo.RETROALIMENTACION);
						mensaje.setVisible(true);
					}
				} else {
					MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar una maestría para eliminar",Tipo.RETROALIMENTACION);
					mensajeRetroalimentacion.setVisible(true);
				}
			}
		});

		JButton btnMatricular = crearBotonCRUD("Matricular");
		btnMatricular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {


			}
		});

		JButton btnBaja = crearBotonCRUD("Dar baja");
		btnBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {


			}
		});

		panelBotonesCRUDMaestria.add(btnCrearMaestria);
		panelBotonesCRUDMaestria.add(btnEditarMaestria);
		panelBotonesCRUDMaestria.add(btnEliminarMaestria);
		panelBotonesCRUDMaestria.add(btnMatricular);
		panelBotonesCRUDMaestria.add(btnBaja);

		panelMaestrias.add(panelBotonesCRUDMaestria, BorderLayout.SOUTH);
	}

	private void configurarPanelCRUDCursos() {
		panelBotonesCRUDCursos = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotonesCRUDCursos.setBackground(Color.DARK_GRAY);

		JButton btnCrearCurso = crearBotonCRUD("Crear");
		btnCrearCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton btnEditarCurso = crearBotonCRUD("Editar");
		btnEditarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton btnEliminarCurso = crearBotonCRUD("Eliminar");
		btnEliminarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton btnNota = crearBotonCRUD("Dar Nota");
		btnNota.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {


			}
		});

		panelBotonesCRUDCursos.add(btnCrearCurso);
		panelBotonesCRUDCursos.add(btnEditarCurso);
		panelBotonesCRUDCursos.add(btnEliminarCurso);

		panelCursos.add(panelBotonesCRUDCursos, BorderLayout.SOUTH);
	}

	private void configurarPanelCRUDLineas() {
		panelBotonesCRUDLineas = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotonesCRUDLineas.setBackground(Color.DARK_GRAY);

		JButton btnCrearLinea = crearBotonCRUD("Crear");
		btnCrearLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearLineaInvestigacionDialog dialog = new CrearLineaInvestigacionDialog(parent, vicedecanato, dptoActual);
				dialog.setVisible(true);

				if(dialog.isConfirmado())
					actualizarTodasLasTablas();
			}
		});

		JButton btnEditarLinea = crearBotonCRUD("Editar");
		btnEditarLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				if(tablaLineas.getSelectedRows().length == 1){
					int seleccionado = tablaLineas.getSelectedRow();

					if(seleccionado != -1){
						LineaInvestigacion linea = lineasEnTabla.get(seleccionado);
						EditarLineaInvestigacionDialog dialog = new EditarLineaInvestigacionDialog(parent, vicedecanato, dptoActual, linea);
						dialog.setVisible(true);

						if (dialog.isConfirmado()){

							actualizarTablaLineas();

						}
					}else{
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar un docente para editar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}
				}
			}
		});

		JButton btnEliminarLinea = crearBotonCRUD("Eliminar");
		btnEliminarLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablaLineas.getSelectedRows().length == 1){
					int seleccionado = tablaLineas.getSelectedRow();

					if (seleccionado != -1) {

						LineaInvestigacion linea = lineasEnTabla.get(seleccionado);

						MensajeDialog confirmacion = new MensajeDialog(parent,"¿Estás seguro que deseas eliminar "+ " " + linea.getNombre() + "?",Tipo.CONFIRMACION);

						confirmacion.setVisible(true);

						if (confirmacion.isConfirmado()) {
							dptoActual.removerLineaInvestigacion(linea);

							actualizarTablaLineas();

							MensajeDialog mensaje = new MensajeDialog(parent,"Línea eliminada correctamente",Tipo.RETROALIMENTACION);
							mensaje.setVisible(true);
						}
					} else {
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar una línea de investigación para eliminar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}
				}
			}
		});

		panelBotonesCRUDLineas.add(btnCrearLinea);
		panelBotonesCRUDLineas.add(btnEditarLinea);
		panelBotonesCRUDLineas.add(btnEliminarLinea);

		panelLineas.add(panelBotonesCRUDLineas, BorderLayout.SOUTH);
	}

	private void configurarPanelCRUDResultados() {
		panelBotonesCRUDResultados = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotonesCRUDResultados.setBackground(Color.DARK_GRAY);
		panelResultados.add(panelBotonesCRUDResultados, BorderLayout.SOUTH);

		JButton btnCrearResultado = crearBotonCRUD("Crear");
		btnCrearResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SeleccionTipoResultadoDialog seleccionDialog = new SeleccionTipoResultadoDialog(parent, estudiantesEnTabla, docentesEnTabla);
				seleccionDialog.setVisible(true);

				if (seleccionDialog.isConfirmado()) {
					String tipo = seleccionDialog.getTipoSeleccionado();
					Investigador autor = seleccionDialog.getInvestigadorSeleccionado();

					if (tipo.equals("Ponencia de Evento")) {
						CrearPonenciaDialog ponenciaDialog = new CrearPonenciaDialog(parent, autor);
						ponenciaDialog.setVisible(true);
						if (ponenciaDialog.isConfirmado()) {
							actualizarTodasLasTablas();
						}

					} else if (tipo.equals("Artículo")) {
						CrearArticuloDialog articuloDialog = new CrearArticuloDialog(parent, autor);
						articuloDialog.setVisible(true);
						if (articuloDialog.isConfirmado()) {
							actualizarTodasLasTablas();
						}

					} else if (tipo.equals("Capítulo de Libro")) {
						CrearCapituloDialog capituloDialog = new CrearCapituloDialog(parent, autor);
						capituloDialog.setVisible(true);
						if (capituloDialog.isConfirmado()) {
							actualizarTodasLasTablas();
						}
					}


				}
			}
		});


		JButton btnEditarResultado = crearBotonCRUD("Editar");
		btnEditarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaResultados.getSelectedRow();

				if (filaSeleccionada >= 0) {
					ResultadoInvestigativo seleccionado = resultadosEnTabla.get(filaSeleccionada);


					if (seleccionado instanceof Articulo) {
						EditarArticuloDialog dialog = new EditarArticuloDialog(parent, (Articulo) seleccionado);
						dialog.setVisible(true);
						if (dialog.isConfirmado()) {
							actualizarTodasLasTablas();
						}

					} else if (seleccionado instanceof PonenciaEvento) {
						EditarPonenciaDialog dialog = new EditarPonenciaDialog(parent, (PonenciaEvento) seleccionado);
						dialog.setVisible(true);
						if (dialog.isConfirmado()) {
							actualizarTodasLasTablas();
						}

					} else if (seleccionado instanceof CapituloLibro) {
						EditarCapituloDialog dialog = new EditarCapituloDialog(parent, (CapituloLibro) seleccionado);
						dialog.setVisible(true);
						if (dialog.isConfirmado()) {
							actualizarTodasLasTablas();
						}

					} else {
						MensajeDialog m = new MensajeDialog(parent, "Tipo de resultado no reconocido", Tipo.RETROALIMENTACION);
						m.setVisible(true);
					}


				}else{
					MensajeDialog m = new MensajeDialog(parent, "Seleccione un resultado para editar", Tipo.RETROALIMENTACION);
					m.setVisible(true);
				}


			}
		});






		JButton btnEliminarResultado = crearBotonCRUD("Eliminar");
		btnEliminarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if(tablaResultados.getSelectedRows().length == 1){

					int seleccionado = tablaResultados.getSelectedRow();

					if (seleccionado != -1) {
						ResultadoInvestigativo resultado = resultadosEnTabla.get(seleccionado);

						MensajeDialog confirmacion = new MensajeDialog(
								parent,
								"¿Estás seguro que deseas eliminar \"" + resultado.getNombrePublicacion() + "\"?",
								Tipo.CONFIRMACION
								);
						confirmacion.setVisible(true);

						if (confirmacion.isConfirmado()) {

							Investigador autor = dptoActual.buscarInvestigadorDelResultado(resultado);

							if(autor != null){

								autor.removerResultado(resultado);
								resultadosEnTabla.remove(seleccionado);

							}

							actualizarTodasLasTablas();

							MensajeDialog mensaje = new MensajeDialog(
									parent,
									"Resultado eliminado correctamente.",
									Tipo.RETROALIMENTACION
									);
							mensaje.setVisible(true);




						}

					} else {
						MensajeDialog mensaje = new MensajeDialog(
								parent,
								"Debes seleccionar un resultado investigativo para eliminar.",
								Tipo.RETROALIMENTACION
								);
						mensaje.setVisible(true);
					}

				}else{
					MensajeDialog mensaje = new MensajeDialog(
							parent,
							"Debe seleccionar solo un resultado investigativo para eliminar.",
							Tipo.RETROALIMENTACION
							);
					mensaje.setVisible(true);
				}
			}
		});

		panelBotonesCRUDResultados.add(btnCrearResultado);
		panelBotonesCRUDResultados.add(btnEditarResultado);
		panelBotonesCRUDResultados.add(btnEliminarResultado);
	}

	private void actualizarTodasLasTablas(){
		actualizarTablaCursos();
		actualizarTablaDoc();
		actualizarTablaEst();
		actualizarTablaLineas();
		actualizarTablaMaestrias();
		actualizarTablaResultados();
	}
}

