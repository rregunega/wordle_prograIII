package gui;

import javax.swing.text.AttributeSet;

import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class ManejadorCaracteres extends DocumentFilter {

	private static final String LETRA_PERMITIDA = "[a-zA-ZáéíóúÁÉÍÓÚñÑ]";

	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

		if (string != null && fb.getDocument().getLength() == 0 && string.matches(LETRA_PERMITIDA)) {
			super.insertString(fb, offset, string.toUpperCase(), attr);
		}
	}

	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {

		if (text == null) {
			super.replace(fb, offset, length, null, attrs);
			return;
		}

		int largoFinal = fb.getDocument().getLength() - length + text.length();

		if (largoFinal <= 1 && text.matches(LETRA_PERMITIDA)) {
			super.replace(fb, offset, length, text.toUpperCase(), attrs);
		}
	}

	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		super.remove(fb, offset, length);
	}
}
