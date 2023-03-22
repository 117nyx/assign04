package assign08;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.CommonParserSettings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BinarySearchTree <T extends Comparable<? super T>> implements SortedSet {
private Node head;
    /**
     * Ensures that this set contains the specified item.
     *
     * @param item - the item whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * the input item was actually inserted); otherwise, returns false
     */
    @Override
    public boolean add(Comparable item) {
        if(head==null){
            head=new Node(item);
            return true;
        }
        return addUtil(item,head);


    }
    public boolean addUtil(Comparable item,Node head){
        int val = item.compareTo(head.key);
        if (val == 0) {
            return false;
        } else if (val > 0) {
            if(head.getGreater()==null){
                head.setGreater(new Node(item));
                return true;
            }
            head = head.getGreater();
            return addUtil(item,head);
        } else {
            if(head.getLesser()==null){
                head.setLesser(new Node(item));
                return true;
            }
            head = head.getLesser();
            return addUtil(item,head);
        }
    }

    /**
     * Ensures that this set contains all items in the specified collection.
     *
     * @param items - the collection of items whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * any item in the input collection was actually inserted); otherwise,
     * returns false
     */
    @Override
    public boolean addAll(Collection items) {
        boolean ret=false;
        for(Object o:items){
            if(add((Comparable)o))
                ret = true;

        }
        return ret;
    }

    /**
     * Removes all items from this set. The set will be empty after this method
     * call.
     */
    @Override
    public void clear() {
        head=null;
    }

    /**
     * Determines if there is an item in this set that is equal to the specified
     * item.
     *
     * @param item - the item sought in this set
     * @return true if there is an item in this set that is equal to the input item;
     * otherwise, returns false
     */
    @Override
    public boolean contains(Comparable item) {
        if(head==null){
            return false;
        }
        return containsUtil(item,head);
    }
    public boolean containsUtil(Comparable item,Node head){
        int val = item.compareTo(head.key);
        if (val == 0) {
            return true;
        } else if (val > 0) {
            if(head.getGreater()==null){
                return false;
            }
            head = head.getGreater();
            return containsUtil(item,head);
        } else {
            if(head.getLesser()==null){
                return false;
            }
            head = head.getLesser();
            return containsUtil(item,head);
        }
    }

    /**
     * Determines if for each item in the specified collection, there is an item in
     * this set that is equal to it.
     *
     * @param items - the collection of items sought in this set
     * @return true if for each item in the specified collection, there is an item
     * in this set that is equal to it; otherwise, returns false
     */
    @Override
    public boolean containsAll(Collection items) {
        for(Object i:items){
            if(!contains((Comparable) i))
                return false;
        }
        return true;
    }

    /**
     * Returns the first (i.e., smallest) item in this set.
     *
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public Comparable first() throws NoSuchElementException {
        if(head == null)
            throw new NoSuchElementException();
        Node start = head;
        while(start.getLesser()!=null)
        {
            start = start.getLesser();
        }
        return start.key;
    }


    /**
     * Returns true if this set contains no items.
     */
    @Override
    public boolean isEmpty() {
        if(head!=null){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns the last (i.e., largest) item in this set.
     *
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public Comparable last() throws NoSuchElementException {
        if(head == null)
            throw new NoSuchElementException();
        Node start = head;
        while(start.getGreater()!=null)
        {
            start = start.getGreater();
        }
        return start.key;
    }

    /**
     * Ensures that this set does not contain the specified item.
     *
     * @param item - the item whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * the input item was actually removed); otherwise, returns false
     */
    @Override
    public boolean remove(Comparable item) {
        return true;
    }



    /**
     * Ensures that this set does not contain any of the items in the specified
     * collection.
     *
     * @param items - the collection of items whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * any item in the input collection was actually removed); otherwise,
     * returns false
     */
    @Override
    public boolean removeAll(Collection items) {
        return false;
    }

    /**
     * Returns the number of items in this set.
     */
    public int size() {
       return size(head);
    }

    public int size(Node root) {
        if (root == null)
            return 0;
        int l = size(root.getLesser());
        int r = size(root.getGreater());

        return 1 + l + r;
    }



    /**
     * Returns an ArrayList containing all of the items in this set, in sorted
     * order.
     */
    @Override
    public ArrayList toArrayList() {
        ArrayList ret = new ArrayList();
        toArrayList(ret,head);
        return ret;
    }
    private void toArrayList(ArrayList ret, Node n) {
        if (n == null)
            return;
        toArrayList(ret,n.getLesser());
        ret.add(n);
        toArrayList(ret,n.getGreater());
    }



}
