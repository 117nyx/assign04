package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsertionSort {

    public static <T extends Comparable<? super T>> void sort(ArrayList<T> arr,int left,int right) {

        // for each index, compare to other indexes and switch values as needed
        for (int i = left; i < right-1; i++) {
            int j = i + 1;
            // while arr[j] is less than arr[i] move arr[j] toward beginning
            while (j > left && arr.get(j).compareTo(arr.get(j-1)) < 0) {
                Collections.swap(arr,j-1,j);
                j--;
            }
        }
    }
}
