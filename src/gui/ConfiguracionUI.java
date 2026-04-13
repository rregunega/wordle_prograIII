package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;

import javax.swing.UIManager;

public class ConfiguracionUI {
	// Colores
	public static final Color COLO_PRIMARIO = new Color(59, 60, 61);
	public static final Color COLOR_PRIMARIO_CLARO = new Color(212, 234, 247);

	public static final Color COLOR_ACENTO = new Color(0, 102, 140);
	public static final Color COLOR_ACENTO_CLARO = new Color(113, 196, 239);

	public static final Color COLOR_FONDO_PRIMARIO = new Color(255, 254, 251);
	public static final Color COLOR_FONDO_SECUNDARIO = new Color(250, 244, 241);

	public static final Color COLOR_TEXTO_OSCURO = new Color(30, 31, 34);
	public static final Color COLOR_TEXTO_CLARO = new Color(255, 253, 251);

	public static final Color AZUL = new Color(13, 110, 253);
	public static final Color GRIS = new Color(108, 117, 125);
	public static final Color VERDE = new Color(25, 135, 84);
	public static final Color ROJO = new Color(220, 53, 69);
	public static final Color AMARILLO = new Color(255, 193, 7);
	public static final Color CYAN = new Color(13, 202, 240);
	public static final Color CLARO = new Color(248, 249, 250);
	public static final Color OSCURO = new Color(33, 37, 41);
	
	public static final Color COLOR_BOTON_VIOLETA = new Color(190, 116, 252);
	public static final Color COLOR_BOTON_VIOLETA_PERMANECE = new Color(170, 100, 230);

	public static Font fuenteTTFTitulo =
		    cargarFuenteBase("/recursosUtilizados/recursosVistaInicio/fuentes/Classyvogueregular.ttf");

    private static Font cargarFuenteBase(String ruta) {
    	
        try {
            InputStream is = ConfiguracionUI.class.getResourceAsStream(ruta);
            return Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Segoe UI", Font.PLAIN, 12);
        }
    }
		
	// Fuentes
	public static final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 24);
	public static final Font FUENTE_SUBTITULO = new Font("Segoe UI", Font.BOLD, 20);
	public static final Font FUENTE_TEXTO = new Font("Segoe UI", Font.PLAIN, 16);
	public static final Font FUENTE_BOTON = new Font("Segoe UI", Font.BOLD, 18);
	
	public static void setearLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
