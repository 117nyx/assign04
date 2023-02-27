package assign06;

import java.util.NoSuchElementException;

/**
 * This class represents a stack object backed by a linked List that can be iterated over
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class LinkedListStack <T> implements Stack{
    private SinglyLinkedList list;

    public LinkedListStack(){

    }
    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object peek() throws NoSuchElementException {
        return null;
    }

    @Override
    public Object pop() throws NoSuchElementException {
        return null;
    }

    @Override
    public void push(Object element) {

    }

    @Override
    public int size() {
        return 0;
    }
}
