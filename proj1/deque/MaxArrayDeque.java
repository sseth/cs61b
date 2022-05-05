package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c;
    public MaxArrayDeque(Comparator<T> c) {
        this.c = c;
    }

    public T max() {
        return max(this.c);
    }

    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        }

        T max = get(0);
        for (T item : this) {
            if (c.compare(item, max) > 0) {
                max = item;
            }
        }

        return max;
    }

    // TODO: equals
}
