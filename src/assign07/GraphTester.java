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
        Graph sample = new Graph();
        sample.addEdge("a", "b");
        sample.addEdge("b", "c");
        sample.addEdge("c", "d");
        sample.addEdge("b", "d");
        sample.addEdge("d", "a");
        sample.addEdge("d","e");
        assertTrue(sample.DFS("a","c"));
        assertTrue(sample.DFS("a","b"));
        assertTrue(sample.DFS("a","d"));
        assertTrue(sample.DFS("c","b"));
        assertTrue(sample.DFS("b","c"));
        assertFalse(sample.DFS("e","a"));
        assertFalse(sample.DFS("e","b"));
        assertFalse(sample.DFS("e","c"));
        assertFalse(sample.DFS("e","d"));
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
    public void BFSTest(){
        Graph ints = new Graph();
        ints.addEdge(0,1);
        ints.addEdge(1,2);
        ints.addEdge(1,3);
        ints.addEdge(2,6);
        ints.addEdge(3,4);
        ints.addEdge(4,5);
        ints.addEdge(6,7);
        ints.addEdge(5,7);
        System.out.println(ints.BFS(0,7).toString());
    }
}
