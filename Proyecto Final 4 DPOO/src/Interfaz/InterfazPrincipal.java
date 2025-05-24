package Interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSplitPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Logica.*;
import Excepciones.*;

@SuppressWarnings("unused")
public class InterfazPrincipal extends JFrame {

	private Vicedecanato vicedecanato;
	private static final long serialVersionUID = 1L;
	private JList<String> listaEstudiantes;
	private DefaultListModel<String> modeloEstudiantes;
	private JPanel panelEstudiantes;
	private JList<String> listaDocentes;
	private DefaultListModel<String> modeloDocentes;
	private JPanel panelDocentes;
	private JList<String> listaDepartamentos;
	private DefaultListModel<String> modeloDepartamentos;
	private JPanel panelDepartamentos;
	
	
	public InterfazPrincipal(Vicedecanato vicedecanato) {
		
		
		this.vicedecanato = vicedecanato;
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("Vicedecanato de Investigacion");
		setMinimumSize(new Dimension(800,600)); //Establece el tamannio minimo
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
		
		panelDocentes = new JPanel();
		panelContenido.add(panelDocentes, "panelDocentes");
		panelDocentes.setBorder(new LineBorder(Color.BLACK,0));
		panelDocentes.setLayout(null);
		
		panelEstudiantes = new JPanel();
		panelContenido.add(panelEstudiantes, "panelEstudiantes");
		((JComponent) panelEstudiantes).setBorder(new LineBorder(Color.BLACK,0));
		panelEstudiantes.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido!");
		lblBienvenido.setBounds(0, 0, 794, 465);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicio.add(lblBienvenido);
		
		panelDepartamentos = new JPanel();
		panelContenido.add(panelDepartamentos, "panelDepartamentos");
		panelDepartamentos.setBorder(new LineBorder(Color.BLACK,0));
		panelDepartamentos.setLayout(null);
		
		JButton btnInicio = new JButton("INICIO");
		btnInicio.setFocusPainted(false);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelContenido.getLayout());
				cl.show(panelContenido, "panelInicio");
			}
		});
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		btnDepartamentos.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		btnDocentes.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		btnEstudiantes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEstudiantes.setBorder(new LineBorder(Color.BLACK,2));
		btnEstudiantes.setBounds(594, 0, 199, 47);
		panelBarraNav.add(btnEstudiantes);
		
		modeloEstudiantes = new DefaultListModel<>();
	    
	    for (Estudiante estudiante : vicedecanato.getEstudiantes()) {
	        modeloEstudiantes.addElement(estudiante.getNombre() + " " + estudiante.getApellidos());
	    }
	    
	    listaEstudiantes = new JList<>(modeloEstudiantes);
	    JScrollPane scrollEstudiantes = new JScrollPane(listaEstudiantes);
	    scrollEstudiantes.setBounds(0, 1, 600, 465);
	    
		panelEstudiantes.add(scrollEstudiantes);
		
		JButton btnCrearEst = new JButton("Crear");
		btnCrearEst.setBounds(655, 13, 97, 25);
		panelEstudiantes.add(btnCrearEst);
		
		JButton btnEliminarEst = new JButton("Eliminar");
		btnEliminarEst.setBounds(655, 68, 97, 25);
		panelEstudiantes.add(btnEliminarEst);
		
		modeloDocentes = new DefaultListModel<>();
		
		for (Docente docente : vicedecanato.getDocentes()) {
		    modeloDocentes.addElement(docente.getNombre() + " " + docente.getApellidos());
		}
		
		listaDocentes = new JList<>(modeloDocentes);
		JScrollPane scrollDocentes = new JScrollPane(listaDocentes);
		scrollDocentes.setBounds(0, 1, 600, 465);
		panelDocentes.add(scrollDocentes);
		
		JButton btnCrearDoc = new JButton("Crear");
		btnCrearDoc.setBounds(655, 13, 97, 25);
		panelDocentes.add(btnCrearDoc);
		
		JButton btnEliminarDoc = new JButton("Eliminar");
		btnEliminarDoc.setBounds(655, 60, 97, 25);
		panelDocentes.add(btnEliminarDoc);
		
		modeloDepartamentos = new DefaultListModel<>();
		
		for (Departamento departamento : vicedecanato.getDepartamentos()) {
		    modeloDepartamentos.addElement(departamento.getNombre());
		}
		
		listaDepartamentos = new JList<>(modeloDepartamentos);
		JScrollPane scrollDepartamentos = new JScrollPane(listaDepartamentos);
		scrollDepartamentos.setBounds(0, 1, 600, 465);
		panelDepartamentos.add(scrollDepartamentos);
		
		JButton btnCrearDep = new JButton("Crear");
		btnCrearDep.setBounds(652, 13, 97, 25);
		panelDepartamentos.add(btnCrearDep);
		
		JButton btnEliminarDep = new JButton("Eliminar");
		btnEliminarDep.setBounds(652, 72, 97, 25);
		panelDepartamentos.add(btnEliminarDep);
		
		setVisible(true);
	}
}
