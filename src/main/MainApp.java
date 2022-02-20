package main;

import java.util.Comparator;
import models.Ciudad;
import models.ColaDelCastigo;

public class MainApp {

	public static void main(String[] args) throws Exception {

		try {

			/*
			 * Comparadores para las colas de ciudades. El primero ordena por orden
			 * alfab�tico y el segundo por poblaci�n (de menor a mayor).
			 */
			Comparator<Ciudad> ComparadorAlfabetico = (Ciudad city1, Ciudad city2) -> city1.getNombre()
					.compareTo(city2.getNombre());
			Comparator<Ciudad> ComparadorPoblacion = (Ciudad city1, Ciudad city2) -> city1.getPopulation()
					- city2.getPopulation();

			/*
			 * Instancias de la clase Ciudad para usar en las pruebas.
			 */
			Ciudad c1 = new Ciudad("M�laga", 570000);
			Ciudad c2 = new Ciudad("C�rdoba", 325000);
			Ciudad c3 = new Ciudad("Sevilla", 700000);
			Ciudad c4 = new Ciudad("Madrid", 3200000);
			Ciudad c5 = new Ciudad("Barcelona", 1600000);
			Ciudad c6 = new Ciudad("Valencia", 800000);
			Ciudad c7 = new Ciudad("Bilbao", 350000);
			Ciudad c8 = new Ciudad("Santiago de Compostela", 95000);
			Ciudad c9 = new Ciudad("Ciudad Real", 75000);
			Ciudad c10 = new Ciudad("Santander", 170000);
			Ciudad c11 = new Ciudad("C�ceres", 95000);

			/*
			 * Dos Colas del Castigo con diferentes comparadores en sus par�metros:
			 */
			ColaDelCastigo<Ciudad> colita = new ColaDelCastigo<Ciudad>(ComparadorAlfabetico);
			ColaDelCastigo<Ciudad> colita2 = new ColaDelCastigo<Ciudad>(ComparadorPoblacion);

			/*
			 * *************************** PRUEBAS *************************** *************
			 * LEER ANTES DE COMENZAR LAS PRUEBAS ************* Para hacer las pruebas,
			 * desactiva los comentarios en cada prueba y ejecuta el main. Las pruebas est�n
			 * pensadas para ser ejecutadas de una en una.
			 */

			/*
			 * PRUEBA 1 - Comprobar que las ciudades se ordenan alfab�ticamente Creamos y
			 * llenamos la cola que compara alfab�ticamente:
			 */

//			colita.add(c1);
//			colita.add(c2);
//			colita.add(c3);
//			colita.add(c4);
//			colita.add(c5);
//
//
//			System.out.println("Lista ordenada alfab�ticamente:");
//			for (Ciudad c : colita.getList()) {
//				System.out.println(c);
//			}
//			System.out.println("");
//
//			colita.add(c6);
//			colita.add(c7);
//			colita.add(c8);
//			colita.add(c9);
//			colita.add(c10);
//			
//			System.out.println("La lista sigue ordenada alfab�ticamente:");
//			for (Ciudad c : colita.getList()) {
//				System.out.println(c);
//			}
//			System.out.println("");

			/*
			 * PRUEBA 2 - Comprobar que las ciudades se ordenan de mayor a menor por
			 * poblaci�n Creamos y llenamos la cola que compara por poblaci�n:
			 */

//			colita2.add(c1);
//			colita2.add(c2);
//			colita2.add(c3);
//			colita2.add(c4);
//			colita2.add(c5);
//
//			System.out.println("Lista ordenada por poblaci�n:");
//			for (Ciudad c : colita2.getList()) {
//				System.out.println(c);
//			}
//			System.out.println("");
//			
//			colita2.add(c6);
//			colita2.add(c7);
//			colita2.add(c8);
//			colita2.add(c9);
//			colita2.add(c10);
//
//			System.out.println("La lista sigue ordenada por poblaci�n:");
//			for (Ciudad c : colita2.getList()) {
//				System.out.println(c);
//			}			

			/*
			 * *********************** PRUEBAS DE EXCEPCIONES ***********************
			 */

			/**
			 * PRUEBA 1 - ElementBlockedException Insertas un elemento e intentas eliminarlo
			 * para tener tu lista vac�a.
			 */

//			colita.add(c1);
//			System.out.println(colita.getList().get(0).getNombre());
//			colita.remove(c1);

			/**
			 * PRUEBA 2 - LlevateTuNullDeAquiException Insertar un objeto null
			 */

//			colita.add(null);

			/**
			 * PRUEBA 3 - ColaExceededSizeException Prueba: insertas m�s de 10 elementos
			 */

//			colita.add(c1);
//			colita.add(c2);
//			colita.add(c3);
//			colita.add(c4);
//			colita.add(c5);
//			colita.add(c6);
//			colita.add(c7);
//			colita.add(c8);
//			colita.add(c9);
//			colita.add(c10);
//
//			System.out.println(colita.getList().get(9).getNombre());
//
//			colita.add(c11);

			/*
			 * *********************** PRUEBAS DE M�TODOS IMPLEMENTADOS DE QUEUE
			 * ***********************
			 */
			/*
			 * LEER ANTES DE EMPEZAR LAS PRUEBAS: Deja desactivados los comentarios acotados
			 * con exclamaciones (!!! --> <-- !!!) para probar todos los m�todos de QUEUE.
			 */

//			 !!! --> 

//			colita.add(c1);
//			colita.add(c2);
//			colita.add(c3);
//			colita.add(c4);
//			colita.add(c5);
//			colita.add(c6);
//			colita.add(c7);
//			colita.add(c8);
//			colita.add(c9);

// 			< -- !!!

			/*
			 * PRUEBA 1 M�TODO add() Comprobamos que devuelve true cuando se a�ade una
			 * ciudad a la Cola del Castigo
			 */

//			System.out.println(colita.add(c10));

			/*
			 * PRUEBA 2 M�TODO offer() Comprobamos que devuelve true cuando se a�ade una
			 * ciudad a la Cola del Castigo false cuando no (no lanza excepci�n).
			 */

//			System.out.println(colita.offer(c10));
//			System.out.println(colita.offer(c11));		

			/*
			 * PRUEBA 3 M�TODO remove() Comprobamos que muestra la cabeza de la
			 * ColaDelCastigo antes de eliminarla:
			 */

//			System.out.println(colita.getList().get(0)); //Cabeza de la Cola
//			System.out.println(colita.remove()); //Muestra y elimina la cabeza de la Cola
//			System.out.println(colita.getList().get(0)); //Ahora la cabeza de la Cola debe ser la siguiente Ciudad
//			
//			colita.clear(); //Eliminamos todas las ciudades hasta que quede una.
//			colita.remove(); //Lanza una excepci�n

			/*
			 * PRUEBA 4 M�TODO poll() Comprobamos que muestra la cabeza de la ColaDelCastigo
			 * antes de eliminarla. Devuelve null si est� vac�a.
			 */

//			System.out.println(colita.getList().get(0)); //Cabeza de la Cola
//			System.out.println(colita.poll()); //Muestra y elimina la cabeza de la Cola
//			System.out.println(colita.getList().get(0)); //Ahora la cabeza de la Cola debe ser la siguiente Ciudad
//			
//			System.out.println(colita2.poll()); //Si la cola est� vac�a, devuelve null.

			/*
			 * PRUEBA 5 M�TODO element() Recupera la cabeza de la ColaDelCastigo y lanza
			 * excepci�n si est� vac�a:
			 */

//			System.out.println(colita.element());
//			System.out.println(colita2.element());

			/*
			 * PRUEBA 6 M�TODO peek() Recupera la cabeza de la ColaDelCastigo y devuelve
			 * null si est� vac�a:
			 */

//			System.out.println(colita.peek());
//			System.out.println(colita2.peek());

			/*
			 * PRUEBA 7 M�TODO clear() Insertas elementos e intentas vaciar la lista.
			 * Siempre te deja un elemento dentro.
			 */

//			System.out.println("Antes del clear, el tama�o de la Cola: "+colita.size());
//			
//			colita.clear();
//			System.out.println("Despu�s del clear, el tama�o de la Cola: "+colita.size());

		} catch (Exception e) {
			System.out.println("Algo ha ido mal: " + e);
		}

	}

}
