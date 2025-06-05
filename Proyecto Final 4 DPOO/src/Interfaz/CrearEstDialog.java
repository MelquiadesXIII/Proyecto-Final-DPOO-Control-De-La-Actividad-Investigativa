package Interfaz;

import javax.swing.*;

import Interfaz.MensajeDialog.Tipo;
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

    
    public CrearEstDialog(final JFrame parent, final Vicedecanato vicedecanato) {
    	
        super(parent, "Crear Estudiante", true);
        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        getContentPane().setLayout(new BorderLayout());

        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setPreferredSize(new Dimension(400, 400));

        
        JPanel panelCampos = new JPanel();
        panelCampos.setBounds(20, 65, 360, 249);
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

        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setBounds(20, 327, 360, 60);
        panelBotones.setBackground(new Color(30, 40, 50));

        JButton botonCrear = new JButton("Crear");
        JButton botonCancelar = new JButton("Cancelar");

        estiloBoton(botonCrear);
        estiloBoton(botonCancelar);

        botonCrear.setPreferredSize(new Dimension(120, 40));
        botonCancelar.setPreferredSize(new Dimension(120, 40));

        botonCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String nombre = getName();
            	String apellidos = getApellidos();
            	String grupo = getGrupo();
            	
            	try{
            		
            		vicedecanato.crearEstudiante(nombre, apellidos, grupo, depto);
            		
            	}catch(RuntimeException r){
            		
            		MensajeDialog d = new MensajeDialog(parent, r.getMessage(), Tipo.RETROALIMENTACION);
            		d.setVisible(true);
            	}
            	
            	
                confirmado = true;
                dispose();
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