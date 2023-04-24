package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver class for our disjoint set implemetation that checks if two vertices are connected.
 */
public class Driver {
    public static void main(String[] args) {
        DisjointSetForest<String> dsf = new DisjointSetForest<>();
        try {
            // Make set with the vertices
            File input = new File(args[0]);
            Scanner out = new Scanner(input);
            while(out.hasNextLine()){
                String add = out.next();
                dsf.makeSet(add);
                out.nextLine();
            }
            out.nextLine();

            //make edges by unioning vertices
            while(out.hasNextLine()){
                dsf.union(dsf.getRepresentative(out.next()),dsf.getRepresentative(out.next()));
                out.nextLine();
            }
            out.nextLine();

            // check if they are connected using get representative
            while(out.hasNextLine()){
                if(dsf.getRepresentative(out.next()).equals(dsf.getRepresentative(out.next()))) {
                    System.out.println("connected");
                    out.nextLine();
                }
                else {
                    System.out.println("not connected");
                    out.nextLine();
                }
            }
        }
        catch (Exception e) {
            System.out.println("File not found");
        }
    }

}
