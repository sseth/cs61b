package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
    }

    public BSTMap(K key, V value) {
        root = new Node(key, value);
    }

    /** Removes all of the mappings from this map. */
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        return containsKey(key, root);
    }

    private boolean containsKey(K key, Node n) {
        if (n == null) {
            return false;
        }
        if (key.compareTo(n.key) < 0) {
            return containsKey(key, n.left);
        }
        if (key.compareTo(n.key) > 0) {
            return containsKey(key, n.right);
        }
        return true;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
        return get(key, root);
    }

    private V get(K key, Node n) {
        if (n == null) {
            return null;
        }
        if (key.compareTo(n.key) < 0) {
            return get(key, n.left);
        }
        if (key.compareTo(n.key) > 0) {
            return get(key, n.right);
        }
        return n.value;
    }

    /** Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /** Associates the specified value with the specified key in this map. */
    public void put(K key, V value) {
        root = put(key, value, root);
        size++;
    }

    private Node put(K key, V value, Node n) {
        if (n == null) {
            return new Node(key, value);
        }

        if (key.compareTo(n.key) < 0) {
            n.left = put(key, value, n.left);
        } else if (key.compareTo(n.key) > 0) {
            n.right = put(key, value, n.right);
        }

        return n;
    }

    /** Prints this BSTMap in order of increasing Key */
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node n) {
        if (n == null) {
            return;
        }
        printInOrder(n.left);
        System.out.print(n.key + " ");
        printInOrder(n.right);
    }


    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /** Removes the mapping for the specified key from this map. */
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /** Removes the entry for the specified key only if it is currently mapped to
     * the specified value. */
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
