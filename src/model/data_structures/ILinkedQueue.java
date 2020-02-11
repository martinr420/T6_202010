package model.data_structures;

public interface ILinkedQueue <K>


{

	public void enqueue ( Nodo <K> item);
	public Nodo<K> dequeue() throws noExisteObjetoException;
	public boolean isEmpty();
	public int size();
	public Nodo<K> darPrimero() throws noExisteObjetoException;
	
	
	
	
	
}
