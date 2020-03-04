package model.data_structures;

import java.util.Iterator;

public class Nodo<K> implements Iterator
{

	private K generic;
	
	private Nodo<K> anterior;
	
	private Nodo<K> siguiente;
	
	public Nodo(K pGeneric)
	
	{
		anterior = null;
		
		siguiente = null;
		
		generic = pGeneric;
				
	}
	
	
	public Nodo<K> darSiguiente()
	{
		return  siguiente;
	}
	
	
	public Nodo<K> darAnterior()
	{
		return  anterior;
	}
	
	public void cambiarSiguiente(Nodo<K> pSig)
	{
		siguiente = pSig;
	}
	
	public void cambiarAnterior(Nodo<K> pAnterior )
	{
		anterior = pAnterior;
	}
	
	public void desconectarSiguiente()
	{
		siguiente = null;
	}
	
	public void desconectarAnterior()
	{
		anterior = null;
	}
	
	public K generic()
	{
		return generic;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return this.darSiguiente() != null;
	}


	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return siguiente;
	}





	

}
