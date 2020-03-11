package test.data_structures;

import javax.sql.rowset.serial.SerialException;

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

		for(int i = 1; i <= 100; i++)
		{
			maxCola.insert(i);
		}
	}
	@Test
	public void testSize()
	{
		setUp1();
		assertEquals(100, maxCola.size());

	}
	@Test
	public void testInsert()
	{
		setUp1();
		maxCola.insert(101);
		assertEquals(maxCola.size(), 101);
		assertTrue(maxCola.size() == 101);
		assertTrue(!maxCola.isEmpty());
		assertFalse(maxCola.isEmpty());
		try
		{
			assertTrue(maxCola.max() == 101);
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
			assertTrue(maxCola.max() == 100);
			assertTrue(maxCola.max() != 101);
			assertFalse(maxCola.max() == 101);
			assertFalse(maxCola.max() != 100);
		} catch (noExisteObjetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDelMax() throws noExisteObjetoException
	{
		setUp1();
		assertTrue(maxCola.deleteMax() == 100);
//		try
//		{
//			System.out.println("Esta eliminando : "+maxCola.deleteMax());
//			assertTrue(maxCola.deleteMax() == 100);
//		}
//		catch(noExisteObjetoException e)
//		{
//			e.printStackTrace();
//		}
	}
	@Test
	public void testIsEmpty()
	{
		setUp1();
		assertFalse(maxCola.isEmpty());
	}

}
