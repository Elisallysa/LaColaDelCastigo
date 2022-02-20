package utils;

public class ElementBlockedException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepción que extiende de la clase Exception. Esta
	 * excepción se lanza cuando se intenta vaciar una ColaDelCastigo a la que ya se
	 * le ha introducido algún elemento.
	 * 
	 * @param message - Mensaje que se imprimirá por pantalla cuando se lance esta
	 *                excepción.
	 */
	public ElementBlockedException (String message) {
		super(message);
	}
	
}
