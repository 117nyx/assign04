package comprehensive;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a disjoint set implementation using a hash map
 * @param <E>
 */
public class DisjointOther<E> implements DisjointSet<E>{
    //backing map for elements and representatives
    private Map<E, E> parent;
    // map for storing height of set
    private Map<E, Integer> height;
    public DisjointOther() {
        parent = new HashMap<>();
        height = new HashMap<>();
    }

    /**
     * Creates a set containing one element, assumes element is not a duplicate of another
     * @param element
     */
    @Override
    public void makeSet(E element) {
        parent.put(element,element);
        height.put(element, 0);
    }

    /**
     * Returns representative element of set containing param element
     * @param element
     * @return
     */
    @Override
    public E getRepresentative(E element) {
        if (parent.get(element) !=  element){
            return getRepresentative(parent.get(element));
        }
        return parent.get(element);
    }

    /**
     * Combines the sets containing the 2 elements if they are not already in the same set
     * assumes elements exist already
     * @param e1
     * @param e2
     */
    @Override
    public void union(E e1, E e2) {
        E rootX = getRepresentative(e1);
        E rootY = getRepresentative(e2);
        // if they are  not in the same set,
        if (rootX != rootY) {
            // union by height
            if (height.get(rootX) < height.get(rootY))
                parent.put(rootX, rootY);
            else if (height.get(rootX) > height.get(rootY))
                parent.put(rootY, rootX);
            else {
                parent.put(rootY, rootX);
                height.put(rootX, height.get(rootX) + 1);
            }
        }
    }
}
