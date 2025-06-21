package Interfaz;

import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import Interfaz.MensajeDialog.Tipo;
import Logica.Maestria;

import java.awt.*;
import java.awt.event.*;

public class EditarMaestriaDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JTextField campoNombre;
	private JTextField campoDuracionMeses;
	private JTextField campoCampoEstudio;
	private boolean confirmado = false;
	private Point point = new Point();
	private Maestria maestriaSeleccionada;

	public EditarMaestriaDialog(final JFrame parent, final Maestria maestria) {
		super(parent, "Editar Maestría", true);
		setUndecorated(true);
		setBackground(new Color(30, 40, 50));
		getContentPane().setLayout(new BorderLayout());

		this.maestriaSeleccionada = maestria;

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 40, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));

		JPanel panelCampos = new JPanel();
		panelCampos.setBounds(20, 65, 360, 250);
		panelCampos.setBackground(new Color(30, 40, 50));
		panel.setLayout(null);
		panelCampos.setLayout(null);
		panel.add(panelCampos);

		int labelWidth = 120;
		int fieldWidth = 200;
		int startX = 30;
		int fieldX = startX + labelWidth + 10;
		int yOffset = 40;
		int fieldHeight = 30;

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(startX, 30, labelWidth, fieldHeight);
		panelCampos.add(labelNombre);
		estiloLabel(labelNombre);

		campoNombre = new JTextField();
		campoNombre.setBounds(fieldX, 30, fieldWidth, fieldHeight);
		panelCampos.add(campoNombre);
		estiloCampo(campoNombre);

		JLabel labelDuracion = new JLabel("Duración (meses):");
		labelDuracion.setBounds(startX, 30 + yOffset, labelWidth, fieldHeight);
		panelCampos.add(labelDuracion);
		estiloLabel(labelDuracion);

		campoDuracionMeses = new JTextField();
		campoDuracionMeses.setBounds(fieldX, 30 + yOffset, fieldWidth, fieldHeight);
		panelCampos.add(campoDuracionMeses);
		estiloCampo(campoDuracionMeses);

		JLabel labelCampoEstudio = new JLabel("Campo de estudio:");
		labelCampoEstudio.setBounds(startX, 30 + 2*yOffset, labelWidth, fieldHeight);
		panelCampos.add(labelCampoEstudio);
		estiloLabel(labelCampoEstudio);

		campoCampoEstudio = new JTextField();
		campoCampoEstudio.setBounds(fieldX, 30 + 2*yOffset, fieldWidth, fieldHeight);
		panelCampos.add(campoCampoEstudio);
		estiloCampo(campoCampoEstudio);

		campoNombre.setText(maestria.getNombre());
		campoDuracionMeses.setText(String.valueOf(maestria.getDuracionMeses()));
		campoCampoEstudio.setText(maestria.getCampoEstudio());

		aplicarFiltroTexto(campoNombre, 50);
		aplicarFiltroTexto(campoCampoEstudio, 50);
		aplicarFiltroNumerico(campoDuracionMeses, 10);

		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		panelBotones.setBounds(20, 320, 360, 60);
		panelBotones.setBackground(new Color(30, 40, 50));

		JButton botonAceptar = new JButton("Aceptar");
		JButton botonCancelar = new JButton("Cancelar");

		estiloBoton(botonAceptar);
		estiloBoton(botonCancelar);

		botonAceptar.setPreferredSize(new Dimension(120, 40));
		botonCancelar.setPreferredSize(new Dimension(120, 40));

		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nuevoNombre = getNombre();
					String nuevoCampoEstudio = getCampoEstudio();
					int nuevaDuracion = getDuracionMeses();

					maestriaSeleccionada.setNombre(nuevoNombre);
					maestriaSeleccionada.setCampoEstudio(nuevoCampoEstudio);
					maestriaSeleccionada.setDuracionMeses(nuevaDuracion);

					MensajeDialog d = new MensajeDialog(parent, "Maestría actualizada correctamente", Tipo.RETROALIMENTACION);
					d.setVisible(true);
					confirmado = true;
					dispose();
				} catch (RuntimeException ex) {
					MensajeDialog d = new MensajeDialog(parent, ex.getMessage(), Tipo.RETROALIMENTACION);
					d.setVisible(true);
				}
			}
		});

		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		panelBotones.add(botonAceptar);
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

		getContentPane().add(panel);

		JLabel lblTitulo = new JLabel("Editar Maestría");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		int labelWidthi = 200;
		int xPosition = (400 - labelWidth) / 2;
		lblTitulo.setBounds(xPosition, 20, labelWidthi, 30);
		panel.add(lblTitulo);
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

	public String getNombre() {
		return campoNombre.getText();
	}

	public int getDuracionMeses() {

		return Integer.parseInt(campoDuracionMeses.getText());

	}

	public String getCampoEstudio() {
		return campoCampoEstudio.getText();
	}

	public boolean isConfirmado() {
		return confirmado;
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
	
	public void aplicarFiltroNumerico(JTextField campo, final int maxChars){
		
		AbstractDocument doc = (AbstractDocument) campo.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {

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
}