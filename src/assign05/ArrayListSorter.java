package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class implements two different sorting algorithms for arraylists- merge sort and quicksort
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


    public static ArrayList<Integer> generateAscending(int size) {
        ArrayList<Integer> arr = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++)
            arr.add(i + 1);
        return arr;
    }

    public static ArrayList<Integer> generatePermuted(int size, long seed) {
        Random rnd = new Random(seed);
        ArrayList<Integer> arr = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++)
            arr.add(i + 1);
        Collections.shuffle(arr,rnd);
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
                temp.set(place, (arr.get(left+i)));
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
    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr, int left, int right, String type) {
        if(left + sizeToSwitch < right){
            int partPoint = partition(arr,left,right,type);

            quicksort(arr,left,partPoint,type);
            quicksort(arr,partPoint,right,type);
        }
        else {
            InsertionSort.sort(arr, left, right + 1);
        }
    }


    public static <T extends Comparable<? super T>> int partition(ArrayList<T> arr, int left, int right, String type) {
        if (type.equals("last")) {
            //get last element as pivot,
            int pivotStorage = right-1;
            T pivot = arr.get(pivotStorage);
            return partitionLoop(arr,right,left,pivot,pivotStorage);

        }
        if (type.equals("random")) {
            //get random element
            int range = (right-left);
            int pivotStorage = (int) (Math.random() * range + left);
            T pivot = arr.get(pivotStorage);
            return partitionLoop(arr,right,left,pivot,pivotStorage);

        }

        if (type.equals("middle")) {
            //get middle element
                int pivotStorage = (right + left)/2;
                T pivot = arr.get(pivotStorage);
                return partitionLoop(arr,right,left,pivot,pivotStorage);

                }

            throw new IllegalArgumentException("incorrect string input");

    }
    private static <T extends Comparable<? super T>> int partitionLoop(ArrayList<T> arr, int right, int left, T pivot, int pivotStorage){
       //swap pivot element with last element
        T temp = arr.get(right);
        arr.set(right,arr.get(pivotStorage));
        arr.set(pivotStorage,temp);
        pivotStorage = right;
        //make sure right ignores pivot
        right--;

        while(left < right){
            //move left and right over any correct elements
            while (arr.get(left).compareTo(pivot) < 0)
                left++;
            while(arr.get(right).compareTo(pivot) > 0) {
                if (right != 0)
                    right--;
                else
                    break;
            }


            if(left < right) {
                //swap left and right elements that are in wrong place(now on correct side of pivot)
                T temp2 = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp2);
                left++;
                right--;
            }

        }
        //check to see if left moved through every element(pivot == greatest value)
        if(left == pivotStorage)
            return left;
        //move left one more time if needed
        if(arr.get(left).compareTo(pivot) <= 0)
            left++;
        //swap left and pivot since it is now in right place
        T temp3 = arr.get(left);
        arr.set(left,arr.get(pivotStorage));
        arr.set(pivotStorage,temp3);
        return left;
    }
}

