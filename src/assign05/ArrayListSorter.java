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
    private static <T extends Comparable<? super T>> void mergeStart(ArrayList<T> arr){
        //init arraylist of arraylists
        ArrayList<ArrayList<T>> mergeLists = new ArrayList<>(arr.size()/sizeToSwitch);
        mergeLists.add(arr);
        //divide until subarrays reach desired size
        while(mergeLists.get(0).size()>sizeToSwitch){
            mergeLists = mergeSplit(mergeLists);
        }
        //sort small sub arrays
        for(ArrayList<T> obj: mergeLists){
            InsertionSort.sort(obj);
        }

        while(mergeLists.size()!=1){
            ArrayList<ArrayList<T>> temp = new ArrayList<>();
            for(int i=0;i<mergeLists.size()-1;i+=2)
                temp.add(merge(mergeLists.get(i),mergeLists.get(i+1)));
            mergeLists = temp;
        }
        arr.clear();
        arr.addAll(mergeLists.get(0));
    }
    private static <T extends Comparable<?super T>> ArrayList<ArrayList<T>> mergeSplit(ArrayList<ArrayList<T>> arr){
        ArrayList<ArrayList<T>> outList= new ArrayList<>();
        for(int i = 0;i<arr.size();i++){
            outList.add(new ArrayList<>(arr.get(i).subList(0,arr.get(i).size()/2)));
            outList.add(new ArrayList<>(arr.get(i).subList(arr.get(i).size()/2,arr.get(i).size())));
        }
        return outList;
    }
    private static <T extends Comparable<?super T>> ArrayList<T> merge(ArrayList<T> arrLeft,ArrayList<T> arrRight){
        ArrayList<T> returnList = new ArrayList<T>();
        int j=0;
        int i=0;
        while(i<arrLeft.size()&&j<arrRight.size()){
                if(arrLeft.get(i).compareTo(arrRight.get(j))<0){
                    returnList.add(arrLeft.get(i));
                    i++;
                } else if(arrLeft.get(i).compareTo(arrRight.get(j))>0) {
                    returnList.add(arrRight.get(j));
                    j++;
                } else if(arrLeft.get(i).compareTo(arrRight.get(j))==0){
                    returnList.add(arrLeft.get(i));
                    returnList.add(arrRight.get(j));
                    j++;
                    i++;
                }

            }
        while(j<arrRight.size()){
            returnList.add(arrRight.get(j));
            j++;
        }
        while(i<arrLeft.size()){
            returnList.add(arrLeft.get(i));
            i++;
        }


        return returnList;
    }

}
