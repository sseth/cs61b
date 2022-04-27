package IntList;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void test0() {
        IntList lst = IntList.of(1, 4, 6, 8, 10);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 4 -> 6 -> 8 -> 10", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void test1() {
        IntList lst = IntList.of(2, 3, 5, 7);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 9 -> 25 -> 49", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void test2() {
        IntList lst = IntList.of(3, 5, 7, 11);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("9 -> 25 -> 49 -> 121", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void test3() {
        IntList lst = IntList.of(0, 1, 22, 34, 51, 11, 17, 2, 5);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("0 -> 1 -> 22 -> 34 -> 51 -> 121 -> 289 -> 4 -> 25", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void test4() {
        IntList lst = IntList.of(1, 11, 22, 3, 51, 2, 17, 16, 5);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 121 -> 22 -> 9 -> 51 -> 4 -> 289 -> 16 -> 25", lst.toString());
        assertTrue(changed);
    }
}
