package test.data_structures;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.LinkedQueue;
import model.data_structures.Nodo;

public class TestLinkedQueue <K>

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
	    linkedQueue.enqueue(new Nodo(12));
	}
	
	
	
	
	
}
