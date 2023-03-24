package assign08;

/**
 * Node class for storing values in the binary search tree
 * Authors: Eden Harvey and Jonathan Kerr
 * @param <T>
 */
public class Node <T extends Comparable<? super T>> {
    private T item;
   private Node greater, lesser;

    /**
     * constructor
     * @param key- value stored in node
     */
    public Node(T key){
        this.item=key;
        greater=lesser=null;
    }
    // setters and getters for different nodes
    public void setGreater(Node n){
        greater=n;
    }
    public void setLesser(Node n){
        lesser=n;
    }
    public Node getGreater(){
        return greater;
    }
    public Node getLesser(){
        return lesser;
    }



    /**
     * checks if theres two children for the selected node
     * @return
     */
    public boolean hasBothChildren(){
        if(lesser!=null&&greater!=null){
            return true;
        } else {
            return false;
        }
    }
    public boolean hasAChild(){
        if(hasBothChildren())
            return false;
        else if(lesser == null && greater != null)
            return true;
        else if(lesser != null && greater==null)
            return true;
        else
            return false;
    }
    public Node rightMost(){
        if(this.getGreater()==null){
            return this;
        }
        Node<T> t = getGreater();
        if(t.getGreater()== null)
            return t;
        t.rightMost();
        return null;
    }
    public Node leftMost(){
        if(this.getLesser()==null){
            return this;
        }
        Node<T> t = getLesser();
        if(t.getLesser() == null)
            return t;
        t.leftMost();
        return null;
    }
    public T getItem(){
        return item;
    }
    public void setItem(T item){
        this.item=item;
    }

}
