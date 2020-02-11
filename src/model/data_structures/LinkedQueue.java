package model.data_structures;

import java.util.Iterator;

public class LinkedQueue <K> implements ILinkedQueue <K>, Iterable <K> 

{
 
	private Nodo<K> primero;

	private Nodo<K> ultimo;

	private int tamano;

	
	public LinkedQueue ()
	{
		primero = null;

		ultimo = null;

		tamano = 0;
	}
	
	
	@Override
	public void enqueue(Nodo <K> item) {
		
		if(primero == null)
		{
			primero = item;
			ultimo = item;

		}
		else
		{
			item.cambiarAnterior(ultimo);
			ultimo.cambiarSiguiente(item);
			ultimo = item;
		}

		tamano++;
		
	}

	@Override
	public Nodo<K> dequeue() throws noExisteObjetoException
	{
		// TODO Auto-generated method stub
		
		if(tamano == 0)
		{
			throw new noExisteObjetoException();
		}
		else
		{
			Nodo<K> aEliminar = ultimo;
			
			if(aEliminar.darAnterior() != null)
			{
				
				ultimo = aEliminar.darAnterior();

				ultimo.desconectarSiguiente();
				


			}
			else
			{
			
				ultimo = null;
				primero = null;
				


			}



			tamano--;

			return aEliminar;
		}
	}

	@Override
	public boolean isEmpty() {
		boolean si = false;
		
		if (tamano == 0)
		{
			si = true;
		}
		
		return si;
	}

	@Override
	public int size() {
		
		return tamano;
	}


	@Override
	public Nodo<K> darPrimero() throws noExisteObjetoException
	{
		
		
		
		if (primero == null)
		{
			throw new noExisteObjetoException();
		}
		
		else return primero;
	}


	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return primero;
	}
	
	

}