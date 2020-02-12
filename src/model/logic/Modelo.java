package model.logic;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ILinkedQueue;
import model.data_structures.ILinkedStack;
import model.data_structures.LinkedQueue;
import model.data_structures.LinkedStack;
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
	private ILinkedQueue<Multa> datosQueue;
	private ILinkedStack<Multa> datosStack;
	
	


	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datosStack = new LinkedStack<Multa>();
		datosQueue = new LinkedQueue<Multa>();
		
		
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
//	public Modelo(int capacidad)
//	{
//		//datos = new ArregloDinamico(capacidad);
//	}
	
	public LinkedQueue<Multa> darDatosQueue()
	{
		return  (LinkedQueue<Multa>) datosQueue;
	}
	
	
	public LinkedStack<Multa> darDatosStack()
	{
		return  (LinkedStack<Multa>) datosStack;
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datosQueue.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Nodo<Multa> dato)
	{	
		datosQueue.enqueue(dato);
		datosStack.push(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 * @throws noExisteObjetoException 
	 */
	
	
	

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 * @throws noExisteObjetoException 
	 */
	public Nodo<Multa> pop(Nodo<Multa> dato) throws noExisteObjetoException
	{
		return datosStack.pop();
	}
	
	public Nodo<Multa> dequeue() throws noExisteObjetoException
	{
		return datosQueue.dequeue();
	}

	public void cargarDatos() throws noExisteObjetoException 
	{
		String path = "./data/Gson";
		JsonReader lector;


		try {


			LinkedStack<Multa> listaStack = new LinkedStack<Multa>();
			LinkedQueue<Multa> listaQueue = new LinkedQueue<Multa>();


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
				datosQueue.enqueue(nMulta);
				datosStack.push(nMulta);

			} //llave for grande

		}//llave try
		catch (IOException e) 
		{
			e.printStackTrace();
		}


	} //llave metodo


	public LinkedQueue<Multa> procesosarColarPorComparendo() throws noExisteObjetoException
	{
		
		
		LinkedQueue<Multa> arregloFinal = new LinkedQueue<Multa>();
		Nodo<Multa> nodoActual = datosQueue.dequeue();
		Multa multaActual = nodoActual.darGenerico();
		Multa siguienteMulta = nodoActual.darSiguiente().darGenerico();
		
		String tipoMultaActual = multaActual.getInfraccion();
		
		
		LinkedQueue<Multa> arregloTemporal = new LinkedQueue<Multa>();
		
		Nodo<Multa> aEliminar = arregloTemporal.darPrimero();
		
		
		
		
		while(nodoActual.hasNext())
		{
			arregloTemporal.enqueue(nodoActual);
			
			if(!(tipoMultaActual.equals(siguienteMulta.getInfraccion())))
			
			{
				if(arregloTemporal.size() >= arregloFinal.size())
				{
					arregloFinal = arregloTemporal;
				}
				
				while(aEliminar.hasNext());
				{
					arregloTemporal.dequeue();
				}
				
				
			}
			nodoActual.next();
		}
		
		
		
		
		
		return arregloFinal;
		
	}
	
	public LinkedStack<Multa> reportarComparendos(int pCantidadComparendos, String tipoComparendo) throws noExisteObjetoException
	{
		Nodo<Multa> nodoActual = datosStack.pop();
		Multa multaActual = nodoActual.darGenerico();
		LinkedStack<Multa> pila = new LinkedStack<Multa>();
		while(nodoActual.hasNext() && pCantidadComparendos <= pila.size())
		{
			if(multaActual.getInfraccion().equals(tipoComparendo) )
			{
				pila.push(nodoActual);
			}
			
		}
		
		
		
		return pila;
	}
	
	
	
	

}//llave clase