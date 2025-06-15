package Interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
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
	private JPanel panelInicio;
	private JPanel panelLineas;
	private JPanel panelMaestrias;
	private JPanel panelEstudiantes;
	private JPanel panelDocentes;
	private DefaultListModel<Object> modeloDocentes;
	private JList<Object> listaDocentes;
	private DefaultListModel<Object> modeloEstudiantes;
	private JList<Object> listaEstudiantes;
	private DefaultListModel<Object> modeloMaestrias;
	private JList<Object> listaMaestrias;
	private DefaultListModel<Object> modeloLineas;
	private JList<Object> listaLineas;
	private JPanel panelBotonesCRUDEstudiantes;
	private JPanel panelBotonesCRUDDocentes;
	private JPanel panelBotonesCRUDMaestria;
	private JButton botonCursos;
	private JButton botonResultados;



	public VentanaGestionDepartamento(JFrame parent, final Departamento dptoActual, final Vicedecanato vicedecanato){

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

		panelMaestrias= crearPanelesConEncabezado("Maestrías registradas en el departamento:");
		panelPrincipal.add(panelMaestrias, "panelMaestrias");
		panelMaestrias.setBackground(Color.DARK_GRAY);

		panelLineas = crearPanelesConEncabezado("Líneas de investigación registradas en el departamento:");
		panelPrincipal.add(panelLineas, "panelLineas");
		panelLineas.setBackground(Color.DARK_GRAY);

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

		modeloDocentes = new DefaultListModel<>();

		for (Docente docente : dptoActual.getDocentes()) {
			modeloDocentes.addElement(docente);
		}

		listaDocentes = new JList<>(modeloDocentes);

		listaDocentes.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index,boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Docente) {
					Docente docente = (Docente) value;
					setText(docente.getNombre() + " " + docente.getApellidos());
				}
				return c;
			}
		});

		listaDocentes.setForeground(Color.WHITE);
		listaDocentes.setBackground(Color.DARK_GRAY);
		listaDocentes.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JScrollPane scrollEstudiantes = new JScrollPane(listaDocentes);
		panelDocentes.add(scrollEstudiantes, BorderLayout.CENTER);
	}

	private void crearTablaEstudiantes(){

		modeloEstudiantes = new DefaultListModel<>();

		for (Estudiante estudiante : dptoActual.getEstudiantes()) {
			modeloEstudiantes.addElement(estudiante);
		}

		listaEstudiantes = new JList<>(modeloEstudiantes);

		listaEstudiantes.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index,boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Estudiante) {
					Estudiante estudiante = (Estudiante) value;
					setText(estudiante.getNombre() + " " + estudiante.getApellidos());
				}
				return c;
			}
		});

		listaEstudiantes.setForeground(Color.WHITE);
		listaEstudiantes.setBackground(Color.DARK_GRAY);
		listaEstudiantes.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JScrollPane scrollEstudiantes = new JScrollPane(listaEstudiantes);
		panelEstudiantes.add(scrollEstudiantes, BorderLayout.CENTER);
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

				actualizarTablaEst();
			}

		});

		JButton btnEditarEst = crearBotonCRUD("Editar");
		btnEditarEst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int seleccionado = listaEstudiantes.getSelectedIndex();

				if(seleccionado != -1){
					EditarEstDialog dialog = new EditarEstDialog(parent,vicedecanato);
					dialog.setVisible(true);

					if (dialog.isConfirmado()){
						String nuevoNombre = dialog.getNombre();
						String nuevosApellidos = dialog.getApellidos();
						String nuevoGrupo = dialog.getGrupo();
						Departamento nuevoDepartamento = (Departamento) dialog.getComboDepartamento().getSelectedItem();

						int estudianteSeleccionado = listaEstudiantes.getSelectedIndex();
						Estudiante estudiante = (Estudiante) modeloEstudiantes.get(estudianteSeleccionado);

						estudiante.setNombre(nuevoNombre);
						estudiante.setApellidos(nuevosApellidos);
						estudiante.setGrupo(nuevoGrupo);
						nuevoDepartamento.agregarEstudiante(estudiante);

						modeloEstudiantes.set(estudianteSeleccionado, estudiante);

					}
				}else{
					MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar un estudiante para editar",Tipo.RETROALIMENTACION);
					mensajeRetroalimentacion.setVisible(true);
				}

			}
		});

		JButton btnEliminarEst = crearBotonCRUD("Eliminar");
		btnEliminarEst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int seleccionado = listaEstudiantes.getSelectedIndex();

				if (seleccionado != -1) {
					Estudiante estudiante = (Estudiante) modeloEstudiantes.getElementAt(seleccionado);

					MensajeDialog confirmacion = new MensajeDialog(parent,"¿Estás seguro que deseas eliminar a:"+ " " + estudiante.getNombre() + "?",Tipo.CONFIRMACION);

					confirmacion.setVisible(true);

					if (confirmacion.isConfirmado()) {
						dptoActual.removerEstudiante(estudiante);

						modeloEstudiantes.remove(seleccionado);

						MensajeDialog mensaje = new MensajeDialog(parent,"Estudiante eliminado correctamente",Tipo.RETROALIMENTACION);
						mensaje.setVisible(true);
					}
				} else {
					MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar un estudiante para eliminar",Tipo.RETROALIMENTACION);
					mensajeRetroalimentacion.setVisible(true);
				}
			}
		});

		panelBotonesCRUDEstudiantes.add(btnAgregarEst);
		panelBotonesCRUDEstudiantes.add(btnEliminarEst);
		panelBotonesCRUDEstudiantes.add(btnEditarEst);

		panelEstudiantes.add(panelBotonesCRUDEstudiantes, BorderLayout.SOUTH);
	}

	private void configurarPanelCRUDDocente(){

		panelBotonesCRUDDocentes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotonesCRUDDocentes.setBackground(Color.DARK_GRAY);

		JButton btnCrearDoc = crearBotonCRUD("Agregar");
		btnCrearDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				AgregarDocenteDialog dialog = new AgregarDocenteDialog(parent, vicedecanato, dptoActual);

				if(dialog.isConfirmado())
					actualizarTablaDoc();
			}

		});

		JButton btnEditarDoc = crearBotonCRUD("Editar");
		btnEditarDoc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int seleccionado = listaDocentes.getSelectedIndex();

				if(seleccionado != -1){
					EditarDocDialog dialog = new EditarDocDialog(parent,vicedecanato);
					dialog.setVisible(true);

					if (dialog.isConfirmado()){
						String nuevoNombre = dialog.getNombre();
						String nuevosApellidos = dialog.getApellidos();
						CategoriaCientifica nuevaCatCientifica = (CategoriaCientifica)dialog.getCatCientifica();
						CategoriaDocente nuevaCatDocente = (CategoriaDocente) dialog.getCatDocente();
						Departamento nuevoDepartamento = (Departamento) dialog.getComboDepartamento().getSelectedItem();

						int docenteSeleccionado = listaDocentes.getSelectedIndex();
						Docente docente = (Docente) modeloDocentes.get(docenteSeleccionado);

						docente.setNombre(nuevoNombre);
						docente.setApellidos(nuevosApellidos);
						docente.setCatCientifica(nuevaCatCientifica);
						docente.setCatDocente(nuevaCatDocente);
						nuevoDepartamento.agregarDocente(docente);

						modeloDocentes.set(docenteSeleccionado, docente);

						actualizarTablaDoc();

					}
				}else{
					MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar un docente para editar",Tipo.RETROALIMENTACION);
					mensajeRetroalimentacion.setVisible(true);
				}
			}
		});

		JButton btnEliminarDoc = crearBotonCRUD("Eliminar");
		btnEliminarDoc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int seleccionado = listaDocentes.getSelectedIndex();

				if (seleccionado != -1) {
					Docente docente = (Docente) modeloDocentes.getElementAt(seleccionado);

					MensajeDialog confirmacion = new MensajeDialog(parent,"¿Estás seguro que deseas eliminar a: " + docente.getNombre() + "?",Tipo.CONFIRMACION);

					confirmacion.setVisible(true);

					if (confirmacion.isConfirmado()) {
						dptoActual.removerDocente(docente);

						modeloDocentes.remove(seleccionado);

						MensajeDialog mensaje = new MensajeDialog(parent,"Docente eliminado correctamente",Tipo.RETROALIMENTACION);
						mensaje.setVisible(true);
					}
				} else {
					MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar un docente para eliminar",Tipo.RETROALIMENTACION);
					mensajeRetroalimentacion.setVisible(true);
				}
			}
		});

		panelBotonesCRUDDocentes.add(btnCrearDoc);
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

					MensajeDialog confirmacion = new MensajeDialog(parent,"¿Estás seguro que deseas eliminar a:"+ " " + maestria.getNombre() + "?",Tipo.CONFIRMACION);

					confirmacion.setVisible(true);

					if (confirmacion.isConfirmado()) {
						dptoActual.removerMaestria(maestria);

						modeloMaestrias.remove(seleccionado);

						MensajeDialog mensaje = new MensajeDialog(parent,"Maestría eliminada correctamente",Tipo.RETROALIMENTACION);
						mensaje.setVisible(true);
					}
				} else {
					MensajeDialog mensajeRetroalimentacion = new MensajeDialog(parent,"Debes seleccionar una maestría para eliminar",Tipo.RETROALIMENTACION);
					mensajeRetroalimentacion.setVisible(true);
				}
			}
		});

		panelBotonesCRUDMaestria.add(btnCrearMaestria);
		panelBotonesCRUDMaestria.add(btnEditarMaestria);
		panelBotonesCRUDMaestria.add(btnEliminarMaestria);

		panelMaestrias.add(panelBotonesCRUDMaestria, BorderLayout.SOUTH);
	}

	public void actualizarTablaEst(){
		modeloEstudiantes.clear();

		for (Estudiante estudiante : dptoActual.getEstudiantes()) {
			modeloEstudiantes.addElement(estudiante);
		}
	}

	public void actualizarTablaDoc(){
		modeloDocentes.clear();

		for (Docente docente : dptoActual.getDocentes()) {
			modeloDocentes.addElement(docente);
		}
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

