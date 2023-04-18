package comprehensive;

public interface  DisjointSet<E> {
    void makeSet(E element);
    void getRepresentative(E element);
    void union(E e1, E e2);
}
