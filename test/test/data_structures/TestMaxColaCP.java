package test.data_structures;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.MaxColaCP;
import model.data_structures.noExisteObjetoException;

public class TestMaxColaCP extends TestCase
{
	private MaxColaCP<Integer> maxCola;



	@Before
	private void setUp1()
	{
		maxCola = new MaxColaCP<Integer>();

		for(int i = 1; i <= 5; i++)
		{
			maxCola.insert(i);
		}
	}
	@Test
	public void testSize()
	{
		setUp1();
		assertEquals(5, maxCola.size());

	}
	@Test
	public void testInsert()
	{
		setUp1();
		maxCola.insert(6);
		assertEquals(maxCola.size(), 6);
		assertTrue(maxCola.size() == 6);
		assertTrue(!maxCola.isEmpty());
		assertFalse(maxCola.isEmpty());
		try
		{
			assertTrue(maxCola.max() == 6);
		} catch (noExisteObjetoException e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testMax()
	{
		setUp1();
		try {
			assertTrue(maxCola.max() == 5);
			assertTrue(maxCola.max() != 101);
			assertFalse(maxCola.max() == 101);
			assertFalse(maxCola.max() != 5);
		} catch (noExisteObjetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDelMax() 
	{
		setUp1();
		try {
			assertTrue(maxCola.deleteMax() == 5);
			assertTrue(maxCola.deleteMax() == 4);
	
		} catch (noExisteObjetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	@Test
	public void testIsEmpty()
	{
		setUp1();
		assertFalse(maxCola.isEmpty());
	}

}
