package model.data_structures;

import java.util.Comparator;

public class MaxHeapCP<K extends Comparable<K>> implements IMaxColaCP<K> 
{
	private int tamano;
	private K[] arreglo;
	private Comparator<K> comparador;

	public MaxHeapCP(int capacidad)
	{
		tamano = 0;
		arreglo = (K[]) new Object[capacidad + 1];
	}
	public MaxHeapCP()
	{
		this(1); 
	}

	public MaxHeapCP(int capacidad, Comparator<K> pComparador)
	{
		comparador = pComparador;
		arreglo = (K[]) new Object[capacidad + 1];
		tamano = 0;
	}
	public MaxHeapCP(Comparator<K> pComparador)
	{
		this(1, pComparador);
	}
	public MaxHeapCP(K[] keys)
	{
		tamano = keys.length;
		arreglo = (K[]) new Object[keys.length + 1];
		for (int i = 0; i < tamano; i++)
		{
			arreglo[i+1] = keys[i];
		}
		for (int k = tamano/2; k >= 1; k--)
		{
			sink(k);
		}
	}

	@Override
	public int size() 
	{
		return tamano;
	}

	@Override
	public void insert(K key)
	{
		if (tamano == arreglo.length - 1)
		{
			cambiarTamano(arreglo.length*2);
		}

		arreglo[++tamano] = key;
		swim(tamano);


	}


	@Override
	public K max() throws noExisteObjetoException
	{
		if (isEmpty())
		{
			throw new noExisteObjetoException();
		}
		return arreglo[1];
	}


	@Override
	public K deleteMax() throws noExisteObjetoException 
	{ 
		if (isEmpty()) 
		{
			throw new noExisteObjetoException();
		}
		K max = arreglo[1];
		intercambiar(1, tamano--);
		sink(1);
		arreglo[tamano+1] = null;
	
		return max;
	}

	@Override
	public boolean isEmpty() 
	{
		return tamano == 0;
	}

	private void swim(int k)
	{
		while (k > 1 && esMenor(k/2, k)) 
		{
			intercambiar(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k)
	{
		while (2*k <= tamano) 
		{
			int j = 2*k;
			if (j < tamano && esMenor(j, j+1))
			{
				j++;
			}
			if (!esMenor(k, j))
			{
				break;
			}
			intercambiar(k, j);
			k = j;
		}
	}

	private boolean esMenor(int i, int j) 
	{
		if (comparador == null) 
		{
			return ((Comparable<K>) arreglo[i]).compareTo(arreglo[j]) < 0;
		}
		else 
		{
			return comparador.compare(arreglo[i], arreglo[j]) < 0;
		}
	}

	private void intercambiar(int i, int j)
	{
		K temp = arreglo[i];
		arreglo[i] = arreglo[j];
		arreglo[j] = temp;
	}

	private void cambiarTamano(int capacidad) 
	{
		K[] temp = (K[]) new Object[capacidad];
		for (int i = 1; i <= tamano; i++)
		{
			temp[i] = arreglo[i];
		}
		arreglo = temp;
	}


}
