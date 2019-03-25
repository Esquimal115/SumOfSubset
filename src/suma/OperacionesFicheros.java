package suma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class OperacionesFicheros {

	public static int[] lista = null;
	public static int[] lista2 = null;
	public static int conjunto;
	public static int suma;
	public static int numeroLineas = 1;
	public static Scanner sc;

	public OperacionesFicheros() {

	}

	public boolean leerFicheros(File ficheroEntrada) {

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(ficheroEntrada);
			br = new BufferedReader(fr);

			String linea = br.readLine();

			while (linea != null) {

				if (numeroLineas == 1) {
					String datos[] = linea.split(" ");
					int n = datos.length;
					lista = new int[n];
					lista2 = new int[n];

					for (int i = 0; i < datos.length; i++) {

						lista[i] = Integer.parseInt(datos[i]);

						lista2[i] = Integer.parseInt(datos[i]);
					}

					if (SumaConjuntos.numRepetido(lista)) {
						System.out.println("Ha introducido numeros repetidos, vuelvalo a intentar");
						System.exit(1);
					}

							//	SumaConjuntos.ordena(lista);

				} else if (numeroLineas == 2) {
					conjunto = Integer.parseInt(linea);
				} else {
					suma = Integer.parseInt(linea);
				}
				numeroLineas++;
				linea = br.readLine();

			} // Final bucle while
		} // Final del try

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	// Metodo que lee el fichero y realiza el algoritmo
	public static void entradaPorFichero() {
		System.out.print("La lista de numeros es: ");

		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + " ");
		}

		System.out.println("");
		System.out.println("Cada conjunto está formado por: " + conjunto + " elemento(s)");
		System.out.println("Con una suma total de: " + suma);

		System.out.println("Los subconjuntos formados son: ");
		System.out.println("");
		SumaConjuntos conj = new SumaConjuntos();
		conj.iniciarSumaSubconjuntos();
	}
	
	//Metodo que lee el fichero e imprime la traza
	
	public static void trazaEntradaPorFichero() {
		System.out.println("");
		System.out.println("MODO TRAZA ACTIVADO!!");
		System.out.println("");
		System.out.print("La lista de numeros es: ");

		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + " ");
		}

		System.out.println("");
		System.out.println("Cada conjunto está formado por: " + conjunto + " elemento(s)");
		System.out.println("Con una suma total de: " + suma);

		System.out.println("Los subconjuntos formados son: ");
		System.out.println("");
		SumaConjuntos conj = new SumaConjuntos();
		conj.iniciarTrazaSumaSubconjuntos();
	}
	

	// Metodo para introducir la entrada de parametros por pantalla
	public static void entradaPorPantalla() {

		System.out.println("");
		System.out.println("El fichero introducido no existe...");
		System.out.println("");
		System.out.print("Intruduzca la lista de nums: ");
		sc = new Scanner(System.in);

		String datos = sc.nextLine();

		String aux[] = datos.split(" ");
		int n = aux.length;
		lista = new int[n];

		for (int i = 0; i < aux.length; i++) {
			lista[i] = Integer.parseInt(aux[i]);
		}
		
				//SumaConjuntos.ordena(OperacionesFicheros.lista);

		System.out.print("Introduzca el numero de conjuntos que desea: ");
		int conjunto = sc.nextInt();
		OperacionesFicheros.conjunto = conjunto;

		System.out.print("Introduzca la suma total del subconjunto: ");
		int suma = sc.nextInt();
		OperacionesFicheros.suma = suma;

		System.out.println("Los subconjuntos formados son: ");
		System.out.println("");
		SumaConjuntos conj = new SumaConjuntos();
		conj.iniciarSumaSubconjuntos();
	}
	
	
	// Metodo para introducir los datos por pantalla y realizar la traza
	
	public static void trazaPorPantalla() {
		System.out.println("");
		System.out.println("MODO TRAZA ACTIVADO!!");
		System.out.println("");
		System.out.println("El fichero introducido no existe...");
		System.out.println("");
		System.out.print("Intruduzca la lista de nums: ");
		sc = new Scanner(System.in);

		String datos = sc.nextLine();

		String aux[] = datos.split(" ");
		int n = aux.length;
		lista = new int[n];

		for (int i = 0; i < aux.length; i++) {
			lista[i] = Integer.parseInt(aux[i]);
		}
			//	SumaConjuntos.ordena(OperacionesFicheros.lista);

		System.out.print("Introduzca el numero de conjuntos que desea: ");
		int conjunto = sc.nextInt();
		OperacionesFicheros.conjunto = conjunto;

		System.out.print("Introduzca la suma total del subconjunto: ");
		int suma = sc.nextInt();
		OperacionesFicheros.suma = suma;

		System.out.println("Los subconjuntos formados son: ");
		System.out.println("");
		SumaConjuntos conj = new SumaConjuntos();
		conj.iniciarTrazaSumaSubconjuntos();
	}

}