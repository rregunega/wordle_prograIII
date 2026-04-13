package gui;

import static gui.ConfiguracionUI.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
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

		agregarTitulo();

		agregarPanelDeInstrucciones();

		agregarBotonEmpezar();

		agregarBotonInstrucciones();

	}

	private void agregarPanelDeInstrucciones() {
		JPanel panelInstrucciones = new JPanel();
		panelInstrucciones.setBorder(new LineBorder(COLOR_ACENTO, 2, true));
		panelInstrucciones.setBounds(26, 347, 422, 252);
		panelInstrucciones.setLayout(null);
		panelInstrucciones.setBackground(COLOR_FONDO_SECUNDARIO);
		add(panelInstrucciones);

		JLabel lblComoJugar = new JLabel("Cómo Jugar");
		lblComoJugar.setFont(FUENTE_SUBTITULO);
		lblComoJugar.setBounds(10, 11, 168, 37);
		panelInstrucciones.add(lblComoJugar);

		JLabel lblInstruccioens = new JLabel(
				"<html><p>Adivina la palabra secreta de 5 letras. Tienes 6 intentos para acertar. Después de cada intento, los colores te darán pistas:"
						+ "<ul><li>Verde: Letra correcta en la posición correcta</li>"
						+ "<li>Amarillo: Letra correcta pero en posición incorrecta</li>"
						+ "<li>Gris: Letra no está en la palabra</li></ul>" + "</html>");
		lblInstruccioens.setAlignmentY(Component.TOP_ALIGNMENT);
		lblInstruccioens.setVerticalTextPosition(SwingConstants.TOP);
		lblInstruccioens.setVerticalAlignment(SwingConstants.TOP);
		lblInstruccioens.setFont(FUENTE_TEXTO);
		lblInstruccioens.setBounds(20, 59, 377, 245);
		panelInstrucciones.add(lblInstruccioens);
	}

	private void agregarTitulo() {
		JLabel tituloLabel = new JLabel("Wordle");
		tituloLabel.setForeground(new Color(0, 0, 0));
		tituloLabel.setFont(fuenteTTFTitulo.deriveFont(60f));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		tituloLabel.setBounds(10, 126, 464, 59);
		add(tituloLabel);
	}

	private void agregarBotonEmpezar() {
		Color colorBase = new Color(190, 116, 252);
		Color colorEncima = new Color(170, 100, 230);

		JLabel subtitulo = new JLabel("<html><div style='text-align:center;'>" + "Ten 6 oportunidades de adivinar<br>"
				+ "la palabra de 5 letras." + "</div></html>");
		subtitulo.setForeground(new Color(0, 0, 0));
		subtitulo.setFont(new Font("Bookman Old Style", Font.ITALIC, 18));
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setBounds(10, 196, 458, 73);
		add(subtitulo);

		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.setBounds(178, 277, 112, 47);
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
		btnEmpezar.setBackground(new Color(190, 116, 252));
		btnEmpezar.setForeground(new Color(255, 255, 255));
		btnEmpezar.setFont(FUENTE_BOTON);

		// Hover + Press effect
		btnEmpezar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnEmpezar.setBackground(colorEncima);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnEmpezar.setBackground(colorBase);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnEmpezar.setBackground(colorBase.darker());
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				btnEmpezar.setBackground(colorBase.brighter());
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
		btnInstrucciones.setBounds(300, 280, 40, 40);

		btnInstrucciones.setBorderPainted(false);
		btnInstrucciones.setContentAreaFilled(false);
		btnInstrucciones.setFocusPainted(false);
		btnInstrucciones.setOpaque(false);
		btnInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnInstrucciones);
		btnInstrucciones.setDoubleBuffered(true);
		btnInstrucciones.setActionCommand("Intrucciones");
		
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
