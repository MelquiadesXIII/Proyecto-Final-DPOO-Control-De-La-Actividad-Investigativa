package Interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Logica.LineaInvestigacion;
import Logica.Investigador;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class EliminarInvestigadorLineaDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private boolean confirmado = false;
	private Point point = new Point();

	public EliminarInvestigadorLineaDialog(final JFrame parent, final LineaInvestigacion linea) {
		super(parent, "Eliminar Investigador", true);

		setUndecorated(true);
		setBackground(new Color(30, 40, 50));
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 40, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setPreferredSize(new Dimension(500, 400));
		panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("Eliminar Investigador");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTitulo.setBounds(20, 20, 460, 30);
		panel.add(lblTitulo);

		List<Investigador> investigadores = linea.getInvestigadores();

		final JList<Object> lista = new JList<>(investigadores.toArray());
		lista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lista.setBackground(new Color(60, 70, 80));
		lista.setForeground(Color.WHITE);
		lista.setSelectionBackground(new Color(80, 90, 100));
		lista.setSelectionForeground(Color.WHITE);
		lista.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		lista.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				Investigador inv = (Investigador) value;
				setText(inv.getNombre() + " " + inv.getApellidos());
				return this;
			}
		});

		JScrollPane scroll = new JScrollPane(lista);
		scroll.setBounds(20, 65, 460, 250);
		scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 70, 80), 2));
		panel.add(scroll);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(80, 340, 150, 40);
		estiloBoton(btnEliminar);
		panel.add(btnEliminar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(270, 340, 150, 40);
		estiloBoton(btnCancelar);
		panel.add(btnCancelar);

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = lista.getSelectedIndex();
				if (selectedIndex != -1) {
					Investigador seleccionado = (Investigador) lista.getModel().getElementAt(selectedIndex);

					MensajeDialog confirmacion = new MensajeDialog(parent, "¿Está seguro que desea eliminar al investigador?", MensajeDialog.Tipo.CONFIRMACION);
					confirmacion.setVisible(true);

					if (confirmacion.isConfirmado()) {
						try {
							linea.removerInvestigador(seleccionado);
							MensajeDialog mensaje = new MensajeDialog(parent, "Investigador eliminado correctamente", MensajeDialog.Tipo.RETROALIMENTACION);
							mensaje.setVisible(true);
							confirmado = true;
							dispose();
						} catch (RuntimeException ex) {
							MensajeDialog error = new MensajeDialog(parent, ex.getMessage(), MensajeDialog.Tipo.RETROALIMENTACION);
							error.setVisible(true);
						}
					}
				} else {
					MensajeDialog mensaje = new MensajeDialog(parent, "Seleccione un investigador para eliminar", MensajeDialog.Tipo.RETROALIMENTACION);
					mensaje.setVisible(true);
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});

		panel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(parent);
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
