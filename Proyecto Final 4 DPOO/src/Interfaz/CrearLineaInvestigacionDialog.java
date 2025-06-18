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

import Interfaz.MensajeDialog.Tipo;
import Logica.Departamento;
import Logica.Docente;
import Logica.Vicedecanato;

public class CrearLineaInvestigacionDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField campoNombre;
	private JComboBox<Docente> comboEncargado;
    private boolean confirmado = false;
    private Point point = new Point();

    public CrearLineaInvestigacionDialog(final JFrame parent, final Vicedecanato vicedecanato,final Departamento departamento) {
        super(parent, "Crear Línea de Investigación", true);
        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        getContentPane().setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setPreferredSize(new Dimension(400, 300));
        panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
        panel.setLayout(null);

        JPanel panelCampos = new JPanel();
        panelCampos.setBounds(20, 54, 360, 149);
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
       
        JLabel labelEncargado = new JLabel("Encargado");
        labelEncargado.setBounds(20, 80, maxLabelWidth, 30);
        panelCampos.add(labelEncargado);
        estiloLabel(labelEncargado);
        
        comboEncargado = new JComboBox<>();
        
        comboEncargado.addItem(null);

		for (Docente d : vicedecanato.getDocentes()) 
			comboEncargado.addItem(d);

		comboEncargado.setBounds(fieldX, 80, fieldWidth, 30);


		panelCampos.add(comboEncargado);
		estiloComboBox(comboEncargado);
        
        aplicarFiltroTexto(campoNombre, 25); 
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setBounds(20, 216, 360, 60);
        panelBotones.setBackground(new Color(30, 40, 50));
        
        JButton botonCrear = new JButton("Crear");
        JButton botonCancelar = new JButton("Cancelar");
        estiloBoton(botonCrear);
        estiloBoton(botonCancelar);
        botonCrear.setPreferredSize(new Dimension(120, 40));
        botonCancelar.setPreferredSize(new Dimension(120, 40));
        
        botonCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Docente seleccionado = (Docente) comboEncargado.getSelectedItem();

                if(!campoNombre.getText().isEmpty() && seleccionado!=null){
                	String nombre = campoNombre.getText().trim();

					try{

						departamento.crearLineaInvestigacion(nombre, seleccionado);
						MensajeDialog d = new MensajeDialog(parent, "La línea ha sido creada satisfactoriamente", Tipo.RETROALIMENTACION);
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

					else
						d = new MensajeDialog(parent, "Seleccione un docente", Tipo.RETROALIMENTACION);

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

        JLabel lblTitulo = new JLabel("Crear L\u00EDnea Inves.");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setBounds(131, 13, 164, 50);
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
   
    private void aplicarFiltroTexto(JTextField campo, final int maxChars) {
        AbstractDocument doc = (AbstractDocument) campo.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) return;
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
                if (newText.length() <= maxChars && newText.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]*$")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) return;
                String current = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = current.substring(0, offset) + text + current.substring(offset + length);
                if (newText.length() <= maxChars && newText.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]*$")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    
    private void estiloComboBox(JComboBox<Docente> comboBox) {
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
				        if (value == null) {
				            label.setText("Seleccione un docente...");
				        } else if (value instanceof Docente) {
				            label.setText(value.toString());
				        }
				        label.setForeground(Color.WHITE);
				        label.setBackground(isSelected ? new Color(30, 40, 50) : new Color(60, 70, 80));
				        return label;
				    }
				});
			}
		});

		comboBox.setSelectedIndex(0);
	}

    public boolean isConfirmado() {
        return confirmado;
    }
    
    public Docente getDocenteSeleccionado() {
        return (Docente) comboEncargado.getSelectedItem();
    }

    public String getNombreLinea() {
        return campoNombre.getText().trim();
    }
}