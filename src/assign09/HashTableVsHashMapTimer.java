package assign09;

import java.io.File;
import java.util.*;

public class HashTableVsHashMapTimer {
    static File file= new File("words.txt");
    public static void main(String args[]) {

        int timesToLoop = 1000;
        ArrayList students;
        HashMap hash;
        for (int n = 10000; n <= 100000; n += 10000) {
            hash = new HashMap();
            try {
                Scanner scan = new Scanner(file);

                Random rand = new Random(n);
                students = new ArrayList();
                //generate list of keys
                for(int i=0;i<n;i++){
                    students.add(scan.next());
                }
                //put keys and random ints into hash table
                for(Object s:students){
                    hash.put(s,rand.nextInt());
                }
                //shuffle list of keys
                Collections.shuffle(students);
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
                    for(int j=0;j<10000;j++){
                        hash.remove(students.get(j));
                    }
                }

                midpointTime = System.nanoTime();

                // Run an empty loop to capture the cost of running the loop.

                for (int i = 0; i < timesToLoop; i++) { // empty block
                    for(int j=0;j<10000;j++){
                        students.get(j);
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
                System.out.println(e);
            }
        }

    }
}
