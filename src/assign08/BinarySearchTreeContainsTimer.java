package assign08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class BinarySearchTreeContainsTimer {

    public static void main(String args[]) {
        int timesToLoop = 1000;
        Random rand = new Random();
        for (int n = 10000; n <= 100000; n += 10000) {

            BinarySearchTree b = new BinarySearchTree();
            long startTime, midpointTime, stopTime;


            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.


            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++) {
                ArrayList vals = new ArrayList();
                for (int j = 0; j < n; j++) {
                    vals.add(j);
                }
                Collections.shuffle(vals, new Random(i));
                b.addAll(vals);
                b.containsAll(vals);
            }

            midpointTime = System.nanoTime();

            // Run an empty loop to capture the cost of running the loop.

            for (int i = 0; i < timesToLoop; i++) { // empty block
                ArrayList vals = new ArrayList();
                for (int j = 0; j < n; j++) {
                    vals.add(j);
                }
                Collections.shuffle(vals, new Random(i));
                b.addAll(vals);
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
