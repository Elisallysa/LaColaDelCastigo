package utils;

public class LlevateTuNullDeAquiException extends NullPointerException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepci�n que extiende de la clase Exception. Esta
	 * excepci�n se lanza cuando se intenta introducir un elemento nulo en la
	 * ColaDelCastigo.
	 * 
	 * @param message - Mensaje que se imprimir� por pantalla cuando se lance esta
	 *                excepci�n.
	 */
	public LlevateTuNullDeAquiException(String message) {
		super(message);
	}

}
