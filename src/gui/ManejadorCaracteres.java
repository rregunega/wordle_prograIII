package gui;

import javax.swing.text.AttributeSet;

import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class ManejadorCaracteres extends DocumentFilter {

	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
			throws BadLocationException {

		if (string != null && string.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]*") && fb.getDocument().getLength() < 1) {

			super.insertString(fb, offset, string.toUpperCase(), attr);
		}
	}

	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {

		if (text == null || text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]*")) {

			super.replace(fb, offset, length, text == null ? null : text.toUpperCase(), attrs);
		}
	}

	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		super.remove(fb, offset, length);
	}
}
