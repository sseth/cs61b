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
            ad.addLast(i);
        }

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
    }

    // TODO: test resize
}
