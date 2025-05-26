package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MensajeDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private Point point = new Point();
    private boolean confirmado = false;

    
    public enum Tipo {
        RETROALIMENTACION,
        CONFIRMACION
    }

    public MensajeDialog(JFrame parent, String mensaje, final Tipo tipo) {
        super(parent, "Mensaje", true);
        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setOpaque(true);
        panel.setPreferredSize(new Dimension(400, 200)); 

        JLabel mensajeLabel = new JLabel(mensaje);
        mensajeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mensajeLabel.setForeground(Color.WHITE);
        mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        panel.add(mensajeLabel, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setBackground(new Color(30, 40, 50));
        panelBotones.setOpaque(true);

        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");

        estiloBoton(botonAceptar);
        estiloBoton(botonCancelar);

        botonAceptar.setPreferredSize(new Dimension(120, 40));
        botonCancelar.setPreferredSize(new Dimension(120, 40));

        botonCancelar.setVisible(tipo == Tipo.CONFIRMACION);

        botonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tipo == Tipo.CONFIRMACION) {
                    confirmado = true;
                }
                dispose();
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panelBotones.add(botonAceptar);
        if (botonCancelar.isVisible()) panelBotones.add(botonCancelar);
        panel.add(panelBotones, BorderLayout.SOUTH);

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

            public void mouseMoved(MouseEvent e) {
               
            }
        };

        panel.addMouseListener(mouseAdapter);
        panel.addMouseMotionListener(motionListener);

        add(panel);
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

    public boolean isConfirmado() {
        return confirmado;
    }
    
    
}