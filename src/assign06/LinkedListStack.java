package assign06;

import java.util.NoSuchElementException;

/**
 * This class represents a stack object backed by a linked List that can be iterated over
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class LinkedListStack <T> implements Stack<T>{
    private SinglyLinkedList<T> list;

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
    public T peek() throws NoSuchElementException {
        return null;
    }

    @Override
    public T pop() throws NoSuchElementException {
        return null;
    }

    @Override
    public void push(T element) {

    }

    @Override
    public int size() {
        return list.size();
    }
}
