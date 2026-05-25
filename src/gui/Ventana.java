package gui;

import static gui.ConfiguracionUI.*;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame implements Navegable {

	// Agregado por autofix de Eclipse
	private static final long serialVersionUID = 1L;

	private CardLayout cardLayout = new CardLayout();
	private JPanel cardPanel = new JPanel();
	private VistaJuego vistaJuego;

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

		vistaJuego = new VistaJuego(this);
		cardPanel.add(vistaJuego, "VistaJuego");

		cardPanel.add(new VistaInstrucciones(this), "VistaInstrucciones");
		cardPanel.add(new VentanaGanador(this), "VentanaGanador");
		cardPanel.add(new VentanaPerdedor(this), "VentanaPerdedor");
		add(cardPanel);

		cardLayout.show(cardPanel, "VistaInicio");
		setVisible(true);

	}

	// Método para alternar visibilidad de las vistas
	@Override
	public void cambiarVista(String nombreVista) {

		if (nombreVista.equals("NuevaPartida")) {
			vistaJuego.reiniciar();
			cardLayout.show(cardPanel, "VistaJuego");
			return;
		}
		cardLayout.show(cardPanel, nombreVista);
	}

}

//https://stackoverflow.com/questions/28488458/cardlayout-changing-panel-from-another-class
//https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
