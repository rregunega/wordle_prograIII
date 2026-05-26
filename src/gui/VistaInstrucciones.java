package gui;

import static gui.ConfiguracionUI.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory; //SACAAAAAAR!!
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class VistaInstrucciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private Navegable navegable;
	private Image fondoInstrucciones;

	public VistaInstrucciones(Navegable navegable) {
		this.navegable = navegable;

		setLayout(null);

		agregarFondoInicio();

		agregarPanelDeInstrucciones();

		agregarBotonRegresar();

		agregarBotonJuego();
	}

	private void agregarPanelDeInstrucciones() {
		JPanel panelInstrucciones = new JPanel();
		panelInstrucciones.setBorder(new LineBorder(new Color(204, 153, 204), 2, true));
		panelInstrucciones.setBounds(23, 131, 437, 317);
		panelInstrucciones.setLayout(null);
		panelInstrucciones.setBackground(COLOR_FONDO_SECUNDARIO);

		panelInstrucciones.add(crearImagen("/recursosUtilizados/VistaInstrucciones/letraVerde.png", 20, 100, 30, 30));
		panelInstrucciones.add(crearImagen("/recursosUtilizados/VistaInstrucciones/letraAmarilla.png", 20, 153, 30, 30));
		panelInstrucciones.add(crearImagen("/recursosUtilizados/VistaInstrucciones/letraGris.png", 20, 200, 30, 30));

		add(panelInstrucciones);

		JLabel lblInstrucciones = new JLabel("<html>"
				+ "Adivina la palabra secreta de 5 letras. La cantidad de intentos depende de la dificultad elegida. "
				+ "Después de cada intento, los colores te darán pistas:" + "</html>");
		lblInstrucciones.setBounds(10, 11, 395, 84);
		panelInstrucciones.add(lblInstrucciones);
		lblInstrucciones.setAlignmentY(Component.TOP_ALIGNMENT);
		lblInstrucciones.setVerticalTextPosition(SwingConstants.TOP);
		lblInstrucciones.setVerticalAlignment(SwingConstants.TOP);
		lblInstrucciones.setFont(FUENTE_TEXTO_INSTRUCCIONES);

		JLabel lblInstrucciones2 = new JLabel("<html>"
				+ "<b>VERDE</b> significa que la letra está en la palabra y en la posición CORRECTA." + "<br><br>"
				+ "<b>AMARILLO</b> significa que la letra está presente en la palabra pero en la posición INCORRECTA."
				+ "<br><br>" + "<b>GRIS</b> significa que la letra NO está presente en la palabra." + "</html>");
		lblInstrucciones2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblInstrucciones2.setVerticalTextPosition(SwingConstants.TOP);
		lblInstrucciones2.setVerticalAlignment(SwingConstants.TOP);
		lblInstrucciones2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblInstrucciones2.setBounds(60, 100, 369, 139);
		panelInstrucciones.add(lblInstrucciones2);

		JLabel lblInstrucciones3 = new JLabel(
				"<html>" + "También podés elegir idioma y ver el tiempo que tardaste al ganar." + "</html>");
		lblInstrucciones3.setAlignmentY(Component.TOP_ALIGNMENT);
		lblInstrucciones3.setVerticalTextPosition(SwingConstants.TOP);
		lblInstrucciones3.setVerticalAlignment(SwingConstants.TOP);
		lblInstrucciones3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblInstrucciones3.setBounds(10, 249, 434, 57);
		panelInstrucciones.add(lblInstrucciones3);
	}

	private void agregarBotonRegresar() {
		Color colorBase = COLOR_BOTON_VIOLETA;
		Color colorPermanece = COLOR_BOTON_VIOLETA_PERMANECE;

		JButton btnRegresar = new JButton("Inicio");
		btnRegresar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegresar.setBounds(23, 39, 79, 33);
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
		btnRegresar.setFont(new Font("Segoe UI", Font.BOLD, 18));

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
		btnJugar.setBounds(181, 489, 112, 46);
		add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegable.cambiarVista("NuevaPartida");
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

		JLabel lblComoJugar = new JLabel("Cómo Jugar");
		lblComoJugar.setForeground(new Color(190, 116, 252));
		lblComoJugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblComoJugar.setBounds(23, 74, 425, 46);
		add(lblComoJugar);
		lblComoJugar.setFont(new Font("Ebrima", Font.BOLD, 27));

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

	private JLabel crearImagen(String ruta, int x, int y, int ancho, int alto) {
		System.out.println(ruta + " -> " + x + "," + y);
		ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
		Image imagenEscalada = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(imagenEscalada));
		label.setBounds(x, y, ancho, alto);
		return label;
	}
}
