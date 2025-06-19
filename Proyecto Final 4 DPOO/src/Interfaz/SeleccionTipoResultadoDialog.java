package Interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

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
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

import Logica.Departamento;
import Logica.Estudiante;

public class SeleccionTipoResultadoDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboTipo;
    private JComboBox<Estudiante> comboEstudiantes;
    private boolean confirmado = false;
    private Point point = new Point();

    public SeleccionTipoResultadoDialog(final JFrame parent,final ArrayList<Estudiante> listaEstudiantes) {
        super(parent, "Seleccionar Tipo de Resultado", true);
        setSize(400, 200);
        setLocationRelativeTo(parent);
        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
        panel.setLayout(null);
        
        JLabel lblTitulo = new JLabel("Seleccionar Resultado");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(100, 0, 250, 50);
        panel.add(lblTitulo);
        
        JLabel lblTipo = new JLabel("Tipo de resultado:");
        lblTipo.setBounds(24, 30, 150, 30);
        panel.add(lblTipo);
        estiloLabel(lblTipo);
        
        comboTipo.setBounds(180, 30, 180, 30);
        panel.add(comboTipo);
        
        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(24, 80, 150, 30);
        panel.add(lblAutor);
        estiloLabel(lblAutor);

        comboEstudiantes.setBounds(180, 80, 180, 30);
        panel.add(comboEstudiantes);
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setBounds(20, 130, 360, 60);
        panelBotones.setBackground(new Color(30, 40, 50));

        String[] tipos = {"Ponencia de Evento", "Artículo", "Capítulo de Libro"};
        comboTipo = new JComboBox<>(tipos);
        estiloComboBox(comboTipo);

        comboEstudiantes = new JComboBox<>();
        for (Estudiante e : listaEstudiantes) {
            comboEstudiantes.addItem(e);
        }
        estiloComboBox(comboEstudiantes);

        JPanel panelCentral = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCentral.add(new JLabel("Tipo de resultado:"));
        panelCentral.add(comboTipo);
        panelCentral.add(new JLabel("Autor:"));
        panelCentral.add(comboEstudiantes);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setPreferredSize(new Dimension(120, 40));
        estiloBoton(btnAceptar);
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                dispose();
            }
        });
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setPreferredSize(new Dimension(120, 40));
        estiloBoton(btnCancelar);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
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

        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);

        add(panelCentral, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
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
    
    private void estiloComboBox(JComboBox<?> comboBox) {
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

    public boolean isConfirmado() {
        return confirmado;
    }

    public String getTipoSeleccionado() {
        return (String) comboTipo.getSelectedItem();
    }

    public Estudiante getEstudianteSeleccionado() {
        return (Estudiante) comboEstudiantes.getSelectedItem();
    }
}
