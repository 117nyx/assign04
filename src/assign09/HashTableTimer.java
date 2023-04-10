package assign09;

import assign08.BinarySearchTree;

import java.io.File;
import java.io.Flushable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class HashTableTimer {
    public static void main(String args[]) {
        int timesToLoop = 10000;
        ArrayList students;
        HashTable hash;
        for (int n = 10000; n <= 100000; n += 10000) {
            hash = new HashTable();
            try {
                Scanner scan = new Scanner(new File("words.txt"));

            Random rand = new Random(n);
            students = new ArrayList();
            for(int i=0;i<n;i++){
                int uid = Integer.parseInt("14"+rand.nextInt(10000,100000));

                students.add(new StudentGoodHash(uid,scan.next(),scan.next()));

            }
//                for (Object s:students) {
//                    System.out.println(s.hashCode());
//                }

            long startTime, midpointTime, stopTime;


            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.


            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) { // empty block
            }

            startTime = System.nanoTime();

            for (int i = 0; i < timesToLoop; i++) {
                for(int j=0;j<timesToLoop;j++){
                    hash.remove(students.get(j));
                }
            }

            midpointTime = System.nanoTime();

            // Run an empty loop to capture the cost of running the loop.

            for (int i = 0; i < timesToLoop; i++) { // empty block
                for(int j=0;j<timesToLoop;j++){
                }
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and computing square roots.
            // Average it over the number of runs.

            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) /
                    (double) timesToLoop;

            System.out.println(n + "\t" + averageTime);
            } catch(Exception e){
                System.out.println("file not found");
            }
        }

    }
}
