package gui;

import static gui.ConfiguracionUI.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaInicio extends JPanel {

	private static final long serialVersionUID = 1L;
  private Navegable navegable;

	public VistaInicio(Navegable navegable) {
		this.navegable = navegable;		
		
		setLayout(null);

		agregarTitulo();

		agregarPanelDeInstrucciones();

		agregarBotonEmpezar();
	}

	private void agregarPanelDeInstrucciones() {
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
	}

	private void agregarTitulo() {
		JLabel lblNewLabel = new JLabel("W-UNGS-dle");
		lblNewLabel.setFont(FUENTE_TITULO);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 36, 464, 47);
		add(lblNewLabel);
	}

	private void agregarBotonEmpezar() {
    Color colorBase = AZUL;
    
		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        navegable.cambiarVista("VistaJuego");
			}
		});
		add(btnEmpezar);
	
		btnEmpezar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmpezar.setFocusPainted(false);
		btnEmpezar.setBorderPainted(false);
		btnEmpezar.setContentAreaFilled(false);
		btnEmpezar.setOpaque(true);
		btnEmpezar.setBackground(colorBase);
		btnEmpezar.setForeground(COLOR_TEXTO_CLARO);
		btnEmpezar.setFont(FUENTE_BOTON);
		btnEmpezar.setBounds(29, 489, 422, 50);


		// Hover + Press effect
		btnEmpezar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnEmpezar.setBackground(colorBase.brighter());
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

		add(btnEmpezar);
	}

}
