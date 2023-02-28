package assign06;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This class represents a singly linked list object that can be iterated over
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class SinglyLinkedList <T>implements List<T>{

    private int size;
    private Node<T> head;
    private Node<T> tail;

    private SinglyLinkedList<T> list = new SinglyLinkedList<T>();
    public SinglyLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }



    @Override
    public void insertFirst(T element) {
        Node<T> newNode = new Node<T>(element,head);
        if(head == null) {
            head = newNode;
            tail = newNode;

        }
        else{
            //maybe works?
            head = newNode;

        }
        size++;
    }

    @Override
    public void insert(int index, T element) throws IndexOutOfBoundsException {

    }

    @Override
    public T getFirst() throws NoSuchElementException {
        return head.data;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        ListIterator<T> iter = new ListIterator<T>();
        while(iter.hasNext()){
           // if()


        }
        return null;
    }

    @Override
    public T deleteFirst() throws NoSuchElementException {
        T rtn = head.data;
        head = head.next;
        return rtn;
    }

    @Override
    public T delete(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(!iterator().hasNext())
            return true;
        return false;
    }

    @Override
    public void clear() {
        list = null;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private static class Node<T> {
        public T data;
        public Node<T>  next;

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }

    }

    private class ListIterator<E> implements Iterator<T> {

        private int nextIndex;
        private boolean canRemove;

        public ListIterator(){
            nextIndex = 0;
            canRemove = false;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            T nextElement = (T)list.get(nextIndex);
            nextIndex++;
            canRemove = true;
            return nextElement;
        }

        public void remove(Node<T> n) {
            if(!canRemove)
                throw new IllegalStateException();
            canRemove = false;
            //adjust nodes
            // node before now points to node (@ nextIndex).next
            //again this might work?
            n.next = n.next.next;
            size--;
        }
    }
}
