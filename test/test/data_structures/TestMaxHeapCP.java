package test.data_structures;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.MaxHeapCP;
import model.data_structures.noExisteObjetoException;

public class TestMaxHeapCP extends TestCase
{
	private MaxHeapCP<Integer> mh;
	
	@Before
	private void setUp1()
	{
		mh = new MaxHeapCP<Integer>(100);
		for(int i = 1; i <= 5; i++ )
		{
			mh.insert(i);
		}
		
		
	}
	public void testSize()
	{
		setUp1();
		assertEquals(5, mh.size());

	}
	@Test
	public void testInsert()
	{
		setUp1();
		mh.insert(6);
		assertTrue(mh.size() == 6);
		assertFalse(mh.isEmpty());
		try
		{
			assertTrue(mh.max() == 6);
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
			assertTrue(mh.max() == 5);
			assertTrue(mh.max() != 101);
			assertFalse(mh.max() == 101);
			assertFalse(mh.max() != 5);
		} catch (noExisteObjetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDelMax()
	{
		setUp1();
		try
		{
			assertTrue(mh.deleteMax() == 5);
		}
		catch(noExisteObjetoException e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void testIsEmpty()
	{
		setUp1();
		assertFalse(mh.isEmpty());
	}

}
