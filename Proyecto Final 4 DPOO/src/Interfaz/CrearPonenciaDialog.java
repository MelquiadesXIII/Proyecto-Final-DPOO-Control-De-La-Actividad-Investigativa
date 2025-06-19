package Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Logica.PonenciaEvento;

public class CrearPonenciaDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    private JTextField txtNombre, txtLugar, txtISBN;
    private JComboBox<Integer> comboDia;
    private JComboBox<String> comboMes;
    private JComboBox<Integer> comboAnio;

    private boolean confirmado = false;
    private PonenciaEvento ponencia;
    private Point point = new Point();

    public CrearPonenciaDialog(final JFrame parent) {
        super(parent, "Crear Ponencia", true);
        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
        panel.setPreferredSize(new Dimension(400, 400));
        panel.setLayout(null);

        JPanel panelCampos = new JPanel(null);
        panelCampos.setBackground(new Color(30, 40, 50));
        panelCampos.setBounds(20, 60, 360, 260);
        panel.add(panelCampos);

        // Etiquetas y campos
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 10, 100, 30);
        estiloLabel(lblNombre);
        panelCampos.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 10, 220, 30);
        estiloCampo(txtNombre);
        panelCampos.add(txtNombre);

        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setBounds(20, 50, 100, 30);
        estiloLabel(lblLugar);
        panelCampos.add(lblLugar);

        txtLugar = new JTextField();
        txtLugar.setBounds(120, 50, 220, 30);
        estiloCampo(txtLugar);
        panelCampos.add(txtLugar);

        JLabel lblISBN = new JLabel("ISBN:");
        lblISBN.setBounds(20, 90, 100, 30);
        estiloLabel(lblISBN);
        panelCampos.add(lblISBN);

        txtISBN = new JTextField();
        txtISBN.setBounds(120, 90, 220, 30);
        estiloCampo(txtISBN);
        panelCampos.add(txtISBN);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(20, 130, 100, 30);
        estiloLabel(lblFecha);
        panelCampos.add(lblFecha);

        comboDia = new JComboBox<>();
        for (int i = 1; i <= 31; i++) comboDia.addItem(i);
        comboDia.setBounds(120, 130, 60, 30);
        estiloComboBox(comboDia);
        panelCampos.add(comboDia);

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        comboMes = new JComboBox<>(meses);
        comboMes.setBounds(190, 130, 100, 30);
        estiloComboBox(comboMes);
        panelCampos.add(comboMes);

        comboAnio = new JComboBox<>();
        int anioActual = java.time.Year.now().getValue();
        for (int i = anioActual; i >= 1900; i--) comboAnio.addItem(i);
        comboAnio.setBounds(300, 130, 60, 30);
        estiloComboBox(comboAnio);
        panelCampos.add(comboAnio);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBounds(20, 330, 360, 50);
        panelBotones.setBackground(new Color(30, 40, 50));

        JButton btnAceptar = new JButton("Crear");
        estiloBoton(btnAceptar);
        btnAceptar.setPreferredSize(new Dimension(120, 40));

        JButton btnCancelar = new JButton("Cancelar");
        estiloBoton(btnCancelar);
        btnCancelar.setPreferredSize(new Dimension(120, 40));

        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones);

        // Acción de crear
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String lugar = txtLugar.getText();
                    String isbn = txtISBN.getText();

                    int dia = (Integer) comboDia.getSelectedItem();
                    int mes = comboMes.getSelectedIndex() + 1;
                    int anio = (Integer) comboAnio.getSelectedItem();

                    Calendar cal = Calendar.getInstance();
                    cal.set(anio, mes - 1, dia);
                    Date fecha = (Date) cal.getTime();

                    ponencia = new PonenciaEvento(nombre, convertirDateALocalDate(fecha), lugar, isbn);
                    confirmado = true;
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(parent, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Título
        JLabel lblTitulo = new JLabel("Crear Ponencia");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setBounds(130, 15, 200, 30);
        panel.add(lblTitulo);

        // Permitir mover el diálogo
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

    private void estiloCampo(JTextField campo) {
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBackground(new Color(60, 70, 80));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void estiloComboBox(JComboBox<?> comboBox) {
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setBackground(new Color(60, 70, 80));
        comboBox.setForeground(Color.WHITE);
        comboBox.setOpaque(false);
        comboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void estiloLabel(JLabel label) {
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
    }

    private void estiloBoton(JButton boton) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBackground(new Color(50, 60, 70));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public PonenciaEvento getPonencia() {
        return ponencia;
    }

    private LocalDate convertirDateALocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
