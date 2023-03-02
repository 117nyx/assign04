package assign05;

import java.util.ArrayList;

public class MergeSortvsQuickSortTiming {
    public static void main(String args[]){
        int timesToLoop=100;
        ArrayList ints = new ArrayList();

            ArrayListSorter.setSizeToSwitch(16);
            long startTime, midpointTime, stopTime;


            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.


            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++) {
                ints=ArrayListSorter.generateAscending(1_000_000);
                ArrayListSorter.mergesort(ints);
            }

            midpointTime = System.nanoTime();

            // Run an empty loop to capture the cost of running the loop.

            for (int i = 0; i < timesToLoop; i++) { // empty block
                ArrayListSorter.generateAscending(1_000_000);
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and computing square roots.
            // Average it over the number of runs.

            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) /
                    (double) timesToLoop;

            System.out.println(1_000_000 + "\t" + averageTime);

    }
}
