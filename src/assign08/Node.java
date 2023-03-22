package assign08;

public class Node <T extends Comparable<? super T>> {
   public T key;
   private Node greater, lesser;
   boolean visited;

    public Node(T key){
        this.key=key;
        greater=lesser=null;
    }

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
    public boolean hasBothChildren(){
        if(lesser!=null&&greater!=null){
            return true;
        } else {
            return false;
        }
    }

}
