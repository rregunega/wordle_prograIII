package gui;

import static gui.ConfiguracionUI.*;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	
	// Agregado por autofix de Eclipse
	private static final long serialVersionUID = 1L;
	
	private CardLayout cardLayout = new CardLayout();
	private JPanel cardPanel = new JPanel();

	public Ventana() {
		setTitle("W-UNGS-dle!");
		setBackground(COLOR_FONDO_PRIMARIO);
		setSize(500, 647); // Medidas de la ventana
		setLocationRelativeTo(null); // Centro la ventana en la pantalla
		setResizable(false); // Evito que la pantalla se redimencione
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardPanel.setLayout(cardLayout);

		// Creo las vistas
		cardPanel.add(new VistaInicio(this), "VistaInicio");
		cardPanel.add(new VistaJuego(this), "VistaJuego");

		add(cardPanel);

		setVisible(true);

	}

	// Método para alternar visibilidad de las vistas
	public void alternarVista(String nombreVista) {
		cardLayout.show(cardPanel, nombreVista);
	}

}

//https://stackoverflow.com/questions/28488458/cardlayout-changing-panel-from-another-class
//https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
