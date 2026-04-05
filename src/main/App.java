package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class App {

	// le quitamos la responsabilidad de iniciar la aplicacion a la vista
	// creando un punto de acceso
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			setearLookAndFeel();

		});
	}

	private static void setearLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
