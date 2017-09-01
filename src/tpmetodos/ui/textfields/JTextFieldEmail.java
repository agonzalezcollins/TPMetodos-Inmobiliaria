package tpmetodos.ui.textfields;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * JTextField que permite letras, arrobas y puntos.
 * @author Agu
 */
public final class JTextFieldEmail extends JTextField 
{
	private static final long serialVersionUID = 1L;

	private final static int NUMERO_MAX_COLUMNAS = 10;
	private final static int NUMERO_MAX_CARACTERES = 20;

	/**
	 * <i>Constructor:</i></br>
	 * Setear el numero de caracteres por defecto
	 * 
	 */
	public JTextFieldEmail() {
       this(NUMERO_MAX_COLUMNAS,NUMERO_MAX_CARACTERES);
	}
	
	/**
	 * <i>Constructor:</i></br>
	 * Setear el numero de caracteres aceptados
	 * 
	 * @param cols
	 */
	public JTextFieldEmail(int cols, int limite) {
		super(cols);
		this.addKeyListener(new EscucharTechado(this,limite));
	}

	@Override
	protected Document createDefaultModel() 
	{
		return new JTextFieldEmail.EmailDocument();
	}

	/**
	 * Clase: Modelo de Documento para Emails
	 * 
	 * @author Agu
	 *
	 */
	private static class EmailDocument extends PlainDocument {
		private static final long serialVersionUID = 1L;

		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
			if (str == null)
				return;
			
			char[] entrada = str.toCharArray();
			String salida = "";
						
			for (int i = 0 ; i < entrada.length; i++) {
				if ( Character.isLetter(entrada[i]) )
                    salida += ((Character) Character.toUpperCase(entrada[i])).toString();
                else if ( entrada[i] == '.' || entrada[i] == '@' || entrada[i] == '-' || entrada[i] == '_' || Character.isDigit(entrada[i]) )
                    salida += ((Character) entrada[i]).toString();
			}
						
			super.insertString(offs, salida, a);
		}
	}
	
	/**
	 * InerClass Escuchar el techado - Implementa KeyListener.
	 * 
	 * @author Agu
	 */
	private class EscucharTechado implements KeyListener {
		
		private JTextField jtf;
		private int limite;
		
		public EscucharTechado(JTextField jtf, int limite){
			this.jtf = jtf;
			this.limite = limite;
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e){
			if (jtf.getText().length()== this.limite)
				e.consume();
		}
		
	}
}