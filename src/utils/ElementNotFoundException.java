package utils;

public class ElementNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepci�n que extiende de la clase Exception. Esta
	 * excepci�n se lanza cuando no se puede encontrar un elemento especificado.
	 * 
	 * @param message - Mensaje que se imprimir� por pantalla cuando se lance esta
	 *                excepci�n.
	 */
	public ElementNotFoundException(String message) {
		super(message);
	}

}
