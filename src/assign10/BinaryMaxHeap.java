package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryMaxHeap<E> implements PriorityQueue {

    private int size;
    private Comparator compare;
    private E[] arr = (E[]) new Object[8];
    private int addIndex=0;

    public BinaryMaxHeap(){
        compare=null;
        size=0;
    }
    public BinaryMaxHeap(Comparator<? super E> c){
        compare=c;
        size=0;

    }
    public BinaryMaxHeap(List<E> l){
        compare=null;
        size=0;

    }
    public BinaryMaxHeap(List<? extends E> l, Comparator<? super E> c){
        compare=c;
        size=0;

    }

    /**
     * Adds the given item to this priority queue.
     * O(1) in the average case, O(log N) in the worst case
     *
     * @param item
     */
    @Override
    public void add(Object item) {
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
    public Object peek() throws NoSuchElementException {
        if(arr[0]!=null)
            return arr[0];
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
    public Object extractMax() throws NoSuchElementException {
        if(arr[0]!=null) {
            Object ret = arr[0];
            arr[0] = arr[addIndex - 1];
            arr[addIndex - 1] = null;
            addIndex--;
            percolateDown(0);
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
        return addIndex-1;
    }

    /**
     * Returns true if this priority queue is empty, false otherwise.
     * O(1)
     */
    @Override
    public boolean isEmpty() {
        return arr[0]!=null;
    }

    /**
     * Empties this priority queue of items.
     * O(1)
     */
    @Override
    public void clear() {
        arr = (E[]) new Object[8];
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
        return arr;
    }
    private void buildHeap(List<E> l){
        arr=(E[])l.toArray();
        for(int i=arr.length/2;i>=0;i--){
            percolateDown(i);
        }
    }
    private void percolateUp(int index){
        if(index%2>0){
            int parent=(index-1)/2;
            if(innerCompare(arr[index],arr[parent])>0){
                E temp = arr[parent];
                arr[parent]=arr[index];
                arr[index]=temp;
                percolateUp(parent);
            }
        }
        if(index%2==0){
            int parent=(index-2)/2;
            if(innerCompare(arr[index],arr[parent])>0){
                E temp = arr[parent];
                arr[parent]=arr[index];
                arr[index]=temp;
                percolateUp(parent);
            }
        }
    }
    private void percolateDown(int index) {
        if (arr[index * 2 + 1] == null) {
            return;
        }
        if (innerCompare(arr[index * 2 + 2], arr[index * 2 + 1]) < 0) {
            if (innerCompare(arr[index], arr[index * 2 + 1]) < 0) {
                E temp = arr[index];
                arr[index] = arr[index * 2 + 1];
                arr[index * 2 + 1] = temp;
                percolateDown(index * 2 + 1);
            }
        } else if (innerCompare(arr[index * 2 + 2], arr[index * 2 + 1]) > 0) {
            if (innerCompare(arr[index], arr[index * 2 + 2]) < 0) {
                E temp = arr[index];
                arr[index] = arr[index * 2 + 2];
                arr[index * 2 + 2] = temp;
                percolateDown(index * 2 + 2);
            }

        }
    }
    private int innerCompare(E o1,E o2){
        //TODO logic
        return 0;
    }

}
