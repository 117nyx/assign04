package assign10;

import assign08.BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BinaryMaxHeapTimer {
    public static void main(String args[]) {
        int timesToLoop = 1000;

        ArrayList arr = new ArrayList();
        for (int n = 10000; n <= 100000; n += 10000) {
            Random rand = new Random(n);
            for(int i = 0;i<100_000;i++){
                arr.add(i);
            }
            //Collections.shuffle(arr,rand);


            long startTime, midpointTime, stopTime;


            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.


            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++) {
                    Collections.shuffle(arr, new Random(i));
                    FindKLargest.findKLargestSort(arr,n);
            }

            midpointTime = System.nanoTime();

            // Run an empty loop to capture the cost of running the loop.

            for (int i = 0; i < timesToLoop; i++) { // empty block
                Collections.shuffle(arr, new Random(i));
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
