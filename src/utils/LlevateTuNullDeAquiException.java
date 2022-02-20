package utils;

public class LlevateTuNullDeAquiException extends NullPointerException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepción que extiende de la clase Exception. Esta
	 * excepción se lanza cuando se intenta introducir un elemento nulo en la
	 * ColaDelCastigo.
	 * 
	 * @param message - Mensaje que se imprimirá por pantalla cuando se lance esta
	 *                excepción.
	 */
	public LlevateTuNullDeAquiException(String message) {
		super(message);
	}

}
