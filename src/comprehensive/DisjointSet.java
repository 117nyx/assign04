package comprehensive;

/**
 * Interface for the disjoint set adt containing its three methods
 * @param <E>
 */
public interface  DisjointSet<E> {
    /**
     * make a set containing a single element
     * @param element
     */
    void makeSet(E element);

    /**
     * Finds representative element of the set containing the element
     * @param element
     */
    E getRepresentative(E element);

    /**
     * Merge sets containing e1 and e2 into one set, if they are in the same set, do nothing
     * @param e1
     * @param e2
     */
    void union(E e1, E e2);
}
