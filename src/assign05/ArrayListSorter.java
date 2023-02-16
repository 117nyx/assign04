package assign05;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class implements two different sorting algorithms for arraylists
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class ArrayListSorter {

    private static int sizeToSwitch = 4;

    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
        ArrayList<T> temp = new ArrayList<>(arr.size());
        for(int i=0;i<arr.size();i++)
            temp.add(null);
        split(arr,temp,0,arr.size());
    }

    public static void setSizeToSwitch(int val) {
        sizeToSwitch = val;
    }

    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {

    }

    public static ArrayList<Integer> generateAscending(int size) {
        ArrayList<Integer> arr = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++)
            arr.add(i + 1);
        return arr;
    }

    public static ArrayList<Integer> generatePermuted(int size) {
        ArrayList<Integer> arr = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++)
            arr.add(i + 1);
        Collections.shuffle(arr);
        return arr;
    }

    public static ArrayList<Integer> generateDescending(int size) {
        ArrayList<Integer> arr = new ArrayList<Integer>(size);
        for (int i = size; i > 0; i--)
            arr.add(i);
        return arr;
    }

    private static <T extends Comparable<? super T>> void sortEvery(ArrayList<T> arr, int step) {
        for (int i = 0; i < arr.size(); i += step) {
            InsertionSort.sort(arr, i, i + step);
        }
    }

    public static <T extends Comparable<? super T>> void split(ArrayList<T> arr, ArrayList<T> temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - 1) / 2;
            split(arr, temp, left, mid);
            split(arr, temp, mid + 1, right);

            merge(arr, temp, left, right);
        }
    }


    public static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, ArrayList<T> temp, int left, int right) {
        int mid = left + (right - 1) / 2;
        int j = 0;
        int i = 0;
        int place = left;

        while (i < mid && j < right) {
            if (arr.get(i + left).compareTo(arr.get(j + mid)) < 0) {
                temp.set(place, (arr.get(i)));
                i++;
                place++;
            } else if (arr.get(i + left).compareTo(arr.get(j + mid)) > 0) {
                temp.set(place, arr.get(j + mid));
                j++;
                place++;
            } else if (arr.get(i + left).compareTo(arr.get(j + mid)) == 0) {
                temp.set(place, arr.get(i + left));
                i++;
                place++;
                temp.set(place, arr.get(j + mid));
                j++;
                place++;
            }

        }
        while (j < right) {
            temp.set(place, arr.get(j + mid));
            j++;
            place++;
        }
        while (i < mid) {
            temp.set(place, arr.get(i + left));
            i++;
            place++;
        }
        for(int k=left;k<right;k++){
            arr.set(k,temp.get(k));
        }
    }
}
