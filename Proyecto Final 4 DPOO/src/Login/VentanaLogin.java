package Login;

import javax.swing.*;

import Interfaz.MensajeDialog;
import Interfaz.MensajeDialog.Tipo;
import Interfaz.VentanaPrincipal;
import Logica.Vicedecanato;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private final Color COLOR_PRIMARY = new Color(30, 40, 50);
    private final Color COLOR_ACCENT = new Color(70, 80, 90); 
    private final Color COLOR_TEXT_FIELD_BORDER = new Color(150, 150, 150);
    private Vicedecanato vicedecanato;
    private RegistroUsuarios registro;

    public VentanaLogin(Vicedecanato vicedecanato) {
    	
    	this.vicedecanato = vicedecanato;
    	registro = new RegistroUsuarios();
    	
        inicializarConfiguracionUI();
        crearPanelLogin();
        setVisible(true);
    }

    private void inicializarConfiguracionUI() {
        setTitle("Iniciar Sesión");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);
    }

    private void crearPanelLogin() {
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(Color.WHITE);
        panelIzquierdo.setLayout(new GridBagLayout());
        panelIzquierdo.setPreferredSize(new Dimension(400, getHeight())); 
        getContentPane().add(panelIzquierdo, BorderLayout.WEST);
        try{
			setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Iconos\\IconoSIGIP.png"));
		}catch(Exception e){
			System.out.println("aguacate");
		}

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Logo (Placeholder - as per instruction, no actual icon)
        /*JLabel labelLogo = new JLabel("LOGO");
        labelLogo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        labelLogo.setForeground(new Color(0, 150, 200)); // A vibrant blue for the logo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panelIzquierdo.add(labelLogo, gbc);*/

       
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        JLabel labelIniciarSesion = new JLabel("INICIAR SESIÓN");
        labelIniciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 28));
        labelIniciarSesion.setForeground(Color.BLACK);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelIzquierdo.add(labelIniciarSesion, gbc);

        JLabel labelUsuario = new JLabel("USUARIO");
        labelUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
        labelUsuario.setForeground(Color.BLACK);
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 2;
        panelIzquierdo.add(labelUsuario, gbc);

        campoUsuario = new JTextField(20);
        campoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoUsuario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_TEXT_FIELD_BORDER)); // Underline effect
        campoUsuario.setToolTipText("Ingrese su nombre de usuario");
        gbc.gridy = 4;
        panelIzquierdo.add(campoUsuario, gbc);

        JLabel labelContrasena = new JLabel("CONTRASEÑA");
        labelContrasena.setFont(new Font("Segoe UI", Font.BOLD, 16));
        labelContrasena.setForeground(Color.BLACK);
        gbc.gridy = 5;
        panelIzquierdo.add(labelContrasena, gbc);

        campoContrasena = new JPasswordField(20);
        campoContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoContrasena.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_TEXT_FIELD_BORDER)); // Underline effect
        gbc.gridy = 6;
        panelIzquierdo.add(campoContrasena, gbc);

        JPanel panelBotonesLogin = new JPanel(new GridBagLayout()); // Use a new panel for the buttons
        panelBotonesLogin.setBackground(Color.WHITE); // Match background with parent panel
        
        final JButton botonEntrar = new JButton("ENTRAR");
        botonEntrar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botonEntrar.setBackground(COLOR_PRIMARY);
        botonEntrar.setForeground(Color.WHITE);
        botonEntrar.setFocusPainted(false);
        botonEntrar.setBorderPainted(false);
        botonEntrar.setPreferredSize(new Dimension(120, 40));
        botonEntrar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                botonEntrar.setBackground(COLOR_ACCENT);
            }

            public void mouseExited(MouseEvent e) {
                botonEntrar.setBackground(COLOR_PRIMARY);
            }
        });
        botonEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = campoUsuario.getText();
                String contrasena = new String(campoContrasena.getPassword());
                MensajeDialog m;

                if (registro.verificarCredenciales(nombreUsuario, contrasena)) {
                    m = new MensajeDialog(VentanaLogin.this, "Ha iniciado sesión correctamente", Tipo.RETROALIMENTACION);
                    m.setVisible(true);
                    dispose();
                    new VentanaPrincipal(vicedecanato);
                    
                } else if(nombreUsuario.trim().isEmpty() && contrasena.trim().isEmpty()){
                	m = new MensajeDialog(VentanaLogin.this, "Todos los campos están vacíos", Tipo.RETROALIMENTACION);
                    m.setVisible(true);
                	
                }else if(nombreUsuario.trim().isEmpty() || contrasena.trim().isEmpty()){
                	m = new MensajeDialog(VentanaLogin.this, "Termine de rellenar los campos", Tipo.RETROALIMENTACION);
                    m.setVisible(true);
                	
                }else {
                    m = new MensajeDialog(VentanaLogin.this, "El usuario no existe", Tipo.RETROALIMENTACION);
                    m.setVisible(true);
                }
            }
        });
        
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.insets = new Insets(0, 5, 0, 5);
        gbcButtons.gridx = 0;
        gbcButtons.gridy = 0;
        panelBotonesLogin.add(botonEntrar, gbcButtons);

        final JButton botonSalir = new JButton("SALIR");
        botonSalir.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botonSalir.setBackground(COLOR_PRIMARY);
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setFocusPainted(false);
        botonSalir.setBorderPainted(false);
        botonSalir.setPreferredSize(new Dimension(120, 40));
        botonSalir.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                botonSalir.setBackground(COLOR_ACCENT);
            }

            public void mouseExited(MouseEvent e) {
                botonSalir.setBackground(COLOR_PRIMARY);
            }
        });
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                MensajeDialog dialog = new MensajeDialog(VentanaLogin.this, "¿Desea salir de la aplicación?", Tipo.CONFIRMACION);
                dialog.setVisible(true);
                if (dialog.isConfirmado()) {
                    System.exit(0);
                }
            }
        });
        gbcButtons.gridx = 1;
        gbcButtons.gridy = 0;
        panelBotonesLogin.add(botonSalir, gbcButtons);

        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER; 
        panelIzquierdo.add(panelBotonesLogin, gbc);
        JLabel labelNoCuenta = new JLabel("¿No tienes cuenta? ");
        labelNoCuenta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelNoCuenta.setForeground(Color.BLACK);
       
        final JButton botonRegistrarse = new JButton("Regístrate");
        botonRegistrarse.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botonRegistrarse.setForeground(new Color(0, 150, 200));
        botonRegistrarse.setBackground(Color.WHITE);
        botonRegistrarse.setBorderPainted(false);
        botonRegistrarse.setFocusPainted(false);
        botonRegistrarse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonRegistrarse.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                botonRegistrarse.setForeground(new Color(0, 100, 150));
            }

            public void mouseExited(MouseEvent e) {
                botonRegistrarse.setForeground(new Color(0, 150, 200));
            }
        });
        botonRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	RegistrarUsuarioDialog r = new RegistrarUsuarioDialog(VentanaLogin.this, registro);
            	r.setVisible(true);
            }
        });
        
        JPanel panelRegistro = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelRegistro.setBackground(Color.WHITE);
        panelRegistro.add(labelNoCuenta);
        panelRegistro.add(botonRegistrarse);

        gbc.gridy = 8;
        gbc.insets = new Insets(5, 10, 10, 10);
        panelIzquierdo.add(panelRegistro, gbc);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(COLOR_PRIMARY);
        panelDerecho.setLayout(new GridBagLayout()); 
        getContentPane().add(panelDerecho, BorderLayout.CENTER);

        JLabel labelNombreEmpresa = new JLabel("SIGIP");
        labelNombreEmpresa.setFont(new Font("Segoe UI", Font.BOLD, 24));
        labelNombreEmpresa.setForeground(Color.WHITE);
        GridBagConstraints gbcRight = new GridBagConstraints();
        gbcRight.gridx = 0;
        gbcRight.gridy = 0;
        gbcRight.anchor = GridBagConstraints.CENTER;
        panelDerecho.add(labelNombreEmpresa, gbcRight);
    }
}