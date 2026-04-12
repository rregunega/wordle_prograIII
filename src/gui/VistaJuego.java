package gui;

import static gui.ConfiguracionUI.COLOR_TEXTO_CLARO;
import static gui.ConfiguracionUI.FUENTE_BOTON;
import static gui.ConfiguracionUI.FUENTE_TITULO;
import static gui.ConfiguracionUI.VERDE;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.PlainDocument;

public class VistaJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private Navegable navegable;

	// TODO: obtener desde la lógica
	private final int COLUMNAS = 5; // Igual al largo de la palabra
	private final int FILAS = 6; // Igual a la cantidad de intentos

	private JTextField[][] grilla = new JTextField[FILAS][COLUMNAS];
	int filaActual=0;

	public VistaJuego(Navegable navegable) {
		this.navegable = navegable;

		setLayout(null);

		agregarTitulo("W-UNGS-dle jugando");

		JPanel panelJuego = new JPanel();
		panelJuego.setBounds(29, 82, 422, 422);
		panelJuego.setLayout(null);
		add(panelJuego);
		
		//f=filas, c=columnas
		for (int f = 0; f < FILAS; f++) {
			JPanel fila = new JPanel();
			fila.setLayout(null);
			fila.setBounds(10, 10 + f * 65, 402, 60);

			JLabel lblIntento = new JLabel("Intento " + (f + 1));
			lblIntento.setBounds(10, 23, 80, 14);
			fila.add(lblIntento);

			for (int c = 0; c < COLUMNAS; c++) {
				JTextField entradaUsuario = new JTextField();
				PlainDocument documento= (PlainDocument) entradaUsuario.getDocument();
				documento.setDocumentFilter(new ManejadorCaracteres());
				entradaUsuario.setBounds(97 + c * 56, 11, 46, 39);
				if (f > filaActual) {
					entradaUsuario.setEnabled(false);		        }
				fila.add(entradaUsuario);
				
				grilla[f][c] = entradaUsuario;
			}

			panelJuego.add(fila);
		}
		
    JButton btnEnviar = new JButton("Enviar intento ►");
    Color colorBase = VERDE;
    btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnEnviar.setFocusPainted(false);
    btnEnviar.setBorderPainted(false);
    btnEnviar.setContentAreaFilled(false);
    btnEnviar.setOpaque(true);
    btnEnviar.setBackground(colorBase);
    btnEnviar.setForeground(COLOR_TEXTO_CLARO);
    btnEnviar.setFont(FUENTE_BOTON);
    btnEnviar.setBounds(29, 530, 422, 50);
    
    btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(filaActual<FILAS-1) { filaActual++;}
				for (int c = 0; c < COLUMNAS; c++) {
					grilla[filaActual-1][c].setEnabled(false);
					grilla[filaActual][c].setEnabled(true);
				}
			}
		});
    
    btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnEnviar.setBackground(colorBase.brighter());
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnEnviar.setBackground(colorBase);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnEnviar.setBackground(colorBase.darker());
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				btnEnviar.setBackground(colorBase.brighter());
			}
		});

    add(btnEnviar);

	}

	private void agregarTitulo(String strTitulo) {
		JLabel lblNewLabel = new JLabel(strTitulo);
		lblNewLabel.setFont(FUENTE_TITULO);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 36, 464, 47);
		add(lblNewLabel);
	}

}
