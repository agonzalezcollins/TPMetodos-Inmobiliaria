package tpmetodos.utils;

/**
 * Utilidades de validacion
 * @author armandito
 *
 */
public class UtilString {
	
	public static void main(String[] args){
		System.out.println("" + isNumber("35123123"));
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isAlphaNumeric(String s){
		return isAlphaNumeric(s,true);
	}
	public static boolean isAlphaNumeric(String s,boolean spaces){
		if(spaces)
			return !s.matches("^.*[^a-zA-Z0-9 ].*$");
		else
			return !s.matches("^.*[^a-zA-Z0-9].*$");
	}
	
	/**
	 * only integers (can be negative)
	 * @param s
	 * @return
	 */
	public static boolean isNumber(String s){
		try{
			Integer.parseInt(s);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	/**
	 * only letters
	 * @param s
	 * @return
	 */
	public static boolean isAlpha(String s){
		return isAlpha(s,true);
	}
	public static boolean isAlpha(String s,boolean spaces){
		if(spaces)
			return !s.matches("^.*[^a-zA-Z ].*$");
		else
			return !s.matches("^.*[^a-zA-Z].*$");
	}
	
}
