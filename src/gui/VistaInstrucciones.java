package gui;

import static gui.ConfiguracionUI.CLARO;
import static gui.ConfiguracionUI.COLOR_ACENTO;
import static gui.ConfiguracionUI.COLOR_BOTON_VIOLETA;
import static gui.ConfiguracionUI.COLOR_BOTON_VIOLETA_PERMANECE;
import static gui.ConfiguracionUI.COLOR_FONDO_SECUNDARIO;
import static gui.ConfiguracionUI.FUENTE_BOTON;
import static gui.ConfiguracionUI.FUENTE_TEXTO;
import static gui.ConfiguracionUI.fuenteTTFTitulo;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.border.LineBorder;
import java.awt.Font;

public class VistaInstrucciones extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Navegable navegable;
	private Image fondoInstrucciones;
	
	public VistaInstrucciones(Navegable navegable)
	{
		this.navegable = navegable;
		
		setLayout(null);
		
		agregarFondoInicio();
		
		agregarPanelDeInstrucciones();
		
		agregarBotonRegresar();
		
		agregarBotonJuego();
	}
	
	private void agregarPanelDeInstrucciones() {
		JPanel panelInstrucciones = new JPanel();
		panelInstrucciones.setBorder(new LineBorder(COLOR_ACENTO, 2, true));
		panelInstrucciones.setBounds(23, 131, 422, 252);
		panelInstrucciones.setLayout(null);
		panelInstrucciones.setBackground(COLOR_FONDO_SECUNDARIO);
		add(panelInstrucciones);

		JLabel lblComoJugar = new JLabel("Cómo Jugar");
		lblComoJugar.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
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
	
	private void agregarBotonRegresar() {
		Color colorBase = COLOR_BOTON_VIOLETA;
		Color colorPermanece = COLOR_BOTON_VIOLETA_PERMANECE;

		JButton btnRegresar = new JButton("←");
		btnRegresar.setBounds(23, 78, 67, 33);
		add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegable.cambiarVista("VistaInicio");
			}
		});

		btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegresar.setFocusPainted(false);
		btnRegresar.setBorderPainted(false);
		btnRegresar.setContentAreaFilled(false);
		btnRegresar.setOpaque(true);
		btnRegresar.setBackground(COLOR_BOTON_VIOLETA);
		btnRegresar.setForeground(CLARO);
		btnRegresar.setFont(new Font("Segoe UI", Font.BOLD, 25));

		// Hover + Press effect
		btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnRegresar.setBackground(colorPermanece);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnRegresar.setBackground(colorBase);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnRegresar.setBackground(colorBase.darker());
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				btnRegresar.setBackground(colorBase);
			}
		});
	}
	
	private void agregarBotonJuego() {
		Color colorBase = COLOR_BOTON_VIOLETA;
		Color colorPermanece = COLOR_BOTON_VIOLETA_PERMANECE;

		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(181, 458, 112, 46);
		add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegable.cambiarVista("VistaJuego");
			}
		});

		btnJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJugar.setFocusPainted(false);
		btnJugar.setBorderPainted(false);
		btnJugar.setContentAreaFilled(false);
		btnJugar.setOpaque(true);
		btnJugar.setBackground(COLOR_BOTON_VIOLETA);
		btnJugar.setForeground(CLARO);
		btnJugar.setFont(FUENTE_BOTON);

		// Hover + Press effect
		btnJugar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnJugar.setBackground(colorPermanece);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnJugar.setBackground(colorBase);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnJugar.setBackground(colorBase.darker());
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				btnJugar.setBackground(colorBase);
			}
		});
	}	
	private void agregarFondoInicio() {
		fondoInstrucciones = new ImageIcon(
				getClass().getResource("/recursosUtilizados/recursosVistaInicio/wallpaper/wallpaperClaro.jpg"))
				.getImage();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondoInstrucciones, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
	}
}
