package comprehensive;

public class Node {
    public String data;
    public String parent;

    public Node(String data){
        this.data = data;
    }
    public Node(String data, String parent){
        this.data=data;
        this.parent=parent;
    }
    public void setParent(String s){
        parent = s;
    }
    public void setData(String s){
        data=s;
    }
}
