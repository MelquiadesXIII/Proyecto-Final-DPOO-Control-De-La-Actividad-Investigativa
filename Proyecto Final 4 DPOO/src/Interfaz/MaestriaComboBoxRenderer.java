package Interfaz;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import Logica.Maestria;

public class MaestriaComboBoxRenderer extends DefaultListCellRenderer{
	private static final long serialVersionUID = 1L;

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value instanceof Maestria) {
            Maestria m = (Maestria) value;
            setText(m.getNombre());
        }
        return this;
    }
}
