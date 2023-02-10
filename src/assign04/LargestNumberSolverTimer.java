package assign04;

import java.util.ArrayList;
import java.util.Random;


/**
 * This class is used to time kth largest methods from our largest number solver class
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class LargestNumberSolverTimer {
    public static void main(String args[]) {
        Random randomNumberGenerator = new Random();




        // Now, run the test.

        int timesToLoop = 10;

        for (int n = 100; n <= 1000; n += 100) {
            ArrayList<Integer[]> list = new ArrayList<Integer[]>(n);

            for(int i =0; i < list.size();i++) {
                Integer[] newList = new Integer[10];
                for(int j = 0; j < newList.length;j++) {
                    Integer randomInt = randomNumberGenerator.nextInt(100);
                    newList[j] = randomInt;
                }
                list.add(newList);

            }
            long startTime, midpointTime, stopTime;


            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.


            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++)
                LargestNumberSolver.findKthLargest(list, 1);

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



