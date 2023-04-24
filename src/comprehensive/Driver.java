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
            String next;
            next = out.nextLine();
            while(!next.equals("")){
                String add = next;
                dsf.makeSet(add);
                next=out.nextLine();
            }
            next = out.nextLine();

            //make edges by unioning vertices
            while(!next.equals("")){
                var temp = next.split("\\s+");
                dsf.union(dsf.getRepresentative(temp[0]),dsf.getRepresentative(temp[1]));
                next=out.nextLine();
            }
            next = out.nextLine();
            // check if they are connected using get representative
            while(out.hasNext()){

                var temp = next.split("\\s+");
                if(dsf.getRepresentative(temp[0]).equals(dsf.getRepresentative(temp[1]))) {
                    System.out.println("connected");
                        next=out.nextLine();
                }
                else {
                    System.out.println("not connected");
                        next=out.nextLine();
                }
            }
            var temp = next.split("\\s+");
            if(dsf.getRepresentative(temp[0]).equals(dsf.getRepresentative(temp[1]))) {
                System.out.println("connected");
            }
            else {
                System.out.println("not connected");
            }
        }
        catch (Exception e) {
            System.out.println("File not found "+e);
        }
    }

}
