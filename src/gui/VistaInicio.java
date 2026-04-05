package gui;

import static gui.ConfiguracionUI.*;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VistaInicio extends JPanel {

	private static final long serialVersionUID = 1L;

	public VistaInicio(Frame frame) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("W-UNGS-dle");
		lblNewLabel.setFont(FUENTE_TITULO);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 36, 464, 47);
		add(lblNewLabel);

		JPanel panelInstrucciones = new JPanel();
		panelInstrucciones.setBorder(new LineBorder(COLOR_ACENTO, 2, true));
		panelInstrucciones.setBounds(29, 145, 422, 316);
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

		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmpezar.setDefaultCapable(false);
		btnEmpezar.setBorder(null);
		btnEmpezar.setForeground(COLOR_TEXTO_CLARO);
		btnEmpezar.setBounds(29, 489, 422, 47);
		btnEmpezar.setBackground(AZUL);
		btnEmpezar.setFont(FUENTE_BOTON);
		btnEmpezar.setFocusPainted(false);
		add(btnEmpezar);
	}

}
