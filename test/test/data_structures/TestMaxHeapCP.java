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
		for(int i = 1; i <= 100; i++ )
		{
			mh.insert(i);
		}
		
		
	}
	public void testSize()
	{
		setUp1();
		assertEquals(100, mh.size());

	}
	@Test
	public void testInsert()
	{
		setUp1();
		mh.insert(101);
		assertEquals(mh.size(), 101);
		assertTrue(mh.size() == 101);
		assertTrue(!mh.isEmpty());
		assertFalse(mh.isEmpty());
		try
		{
			assertTrue(mh.max() == 101);
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
			assertTrue(mh.max() == 100);
			assertTrue(mh.max() != 101);
			assertFalse(mh.max() == 101);
			assertFalse(mh.max() != 100);
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
			assertTrue(mh.deleteMax() == 100);
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
