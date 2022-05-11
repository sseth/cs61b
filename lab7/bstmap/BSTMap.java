package bstmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
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
    }

    private Node put(K key, V value, Node n) {
        if (n == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(n.key) < 0) {
            n.left = put(key, value, n.left);
        } else if (key.compareTo(n.key) > 0) {
            n.right = put(key, value, n.right);
        } else {
            n.value = value;
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
        Set<K> keys = new HashSet<K>();
        keySet(root, keys);
        return keys;
    }

    private void keySet(Node n, Set<K> keys) {
        if (n == null) {
            return;
        }
        keys.add(n.key);
        keySet(n.left, keys);
        keySet(n.right, keys);
    }

    /** Removes the mapping for the specified key from this map. */
    public V remove(K key) {
        V returnVal = get(key);
        if (returnVal == null) {
            return null;
        } else {
            remove(key, root);
            return returnVal;
        }
    }

    /** Removes the entry for the specified key only if it is currently mapped to
     * the specified value. */
    public V remove(K key, V value) {
        if (get(key).equals(value)) {
            remove(key, root);
            return value;
        } else {
            return null;
        }
    }

    /** @source https://algs4.cs.princeton.edu/32bst/BST.java.html */
    private Node remove(K key, Node n) {
        if (n == null) {
            return null;
        }
        if (key.compareTo(n.key) < 0) {
            n.left = remove(key, n.left);
        } else if (key.compareTo(n.key) > 0) {
            n.right = remove(key, n.right);
        } else if (n.left == null) {
            size--;
            return n.right;
        } else if (n.right == null) {
            size--;
            return n.left;
        } else {
            Node p = min(n.right);
            n.key = p.key;
            n.value = p.value;
            n.right = remove(p.key, n.right);
        }
        return n;
    }

    private Node min(Node n) {
        if (n.left == null) {
            return n;
        }
        return min(n.left);
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
        // return new BSTMapIterator();
    }

    // TODO?
    private class BSTMapIterator implements Iterator<K> {
        private Node next;
        private int rem;
        public BSTMapIterator() {
            next = root;
            rem = root == null ? 0 : size;
        }

        public boolean hasNext() {
            return rem > 0;
        }

        public K next() {
            rem--;
            // ??
            return null;
        }
    }
}
