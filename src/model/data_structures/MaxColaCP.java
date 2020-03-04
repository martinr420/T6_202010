package model.data_structures;

public class MaxColaCP<K extends Comparable<K>> implements IMaxColaCP
{
	private int size;
	private Nodo<K> raiz;
	
	public PriorityQueue()
	{
		size = 0;
		raiz = null;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void insert(Comparable key) 
	{
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comparable max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparable deleteMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
