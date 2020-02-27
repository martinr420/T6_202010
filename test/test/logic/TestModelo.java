package test.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import model.data_structures.ListaDoblementeEncadenada;
import model.data_structures.Nodo;
import model.logic.Modelo;
import model.logic.Multa;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestModelo <K> extends TestCase
{
	
	private Modelo modelo;
	
	@Before
	public void setUp1() {
		
		modelo= new Modelo();
	}


	@Test
	public void testShellSort()
	{ 
		setUp1();
		
		Integer datosAleatorios[] =  {4,5,0,1,2,3,43,5,4,1};
		Integer datosAscendentes[] = {43,5,5,4,3,3,2,1,1,0};
	    Integer datosDescendentes[] = {0,1,1,2,3,4,4,5,5,43};
		
	modelo.shellSort(datosAleatorios);
	modelo.shellSort(datosAscendentes);
	modelo.shellSort(datosDescendentes);
 
		
		Integer listaFinal[] = {0,1,1,2,3,4,4,5,5,43};
		
		assertTrue(Arrays.equals(datosAleatorios, listaFinal));
		assertTrue(Arrays.equals(datosAscendentes,listaFinal));
		assertTrue(Arrays.equals(datosDescendentes, listaFinal));
		
	}
	
	@Test
	public void testMergeSort()
	{ 
		setUp1();
		
		Integer datosAleatorios[] =  {4,5,0,1,2,3,43,5,4,1};
		Integer datosAscendentes[] = {43,5,5,4,3,3,2,1,1,0};
	    Integer datosDescendentes[] = {0,1,1,2,3,4,4,5,5,43};
		
	modelo.mergeSort(datosAleatorios, 0, 9 );
	modelo.mergeSort(datosAscendentes, 0, 9) ;
	modelo.mergeSort(datosDescendentes, 0, 9);
 
		
		Integer listaFinal[] = {0,1,1,2,3,4,4,5,5,43};
		
		assertTrue(Arrays.equals(datosAleatorios, listaFinal));
		assertTrue(Arrays.equals(datosAscendentes,listaFinal));
		assertTrue(Arrays.equals(datosDescendentes, listaFinal));
		
	}
	
	@Test
	public void testQuickSort()
	{ 
		setUp1();
		
		Integer datosAleatorios[] =  {4,5,0,1,2,3,43,5,4,1};
		Integer datosAscendentes[] = {43,5,5,4,3,3,2,1,1,0};
	    Integer datosDescendentes[] = {0,1,1,2,3,4,4,5,5,43};
		
	modelo.quickSort(datosAleatorios, 1, 10);
	modelo.quickSort(datosAscendentes, 1, 10);
	modelo.quickSort(datosDescendentes, 1, 10);
 
		
		Integer listaFinal[] = {0,1,1,2,3,4,4,5,5,43};
		
		assertTrue(Arrays.equals(datosAleatorios, listaFinal));
		assertTrue(Arrays.equals(datosAscendentes,listaFinal));
		assertTrue(Arrays.equals(datosDescendentes, listaFinal));
		
	}
	
	
	
}


