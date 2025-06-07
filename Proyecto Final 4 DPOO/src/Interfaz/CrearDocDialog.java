package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import Interfaz.MensajeDialog.Tipo;
import Logica.CategoriaCientifica;
import Logica.CategoriaDocente;
import Logica.Departamento;
import Logica.Vicedecanato;

public class CrearDocDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	private JTextField campoNombre;
	private JTextField campoApellidos;
	private boolean confirmado = false;
	private Point point = new Point();
	private JComboBox<Departamento> comboDepartamento;
	private JComboBox<CategoriaCientifica> comboCatCientifica;
	private JComboBox<CategoriaDocente> comboCatDocente;
	
	public CrearDocDialog(final JFrame parent, final Vicedecanato vicedecanato){
		
		super(parent, "Crear Docente", true);
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

		campoNombre = new JTextField();
		campoNombre.setBounds(118, 52, 230, 39);
		panelCampos.add(campoNombre);
		estiloCampo(campoNombre);

		campoApellidos = new JTextField();
		campoApellidos.setBounds(118, 118, 230, 39);
		panelCampos.add(campoApellidos);
		estiloCampo(campoApellidos);


		JLabel labelDepartamento = new JLabel("Departamento:");
		labelDepartamento.setBounds(24, 240, 100, 50);
		panelCampos.add(labelDepartamento);
		estiloLabel(labelDepartamento);

		comboDepartamento = new JComboBox<>();

		final Departamento verSeleccionarDepto = new Departamento("Seleccionar");
		comboDepartamento.addItem(verSeleccionarDepto);

		for (Departamento d : vicedecanato.getDepartamentos()) {
			comboDepartamento.addItem(d);
		}

		comboDepartamento.setBounds(118, 246, 230, 39);
		panelCampos.add(comboDepartamento);
		estiloComboBox(comboDepartamento);
		
		JLabel labelCatCientifica = new JLabel("Cat. Científica:");
		labelCatCientifica.setBounds(24, 172, 100, 50);
		panelCampos.add(labelCatCientifica);
		estiloLabel(labelCatCientifica);

		comboCatCientifica = new JComboBox<>(CategoriaCientifica.values());
		comboCatCientifica.setBounds(118, 178, 230, 39);
		panelCampos.add(comboCatCientifica);
		estiloComboBoxEnum(comboCatCientifica);
		
		JLabel labelCatDocente = new JLabel("Cat. Docente:");
		labelCatDocente.setBounds(24, 206, 100, 50);
		panelCampos.add(labelCatDocente);
		estiloLabel(labelCatDocente);

		comboCatDocente = new JComboBox<>(CategoriaDocente.values());
		comboCatDocente.setBounds(118, 212, 230, 39);
		panelCampos.add(comboCatDocente);
		estiloComboBoxEnum(comboCatDocente);

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
				CategoriaCientifica catCientifica = (CategoriaCientifica) comboCatCientifica.getSelectedItem();
				CategoriaDocente catDocente = (CategoriaDocente) comboCatDocente.getSelectedItem();

				if(!depto.equals(verSeleccionarDepto)){
					String nombre = getNombre();
					String apellidos = getApellidos();

					try{

						vicedecanato.crearDocente(nombre, apellidos, catCientifica, catDocente, depto);
						MensajeDialog d = new MensajeDialog(parent, "El docente ha sido creado satisfactoriamente", Tipo.RETROALIMENTACION);
						d.setVisible(true);
						confirmado = true;
						dispose();

					}catch(RuntimeException r){

						MensajeDialog d = new MensajeDialog(parent, r.getMessage(), Tipo.RETROALIMENTACION);
						d.setVisible(true);
						confirmado = false;
					}
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

		JLabel lblCrearDocente = new JLabel("Crear Docente");
		lblCrearDocente.setForeground(Color.WHITE);
		lblCrearDocente.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCrearDocente.setBounds(127, 28, 164, 50);
		panel.add(lblCrearDocente);
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
	
	private void estiloComboBoxEnum(JComboBox<?> comboBox) {
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox.setBackground(new Color(60, 70, 80));
		comboBox.setForeground(Color.WHITE);
		comboBox.setOpaque(false);
		comboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}

	public String getNombre() {
		return campoNombre.getText();
	}

	public String getApellidos() {
		return campoApellidos.getText();
	}

	public boolean isConfirmado() {
		return confirmado;
	}
}
