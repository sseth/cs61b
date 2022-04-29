package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    // Change `add` and `resize` so that nextFirst = first - 1, nextLast = last + 1,
    // i.e. the list grows outwards from first and last
    // and on resize, first is at items[0] and last is at items[size - 1]?
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

    public void printDeque() {
        int n = getIndex(nextLast - 1);
        for (int i = getIndex(nextFirst + 1); i != n; i = getIndex(i + 1)) {
            if (items[i] == null) {
                break;
            }
            System.out.print(items[i] + " ");
        }
        System.out.println(items[getIndex(nextLast - 1)]);
    }

    // TODO: resize on remove
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

    // TODO:
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {

        public DequeIterator() {

        }

        public boolean hasNext() {
            return false;
        }

        public T next() {
            return null;
        }
    }

    // TODO:
    public boolean equals(Object o) {
        return false;
    }
}
