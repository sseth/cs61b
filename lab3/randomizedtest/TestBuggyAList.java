package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> bal = new BuggyAList<>();
        AListNoResizing<Integer> anr = new AListNoResizing<>();

        bal.addLast(1);
        anr.addLast(1);
        bal.addLast(2);
        anr.addLast(2);
        bal.addLast(3);
        anr.addLast(3);

        assertEquals((int) bal.removeLast(), (int) anr.removeLast());
        assertEquals((int) bal.removeLast(), (int) anr.removeLast());
        assertEquals((int) bal.removeLast(), (int) anr.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            switch (operationNumber) {
                case 0: // addLast
                    int randVal = StdRandom.uniform(0, 100);
                    L.addLast(randVal);
                    B.addLast(randVal);
                    break;
                case 1: // size
                    int size = L.size();
                    int size1 = B.size();
                    assertEquals(size, size1);
                    break;
                case 2: // getLast
                    if (L.size() == 0 || B.size() == 0) {
                        i--;
                        break;
                    }
                    int l1 = L.getLast();
                    int l2 = B.getLast();
                    assertEquals(l1, l2);
                    break;
                case 3: // removeLast
                    if (L.size() == 0 || B.size() == 0) {
                        i--;
                        break;
                    }
                    int last = L.removeLast();
                    int last1 = B.removeLast();
                    assertEquals(last, last1);
            }
        }
    }
}
