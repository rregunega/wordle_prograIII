package gui;

import static gui.ConfiguracionUI.*;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public class VistaInicio extends JPanel {

	private static final long serialVersionUID = 1L;
	private Navegable navegable;
	private Image fondo;

	public VistaInicio(Navegable navegable) {
		this.navegable = navegable;

		cargarFondo();

		setLayout(null);

		agregarIconoWordle();

		agregarTitulo();

		agregarBotonEmpezar();

		agregarBotonInstrucciones();

	}

	private void agregarIconoWordle() {

		JLabel lblNewLabel = new JLabel("");
		ImageIcon iconWordle = new ImageIcon(
				VistaInicio.class.getResource("/recursosUtilizados/recursosVistaInicio/icons/wordleIcono.png"));

		Image iconTamaño = iconWordle.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

		ImageIcon iconNuevo = new ImageIcon(iconTamaño);

		lblNewLabel.setIcon(iconNuevo);
		lblNewLabel.setBounds(215, 149, 66, 59);

		add(lblNewLabel);

	}

	private void agregarTitulo() {
		JLabel tituloLabel = new JLabel("Wordle");
		tituloLabel.setFont(FUENTE_TITULO);
		tituloLabel.setFont(fuenteTTFTitulo.deriveFont(60f));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		tituloLabel.setBounds(10, 219, 464, 59);
		add(tituloLabel);
	}

	private void agregarBotonEmpezar() {
		Color colorBase = COLOR_BOTON_VIOLETA;
		Color colorPermanece = COLOR_BOTON_VIOLETA_PERMANECE;

		JLabel subtitulo = new JLabel("<html><div style='text-align:center;'>" + "Ten 6 oportunidades de adivinar<br>"
				+ "la palabra de 5 letras." + "</div></html>");
		subtitulo.setForeground(new Color(0, 0, 0));
		subtitulo.setFont(new Font("Bookman Old Style", Font.ITALIC, 18));
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setBounds(10, 289, 458, 73);
		add(subtitulo);

		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.setBounds(188, 379, 112, 46);
		add(btnEmpezar);
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegable.cambiarVista("VistaJuego");
			}
		});

		btnEmpezar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmpezar.setFocusPainted(false);
		btnEmpezar.setBorderPainted(false);
		btnEmpezar.setContentAreaFilled(false);
		btnEmpezar.setOpaque(true);
		btnEmpezar.setBackground(COLOR_BOTON_VIOLETA);
		btnEmpezar.setForeground(CLARO);
		btnEmpezar.setFont(FUENTE_BOTON);

		// Hover + Press effect
		btnEmpezar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnEmpezar.setBackground(colorPermanece);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnEmpezar.setBackground(colorBase);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnEmpezar.setBackground(colorBase.darker());
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				btnEmpezar.setBackground(colorBase);
			}
		});
	}

	private void agregarBotonInstrucciones() {
		ImageIcon iconOriginal = new ImageIcon(
				VistaInicio.class.getResource("/recursosUtilizados/recursosVistaInicio/icons/signoPregunta.png"));
		ImageIcon iconEncima = new ImageIcon(
				VistaInicio.class.getResource("/recursosUtilizados/recursosVistaInicio/icons/signoPreguntaEncima.png"));
		ImageIcon iconClick = new ImageIcon(
				VistaInicio.class.getResource("/recursosUtilizados/recursosVistaInicio/icons/signoPreguntaOscuro.png"));

		Image iconTamañoOriginal = iconOriginal.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		Image iconTamañoEncima = iconEncima.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		Image iconTamañoClick = iconClick.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		ImageIcon iconNuevo = new ImageIcon(iconTamañoOriginal);
		ImageIcon iconPermanece = new ImageIcon(iconTamañoEncima);
		ImageIcon iconPresinado = new ImageIcon(iconTamañoClick);

		JButton btnInstrucciones = new JButton();

		btnInstrucciones.setIcon(iconNuevo);
		btnInstrucciones.setBounds(310, 385, 33, 38);

		btnInstrucciones.setBorderPainted(false);
		btnInstrucciones.setContentAreaFilled(false);
		btnInstrucciones.setFocusPainted(false);
		btnInstrucciones.setOpaque(false);
		btnInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegable.cambiarVista("VistaInstrucciones");
			}
		});
		add(btnInstrucciones);
		btnInstrucciones.setDoubleBuffered(true);
		btnInstrucciones.setActionCommand("Intrucciones");
		{

			btnInstrucciones.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					btnInstrucciones.setIcon(iconPermanece);
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					btnInstrucciones.setIcon(iconNuevo);
				}

				public void mousePressed(java.awt.event.MouseEvent evt) {
					btnInstrucciones.setIcon(iconPresinado);
				}

				public void mouseReleased(java.awt.event.MouseEvent evt) {
					btnInstrucciones.setIcon(iconPermanece);
				}
			});

		}
	}

	private void cargarFondo() {
		fondo = new ImageIcon(
				getClass().getResource("/recursosUtilizados/recursosVistaInicio/wallpaper/wallpaperClaro.jpg"))
				.getImage();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
	}
}
