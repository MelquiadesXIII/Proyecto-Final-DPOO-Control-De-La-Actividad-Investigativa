package Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import Interfaz.MensajeDialog.Tipo;
import Logica.Investigador;
import Logica.PonenciaEvento;

import com.toedter.calendar.JDateChooser;

public class CrearPonenciaDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    private JTextField txtNombre, txtLugar, txtISBN;
    private JDateChooser fecha;

    private boolean confirmado = false;
    private PonenciaEvento ponencia;
    private Point point = new Point();

    public CrearPonenciaDialog(final JFrame parent, final Investigador autor) {
        super(parent, "Crear Ponencia", true);
        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        setSize(420, 300);
        setLocationRelativeTo(parent);
        setLayout(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
        panel.setBounds(0, 0, 420, 300);
        setContentPane(panel);

        JLabel lblTitulo = new JLabel("Crear Ponencia");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(140, 10, 200, 30);
        panel.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 60, 100, 25);
        estiloLabel(lblNombre);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(130, 60, 250, 30);
        estiloCampo(txtNombre);
        panel.add(txtNombre);

        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setBounds(30, 100, 100, 25);
        estiloLabel(lblLugar);
        panel.add(lblLugar);

        txtLugar = new JTextField();
        txtLugar.setBounds(130, 100, 250, 30);
        estiloCampo(txtLugar);
        panel.add(txtLugar);

        JLabel lblISBN = new JLabel("ISBN:");
        lblISBN.setBounds(30, 140, 100, 25);
        estiloLabel(lblISBN);
        panel.add(lblISBN);

        txtISBN = new JTextField();
        txtISBN.setBounds(130, 140, 250, 30);
        estiloCampo(txtISBN);
        panel.add(txtISBN);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(30, 180, 100, 25);
        estiloLabel(lblFecha);
        panel.add(lblFecha);

        fecha = new JDateChooser();
        fecha.setBounds(130, 180, 250, 30);
        fecha.setDateFormatString("dd/MM/yyyy");
        estiloDateChooser(fecha);
        panel.add(fecha);

        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(80, 230, 110, 40);
        estiloBoton(btnCrear);
        panel.add(btnCrear);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(230, 230, 110, 40);
        estiloBoton(btnCancelar);
        panel.add(btnCancelar);
        
        aplicarFiltroTexto(txtNombre, 40);
        aplicarFiltroTexto(txtLugar, 40);
        aplicarFiltroNumerico(txtISBN, 13);
        
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String lugar = txtLugar.getText();
                    String isbn = txtISBN.getText();
                    Date fechaSeleccionada = fecha.getDate();

                    if (fechaSeleccionada == null) {
                        JOptionPane.showMessageDialog(parent, "Debe seleccionar una fecha válida.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    LocalDate fecha = convertirDateALocalDate(fechaSeleccionada);
                    autor.crearPonenciaEvento(nombre, fecha, lugar, isbn);
                    confirmado = true;
                    dispose();
                } catch (RuntimeException r) {
                	MensajeDialog m = new MensajeDialog(parent, r.getMessage(), Tipo.RETROALIMENTACION);
                	m.setVisible(true);
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }
        });
    }

    

    private void estiloCampo(JTextField campo) {
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBackground(new Color(60, 70, 80));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void estiloLabel(JLabel label) {
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
    }

    private void estiloBoton(JButton boton) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBackground(new Color(50, 60, 70));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
    }

    private void estiloDateChooser(JDateChooser fecha) {
    	fecha.setBackground(new Color(60, 70, 80));
    	fecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    	fecha.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JTextField editor = (JTextField) fecha.getDateEditor().getUiComponent();
        editor.setBackground(new Color(60, 70, 80));
        editor.setForeground(Color.WHITE);
        editor.setCaretColor(Color.WHITE);
        editor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        editor.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        Component[] comps = fecha.getComponents();
        for (Component c : comps) {
            if (c instanceof JButton) {
                JButton boton = (JButton) c;
                boton.setBackground(new Color(50, 60, 70));
                boton.setForeground(Color.WHITE);
                boton.setFocusPainted(false);
                boton.setBorderPainted(false);
                boton.setOpaque(true);
            }
        }
    }

    

    public boolean isConfirmado() {
        return confirmado;
    }

    public PonenciaEvento getPonencia() {
        return ponencia;
    }

    

    private LocalDate convertirDateALocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    public void aplicarFiltroTexto(JTextField campo, final int maxChars){

		AbstractDocument doc = (AbstractDocument) campo.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {

			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
				if (string != null) {
					String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
					String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
					if (newText.length() <= maxChars && newText.matches("^[\\p{L}\\s]*$")) {
						super.insertString(fb, offset, string, attr);
					}
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
				if (text != null) {
					String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
					String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
					if (newText.length() <= maxChars && newText.matches("^[\\p{L}\\s]*$")) {
						super.replace(fb, offset, length, text, attrs);
					}
				} else {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});
	}
	
	public void aplicarFiltroNumerico(JTextField campo, final int maxChars){
		
		AbstractDocument doc = (AbstractDocument) campo.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {

			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
				if (string != null) {

					String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
					if (newText.length() <= maxChars && string.matches("\\d*")) {
						super.insertString(fb, offset, string, attr);
					}
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
				String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
				String newText = currentText.substring(0, offset) + 
						(text != null ? text : "") + 
						currentText.substring(offset + length);

				if (newText.length() <= maxChars && newText.matches("\\d*")) {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});
	}
}
