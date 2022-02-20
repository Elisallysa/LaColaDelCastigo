package utils;

public class ElementBlockedException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepci�n que extiende de la clase Exception. Esta
	 * excepci�n se lanza cuando se intenta vaciar una ColaDelCastigo a la que ya se
	 * le ha introducido alg�n elemento.
	 * 
	 * @param message - Mensaje que se imprimir� por pantalla cuando se lance esta
	 *                excepci�n.
	 */
	public ElementBlockedException (String message) {
		super(message);
	}
	
}
