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
import javax.swing.JComboBox;
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
import Logica.CategoriaCientifica;
import Logica.CategoriaDocente;
import Logica.Departamento;
import Logica.Docente;
import Logica.Vicedecanato;

public class EditarDocDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	private JTextField campoNombre;
	private JTextField campoApellidos;
	private boolean confirmado = false;
	private Point point = new Point();
	private JComboBox<Departamento> comboDepartamento;
	private JComboBox<CategoriaCientifica> comboCatCientifica;
	private JComboBox<CategoriaDocente> comboCatDocente;

	public EditarDocDialog(final JFrame parent, final Vicedecanato vicedecanato, final Docente docente){

		super(parent, "Editar Docente", true);
		setUndecorated(true);
		setBackground(new Color(30, 40, 50));
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 40, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
		panel.setLayout(null);

		JPanel panelCampos = new JPanel();
		panelCampos.setBounds(20, 80, 460, 310);
		panelCampos.setBackground(new Color(30, 40, 50));
		panelCampos.setLayout(null);
		panel.add(panelCampos);


		int labelWidth = 120;
		int fieldWidth = 300;
		int fieldHeight = 40;
		int fieldX = 150;
		int startY = 20;
		int verticalSpacing = 60;

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(20, startY, labelWidth, fieldHeight);
		panelCampos.add(labelNombre);
		estiloLabel(labelNombre);

		campoNombre = new JTextField();
		campoNombre.setBounds(fieldX, startY, fieldWidth, fieldHeight);
		panelCampos.add(campoNombre);
		estiloCampo(campoNombre);

		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setBounds(20, startY + verticalSpacing, labelWidth, fieldHeight);
		panelCampos.add(labelApellidos);
		estiloLabel(labelApellidos);

		campoApellidos = new JTextField();
		campoApellidos.setBounds(fieldX, startY + verticalSpacing, fieldWidth, fieldHeight);
		panelCampos.add(campoApellidos);
		estiloCampo(campoApellidos);

		JLabel labelCatCientifica = new JLabel("Cat. Científica:");
		labelCatCientifica.setBounds(20, startY + verticalSpacing * 2, labelWidth, fieldHeight);
		panelCampos.add(labelCatCientifica);
		estiloLabel(labelCatCientifica);

		comboCatCientifica = new JComboBox<>(CategoriaCientifica.values());
		comboCatCientifica.setBounds(fieldX, startY + verticalSpacing * 2, fieldWidth, fieldHeight);
		panelCampos.add(comboCatCientifica);
		estiloComboBoxEnum(comboCatCientifica);

		JLabel labelCatDocente = new JLabel("Cat. Docente:");
		labelCatDocente.setBounds(20, startY + verticalSpacing * 3, labelWidth, fieldHeight);
		panelCampos.add(labelCatDocente);
		estiloLabel(labelCatDocente);

		comboCatDocente = new JComboBox<>(CategoriaDocente.values());
		comboCatDocente.setBounds(fieldX, startY + verticalSpacing * 3, fieldWidth, fieldHeight);
		panelCampos.add(comboCatDocente);
		estiloComboBoxEnum(comboCatDocente);

		aplicarFiltroTexto(campoNombre, 25);
		aplicarFiltroTexto(campoApellidos, 100);

		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		panelBotones.setBounds(20, 380, 460, 60);
		panelBotones.setBackground(new Color(30, 40, 50));

		JButton botonAceptar = new JButton("Aceptar");
		JButton botonCancelar = new JButton("Cancelar");

		estiloBoton(botonAceptar);
		estiloBoton(botonCancelar);

		botonAceptar.setPreferredSize(new Dimension(120, 40));
		botonCancelar.setPreferredSize(new Dimension(120, 40));

		campoNombre.setText(docente.getNombre());
		campoApellidos.setText(docente.getApellidos());
		comboCatCientifica.setSelectedItem(docente.getCatCientifica());
		comboCatDocente.setSelectedItem(docente.getCatDocente());

		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					String nuevoNombre = getNombre();
					String nuevosApellidos = getApellidos();
					CategoriaCientifica nuevaCatCientifica = getCatCientifica();
					CategoriaDocente nuevaCatDocente = getCatDocente();

					docente.setNombre(nuevoNombre);
					docente.setApellidos(nuevosApellidos);
					docente.setCatCientifica(nuevaCatCientifica);
					docente.setCatDocente(nuevaCatDocente);

					MensajeDialog d = new MensajeDialog(parent, "El docente ha sido editado satisfactoriamente", Tipo.RETROALIMENTACION);
					d.setVisible(true);
					confirmado = true;
					dispose();

				}catch(RuntimeException r){

					MensajeDialog d = new MensajeDialog(parent, r.getMessage(), Tipo.RETROALIMENTACION);
					d.setVisible(true);
					confirmado = false;
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

		JLabel lblCrearDocente = new JLabel("Editar Docente");
		lblCrearDocente.setForeground(Color.WHITE);
		lblCrearDocente.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCrearDocente.setBounds((500 - 164) / 2, 28, 164, 50);
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

	public JComboBox<Departamento> getComboDepartamento() {
		return comboDepartamento;
	}

	public void setComboDepartamento(JComboBox<Departamento> comboDepartamento) {
		this.comboDepartamento = comboDepartamento;
	}

	public CategoriaCientifica getCatCientifica(){
		return (CategoriaCientifica) comboCatCientifica.getSelectedItem();
	}

	public CategoriaDocente getCatDocente(){
		return (CategoriaDocente) comboCatDocente.getSelectedItem();
	}

	public void aplicarFiltroTexto(JTextField campo, final int maxChars) {
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
}
