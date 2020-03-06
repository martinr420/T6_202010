package test.data_structures;

import javax.sql.rowset.serial.SerialException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.MaxColaCP;

public class TestMaxColaCP extends TestCase
{
	private MaxColaCP<Integer> maxCola;

	@Before
	private void setUp1()
	{
		for(int i = 0; i < 1000; i++)
		{
			int num = (int) (Math.random()*i);
			maxCola.insert(num);
		}


	}
	@Test
	private void TestSize()
	{
		setUp1();
		assertEquals(1000, maxCola.size());
	}
}
