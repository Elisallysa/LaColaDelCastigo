package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import utils.ColaExceededSizeException;
import utils.ElementBlockedException;
import utils.ElementNotFoundException;
import utils.LlevateTuNullDeAquiException;

public class ColaDelCastigo<E> {

	// Atributos
	// Elemento genérico E:
	private E element;
	// Lista de genéricos de la interfaz List
	private List<E> list;
	// Interfaz de comparador de genéricos
	private Comparator<E> comp;

	// Constructor
	/**
	 * Una ColaDelCastigo recibe como parámetro un comparador de genéricos (E) y
	 * está constituida por un ArrayList (que implementa la interfaz List).
	 * 
	 * @param comp
	 */
	public ColaDelCastigo(Comparator<E> comp) {
		super();
		this.comp = comp;
		this.list = new ArrayList<>();
	}

	// Getters y setters
	public Comparator<?> getComp() {
		return comp;
	}

	public void setComp(Comparator<E> comp) {
		this.comp = comp;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(ArrayList<E> list) {
		this.list = new ArrayList<>();
	}

	// Métodos
	// (1) Métodos de la interfaz Queue:

	/**
	 * Método que añade un elemento E a la cola sin violar restricciones de
	 * capacidad.
	 * 
	 * @param elem - Elemento genérico que se desea añadir a la cola.
	 * @return true: si la Cola del Castigo cambia tras llamar al método; false: si
	 *         la Cola no cambia.
	 * @throws ColaExceededSizeException    - Excepción que se lanza cuando la cola
	 *                                      ya contiene 10 elementos.
	 * @throws LlevateTuNullDeAquiException - Excepción que se lanza cuando se
	 *                                      intenta introducir un elemento nulo.
	 */
	public boolean add(E elem) throws Exception {
		try {
			if (list.size() < 10 && elem != null) {
				list.add(elem);
				list.sort(this.comp);
				return true;
			} else if (list.size() >= 10) {
				throw new ColaExceededSizeException("La Cola del Castigo no admite más de 10 elementos.");
			} else if (elem == null) {
				throw new LlevateTuNullDeAquiException("Ya lo has leído, llévate tu sucio null de aquí.");
			}
		} catch (ClassCastException cce) {
			System.out
					.println("La clase del elemento especificado no permite que sea añadido a esta Cola del Castigo.");
		} catch (IllegalArgumentException iae) {
			System.out.println("Alguna propiedad de este elemento no permite que sea añadido a esta Cola del Castigo.");
		}
		return false;

	}

	/**
	 * Inserta el elemento especificado en la Cola del Castigo sin violar
	 * restricciones de capacidad.
	 *
	 * @param e - Elemento que se desea introducir
	 * @return {@code true} si se ha introducido el elemento; si no {@code false}
	 * @throws IllegalArgumentException  si alguna propiedad de este elemento
	 *                                   impiede que sea añadido a la Cola del
	 *                                   Castigo.
	 * @throws ColaExceededSizeException si al introducir el elemento especificado
	 *                                   se supera el tamaño máximo de la Cola del
	 *                                   Castigo.
	 */
	public boolean offer(E e) throws Exception {
		if (list.size() < 10 && e != null) {
			list.add(e);
			list.sort(this.comp);
			return true;
		} else if (e == null) {
			throw new LlevateTuNullDeAquiException("Ya lo has leído, llévate tu sucio null de aquí.");
		}
		return false;
	}

	/**
	 * Recupera y elimina la cabeza de la Cola del Castigo.
	 *
	 * @return la cabeza de la Cola del Castigo.
	 * @throws ElementBlockedException - si la cabeza de la Cola es el único
	 *                                 elemento de la misma, no podrá vaciarse.
	 * @throws NoSuchElementException  - si la Cola del Castigo está vacía.
	 */
	public E remove() throws ElementBlockedException {
		if (this.list.size() > 1) {
			E elemento = this.list.get(0);
			this.list.remove(this.list.get(0));
			return elemento;
		} else if (this.list.size() == 0) {
			throw new NoSuchElementException("Operación no permitida, la Cola del Castigo está vacía.");
		} else if (this.list.size() == 1) {
			throw new ElementBlockedException("La Cola del Castigo no puede vaciarse completamente una vez rellenada.");
		}
		return null;
	}

	/**
	 * Recupera y elimina la cabeza de la Cola del Castigo o devuelve null si la
	 * Cola está vacía.
	 *
	 * @return la cabeza de la Cola, o {@code null} si la Cola está vacía
	 */
	public E poll() {
		if (!this.list.isEmpty()) {
			E elemento = this.list.get(0);
			boolean eliminado = this.list.remove(this.list.get(0));
			if (eliminado)
				return elemento;
		}
		return element;
	}

	/**
	 * Recupera, pero no elimina, la cabeza de la Cola del Castigo. Se diferencia
	 * del método peek en que lanza una excepción si la Cola está vacía.
	 *
	 * @return la cabeza de la Cola del Castigo
	 * @throws NoSuchElementException - si la Cola del Castigo está vacía.
	 */
	public E element() {
		if (!this.list.isEmpty()) {
			return this.list.get(0);
		} else {
			throw new NoSuchElementException("La Cola del Castigo está vacía.");
		}
	}

	/**
	 * Recupera, pero no elimina, la cabeza de la Cola del Castigo.
	 *
	 * @return la cabeza de la Cola del Castigo, o {@code null} si la Cola está
	 *         vacía
	 */
	public E peek() {
		if (!this.list.isEmpty()) {
			return this.list.get(0);
		} else {
			return null;
		}
	}

	// (2) Métodos de la interfaz List:
	/**
	 * Método que elimina un Objeto concreto contenido en la cola.
	 * 
	 * @param o - Objeto concreto que se desea eliminar.
	 * @return false - Si se elimina correctamente el objeto.
	 * @throws ElementBlockedException  - Si la cola solo contiene ese Objeto, no
	 *                                  podrá eliminarlo porque la cola se quedaría
	 *                                  vacía.
	 * @throws ElementNotFoundException - Si la cola no contiene el objeto que se
	 *                                  desea eliminar.
	 */
	public boolean remove(Object o) throws Exception {
		if (list.size() == 1) {
			throw new ElementBlockedException("La cola de castigo no puede vaciarse completamente una vez rellenada.");
		} else if (list.contains(o)) {
			return false;
		} else {
			throw new ElementNotFoundException("No puedes eliminar un objeto que no existe.");
		}
	}

	/**
	 * Método que elimina todos los objetos que contiene la cola menos uno.
	 * 
	 * @throws Exception - Cuando procede a eliminar el último o único elemento de
	 *                   la cola, lanza una excepción que indica que esta no se
	 *                   puede vaciar completamente.
	 */

	public void clear() throws Exception {
		if (this.list.size() > 1)
			for (int i = this.list.size() - 1; i > 0; i--) {
				this.list.remove(this.list.get(i));
			}
	}

	/**
	 * Método que devuelve el tamaño de la ColaDelCastigo.
	 * 
	 * @return - Número entero que corresponde al tamaño de la ColaDelCastigo.
	 */
	public int size() {
		return this.list.size();
	}

	/**
	 * Método que muestra si la ColaDelCastigo está vacía o no.
	 * 
	 * @return true: si la ColaDelCastigo está vacía; false: si no está vacía.
	 */
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	/**
	 * Método que muestra si la ColaDelCastigo contiene un Objeto concreto o no.
	 * 
	 * @param o - Objeto que ha de incluir la cola o no.
	 * @return true: si contiene el objeto; false: si no contiene el objeto.
	 */
	public boolean contains(Object o) {
		return this.list.contains(o);
	}

	/**
	 * Interfaz de iterador de una colección.
	 * 
	 * @return
	 */
	public Iterator<E> iterator() {
		return this.list.iterator();
	}

	/**
	 * Método que convierte la cola en un array.
	 * 
	 * @return - Array de los objetos que contiene la cola.
	 */
	public Object[] toArray() {
		return this.list.toArray();
	}

	/**
	 * Método que devuelve un array que contiene los elementos de la ColaDelCastigo.
	 * 
	 * @param <T> - el tipo de componente que contiene la cola
	 * @param a   - el array donde se van a insertar los elementos de la cola
	 * @return un array que contiene todos los elementos de la cola.
	 */
	public <T> T[] toArray(T[] a) throws Exception {
		try {
			return this.list.toArray(a);
		} catch (ArrayStoreException ase) {
			System.out.println("Se está intentando almacenar un tipo de objeto no válido.");
		} catch (NullPointerException npe) {
			System.out.println("El array especificado es nulo.");
		}
		return null;
	}

	/**
	 * Método que comprueba si la cola contiene todos los elementos de una colección
	 * específica.
	 * 
	 * @param c - Colección con la que se comparará los elementos que contiene la
	 *          cola.
	 * @return true: si contiene todos los elementos de la colección especificada;
	 *         false: si no los contiene.
	 */
	public boolean containsAll(Collection<?> c) {
		try {
			return this.list.containsAll(c);
		} catch (ClassCastException cce) {
			System.out.println(
					"Uno o más tipos de elementos contenidos en la colección no son compatibles con la ColaDelCastigo.");
		} catch (NullPointerException npe) {
			System.out.println("La colección es nula o contiene uno o más elementos nulos.");
		}
		return false;
	}

	/**
	 * Método que introduce todos los elementos de una colección específica.
	 * 
	 * @param c - Colección que contiene los elementos que se introducirán en la
	 *          ColaDelCastigo.
	 * @return true: si la ColaDelCastigo introduce correctamente los elementos de
	 *         la colección; false: si no los introduce.
	 */
	public boolean addAll(Collection<? extends E> c) {

		try {
			return this.list.addAll(c);
		} catch (UnsupportedOperationException uoe) {
			System.out.println("Esta colección no puede soportar esta operación.");
		} catch (ClassCastException cce) {
			System.out
					.println("La clase de un elemento de esta colección no permite ser añadida a la Cola del Castigo.");
		} catch (NullPointerException npe) {
			System.out.println("Esta colección es nula o contiene elementos nulos.");
		} catch (IllegalArgumentException iae) {
			System.out.println(
					"Alguna propiedad de un elemento de la colección no permite que sea añadido a la Cola del Castigo.");
		} catch (IllegalStateException ise) {
			System.out.println("No todos los elementos pueden ser añadidos debido a restricciones de inserción.");
		}
		return false;
	}

	/**
	 * Elimina todos los elementos que también estén contenidos en la colección
	 * especificada.
	 * 
	 * @param c - colección que contiene elementos que se desean borrar.
	 * @return true:si la ColaDelCastigo cambia tras llamar al método; false: si no
	 *         cambia.
	 */
	public boolean removeAll(Collection<?> c) {
		try {
			return this.list.removeAll(c);
		} catch (UnsupportedOperationException uoe) {
			System.out.println("Esta colección no puede soportar esta operación.");
		} catch (ClassCastException cce) {
			System.out
					.println("La clase de un elemento de esta colección no permite ser añadida a la Cola del Castigo.");
		} catch (NullPointerException npe) {
			System.out.println("Esta colección es nula o contiene elementos nulos.");
		}
		return false;

	}

	/**
	 * Retiene solo los elementos que están contenidos en la colección especificada.
	 * Dicho de otro modo, elimina los elementos de la Cola del Castigo que no están
	 * contenidos en la colección especificada.
	 * 
	 * @param c - colección que contiene elementos que han de ser retenidos en la
	 *          Cola del Castigo.
	 * @return true: si la colección cambia tras llamar al método; false: si no lo
	 *         hace.
	 */
	public boolean retainAll(Collection<?> c) {
		try {
			return this.list.retainAll(c);
		} catch (UnsupportedOperationException uoe) {
			System.out.println("Esta colección no puede soportar esta operación.");
		} catch (ClassCastException cce) {
			System.out
					.println("La clase de un elemento de esta colección no permite ser añadida a la Cola del Castigo.");
		} catch (NullPointerException npe) {
			System.out.println("Esta colección es nula o contiene elementos nulos.");
		}
		return false;
	}

	// To String
	@Override
	public String toString() {
		return "ColaDelCastigo [element=" + element + ", comp=" + comp + "]";
	}

}
