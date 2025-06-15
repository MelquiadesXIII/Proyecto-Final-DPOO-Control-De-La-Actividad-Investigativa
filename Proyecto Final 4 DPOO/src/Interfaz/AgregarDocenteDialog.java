package Interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import Interfaz.MensajeDialog.Tipo;
import Logica.*;

public class AgregarDocenteDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private boolean confirmado = false;
	private Point point = new Point();
	private JList<Object> listaElementos;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JFrame parent;
	private Vicedecanato vicedecanato;
	private Departamento departamentoActual;

	@SuppressWarnings("serial")
	public AgregarDocenteDialog(final JFrame parent, final Vicedecanato vicedecanato, 
			final Departamento departamentoActual) {

		super(parent, "Agregar Docente", true);
		this.parent = parent;
		this.vicedecanato = vicedecanato;
		this.departamentoActual = departamentoActual;

		setUndecorated(true);
		setBackground(new Color(30, 40, 50));
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 40, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setPreferredSize(new Dimension(500, 400));
		panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
		panel.setLayout(null);

		ArrayList<Docente> elementosDisponibles = this.vicedecanato.obtenerDocentesNoRegistradosEnDepartamentos();

		listaElementos = new JList<>(elementosDisponibles.toArray());
		listaElementos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		listaElementos.setBackground(new Color(60, 70, 80));
		listaElementos.setForeground(Color.WHITE);
		listaElementos.setSelectionBackground(new Color(80, 90, 100));
		listaElementos.setSelectionForeground(Color.WHITE);
		listaElementos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		listaElementos.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				Docente d = (Docente) value;
				setText(d.getNombre() + " " + d.getApellidos());
				return this;
			}
		});

		JScrollPane scrollPane = new JScrollPane(listaElementos);
		scrollPane.setBounds(20, 65, 460, 250);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(60, 70, 80), 2));
		panel.add(scrollPane);

		JPanel panelBotones = new JPanel(new GridLayout(1, 2, 40, 0)); 
		panelBotones.setBounds(20, 340, 460, 50); 
		panelBotones.setBackground(new Color(30, 40, 50));
		panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 40, 5, 40)); 


		btnAgregar = new JButton("Agregar");
		btnCancelar = new JButton("Cancelar");

		estiloBoton(btnAgregar);
		estiloBoton(btnCancelar);

		btnAgregar.setPreferredSize(new Dimension(150, 40));
		btnCancelar.setPreferredSize(new Dimension(150, 40));

		panelBotones.add(btnAgregar);
		panelBotones.add(btnCancelar);
		panel.add(panelBotones);

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				procesarSeleccion();
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JLabel lblTitulo = new JLabel("Agregar Docente");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTitulo.setBounds(20, 20, 300, 30);
		panel.add(lblTitulo);

		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		};

		MouseMotionListener motionListener = new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		};

		panel.addMouseListener(mouseAdapter);
		panel.addMouseMotionListener(motionListener);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
	}


	private void procesarSeleccion() {
		int selectedIndex = listaElementos.getSelectedIndex();

		if (selectedIndex != -1) {
			Docente seleccion = (Docente) listaElementos.getModel().getElementAt(selectedIndex);

			MensajeDialog m1 = new MensajeDialog(parent, "¿Seguro que desea agregar al docente?", Tipo.CONFIRMACION);    
			m1.setVisible(true);

			if(m1.isConfirmado()){
				try {
					departamentoActual.agregarDocente(seleccion);

					MensajeDialog d = new MensajeDialog(parent, "Elemento agregado correctamente", Tipo.RETROALIMENTACION);
					d.setVisible(true);
					confirmado = true;
					dispose();
				} catch(RuntimeException r) {
					MensajeDialog m2 = new MensajeDialog(parent, r.getMessage(), Tipo.RETROALIMENTACION);
					m2.setVisible(true);
				}
			}
		} else {
			MensajeDialog d = new MensajeDialog(parent, "Seleccione un elemento de la lista", Tipo.RETROALIMENTACION);
			d.setVisible(true);
		}
	}

	private void estiloBoton(JButton boton) {
		boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		boton.setBackground(new Color(50, 60, 70));
		boton.setForeground(Color.WHITE);
		boton.setFocusPainted(false);
		boton.setBorderPainted(false);
		boton.setOpaque(true);
	}

	public boolean isConfirmado() {
		return confirmado;
	}
}