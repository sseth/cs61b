package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(2);
        }

        items[nextFirst] = item;
        nextFirst = getIndex(nextFirst - 1);
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(2);
        }

        items[nextLast] = item;
        nextLast = getIndex(nextLast + 1);
        size++;
    }

    // TODO: refactor using get()?
    private void resize(double factor) {
        T[] temp = (T[]) new Object[(int) (items.length * factor)];

        int index = getIndex(nextFirst + 1);
        for (int i = 0; i < size; i++) {
            temp[i] = items[index];
            index = getIndex(index + 1);
        }

        items = temp;
        nextLast = getIndex(size);
        nextFirst = getIndex(items.length - 1);
    }

    public int size() {
        return size;
    }

    /*public void printDeque() {
        int index = getIndex(nextFirst + 1);
        for (int i = 0; i < size - 1; i++) {
            System.out.print(items[index] + " ");
            index = getIndex(index + 1);
        }
        System.out.println(items[index]);
    }*/

    public void printDeque() {
        int i;
        for (i = 0; i < size - 1; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println(get(i));
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        int index = getIndex(nextFirst + 1);
        T removed = items[index];
        nextFirst = index;
        items[nextFirst] = null;
        size--;

        if (items.length > 16 && size < 0.25 * items.length) {
            resize(0.5);
        }

        return removed;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        int index = getIndex(nextLast - 1);
        T removed = items[index];
        nextLast = index;
        items[nextLast] = null;
        size--;

        if (items.length > 16 && size < 0.25 * items.length) {
            resize(0.5);
        }

        return removed;
    }

    private int getIndex(int index) {
        if (index < 0) {
            index += items.length;
        } else if (index > items.length - 1) {
            index -= items.length;
        }
        return index;
    }

    public T get(int index) {
        if (size == 0 || index > size - 1) {
            return null;
        }
        return items[getIndex(nextFirst + 1 + index)];
    }

    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        private int next;
        public DequeIterator() {
            next = 0;
        }

        public boolean hasNext() {
            return next < size;
        }

        public T next() {
            T nextItem = get(next);
            next++;
            return nextItem;
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> other = (Deque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        // TODO:
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }

        return true;
    }
}
