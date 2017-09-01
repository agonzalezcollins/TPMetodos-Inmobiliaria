package tpmetodos.ui.textfields;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.text.AttributeSet;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * JTextField que solo ingresa mayusculas
 * @author Agu
 */
public final class JTextFieldLetrasMayuscula extends JTextField
{
	private static final long serialVersionUID = 1L;

	private final static int NUMERO_MAX_CARACTERES = 50;
	private final static int NUMERO_MAX_COLUMNAS = 10;
	

	/**
	 * <i>Constructor:</i></br>
	 * Setear el numero de caracteres por defecto
	 * 
	 */
	public JTextFieldLetrasMayuscula(){	
		this(NUMERO_MAX_COLUMNAS,NUMERO_MAX_CARACTERES);
	}
	
	/**
	 * <i>Constructor:</i></br>
	 * Setear el numero de caracteres aceptados
	 * 
	 * @param cols
	 */
	public JTextFieldLetrasMayuscula(int cols, int limite) {
		super(cols);
		this.addKeyListener(new EscucharTechado(this,limite));
		
	}
	
	@Override
	protected Document createDefaultModel() {
		return new MayusDocument();
	}

	/**
	 * Clase: Modelo de Documento para Mayusculas
	 * 
	 * @author Agu
	 *
	 */
	private static class MayusDocument extends PlainDocument {
        private static final long serialVersionUID = 1L;

        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null)
                return;
			
			char[] entrada = str.toCharArray();
			String salida = "";
							
			for (int i = 0 ; i < entrada.length; i++) {// paso todo a mayuscula
				if(entrada[i]=='º' || entrada[i]=='ª')
                    continue;
				if ( Character.isLetter(entrada[i]) )
                    salida += ((Character) Character.toUpperCase(entrada[i])).toString();
                else if (entrada[i] == ' ')
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
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyTyped(KeyEvent e){
			if (jtf.getText().length()== this.limite)
				e.consume();
		}
		
	}
}