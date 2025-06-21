package Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import Interfaz.MensajeDialog.Tipo;
import Logica.CapituloLibro;

public class EditarCapituloDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    private JTextField campoTitulo, campoAutores, campoEditores, campoEditorial, campoISSN, campoVolumen;
    private boolean confirmado = false;
    private CapituloLibro capitulo;
    private Point point = new Point();

    public EditarCapituloDialog(final JFrame parent, CapituloLibro capituloEditar) {
        super(parent, "Editar Capítulo de Libro", true);
        this.capitulo = capituloEditar;

        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
        panel.setPreferredSize(new Dimension(420, 410));
        panel.setLayout(null);

        JPanel panelCampos = new JPanel(null);
        panelCampos.setBackground(new Color(30, 40, 50));
        panelCampos.setBounds(20, 60, 380, 263);
        panel.add(panelCampos);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 10, 120, 30);
        estiloLabel(lblTitulo);
        panelCampos.add(lblTitulo);

        campoTitulo = new JTextField(capitulo.getNombrePublicacion());
        campoTitulo.setBounds(150, 10, 200, 30);
        estiloCampo(campoTitulo);
        panelCampos.add(campoTitulo);

        JLabel lblAutores = new JLabel("Autores:");
        lblAutores.setBounds(20, 50, 120, 30);
        estiloLabel(lblAutores);
        panelCampos.add(lblAutores);

        campoAutores = new JTextField(String.join(", ", capitulo.getAutores()));
        campoAutores.setBounds(150, 50, 200, 30);
        estiloCampo(campoAutores);
        panelCampos.add(campoAutores);

        JLabel lblEditores = new JLabel("Editores:");
        lblEditores.setBounds(20, 90, 120, 30);
        estiloLabel(lblEditores);
        panelCampos.add(lblEditores);

        campoEditores = new JTextField(String.join(", ", capitulo.getNombresEditores()));
        campoEditores.setBounds(150, 90, 200, 30);
        estiloCampo(campoEditores);
        panelCampos.add(campoEditores);

        JLabel lblEditorial = new JLabel("Editorial:");
        lblEditorial.setBounds(20, 130, 120, 30);
        estiloLabel(lblEditorial);
        panelCampos.add(lblEditorial);

        campoEditorial = new JTextField(capitulo.getEditorial());
        campoEditorial.setBounds(150, 130, 200, 30);
        estiloCampo(campoEditorial);
        panelCampos.add(campoEditorial);

        JLabel lblISSN = new JLabel("ISSN:");
        lblISSN.setBounds(20, 170, 120, 30);
        estiloLabel(lblISSN);
        panelCampos.add(lblISSN);

        campoISSN = new JTextField(capitulo.getISSN());
        campoISSN.setBounds(150, 170, 200, 30);
        estiloCampo(campoISSN);
        panelCampos.add(campoISSN);

        JLabel lblVolumen = new JLabel("Volumen:");
        lblVolumen.setBounds(20, 210, 120, 30);
        estiloLabel(lblVolumen);
        panelCampos.add(lblVolumen);

        campoVolumen = new JTextField(capitulo.getVolumen());
        campoVolumen.setBounds(150, 210, 200, 30);
        estiloCampo(campoVolumen);
        panelCampos.add(campoVolumen);

        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBounds(20, 336, 380, 50);
        panelBotones.setBackground(new Color(30, 40, 50));

        JButton btnAceptar = new JButton("Aceptar");
        estiloBoton(btnAceptar);
        btnAceptar.setPreferredSize(new Dimension(120, 40));

        JButton btnCancelar = new JButton("Cancelar");
        estiloBoton(btnCancelar);
        btnCancelar.setPreferredSize(new Dimension(120, 40));

        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones);

        aplicarFiltroNumerico(campoISSN, 8);
        aplicarFiltroNumerico(campoVolumen, 4);
        aplicarFiltroTexto(campoAutores, 3000);
        aplicarFiltroTexto(campoEditores, 3000);
        aplicarFiltroTexto(campoEditorial, 50);
        aplicarFiltroTexto(campoTitulo, 40);
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String titulo = campoTitulo.getText().trim();
                    String editorial = campoEditorial.getText().trim();
                    String issn = campoISSN.getText().trim();
                    String volumen = campoVolumen.getText().trim();

                    String[] autoresArray = campoAutores.getText().trim().split(",");
                    String[] editoresArray = campoEditores.getText().trim().split(",");

                    ArrayList<String> autores = new ArrayList<>();
                    for (String a : autoresArray) autores.add(a.trim());

                    ArrayList<String> editores = new ArrayList<>();
                    for (String ed : editoresArray) editores.add(ed.trim());

                    capitulo.setTitulo(titulo);
                    capitulo.setAutores(autores);
                    capitulo.setNombresEditores(editores);
                    capitulo.setEditorial(editorial);
                    capitulo.setISSN(issn);
                    capitulo.setVolumen(volumen);

                    confirmado = true;
                    dispose();
                } catch (Exception ex) {
                	MensajeDialog m = new MensajeDialog(parent, ex.getMessage(), Tipo.RETROALIMENTACION);
                    m.setVisible(true);
                }
            }
        });


        btnCancelar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		dispose();
        	}
        });

        JLabel tituloLabel = new JLabel("Editar Capítulo de Libro");
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        tituloLabel.setBounds(100, 15, 250, 30);
        panel.add(tituloLabel);

        
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

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
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
    
    public void setCapitulo(CapituloLibro capitulo) {
        this.capitulo = capitulo;

        campoTitulo.setText(capitulo.getNombrePublicacion());
        campoEditorial.setText(capitulo.getEditorial());
        campoISSN.setText(capitulo.getISSN());
        campoVolumen.setText(capitulo.getVolumen());

        campoAutores.setText(String.join(", ", capitulo.getAutores()));
        campoEditores.setText(String.join(", ", capitulo.getNombresEditores()));
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public CapituloLibro getCapitulo() {
        return capitulo;
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
