package assign05;

import assign04.LargestNumberSolver;

import java.util.ArrayList;

public class ArrayListSorterTimer {

    public static void main(String args[]){
        int timesToLoop=10000;
        ArrayList ints = new ArrayList();
        for (int n = 1; n <= 131072; n*=2) {
            ints=ArrayListSorter.generateDescending(131072);
            ArrayListSorter.setSizeToSwitch(n);

            long startTime, midpointTime, stopTime;


            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.


            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++)
                ArrayListSorter.mergesort(ints);

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

}
