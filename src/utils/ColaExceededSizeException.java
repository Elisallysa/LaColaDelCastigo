package utils;

public class ColaExceededSizeException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepci�n que extiende de la clase Exception. Esta
	 * excepci�n se lanza cuando se supera el tama�o de la ColaDelCastigo.
	 * 
	 * @param message - Mensaje que se imprimir� por pantalla cuando se lance esta
	 *                excepci�n.
	 */
	public ColaExceededSizeException(String message) {
		super(message);
	}
}
