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
            mergeLists = mergeSplit(mergeLists);
        }
        for(ArrayList<T> obj: mergeLists){
            InsertionSort.sort(obj);
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
    private static <T> ArrayList<ArrayList<T>> mergeSplit(ArrayList<ArrayList<T>> arr){
        ArrayList<ArrayList<T>> outList= new ArrayList<>();
        for(int i = 0;i<arr.size();i++){
            outList.add(new ArrayList<>(arr.get(i).subList(0,arr.get(i).size()/2)));
            outList.add(new ArrayList<>(arr.get(i).subList(arr.get(i).size()/2,arr.get(i).size())));
        }
        return outList;
    }

}
