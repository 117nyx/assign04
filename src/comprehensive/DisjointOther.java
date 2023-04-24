package comprehensive;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a disjoint set implementation using a hash map
 * @param <E>
 */
public class DisjointOther<E> implements DisjointSet<E>{
    private Map<E, E> parent; // parent[i] stores the parent of element i
    private Map<E, Integer> rank; // rank[i] stores the height of the subtree rooted at i
    public DisjointOther() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    @Override
    public void makeSet(E element) {
        parent.put(element,element);
        rank.put(element, 0);
    }

    @Override
    public E getRepresentative(E element) {
        if (parent.get( element) !=  element) {
            parent.put( element, getRepresentative(parent.get((E)element))); // path compression
        }
        return parent.get(element);
    }

    @Override
    public void union(E e1, E e2) {
        E rootX = getRepresentative(e1);
        E rootY = getRepresentative(e2);
        // if they are  not in the same set,
        if (rootX != rootY) {
            // union by rank
            if (rank.get(rootX) < rank.get(rootY)) {
                parent.put(rootX, rootY);
            } else if (rank.get(rootX) > rank.get(rootY)) {
                parent.put(rootY, rootX);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rank.get(rootX) + 1);
            }
        }
    }
}
