package Interfaz;

import Interfaz.MensajeDialog.Tipo;
import Logica.Articulo;
import Logica.GrupoImpacto;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import java.awt.*;
import java.awt.event.*;

public class EditarArticuloDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField campoTitulo, campoNumero, campoVolumen, campoAnio, campoPaginas;
    private JComboBox<GrupoImpacto> comboGrupo;
    private boolean confirmado = false;
    private Articulo articulo;
    private Point point = new Point();

    public EditarArticuloDialog(final JFrame parent, Articulo articuloEditar) {
        super(parent, "Editar Artículo", true);
        this.articulo = articuloEditar;

        setUndecorated(true);
        setBackground(new Color(30, 40, 50));
        getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(30, 40, 50));
        panel.setBorder(new LineBorder(new Color(70, 80, 90), 2));
        panel.setPreferredSize(new Dimension(420, 410));

        JLabel lblTituloGeneral = new JLabel("Editar Artículo");
        lblTituloGeneral.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTituloGeneral.setForeground(Color.WHITE);
        lblTituloGeneral.setBounds(140, 10, 200, 30);
        panel.add(lblTituloGeneral);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(30, 60, 100, 30);
        estiloLabel(lblTitulo);
        panel.add(lblTitulo);

        campoTitulo = new JTextField(articulo.getNombrePublicacion());
        campoTitulo.setBounds(140, 60, 240, 30);
        estiloCampo(campoTitulo);
        panel.add(campoTitulo);

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(30, 100, 100, 30);
        estiloLabel(lblNumero);
        panel.add(lblNumero);

        campoNumero = new JTextField(String.valueOf(articulo.getNumero()));
        campoNumero.setBounds(140, 100, 240, 30);
        estiloCampo(campoNumero);
        panel.add(campoNumero);

        JLabel lblVolumen = new JLabel("Volumen:");
        lblVolumen.setBounds(30, 140, 100, 30);
        estiloLabel(lblVolumen);
        panel.add(lblVolumen);

        campoVolumen = new JTextField(String.valueOf(articulo.getVolumen()));
        campoVolumen.setBounds(140, 140, 240, 30);
        estiloCampo(campoVolumen);
        panel.add(campoVolumen);

        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setBounds(30, 180, 100, 30);
        estiloLabel(lblAnio);
        panel.add(lblAnio);

        campoAnio = new JTextField(articulo.getAnioPublicacion());
        campoAnio.setBounds(140, 180, 240, 30);
        estiloCampo(campoAnio);
        panel.add(campoAnio);

        JLabel lblPaginas = new JLabel("Páginas:");
        lblPaginas.setBounds(30, 220, 100, 30);
        estiloLabel(lblPaginas);
        panel.add(lblPaginas);

        campoPaginas = new JTextField(String.valueOf(articulo.getPaginas()));
        campoPaginas.setBounds(140, 220, 240, 30);
        estiloCampo(campoPaginas);
        panel.add(campoPaginas);

        JLabel lblGrupo = new JLabel("Grupo Impacto:");
        lblGrupo.setBounds(30, 260, 120, 30);
        estiloLabel(lblGrupo);
        panel.add(lblGrupo);

        comboGrupo = new JComboBox<>(GrupoImpacto.values());
        comboGrupo.setBounds(140, 260, 240, 30);
        estiloComboBox(comboGrupo);
        comboGrupo.setSelectedItem(articulo.getGrupo());
        panel.add(comboGrupo);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setBounds(30, 320, 360, 60);
        panelBotones.setBackground(new Color(30, 40, 50));

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        estiloBoton(btnAceptar);
        estiloBoton(btnCancelar);

        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones);
        
        aplicarFiltroTexto(campoTitulo, 50);
		aplicarFiltroNumerico(campoAnio, 4);
		aplicarFiltroNumerico(campoNumero, 5);
		aplicarFiltroNumerico(campoPaginas, 4);
		aplicarFiltroNumerico(campoVolumen, 5);

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String titulo = campoTitulo.getText().trim();
                    int numero = Integer.parseInt(campoNumero.getText().trim());
                    int volumen = Integer.parseInt(campoVolumen.getText().trim());
                    String anio = campoAnio.getText().trim();
                    int paginas = Integer.parseInt(campoPaginas.getText().trim());
                    GrupoImpacto grupo = (GrupoImpacto) comboGrupo.getSelectedItem();

                    articulo.setTitulo(titulo);
                    articulo.setNumero(numero);
                    articulo.setVolumen(volumen);
                    articulo.setAnioPublicacion(anio);
                    articulo.setPaginas(paginas);
                    articulo.setGrupo(grupo);

                    confirmado = true;
                    dispose();
                } catch (Exception ex) {
                    MensajeDialog m = new MensajeDialog(parent, ex.getMessage(), Tipo.RETROALIMENTACION);
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

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    private void estiloLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    private void estiloCampo(JTextField campo) {
        campo.setBackground(new Color(60, 70, 80));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void estiloComboBox(JComboBox<?> comboBox) {
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setBackground(new Color(60, 70, 80));
        comboBox.setForeground(Color.WHITE);
        comboBox.setOpaque(false);
        comboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void estiloBoton(JButton boton) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBackground(new Color(50, 60, 70));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setPreferredSize(new Dimension(120, 40));
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;

        campoTitulo.setText(articulo.getNombrePublicacion());
        campoNumero.setText(String.valueOf(articulo.getNumero()));
        campoVolumen.setText(String.valueOf(articulo.getVolumen()));
        campoAnio.setText(articulo.getAnioPublicacion());
        campoPaginas.setText(String.valueOf(articulo.getPaginas()));
        comboGrupo.setSelectedItem(articulo.getGrupo());
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public Articulo getArticulo() {
        return articulo;
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
