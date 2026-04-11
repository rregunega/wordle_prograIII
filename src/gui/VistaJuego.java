package gui;

import static gui.ConfiguracionUI.FUENTE_TITULO;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VistaJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private Navegable navegable;

	// TODO: obtener desde la lógica
	private final int COLUMNAS = 5; // Igual al largo de la palabra
	private final int FILAS = 6; // Igual a la cantidad de intentos

	private JTextField[][] grilla = new JTextField[FILAS][COLUMNAS];

	public VistaJuego(Navegable navegable) {
		this.navegable = navegable;

		setLayout(null);

		agregarTitulo("W-UNGS-dle jugando");

		JPanel panelJuego = new JPanel();
		panelJuego.setBounds(29, 82, 422, 422);
		panelJuego.setLayout(null);
		add(panelJuego);

		for (int i = 0; i < FILAS; i++) {
			JPanel fila = new JPanel();
			fila.setLayout(null);
			fila.setBounds(10, 10 + i * 65, 402, 60);

			JLabel lblIntento = new JLabel("Intento " + (i + 1));
			lblIntento.setBounds(10, 23, 80, 14);
			fila.add(lblIntento);

			for (int j = 0; j < COLUMNAS; j++) {
				JTextField txt = new JTextField();
				txt.setBounds(97 + j * 56, 11, 46, 39);
				fila.add(txt);

				grilla[i][j] = txt;
			}

			panelJuego.add(fila);
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

}
