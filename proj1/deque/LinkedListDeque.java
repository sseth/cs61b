package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class DeqNode {
        T item;
        DeqNode prev;
        DeqNode next;

        DeqNode() {
            this.item = null;
            this.prev = this;
            this.next = this;
        }

        DeqNode(T item, DeqNode prev, DeqNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private final DeqNode sentinel;

    public LinkedListDeque() {
        sentinel = new DeqNode();
        size = 0;
    }

    public void addFirst(T item) {
        DeqNode temp = new DeqNode(item, sentinel, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size++;
    }

    public void addLast(T item) {
        DeqNode temp = new DeqNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DeqNode p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }

    public T removeFirst() {
        DeqNode removed = sentinel.next;
        if (removed == sentinel) {
            return null;
        }

        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return removed.item;
    }

    public T removeLast() {
        DeqNode removed = sentinel.prev;
        if (removed == sentinel) {
            return null;
        }

        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return removed.item;
    }

    public T get(int index) {
        DeqNode p = sentinel.next;
        if (index > size - 1) {
            return null;
        }
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, DeqNode p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursive(--index, p.next);
    }

    // TODO:
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        private DeqNode next;
        public DequeIterator() {
            next = sentinel.next;
        }

        public boolean hasNext() {
            return next != sentinel;
        }

        public T next() {
            T nextItem = next.item;
            next = next.next;
            return nextItem;
        }
    }

    // TODO:
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deque)) {
            // use getClass instead?
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
