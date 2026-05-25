package gui;

import static gui.ConfiguracionUI.COLOR_BOTON_VIOLETA;
import static gui.ConfiguracionUI.COLOR_TEXTO_CLARO;
import static gui.ConfiguracionUI.FUENTE_BOTON;
import static gui.ConfiguracionUI.FUENTE_TITULO;
import static gui.ConfiguracionUI.COLOR_BOTON_VIOLETA_PERMANECE;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaPerdedor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblVictoria;
	private Image fondoPerder;

	/**
	 * Create the panel.
	 */
	public VentanaPerdedor(Navegable navegable) {
		setLayout(null); // Manteniendo el estilo de diseño absoluto de las otras vistas
		agregarFondoPerder();

		lblVictoria = new JLabel("PERDISTE!");
		lblVictoria.setFont(FUENTE_TITULO);
		lblVictoria.setForeground(Color.WHITE);
		lblVictoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblVictoria.setBounds(10, 226, 464, 93);
		add(lblVictoria);

		JButton btnVolver = new JButton("Volver al Inicio");
		Color colorBase = COLOR_BOTON_VIOLETA;
		Color colorPermanece = COLOR_BOTON_VIOLETA_PERMANECE;
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setFocusPainted(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(true);
		btnVolver.setBackground(COLOR_BOTON_VIOLETA);
		btnVolver.setForeground(COLOR_TEXTO_CLARO);
		btnVolver.setFont(FUENTE_BOTON);
		btnVolver.setBounds(150, 353, 178, 43);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegable.cambiarVista("VistaInicio"); // Utiliza la interfaz para navegar
			}
		});

		add(btnVolver);

		btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (btnVolver.isEnabled()) {
					btnVolver.setBackground(colorPermanece);
				}
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (btnVolver.isEnabled()) {
					btnVolver.setBackground(colorBase);
				}
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				if (btnVolver.isEnabled()) {
					btnVolver.setBackground(colorBase.darker());
				}
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				if (btnVolver.isEnabled()) {
					btnVolver.setBackground(colorBase);
				}
			}

		});

		add(btnVolver);
	}

	public void cambiarVista(String nombreVista) {

	}

	public void mostrarPalabra(String palabra) {
		lblVictoria.setText("<html><center>PERDISTE!<br>La palabra era: " + palabra + "</center></html>");
	}

	private void agregarFondoPerder() {
		fondoPerder = new ImageIcon(
				getClass().getResource("/recursosUtilizados/recursosVistaInicio/wallpaper/wallpaperPerder.jpg"))
				.getImage();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondoPerder, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
	}
}
