package assign05;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class implements two different sorting algorithms for arraylists
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class ArrayListSorter {

    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr){

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
