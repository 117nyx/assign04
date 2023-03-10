package assign04;
/**
 * This class represents a largest number solver that allows users to find the largest number made
 * out of arranging the integers in an array and combining them into one big integer,int, or long
 * Authors: Jonathan Kerr and Eden Harvey
 */

import java.io.File;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @param <T>
 */
public class LargestNumberSolver <T> {
    //variable

    /**
     * sorts input array using insertion sort ad input Comparator object
     *
     * @param arr- array to be sorted
     * @param <T>- generic type
     */
    public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {  //O(n^2)

        // for each index, compare to other indexes and switch values as needed
        for (int i = 1; i < arr.length; ++i) {
            T val = arr[i];
            int j = i - 1;
            // while arr[j] is greater than arr[i] move arr[j] toward beginning
            while (j >= 0 && cmp.compare(arr[j], val) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = val;
        }
    }

    /**
     * returns the largest number that can be formed by arranging the integers of the given array, in any order.
     * If the array is empty, the largest number that can be formed is 0.
     *
     * @param arr- input array
     * @return
     */
    public static BigInteger findLargestNumber(Integer[] arr) {
        //This method must not alter the given array and must call your insertionSort method
        Integer[] arrCopy = arr.clone();
        Comparator cmp = new biggestNum();
        // sort array using comparator, make a new string and add values of sorted array to string
        insertionSort(arrCopy,cmp);
        StringBuilder returnVal=new StringBuilder();
        for(Integer val: arrCopy)
            returnVal.append(val);
        return new BigInteger(returnVal.toString());

    }


    /**
     * Returns largest int value that can be formed by arranging integers of the given array
     * in any order
     *
     * @param arr
     * @return
     * @throws OutOfRangeException- thrown if largest number is too large for int data type
     */
    public static int findLargestInt(Integer[] arr) throws OutOfRangeException {
        // call find largest, check for out of bounds, convert to int
        BigInteger tempInt = findLargestNumber(arr);
        if(tempInt.compareTo(new BigInteger("2147483647"))>0)
            throw new OutOfRangeException("returned result is too large for int datatype");
        return tempInt.intValue();
    }

    /**
     * Same behavior as previous method, but for long data type
     *
     * @param arr
     * @return
     * @throws OutOfRangeException-thrown if largest number is too large for long data type
     */
    public static long findLargestLong(Integer[] arr) throws OutOfRangeException {
        //call find largest, check for out of bounds, convert to long
        BigInteger tempInt = findLargestNumber(arr);
        if(tempInt.compareTo(new BigInteger("9223372036854775807"))>0)
            throw new OutOfRangeException("returned result is too large for long datatype");
        return tempInt.longValue();
    }

    /**
     * sums largest numbers that can be formed b each array in the given list, does not alter given list
     *
     * @param list
     * @return
     */
    public static BigInteger sum(List<Integer[]> list) {
        //call find largest on each array, add them together
        ArrayList<Integer[]> listCopy= new ArrayList<>();
        for (Integer[] item : list) listCopy.add(item.clone());
        BigInteger big= new BigInteger("0");
        for(Integer[] val: listCopy){
            big=big.add(findLargestNumber(val));
        }
        return big;
    }

    /**
     * This method determines the kth largest number that can be formed by each array in the given list.
     * E.g., if k=0 returns the largest overall, if k=list.size()-1 returns the smallest overall.
     * This method returns the original array that represents the kth largest number,
     * not the kth largest number itself.
     *
     * @param list
     * @param k
     * @return
     * @throws IllegalArgumentException- thrown if k is not a valid position
     */
    public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException {
        if(k>=list.size()||k<0){
            throw new IllegalArgumentException("provided value k is out of bounds of given list"); //O(1)
        }
        Integer[][] intList = (Integer[][]) list.toArray(new Integer[0][0]); //O(N)
        LargestNumberSolver.insertionSort(intList,new KComparator());
        return intList[k];

    }

    /**
     * generates list of integer arrays from an input file,
     * such that each line corresponds to one array of integers separated by blank spaces
     * returns empty list if file does not exist
     *
     * @param filename
     * @return
     */
    public static List<Integer[]> readFile(String filename) {
        try {
            //setup scanner, list, string
            File file = new File(filename);
            Scanner text = new Scanner(file);

            ArrayList<ArrayList> textList= new ArrayList<ArrayList>();

            String str = new String("");

            //while there is still inputs remaining, make a string of an entire line, then parse integers out of it
            // to form integer array
            while(text.hasNext()) {
                str = text.nextLine();
                ArrayList<Integer> intArray = new ArrayList();
                Scanner stringScan = new Scanner(str);
                // while string representing line still has inputs, parse ints into int array
                while(stringScan.hasNext()) {
                    intArray.add(Integer.parseInt(stringScan.next()));
                }
                textList.add(intArray);
            }
            ArrayList<Integer[]> returnList = new ArrayList<Integer[]>();
            for(ArrayList val: textList) {
                returnList.add((Integer[]) val.toArray(new Integer[0]));
            }
            return returnList;
        }
        catch(Exception e){
            System.out.println("file not found");
             return new ArrayList<Integer[]>();
        }



    }

    /**
     *
     */
    protected static class biggestNum implements Comparator {


        public int compare(Object o1, Object o2){
            if(!(o1 instanceof Integer && o2 instanceof Integer)) {
                throw new IllegalArgumentException("one or both inputs are not of type Integer");
            }
            if(o1.equals(o2))
                return 0;
            return compareCalc(o1,o2);
        }
        public int compareCalc(Object o1, Object o2) {

            String o1String = o1.toString();
            String o2String = o2.toString();
            //compare first digit
            if(o1String.charAt(0)>o2String.charAt(0)){ //o1 has larger first digit
                return -1;
            } else if(o1String.charAt(0)<o2String.charAt(0)){ //o2 has larger first digit
                return 1;
            } else { //both have same first digit
                if(o1String.length()<o2String.length()) {//length of o1 is smaller than o2
                    if (o2String.charAt(1) > o1String.charAt(0))
                        return 1;
                    return -1;
                }
                if(o1String.length()>o2String.length()) { //length of o2 is smaller than o1
                    if (o1String.charAt(1) > o2String.charAt(0))
                        return -1;
                    return 1;
                }
                if(o1String.length()==o2String.length()){ //remove the first index of the int and go through process once more for the second digit
                    o1String=o1String.substring(1,o1String.length());
                    o2String=o2String.substring(1,o2String.length());
                    return compareCalc(Integer.parseInt(o1String),Integer.parseInt(o2String));
                }
            }
            return 0;
        }

    }
    protected static class comparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparable<?> && o2 instanceof Comparable<?>)
                return ((Comparable) o1).compareTo(o2);
            return 0;
        }
    }
    protected static class KComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Integer[] && o2 instanceof Integer[])
                return findLargestNumber((Integer[])o2).compareTo(findLargestNumber((Integer[])o1));
            return 0;
        }
    }
}


