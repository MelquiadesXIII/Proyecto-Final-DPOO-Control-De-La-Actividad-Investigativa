package Interfaz;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Interfaz.MensajeDialog.Tipo;
import Logica.*;

import java.net.URI;
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
	private JPanel panelAyuda;
	private JPanel panelInicio;
	private JList<Departamento> listaDepartamentos;
	private DefaultListModel<Departamento> modeloDepartamentos;
	private JList<Estudiante> listaEstudiantes;
	private DefaultListModel<Estudiante> modeloEstudiantes;
	private ArrayList<JButton> botonesNavegacion;
	private JButton botonSeleccionadoActual;
	private final Color COLOR_DEFAULT = new Color(30, 40, 50);
	private final Color COLOR_HOVER = new Color(50, 60, 70); 
	private final Color COLOR_SELECTED = new Color(70, 80, 90);
	private final Color COLOR_HEADER_BACKGROUND = new Color(45, 55, 65);
	private JPanel panelReportes; 
	private JTabbedPane pestañasReportes;
	private JPanel panelReporte1;
	private JPanel panelReporte2;
	private JPanel panelReporte3;
	private JPanel panelReporte4;
	private JComboBox<Departamento> seleccionarDeptoReporte1 = new JComboBox<>();
	private JComboBox<Maestria> seleccionarMaestriaReporte2 = new JComboBox<>();
	private JComboBox<Departamento> seleccionarDeptoReporte2 = new JComboBox<>();
	private JTable tablaMatriculados;
	private DefaultTableModel modeloTablaMatriculados;
	private JTable tablaRanking;
	private DefaultTableModel modeloTablaRanking;
	private JPanel panelBotonesCRUDDocentes;
	private JPanel panelBotonesCRUDDepartamentos;
	private JPanel panelBotonesCRUDEstudiantes;
	private JComboBox<Departamento> seleccionarDeptoReporte3 = new JComboBox<>();
	private JComboBox<Maestria> seleccionarMaestriaReporte3 = new JComboBox<>();
	private JTable tablaCursos;
	private DefaultTableModel modeloTablaCursos;
	private JTable tablaDocentes;
	private JScrollPane scrollTablaDocentes;
	private DefaultTableModel modeloTablaDocentes;
	private ArrayList<Docente> docentesEnTabla = new ArrayList<>();
	private ArrayList<Estudiante> estudiantesEnTabla = new ArrayList<>();
	private JTable tablaEstudiantes;
	private JScrollPane scrollTablaEstudiantes;
	private DefaultTableModel modeloTablaEstudiantes;
	private ArrayList<Departamento> departamentosEnTabla = new ArrayList<>();
	private JTable tablaDepartamentos;
	private JScrollPane scrollTablaDepartamentos;
	private DefaultTableModel modeloTablaDepartamentos;

	public VentanaPrincipal(Vicedecanato vicedecanato){

		this.vicedecanato = vicedecanato;
		inicializarConfiguracionUI();
		crearPanelPrincipal();
		configurarPanelNavegacion();

		if (this.botonInicio != null) {
			actualizarAparienciaBotones(this.botonInicio);
		}

		crearPaneles();
		crearPanelesReportes();
		crearTablaDocentes();
		crearTablaDepartamentos();
		crearTablaEstudiantes();
		configurarPanelesCRUD();

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

		botonDepartamentos = crearBotonNavegacion("Departamentos");
		botonDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelDepartamentos");
				actualizarAparienciaBotones(botonDepartamentos);
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

		botonReportes = crearBotonNavegacion("Reportes");
		botonReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelReportes");
				actualizarAparienciaBotones(botonReportes);
			}
		});

		botonAyuda = crearBotonNavegacion("Ayuda");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
				cl.show(panelPrincipal, "panelAyuda");
				actualizarAparienciaBotones(botonAyuda);
			}
		});

		botonSalir = crearBotonNavegacion("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarAparienciaBotones(botonSalir);
				MensajeDialog dialog = new MensajeDialog(VentanaPrincipal.this, "¿Desea salir de la aplicación?", Tipo.CONFIRMACION);
				dialog.setVisible(true);

				if (dialog.isConfirmado()) {
					System.exit(0);
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
		panelInicio.setBackground(Color.DARK_GRAY);

		panelDocentes = crearPanelesConEncabezado("Docentes registrados en el vicedecanato:");
		panelPrincipal.add(panelDocentes, "panelDocentes");
		panelDocentes.setBackground(Color.DARK_GRAY);

		panelEstudiantes = crearPanelesConEncabezado("Estudiantes registrados en el vicedecanato:");
		panelPrincipal.add(panelEstudiantes, "panelEstudiantes");
		panelEstudiantes.setBackground(Color.DARK_GRAY);

		panelDepartamentos = crearPanelesConEncabezado("Departamentos registrados en el vicedecanato:");
		panelPrincipal.add(panelDepartamentos, "panelDepartamentos");
		panelDepartamentos.setBackground(Color.DARK_GRAY);

		panelReportes = crearPanelesConEncabezado("Listado de reportes");
		panelPrincipal.add(panelReportes, "panelReportes");
		panelReportes.setBackground(Color.DARK_GRAY);

		panelAyuda = crearPanelesConEncabezado("¿Necesitas Ayuda? Contáctanos");
		panelPrincipal.add(panelAyuda, "panelAyuda");
		panelAyuda.setBackground(Color.DARK_GRAY);

		JLabel lblBienvenida = new JLabel("<html>" +
				"<div style='text-align: center; font-family: Segoe UI;'>" +
				"<h1>Sistema Integral de Gestión Investigativa y de Posgrado</h1>" +
				"<p><b>Facultad de Ingeniería Informática" +
				"<hr>" +
				"<p style='text-align: left;'>" +
				"Plataforma oficial del <b>Vicedecanato de Investigaciones y Posgrado</b> para:<br><br>" +
				"• Registrar y monitorear <b>líneas de investigación</b>.<br>" +
				"• Gestionar <b>resultados científicos</b> (artículos, capítulos, ponencias).<br>" +
				"• Administrar <b>cursos de posgrado</b> (impartidos, recibidos, créditos).<br>" +
				"• Acompañar el progreso en <b>maestrías</b> (matrículas, defensas).<br><br>" +
				"<i>Optimice la toma de decisiones con reportes automatizados.</i>" +
				"</p>" +
				"</div>" +
				"</html>");
		lblBienvenida.setBounds(0, 0, 794, 465);
		lblBienvenida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblBienvenida.setForeground(Color.WHITE);
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicio.add(lblBienvenida);

		JLabel lblInfo = new JLabel(
				"<html>" +
						"<div style='text-align: center; font-family: Segoe UI;'>" +
						"<h2 style='color: #2E86C1;'>Soporte y Contacto</h2>" +
						"<hr>" +
						"<p style='text-align: left;'>" +
						"<b>Para soporte técnico o más información, contacte a:</b><br><br>" +
						"• <b>Desarrollador 1:</b> liancarlos365@gmail.com<br>" +
						"• <b>Desarrollador 2:</b> llerandimarlon05@gmail.com<br><br>" +
						"<b>Repositorio del proyecto:</b><br>" +
						"<span style='color: #3498DB; text-decoration: underline; cursor: pointer;'>" +
						"https://github.com/MelquiadesXIII/Proyecto-Final-DPOO-Control-De-La-Actividad-Investigativa.git" +
						"</span>" +
						"</p>" +
						"<hr>" +
						"<p style='font-size: 10px; color: #7F8C8D;'>Versión 1.0 - Junio 2025</p>" +
						"</div>" +
						"</html>"
				);

		lblInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (e.getClickCount() == 1) { 
						Desktop.getDesktop().browse(new URI("https://github.com/MelquiadesXIII/Proyecto-Final-DPOO-Control-De-La-Actividad-Investigativa.git"));
					}
				} catch (Exception ex) {
					new MensajeDialog(VentanaPrincipal.this, "Error al abrir el enlace.", Tipo.RETROALIMENTACION);
				}
			}
		});

		lblInfo.setBounds(0, 0, 794, 465);
		lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		panelAyuda.add(lblInfo, BorderLayout.CENTER);


	}

	private void crearTablaDepartamentos() {
		departamentosEnTabla.clear();

		// Definir columnas con los nuevos campos requeridos
		String[] columnas = {
				"Nombre del departamento", 
				"Cant. Docentes", 
				"Cant. Estudiantes", 
				"Cant. Líneas Inv.", 
				"Cant. Maestrías"
		};

		modeloTablaDepartamentos = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Departamento departamento : vicedecanato.getDepartamentos()) {
			Object[] fila = {
					departamento.getNombre(),
					departamento.getDocentes().size(),
					departamento.getEstudiantes().size(),
					departamento.getLineasInvestigacion().size(),
					departamento.getMaestrias().size()
			};

			departamentosEnTabla.add(departamento);
			modeloTablaDepartamentos.addRow(fila);
		}

		tablaDepartamentos = new JTable(modeloTablaDepartamentos);

		// Aplicar mismo estilo que tabla docentes
		tablaDepartamentos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tablaDepartamentos.setRowHeight(30);
		tablaDepartamentos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tablaDepartamentos.getTableHeader().setBackground(COLOR_HEADER_BACKGROUND);
		tablaDepartamentos.getTableHeader().setForeground(Color.WHITE);

		// Centrar contenido en todas las celdas
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaDepartamentos.getColumnCount(); i++) {
			tablaDepartamentos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		// Ajustar anchos de columnas (optimizado para los nuevos datos)
		tablaDepartamentos.getColumnModel().getColumn(0).setPreferredWidth(250);  // Nombre
		tablaDepartamentos.getColumnModel().getColumn(1).setPreferredWidth(100);  // Docentes
		tablaDepartamentos.getColumnModel().getColumn(2).setPreferredWidth(100);  // Estudiantes
		tablaDepartamentos.getColumnModel().getColumn(3).setPreferredWidth(100);  // Líneas Inv.
		tablaDepartamentos.getColumnModel().getColumn(4).setPreferredWidth(100);  // Maestrías

		scrollTablaDepartamentos = new JScrollPane(tablaDepartamentos);
		scrollTablaDepartamentos.setBorder(BorderFactory.createEmptyBorder());

		panelDepartamentos.add(scrollTablaDepartamentos, BorderLayout.CENTER);
	}

	public void actualizarTablaDep() {
		panelDepartamentos.removeAll();

		// Crear encabezado con mismo estilo que docentes
		JPanel encabezado = new JPanel();
		encabezado.setBackground(COLOR_HEADER_BACKGROUND);
		encabezado.setPreferredSize(new Dimension(0, 50));
		JLabel lblTitulo = new JLabel("Departamentos registrados en el vicedecanato:");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);
		panelDepartamentos.add(encabezado, BorderLayout.NORTH);

		// Reconstruir la tabla
		crearTablaDepartamentos();

		// Agregar botones CRUD si existen
		panelDepartamentos.add(panelBotonesCRUDDepartamentos, BorderLayout.SOUTH);

		panelDepartamentos.revalidate();
		panelDepartamentos.repaint();
	}

	private void crearTablaEstudiantes(){

		estudiantesEnTabla.clear();

		String[] columnas = {"Nombre y apellidos", "Grupo", "Departamento"};

		modeloTablaEstudiantes = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Estudiante estudiante : vicedecanato.getEstudiantes()) {
			Departamento departamento = vicedecanato.obtenerDepartamentoDeUnEstudiante(estudiante); 
			String nombreDepartamento = (departamento != null) ? departamento.getNombre() : "Sin departamento";

			Object[] fila = {
					estudiante.getNombre() + " " + estudiante.getApellidos(), 
					estudiante.getGrupo(),
					nombreDepartamento 
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
		JLabel lblTitulo = new JLabel("Estudiantes registrados en el vicedecanato:");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);
		panelEstudiantes.add(encabezado, BorderLayout.NORTH);

		crearTablaEstudiantes();  

		panelEstudiantes.add(panelBotonesCRUDEstudiantes, BorderLayout.SOUTH);
		panelEstudiantes.revalidate();
		panelEstudiantes.repaint();
	}

	private void crearTablaDocentes(){

		docentesEnTabla.clear();

		String[] columnas = {"Nombre y apellidos", "Categoría Científica", "Categoría Docente", "Departamento"};

		modeloTablaDocentes = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Docente docente : vicedecanato.getDocentes()) {
			Departamento departamento = vicedecanato.obtenerDepartamentoDeUnDocente(docente);
			String nombreDepartamento = (departamento != null) ? departamento.getNombre() : "Sin departamento";

			Object[] fila = {
					docente.getNombre() + " " + docente.getApellidos(),
					docente.getCatCientifica().getCategoria(),
					docente.getCatDocente().getCategoria(),
					nombreDepartamento
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

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaDocentes.getColumnCount(); i++) {
			tablaDocentes.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		tablaDocentes.getColumnModel().getColumn(0).setPreferredWidth(200);
		tablaDocentes.getColumnModel().getColumn(1).setPreferredWidth(150);
		tablaDocentes.getColumnModel().getColumn(2).setPreferredWidth(150);
		tablaDocentes.getColumnModel().getColumn(3).setPreferredWidth(200);

		scrollTablaDocentes = new JScrollPane(tablaDocentes);
		scrollTablaDocentes.setBorder(BorderFactory.createEmptyBorder());

		panelDocentes.add(scrollTablaDocentes, BorderLayout.CENTER);

	}

	public void actualizarTablaDoc() {

		panelDocentes.removeAll();

		JPanel encabezado = new JPanel();
		encabezado.setBackground(COLOR_HEADER_BACKGROUND);
		encabezado.setPreferredSize(new Dimension(0, 50));
		JLabel lblTitulo = new JLabel("Docentes registrados en el vicedecanato:");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		encabezado.add(lblTitulo);
		panelDocentes.add(encabezado, BorderLayout.NORTH);

		crearTablaDocentes();

		panelDocentes.add(panelBotonesCRUDDocentes, BorderLayout.SOUTH);

		panelDocentes.revalidate();
		panelDocentes.repaint();
	}

	private void configurarPanelesCRUD(){

		configurarPanelCRUDEstudiante();

		configurarPanelCRUDDocente();

		configurarPanelCRUDDepartamento();
	}

	private JButton crearBotonCRUD(String texto) {
		final JButton boton = new JButton(texto);
		boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		boton.setBackground(COLOR_DEFAULT);
		boton.setForeground(Color.WHITE);
		boton.setPreferredSize(new Dimension(120, 35));
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

		JButton btnCrearEst = crearBotonCRUD("Crear");
		btnCrearEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				CrearEstDialog dialog = new CrearEstDialog(VentanaPrincipal.this, vicedecanato);
				dialog.setVisible(true);

				if(dialog.isConfirmado())
					actualizarTablaEst();
			}

		});

		JButton btnEditarEst = crearBotonCRUD("Editar");
		btnEditarEst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				if(tablaEstudiantes.getSelectedRows().length == 1){

					int seleccionado = tablaEstudiantes.getSelectedRow();

					if(seleccionado != -1){

						Estudiante estudiante = estudiantesEnTabla.get(seleccionado);
						EditarEstDialog dialog = new EditarEstDialog(VentanaPrincipal.this,vicedecanato,estudiante);
						dialog.setVisible(true);

						if (dialog.isConfirmado()){

							actualizarTablaEst();
						}
					}else{
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(VentanaPrincipal.this,"Debes seleccionar un estudiante para editar",Tipo.RETROALIMENTACION);
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

						MensajeDialog confirmacion = new MensajeDialog(VentanaPrincipal.this,"¿Estás seguro que deseas eliminar a"+ " " + estudiante.getNombre() + "?",Tipo.CONFIRMACION);

						confirmacion.setVisible(true);

						if (confirmacion.isConfirmado()) {
							vicedecanato.removerEstudiante(estudiante);

							actualizarTablaEst();

							MensajeDialog mensaje = new MensajeDialog(VentanaPrincipal.this,"Estudiante eliminado correctamente",Tipo.RETROALIMENTACION);
							mensaje.setVisible(true);
						}
					} else {
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(VentanaPrincipal.this,"Debes seleccionar un estudiante para eliminar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}

				}
			}
		});

		panelBotonesCRUDEstudiantes.add(btnCrearEst);
		panelBotonesCRUDEstudiantes.add(btnEditarEst);
		panelBotonesCRUDEstudiantes.add(btnEliminarEst);

		panelEstudiantes.add(panelBotonesCRUDEstudiantes, BorderLayout.SOUTH);
	}

	private void configurarPanelCRUDDocente(){

		panelBotonesCRUDDocentes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotonesCRUDDocentes.setBackground(Color.DARK_GRAY);

		JButton btnCrearDoc = crearBotonCRUD("Crear");
		btnCrearDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				CrearDocDialog dialog = new CrearDocDialog(VentanaPrincipal.this, vicedecanato);
				dialog.setVisible(true);

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
						EditarDocDialog dialog = new EditarDocDialog(VentanaPrincipal.this, vicedecanato, docente);
						dialog.setVisible(true);

						if (dialog.isConfirmado()){

							actualizarTablaDoc();

						}
					}else{
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(VentanaPrincipal.this,"Debes seleccionar un docente para editar",Tipo.RETROALIMENTACION);
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

						MensajeDialog confirmacion = new MensajeDialog(VentanaPrincipal.this,"¿Estás seguro que deseas eliminar a"+ " " + docente.getNombre() + "?",Tipo.CONFIRMACION);

						confirmacion.setVisible(true);

						if (confirmacion.isConfirmado()) {
							vicedecanato.removerDocente(docente);

							actualizarTablaDoc();

							MensajeDialog mensaje = new MensajeDialog(VentanaPrincipal.this,"Docente eliminado correctamente",Tipo.RETROALIMENTACION);
							mensaje.setVisible(true);
						}
					} else {
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(VentanaPrincipal.this,"Debes seleccionar un docente para eliminar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}
				}
			}
		});

		panelBotonesCRUDDocentes.add(btnCrearDoc);
		panelBotonesCRUDDocentes.add(btnEditarDoc);
		panelBotonesCRUDDocentes.add(btnEliminarDoc);

		panelDocentes.add(panelBotonesCRUDDocentes, BorderLayout.SOUTH);
	}

	private void configurarPanelCRUDDepartamento(){

		panelBotonesCRUDDepartamentos = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotonesCRUDDepartamentos.setBackground(Color.DARK_GRAY);

		JButton btnCrearDep = crearBotonCRUD("Crear");
		btnCrearDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				CrearDepDialog dialog = new CrearDepDialog(VentanaPrincipal.this, vicedecanato);
				dialog.setVisible(true);

				if(dialog.isConfirmado())
					actualizarTablaDep();
			}

		});

		JButton btnEditarDep = crearBotonCRUD("Editar");
		btnEditarDep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				if(tablaDepartamentos.getSelectedRows().length == 1){

					int seleccionado = tablaDepartamentos.getSelectedRow();

					if(seleccionado != -1){
						Departamento departamento = departamentosEnTabla.get(seleccionado);

						EditarDepDialog dialog = new EditarDepDialog(VentanaPrincipal.this,vicedecanato,departamento);
						dialog.setVisible(true);

						if (dialog.isConfirmado()){

							actualizarTablaDep();
						}
					}else{
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(VentanaPrincipal.this,"Debes seleccionar un docente para editar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}

				}
			}
		});
		JButton btnEliminarDep = crearBotonCRUD("Eliminar");
		btnEliminarDep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				if(tablaDepartamentos.getSelectedRows().length == 1){
					int seleccionado = tablaDepartamentos.getSelectedRow();

					if (seleccionado != -1) {
						Departamento departamento = departamentosEnTabla.get(seleccionado);

						MensajeDialog confirmacion = new MensajeDialog(VentanaPrincipal.this,"¿Estás seguro que deseas eliminar el departamento:"+ " " + departamento.getNombre() + "?",Tipo.CONFIRMACION);

						confirmacion.setVisible(true);

						if (confirmacion.isConfirmado()) {
							vicedecanato.removerDepartamento(departamento);

							actualizarTablaDep();
							
							MensajeDialog mensaje = new MensajeDialog(VentanaPrincipal.this,"Departamento eliminado correctamente",Tipo.RETROALIMENTACION);
							mensaje.setVisible(true);
						}
					} else {
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(VentanaPrincipal.this,"Debes seleccionar un departamento para eliminar",Tipo.RETROALIMENTACION);
						mensajeRetroalimentacion.setVisible(true);
					}
				}
			}
		});

		panelBotonesCRUDDepartamentos.add(btnCrearDep);
		panelBotonesCRUDDepartamentos.add(btnEditarDep);
		panelBotonesCRUDDepartamentos.add(btnEliminarDep);

		panelDepartamentos.add(panelBotonesCRUDDepartamentos, BorderLayout.SOUTH);
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

	private void crearPanelesReportes(){
		pestañasReportes = new JTabbedPane();
		pestañasReportes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pestañasReportes.setTabPlacement(JTabbedPane.TOP);
		panelReportes.add(pestañasReportes, BorderLayout.CENTER);

		panelReporte1 = new JPanel();
		panelReporte1.setBackground(Color.LIGHT_GRAY);
		panelReporte1.setLayout(new BorderLayout());
		pestañasReportes.addTab("Ranking de los investigadores", panelReporte1);
		mostrarReporte1();

		panelReporte2 = new JPanel();
		panelReporte2.setBackground(Color.LIGHT_GRAY);
		panelReporte2.setLayout(new BorderLayout());
		pestañasReportes.addTab("Estado de los matriculados", panelReporte2);
		mostrarReporte2();

		panelReporte3 = new JPanel();
		panelReporte3.setBackground(Color.LIGHT_GRAY);
		panelReporte3.setLayout(new BorderLayout());
		pestañasReportes.addTab("Plan de estudios de la maestría", panelReporte3);
		mostrarReporte3();

		panelReporte4 = new JPanel();
		panelReporte4.setBackground(Color.LIGHT_GRAY);
		panelReporte4.setLayout(new BorderLayout());
		pestañasReportes.addTab("Producción científica", panelReporte4);

		for (int i = 0; i < 4; i++) {
			JLabel label = new JLabel(pestañasReportes.getTitleAt(i), SwingConstants.CENTER);
			label.setPreferredSize(new Dimension(183, 30));
			pestañasReportes.setTabComponentAt(i, label);
		}
	}

	private void mostrarReporte2(){

		JPanel panelFiltros = new JPanel();
		panelFiltros.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		panelFiltros.setBackground(Color.LIGHT_GRAY);

		Departamento verSeleccionarDepto = new Departamento("Seleccionar");
		final Maestria verSeleccionarMaestria = new Maestria("Seleccionar", 1, "ninguno");

		String[] columnas = {"Nombre y apellidos", "Créditos Acumulados", "Listo para defender maestría"};
		modeloTablaMatriculados = new DefaultTableModel(columnas, 0){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaMatriculados = new JTable(modeloTablaMatriculados);
		tablaMatriculados.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		tablaMatriculados.setRowHeight(25);
		JTableHeader header = tablaMatriculados.getTableHeader();
		header.setFont(new Font("Segoe UI", Font.BOLD, 16)); 
		header.setBackground(new Color(230, 230, 230));      
		header.setForeground(Color.BLACK);

		DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0; i < tablaMatriculados.getColumnCount(); i++){
			tablaMatriculados.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		JScrollPane scrollTabla = new JScrollPane(tablaMatriculados);
		scrollTabla.setPreferredSize(new Dimension(800, 400));
		panelReporte2.add(scrollTabla, BorderLayout.CENTER);


		seleccionarDeptoReporte2.addItem(verSeleccionarDepto);
		for (Departamento d : vicedecanato.getDepartamentos()) {
			seleccionarDeptoReporte2.addItem(d);
		}

		seleccionarMaestriaReporte2.addItem(verSeleccionarMaestria);

		seleccionarDeptoReporte2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Departamento deptoSeleccionado = (Departamento) seleccionarDeptoReporte2.getSelectedItem();
				if (deptoSeleccionado != null) {

					seleccionarMaestriaReporte2.removeAllItems();
					seleccionarMaestriaReporte2.addItem(verSeleccionarMaestria);

					for (Maestria m : deptoSeleccionado.getMaestrias()) {
						seleccionarMaestriaReporte2.addItem(m);
					}

					actualizarTablaMatriculados();
				}
			}
		});

		seleccionarMaestriaReporte2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarTablaMatriculados();
			}
		});


		panelFiltros.add(new JLabel("Departamento:"));
		panelFiltros.add(seleccionarDeptoReporte2);
		panelFiltros.add(new JLabel("Maestría:"));
		panelFiltros.add(seleccionarMaestriaReporte2);

		panelReporte2.add(panelFiltros, BorderLayout.NORTH);

		if (!vicedecanato.getDepartamentos().isEmpty()) {
			seleccionarMaestriaReporte2.setSelectedIndex(0);
			actualizarTablaMatriculados();
		}
	}

	private void actualizarTablaMatriculados() {
		modeloTablaMatriculados.setRowCount(0); 

		Maestria maestriaSeleccionada = (Maestria) seleccionarMaestriaReporte2.getSelectedItem();
		if (maestriaSeleccionada != null) {

			for (Docente d : maestriaSeleccionada.getMatriculados()) {
				String condicion =  vicedecanato.darVistoBuenoMaestria(maestriaSeleccionada, d) ? "Si" : "No";
				Object[] fila = {
						d.getNombre() + " " + d.getApellidos(),
						d.getCreditosObtenidosCursosRecibidos(),
						condicion
				};
				modeloTablaMatriculados.addRow(fila);
			}
		}
	}

	private void mostrarReporte1(){

		JPanel panelFiltros = new JPanel();
		panelFiltros.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		panelFiltros.setBackground(Color.LIGHT_GRAY);

		Departamento verSeleccionarDepto = new Departamento("Seleccionar");
		seleccionarDeptoReporte1.addItem(verSeleccionarDepto);

		for (Departamento d : vicedecanato.getDepartamentos()) {
			seleccionarDeptoReporte1.addItem(d);
		}

		final ArrayList<Investigador> ranking = new ArrayList<Investigador>();
		seleccionarDeptoReporte1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Departamento deptoSeleccionado = (Departamento) seleccionarDeptoReporte1.getSelectedItem();
				if (deptoSeleccionado != null) {

					actualizarTablaRanking(ranking);
				}
			}
		});

		String[] columnas = {"Lugar", "Nombre y apellidos", "Puntaje"};
		modeloTablaRanking = new DefaultTableModel(columnas, 0){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaRanking = new JTable(modeloTablaRanking);
		tablaRanking.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		tablaRanking.setRowHeight(25);
		JTableHeader header = tablaRanking.getTableHeader();
		header.setFont(new Font("Segoe UI", Font.BOLD, 16)); 
		header.setBackground(new Color(230, 230, 230));      
		header.setForeground(Color.BLACK);

		DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0; i < tablaRanking.getColumnCount(); i++){
			tablaRanking.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		JScrollPane scrollTabla = new JScrollPane(tablaRanking);
		scrollTabla.setPreferredSize(new Dimension(800, 400));
		panelReporte1.add(scrollTabla, BorderLayout.CENTER);

		panelFiltros.add(new JLabel("Departamento:"));
		panelFiltros.add(seleccionarDeptoReporte1);
		panelReporte1.add(panelFiltros, BorderLayout.NORTH);
	}

	private void actualizarTablaRanking(ArrayList<Investigador> ranking){

		modeloTablaRanking.setRowCount(0);

		Departamento deptoSeleccionado = (Departamento) seleccionarDeptoReporte1.getSelectedItem();

		if(deptoSeleccionado != null){

			vicedecanato.generarDatosReporte1(ranking, deptoSeleccionado);

			int i = 1;
			for(Investigador r: ranking){

				Object[] fila = {
						i,
						r.getNombre() + " " + r.getApellidos(),
						r.calcularPuntajeInvestigativo(),
				};
				modeloTablaRanking.addRow(fila);
				i++;
			}
		}

	}

	private void mostrarReporte3() {
		JPanel panelFiltros = new JPanel();
		panelFiltros.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelFiltros.setBackground(Color.LIGHT_GRAY);

		final Departamento deptoSeleccionar = new Departamento("Seleccionar");
		final Maestria maestriaSeleccionar = new Maestria("Seleccionar", 1, "ninguno");

		String[] columnas = {"Temas de cursos", "Créditos", "Docente Principal", "Ver Objetivos"};
		modeloTablaCursos = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 3;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return (columnIndex == 3) ? JButton.class : Object.class;
			}
		};

		tablaCursos = new JTable(modeloTablaCursos);
		tablaCursos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		tablaCursos.setRowHeight(30);

		JTableHeader header = tablaCursos.getTableHeader();
		header.setFont(new Font("Segoe UI", Font.BOLD, 16));
		header.setBackground(new Color(230, 230, 230));
		header.setForeground(Color.BLACK);

		DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaCursos.getColumnCount(); i++) {
			tablaCursos.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		tablaCursos.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
		tablaCursos.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), this));

		tablaCursos.getColumnModel().getColumn(1).setWidth(80);
		tablaCursos.getColumnModel().getColumn(0).setPreferredWidth(300); 
		tablaCursos.getColumnModel().getColumn(2).setPreferredWidth(200); 
		tablaCursos.getColumnModel().getColumn(3).setPreferredWidth(120);

		JScrollPane scrollTabla = new JScrollPane(tablaCursos);
		scrollTabla.setPreferredSize(new Dimension(800, 400));
		panelReporte3.add(scrollTabla, BorderLayout.CENTER);

		seleccionarDeptoReporte3.addItem(deptoSeleccionar);
		for (Departamento d : vicedecanato.getDepartamentos()) {
			seleccionarDeptoReporte3.addItem(d);
		}

		seleccionarMaestriaReporte3.addItem(maestriaSeleccionar);

		seleccionarDeptoReporte3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Departamento depto = (Departamento) seleccionarDeptoReporte3.getSelectedItem();
				if (depto != null) {

					seleccionarMaestriaReporte3.removeAllItems();
					seleccionarMaestriaReporte3.addItem(maestriaSeleccionar);

					for (Maestria m : depto.getMaestrias()) {
						seleccionarMaestriaReporte3.addItem(m);
					}
					actualizarTablaCursos();
				}
			}
		});

		seleccionarMaestriaReporte3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarTablaCursos();
			}
		});

		panelFiltros.add(new JLabel("Departamento:"));
		panelFiltros.add(seleccionarDeptoReporte3);
		panelFiltros.add(new JLabel("Maestría:"));
		panelFiltros.add(seleccionarMaestriaReporte3);

		panelReporte3.add(panelFiltros, BorderLayout.NORTH);

		if (!vicedecanato.getDepartamentos().isEmpty()) {
			seleccionarMaestriaReporte3.setSelectedIndex(0);
			actualizarTablaCursos();
		}
	}



	void mostrarObjetivosCurso(int row) {
		Maestria maestria = (Maestria) seleccionarMaestriaReporte3.getSelectedItem();
		if (maestria != null && !maestria.getNombre().equals("Seleccionar")) {
			ArrayList<CursoPosgrado> cursos = maestria.getCursos();
			if (row >= 0 && row < cursos.size()) {
				CursoPosgrado curso = cursos.get(row);

				StringBuilder texto = new StringBuilder("Objetivos:\n");
				for (String obj : curso.getObjetivos()) {
					texto.append(obj).append("\n");
				}

				JOptionPane.showMessageDialog(this, texto.toString(), "Objetivos del curso: " + curso.getTema(), JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void actualizarTablaCursos() {
		modeloTablaCursos.setRowCount(0);

		Maestria maestria = (Maestria) seleccionarMaestriaReporte3.getSelectedItem();
		if (maestria != null){

			for (CursoPosgrado curso : maestria.getCursos()) {
				Object[] fila = {
						curso.getTema(),
						curso.getCantCreditos(),
						curso.getProfesor() != null ? curso.getProfesor().getNombre() + " " + curso.getProfesor().getApellidos() : "Sin asignar",
								"Ver Objetivos"
				};
				modeloTablaCursos.addRow(fila);
			}
		}
	}




}
