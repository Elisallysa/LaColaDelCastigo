package utils;

public class ElementNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepción que extiende de la clase Exception. Esta
	 * excepción se lanza cuando no se puede encontrar un elemento especificado.
	 * 
	 * @param message - Mensaje que se imprimirá por pantalla cuando se lance esta
	 *                excepción.
	 */
	public ElementNotFoundException(String message) {
		super(message);
	}

}
