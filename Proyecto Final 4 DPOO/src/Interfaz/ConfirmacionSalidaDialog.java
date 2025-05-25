package Interfaz;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class ConfirmacionSalidaDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private Point point = new Point();
    private boolean confirmado = false;

    public ConfirmacionSalidaDialog(JFrame parent) {
        super(parent, "Confirmación", true);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0)); 

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setPreferredSize(new Dimension(350, 150));

        JLabel mensaje = new JLabel("¿Está seguro que desea salir?");
        mensaje.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mensaje.setForeground(Color.WHITE);
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(mensaje, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(new Color(30, 40, 50));

        JButton botonSi = new JButton("Sí");
        JButton botonNo = new JButton("No");

        estiloBoton(botonSi);
        estiloBoton(botonNo);

        botonSi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                dispose();
            }
        });

        botonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = false;
                dispose();
            }
        });

        panelBotones.add(botonSi);
        panelBotones.add(botonNo);
        panel.add(panelBotones, BorderLayout.SOUTH);
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
        });
        
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
        boton.setPreferredSize(new Dimension(80, 30));
    }

    public boolean isConfirmado() {
        return confirmado;
    }
    
 
}