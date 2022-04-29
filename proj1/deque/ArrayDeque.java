package deque;

public class ArrayDeque<T> {
    T[] items;
    int size;

    public ArrayDeque() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(5);
        }

        System.arraycopy(items, 0, items, 1, size++);
        items[0] = item;
    }


    public void addLast(T item) {
        if (size == items.length) {
            resize(5);
        }

        items[size++] = item;
    }

    private void resize(int factor) {
        // TODO make factor a class constant?
        T[] temp = (T[]) new Object[size * factor];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(items[i] + " ");
        }
        if (size > 0) {
            System.out.println(items[size - 1]);
        }
    }

    // TODO resize on remove?
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T removed = items[0];
        System.arraycopy(items, 1, items, 0, size);
        items[--size] = null;
        // System.out.println(items[size] == null);
        return removed;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T removed = items[size - 1];
        items[size - 1] = null;
        size--;
        // System.out.println(items[size] == null);
        return removed;
    }

    public T get(int index) {
        return items[index];
    }

    /*public Iterator<T> iterator() {
        return null;
    }

    public boolean equals(Object o) {
        return false;
    }*/
}
