public class UnionFind {
    int[] parent;
    int[] size;

    /**
     * Creates a UnionFind data structure holding n vertices.
     */
    public UnionFind(int n) {
        // TODO: Initially, all vertices are in disjoint sets.
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            size[i] = 1;
        }
    }

    /**
     * Throws an exception if v1 is not a valid index.
     */
    private void validate(int vertex) {
        // TODO
    }

    /**
     * Returns the size of the set v1 belongs to.
     */
    public int sizeOf(int v1) {
        // TODO
        return -1;
    }

    /**
     * Returns the parent of v1.
     * If v1 is the root of a tree,
     * returns the negative size of the tree for which v1 is the root.
     */
    public int parent(int v1) {
        // TODO
        return -1;
    }

    /**
     * Returns true if nodes v1 and v2 are connected.
     */
    public boolean connected(int v1, int v2) {
        // TODO
        return false;
    }

    /**
     * Connects two elements.
     */
    public void union(int v1, int v2) {
        /* TODO:
          v1 and v2 can be any valid elements, and a union-by-size heuristic is used.
          If the sizes of the sets are equal, tie break by connecting v1's root to v2's root.
          Unioning a vertex with itself or vertices that are already connected should not
          change the sets but may alter the internal structure of the data.
         */
    }

    /**
     * Returns the root of the set V belongs to.
     */
    public int find(int vertex) {
        // TODO: use path compression for a fast search time
        return -1;
    }

}