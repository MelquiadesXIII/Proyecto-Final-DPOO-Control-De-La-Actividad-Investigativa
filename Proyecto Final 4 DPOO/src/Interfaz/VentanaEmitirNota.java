package Interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import Excepciones.InstanciaNoValidaException;
import Excepciones.NoExistenciaException;
import Excepciones.RangoNoValidoException;
import Interfaz.MensajeDialog.Tipo;
import Logica.CursoPosgrado;
import Logica.Docente;

public class VentanaEmitirNota extends JDialog {

	private static final long serialVersionUID = 1L;
	private final Color COLOR_DEFAULT = new Color(30, 40, 50);
	private final Color COLOR_HOVER = new Color(50, 60, 70);
	private final Color COLOR_SELECTED = new Color(70, 80, 90);
	private final Color COLOR_HEADER_BACKGROUND = new Color(45, 55, 65);

	private CursoPosgrado cursoActual;
	private Docente evaluador;
	private JComboBox<Docente> cmbParticipantes;
	private ButtonGroup grupoNotas;
	private JButton btnEmitirNota;
	private JButton btnCancelar;
	private boolean confirmado = false;
	private JFrame parent;

	public VentanaEmitirNota(JFrame parent, CursoPosgrado curso, Docente profesorEvaluador) {
		super(parent, "Emitir Nota de Curso para Docente", true);
		this.cursoActual = curso;
		this.evaluador = profesorEvaluador;
		this.parent = parent;

		inicializarConfiguracionUI();
		crearComponentes();
		configurarListeners();
	}

	private void inicializarConfiguracionUI() {
		setSize(450, 280);
		getContentPane().setBackground(COLOR_DEFAULT);
		setResizable(false);
		setLocationRelativeTo(getParent());
		setLayout(new BorderLayout(10, 10));
	}

	private void crearComponentes() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(COLOR_DEFAULT);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JPanel panelParticipante = new JPanel();
		panelParticipante.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		panelParticipante.setBackground(COLOR_DEFAULT);
		panelParticipante.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel lblParticipante = new JLabel("Seleccionar Participante:");
		lblParticipante.setForeground(Color.WHITE);
		panelParticipante.add(lblParticipante);

		cmbParticipantes = new JComboBox<Docente>();
		cargarParticipantesEnComboBox();
		estiloComboBoxDocente(cmbParticipantes);
		cmbParticipantes.setPreferredSize(new Dimension(200, 25));
		panelParticipante.add(cmbParticipantes);
		mainPanel.add(panelParticipante);

		mainPanel.add(Box.createVerticalStrut(20));

		JPanel panelNotaGroup = new JPanel();
		panelNotaGroup.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		panelNotaGroup.setBackground(COLOR_DEFAULT);
		panelNotaGroup.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel lblNota = new JLabel("Seleccionar Nota:");
		lblNota.setForeground(Color.WHITE);
		panelNotaGroup.add(lblNota);

		JPanel panelNotas = new JPanel();
		panelNotas.setBackground(COLOR_DEFAULT);
		panelNotas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		grupoNotas = new ButtonGroup();

		for (int i = 2; i <= 5; i++) {
			JRadioButton rb = new JRadioButton(String.valueOf(i));
			rb.setBackground(COLOR_DEFAULT);
			rb.setForeground(Color.WHITE);
			rb.setFocusPainted(false);
			grupoNotas.add(rb);
			panelNotas.add(rb);
		}
		panelNotaGroup.add(panelNotas);
		mainPanel.add(panelNotaGroup);

		add(mainPanel, BorderLayout.CENTER);

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		panelBotones.setBackground(COLOR_HEADER_BACKGROUND);

		btnEmitirNota = new JButton("Emitir Nota");
		btnEmitirNota.setBackground(COLOR_SELECTED);
		btnEmitirNota.setForeground(Color.WHITE);
		btnEmitirNota.setFocusPainted(false);
		panelBotones.add(btnEmitirNota);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(COLOR_HOVER);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFocusPainted(false);
		panelBotones.add(btnCancelar);

		add(panelBotones, BorderLayout.SOUTH);
	}

	private void cargarParticipantesEnComboBox() {
		cmbParticipantes.removeAllItems();
		for (Docente d : cursoActual.getParticipantes()) {
			cmbParticipantes.addItem(d);
		}
		if (cmbParticipantes.getItemCount() > 0) {
			cmbParticipantes.setSelectedIndex(0);
		}
	}

	private void configurarListeners() {
		btnEmitirNota.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emitirNota();
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	private int getNotaSeleccionada() {

		int indice = -1;
		for (Enumeration<AbstractButton> buttons = grupoNotas.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				indice = Integer.parseInt(button.getText());
			}
		}
		return indice;
	}

	private void emitirNota() {
		Docente participanteSeleccionado = (Docente) cmbParticipantes.getSelectedItem();
		int notaSeleccionada = getNotaSeleccionada();

		if(participanteSeleccionado != null){

			if(notaSeleccionada == -1){
				try {
					
					cursoActual.emitirNota(evaluador, participanteSeleccionado, notaSeleccionada);
					MensajeDialog m = new MensajeDialog(this.parent, "Nota emitida correctamente", Tipo.RETROALIMENTACION);
					m.setVisible(true);
					confirmado = true;
					dispose();
					
				} catch (RuntimeException ex) {
					MensajeDialog m = new MensajeDialog(this.parent, ex.getMessage(), Tipo.RETROALIMENTACION);
					m.setVisible(true);
				} 
			}else{
				MensajeDialog m = new MensajeDialog(this.parent, "Debe seleccionar una nota", Tipo.RETROALIMENTACION);
				m.setVisible(true);
			}
			
		}else{
			MensajeDialog m = new MensajeDialog(this.parent, "Debe seleccionar un participante", Tipo.RETROALIMENTACION);
			m.setVisible(true);
		}
	}

	public boolean isConfirmado(){
		return confirmado;
	}

	private void estiloComboBoxDocente(JComboBox<Docente> combo) {
		combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		combo.setBackground(new Color(60, 70, 80));
		combo.setForeground(Color.WHITE);
		combo.setRenderer(new DocenteComboBoxRenderer());
	}
}