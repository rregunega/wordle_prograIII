package gui;

import static gui.ConfiguracionUI.COLOR_ACENTO;
import static gui.ConfiguracionUI.COLOR_FONDO_SECUNDARIO;
import static gui.ConfiguracionUI.FUENTE_SUBTITULO;
import static gui.ConfiguracionUI.FUENTE_TEXTO;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VistaInstrucciones extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Navegable navegable;
	
	public VistaInstrucciones(Navegable navegable)
	{
		this.navegable = navegable;
		
		setLayout(null);
		
		agregarPanelDeInstrucciones();
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
}
