package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents a binary max heap data structure using array backed implementation
 * Authors: Jonathan Kerr and Eden Harvey
 * @param <E>
 */
public class BinaryMaxHeap<E> implements PriorityQueue {

    private Comparator<? super E> compare;
    private E[] arr = (E[]) new Object[8];
    private int addIndex=1;

    /**
     * Base constructor, sets the comparator field to null - uses natural ordering.
     */
    public BinaryMaxHeap(){
        compare=null;
    }

    /**
     * Creates an empty BinaryMaxHeap that uses the given comparator for its comparisons.
     * @param c - Comparator to be used.
     */
    public BinaryMaxHeap(Comparator<? super E> c){
        compare=c;


    }

    /**
     * Constructs a heap using the natural ordering of the objects that are passed in as a list.
     * @param l - List of objects to build the heap from.
     */
    public BinaryMaxHeap(List<E> l){
        compare=null;
        buildHeap(l);
    }

    /**
     * Constructs a new heap using the given list of objects, and using the given comparator to make
     * comparisons.
     * @param l - List of objects to build the heap from.
     * @param c - Comparator to be used to make comparisons.
     */
    public BinaryMaxHeap(List<? extends E> l, Comparator<? super E> c){
        compare=c;
        buildHeap(l);
    }

    /**
     * Adds the given item to this priority queue.
     * O(1) in the average case, O(log N) in the worst case
     *
     * @param item
     */
    @Override
    public void add(Object item) {
        //resizes array as needed
        if(arr.length<=addIndex){
            E[] temp = (E[]) new Object[arr.length*2];
            for(int i=0;i<arr.length;i++){
                temp[i]=arr[i];
            }
            arr=temp;
        }
        if(addIndex==0) {
            arr[0] = (E) item;
            addIndex++;
            return;
        }
        arr[addIndex]=(E)item;
        percolateUp(addIndex);
        addIndex++;
    }

    /**
     * Returns, but does not remove, the maximum item this priority queue.
     * O(1)
     *
     * @return the maximum item
     * @throws NoSuchElementException if this priority queue is empty
     */
    @Override
    public E peek() throws NoSuchElementException {
        if(arr[1]!=null)
            return arr[1];
        throw new NoSuchElementException("this BinaryMaxHeap is empty!");
    }

    /**
     * Returns and removes the maximum item this priority queue.
     * O(log N)
     *
     * @return the maximum item
     * @throws NoSuchElementException if this priority queue is empty
     */
    @Override
    public E extractMax() throws NoSuchElementException {
        if(arr[1]!=null) {
            E ret = arr[1];
            arr[1] = arr[addIndex-1];
            arr[addIndex-1] = null;
            addIndex--;
            percolateDown(1);
            return ret;
        }
        throw new NoSuchElementException("this BinaryMaxHeap is empty!");
    }

    /**
     * Returns the number of items in this priority queue.
     * O(1)
     */
    @Override
    public int size() {
        return (addIndex-1);
    }

    /**
     * Returns true if this priority queue is empty, false otherwise.
     * O(1)
     */
    @Override
    public boolean isEmpty() {
        return arr[1]==null;
    }

    /**
     * Empties this priority queue of items.
     * O(1)
     */
    @Override
    public void clear() {
        arr = (E[]) new Object[8];
        addIndex=1;
    }

    /**
     * Creates and returns an array of the items in this priority queue,
     * in the same order they appear in the backing array.
     * O(N)
     * <p>
     * (NOTE: This method is needed for grading purposes. The root item
     * must be stored at index 0 in the returned array, regardless of
     * whether it is in stored there in the backing array.)
     */
    @Override
    public Object[] toArray() {
        E[] ret= (E[])new Object[addIndex-1];
        for(int i=1;i<addIndex;i++){
            ret[i-1]=arr[i];
        }
        return ret;
    }

    /**
     * Builds a heap with a size that is a multiple of 2 using the elements in the provided list
     * @param l - List to be inserted into the array
     */
    private void buildHeap(List l){
        int num = 1;
        int timesMoment = 1;
        while(num<=l.size()+1){
            num=(int)Math.pow(2,timesMoment);
            timesMoment++;
        }
        arr = (E[])new Object[num];
        for(int i = 1;i<l.size()+1;i++){
            arr[i]=(E)l.get(i-1);
            addIndex++;
        }
        for(int i=arr.length/2;i>0;i--){
            percolateDown(i);
        }
    }

    /**
     * Beginning at starting index, this method recursively locates the parent objects and performs switches
     * as necessary to ensure the rules of the data structure are kept.
     * @param index - the starting index
     */
    private void percolateUp(int index){
        if(index==1){
            return;
        }
        //left child
        if(index%2>0){
            int parent=(index)/2;
            if(innerCompare(arr[index],arr[parent])>0){
                E temp = arr[parent];
                arr[parent]=arr[index];
                arr[index]=temp;
                percolateUp(parent);
            }
        }
        //right child
        if(index%2==0){
            int parent=(index)/2;
            if(innerCompare(arr[index],arr[parent])>0){
                E temp = arr[parent];
                arr[parent]=arr[index];
                arr[index]=temp;
                percolateUp(parent);
            }
        }
    }

    /**
     * Beginning at an index, this method recursively locates the two children of the given index,
     * compares the greater of the two children to the given index and performs switches as necessary.
     * @param index - The index to begin recursion at.
     */
    private void percolateDown(int index) {
        //left child is null, so both children null, no right child handled by compare
        if ((index*2)+1>(arr.length-1)||arr[index * 2] == null) {
            return;
        }

        // left child greater than right
        if (innerCompare(arr[index * 2],arr[index * 2 + 1]) > 0) {
            if (innerCompare(arr[index], arr[index * 2]) < 0) {
                E temp = arr[index];
                arr[index] = arr[index * 2];
                arr[index * 2] = temp;
                percolateDown(index * 2);
            }
            //right child greater than left
        } else if (innerCompare(arr[index * 2],arr[index * 2 + 1]) < 0) {
            if (innerCompare(arr[index], arr[index * 2 + 1]) < 0) {
                E temp = arr[index];
                arr[index] = arr[index * 2 + 1];
                arr[index * 2 + 1] = temp;
                percolateDown(index * 2 + 1);
            }

        }
    }

    /**
     * Compares two objects, either using a comparator if the cmp field is populated, or natural ordering.
     * @param o1 - First object to be compared
     * @param o2 - Second object to be compared
     * @return - an int value representing the result of the comparision
     */
    private int innerCompare(E o1,E o2){
        if(o1 == null)
            return -1;
        //if right child is null, then use left child.
        if(o2 == null)
            return 1;
        // check comparator object, if null, use compareTo and cast to comparable otherwise use comparator
        if(compare==null)
        {
            return ((Comparable<? super E>)o1).compareTo(o2);
        }
        else
            return compare.compare(o1,o2);

    }

}
