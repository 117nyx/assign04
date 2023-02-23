package assign05;

import java.util.ArrayList;

public class InsertionSortTimer {
    public static void main(String args[]) {
        int timesToLoop = 1000;
        ArrayList ints = new ArrayList();
        for(int n=0;n<timesToLoop;n++){
            ints = ArrayListSorter.generatePermuted(10000,n);

            long startTime, midpointTime, stopTime;


            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.


            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block

            }

            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++)
                ArrayListSorter.quicksort(ints,0,ints.size()-1,"middle");

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
