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



    public SinglyLinkedList(){
        size = 0;
        head = null;

    }



    @Override
    public void insertFirst(T element) {
        Node<T> newNode = new Node<T>(element);
        if(head == null) {
            head = newNode;



        }
        else{
            head.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void insert(int index, T element) throws IndexOutOfBoundsException {
        if(index > size)
            throw new IndexOutOfBoundsException();
        if(isEmpty()) {
            head = new Node<>(element);
            head.next = null;
        }
        // use iterator to traverse through list until nextIndex == index, then adjust nodes to insert
        ListIterator<T> iter = new ListIterator<T>();
        // traverse list until nextIndex == index, return data of element at index
        while(iter.hasNext()){
            if(iter.nextIndex+1 == index)
            {
                Node<T> n = new Node<>(element);
                iter.current.next=n;
            }
            iter.next();

        }
        size++;

    }

    @Override
    public T getFirst() throws NoSuchElementException {
        if(head == null)
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index > size)
            throw new IndexOutOfBoundsException();
        ListIterator<T> iter = new ListIterator<T>();
        // traverse list until nextIndex == index, return data of element at index
        while(iter.hasNext()){
           if(iter.nextIndex == index)
               return iter.next();
            iter.next();

        }
        return null;
    }

    @Override
    public T deleteFirst() throws NoSuchElementException {
        if(head == null)
            throw new NoSuchElementException();
        T rtn = head.data;
        head = head.next;
        return rtn;
    }

    @Override
    public T delete(int index) throws IndexOutOfBoundsException {
        if(index>size)
            throw new IndexOutOfBoundsException();
        ListIterator<T> iter = new ListIterator<T>();
        // traverse list until nextIndex == index, return data of element at index,remove element
        while(iter.hasNext()){
            if(iter.nextIndex == index) {
                T rtn = iter.next();
                iter.remove();
                return rtn;
            }
            iter.next();

        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        //traverse list until element.equals list item at that index, return nextIndex
        ListIterator<T> iter = new ListIterator<T>();
        int val =0;
        while(iter.hasNext()) {
            if(iter.current.data.equals(element)){

                return val;
            }
            iter.next();
        val++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !iterator().hasNext();
    }

    @Override
    public void clear() {
        head=null;
        size = 0;
    }

    @Override
    public T[] toArray() {
        //traverse list, for each node, print out data and index
        ListIterator<T> iter = new ListIterator<>();
        Object[] arr = new Object[size + 1];
        for( int i = 0; i <= size; i++) {
            T element = iter.next();
            arr[i] = element;
        }

        return (T[])arr;
    }

    @Override
    public Iterator<T> iterator() {

        return new ListIterator();
    }

    private static class Node<T> {
        public T data;
        public Node<T>  next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

    }

    private class ListIterator<E> implements Iterator<T> {

        private boolean canRemove;
        private Node<T> current;
        private int nextIndex;

        public ListIterator(){
            canRemove = false;
            current=head;
            nextIndex = 1;

        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            T nextElement = current.data;
            canRemove = true;
            current=current.next;
            nextIndex++;
            return nextElement;
        }

        public void remove() {
            if(!canRemove)
                throw new IllegalStateException();
            canRemove = false;
            //adjust nodes
            // node before now points to node (@ nextIndex).next
            //again this might work?
            if(current==head)
            {
                head = head.next;
            } else {
                current.next = current.next.next;
                size--;
            }
        }
    }
}
