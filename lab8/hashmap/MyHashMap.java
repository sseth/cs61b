package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author Shubhankar Seth
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private Set<K> keySet;
    private final double MAX_LOAD;

    /** Constructors */
    public MyHashMap() {
        this(16, 0.75);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, 0.75);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= maxLoad
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        buckets = createTable(initialSize);
        this.MAX_LOAD = maxLoad;
        keySet = new HashSet<>();
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key, value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    /**
     * Returns a table to back our hash table.
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        Collection<Node>[] table = new Collection[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = createBucket();
        }
        return table;
    }

    /** Removes all of the mappings from this map. */
    public void clear() {
        buckets = createTable(10);
        keySet = new HashSet<>();
    }

    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        return false;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
        return null;
    }

    /** Returns the number of key-value mappings in this map. */
    public int size() {
        return keySet.size();
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    public void put(K key, V value) {
        if ((double) keySet.size() / buckets.length >= MAX_LOAD) {
            resize(keySet.size() * 2);
        }
    }

    private void resize(int size) {

    }

    /** Returns a Set view of the keys contained in this map. */
    public Set<K> keySet() {
        return keySet;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     */
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value.
     */
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public Iterator<K> iterator() {
        return keySet.iterator();
    }
}
