package utils;

public class ColaExceededSizeException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepción que extiende de la clase Exception. Esta
	 * excepción se lanza cuando se supera el tamaño de la ColaDelCastigo.
	 * 
	 * @param message - Mensaje que se imprimirá por pantalla cuando se lance esta
	 *                excepción.
	 */
	public ColaExceededSizeException(String message) {
		super(message);
	}
}
