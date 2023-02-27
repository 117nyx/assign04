package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a singly linked list object that can be iterated over
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class SinglyLinkedList  implements List{

    public <T extends Comparable<? super T>>  SinglyLinkedList(){

    }



    @Override
    public void insertFirst(Object element) {

    }

    @Override
    public void insert(int index, Object element) throws IndexOutOfBoundsException {

    }

    @Override
    public Object getFirst() throws NoSuchElementException {
        return null;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object deleteFirst() throws NoSuchElementException {
        return null;
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private static class ListIterator implements java.util.Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {
            java.util.Iterator.super.remove();
        }
    }
}
