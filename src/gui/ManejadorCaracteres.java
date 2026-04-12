package gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class ManejadorCaracteres extends DocumentFilter{
	
	public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws BadLocationException {
		
		if ((text == null || text.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]*$")) && fb.getDocument().getLength()<1) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            java.awt.Toolkit.getDefaultToolkit().beep(); 
        }
    }
}
	


