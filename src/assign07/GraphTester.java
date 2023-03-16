package assign07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class GraphTester {
Graph<Integer> sample;
List<Integer> sources = new ArrayList<Integer>();
    List<Integer> destinations = new ArrayList<Integer>();


    @BeforeEach
    public void before(){
        for(int i = 0; i < 6; i++){

            sources.add(i);
            destinations.add(i+6);
        }

        sample = new Graph<>();
        sample.addEdge(0, 1);
        sample.addEdge(1, 2);
        sample.addEdge(1, 3);
        sample.addEdge(4, 5);
        sample.addEdge(2, 6);
        sample.addEdge(6, 8);
        sample.addEdge(5, 8);
        sample.addEdge(3, 4);

    }

    @Test
    public void areConnectedTest(){
        System.out.println(sample.generateDot());
        assertTrue(sample.DFS(0,8));
        assertFalse(sample.DFS(2,3));
    }

    @Test
    public void BFSTest(){
        Object[] exp = new Object[]{0,1,2,6,8};
        Object[] act = sample.BFS(0,8).toArray();
        assertArrayEquals(exp,act);
    }
    // test constructor- lists of ints
    //test methods once constructor works
    //
}
