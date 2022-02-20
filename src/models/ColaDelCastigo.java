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
	// Elemento gen�rico E:
	private E element;
	// Lista de gen�ricos de la interfaz List
	private List<E> list;
	// Interfaz de comparador de gen�ricos
	private Comparator<E> comp;

	// Constructor
	/**
	 * Una ColaDelCastigo recibe como par�metro un comparador de gen�ricos (E) y
	 * est� constituida por un ArrayList (que implementa la interfaz List).
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

	// M�todos
	// (1) M�todos de la interfaz Queue:

	/**
	 * M�todo que a�ade un elemento E a la cola sin violar restricciones de
	 * capacidad.
	 * 
	 * @param elem - Elemento gen�rico que se desea a�adir a la cola.
	 * @return true: si la Cola del Castigo cambia tras llamar al m�todo; false: si
	 *         la Cola no cambia.
	 * @throws ColaExceededSizeException    - Excepci�n que se lanza cuando la cola
	 *                                      ya contiene 10 elementos.
	 * @throws LlevateTuNullDeAquiException - Excepci�n que se lanza cuando se
	 *                                      intenta introducir un elemento nulo.
	 */
	public boolean add(E elem) throws Exception {
		try {
			if (list.size() < 10 && elem != null) {
				list.add(elem);
				list.sort(this.comp);
				return true;
			} else if (list.size() >= 10) {
				throw new ColaExceededSizeException("La Cola del Castigo no admite m�s de 10 elementos.");
			} else if (elem == null) {
				throw new LlevateTuNullDeAquiException("Ya lo has le�do, ll�vate tu sucio null de aqu�.");
			}
		} catch (ClassCastException cce) {
			System.out
					.println("La clase del elemento especificado no permite que sea a�adido a esta Cola del Castigo.");
		} catch (IllegalArgumentException iae) {
			System.out.println("Alguna propiedad de este elemento no permite que sea a�adido a esta Cola del Castigo.");
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
	 *                                   impiede que sea a�adido a la Cola del
	 *                                   Castigo.
	 * @throws ColaExceededSizeException si al introducir el elemento especificado
	 *                                   se supera el tama�o m�ximo de la Cola del
	 *                                   Castigo.
	 */
	public boolean offer(E e) throws Exception {
		if (list.size() < 10 && e != null) {
			list.add(e);
			list.sort(this.comp);
			return true;
		} else if (e == null) {
			throw new LlevateTuNullDeAquiException("Ya lo has le�do, ll�vate tu sucio null de aqu�.");
		}
		return false;
	}

	/**
	 * Recupera y elimina la cabeza de la Cola del Castigo.
	 *
	 * @return la cabeza de la Cola del Castigo.
	 * @throws ElementBlockedException - si la cabeza de la Cola es el �nico
	 *                                 elemento de la misma, no podr� vaciarse.
	 * @throws NoSuchElementException  - si la Cola del Castigo est� vac�a.
	 */
	public E remove() throws ElementBlockedException {
		if (this.list.size() > 1) {
			E elemento = this.list.get(0);
			this.list.remove(this.list.get(0));
			return elemento;
		} else if (this.list.size() == 0) {
			throw new NoSuchElementException("Operaci�n no permitida, la Cola del Castigo est� vac�a.");
		} else if (this.list.size() == 1) {
			throw new ElementBlockedException("La Cola del Castigo no puede vaciarse completamente una vez rellenada.");
		}
		return null;
	}

	/**
	 * Recupera y elimina la cabeza de la Cola del Castigo o devuelve null si la
	 * Cola est� vac�a.
	 *
	 * @return la cabeza de la Cola, o {@code null} si la Cola est� vac�a
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
	 * del m�todo peek en que lanza una excepci�n si la Cola est� vac�a.
	 *
	 * @return la cabeza de la Cola del Castigo
	 * @throws NoSuchElementException - si la Cola del Castigo est� vac�a.
	 */
	public E element() {
		if (!this.list.isEmpty()) {
			return this.list.get(0);
		} else {
			throw new NoSuchElementException("La Cola del Castigo est� vac�a.");
		}
	}

	/**
	 * Recupera, pero no elimina, la cabeza de la Cola del Castigo.
	 *
	 * @return la cabeza de la Cola del Castigo, o {@code null} si la Cola est�
	 *         vac�a
	 */
	public E peek() {
		if (!this.list.isEmpty()) {
			return this.list.get(0);
		} else {
			return null;
		}
	}

	// (2) M�todos de la interfaz List:
	/**
	 * M�todo que elimina un Objeto concreto contenido en la cola.
	 * 
	 * @param o - Objeto concreto que se desea eliminar.
	 * @return false - Si se elimina correctamente el objeto.
	 * @throws ElementBlockedException  - Si la cola solo contiene ese Objeto, no
	 *                                  podr� eliminarlo porque la cola se quedar�a
	 *                                  vac�a.
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
	 * M�todo que elimina todos los objetos que contiene la cola menos uno.
	 * 
	 * @throws Exception - Cuando procede a eliminar el �ltimo o �nico elemento de
	 *                   la cola, lanza una excepci�n que indica que esta no se
	 *                   puede vaciar completamente.
	 */

	public void clear() throws Exception {
		if (this.list.size() > 1)
			for (int i = this.list.size() - 1; i > 0; i--) {
				this.list.remove(this.list.get(i));
			}
	}

	/**
	 * M�todo que devuelve el tama�o de la ColaDelCastigo.
	 * 
	 * @return - N�mero entero que corresponde al tama�o de la ColaDelCastigo.
	 */
	public int size() {
		return this.list.size();
	}

	/**
	 * M�todo que muestra si la ColaDelCastigo est� vac�a o no.
	 * 
	 * @return true: si la ColaDelCastigo est� vac�a; false: si no est� vac�a.
	 */
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	/**
	 * M�todo que muestra si la ColaDelCastigo contiene un Objeto concreto o no.
	 * 
	 * @param o - Objeto que ha de incluir la cola o no.
	 * @return true: si contiene el objeto; false: si no contiene el objeto.
	 */
	public boolean contains(Object o) {
		return this.list.contains(o);
	}

	/**
	 * Interfaz de iterador de una colecci�n.
	 * 
	 * @return
	 */
	public Iterator<E> iterator() {
		return this.list.iterator();
	}

	/**
	 * M�todo que convierte la cola en un array.
	 * 
	 * @return - Array de los objetos que contiene la cola.
	 */
	public Object[] toArray() {
		return this.list.toArray();
	}

	/**
	 * M�todo que devuelve un array que contiene los elementos de la ColaDelCastigo.
	 * 
	 * @param <T> - el tipo de componente que contiene la cola
	 * @param a   - el array donde se van a insertar los elementos de la cola
	 * @return un array que contiene todos los elementos de la cola.
	 */
	public <T> T[] toArray(T[] a) throws Exception {
		try {
			return this.list.toArray(a);
		} catch (ArrayStoreException ase) {
			System.out.println("Se est� intentando almacenar un tipo de objeto no v�lido.");
		} catch (NullPointerException npe) {
			System.out.println("El array especificado es nulo.");
		}
		return null;
	}

	/**
	 * M�todo que comprueba si la cola contiene todos los elementos de una colecci�n
	 * espec�fica.
	 * 
	 * @param c - Colecci�n con la que se comparar� los elementos que contiene la
	 *          cola.
	 * @return true: si contiene todos los elementos de la colecci�n especificada;
	 *         false: si no los contiene.
	 */
	public boolean containsAll(Collection<?> c) {
		try {
			return this.list.containsAll(c);
		} catch (ClassCastException cce) {
			System.out.println(
					"Uno o m�s tipos de elementos contenidos en la colecci�n no son compatibles con la ColaDelCastigo.");
		} catch (NullPointerException npe) {
			System.out.println("La colecci�n es nula o contiene uno o m�s elementos nulos.");
		}
		return false;
	}

	/**
	 * M�todo que introduce todos los elementos de una colecci�n espec�fica.
	 * 
	 * @param c - Colecci�n que contiene los elementos que se introducir�n en la
	 *          ColaDelCastigo.
	 * @return true: si la ColaDelCastigo introduce correctamente los elementos de
	 *         la colecci�n; false: si no los introduce.
	 */
	public boolean addAll(Collection<? extends E> c) {

		try {
			return this.list.addAll(c);
		} catch (UnsupportedOperationException uoe) {
			System.out.println("Esta colecci�n no puede soportar esta operaci�n.");
		} catch (ClassCastException cce) {
			System.out
					.println("La clase de un elemento de esta colecci�n no permite ser a�adida a la Cola del Castigo.");
		} catch (NullPointerException npe) {
			System.out.println("Esta colecci�n es nula o contiene elementos nulos.");
		} catch (IllegalArgumentException iae) {
			System.out.println(
					"Alguna propiedad de un elemento de la colecci�n no permite que sea a�adido a la Cola del Castigo.");
		} catch (IllegalStateException ise) {
			System.out.println("No todos los elementos pueden ser a�adidos debido a restricciones de inserci�n.");
		}
		return false;
	}

	/**
	 * Elimina todos los elementos que tambi�n est�n contenidos en la colecci�n
	 * especificada.
	 * 
	 * @param c - colecci�n que contiene elementos que se desean borrar.
	 * @return true:si la ColaDelCastigo cambia tras llamar al m�todo; false: si no
	 *         cambia.
	 */
	public boolean removeAll(Collection<?> c) {
		try {
			return this.list.removeAll(c);
		} catch (UnsupportedOperationException uoe) {
			System.out.println("Esta colecci�n no puede soportar esta operaci�n.");
		} catch (ClassCastException cce) {
			System.out
					.println("La clase de un elemento de esta colecci�n no permite ser a�adida a la Cola del Castigo.");
		} catch (NullPointerException npe) {
			System.out.println("Esta colecci�n es nula o contiene elementos nulos.");
		}
		return false;

	}

	/**
	 * Retiene solo los elementos que est�n contenidos en la colecci�n especificada.
	 * Dicho de otro modo, elimina los elementos de la Cola del Castigo que no est�n
	 * contenidos en la colecci�n especificada.
	 * 
	 * @param c - colecci�n que contiene elementos que han de ser retenidos en la
	 *          Cola del Castigo.
	 * @return true: si la colecci�n cambia tras llamar al m�todo; false: si no lo
	 *         hace.
	 */
	public boolean retainAll(Collection<?> c) {
		try {
			return this.list.retainAll(c);
		} catch (UnsupportedOperationException uoe) {
			System.out.println("Esta colecci�n no puede soportar esta operaci�n.");
		} catch (ClassCastException cce) {
			System.out
					.println("La clase de un elemento de esta colecci�n no permite ser a�adida a la Cola del Castigo.");
		} catch (NullPointerException npe) {
			System.out.println("Esta colecci�n es nula o contiene elementos nulos.");
		}
		return false;
	}

	// To String
	@Override
	public String toString() {
		return "ColaDelCastigo [element=" + element + ", comp=" + comp + "]";
	}

}
