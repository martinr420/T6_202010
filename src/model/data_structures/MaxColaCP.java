package model.data_structures;

public class MaxColaCP<K extends Comparable<K>> implements IMaxColaCP<K>
{
	private int tamano;
	private Nodo<K> primero;
	private Nodo<K> ultimo;

	public MaxColaCP()
	{
		tamano= 0;
		primero = null;
		ultimo = null;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return tamano;
	}

	@Override
	public void insert(K key) {
		Nodo<K> nuevo = new Nodo<K>(key);
		if(tamano == 0)
		{
			primero = nuevo;
			ultimo = nuevo;
			tamano++;
		}
		else
		{
		
			nuevo.cambiarAnterior(ultimo);
			ultimo.cambiarSiguiente(nuevo);
			ultimo = nuevo;
			tamano++;
		}
		// TODO Auto-generated method stub

	}

	@Override
	public K max() throws noExisteObjetoException
	{
		if(tamano == 0)
		{
			throw new noExisteObjetoException();
		}
		Nodo<K> mayor = primero;
		Nodo<K> actual = primero;
		while(actual!=null)
		{
			if(actual.generic().compareTo(mayor.generic()) > 0 )
			{
				mayor = actual;
			}
			actual = actual.darSiguiente();
		}

		
		// TODO Auto-generated method stub
		return mayor.generic();
	}

	@Override
	public K deleteMax() throws noExisteObjetoException
	{
		if(tamano == 0)
		{
			throw new noExisteObjetoException();
		}

		Nodo<K> mayor = primero;
		Nodo<K> actual = primero;
		
		while(actual != null)
		{
			if(actual.generic().compareTo(mayor.generic()) > 0)
			{
				mayor = actual;
			}
			actual = actual.darSiguiente();
		}
		desconectarNodo(mayor);
		return mayor.generic();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tamano == 0;
	}
	
	private void desconectarNodo(Nodo<K> pNodo) throws noExisteObjetoException
	{
		if(tamano == 0 || pNodo == null)
		{
			throw new noExisteObjetoException();
		}
		if(pNodo.darAnterior() != null && pNodo.darSiguiente() != null)
		{
			pNodo.darAnterior().cambiarSiguiente(pNodo.darSiguiente());
			pNodo.darSiguiente().cambiarAnterior(pNodo.darAnterior());
			pNodo.desconectarAnterior();
			pNodo.desconectarSiguiente();
		}
		else if(pNodo.darSiguiente() != null)
		{
			pNodo.darSiguiente().desconectarAnterior();
			pNodo.desconectarSiguiente();
		}
		else
		{
			pNodo.darAnterior().desconectarSiguiente();
			pNodo.desconectarAnterior();
		}
	}

	
	



}
