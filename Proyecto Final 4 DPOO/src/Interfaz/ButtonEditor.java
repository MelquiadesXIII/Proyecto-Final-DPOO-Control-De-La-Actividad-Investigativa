package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

class ButtonEditor extends DefaultCellEditor {
	private static final long serialVersionUID = 1L;
	private JButton button;
	private int selectedRow;
	
	ButtonEditor(JCheckBox checkBox, final VentanaPrincipal ventana) {
		super(checkBox);
		
		button = new JButton();
		button.setOpaque(true);
		button.setText("Ver Objetivos");
		button.setBackground(new Color(40, 150, 200));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.BOLD, 12));

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				ventana.mostrarObjetivosCurso(selectedRow);
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		selectedRow = row;
		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return "Ver Objetivos";
	}


}
