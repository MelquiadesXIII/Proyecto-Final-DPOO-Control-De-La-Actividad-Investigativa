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

public class CrearEstDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JTextField campoNombre;
	private JTextField campoApellidos;
	private boolean confirmado = false;
	private Point point = new Point();
	private JTextField campoGrupo;
	private JComboBox<Departamento> comboDepartamento;


	public CrearEstDialog(final JFrame parent, final Vicedecanato vicedecanato) {

		super(parent, "Crear Estudiante", true);
		setUndecorated(true);
		setBackground(new Color(30, 40, 50));
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 40, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setPreferredSize(new Dimension(400, 450));
		panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));

		JPanel panelCampos = new JPanel();
		panelCampos.setBounds(20, 65, 360, 300);
		panelCampos.setBackground(new Color(30, 40, 50));

		panel.setLayout(null);
		panelCampos.setLayout(null);

		panel.add(panelCampos);

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(24, 46, 82, 50);
		panelCampos.add(labelNombre);
		estiloLabel(labelNombre);

		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setBounds(24, 112, 82, 50);
		panelCampos.add(labelApellidos);
		estiloLabel(labelApellidos);

		JLabel labelGrupo = new JLabel("Grupo:");
		labelGrupo.setBounds(24, 175, 82, 50);
		panelCampos.add(labelGrupo);
		estiloLabel(labelGrupo);

		campoNombre = new JTextField();
		campoNombre.setBounds(118, 52, 230, 39);
		panelCampos.add(campoNombre);
		estiloCampo(campoNombre);

		campoApellidos = new JTextField();
		campoApellidos.setBounds(118, 118, 230, 39);
		panelCampos.add(campoApellidos);
		estiloCampo(campoApellidos);

		campoGrupo = new JTextField();
		campoGrupo.setBounds(118, 181, 230, 39);
		panelCampos.add(campoGrupo);
		estiloCampo(campoGrupo);


		JLabel labelDepartamento = new JLabel("Departamento:");
		labelDepartamento.setBounds(24, 240, 100, 50);
		panelCampos.add(labelDepartamento);
		estiloLabel(labelDepartamento);

		comboDepartamento = new JComboBox<>();


		final Departamento verSeleccionarDepto = new Departamento("Seleccionar");
		comboDepartamento.addItem(verSeleccionarDepto);

		for (Departamento d : vicedecanato.getDepartamentos()) 
			comboDepartamento.addItem(d);

		comboDepartamento.setBounds(118, 246, 230, 39);


		panelCampos.add(comboDepartamento);
		estiloComboBox(comboDepartamento);

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

		//Filtrar los nombres para no permitir numeros ni exceso de caracteres en los apellidos
		AbstractDocument docApellidos = (AbstractDocument) campoApellidos.getDocument();
		docApellidos.setDocumentFilter(new DocumentFilter() {
			private int maxChars = 100;

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


		//Filtrar los nombres para no permitir exceso de caracteres en el grupo ya q aqui si se pueden aceptar numeros
		AbstractDocument docGrupo = (AbstractDocument) campoGrupo.getDocument();
		docGrupo.setDocumentFilter(new DocumentFilter() {
			private int maxChars = 10;

			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
				if (string == null) {
					return;
				}
				String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
				String newText = currentText.substring(0, offset) + string + currentText.substring(offset);

				if (newText.length() <= maxChars && newText.matches("^[a-zA-Z0-9]*$")) {
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

				if (newText.length() <= maxChars && newText.matches("^[a-zA-Z0-9]*$")) { 
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});


		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		panelBotones.setBounds(20, 380, 360, 60);
		panelBotones.setBackground(new Color(30, 40, 50));

		JButton botonCrear = new JButton("Crear");
		JButton botonCancelar = new JButton("Cancelar");

		estiloBoton(botonCrear);
		estiloBoton(botonCancelar);

		botonCrear.setPreferredSize(new Dimension(120, 40));
		botonCancelar.setPreferredSize(new Dimension(120, 40));

		botonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Departamento depto = (Departamento) comboDepartamento.getSelectedItem();

				if(!depto.equals(verSeleccionarDepto) && !campoNombre.getText().isEmpty() && !campoApellidos.getText().isEmpty() && !campoGrupo.getText().trim().isEmpty()){
					String nombre = getNombre();
					String apellidos = getApellidos();
					String grupo = getGrupo();

					try{

						vicedecanato.crearEstudiante(nombre, apellidos, grupo, depto);
						MensajeDialog d = new MensajeDialog(parent, "El estudiante ha sido creado satisfactoriamente", Tipo.RETROALIMENTACION);
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

					if(campoNombre.getText().trim().isEmpty())
						d = new MensajeDialog(parent, "Rellene el campo del nombre", Tipo.RETROALIMENTACION);

					else if(campoApellidos.getText().trim().isEmpty())
						d = new MensajeDialog(parent, "Rellene el campo de los apellidos", Tipo.RETROALIMENTACION);

					else if(campoGrupo.getText().trim().isEmpty())
						d = new MensajeDialog(parent, "Rellene el campo del grupo", Tipo.RETROALIMENTACION);

					else
						d = new MensajeDialog(parent, "Seleccione un departamento", Tipo.RETROALIMENTACION);

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

		getContentPane().add(panel);

		JLabel lblCrearEstudiante = new JLabel("Crear Estudiante");
		lblCrearEstudiante.setForeground(Color.WHITE);
		lblCrearEstudiante.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCrearEstudiante.setBounds(127, 28, 164, 50);
		panel.add(lblCrearEstudiante);
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

	private void estiloComboBox(JComboBox<Departamento> comboBox) {
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox.setBackground(new Color(60, 70, 80));
		comboBox.setForeground(Color.WHITE);
		comboBox.setOpaque(false);
		comboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		comboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton button = new JButton();
				button.setBackground(new Color(50, 60, 70));
				button.setForeground(Color.WHITE);
				button.setBorder(BorderFactory.createEmptyBorder());
				return button;
			}

			@SuppressWarnings("unchecked")
			@Override
			public void installUI(JComponent c) {
				super.installUI(c);
				comboBox.setRenderer(new DefaultListCellRenderer() {
					private static final long serialVersionUID = 1L;

					@Override
					public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
						JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
						if (value instanceof Departamento) {
							label.setText(((Departamento) value).getNombre());
						} else if (value != null) {
							label.setText(value.toString());
						}
						label.setForeground(Color.WHITE);
						label.setBackground(isSelected ? new Color(30, 40, 50) : new Color(60, 70, 80));
						label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
						return label;
					}
				});
			}
		});

		comboBox.setSelectedIndex(0);
	}

	public String getNombre() {
		return campoNombre.getText();
	}

	public String getApellidos() {
		return campoApellidos.getText();
	}

	public String getGrupo(){
		return campoGrupo.getText();
	}

	public boolean isConfirmado() {
		return confirmado;
	}
}