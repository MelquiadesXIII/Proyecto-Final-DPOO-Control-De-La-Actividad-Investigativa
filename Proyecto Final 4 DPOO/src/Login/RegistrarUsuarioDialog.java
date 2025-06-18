package Login;

import javax.swing.*;
import Interfaz.MensajeDialog;
import Interfaz.MensajeDialog.Tipo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarUsuarioDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField campoUsuario;
	private JPasswordField campoContrasena;
	private JPasswordField campoConfirmarContrasena; 
	private final Color COLOR_PRIMARY = new Color(30, 40, 50);
	private final Color COLOR_ACCENT = new Color(70, 80, 90);
	private final Color COLOR_TEXT_FIELD_BORDER = new Color(150, 150, 150);
	private RegistroUsuarios registro;
	private VentanaLogin parent;


	public RegistrarUsuarioDialog(VentanaLogin owner, RegistroUsuarios registroUsuarios) {
		super(owner, "Registrar Usuario", true); 
		this.registro = registroUsuarios; 
		this.parent = owner;
		parent.setVisible(false);

		inicializarConfiguracionUI();
		crearPanelRegistro();
	}

	private void inicializarConfiguracionUI() {
		setSize(800, 550); 
		setLocationRelativeTo(parent); 
		setResizable(false);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.WHITE);
		try {
			setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Iconos\\IconoSIGIP.png"));
		} catch (Exception e) {
			System.out.println("Error al cargar el icono: " + e.getMessage());
		}
	}

	private void crearPanelRegistro() {
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setBackground(Color.WHITE);
		panelIzquierdo.setLayout(new GridBagLayout());
		panelIzquierdo.setPreferredSize(new Dimension(400, getHeight()));
		add(panelIzquierdo, BorderLayout.WEST);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridy = 0;
		gbc.weighty = 0.1;
		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 0)), gbc);

		JLabel labelRegistrarUsuario = new JLabel("REGISTRAR USUARIO");
		labelRegistrarUsuario.setFont(new Font("Segoe UI", Font.BOLD, 28));
		labelRegistrarUsuario.setForeground(Color.BLACK);
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelIzquierdo.add(labelRegistrarUsuario, gbc);

		JLabel labelUsuario = new JLabel("NOMBRE DE USUARIO");
		labelUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		labelUsuario.setForeground(Color.BLACK);
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = 2;
		panelIzquierdo.add(labelUsuario, gbc);

		campoUsuario = new JTextField(20);
		campoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		campoUsuario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_TEXT_FIELD_BORDER));
		campoUsuario.setToolTipText("Ingrese el nombre de usuario");
		gbc.gridy = 3;
		panelIzquierdo.add(campoUsuario, gbc);

		JLabel labelContrasena = new JLabel("CONTRASEÑA");
		labelContrasena.setFont(new Font("Segoe UI", Font.BOLD, 16));
		labelContrasena.setForeground(Color.BLACK);
		gbc.gridy = 4;
		panelIzquierdo.add(labelContrasena, gbc);

		campoContrasena = new JPasswordField(20);
		campoContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		campoContrasena.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_TEXT_FIELD_BORDER));
		gbc.gridy = 5;
		panelIzquierdo.add(campoContrasena, gbc);

		JLabel labelConfirmarContrasena = new JLabel("CONFIRMAR CONTRASEÑA");
		labelConfirmarContrasena.setFont(new Font("Segoe UI", Font.BOLD, 16));
		labelConfirmarContrasena.setForeground(Color.BLACK);
		gbc.gridy = 6;
		panelIzquierdo.add(labelConfirmarContrasena, gbc);

		campoConfirmarContrasena = new JPasswordField(20);
		campoConfirmarContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		campoConfirmarContrasena.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_TEXT_FIELD_BORDER));
		gbc.gridy = 7;
		panelIzquierdo.add(campoConfirmarContrasena, gbc);

		JPanel panelBotonesRegistro = new JPanel(new GridBagLayout());
		panelBotonesRegistro.setBackground(Color.WHITE);

		final JButton botonRegistrar = new JButton("REGISTRAR"); 
		botonRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonRegistrar.setBackground(COLOR_PRIMARY);
		botonRegistrar.setForeground(Color.WHITE);
		botonRegistrar.setFocusPainted(false);
		botonRegistrar.setBorderPainted(false);
		botonRegistrar.setPreferredSize(new Dimension(120, 40));
		botonRegistrar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				botonRegistrar.setBackground(COLOR_ACCENT);
			}

			public void mouseExited(MouseEvent e) {
				botonRegistrar.setBackground(COLOR_PRIMARY);
			}
		});
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = campoUsuario.getText();
				String contrasena = new String(campoContrasena.getPassword());
				String confirmarContrasena = new String(campoConfirmarContrasena.getPassword());

				try{

					Usuario u = new Usuario(nombreUsuario, contrasena);

					if(registro.clavesIguales(contrasena, confirmarContrasena)){

						if(registro.nuevoUsuarioValido(u)){
							registro.guardarUsuario(u);
							MensajeDialog m = new MensajeDialog(parent, "El usuario ha sido registrado exitosamente", Tipo.RETROALIMENTACION);
							m.setVisible(true);
							dispose();
							parent.setVisible(true);

						}else{
							MensajeDialog m = new MensajeDialog(parent, "El usuario ya existe", Tipo.RETROALIMENTACION);
							m.setVisible(true);
						}

					}else{
						MensajeDialog m = new MensajeDialog(parent, "Las contraseñas no coinciden", Tipo.RETROALIMENTACION);
						m.setVisible(true);
					}

				}catch(RuntimeException r){
					MensajeDialog m = new MensajeDialog(parent, r.getMessage(), Tipo.RETROALIMENTACION);
					m.setVisible(true);
				}
			}
		});

		GridBagConstraints gbcButtons = new GridBagConstraints();
		gbcButtons.insets = new Insets(0, 5, 0, 5);
		gbcButtons.gridx = 0;
		gbcButtons.gridy = 0;
		panelBotonesRegistro.add(botonRegistrar, gbcButtons);

		final JButton botonCancelar = new JButton("CANCELAR");
		botonCancelar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonCancelar.setBackground(COLOR_PRIMARY);
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setFocusPainted(false);
		botonCancelar.setBorderPainted(false);
		botonCancelar.setPreferredSize(new Dimension(120, 40));
		botonCancelar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				botonCancelar.setBackground(COLOR_ACCENT);
			}

			public void mouseExited(MouseEvent e) {
				botonCancelar.setBackground(COLOR_PRIMARY);
			}
		});
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				parent.setVisible(true);
			}
		});
		gbcButtons.gridx = 1;
		gbcButtons.gridy = 0;
		panelBotonesRegistro.add(botonCancelar, gbcButtons);

		gbc.gridy = 8;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(30, 10, 10, 10);
		gbc.anchor = GridBagConstraints.CENTER;
		panelIzquierdo.add(panelBotonesRegistro, gbc);

		JPanel panelDerecho = new JPanel();
		panelDerecho.setBackground(COLOR_PRIMARY);
		panelDerecho.setLayout(new GridBagLayout());
		add(panelDerecho, BorderLayout.CENTER);

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
