package Interfaz;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapanetInterface extends JFrame {

	private JPanel mainContentPanel;
	private CardLayout cardLayout;   

	public MapanetInterface() {
		setTitle("Vicedecanato: Ventana Principal");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1080, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		// 1. Panel de Navegaci�n Izquierda
		JPanel navigationPanel = createNavigationPanel();
		add(navigationPanel, BorderLayout.WEST);

		// 2. Panel de Contenido Principal (con CardLayout)
		mainContentPanel = createMainContentPanel();
		add(mainContentPanel, BorderLayout.CENTER);

		// 3. Agregar las "tarjetas" al mainContentPanel
		addContentPanels();

		setVisible(true);
	}

	// M�todo para crear el panel de navegaci�n izquierdo
	private JPanel createNavigationPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Apila los elementos verticalmente
		panel.setBackground(new Color(30, 40, 50)); // Color oscuro para el fondo
		panel.setPreferredSize(new Dimension(200, getHeight())); // Ancho fijo para la navegaci�n

		// T�tulo del decanato
		JLabel decanatoTitle = new JLabel("Vicedecanato");
		decanatoTitle.setForeground(Color.WHITE);
		decanatoTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		decanatoTitle.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(Box.createRigidArea(new Dimension(0, 30))); // Espacio superior
		panel.add(decanatoTitle);
		panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio
		panel.add(Box.createRigidArea(new Dimension(0, 40))); // Espacio antes de los botones

		// Botones de navegaci�n (simulando los de la imagen)
		panel.add(createNavigationButton("Docentes", "DOCENTES"));
		panel.add(createNavigationButton("L�neas de Investigaci�n", "LINEAS_INVESTIGACION"));
		panel.add(createNavigationButton("Resultados", "RESULTADOS"));
		panel.add(createNavigationButton("Posgrado", "POSGRADO"));
		panel.add(createNavigationButton("Reportes", "REPORTES"));
		panel.add(createNavigationButton("Configuraci�n", "CONFIGURACION"));

		return panel;
	}

	private JButton createNavigationButton(String text, final String cardName) {
		final JButton button = new JButton(text);
		button.setAlignmentX(Component.RIGHT_ALIGNMENT); // Alinear a la izquierda
		button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Ancho m�ximo, alto fijo
		button.setHorizontalAlignment(SwingConstants.LEFT); // Alinear texto a la izquierda
		button.setBackground(new Color(30, 40, 50)); // Mismo color de fondo que el panel
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.BOLD, 16));
		button.setBorderPainted(false); // No pintar el borde del bot�n
		button.setFocusPainted(false); // No pintar el foco al hacer clic

		// Efecto hover (cambiar color al pasar el rat�n)
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(new Color(50, 60, 70));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Si este bot�n est� seleccionado, mantener el color de selecci�n
				// Esto requerir�a una l�gica adicional para rastrear el bot�n seleccionado
				// Por ahora, simplemente vuelve al color normal
				button.setBackground(new Color(30, 40, 50));
			}
		});

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainContentPanel, cardName); // Muestra el panel correspondiente
				// L�gica adicional para resaltar el bot�n seleccionado (opcional)
			}
		});
		return button;
	}

	// M�todo para crear el panel principal de contenido que usar� CardLayout
	private JPanel createMainContentPanel() {
		JPanel panel = new JPanel();
		cardLayout = new CardLayout();
		panel.setLayout(cardLayout);
		return panel;
	}

	// M�todo para agregar todos los paneles de contenido al CardLayout
	private void addContentPanels() {
		mainContentPanel.add(createDocentesPanel(), "DOCENTES");
		mainContentPanel.add(createLineasInvestigacionPanel(), "LINEAS_INVESTIGACION");
		mainContentPanel.add(createResultadosPanel(), "RESULTADOS");
		mainContentPanel.add(createPosgradoPanel(), "POSGRADO");
		mainContentPanel.add(createReportesPanel(), "REPORTES");
		mainContentPanel.add(createConfiguracionPanel(), "CONFIGURACION");

		// Mostrar el panel de Docentes por defecto al iniciar
		cardLayout.show(mainContentPanel, "DOCENTES");
	}

	// M�todo para crear el panel de "Docentes"
	private JPanel createDocentesPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.WHITE); // Fondo blanco para el contenido

		// T�tulo del panel
		JLabel title = new JLabel("Docentes");
		title.setFont(new Font("Segoe UI", Font.BOLD, 28));
		title.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding
		panel.add(title, BorderLayout.NORTH);

		// Panel de b�squeda
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10)); // Margen izquierda
		JTextField searchField = new JTextField(30);
		searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		searchField.setPreferredSize(new Dimension(searchField.getPreferredSize().width, 30));
		searchField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // Borde sutil
		searchPanel.add(new JLabel("Buscar...")); // Placeholder de la imagen
		searchPanel.add(searchField);
		panel.add(searchPanel, BorderLayout.NORTH); // A�adir el panel de b�squeda abajo del t�tulo

		// Tabla de docentes
		String[] columnNames = {"Nombre", "Categor�a Docente", "Categor�a Cient�fica"};
		Object[][] data = {
				{"Mario Garc�a", "Instructor", "Instructor"},
				{"Elena P�rez", "Assistent", "Assistent"},
				{"Jos� Rodr�guez", "Professor Advoc", "Professor Advoc"},
				{"Laura Fern�ndez", "Professor Advoc", "Master"},
				{"Ana L�pez", "Full Professor", "Doctor"},
				{"Miguel S�nchez", "Instructor", "Instructor"},
				{"Carmen D�az", "Professor Advoc", "Professor Advoc"},
				{"Andr�s Torres", "Assistent", "Master"}
		};
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Hacer que las celdas de la tabla no sean editables
			}
		};
		JTable docentesTable = new JTable(tableModel);
		docentesTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		docentesTable.setRowHeight(30); // Altura de las filas
		docentesTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14)); // Fuente del encabezado
		docentesTable.getTableHeader().setBackground(new Color(240, 240, 240)); // Color de fondo del encabezado

		// A�adir la tabla a un JScrollPane para que sea scrollable
		JScrollPane scrollPane = new JScrollPane(docentesTable);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20)); // Padding alrededor de la tabla

		// A�adir el scrollPane al panel de docentes
		panel.add(scrollPane, BorderLayout.CENTER);

		return panel;
	}

	// M�todos para crear los otros paneles (similares, pero con contenido diferente)
	private JPanel createLineasInvestigacionPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(new JLabel("Contenido de L�neas de Investigaci�n"));
		return panel;
	}

	private JPanel createResultadosPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.add(new JLabel("Contenido de Resultados"));
		return panel;
	}

	private JPanel createPosgradoPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.add(new JLabel("Contenido de Posgrado"));
		return panel;
	}

	private JPanel createReportesPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		panel.add(new JLabel("Contenido de Reportes"));
		return panel;
	}

	private JPanel createConfiguracionPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.add(new JLabel("Contenido de Configuraci�n"));
		return panel;
	}

}

