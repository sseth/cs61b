package bstmap;

import static org.junit.Assert.*;
import org.junit.Test;

/** Tests by Brendan Hu, Spring 2015, revised for 2016 by Josh Hug */
public class TestBSTMap {

    @Test
    public void removeTest() {
        BSTMap<Character, Integer> b = new BSTMap<>();

        b.put('d', (int) 'd');
        b.put('f', (int) 'f');
        b.put('b', (int) 'b');
        b.put('a', (int) 'a');
        b.put('e', (int) 'e');
        b.put('g', (int) 'g');
        b.put('c', (int) 'c');
        b.put('f', (int) 'f');
        b.printInOrder();

        assertEquals((int) 'd', (int) b.remove('d'));
        b.printInOrder();
        assertEquals(6, b.size());
        assertEquals((int) 'c', (int) b.remove('c'));
        b.printInOrder();
        assertEquals(5, b.size());
        assertNull(b.remove('d'));
        assertNull(b.remove('a', 69));
    }

    @Test
    public void removeTest2() {
        BSTMap<Character, Integer> b = new BSTMap<>();

        b.put('h', (int) 'h');
        b.put('d', (int) 'd');
        b.put('f', (int) 'f');
        b.put('b', (int) 'b');
        b.put('a', (int) 'a');
        b.put('e', (int) 'e');
        b.put('g', (int) 'g');
        b.put('c', (int) 'c');
        b.put('f', (int) 'f');
        b.put('l', (int) 'l');
        b.put('j', (int) 'j');
        b.put('n', (int) 'n');
        b.put('i', (int) 'i');
        b.put('k', (int) 'k');
        b.put('m', (int) 'm');
        b.put('o', (int) 'o');
        b.printInOrder();

        assertEquals((int) 'h', (int) b.remove('h'));
        b.printInOrder();
        assertEquals((int) 'i', (int) b.remove('i'));
        b.printInOrder();
        assertEquals((int) 'j', (int) b.remove('j'));
        b.printInOrder();
        assertEquals((int) 'k', (int) b.remove('k'));
        b.printInOrder();
        assertEquals((int) 'l', (int) b.remove('l'));
        b.printInOrder();
        assertEquals((int) 'm', (int) b.remove('m'));
        b.printInOrder();
        assertEquals((int) 'n', (int) b.remove('n'));
        b.printInOrder();
        assertEquals((int) 'o', (int) b.remove('o'));
        b.printInOrder();
    }

    @Test
    public void printTest() {
        BSTMap<Character, Integer> b = new BSTMap<>();

        b.put('d', (int) 'd');
        b.put('f', (int) 'f');
        b.put('b', (int) 'b');
        b.put('a', (int) 'a');
        b.put('e', (int) 'e');
        b.put('g', (int) 'g');
        b.put('c', (int) 'c');
        b.put('f', (int) 'f');

        b.printInOrder();
        System.out.println(b.keySet());;

        assertTrue(b.containsKey('f'));
        assertEquals((int) 'f', (int) b.get('f'));
    }

  	@Test
    public void sanityGenericsTest() {
    	try {
    		BSTMap<String, String> a = new BSTMap<String, String>();
	    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
	    	BSTMap<Integer, String> c = new BSTMap<Integer, String>();
	    	BSTMap<Boolean, Integer> e = new BSTMap<Boolean, Integer>();
	    } catch (Exception e) {
	    	fail();
	    }
    }

    //assumes put/size/containsKey/get work
    @Test
    public void sanityClearTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1+i);
            //make sure put is working via containsKey and get
            assertTrue( null != b.get("hi" + i) && (b.get("hi"+i).equals(1+i))
                        && b.containsKey("hi" + i));
        }
        assertEquals(455, b.size());
        b.clear();
        assertEquals(0, b.size());
        for (int i = 0; i < 455; i++) {
            assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    // assumes put works
    @Test
    public void sanityContainsKeyTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // assumes put works
    @Test
    public void sanityGetTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertNull(b.get("starChild"));
        assertEquals(0, b.size());
        b.put("starChild", 5);
        assertEquals(5, (int) b.get("starChild"));
        b.put("KISS", 5);
        b.printInOrder();
        assertEquals(5, (int) b.get("KISS"));
        assertNotNull(b.get("starChild"));
        assertEquals(2, b.size());
    }

    // assumes put works
    @Test
    public void sanitySizeTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(0, b.size());
        b.put("hi", 1);
        assertEquals(1, b.size());
        for (int i = 0; i < 455; i++)
            b.put("hi" + i, 1);
        assertEquals(456, b.size());
    }

    //assumes get/containskey work
    @Test
    public void sanityPutTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("hi", 1);
        assertTrue(b.containsKey("hi") && b.get("hi") != null);
    }

    //assumes put works
    @Test
    public void containsKeyNullTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("hi", null);
        assertTrue(b.containsKey("hi"));
    }

}
