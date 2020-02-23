package test.data_structures;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.LinkedStack;
import model.data_structures.Nodo;
import model.data_structures.noExisteObjetoException;

import static org.junit.Assert.assertEquals;

public class TestLinkedStack<K> extends TestCase

{

	
	private LinkedStack<K> linkedStack;
	
	
	@Before 
	private void SetUp()
	{
		linkedStack = new LinkedStack<K>();
		
		linkedStack.push(new Nodo (5));
		linkedStack.push(new Nodo (30));
		linkedStack.push(new Nodo (0));
		linkedStack.push(new Nodo (1));
		linkedStack.push(new Nodo (3));
		linkedStack.push(new Nodo (12));
		
	}
	
	@Test
	private void testPush()
	{
		SetUp();
		linkedStack.push(new Nodo (4));
		assertEquals(7, linkedStack.size());
	}
	
	@Test 
	private void testPop() throws noExisteObjetoException
	{
		SetUp();
		Nodo<K> nodo = linkedStack.pop();
		assertEquals(12, nodo.darGenerico());
		
	}
	
	@Test
	private void testIsEmpty()
	{
		SetUp();
		boolean si = linkedStack.isEmpty();
		assertEquals(false , si);
	}
	
	@Test
	private void testSize()
	{
		SetUp();
		int tama√ = linkedStack.size();
		assertEquals(6, tama√);
	}
	
	@Test 
	private void testDarUltimo() throws noExisteObjetoException
	{
		SetUp();
		Nodo <K> ultimo = linkedStack.darUltimo();
		assertEquals(12, ultimo.darGenerico());
	}
	
	
}
