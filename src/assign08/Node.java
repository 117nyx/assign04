package assign08;

public class Node <T extends Comparable<? super T>> {
   public T key;
   private Node greater, lesser;


    public Node(T key){
        this.key=key;
        greater=lesser=null;
    }

    public void setGreater(Node n){
        n=greater;
    }
    public void setLesser(Node n){
        n=lesser;
    }
    public Node getGreater(){
        return greater;
    }
    public Node getLesser(){
        return lesser;
    }

}
