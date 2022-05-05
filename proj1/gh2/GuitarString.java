package gh2;

import deque.Deque;
import deque.LinkedListDeque;

public class GuitarString {
    // Sampling Rate
    private static final int SR = 44100;
    // Energy decay factor
    private static final double DECAY = .996;
    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency. */
    public GuitarString(double frequency) {
        int capacity = (int) Math.round(SR / frequency);
        buffer = new LinkedListDeque<>();
        while (capacity > 0) {
            buffer.addFirst(0.0);
            capacity--;
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int n = buffer.size(); n > 0; n--) {
            buffer.removeFirst();
            buffer.addLast(Math.random() - 0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double a = buffer.removeFirst();
        double b = buffer.get(0);
        buffer.addLast(DECAY * (a + b) / 2);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
