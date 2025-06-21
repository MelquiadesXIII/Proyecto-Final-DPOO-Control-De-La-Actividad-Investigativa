package Interfaz;

import Interfaz.MensajeDialog.Tipo;
import Logica.Articulo;
import Logica.GrupoImpacto;
import Logica.Investigador;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class CrearArticuloDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField campoTitulo, campoNumero, campoVolumen, campoAnio, campoPaginas;
    private JComboBox<GrupoImpacto> comboGrupo;
    private boolean confirmado = false;
    private Articulo articulo;
    private Point point = new Point();

    public CrearArticuloDialog(final JFrame parent, final Investigador autor) {
        super(parent, "Nuevo Artículo", true);
        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
        panel.setPreferredSize(new Dimension(400, 450));

        
        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(30, 40, 100, 30);
        estiloLabel(lblTitulo);
        panel.add(lblTitulo);

        campoTitulo = new JTextField();
        campoTitulo.setBounds(140, 40, 220, 30);
        estiloCampo(campoTitulo);
        panel.add(campoTitulo);

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(30, 90, 100, 30);
        estiloLabel(lblNumero);
        panel.add(lblNumero);

        campoNumero = new JTextField();
        campoNumero.setBounds(140, 90, 220, 30);
        estiloCampo(campoNumero);
        panel.add(campoNumero);

        JLabel lblVolumen = new JLabel("Volumen:");
        lblVolumen.setBounds(30, 140, 100, 30);
        estiloLabel(lblVolumen);
        panel.add(lblVolumen);

        campoVolumen = new JTextField();
        campoVolumen.setBounds(140, 140, 220, 30);
        estiloCampo(campoVolumen);
        panel.add(campoVolumen);

        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setBounds(30, 190, 100, 30);
        estiloLabel(lblAnio);
        panel.add(lblAnio);

        campoAnio = new JTextField();
        campoAnio.setBounds(140, 190, 220, 30);
        estiloCampo(campoAnio);
        panel.add(campoAnio);

        JLabel lblPaginas = new JLabel("Páginas:");
        lblPaginas.setBounds(30, 240, 100, 30);
        estiloLabel(lblPaginas);
        panel.add(lblPaginas);

        campoPaginas = new JTextField();
        campoPaginas.setBounds(140, 240, 220, 30);
        estiloCampo(campoPaginas);
        panel.add(campoPaginas);

        JLabel lblGrupo = new JLabel("Grupo Impacto:");
        lblGrupo.setBounds(30, 290, 120, 30);
        estiloLabel(lblGrupo);
        panel.add(lblGrupo);

        comboGrupo = new JComboBox<>(GrupoImpacto.values());
        comboGrupo.setBounds(140, 290, 220, 30);
        estiloComboBox(comboGrupo);
        panel.add(comboGrupo);

        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setBounds(20, 350, 360, 60);
        panelBotones.setBackground(new Color(30, 40, 50));

        JButton btnCrear = new JButton("Crear");
        JButton btnCancelar = new JButton("Cancelar");

        estiloBoton(btnCrear);
        estiloBoton(btnCancelar);

        panelBotones.add(btnCrear);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones);

        
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String titulo = campoTitulo.getText().trim();
                    int numero = Integer.parseInt(campoNumero.getText().trim());
                    int volumen = Integer.parseInt(campoVolumen.getText().trim());
                    String anio = campoAnio.getText().trim();
                    int paginas = Integer.parseInt(campoPaginas.getText().trim());
                    GrupoImpacto grupo = (GrupoImpacto) comboGrupo.getSelectedItem();

                    autor.crearArticulo(titulo, numero, volumen, anio, paginas, grupo);
                    confirmado = true;
                    dispose();
                } catch (RuntimeException r) {
                	MensajeDialog m = new MensajeDialog(parent, r.getMessage(), Tipo.RETROALIMENTACION);
                	m.setVisible(true);
                	
                }
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

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    private void estiloLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    private void estiloCampo(JTextField campo) {
        campo.setBackground(new Color(60, 70, 80));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void estiloComboBox(JComboBox<?> comboBox) {
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setBackground(new Color(60, 70, 80));
        comboBox.setForeground(Color.WHITE);
        comboBox.setOpaque(false);
        comboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void estiloBoton(JButton boton) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBackground(new Color(50, 60, 70));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setPreferredSize(new Dimension(120, 40));
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public Articulo getArticulo() {
        return articulo;
    }
}
