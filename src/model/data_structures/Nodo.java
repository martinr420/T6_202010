package model.data_structures;


public class Nodo<K> 
{

	private K generic;
	
	private Nodo<K> izq;
	
	private Nodo<K> der;
	
	public Nodo(K pGeneric)
	
	{
		izq = null;
		
		der = null;
		
		generic = pGeneric;
				
	}
	
	
	public Nodo<K> darIzq()
	{
		return  izq;
	}
	
	
	public Nodo<K> darDer()
	{
		return  der;
	}
	
	public void cambiarIzq(Nodo<K> pIzq)
	{
		izq = pIzq;
	}
	
	public void cambiarDer(Nodo<K> pDer )
	{
		der = pDer;
	}
	
	public void desconectarIzq()
	{
		izq = null;
	}
	
	public void desconectarDer()
	{
		der = null;
	}
	
	public K generic()
	{
		return generic;
	}





	

}
