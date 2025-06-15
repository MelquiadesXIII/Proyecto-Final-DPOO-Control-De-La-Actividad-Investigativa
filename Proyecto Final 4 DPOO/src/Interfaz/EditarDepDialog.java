package Interfaz;

import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.AttributeSet;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import Interfaz.MensajeDialog.Tipo;
import Logica.Departamento;
import Logica.Vicedecanato;

import java.awt.*;
import java.awt.event.*;

public class EditarDepDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JTextField campoNombre;
	private boolean confirmado = false;
	private Point point = new Point();


	public EditarDepDialog(final JFrame parent, final Vicedecanato vicedecanato, final Departamento departamento) {

		super(parent, "Editar Departamento", true);
		setUndecorated(true);
		setBackground(new Color(30, 40, 50));
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 40, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setPreferredSize(new Dimension(400, 275));
		panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));

		JPanel panelCampos = new JPanel();
		panelCampos.setBounds(20, 65, 360, 118);
		panelCampos.setBackground(new Color(30, 40, 50));

		panel.setLayout(null);
		panelCampos.setLayout(null);

		panel.add(panelCampos);

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(24, 46, 82, 50);
		panelCampos.add(labelNombre);
		estiloLabel(labelNombre);

		campoNombre = new JTextField();
		campoNombre.setBounds(118, 52, 230, 39);
		panelCampos.add(campoNombre);
		estiloCampo(campoNombre);

		AbstractDocument docNombre = (AbstractDocument) campoNombre.getDocument();
		docNombre.setDocumentFilter(new DocumentFilter() {
			private int maxChars = 25;

			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
				if (string == null) {
					return;
				}
				String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
				String newText = currentText.substring(0, offset) + string + currentText.substring(offset);

				if (newText.length() <= maxChars && newText.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]*$")) {
					super.insertString(fb, offset, string, attr);
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
				if (text == null) {
					super.replace(fb, offset, length, text, attrs);
					return;
				}
				String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
				String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

				if (newText.length() <= maxChars && newText.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]*$")) {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});


		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		panelBotones.setBounds(20, 196, 360, 60);
		panelBotones.setBackground(new Color(30, 40, 50));

		JButton botonAceptar = new JButton("Aceptar");
		JButton botonCancelar = new JButton("Cancelar");

		estiloBoton(botonAceptar);
		estiloBoton(botonCancelar);

		botonAceptar.setPreferredSize(new Dimension(120, 40));
		botonCancelar.setPreferredSize(new Dimension(120, 40));

		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!campoNombre.getText().isEmpty()){

					try{
						
						String nuevoNombre = getNombre();

						departamento.setNombre(nuevoNombre);
						
						MensajeDialog d = new MensajeDialog(parent, "El departamento ha sido editado satisfactoriamente", Tipo.RETROALIMENTACION);
						d.setVisible(true);
						confirmado = true;
						dispose();

					}catch(RuntimeException r){

						MensajeDialog d = new MensajeDialog(parent, r.getMessage(), Tipo.RETROALIMENTACION);
						d.setVisible(true);
						confirmado = false;
					}
				
				}else{
					
					MensajeDialog d;
					
					if(campoNombre.getText().trim().isEmpty()){
						d = new MensajeDialog(parent, "Rellene el campo del nombre", Tipo.RETROALIMENTACION);
						d.setVisible(true);
					}
					
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

		JLabel lbltitulo = new JLabel("Editar Departamento");
		lbltitulo.setForeground(Color.WHITE);
		lbltitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		int labelWidth = 200;
		int xPosition = (425 - labelWidth) / 2;
		lbltitulo.setBounds(xPosition, 28, labelWidth, 50);
		panel.add(lbltitulo);
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

	public boolean isConfirmado() {
		return confirmado;
	}
}