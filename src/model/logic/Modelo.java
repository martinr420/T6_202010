package model.logic;




import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;



import model.data_structures.IListaDoblementeEncadenada;

import model.data_structures.ListaDoblementeEncadenada;
import model.data_structures.Nodo;
import model.data_structures.noExisteObjetoException;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IListaDoblementeEncadenada<Multa> datos;




	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ListaDoblementeEncadenada<Multa>();


	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	//	public Modelo(int capacidad)
	//	{
	//		//datos = new ArregloDinamico(capacidad);
	//	}


	public ListaDoblementeEncadenada<Multa> darDatos()
	{
		return  (ListaDoblementeEncadenada<Multa>) datos;
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Nodo<Multa> dato)
	{	
		datos.agregarNodoAlFinal(dato.darGenerico());
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 * @throws noExisteObjetoException 
	 */


	public void cargarDatos() throws noExisteObjetoException 
	{
		String path = "./data/Json.Json";
		JsonReader lector;


		try {


			ListaDoblementeEncadenada<Multa> lista = new ListaDoblementeEncadenada<Multa>();



			lector = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(lector);
			JsonObject ja = elem.getAsJsonObject();

			JsonArray features = ja.getAsJsonArray("features");


			for(JsonElement e : features)
			{



				JsonObject propiedades = (JsonObject) e.getAsJsonObject().get("properties");
				long id = propiedades.get("OBJECTID").getAsLong();
				String fecha = propiedades.get("FECHA_HORA").getAsString();
				String medioDete = propiedades.getAsJsonObject().get("MEDIO_DETE").getAsString();
				String claseVehiculo = propiedades.getAsJsonObject().get("CLASE_VEHI").getAsString();
				String tipoServicio = propiedades.getAsJsonObject().get("TIPO_SERVI").getAsString();
				String infraccion = propiedades.getAsJsonObject().get("INFRACCION").getAsString();
				String descripcion = propiedades.getAsJsonObject().get("DES_INFRAC").getAsString();
				String localidad = propiedades.getAsJsonObject().get("LOCALIDAD").getAsString();


				JsonObject geometry = (JsonObject) e.getAsJsonObject().get("geometry");

				String tipo = geometry.get("type").getAsString();

				double[] listaCoords = new double[3];

				JsonArray coordsJson = geometry.getAsJsonArray("coordinates");




				for(int i = 0; i < coordsJson.size(); i ++)
				{
					listaCoords[i] = coordsJson.get(i).getAsDouble();


				}

				Geo geometria = new Geo(tipo, listaCoords);

				Multa multa = new Multa(id, fecha, medioDete, claseVehiculo, tipoServicio, infraccion, descripcion, localidad, geometria);


				Nodo<Multa> nMulta = new Nodo<Multa>(multa);
				agregar(nMulta);

			} //llave for grande

		}//llave try
		catch (IOException e) 
		{
			e.printStackTrace();
		}


	} //llave metodo

	public String retornarreq1() throws noExisteObjetoException
	{
		return "El total de comparendos son: " + datos.darTamano()+". el primer comparendo de la lista es: "
				+ datos.darPrimero().toString() +".";
	}

	public Comparable[] copiarComparendos() throws noExisteObjetoException
	{
		Comparable[] comparables = new Comparable[datos.darTamano()];

		for(int i = 0; i < datos.darTamano(); i++)
		{
			comparables[i] = datos.darNodoEnPos(i);
		}
		if(comparables.length > 0)
		{
			System.out.println("El arreglo fue creado con exito");

		}

		else 
		{
			System.out.println("fail");
		}


		return comparables;
	}


	public void shellSort(Comparable[] datos)
	{


		long inicio = System.currentTimeMillis();
		int salto = datos.length/2;

		while( salto != 0 )
		{
			boolean intercambio = true;

			while(intercambio)
			{ 
				intercambio = false;
				for(int i = salto; i < datos.length; i++)
				{
					if(datos[i-salto].compareTo(datos[i]) > 0)
					{ 
						Comparable temp = datos[i]; 
						datos[i] = datos[i-salto];
						datos[i-salto] = temp;
						intercambio=true;
					}
				}

			}
			salto/=2;
		}

		long fin = System.currentTimeMillis();

		long tiempo = fin - inicio ;


		System.out.println("el tiempo total es de: " + tiempo );
		System.out.println("los primeros comparendos son: ");
		for(int j = 1; j <= 10; j++ )
		{
			System.out.println(j + " " + datos[j-1].toString());
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("los ultimos comparendos son: ");
		for(int k = datos.length - 11; k < datos.length; k++)
		{
			System.out.println(k+1 + " " + datos[k].toString());
		}

		System.out.println("----------------------------------------------------------");
	}

	public void mergeSort(Comparable datos[], int izq, int der)
	{
		long inicio = System.currentTimeMillis();
		if(izq < der)
		{
			//Encuentra el punto medio del vector.
			int mid = (izq + der) / 2;

			//Divide la primera y segunda mitad (llamada recursiva).
			mergeSort(datos, izq, mid);
			mergeSort(datos, mid+1, der);

			//Une las mitades.
			merge(datos, izq, mid, der);
		}

	}
	public void merge(Comparable datos[], int izq, int mid, int der)
	{
		//Encuentra el tamaño de los sub-vectores para unirlos.
		int n1 = mid - izq + 1;
		int n2 = der - mid;

		//Vectores temporales.
		Comparable izqArray[] = new Comparable [n1];
		Comparable derArray[] = new Comparable[n2];

		//Copia los datos a los arrays temporales.
		for (int i=0; i < n1; i++) {
			izqArray[i] = datos[izq+i];
		}
		for (int j=0; j < n2; j++) {
			derArray[j] = datos[mid + j + 1];
		}
		/* Une los vectorestemporales. */

		//Índices inicial del primer y segundo sub-vector.
		int i = 0, j = 0;

		//Índice inicial del sub-vector arr[].
		int k = izq;

		//Ordenamiento.
		while (i < n1 && j < n2) {
			if (izqArray[i].compareTo(derArray[j]) < 0) {
				datos[k] = izqArray[i];
				i++;
			} else {
				datos[k] = derArray[j];
				j++;
			}
			k++;
		}//Fin del while.

		/* Si quedan elementos por ordenar */
		//Copiar los elementos restantes de leftArray[].
		while (i < n1) {
			datos[k] = izqArray[i];
			i++;
			k++;
		}
		//Copiar los elementos restantes de rightArray[].
		while (j < n2) {
			datos[k] = derArray[j];
			j++;
			k++;
		}
	}


	public void darInfoMergeSort(Comparable[] datos, int izq, int der)
	{
		long inicio = System.currentTimeMillis();
		
		mergeSort(datos, izq, der);
				
		long fin = System.currentTimeMillis();

		long time = fin - inicio;

		System.out.println("el tiempo total de ejecucion es de " + time);

		System.out.println("Los primeros 10 objetos del arreeglo son");
		for(int i = 0; i < 10; i++)
		{
			System.out.println(datos[i].toString());
		}
		System.out.println("--------------------------------------------------");
		System.out.println("Los ultimos datos son: ");
		for(int j = datos.length-11; j < datos.length; j++)
		{
			System.out.println(datos[j].toString());
		}
	}

}//llave clase