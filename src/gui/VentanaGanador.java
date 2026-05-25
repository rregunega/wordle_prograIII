package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static gui.ConfiguracionUI.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaGanador extends JPanel implements Navegable {

	private static final long serialVersionUID = 1L;
	private Image fondoGanar;
	private JLabel lblVictoria;

	/**
	 * Create the panel.
	 */
	public VentanaGanador(Navegable navegable) {
		setLayout(null); // Manteniendo el estilo de diseño absoluto de las otras vistas
		agregarFondoGanar();
		
		lblVictoria = new JLabel("¡Felicidades, ganaste!");
		lblVictoria.setFont(new Font("Segoe UI", Font.BOLD, 24));
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

	@Override
	public void cambiarVista(String nombreVista) {
		// TODO Auto-generated method stub

	}

	public void mostrarResultado(long tiempo, long mejorTiempo) {
		String textoMejor = "Sin mejor tiempo previo";
		if (mejorTiempo > 0) {
			textoMejor = "Mejor tiempo: " + mejorTiempo + " segundos";
		}
		lblVictoria.setText("<html><center>¡Felicidades, ganaste!<br>Tiempo: " + tiempo + " segundos<br>"
				+ textoMejor + "</center></html>");
	}
	private void agregarFondoGanar() {
		fondoGanar = new ImageIcon(
				getClass().getResource("/recursosUtilizados/recursosVistaInicio/wallpaper/wallpaperGanar.jpg"))
				.getImage();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondoGanar, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
	}
}
