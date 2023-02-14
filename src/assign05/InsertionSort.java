package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsertionSort {

    public static <T extends Comparable<? super T>> void sort(ArrayList<T> arr) {

        // for each index, compare to other indexes and switch values as needed
        for (int i = 0; i < arr.size()-1; i++) {
            int j = i + 1;
            // while arr[j] is less than arr[i] move arr[j] toward beginning
            while (j > 0 && arr.get(j).compareTo(arr.get(j-1)) < 0) {
                Collections.swap(arr,j-1,j);
                j--;
            }
        }
    }
}
