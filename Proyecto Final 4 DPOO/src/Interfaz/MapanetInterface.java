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

		// 1. Panel de Navegación Izquierda
		JPanel navigationPanel = createNavigationPanel();
		add(navigationPanel, BorderLayout.WEST);

		// 2. Panel de Contenido Principal (con CardLayout)
		mainContentPanel = createMainContentPanel();
		add(mainContentPanel, BorderLayout.CENTER);

		// 3. Agregar las "tarjetas" al mainContentPanel
		addContentPanels();

		setVisible(true);
	}

	// Método para crear el panel de navegación izquierdo
	private JPanel createNavigationPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Apila los elementos verticalmente
		panel.setBackground(new Color(30, 40, 50)); // Color oscuro para el fondo
		panel.setPreferredSize(new Dimension(200, getHeight())); // Ancho fijo para la navegación

		// Título del decanato
		JLabel decanatoTitle = new JLabel("Vicedecanato");
		decanatoTitle.setForeground(Color.WHITE);
		decanatoTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		decanatoTitle.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(Box.createRigidArea(new Dimension(0, 30))); // Espacio superior
		panel.add(decanatoTitle);
		panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio
		panel.add(Box.createRigidArea(new Dimension(0, 40))); // Espacio antes de los botones

		// Botones de navegación (simulando los de la imagen)
		panel.add(createNavigationButton("Docentes", "DOCENTES"));
		panel.add(createNavigationButton("Líneas de Investigación", "LINEAS_INVESTIGACION"));
		panel.add(createNavigationButton("Resultados", "RESULTADOS"));
		panel.add(createNavigationButton("Posgrado", "POSGRADO"));
		panel.add(createNavigationButton("Reportes", "REPORTES"));
		panel.add(createNavigationButton("Configuración", "CONFIGURACION"));

		return panel;
	}

	private JButton createNavigationButton(String text, final String cardName) {
		final JButton button = new JButton(text);
		button.setAlignmentX(Component.RIGHT_ALIGNMENT); // Alinear a la izquierda
		button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Ancho máximo, alto fijo
		button.setHorizontalAlignment(SwingConstants.LEFT); // Alinear texto a la izquierda
		button.setBackground(new Color(30, 40, 50)); // Mismo color de fondo que el panel
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.BOLD, 16));
		button.setBorderPainted(false); // No pintar el borde del botón
		button.setFocusPainted(false); // No pintar el foco al hacer clic

		// Efecto hover (cambiar color al pasar el ratón)
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(new Color(50, 60, 70));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Si este botón está seleccionado, mantener el color de selección
				// Esto requeriría una lógica adicional para rastrear el botón seleccionado
				// Por ahora, simplemente vuelve al color normal
				button.setBackground(new Color(30, 40, 50));
			}
		});

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainContentPanel, cardName); // Muestra el panel correspondiente
				// Lógica adicional para resaltar el botón seleccionado (opcional)
			}
		});
		return button;
	}

	// Método para crear el panel principal de contenido que usará CardLayout
	private JPanel createMainContentPanel() {
		JPanel panel = new JPanel();
		cardLayout = new CardLayout();
		panel.setLayout(cardLayout);
		return panel;
	}

	// Método para agregar todos los paneles de contenido al CardLayout
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

	// Método para crear el panel de "Docentes"
	private JPanel createDocentesPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.WHITE); // Fondo blanco para el contenido

		// Título del panel
		JLabel title = new JLabel("Docentes");
		title.setFont(new Font("Segoe UI", Font.BOLD, 28));
		title.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding
		panel.add(title, BorderLayout.NORTH);

		// Panel de búsqueda
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10)); // Margen izquierda
		JTextField searchField = new JTextField(30);
		searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		searchField.setPreferredSize(new Dimension(searchField.getPreferredSize().width, 30));
		searchField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // Borde sutil
		searchPanel.add(new JLabel("Buscar...")); // Placeholder de la imagen
		searchPanel.add(searchField);
		panel.add(searchPanel, BorderLayout.NORTH); // Añadir el panel de búsqueda abajo del título

		// Tabla de docentes
		String[] columnNames = {"Nombre", "Categoría Docente", "Categoría Científica"};
		Object[][] data = {
				{"Mario García", "Instructor", "Instructor"},
				{"Elena Pérez", "Assistent", "Assistent"},
				{"José Rodríguez", "Professor Advoc", "Professor Advoc"},
				{"Laura Fernández", "Professor Advoc", "Master"},
				{"Ana López", "Full Professor", "Doctor"},
				{"Miguel Sánchez", "Instructor", "Instructor"},
				{"Carmen Díaz", "Professor Advoc", "Professor Advoc"},
				{"Andrés Torres", "Assistent", "Master"}
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

		// Añadir la tabla a un JScrollPane para que sea scrollable
		JScrollPane scrollPane = new JScrollPane(docentesTable);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20)); // Padding alrededor de la tabla

		// Añadir el scrollPane al panel de docentes
		panel.add(scrollPane, BorderLayout.CENTER);

		return panel;
	}

	// Métodos para crear los otros paneles (similares, pero con contenido diferente)
	private JPanel createLineasInvestigacionPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(new JLabel("Contenido de Líneas de Investigación"));
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
		panel.add(new JLabel("Contenido de Configuración"));
		return panel;
	}

}

