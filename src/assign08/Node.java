package assign08;

/**
 * Node class for storing values in the binary search tree
 * Authors: Eden Harvey and Jonathan Kerr
 * @param <T>
 */
public class Node <T extends Comparable<? super T>> {
   public T key;
   private Node greater, lesser, parent;

    /**
     * constructor
     * @param key- value stored in node
     */
    public Node(T key){
        this.key=key;
        greater=lesser=parent=null;
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

    public Node getParent(){return parent;};
    public void setParent(Node n){parent = n;};

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
        Node<T> t = getGreater();
        if(t.getGreater()== null)
            return t;
        t.rightMost();
        return null;
    }

}
