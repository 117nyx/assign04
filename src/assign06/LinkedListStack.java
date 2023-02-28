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
        list.clear();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T peek() throws NoSuchElementException {
        return list.get(size());
    }

    @Override
    public T pop() throws NoSuchElementException {
        T rtn = peek();
        list.delete(size());
        return rtn;
    }

    @Override
    public void push(T element) {
        list.insert(size(),element);
    }

    @Override
    public int size() {
        return list.size();
    }
}
