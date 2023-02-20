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
        for (int i = 0; i < arr.size(); i++)
            temp.add(null);
        split(arr, temp, 0, arr.size() - 1);
    }

    public static void setSizeToSwitch(int val) {
        sizeToSwitch = val;
    }

    public static int getSizeToSwitch() {
        return sizeToSwitch;
    }

    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr, int low, int high, String type) {
        if(low < high){
            int pivot = partition(arr,low,high,type);

            quicksort(arr,low,pivot-1,type);
            quicksort(arr,pivot+1,high,type);
        }
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
        if (left + sizeToSwitch < right) {
            int mid = (left + (right)) / 2;
            split(arr, temp, left, mid);
            split(arr, temp, mid + 1, right);

            merge(arr, temp, left, right);
        }
        if (left + sizeToSwitch >= right) {
            InsertionSort.sort(arr, left, right + 1);
        }
    }


    public static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, ArrayList<T> temp, int left, int right) {
        int mid = (left + (right)) / 2;
        int j = 0;
        int i = 0;
        int place = left;

        while (i + left <= mid && j + mid + 1 <= right) {
            if (arr.get(i + left).compareTo(arr.get(j + mid + 1)) < 0) {
                temp.set(place, (arr.get(i)));
                i++;
                place++;
            } else if (arr.get(i + left).compareTo(arr.get(j + mid + 1)) > 0) {
                temp.set(place, arr.get(j + mid + 1));
                j++;
                place++;
            } else if (arr.get(i + left).compareTo(arr.get(j + mid + 1)) == 0) {
                temp.set(place, arr.get(i + left));
                i++;
                place++;
            }

        }
        while (j + mid < right) {
            temp.set(place, arr.get(j + mid + 1));
            j++;
            place++;
        }
        while (i + left <= mid) {
            temp.set(place, arr.get(i + left));
            i++;
            place++;
        }
        for (int k = left; k <= right; k++) {
            arr.set(k, temp.get(k));
        }
    }

    public static <T extends Comparable<? super T>> int partition(ArrayList<T> arr, int low, int high, String type) {
        if (type.equals("last")) {
            //get last element as pivot,
            T pivot = arr.get(high);
            int index = low - 1;
            for (int i = low; i < high; i++)
                if (arr.get(i).compareTo(pivot) < 0) {
                    index++;
                    T temp = arr.get(i);
                    arr.set(i,arr.get(index));
                    arr.set(index, temp);
                }

            T temp = arr.get(index+1);
            arr.set(index,arr.get(high));
            arr.set(index+1,temp);
            return(index + 1);
        }
        if (type.equals("random")) {
            T pivot = arr.get((int) (Math.random()* arr.size() +low));
            int index = low - 1;
            for (int i = low; i < high; i++)
                if (arr.get(i).compareTo(pivot) < 0) {
                    index++;
                    T temp = arr.get(i);
                    arr.set(i,arr.get(index));
                    arr.set(index,temp);
                }

            T temp = arr.get(index+1);
            arr.set(index,arr.get(high));
            arr.set(index+1,temp);
            return(index + 1);
        }

        if (type.equals("middle")) {
                T pivot = arr.get((high + low)/2);
                int index = low - 1;
                for (int i = low; i < high; i++)
                    if (arr.get(i).compareTo(pivot) < 0) {
                        index++;
                        T temp = arr.get(i);
                        arr.set(i,arr.get(index));
                        arr.set(index,temp);
                    }

                T temp = arr.get(index+1);
                arr.set(index,arr.get(high));
                arr.set(index+1,temp);
                return(index + 1);
                }

            throw new IllegalArgumentException("incorrect string input");

    }

}
