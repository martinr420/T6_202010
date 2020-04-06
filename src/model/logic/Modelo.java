package model.logic;




import java.io.FileReader;
import java.io.IOException;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.Queue;
import model.data_structures.RedBlackBST;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private RedBlackBST<Long, Multa> arbol;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		arbol = new RedBlackBST<Long, Multa>();
	}


	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */

	private void cargarDatos() 
	{
		String path = "./data/comparendos.geojson";
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
				String medioDete = propiedades.getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String claseVehiculo = propiedades.getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String tipoServicio = propiedades.getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String infraccion = propiedades.getAsJsonObject().get("INFRACCION").getAsString();
				String descripcion = propiedades.getAsJsonObject().get("DES_INFRACCION").getAsString();
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

				arbol.put(id, multa);

			} //llave for grande

		}//llave try
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	} //llave metodo

	
	public String retornarreq1()
	{
		cargarDatos();
		return "El total de comparendos son: " + arbol.size() + " el menor ID es: " + arbol.min() + "\n el mayor ID es: " + arbol.max();  	
	}
	
	public String reque2(long pID)
	{
		String msj = "";
		
		Multa m = arbol.get(pID);
		
		if(m == null) return "No hay comparendos con ese ID";
		
		msj += "La multa con el ID "+ pID + "es " + m.toString();
		
		return msj;
	}
	
	public String reque3(long pMin , long pMax) throws Exception 
	{
		if(pMin > pMax) throw new Exception();
		
		String msj = "";
		
		Queue<Multa> q = (Queue<Multa>) arbol.valuesInRange(pMin, pMax);
		int tam  = q.size();
		for(int i = 1; i <= tam; i++)
		{
			msj += q.dequeue().toString() + "\n";
		}
		
		return msj;
		
	}

	

	

}//llave clase