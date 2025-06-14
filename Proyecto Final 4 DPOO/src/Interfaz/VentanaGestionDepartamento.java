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
import java.util.ArrayList;

import Interfaz.MensajeDialog.Tipo;
import Logica.*;
import Excepciones.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


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
	private JPanel panelInicio;
	private JPanel panelLineas;
	private JPanel panelMaestrias;
	private JPanel panelEstudiantes;
	private JPanel panelDocentes;
	private DefaultListModel<Object> modeloMaestrias;
	private JList<Object> listaMaestrias;
	private DefaultListModel<Object> modeloLineas;
	private JList<Object> listaLineas;
	private JPanel panelBotonesCRUDEstudiantes;
	private JPanel panelBotonesCRUDDocentes;
	private JPanel panelBotonesCRUDMaestria;
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



	public VentanaGestionDepartamento(JFrame parent, final Departamento dptoActual, final Vicedecanato vicedecanato){

		super(parent, "Gesti�n de " + dptoActual.getNombre(), true);
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
		crearTablaDocentes();
		crearTablaEstudiantes();
		crearTablaMaestrias();
		crearTablaLineasInv();
		configurarPanelesCRUD();

		this.parent.setVisible(false);
		setVisible(true);
	}

	private void inicializarConfiguracionUI(){

		setBackground(Color.WHITE);
		setTitle("Sistema Integral de Gesti�n Investigativa y de Posgrado: Ventana de Gesti�n de " + dptoActual.getNombre());
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

		botonMaestrias = crearBotonNavegacion("Maestr�as");
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

		botonLineas = crearBotonNavegacion("Lineas Inv.");
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
				MensajeDialog dialog = new MensajeDialog(parent, "�Desea salir de la ventana actual?", Tipo.CONFIRMACION);
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

		panelDocentes = crearPanelesConEncabezado("Docentes registrados en el departamento:");
		panelPrincipal.add(panelDocentes, "panelDocentes");
		panelDocentes.setBackground(Color.DARK_GRAY);

		panelEstudiantes = crearPanelesConEncabezado("Estudiantes registrados en el departamento:");
		panelPrincipal.add(panelEstudiantes, "panelEstudiantes");
		panelEstudiantes.setBackground(Color.DARK_GRAY);

		panelMaestrias = crearPanelesConEncabezado("Maestr�as registradas en el departamento:");
		panelPrincipal.add(panelMaestrias, "panelMaestrias");
		panelMaestrias.setBackground(Color.DARK_GRAY);
		
		panelCursos = crearPanelesConEncabezado("Cursos de las maestr�as del departamento:");
		panelPrincipal.add(panelCursos, "panelCursos");
		panelMaestrias.setBackground(Color.DARK_GRAY);
		
		panelLineas = crearPanelesConEncabezado("L�neas de investigaci�n registradas en el departamento:");
		panelPrincipal.add(panelLineas, "panelLineas");
		panelLineas.setBackground(Color.DARK_GRAY);
		
		panelResultados = crearPanelesConEncabezado("Resultados investigativos de los investigadores del departamento:");
		panelPrincipal.add(panelResultados, "panelResultados");
		panelMaestrias.setBackground(Color.DARK_GRAY);

		JLabel lblBienvenida = new JLabel("<html>" +
				"<div style='text-align: center; font-family: Segoe UI;'>" +
				"<h1>Sistema Integral de Gesti�n Investigativa y de Posgrado</h1>" +
				"<p><b>Facultad de Ingenier�a Inform�tica" +
				"<hr>" +
				"<p style='text-align: left;'>" +
				"Actualmente se encuentra en la gesti�n del <b>" + dptoActual.getNombre() + " </b> para:<br><br>" +
				"� Registrar y monitorear <b>l�neas de investigaci�n</b>.<br>" +
				"� Gestionar <b>resultados cient�ficos</b> (art�culos, cap�tulos, ponencias).<br>" +
				"� Administrar <b>cursos de posgrado</b> (impartidos, recibidos, cr�ditos).<br>" +
				"� Acompa�ar el progreso en <b>maestr�as</b> (matr�culas, defensas).<br><br>" +
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

		String[] columnas = {"Nombre y apellidos", "Cat. Cient�fica", "Cat. Docente", "Cursos Impartidos", "Cursos Recibidos", "Investigaciones"};

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

	private void crearTablaMaestrias(){

		modeloMaestrias = new DefaultListModel<>();

		for (Maestria m : dptoActual.getMaestrias()) {
			modeloMaestrias.addElement(m);
		}

		listaMaestrias = new JList<>(modeloMaestrias);

		listaMaestrias.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index,boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Maestria) {
					Maestria maestria = (Maestria) value;
					setText(maestria.getNombre());
				}
				return c;
			}
		});

		listaMaestrias.setForeground(Color.WHITE);
		listaMaestrias.setBackground(Color.DARK_GRAY);
		listaMaestrias.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JScrollPane scrollMaestrias = new JScrollPane(listaMaestrias);
		panelMaestrias.add(scrollMaestrias, BorderLayout.CENTER);
	}

	private void crearTablaLineasInv(){

		modeloLineas = new DefaultListModel<>();

		for (LineaInvestigacion l : dptoActual.getLineasInvestigacion()) {
			modeloLineas.addElement(l);
		}

		listaLineas = new JList<>(modeloLineas);

		listaLineas.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index,boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof LineaInvestigacion) {
					LineaInvestigacion linea = (LineaInvestigacion) value;
					setText(linea.getNombre());
				}
				return c;
			}
		});

		listaLineas.setForeground(Color.WHITE);
		listaLineas.setBackground(Color.DARK_GRAY);
		listaLineas.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JScrollPane scrollLineas = new JScrollPane(listaLineas);
		panelLineas.add(scrollLineas, BorderLayout.CENTER);

	}

	private void configurarPanelesCRUD(){

		configurarPanelCRUDEstudiante();

		configurarPanelCRUDDocente();

		configurarPanelCRUDMaestria();
		
		//configurarPanelCRUDCursos();

		/*configurarPanelCRUDLineas();*/
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

		JButton btnAgregarEst = crearBotonCRUD("Agregar");
		btnAgregarEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				
				/*if(dialog.isConfirmado())
					
				actualizarTablaEst();*/
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

							actualizarTablaEst();
						}
					}else{
						MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar un estudiante para editar",Tipo.RETROALIMENTACION);
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

						MensajeDialog confirmacion = new MensajeDialog(parent,"�Est�s seguro que deseas eliminar a"+ " " + estudiante.getNombre() + "?",Tipo.CONFIRMACION);

						confirmacion.setVisible(true);

						if (confirmacion.isConfirmado()) {
							vicedecanato.removerEstudiante(estudiante);

							actualizarTablaEst();

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

						MensajeDialog confirmacion = new MensajeDialog(parent,"�Est�s seguro que deseas eliminar a"+ " " + docente.getNombre() + "?",Tipo.CONFIRMACION);

						confirmacion.setVisible(true);

						if (confirmacion.isConfirmado()) {
							vicedecanato.removerDocente(docente);

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

		panelBotonesCRUDMaestria = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotonesCRUDMaestria.setBackground(Color.DARK_GRAY);

		JButton btnCrearMaestria = crearBotonCRUD("Crear");
		btnCrearMaestria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				CrearMaestriaDialog dialog = new CrearMaestriaDialog(parent, vicedecanato);
				dialog.setVisible(true);

				if(dialog.isConfirmado())
					actualizarTablaMaestrias();
			}

		});

		JButton btnEditarMaestria = crearBotonCRUD("Editar");
		btnEditarMaestria.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int seleccionado = listaMaestrias.getSelectedIndex();

				if(seleccionado != -1){
					EditarMaestriaDialog dialog = new EditarMaestriaDialog(parent,vicedecanato);
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

						actualizarTablaMaestrias();

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

					MensajeDialog confirmacion = new MensajeDialog(parent,"�Est�s seguro que deseas eliminar a:"+ " " + maestria.getNombre() + "?",Tipo.CONFIRMACION);

					confirmacion.setVisible(true);

					if (confirmacion.isConfirmado()) {
						dptoActual.removerMaestria(maestria);

						modeloMaestrias.remove(seleccionado);

						MensajeDialog mensaje = new MensajeDialog(parent,"Maestr�a eliminada correctamente",Tipo.RETROALIMENTACION);
						mensaje.setVisible(true);
					}
				} else {
					MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar una maestr�a para eliminar",Tipo.RETROALIMENTACION);
					mensajeRetroalimentacion.setVisible(true);
				}
			}
		});

		panelBotonesCRUDMaestria.add(btnCrearMaestria);
		panelBotonesCRUDMaestria.add(btnEditarMaestria);
		panelBotonesCRUDMaestria.add(btnEliminarMaestria);

		panelMaestrias.add(panelBotonesCRUDMaestria, BorderLayout.SOUTH);
	}

	public void actualizarTablaMaestrias(){
		modeloMaestrias.clear();

		for (Maestria m: dptoActual.getMaestrias()) {
			modeloMaestrias.addElement(m);
		}
	}

	public void actualizarTablaLineas(){
		modeloLineas.clear();

		for (LineaInvestigacion l : dptoActual.getLineasInvestigacion()) {
			modeloLineas.addElement(l);
		}
	}
}

