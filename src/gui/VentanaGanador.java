package gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static gui.ConfiguracionUI.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaGanador extends JPanel implements Navegable{

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VentanaGanador(Navegable navegable) {
        setLayout(null); // Manteniendo el estilo de diseño absoluto de las otras vistas

        JLabel lblVictoria = new JLabel("¡Felicidades, ganaste!");
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

	@Override
	public void cambiarVista(String nombreVista) {
		// TODO Auto-generated method stub
		
	}
}
