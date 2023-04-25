package comprehensive;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a disjoint set implementation using a hash map
 * @param <E>
 */
public class DisjointOther<E> implements DisjointSet<E>{
    private Map<E, E> parent; // parent[i] stores the parent of element i

    public DisjointOther() {
        parent = new HashMap<>();
    }

    /**
     * Makes se containing one element
     * @param element
     */
    @Override
    public void makeSet(E element) {
        parent.put(element,element);
    }

    /**
     * Returns representative element of the set containing element
     * @param element
     * @return
     */
    @Override
    public E getRepresentative(E element) {
        //recurse if the element is not the representative
        if (parent.get( element) !=  element) {
            return getRepresentative(parent.get(element)); // path compression
        }
        return parent.get(element);
    }

    /**
     * Combines the sets containing e1 and e2, if they are in the same set, do nothing
     * @param e1
     * @param e2
     */
    @Override
    public void union(E e1, E e2) {
        E rootX = getRepresentative(e1);
        E rootY = getRepresentative(e2);
        // if they are  not in the same set,
        if (rootX != rootY) {
            parent.put(rootY, rootX);
        }
    }
}
