package assign05;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class implements two different
 */
public class ArrayListSorter {

    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T>){

    }

    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T>){

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
