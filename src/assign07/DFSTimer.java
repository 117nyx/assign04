package assign07;

import java.util.Random;

public class DFSTimer {
    public static void main(String args[]){
        int timesToLoop=10000;
        Graph g = new Graph<>();
        for (int n = 1000; n <= 10000; n+=1000) {
            g = generateRandomGraph(g,n,n);
            long startTime, midpointTime, stopTime;


            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.


            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++) {
                g.DFS("v1" ,"v100");
            }

            midpointTime = System.nanoTime();

            // Run an empty loop to capture the cost of running the loop.

            for (int i = 0; i < timesToLoop; i++) { // empty block
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and computing square roots.
            // Average it over the number of runs.

            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) /
                    (double) timesToLoop;

            System.out.println(n + "\t" + averageTime);
        }
    }
    public static Graph generateRandomGraph( Graph g, int vertexCount, int seed) {
        Random rng = new Random(seed);
        g = new Graph();
        // generate a list of vertices
        String[] vertex = new String[vertexCount];
        for(int i = 0; i < vertexCount; i++)
            vertex[i] = "v" + i;

        // randomly connect the vertices using 2 * |V| edges
        for(int i = 0; i < 2 * vertexCount; i++)
            g.addEdge(vertex[rng.nextInt(vertexCount)],vertex[rng.nextInt(vertexCount)]);
//vertex[i + 1 + rng.nextInt(vertexCount - (i + 1))
        return g;


    }
}
