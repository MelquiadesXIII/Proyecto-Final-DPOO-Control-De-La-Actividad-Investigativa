package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import Interfaz.MensajeDialog.Tipo;
import Logica.Departamento;

public class CrearMaestriaDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField campoNombre;
	private JTextField campoCampo;
	private JTextField campoDuracion;
	private boolean confirmado = false;
	private Point point = new Point();

	public CrearMaestriaDialog(final JFrame parent, final Departamento departamento) {
		super(parent, "Crear Maestría", true);
		setUndecorated(true);
		setBackground(new Color(30, 40, 50));
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 40, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setPreferredSize(new Dimension(400, 380));
		panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
		panel.setLayout(null);

		JPanel panelCampos = new JPanel();
		panelCampos.setBounds(20, 80, 360, 230);
		panelCampos.setBackground(new Color(30, 40, 50));
		panelCampos.setLayout(null);
		panel.add(panelCampos);

		int maxLabelWidth = 140;
		int fieldX = 20 + maxLabelWidth + 10;
		int fieldWidth = 360 - fieldX - 20;

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(20, 20, maxLabelWidth, 30);
		panelCampos.add(labelNombre);
		estiloLabel(labelNombre);

		campoNombre = new JTextField();
		campoNombre.setBounds(fieldX, 20, fieldWidth, 30);
		panelCampos.add(campoNombre);
		estiloCampo(campoNombre);

		JLabel labelCampo = new JLabel("Campo de estudio:");
		labelCampo.setBounds(20, 70, maxLabelWidth, 30);
		panelCampos.add(labelCampo);
		estiloLabel(labelCampo);

		campoCampo = new JTextField();
		campoCampo.setBounds(fieldX, 70, fieldWidth, 30);
		panelCampos.add(campoCampo);
		estiloCampo(campoCampo);

		JLabel labelDuracion = new JLabel("Duración (meses):");
		labelDuracion.setBounds(20, 120, maxLabelWidth, 30);
		panelCampos.add(labelDuracion);
		estiloLabel(labelDuracion);

		campoDuracion = new JTextField();
		campoDuracion.setBounds(fieldX, 120, fieldWidth, 30);
		panelCampos.add(campoDuracion);
		estiloCampo(campoDuracion);

		aplicarFiltroTexto(campoNombre, 25); 
		aplicarFiltroTexto(campoCampo, 40); 
		aplicarFiltroNumerico(campoDuracion);

		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		panelBotones.setBounds(20, 310, 360, 60);
		panelBotones.setBackground(new Color(30, 40, 50));

		JButton botonCrear = new JButton("Crear");
		JButton botonCancelar = new JButton("Cancelar");
		estiloBoton(botonCrear);
		estiloBoton(botonCancelar);
		botonCrear.setPreferredSize(new Dimension(120, 40));
		botonCancelar.setPreferredSize(new Dimension(120, 40));

		botonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = campoNombre.getText().trim();
				String campo = campoCampo.getText().trim();
				String duracionStr = campoDuracion.getText().trim();

				if (!nombre.isEmpty() && !campo.isEmpty() && !duracionStr.isEmpty()) {
					try {
						int duracion = Integer.parseInt(duracionStr);
						departamento.crearMaestria(nombre, campo, duracion);
						MensajeDialog d = new MensajeDialog(parent, "Maestría creada exitosamente", Tipo.RETROALIMENTACION);
						d.setVisible(true);
						confirmado = true;
						dispose();
					} catch (NumberFormatException ex) {
						MensajeDialog d = new MensajeDialog(parent, "Duración debe ser un número válido", Tipo.RETROALIMENTACION);
						d.setVisible(true);
					} catch (RuntimeException ex) {
						MensajeDialog d = new MensajeDialog(parent, ex.getMessage(), Tipo.RETROALIMENTACION);
						d.setVisible(true);
					}
				} else {
					MensajeDialog d;
					if (nombre.isEmpty()) d = new MensajeDialog(parent, "Rellene el nombre", Tipo.RETROALIMENTACION);
					else if (campo.isEmpty()) d = new MensajeDialog(parent, "Rellene el campo de estudio", Tipo.RETROALIMENTACION);
					else d = new MensajeDialog(parent, "Rellene la duración", Tipo.RETROALIMENTACION);
					d.setVisible(true);
				}
			}
		});

		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		panelBotones.add(botonCrear);
		panelBotones.add(botonCancelar);
		panel.add(panelBotones);

		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		};

		MouseMotionListener motionListener = new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
			public void mouseMoved(MouseEvent e) {}
		};

		panel.addMouseListener(mouseAdapter);
		panel.addMouseMotionListener(motionListener);

		JLabel lblTitulo = new JLabel("Crear Maestría");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTitulo.setBounds(140, 35, 164, 50);
		panel.add(lblTitulo);

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

	private void estiloLabel(JLabel label) {
		label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label.setForeground(Color.WHITE);
	}

	private void estiloCampo(JTextField campo) {
		campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		campo.setBackground(new Color(60, 70, 80));
		campo.setForeground(Color.WHITE);
		campo.setCaretColor(Color.WHITE);
		campo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}

	public void aplicarFiltroTexto(JTextField campo, final int maxChars){

		AbstractDocument doc = (AbstractDocument) campo.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {

			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
				if (string != null) {
					String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
					String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
					if (newText.length() <= maxChars && newText.matches("^[\\p{L}\\s]*$")) {
						super.insertString(fb, offset, string, attr);
					}
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
				if (text != null) {
					String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
					String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
					if (newText.length() <= maxChars && newText.matches("^[\\p{L}\\s]*$")) {
						super.replace(fb, offset, length, text, attrs);
					}
				} else {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});
	}

	public void aplicarFiltroNumerico(JTextField campo){

		AbstractDocument doc = (AbstractDocument) campo.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
			private int maxChars = 10; 

			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
				if (string != null) {

					String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
					if (newText.length() <= maxChars && string.matches("\\d*")) {
						super.insertString(fb, offset, string, attr);
					}
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
				String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
				String newText = currentText.substring(0, offset) + 
						(text != null ? text : "") + 
						currentText.substring(offset + length);

				if (newText.length() <= maxChars && newText.matches("\\d*")) {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});
	}

	public boolean isConfirmado() {
		return confirmado;
	}
}