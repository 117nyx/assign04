package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class implements two different sorting algorithms for arraylists
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class ArrayListSorter {
private static int sizeToSwitch = 4;
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr){
        sortEvery(arr,sizeToSwitch);
        mergePass(arr);
    }

    public static void setSizeToSwitch(int val){
        sizeToSwitch = val;
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
    private static <T extends Comparable<? super T>> void sortEvery(ArrayList<T> arr, int step){
        for(int i = 0;i<arr.size();i+=step){
            InsertionSort.sort(arr,i,i+step);
        }
    }
    private static <T extends Comparable<? super T>> ArrayList<T> mergePass(ArrayList<T> arr){
        arr=merge(arr);
        return arr;

    }

    public static <T extends Comparable<?super T>> ArrayList<T> merge(ArrayList<T> arr){

        int subSize = sizeToSwitch;
        while(subSize<arr.size()) {
            ArrayList<T> returnList = new ArrayList<>();
            for (int hop = 0; hop < arr.size(); hop += subSize * 2) {
                int j = 0;
                int i = 0;

                while (i < subSize && j < subSize) {
                    if (arr.get(i + hop).compareTo(arr.get(j + hop + subSize)) < 0) {
                        returnList.add(arr.get(i + hop));
                        i++;
                    } else if (arr.get(i + hop).compareTo(arr.get(j + hop + subSize)) > 0) {
                        returnList.add(arr.get(j + hop + subSize));
                        j++;
                    } else if (arr.get(i + hop).compareTo(arr.get(j + hop + subSize)) == 0) {
                        returnList.add(arr.get(i + hop));
                        returnList.add(arr.get(j + hop + subSize));
                        j++;
                        i++;
                    }

                }
                while (j < subSize) {
                    returnList.add(arr.get(j + hop + subSize));
                    j++;
                }
                while (i < subSize) {
                    returnList.add(arr.get(i + hop));
                    i++;
                }
            }
            subSize *= 2;
            arr=returnList;
        }
        return arr;
    }

}
