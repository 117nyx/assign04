package assign07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class GraphTester {


    @BeforeEach
    public void before(){
        Graph sample = new Graph();
        sample.addEdge("a", "b");
        sample.addEdge("b", "c");
        sample.addEdge("c", "d");
        sample.addEdge("b", "d");
        sample.addEdge("d", "a");
    }
    @Test
    public void DFSTestSmallGraphTrue(){
        assertTrue(Graph.DFS())
    }
}
