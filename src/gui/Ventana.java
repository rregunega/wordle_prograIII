package gui;

import static gui.ConfiguracionUI.*;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import juego.Dificultad;
import juego.Idioma;

public class Ventana extends JFrame implements Navegable {

	private static final long serialVersionUID = 1L;

	private CardLayout cardLayout = new CardLayout();
	private JPanel cardPanel = new JPanel();
	private VistaJuego vistaJuego;
	private VentanaPerdedor ventanaPerdedor;
	private VentanaGanador ventanaGanador;
	private Dificultad dificultadElegida = Dificultad.FACIL;
	private Idioma idiomaElegido = Idioma.ESPANOL;

	public Ventana() {

		setTitle("W-UNGS-dle!");
		setBackground(COLOR_FONDO_PRIMARIO);
		setSize(500, 647); // Medidas de la ventana
		setLocationRelativeTo(null); // Centro la ventana en la pantalla
		setResizable(false); // Evito que la pantalla se redimencione
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cardPanel.setLayout(cardLayout);

		cardPanel.add(new VistaInicio(this), "VistaInicio");

		vistaJuego = new VistaJuego(this);
		cardPanel.add(vistaJuego, "VistaJuego");

		cardPanel.add(new VistaInstrucciones(this), "VistaInstrucciones");
		ventanaGanador = new VentanaGanador(this);
		cardPanel.add(ventanaGanador, "VentanaGanador");

		ventanaPerdedor = new VentanaPerdedor(this);
		cardPanel.add(ventanaPerdedor, "VentanaPerdedor");

		add(cardPanel);

		cardLayout.show(cardPanel, "VistaInicio");
		setVisible(true);

	}

	public VentanaPerdedor getVentanaPerdedor() {
		return ventanaPerdedor;
	}

	public VentanaGanador getVentanaGanador() {
		return ventanaGanador;
	}

	public void iniciarNuevaPartida(Dificultad dificultad, Idioma idioma) {
		dificultadElegida = dificultad;
		idiomaElegido = idioma;
		crearVistaJuegoNueva();
		cardLayout.show(cardPanel, "VistaJuego");
	}

	// Método para alternar visibilidad de las vistas
	@Override
	public void cambiarVista(String nombreVista) {

		if (nombreVista.equals("NuevaPartida")) {
			crearVistaJuegoNueva();
			cardLayout.show(cardPanel, "VistaJuego");
			return;
		}
		if (nombreVista.equals("VistaInicio")) {
			vistaJuego.limpiarTablero();
		}
		cardLayout.show(cardPanel, nombreVista);
	}

	private void crearVistaJuegoNueva() {
		cardPanel.remove(vistaJuego);
		vistaJuego = new VistaJuego(this);
		cardPanel.add(vistaJuego, "VistaJuego");
		vistaJuego.reiniciar(dificultadElegida, idiomaElegido);
		cardPanel.revalidate();
		cardPanel.repaint();
	}

}

