package model.data_structures;

import java.util.Iterator;

public interface IArbolRojoNegro <Key extends Comparable <Key>, Value>
{
	int size();
	boolean isEmpty();
	Value get(Key key);
	boolean contains(Key key);
	int height();
	Key min();
	Key max();
	Iterable<Key> keys();
	Iterable<Value> valuesInRange(Key lo, Key hi);
	Iterable<Key> keysInRange(Key lo, Key Hi);
	

}
