package main;

import javax.swing.SwingUtilities;
//import javax.swing.UIManager;

import static gui.ConfiguracionUI.*;

import gui.Ventana;

public class App {

	// le quitamos la responsabilidad de iniciar la aplicacion a la vista
	// creando un punto de acceso
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			setearLookAndFeel();
			new Ventana();

		});
	}



}
