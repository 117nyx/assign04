package comprehensive;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a disjoint set forest implementation using trees
 */
public class DisjointSetForest<E> implements DisjointSet<E> {
    //backing map
    private Map<E, Node<E>> nodes;

    public DisjointSetForest() {
        nodes = new HashMap<>();
    }

    /**
     * Create a new set containing the given element
     * assumes it is not a duplicate
     */
    @Override
    public void makeSet(E element) {
        Node<E> node = new Node<>(element);
        nodes.put(element, node);
    }

    /**
     *Find the representative element of the set containing the element
     */
    @Override
    public E getRepresentative(E element) {
        Node<E> node = nodes.get(element);
        if (node.parent != node) {
            node.parent.data = getRepresentative(node.parent.data); // path compression
        }
        return node.parent.data;
    }

    /**
     *Merge the sets containing the two elements
     */
    @Override
    public void union(E e1, E e2) {
        Node<E> root1 = findNode(nodes.get(e1));
        Node<E> root2 = findNode(nodes.get(e2));
        // check for same set
        if (root1 == root2) {
            return;
        }
        // union by rank
        if (root1.rank > root2.rank) {
            root2.parent = root1;
        } else if (root1.rank < root2.rank) {
            root1.parent = root2;
        } else {
            root2.parent = root1;
            root1.rank++;
        }
    }

    /**
     *Node class for representing elements in the forest
     */
    private static class Node<E> {
        E data;
        Node<E> parent;
        int rank;

        Node(E data) {
            this.data = data;
            parent = this;
            rank = 0;
        }
    }
    /**
     *Find the root node of the given node and perform path compression
     */
    private Node<E> findNode(Node<E> node) {
        if (node.parent != node) {
            node.parent = findNode(node.parent); // path compression
        }
        return node.parent;
    }
}
