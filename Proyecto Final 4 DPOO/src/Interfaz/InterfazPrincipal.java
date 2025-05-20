package Interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	public InterfazPrincipal() {
		getContentPane().setBackground(Color.WHITE);
		
		
		setTitle("Vicedecanato de Investigacion");
		setResizable(false);
		setSize(800, 600);;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(Color.WHITE);
		panelTitulo.setBorder(new LineBorder(Color.BLACK,2));
		getContentPane().add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel titulo = new JLabel("Vicedecanato - Facultad de Ingenier\u00EDa Inform\u00E1tica");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		titulo.setBounds(0, 0, 794, 54);
		panelTitulo.add(titulo);
		
		JPanel panelBarraNav = new JPanel();
		panelBarraNav.setBackground(Color.WHITE);
		panelBarraNav.setBorder(new LineBorder(Color.BLACK,2));
		panelBarraNav.setBounds(0, 55, 794, 47);
		panelTitulo.add(panelBarraNav);
		panelBarraNav.setLayout(null);
		
		final JPanel panelContenido = new JPanel();
		panelContenido.setBounds(0, 100, 794, 465);
		panelContenido.setBorder(new LineBorder(Color.BLACK,0));
		panelTitulo.add(panelContenido);
		panelContenido.setLayout(new CardLayout(0, 0));
		
		JPanel panelInicio = new JPanel();
		panelContenido.add(panelInicio, "panelInicio");
		panelInicio.setBorder(new LineBorder(Color.BLACK,0));
		panelInicio.setLayout(null);
		
		JPanel panelDocentes = new JPanel();
		panelContenido.add(panelDocentes, "panelDocentes");
		panelDocentes.setBorder(new LineBorder(Color.BLACK,0));
		panelDocentes.setLayout(null);
		
		JLabel lblListaDeDocentes = new JLabel("Lista de Docentes");
		lblListaDeDocentes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblListaDeDocentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeDocentes.setBounds(229, 104, 326, 110);
		panelDocentes.add(lblListaDeDocentes);
		
		JPanel panelEstudiantes = new JPanel();
		panelContenido.add(panelEstudiantes, "panelEstudiantes");
		panelEstudiantes.setBorder(new LineBorder(Color.BLACK,0));
		panelEstudiantes.setLayout(null);
		
		JLabel lblListaDeEstudiantes = new JLabel("Lista de Estudiantes");
		lblListaDeEstudiantes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblListaDeEstudiantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeEstudiantes.setBounds(224, 87, 351, 164);
		panelEstudiantes.add(lblListaDeEstudiantes);
		
		JLabel lblBienvenido = new JLabel("Bienvenido!");
		lblBienvenido.setBounds(0, 0, 794, 465);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicio.add(lblBienvenido);
		
		JPanel panelDepartamentos = new JPanel();
		panelContenido.add(panelDepartamentos, "panelDepartamentos");
		panelDepartamentos.setBorder(new LineBorder(Color.BLACK,0));
		panelDepartamentos.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Departamentos");
		lblNewLabel.setBounds(0, 0, 794, 465);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelDepartamentos.add(lblNewLabel);
		
		JButton btnInicio = new JButton("INICIO");
		btnInicio.setFocusPainted(false);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelContenido.getLayout());
				cl.show(panelContenido, "panelInicio");
			}
		});
		btnInicio.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnInicio.setBorder(new LineBorder(Color.BLACK,2));
		btnInicio.setBounds(0, 0, 198, 47);
		panelBarraNav.add(btnInicio);
		
		JButton btnDepartamentos = new JButton("DEPARTAMENTOS");
		btnDepartamentos.setFocusPainted(false);
		btnDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelContenido.getLayout());
				cl.show(panelContenido, "panelDepartamentos");
			}
		});
		btnDepartamentos.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnDepartamentos.setBorder(new LineBorder(Color.BLACK,2));
		btnDepartamentos.setBounds(198, 0, 198, 47);
		panelBarraNav.add(btnDepartamentos);
		
		JButton btnDocentes = new JButton("DOCENTES");
		btnDocentes.setFocusPainted(false);
		btnDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelContenido.getLayout());
				cl.show(panelContenido, "panelDocentes");
			}
		});
		btnDocentes.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnDocentes.setBorder(new LineBorder(Color.BLACK,2));
		btnDocentes.setBounds(396, 0, 198, 47);
		panelBarraNav.add(btnDocentes);
		
		JButton btnEstudiantes = new JButton("ESTUDIANTES");
		btnEstudiantes.setFocusPainted(false);
		btnEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelContenido.getLayout());
				cl.show(panelContenido, "panelEstudiantes");
			}
		});
		btnEstudiantes.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnEstudiantes.setBorder(new LineBorder(Color.BLACK,2));
		btnEstudiantes.setBounds(594, 0, 199, 47);
		panelBarraNav.add(btnEstudiantes);
		
		
		setVisible(true);
	}
}
