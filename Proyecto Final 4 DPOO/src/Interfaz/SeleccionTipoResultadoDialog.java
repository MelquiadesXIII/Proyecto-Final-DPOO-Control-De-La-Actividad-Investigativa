package Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

import Logica.*;

public class SeleccionTipoResultadoDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    private JComboBox<String> comboTipo;
    private JComboBox<Investigador> comboAutores;
    private boolean confirmado = false;
    private Point point = new Point();

    public SeleccionTipoResultadoDialog(final JFrame parent, final ArrayList<Estudiante> listaEstudiantes, final ArrayList<Docente> listaDocentes) {
        super(parent, "Seleccionar Tipo de Resultado", true);
        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        setSize(400, 230);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
        setContentPane(panel);

        JLabel lblTitulo = new JLabel("Seleccionar Resultado");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(100, 10, 250, 30);
        panel.add(lblTitulo);

        JLabel lblTipo = new JLabel("Tipo de resultado:");
        lblTipo.setBounds(30, 60, 130, 25);
        estiloLabel(lblTipo);
        panel.add(lblTipo);

        comboTipo = new JComboBox<>(new String[]{"Ponencia de Evento", "Artículo", "Capítulo de Libro"});
        estiloComboBox(comboTipo);
        comboTipo.setBounds(170, 60, 180, 30);
        panel.add(comboTipo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(30, 100, 130, 25);
        estiloLabel(lblAutor);
        panel.add(lblAutor);

        comboAutores = new JComboBox<>();
        for (Estudiante est : listaEstudiantes) {
            comboAutores.addItem(est);
        }
        for (Docente doc : listaDocentes) {
            comboAutores.addItem(doc);
        }
        estiloComboBox(comboAutores);
        comboAutores.setBounds(170, 100, 180, 30);
        panel.add(comboAutores);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(70, 160, 110, 35);
        estiloBoton(btnAceptar);
        panel.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(220, 160, 110, 35);
        estiloBoton(btnCancelar);
        panel.add(btnCancelar);

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                dispose();
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

    private void estiloComboBox(final JComboBox<?> comboBox) {
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
                    public Component getListCellRendererComponent(final JList<?> list, final Object value, final int index, final boolean isSelected, final boolean cellHasFocus) {
                        final JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                        if (value instanceof Investigador) {
                            final Investigador inv = (Investigador) value;
                            label.setText(inv.getNombre() + " " + inv.getApellidos());
                        } else if (value != null) {
                            label.setText(value.toString());
                        } else {
                            label.setText("");
                        }

                        label.setForeground(Color.WHITE);
                        label.setBackground(isSelected ? new Color(30, 40, 50) : new Color(60, 70, 80));
                        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                        return label;
                    }
                });
            }
        });

        if (comboBox.getItemCount() > 0) {
            comboBox.setSelectedIndex(0);
        }
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public String getTipoSeleccionado() {
        return (String) comboTipo.getSelectedItem();
    }

    public Investigador getInvestigadorSeleccionado() {
        return (Investigador) comboAutores.getSelectedItem();
    }
}
