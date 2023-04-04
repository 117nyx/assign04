package assign07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class GraphTester {
Graph sample;
List<Vertex> vertices = new ArrayList<Vertex>();



    @BeforeEach
    public void before(){
        Graph sample = new Graph();
        sample.addEdge("a", "b");
        sample.addEdge("b", "c");
        sample.addEdge("c", "d");
        sample.addEdge("b", "d");
        sample.addEdge("d", "a");

        Graph ints = new Graph();


    }
    @Test
    public void DFSTestSmallGraphTrue(){

        ArrayList ar1 = new ArrayList();
        ar1.add("a");
        ar1.add("b");
        ar1.add("c");
        ar1.add("b");
        ar1.add("d");
        ar1.add("d");
        ArrayList ar2 = new ArrayList();
        ar2.add("b");
        ar2.add("c");
        ar2.add("d");
        ar2.add("d");
        ar2.add("a");
        ar2.add("e");
      assertTrue(GraphUtility.areConnected(ar1,ar2,"b","e"));
      assertFalse(GraphUtility.areConnected(ar1,ar2,"e","a"));
    }
    @Test
    public void TopoSort() {
        List int1 = new ArrayList<>();
        int1.add(45);
        int1.add(0);
        int1.add(1);
        int1.add(1);
        int1.add(3);
        int1.add(2);



        List int2 = new ArrayList<>();
        int2.add(1);
        int2.add(1);
        int2.add(2);
        int2.add(3);
        int2.add(4);
        int2.add(3);


        Graph ints = new Graph(int1, int2);
        System.out.println(ints.generateDot());
        List actual = ints.topoSort();
        for (var v : actual) {
            System.out.println(v.toString());
        }

    }
    @Test
    public void topoSortExceptionCheck(){
        List int1 = new ArrayList<>();
        int1.add(1);
        int1.add(2);

        List int2 = new ArrayList<>();
        int2.add(2);
        int2.add(1);

        assertThrows(IllegalArgumentException.class,()->GraphUtility.sort(int1,int2));
    }
    @Test
    public void BFSTest(){
        Graph ints = new Graph();
        ints.addEdge(0,1);

        System.out.println(ints.BFS(1,0).toString());
    }

}
