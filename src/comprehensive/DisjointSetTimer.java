package comprehensive;

import assign10.BinaryMaxHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DisjointSetTimer {
    public static void main(String args[]) {
        int timesToLoop = 1000;

        for (int n = 10_000; n <= 100_000; n += 10_000) {
            int val;



            long startTime, midpointTime, stopTime;


            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.


            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++) {
                DisjointSetForest dsf = new DisjointSetForest();
                for (int j = 0; j < n; j++) {
                    dsf.makeSet(j);
                }
                for(int j=1;j<n;j++) {
                    val = (int) (Math.random() * j);
                    dsf.union(val,j);
                }
            }

            midpointTime = System.nanoTime();

            // Run an empty loop to capture the cost of running the loop.

            for (int i = 0; i < timesToLoop; i++) { // empty block
                DisjointSetForest dsf = new DisjointSetForest();
                for (int j = 0; j < n; j++) {
                    dsf.makeSet(j);
                }
                for(int j=1;j<n;j++)
                   val = (int)(Math.random()*j);
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
}
