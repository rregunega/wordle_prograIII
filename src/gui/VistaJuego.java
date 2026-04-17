package gui;

import static gui.ConfiguracionUI.COLOR_TEXTO_CLARO;
import static gui.ConfiguracionUI.FUENTE_BOTON;
import static gui.ConfiguracionUI.FUENTE_TITULO;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.PlainDocument;

import juego.Estado;
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
	

	public VistaJuego(Navegable navegable) {
	
		partida = new Partida();
		
		setLayout(null);

		revalidate();
		
		repaint();

		agregarTitulo("W-UNGS-dle jugando");

		JPanel panelJuego = new JPanel();
		panelJuego.setBounds(29, 82, 422, 410);
		panelJuego.setLayout(null);
		add(panelJuego);
		

//		//f=filas, c=columnas
		for (int f = 0; f < FILAS; f++) {
			JPanel fila = new JPanel();
			fila.setLayout(null);
			fila.setBounds(10, 10 + f * 62, 402, 62);

			JLabel lblIntento = new JLabel("Intento " + (f + 1));
			lblIntento.setBounds(10, 23, 80, 14);
			fila.add(lblIntento);

			for (int c = 0; c < COLUMNAS; c++) {
				JTextField entradaUsuario = new JTextField();
				Color colorBase = GRAY;
				PlainDocument documento = (PlainDocument) entradaUsuario.getDocument();
				documento.setDocumentFilter(new ManejadorCaracteres());
				documento.addDocumentListener(new DocumentListener() {
					public void insertUpdate(DocumentEvent e) { validarFilaActual(); }
				    public void removeUpdate(DocumentEvent e) { validarFilaActual(); }
				    public void changedUpdate(DocumentEvent e) { validarFilaActual(); }})
				;
				entradaUsuario.setBounds(97 + c * 54, 6, 50, 50);
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
				btnEnviar.setEnabled(false);}}
			);
		
		btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (btnEnviar.isEnabled()) {
				btnEnviar.setBackground(colorPermanece);}
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (btnEnviar.isEnabled()) {
				btnEnviar.setBackground(colorBase);}
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				if (btnEnviar.isEnabled()) {
				btnEnviar.setBackground(colorBase.darker());}
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				if (btnEnviar.isEnabled()) {
				btnEnviar.setBackground(colorBase);}
			}
		});
		
		add(btnEnviar);

	}

	protected void nada() {
		// TODO Auto-generated method stub
		
	}

	private void pintarFila(Letra[] colorFinal, int fila) {

		for (int col = 0; col < COLUMNAS; col++) {

			String estado = colorFinal[col].getEstado();

			if (estado.equals(Estado.VERDE)) {

				grilla[fila][col].setBackground(COLOR_CELDA_VERDE);

			} else if (estado.equals(Estado.AMARILLO)) {

				grilla[fila][col].setBackground(COLOR_CELDA_AMARILLO);

			} else {

				grilla[fila][col].setBackground(COLOR_CELDA_GRIS);
			}
		}
	}

	private void agregarTitulo(String strTitulo) {
		JLabel lblNewLabel = new JLabel(strTitulo);
		lblNewLabel.setFont(FUENTE_TITULO);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 36, 464, 47);
		add(lblNewLabel);
	}
	
	private void procesarIntento() {
		
		String usuario = obtenerEntradaUsuario();
		String palabraSecreta = partida.palabra;
		System.out.println(palabraSecreta);
		
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

	private String obtenerEntradaUsuario(){
		StringBuilder usuario=new StringBuilder();
		
		for(int posicion=0; posicion<COLUMNAS; posicion++) {
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
}
