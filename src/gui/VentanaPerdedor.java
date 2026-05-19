package gui;

import static gui.ConfiguracionUI.COLOR_BOTON_VIOLETA;
import static gui.ConfiguracionUI.COLOR_TEXTO_CLARO;
import static gui.ConfiguracionUI.FUENTE_BOTON;
import static gui.ConfiguracionUI.FUENTE_TITULO;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaPerdedor extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VentanaPerdedor(Navegable navegable) {
        setLayout(null); // Manteniendo el estilo de diseño absoluto de las otras vistas

        JLabel lblVictoria = new JLabel("QUE LASTIMA, PERDISTE");
        lblVictoria.setFont(FUENTE_TITULO);
        lblVictoria.setHorizontalAlignment(SwingConstants.CENTER);
        lblVictoria.setBounds(10, 150, 464, 47);
        add(lblVictoria);

        JButton btnVolver = new JButton("Volver al Inicio");
        btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnVolver.setFocusPainted(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setOpaque(true);
        btnVolver.setBackground(COLOR_BOTON_VIOLETA);
        btnVolver.setForeground(COLOR_TEXTO_CLARO);
        btnVolver.setFont(FUENTE_BOTON);
        btnVolver.setBounds(140, 300, 200, 50);
        
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                navegable.cambiarVista("VistaInicio"); // Utiliza la interfaz para navegar
            }
        });
        
        add(btnVolver);
    }

	public void cambiarVista(String nombreVista) {
		
	}
}
