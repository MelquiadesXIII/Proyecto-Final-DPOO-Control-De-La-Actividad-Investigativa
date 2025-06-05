package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class ButtonRenderer extends JButton implements TableCellRenderer {
	private static final long serialVersionUID = 1L;

	public ButtonRenderer() {
		setOpaque(true);
		setText("Ver Objetivos");
		setBackground(new Color(40, 150, 200));
		setForeground(Color.WHITE);
		setFont(new Font("Segoe UI", Font.BOLD, 12));
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		return this;
	}
}
