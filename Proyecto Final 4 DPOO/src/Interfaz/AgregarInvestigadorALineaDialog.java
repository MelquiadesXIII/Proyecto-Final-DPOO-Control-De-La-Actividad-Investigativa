package Interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import Logica.*;

public class AgregarInvestigadorALineaDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private boolean confirmado = false;
	private JList<Object> listaElementos;
	private JButton btnAgregar, btnCancelar;

	public AgregarInvestigadorALineaDialog(final JFrame parent, final Departamento departamento, final LineaInvestigacion linea, final boolean esEstudiante) {
		super(parent, "Agregar Investigador", true);

		setUndecorated(true);
		setBackground(new Color(30, 40, 50));
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 40, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setPreferredSize(new Dimension(500, 400));
		panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
		panel.setLayout(null);

		
		ArrayList<Investigador> disponibles = new ArrayList<>();

		if (esEstudiante) {
		    disponibles.addAll(departamento.obtenerInvestigadoresNoRegistradosLineasDeInvestigacion());
		} else {
		    disponibles.addAll(departamento.obtenerInvestigadoresNoRegistradosLineasDeInvestigacion());
		};

		listaElementos = new JList<>(disponibles.toArray());
		listaElementos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		listaElementos.setBackground(new Color(60, 70, 80));
		listaElementos.setForeground(Color.WHITE);
		listaElementos.setSelectionBackground(new Color(80, 90, 100));
		listaElementos.setSelectionForeground(Color.WHITE);
		listaElementos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		listaElementos.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				Investigador inv = (Investigador) value;
				setText(inv.getNombre() + " " + inv.getApellidos());
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

		btnAgregar = new JButton("Agregar");
		btnCancelar = new JButton("Cancelar");

		estiloBoton(btnAgregar);
		estiloBoton(btnCancelar);

		panelBotones.add(btnAgregar);
		panelBotones.add(btnCancelar);
		panel.add(panelBotones);

		JLabel lblTitulo = new JLabel("Agregar Investigador");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTitulo.setBounds(20, 20, 300, 30);
		panel.add(lblTitulo);

		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listaElementos.getSelectedIndex();
				if (index != -1) {
					Investigador seleccionado = (Investigador) listaElementos.getModel().getElementAt(index);
					MensajeDialog confirm = new MensajeDialog(parent, "¿Seguro que desea agregar al investigador?", MensajeDialog.Tipo.CONFIRMACION);
					confirm.setVisible(true);

					if (confirm.isConfirmado()) {
						try {
							linea.agregarInvestigador(seleccionado);
							MensajeDialog exito = new MensajeDialog(parent, "Investigador agregado correctamente", MensajeDialog.Tipo.RETROALIMENTACION);
							exito.setVisible(true);
							confirmado = true;
							dispose();
						} catch (RuntimeException ex) {
							MensajeDialog error = new MensajeDialog(parent, ex.getMessage(), MensajeDialog.Tipo.RETROALIMENTACION);
							error.setVisible(true);
						}
					}
				} else {
					MensajeDialog aviso = new MensajeDialog(parent, "Seleccione un investigador de la lista", MensajeDialog.Tipo.RETROALIMENTACION);
					aviso.setVisible(true);
				}
			}
		});

		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
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
