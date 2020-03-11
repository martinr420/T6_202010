package model.logic;




import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
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
	private MaxHeapCP<Multa> datosHeap;
	private MaxColaCP<Multa> datosCola;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datosCola = new MaxColaCP<Multa>();
		datosHeap = new MaxHeapCP<Multa>();
	}



	public MaxHeapCP<Multa> darDatosHeap()
	{
		return datosHeap;
	}

	public MaxColaCP<Multa> darDatosCola()
	{
		return datosCola;
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int sizeHeap()
	{
		return datosHeap.size();
	}

	public int sizeCola()
	{
		return datosCola.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregarAHeap(Nodo<Multa> dato)
	{	
		datosHeap.insert(dato.generic());
	}

	public void agregarACola(Nodo<Multa> dato)
	{
		datosCola.insert(dato.generic());
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 * @throws noExisteObjetoException 
	 */
	public List<Multa> cargarDatos() throws noExisteObjetoException 
	{
		List<Multa> muestra = new ArrayList<Multa>();

		String path = "./data/comparendos_dei_2018_small.txt";
		JsonReader lector;


		try {

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

				muestra.add(multa);
			
			} //llave for grande

		}//llave try
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		Collections.shuffle(muestra);
		return muestra;


	} //llave metodo
	
	public long cargarDatosALaCola(int tamanoMuestra)
	{
		long inicio = 0, fin = -1;
		ArrayList<Multa> muestra;
		try {
			muestra = (ArrayList<Multa>) cargarDatos();
			inicio = System.currentTimeMillis();
			for(int i = 0; i < tamanoMuestra; i++)
			{
				datosCola.insert(muestra.get(i));
			}
			fin = System.currentTimeMillis();
		} catch (noExisteObjetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fin - inicio;
	}
	
	public long  cargarDatosAlHeap(int tamanoMuestra)
	{
		long inicio = 0, fin = -1;
		ArrayList<Multa> muestra;
		try {
			muestra = (ArrayList<Multa>) cargarDatos();
			inicio = System.currentTimeMillis();
			for(int i = 0; i < tamanoMuestra; i++)
			{
				datosHeap.insert(muestra.get(i));
			}
			fin = System.currentTimeMillis();
		} catch (noExisteObjetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fin - inicio;
	}


	public String retornarreq1(int tamanoMuestra) throws noExisteObjetoException
	{
		
		
		return "El total de comparendos son: " + datosCola.size() + ". el tiempo en cargar la cola es: " + cargarDatosALaCola(tamanoMuestra) + 
				". El tiempo en cargar los datos al heap es de: " +  cargarDatosAlHeap(tamanoMuestra) + ". ";
	}

	
}//llave clase