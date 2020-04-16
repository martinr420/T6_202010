package test.data_structures;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.RedBlackBST;

public class TestRedBlackBST extends TestCase

{
      private RedBlackBST<Character, Integer > arbol;
      
      @Before 
      
      public void setUp()
      {
    	  arbol = new RedBlackBST<Character, Integer >();
    	  
    	  arbol.put('a', 1);
    	  arbol.put('b', 2);
    	  arbol.put('c', 3);
    	  arbol.put('d', 4);
    	  arbol.put('e', 5);
    	  
      }

      @Test
      
      public void testPut()
      {
    	  setUp();
    	  arbol.put('f', 6);
    	  assertTrue(arbol.get('f') == 6);
      }
      
      @Test
      
      public void testSize()
      {
    	  setUp();
    	  assertTrue(arbol.size() == 5);
      }
      
      public void testGet()
      {
    	  setUp();
    	  assertTrue(arbol.get('c') == 3);
      }
      
      public void testHeight()
      {
    	  setUp();
    	  assertTrue(arbol.height() == 2);
      }

      public void testMin()
      {
    	  setUp();
    	  assertTrue(arbol.min() == 'a');
      }
      
      public void testMax()
      {
    	  setUp();
    	  assertTrue (arbol.max() == 'e');
    	  
      }
      
      public void testCheck()
      {
    	  setUp();
    	  assertTrue (arbol.check());
      }
      
      



}
