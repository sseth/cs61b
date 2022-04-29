package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void testAdd() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        assertEquals(0, ad.size());
        ad.addFirst(2);
        assertEquals(1, ad.size());
        ad.addLast(3);
        assertEquals(2, ad.size());
        ad.addLast(4);
        assertEquals(3, ad.size());
        ad.addFirst(1);
        assertEquals(4, ad.size());
        ad.addFirst(0);
        assertEquals(5, ad.size());

        ad.printDeque();

        for (int i = 0; i < 5; i++) {
            assertEquals(i, (int) ad.get(i));
        }
    }

    @Test
    public void removeTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            ad.printDeque();
            ad.addLast(i);
        }

        ad.printDeque();
        assertEquals(5, ad.size());
        assertEquals(0, (int) ad.removeFirst());
        assertEquals(4, ad.size());
        ad.printDeque();
        assertEquals(4, (int) ad.removeLast());
        assertEquals(3, ad.size());
        ad.printDeque();
        assertEquals(3, (int) ad.removeLast());
        assertEquals(2, ad.size());
        ad.printDeque();
        assertEquals(1, (int) ad.removeFirst());
        assertEquals(1, ad.size());
        ad.printDeque();
        assertEquals(2, (int) ad.removeFirst());
        assertEquals(0, ad.size());
        ad.printDeque();

        assertNull(ad.removeFirst());
        assertNull(ad.removeLast());
        assertEquals(0, ad.size());
    }

    @Test
    public void resizeTest1() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            ad.addFirst(i);
            ad.addLast(i);
        }
        ad.printDeque();

        ad.addLast(4);
        ad.printDeque();

        ad.addLast(5);
        ad.addFirst(4);
        ad.addFirst(5);
        ad.printDeque();
        assertEquals(5, (int) ad.removeLast());
        assertEquals(5, (int) ad.removeFirst());
    }

    @Test
    public void resizeTest2() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(0);
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);

        assertEquals(0, (int) ad.removeLast());
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        ad.addLast(5);
        ad.addLast(6);

        ad.addLast(7);
        ad.addLast(8);
        ad.addLast(9);
        ad.addLast(10);
        ad.addLast(11);
        ad.addLast(12);
        ad.addLast(13);
        ad.addLast(14);

        assertEquals(14, (int) ad.removeLast());
        assertEquals(13, (int) ad.removeLast());
        assertEquals(12, (int) ad.removeLast());
        assertEquals(11, (int) ad.removeLast());

        ad.addLast(0);
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);

        assertEquals(4, (int) ad.removeFirst());
        assertEquals(3, (int) ad.removeFirst());
        assertEquals(2, (int) ad.removeFirst());
        assertEquals(1, (int) ad.removeFirst());
        assertEquals(2, (int) ad.removeFirst());
    }

    @Test
    public void removeTest2() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(0);
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        ad.addFirst(6);
        ad.addFirst(7);

        assertEquals(0, (int) ad.removeLast());
        assertEquals(1, (int) ad.removeLast());
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        ad.addLast(5);
        ad.addLast(6);

        int[] a = {7, 6, 5, 4, 3, 2, 2, 3, 4, 5, 6};
        for (int i = 0; i < ad.size(); i++) {
            assertEquals(a[i], (int) ad.get(i));
        }
    }

    // TODO: call removeLast after only inserting first and vice versa (all the way to the end and less than)
    // TODO: test addLast after removeLast where last = len - 1 and addFirst after removeLast where first = 0

    /** Tests downsizing */
    @Test
    public void resizeTest3() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for (int i = 0; i <= 16; i++) {
            ad.addFirst(i);
        }
        assertEquals(17, ad.size());
        for (int i = 16; i >= 8; i--) {
            assertEquals(i, (int) ad.removeFirst());
        }
        assertEquals(8, ad.size());

        assertEquals(0, (int) ad.removeLast());
        ad.printDeque();

    }

    @Test
    public void bigADequeTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            ad.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) ad.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) ad.removeLast(), 0.0);
        }
    }
}
