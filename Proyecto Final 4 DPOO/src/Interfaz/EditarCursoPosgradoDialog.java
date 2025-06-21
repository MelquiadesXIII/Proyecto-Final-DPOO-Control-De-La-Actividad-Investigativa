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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import Interfaz.MensajeDialog.Tipo;
import Logica.CategoriaCientifica;
import Logica.CursoPosgrado;
import Logica.Departamento;
import Logica.Docente;

public class EditarCursoPosgradoDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField campoTema;
    private JTextArea areaObjetivos;
    private JTextField campoCreditos;
    private JComboBox<Docente> comboProfesores;
    private boolean confirmado = false;
    private Point point = new Point();
    private Departamento depto;

    public EditarCursoPosgradoDialog(final JFrame parent, final Departamento depto, final CursoPosgrado curso) {
        super(parent, "Editar Curso de Posgrado", true);
        this.depto = depto;
        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setPreferredSize(new Dimension(500, 450)); 
        panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
        panel.setLayout(null);

        JPanel panelCampos = new JPanel();
        panelCampos.setBounds(20, 80, 460, 250); 
        panelCampos.setBackground(new Color(30, 40, 50));
        panelCampos.setLayout(null);
        panel.add(panelCampos);

        int maxLabelWidth = 140;
        int fieldX = 20 + maxLabelWidth + 10;
        int fieldWidth = 460 - fieldX - 20;

        JLabel labelTema = new JLabel("Tema del curso:");
        labelTema.setBounds(20, 20, maxLabelWidth, 30);
        panelCampos.add(labelTema);
        estiloLabel(labelTema);

        campoTema = new JTextField(curso.getTema());
        campoTema.setBounds(fieldX, 20, fieldWidth, 30);
        panelCampos.add(campoTema);
        estiloCampo(campoTema);
        aplicarFiltroTexto(campoTema, 25);

        JLabel labelObjetivos = new JLabel("Objetivos:");
        labelObjetivos.setBounds(20, 60, maxLabelWidth, 30);
        panelCampos.add(labelObjetivos);
        estiloLabel(labelObjetivos);

        areaObjetivos = new JTextArea(String.join("\n", curso.getObjetivos()));
        areaObjetivos.setLineWrap(true);
        areaObjetivos.setWrapStyleWord(true);
        JScrollPane scrollObjetivos = new JScrollPane(areaObjetivos);
        scrollObjetivos.setBounds(fieldX, 60, fieldWidth, 80);
        scrollObjetivos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelCampos.add(scrollObjetivos);
        estiloCampo(areaObjetivos);
        aplicarFiltroTextoArea(areaObjetivos, 200);

        JLabel labelCreditos = new JLabel("Créditos:");
        labelCreditos.setBounds(20, 150, maxLabelWidth, 30);
        panelCampos.add(labelCreditos);
        estiloLabel(labelCreditos);

        campoCreditos = new JTextField(String.valueOf(curso.getCantCreditos()));
        campoCreditos.setBounds(fieldX, 150, fieldWidth, 30);
        panelCampos.add(campoCreditos);
        estiloCampo(campoCreditos);
        aplicarFiltroNumerico(campoCreditos, 2);

        JLabel labelProfesor = new JLabel("Profesor (Doctor):");
        labelProfesor.setBounds(20, 190, maxLabelWidth, 30);
        panelCampos.add(labelProfesor);
        estiloLabel(labelProfesor);

        comboProfesores = new JComboBox<>();
        comboProfesores.setBounds(fieldX, 190, fieldWidth, 30);
        cargarProfesoresDoctores();
        comboProfesores.setSelectedItem(curso.getProfesor());
        panelCampos.add(comboProfesores);
        estiloComboBoxDocente(comboProfesores);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setBounds(20, 340, 460, 60);
        panelBotones.setBackground(new Color(30, 40, 50));

        JButton botonGuardar = new JButton("Guardar");
        JButton botonCancelar = new JButton("Cancelar");
        estiloBoton(botonGuardar);
        estiloBoton(botonCancelar);
        botonGuardar.setPreferredSize(new Dimension(120, 40));
        botonCancelar.setPreferredSize(new Dimension(120, 40));

        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String tema = campoTema.getText();
                    String objetivosTexto = areaObjetivos.getText();
                    int creditos = Integer.parseInt(campoCreditos.getText());
                    Docente profesor = (Docente) comboProfesores.getSelectedItem();

                    ArrayList<String> objetivosList = new ArrayList<>();
                    for (String objetivo : objetivosTexto.split("\\n")) {
                        if (!objetivo.trim().isEmpty()) {
                            objetivosList.add(objetivo);
                        }
                    }

                    curso.setTema(tema);
                    curso.setObjetivos(objetivosList);
                    curso.setCantCreditos(creditos);
                    curso.setProfesor(profesor);
                    
                    MensajeDialog d = new MensajeDialog(parent, "Curso actualizado exitosamente", Tipo.RETROALIMENTACION);
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

        panelBotones.add(botonGuardar);
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

        JLabel lblTitulo = new JLabel("Editar Curso de Posgrado");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        int tituloWidth = 300;
        int tituloX = (500 - tituloWidth) / 2;
        lblTitulo.setBounds(tituloX, 35, tituloWidth, 50);
        panel.add(lblTitulo);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void cargarProfesoresDoctores() {
        for (Docente docente : depto.getDocentes()) {
            if (docente.getCatCientifica() == CategoriaCientifica.DOCTOR) {
                comboProfesores.addItem(docente);
            }
        }
    }

    private void estiloBoton(final JButton boton) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBackground(new Color(50, 60, 70));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(70, 80, 90));
            }
            public void mouseExited(MouseEvent e) {
                boton.setBackground(new Color(50, 60, 70));
            }
        });
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

    private void estiloCampo(JTextArea area) {
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setBackground(new Color(60, 70, 80));
        area.setForeground(Color.WHITE);
        area.setCaretColor(Color.WHITE);
        area.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(80, 90, 100)),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }

    private void estiloComboBoxDocente(JComboBox<Docente> combo) {
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        combo.setBackground(new Color(60, 70, 80));
        combo.setForeground(Color.WHITE);
        combo.setRenderer(new DocenteComboBoxRenderer());
    }

    public void aplicarFiltroTextoArea(JTextArea area, final int maxChars) {
        AbstractDocument doc = (AbstractDocument) area.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) 
                throws BadLocationException {
                if (string != null) {
                    String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                    String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
                    if (newText.length() <= maxChars && newText.matches("^[\\p{L}\\s\\n]*$")) {
                        super.insertString(fb, offset, string, attr);
                    }
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
                throws BadLocationException {
                if (text != null) {
                    String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                    String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                    if (newText.length() <= maxChars && newText.matches("^[\\p{L}\\s\\n]*$")) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                } else {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    public void aplicarFiltroTexto(JTextField campo, final int maxChars) {
        AbstractDocument doc = (AbstractDocument) campo.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) 
                throws BadLocationException {
                if (string != null) {
                    String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                    String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
                    if (newText.length() <= maxChars && newText.matches("^[\\p{L}\\s]*$")) {
                        super.insertString(fb, offset, string, attr);
                    }
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
                throws BadLocationException {
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

    public void aplicarFiltroNumerico(JTextField campo, final int maxChars) {
        AbstractDocument doc = (AbstractDocument) campo.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) 
                throws BadLocationException {
                if (string != null) {
                    String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
                    if (newText.length() <= maxChars && string.matches("\\d*")) {
                        super.insertString(fb, offset, string, attr);
                    }
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
                throws BadLocationException {
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

    public boolean isConfirmado() {
        return confirmado;
    }
}