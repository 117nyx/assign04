package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class implements two different sorting algorithms for arraylists
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class ArrayListSorter {
public static int sizeToSwitch = 4;
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr){
        ArrayList<ArrayList<T>> mergeLists = new ArrayList<>();
        mergeLists.add(arr);

        while(mergeLists.get(0).size()>sizeToSwitch){
            ArrayList<List<T>> clone = new ArrayList<>();
            for(int j=0;j<mergeLists.size();j++){
                clone.add(mergeLists.get(j).subList(0,mergeLists.get(j).size()/2));
                clone.add(mergeLists.get(j).subList(mergeLists.get(j).size()/2,mergeLists.get(j).size()));
            }
        }

    }

    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr){

    }

    public static ArrayList<Integer> generateAscending(int size){
        ArrayList<Integer> arr = new ArrayList<Integer>(size);
        for(int i = 0; i<size;i++)
            arr.add(i+1);
        return arr;
    }

    public static ArrayList<Integer> generatePermuted(int size){
        ArrayList<Integer> arr = new ArrayList<Integer>(size);
        for(int i = 0; i<size;i++)
            arr.add(i+1);
        Collections.shuffle(arr);
        return arr;
    }

    public static ArrayList<Integer> generateDescending(int size) {
        ArrayList<Integer> arr = new ArrayList<Integer>(size);
        for (int i = size; i >0; i--)
            arr.add(i);
        return arr;
    }

}
