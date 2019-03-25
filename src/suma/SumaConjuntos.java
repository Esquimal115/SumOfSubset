package suma;

import java.util.ArrayList;

/**
 *
 * @author Javier Martinez Coll
 */
public class SumaConjuntos {

	int x[];
	int suma;
	int aux;
	ArrayList<Integer> sol;
	ArrayList<Integer> solAux = new ArrayList <> ();
	int cont = 0;

	public void iniciarSumaSubconjuntos() {

		int n = OperacionesFicheros.lista.length;
		x = new int[n];

		suma = OperacionesFicheros.suma;

		if (OperacionesFicheros.lista.length < OperacionesFicheros.conjunto) {

			System.out.println
			("Error, el numero del conjunto es mayor que la lista");

			}else if(OperacionesFicheros.conjunto < 0) {
			
			System.out.println("Error, ha introducido un conjunto negativo");
				
			} else {
				// Inicializamos la llamada a la función que nos calculara el resultado
				// Inicializamos el primer parametro a 0, ya que sera la suma que lleva hasta el
				// momento la funcion
				// Iniciamos el el segundo paramentro a 0, que sera la posicion del vector x en
				// la primera llamada.
				
				sumarSubconjuntos(0, 0);
			}				
		}

	

	private void sumarSubconjuntos(int s, int k) {

		// Creamos un array list para la solucion
		sol = new ArrayList<>();
		// Inicializamos el primer elemento que vamos a tomar a 1 por defecto

		x[k] = 1;

		/*
		 * En esta primera condicion miramos si la suma del subconjunto formado hasta el
		 * momento es = a la suma que deseamos y el numero de unos que tenemos en el
		 * array x es igual que el conjunto que deseamos. Si dicha condicion se cumple,
		 * cogemos los valores del vector x iguales a 1
		 */

		if (s + OperacionesFicheros.lista[k] == suma && cuentaUnos(x) == OperacionesFicheros.conjunto) {

			for (int i = 0; i < x.length; i++) {

				if (x[i] == 1) {
					aux = OperacionesFicheros.lista[i];
					sol.add(aux);
				}
			}

			// Contador para el numero de soluciones
			cont++;
			
			System.out.print(cont + ": ");
			System.out.println(sol);

		}

		// Si el numero de 1's en el vector "x" es menor que el conjunto deseado
		// cogemos ese valor y vamos comprobando los siguientes
		// Debemos controlar tambien que la variable "k" no exceda el tamaño del vector
		// lista

		if (cuentaUnos(x) < OperacionesFicheros.conjunto && OperacionesFicheros.lista.length - 1 > k) {

			sumarSubconjuntos(s + OperacionesFicheros.lista[k], k + 1);
		}

		// Si no se cumple la condicion anterior, esa posicion del vector se marca a "0"
		// Realizamos la llamada recursiva y comprobamos el siguiente valor

		x[k] = 0;

		if (OperacionesFicheros.lista.length - 1 > k) {

			sumarSubconjuntos(s, k + 1);
		}
	}

	// Ordenacion por el metodo de la burbuja por si se desea tener el vector ordenado, 
	// aunque no es necesario

	public static void ordena(int[] a) {
		int aux;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {

				if (a[i] > a[j]) {
					aux = a[i];
					a[i] = a[j];
					a[j] = aux;
				}
			}
		}
	}

	// Función para comprobar si hay algun numero repetido en la lista

	public static boolean numRepetido(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					return true;
				}
			}
		}
		return false;
	}

	// Función que nos permite contar la cantidad de unos que hay en
	// nuestro vector de soluciones.

	public int cuentaUnos(int[] lista) {
		int cont = 0;

		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == 1) {
				cont++;
			}
		}
		return cont;
	}
	
	
	// METODOS / FUNCIONES PARA LA TRAZA 
	
	//Iniciar la traza
	public void iniciarTrazaSumaSubconjuntos() {

		int n = OperacionesFicheros.lista.length;
		x = new int[n];

		suma = OperacionesFicheros.suma;

		if (OperacionesFicheros.lista.length < OperacionesFicheros.conjunto || OperacionesFicheros.conjunto < 0) {

			System.out.println
			("Error, el numero del conjunto es mayor que la lista o ha introducido un conjunto negativo");

		} else {

			// Inicializamos la llamada a la función que nos calculara el resultado
			// Inicializamos el primer parametro a 0, ya que sera la suma que lleva hasta el
			// momento la funcion
			// Iniciamos el el segundo paramentro a 0, que sera la posicion del vector x en
			// la primera llamada.
			trazaSumaSubconjuntos(0, 0);
		}

	}
	
	
	// Traza del algoritmo
	private void trazaSumaSubconjuntos(int s, int k) {
		
		solAux.clear();
		// Creamos un array list para la solucion
		sol = new ArrayList<>();
		// Inicializamos el primer elemento que vamos a tomar a 1 por defecto

		x[k] = 1;
		System.out.println("");
		System.out.println("Exploramos el numero: " + OperacionesFicheros.lista[k]);
		System.out.println ("La suma hasta el momento es: " + (s + OperacionesFicheros.lista[k]) + " de la suma deseada " + suma);
	
		/*
		 * En esta primera condicion miramos si la suma del subconjunto formado hasta el
		 * momento es = a la suma que deseamos y el numero de unos que tenemos en el
		 * array x es igual que el conjunto que deseamos. Si dicha condicion se cumple,
		 * cogemos los valores del vector x iguales a 1
		 */

		if (s + OperacionesFicheros.lista[k] == suma && cuentaUnos(x) == OperacionesFicheros.conjunto) {
			
			recorreBooleano();

			// Contador para el numero de soluciones
			cont++;
			System.out.println("Hemos hayado una solucion!!");
			System.out.print(cont + "--> ");
			System.out.println(solAux);
			solAux.clear();
			System.out.println("***********************************************************************");
			System.out.println("***********************************************************************");
			System.out.println("");
		}

		// Si el numero de 1's en el vector "x" es menor que el conjunto deseado
		// cogemos ese valor y vamos comprobando los siguientes
		// Debemos controlar tambien que la variable "k" no exceda el tamaño del vector
		// lista
		
		
		

		if (cuentaUnos(x) < OperacionesFicheros.conjunto && OperacionesFicheros.lista.length - 1 > k) {
			
			System.out.println("Numero elementos en array solucion --> " + cuentaUnos(x));
			
			recorreBooleano();
				
			System.out.println("Añadimos el elemento " + OperacionesFicheros.lista[k]);
			System.out.println("Nuestro array temporal de soluciones es: " + solAux );
			System.out.println("Seguimos explorando soluciones!!");
			trazaSumaSubconjuntos(s + OperacionesFicheros.lista[k], k + 1);
		}

		// Si no se cumple la condicion anterior, esa posicion del vector se marca a "0"
		// Realizamos la llamada recursiva y comprobamos el siguiente valor
		
		x[k] = 0;

		if (cuentaUnos(x) < OperacionesFicheros.conjunto && OperacionesFicheros.lista.length - 1 > k) {
			
			System.out.println("");
			System.out.println("No hemos hallado solucion y el numero de 1 es > conjunto deseado ");
			
			recorreBooleano();	
			
			System.out.println("");		
			System.out.println(OperacionesFicheros.lista[k] + " es eliminado como posible solucion");
			System.out.println("Nuestro array temporal de soluciones es: " + solAux );
			trazaSumaSubconjuntos(s, k + 1);
		}
		solAux.clear();
	}



	private void recorreBooleano() {
		for (int i = 0; i < x.length; i++) {

			if (x[i] == 1) {
				aux = OperacionesFicheros.lista[i];
				solAux.add(aux);
			}
		}
	}

}