package gui;

import static gui.ConfiguracionUI.COLOR_TEXTO_CLARO;
import static gui.ConfiguracionUI.FUENTE_BOTON;
import static gui.ConfiguracionUI.FUENTE_TEXTO_JUEGO;
import static gui.ConfiguracionUI.COLOR_BOTON_VIOLETA;
import static gui.ConfiguracionUI.COLOR_BOTON_VIOLETA_PERMANECE;
import static gui.ConfiguracionUI.BORDE_ENTRADA_TEXTO;
import static gui.ConfiguracionUI.GRAY;
import static gui.ConfiguracionUI.COLOR_CELDA_VERDE;
import static gui.ConfiguracionUI.COLOR_CELDA_AMARILLO;
import static gui.ConfiguracionUI.COLOR_CELDA_GRIS;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.PlainDocument;

import juego.EstadoPalabra;
import juego.Letra;
import juego.Partida;

public class VistaJuego extends JPanel {

	private static final long serialVersionUID = 1L;

	// TODO: obtener desde la lógica
	private final int COLUMNAS = 5; // Igual al largo de la palabra
	private final int FILAS = 6; // Igual a la cantidad de intentos
	private Partida partida;
	private JButton btnEnviar = new JButton("Enviar intento");
	private JTextField[][] grilla = new JTextField[FILAS][COLUMNAS];
	private int filaActual = 0;
	private Navegable navegable;

	public VistaJuego(Navegable navegable) {
		this.navegable = navegable;
		partida = new Partida();
		setLayout(null);
		revalidate();
		repaint();
		agregarBotonInstrucciones();
		// agregarTitulo("W-UNGS-dle jugando");

		JPanel panelJuego = new JPanel();
		panelJuego.setBounds(29, 82, 422, 410);
		panelJuego.setLayout(null);
		add(panelJuego);

//		//f=filas, c=columnas
		for (int f = 0; f < FILAS; f++) {
			JPanel fila = new JPanel();
			fila.setLayout(null);
			fila.setBounds(75, 6 + f * 62, 402, 62);

			for (int c = 0; c < COLUMNAS; c++) {
				JTextField entradaUsuario = new JTextField();
				Color colorBase = GRAY;
				PlainDocument documento = (PlainDocument) entradaUsuario.getDocument();
				documento.setDocumentFilter(new ManejadorCaracteres());
				documento.addDocumentListener(new DocumentListener() {
					public void insertUpdate(DocumentEvent e) {
						validarFilaActual();
					}

					public void removeUpdate(DocumentEvent e) {
						validarFilaActual();
					}

					public void changedUpdate(DocumentEvent e) {
						validarFilaActual();
					}
				});
				entradaUsuario.setBounds(c * 53, 6, 50, 50);
				entradaUsuario.setForeground(colorBase);
				entradaUsuario.setBorder(BORDE_ENTRADA_TEXTO);
				entradaUsuario.setFont(FUENTE_TEXTO_JUEGO);
				entradaUsuario.setHorizontalAlignment(JTextField.CENTER);
				if (f > filaActual) {
					entradaUsuario.setEnabled(false);
				}
				fila.add(entradaUsuario);

				grilla[f][c] = entradaUsuario;
			}

			panelJuego.add(fila);
		}

		Color colorBase = COLOR_BOTON_VIOLETA;
		Color colorPermanece = COLOR_BOTON_VIOLETA_PERMANECE;
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setFocusPainted(false);
		btnEnviar.setBorderPainted(false);
		btnEnviar.setContentAreaFilled(false);
		btnEnviar.setOpaque(true);
		btnEnviar.setBackground(colorBase);
		btnEnviar.setForeground(COLOR_TEXTO_CLARO);
		btnEnviar.setFont(FUENTE_BOTON);
		btnEnviar.setBounds(29, 503, 422, 50);
		btnEnviar.setEnabled(false);
		btnEnviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				procesarIntento();
				gano();
				perdio();
				btnEnviar.setEnabled(false);
			}
		});

		btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (btnEnviar.isEnabled()) {
					btnEnviar.setBackground(colorPermanece);
				}
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (btnEnviar.isEnabled()) {
					btnEnviar.setBackground(colorBase);
				}
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				if (btnEnviar.isEnabled()) {
					btnEnviar.setBackground(colorBase.darker());
				}
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				if (btnEnviar.isEnabled()) {
					btnEnviar.setBackground(colorBase);
				}
			}
		});

		add(btnEnviar);

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
		btnInstrucciones.setBounds(418, 22, 33, 38);

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

	private void pintarFila(Letra[] colorFinal, int fila) {

		for (int col = 0; col < COLUMNAS; col++) {

			EstadoPalabra estado = colorFinal[col].getEstado();

			if (estado.equals(EstadoPalabra.CORRECTA)) {

				grilla[fila][col].setBackground(COLOR_CELDA_VERDE);
				grilla[fila][col].setForeground(Color.WHITE);

			} else if (estado.equals(EstadoPalabra.DESPLAZADA)) {

				grilla[fila][col].setBackground(COLOR_CELDA_AMARILLO);
				grilla[fila][col].setForeground(Color.WHITE);

			} else {

				grilla[fila][col].setBackground(COLOR_CELDA_GRIS);
			}
		}
	}

	private void perdio() {
		if (partida.perdio()) {
			Ventana ventana = (Ventana) navegable;

			ventana.getVentanaPerdedor().mostrarPalabra(partida.getPalabraSecreta());

			navegable.cambiarVista("VentanaPerdedor");
		}
	}

	private void gano() {
		if (partida.gano()) {
			navegable.cambiarVista("VentanaGanador");
		}
	}

	private void procesarIntento() {

		String usuario = obtenerEntradaUsuario();
		Letra[] colorFinal = partida.verificarLetra(usuario);
		pintarFila(colorFinal, filaActual);

		if (filaActual < FILAS - 1) {
			filaActual++;
		}

		for (int col = 0; col < COLUMNAS; col++) {
			grilla[filaActual - 1][col].setEditable(false);
			grilla[filaActual - 1][col].setFocusable(false);
			grilla[filaActual][col].setEnabled(true);
		}
	}

	private String obtenerEntradaUsuario() {
		StringBuilder usuario = new StringBuilder();

		for (int posicion = 0; posicion < COLUMNAS; posicion++) {
			usuario.append(grilla[filaActual][posicion].getText());
		}

		System.out.println(usuario);
		return usuario.toString();
	}

	private void validarFilaActual() {
		int letrasEnPantalla = 0;
		for (int c = 0; c < COLUMNAS; c++) {
			if (!grilla[filaActual][c].getText().trim().isEmpty()) {
				letrasEnPantalla++;
			}
		}
		btnEnviar.setEnabled(letrasEnPantalla == COLUMNAS);
	}

	// metodo que reinicia el juego
	public void reiniciar() {
		partida = new Partida();
		filaActual = 0;

		for (int f = 0; f < FILAS; f++) {
			for (int c = 0; c < COLUMNAS; c++) {
				grilla[f][c].setText("");
				grilla[f][c].setText("");
				grilla[f][c].setText("");
				grilla[f][c].setBackground(Color.WHITE);
				grilla[f][c].setForeground(Color.GRAY);

				grilla[f][c].setEditable(true);
				grilla[f][c].setFocusable(true);

				if (f == 0) {
					grilla[f][c].setEnabled(true);
				} else {
					grilla[f][c].setEnabled(false);
				}
			}
		}

		btnEnviar.setEnabled(false);

	}

}
