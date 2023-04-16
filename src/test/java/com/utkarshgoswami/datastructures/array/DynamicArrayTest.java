package com.utkarshgoswami.datastructures.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynamicArrayTest {
	
	@Test
	public void checkArrayIsEmpty() {
		DynamicArray<Integer> arr = new DynamicArray<>();
		if(arr.size()==0) {
			assertTrue(true);
		}
	}
	
	@Test
	public void addElements() {
		DynamicArray<Integer> arr = new DynamicArray<>();
		arr.add(45);
		arr.add(56);
		arr.add(65);
		arr.add(76);
		
		if(arr.size()>0) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
	
	@Test
	  public void testEmptyList() {
	    DynamicArray<Integer> list = new DynamicArray<>();
	    assertTrue(list.isEmpty());
	  }

	  public void testRemovingEmpty() {
	    DynamicArray<Integer> list = new DynamicArray<>();
	    list.removeAt(0);
	  }
	  
	  @Test
	  public void testRemovingEmptyException() {
		  Assertions.assertThrows(Exception.class, ()->testRemovingEmpty());
	  }

	  
	  public void testIndexOutOfBounds() {
	    DynamicArray<Integer> list = new DynamicArray<>();
	    list.add(-56);
	    list.add(-53);
	    list.add(-55);
	    list.removeAt(3);
	  }
	  
	  @Test
	  public void testIndexOutOfBoundsException() {
		  Assertions.assertThrows(Exception.class, ()->testIndexOutOfBounds());
	  }
	  
	  public void testIndexOutOfBounds2() {
	    DynamicArray<Integer> list = new DynamicArray<>();
	    for (int i = 0; i < 1000; i++) list.add(789);
	    list.removeAt(1000);
	  }
	  
	  @Test
	  public void testIndexOutofBoundsException2() {
		  Assertions.assertThrows(Exception.class, ()-> testIndexOutOfBounds2());
	  }

	  public void testIndexOutOfBounds3() {
	    DynamicArray<Integer> list = new DynamicArray<>();
	    for (int i = 0; i < 1000; i++) list.add(789);
	    list.removeAt(-1);
	  }
	  
	  @Test
	  public void testIndexOutOfBoundsException3() {
		  Assertions.assertThrows(Exception.class, ()-> testIndexOutOfBounds3());
	  }

	  public void testIndexOutOfBounds4() {
	    DynamicArray<Integer> list = new DynamicArray<>();
	    for (int i = 0; i < 15; i++) list.add(123);
	    list.removeAt(-66);
	  }
	  
	  @Test
	  public void testIndexOutOfBoundsException4() {
		  Assertions.assertThrows(Exception.class, ()-> testIndexOutOfBounds4());
	  }

	  @Test
	  public void testRemoving() {

	    DynamicArray<String> list = new DynamicArray<>();
	    
	    String[] str = {"a", "b", "c", "d", "e", null, "g", "h"};
	    for (String s : str) {
	    	list.add(s);
	    }
	    
	    boolean res = list.remove("c");
	    assertTrue(res);

	    res = list.remove("c");
	    assertFalse(res);

	    res = list.remove("h");
	    assertTrue(res);

	    res = list.remove(null);
	    assertTrue(res);

	    res = list.remove("a");
	    assertTrue(res);

	    res = list.remove("a");
	    assertFalse(res);

	    res = list.remove("h");
	    assertFalse(res);

	    res = list.remove(null);
	    assertFalse(res);
	  }

	  @Test
	  public void testRemoving2() {

	    DynamicArray<String> list = new DynamicArray<>();
	    String[] str = {"a", "b", "c", "d"};
	    for (String s : str) {
	    	list.add(s);
	    }

	    assertTrue(list.remove("a"));
	    assertTrue(list.remove("b"));
	    assertTrue(list.remove("c"));
	    assertTrue(list.remove("d"));

	    assertFalse(list.remove("a"));
	    assertFalse(list.remove("b"));
	    assertFalse(list.remove("c"));
	    assertFalse(list.remove("d"));
	  }

	  @Test
	  public void testIndexOfNullElement() {
	    DynamicArray<String> list = new DynamicArray<>();
	    String[] str = {"a", "b", null, "d"};
	    for (String s : str) {
	    	list.add(s);
	    }
	    assertTrue(list.indexOf(null) == 2);
	  }

	  @Test
	  public void testAddingElements() {

	    DynamicArray<Integer> list = new DynamicArray<>();

	    int[] elems = {1, 2, 3, 4, 5, 6, 7};

	    for (int i = 0; i < elems.length; i++) {
	    	list.add(elems[i]);
	    }

	    for (int i = 0; i < elems.length; i++) {
	    	assertEquals(list.get(i).intValue(), elems[i]);
	    }
	  }

	  @Test
	  public void testAddAndRemove() {

	    DynamicArray<Long> list = new DynamicArray<>(0);

	    for (int i = 0; i < 55; i++) {
	    	list.add(44L);
	    }
	    for (int i = 0; i < 55; i++) {
	    	list.remove(44L);
	    }
	    assertTrue(list.isEmpty());

	    for (int i = 0; i < 55; i++) {
	    	list.add(44L);
	    }
	    for (int i = 0; i < 55; i++) {
	    	list.removeAt(0);
	    }
	    assertTrue(list.isEmpty());

	    for (int i = 0; i < 155; i++) {
	    	list.add(44L);
	    }
	    for (int i = 0; i < 155; i++) {
	    	list.remove(44L);
	    }
	    assertTrue(list.isEmpty());

	    for (int i = 0; i < 155; i++) {
	    	list.add(44L);
	    }
	    for (int i = 0; i < 155; i++) {
	    	list.removeAt(0);
	    }
	    assertTrue(list.isEmpty());
	  }

	  @Test
	  public void testAddSetRemove() {

	    DynamicArray<Long> list = new DynamicArray<>(0);

	    for (int i = 0; i < 55; i++) {
	    	list.add(44L);
	    }
	    for (int i = 0; i < 55; i++) {
	    	list.set(i, 33L);
	    }
	    for (int i = 0; i < 55; i++) {
	    	list.remove(33L);
	    }
	    assertTrue(list.isEmpty());

	    for (int i = 0; i < 55; i++) {
	    	list.add(44L);
	    }
	    for (int i = 0; i < 55; i++) {
	    	list.set(i, 33L);
	    }
	    for (int i = 0; i < 55; i++) {
	    	list.removeAt(0);
	    }
	    assertTrue(list.isEmpty());

	    for (int i = 0; i < 155; i++) {
	    	list.add(44L);
	    }
	    for (int i = 0; i < 155; i++) {
	    	list.set(i, 33L);
	    }
	    for (int i = 0; i < 155; i++) {
	    	list.remove(33L);
	    }
	    assertTrue(list.isEmpty());

	    for (int i = 0; i < 155; i++) {
	    	list.add(44L);
	    }
	    for (int i = 0; i < 155; i++) {
	    	list.removeAt(0);
	    }
	    assertTrue(list.isEmpty());
	  }

	  @Test
	  public void testSize() {

	    DynamicArray<Integer> list = new DynamicArray<>();

	    Integer[] elems = {-76, 45, 66, 3, null, 54, 33};
	    for (int i = 0, sz = 1; i < elems.length; i++, sz++) {
	      list.add(elems[i]);
	      assertEquals(list.size(), sz);
	    }
	  }
	
}