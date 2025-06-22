package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SeleccionTipoInvestigadorDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private boolean confirmado = false;
	private String tipoSeleccionado = null;

	public SeleccionTipoInvestigadorDialog(JFrame parent) {
		super(parent, "Seleccionar Tipo de Investigador", true);
		setUndecorated(true);
		setSize(400, 200);
		setLocationRelativeTo(parent);
		setBackground(new Color(30, 40, 50));
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 40, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new GridLayout(3, 1, 10, 10));

		JLabel label = new JLabel("Seleccione el tipo de investigador:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		panel.add(label);

		JButton btnEstudiante = new JButton("Estudiante");
		JButton btnDocente = new JButton("Docente");
		estiloBoton(btnEstudiante);
		estiloBoton(btnDocente);

		btnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoSeleccionado = "Estudiante";
				confirmado = true;
				dispose();
			}
		});
		btnDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoSeleccionado = "Docente";
				confirmado = true;
				dispose();
			}
		});

		panel.add(btnEstudiante);
		panel.add(btnDocente);

		add(panel, BorderLayout.CENTER);
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

	public String getTipoSeleccionado() {
		return tipoSeleccionado;
	}
}
