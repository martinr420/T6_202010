package test.data_structures;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.LinkedQueue;
import model.data_structures.Nodo;
import model.data_structures.noExisteObjetoException;

public class TestLinkedQueue <K> extends TestCase

{

	private LinkedQueue<K> linkedQueue;
	
	@Before 
	private void SetUp()
	{
		linkedQueue = new LinkedQueue<K>();
		
		linkedQueue.enqueue(new Nodo (3));
		linkedQueue.enqueue(new Nodo (4));
		linkedQueue.enqueue(new Nodo (92));
		linkedQueue.enqueue(new Nodo (8));
		linkedQueue.enqueue(new Nodo (45));
		linkedQueue.enqueue(new Nodo (32));
		linkedQueue.enqueue(new Nodo (0));
	}
	
	@Test
	public void testEnqueue()
	{
		SetUp();
	    linkedQueue.enqueue(new Nodo(1));
	    assertEquals(8, linkedQueue.size());
	}
	
	@Test
	public void testDequeue() throws noExisteObjetoException
	{
		SetUp();
		Nodo <K> nodo = linkedQueue.dequeue();
		assertEquals (3, nodo.darGenerico());
	}
	
	@Test
	public void TestIsEmpty ()
	{
		SetUp();
		boolean si = linkedQueue.isEmpty();
		assertEquals(false, si);
	}
	
	@Test
	public void testSize ()
	{
		SetUp();
		int tamaño = linkedQueue.size();
		assertEquals(7, tamaño);
	}
	
	@Test
	public void testDarPrimero() throws noExisteObjetoException
	{
		SetUp();
		Nodo <K> nodo = linkedQueue.darPrimero();
		assertEquals (3, nodo.darGenerico());
		
		
	}
	
}
