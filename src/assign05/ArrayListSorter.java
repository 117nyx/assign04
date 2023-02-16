package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class implements two different sorting algorithms for arraylists
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class ArrayListSorter {
public static int sizeToSwitch = 1;
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr){
        //sort into small sub arrays
        sortEvery(arr,sizeToSwitch);

        mergeStart(arr);
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
    private static <T extends Comparable<? super T>> void mergeStart(ArrayList<T> arr){

//        //init arraylist of arraylists
//        ArrayList<T> mergeLists = new ArrayList<>(arr.size());
//        //divide until subarrays reach desired size
//        while(mergeLists.get(0).size()>sizeToSwitch){
//            mergeLists = mergeSplit(mergeLists);
//        }
//
//
//        while(mergeLists.size()!=1){
//            ArrayList<ArrayList<T>> temp = new ArrayList<>();
//            for(int i=0;i<mergeLists.size()-1;i+=2)
//                temp.add(merge(mergeLists.get(i),mergeLists.get(i+1)));
//            mergeLists = temp;
//        }
//        arr.clear();
//        arr.addAll(mergeLists.get(0));
    }

    public static <T extends Comparable<?super T>> void merge(ArrayList<T> arr){

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
    }

}
