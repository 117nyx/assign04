package assign04;
/**
 * This class tests the Largest Number Solver class
 * Authors: Eden Harvey and Jonathan Kerr
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests LargestNumberSolver program
 */
class LargestNumberSolverTester {
    Integer[] IntArray = new Integer[]{3,1,2,10,7,0};
    Integer[] fiveArray = new Integer[]{0,9,2,10,7,0};
    Integer[] intAndLongArr = new Integer[]{11,13};
    Integer[] tooLongForIntAndLong = new Integer[]{10,20,30,40,50,60,70,80,90,100};
    Integer[] similarNums = new Integer[]{5,0,6,67,69};
    ArrayList smallList = new ArrayList();
    ArrayList tinyList = new ArrayList();

    @BeforeEach
    void setup(){

        Integer[] IntArray = new Integer[]{3,1,2,10,7,0};
        Integer[] fiveArray = new Integer[]{0,9,2,10,7,0};
        Integer[] intAndLongArr = new Integer[]{11,13};
        Integer[] similarNums = new Integer[]{5,0,6,67,69};
        Integer[] tooLongForIntAndLong = new Integer[]{10,20,30,40,50,60,70,80,90,100};
        ArrayList smallList = new ArrayList();
        smallList.add(IntArray);
        smallList.add(fiveArray);
        smallList.add(intAndLongArr);
        tinyList.add(new Integer[]{2});
        tinyList.add(new Integer[]{1});
        tinyList.add(new Integer[]{3});

    }

    @Test
    public void testInsertionSort(){
        LargestNumberSolver.insertionSort(IntArray,new comparator());
        for(int i=0;i<IntArray.length;i++)
            System.out.println(IntArray[i]);
    }

    @Test
    public void testOrderFindLargestNumber(){

        BigInteger actual=LargestNumberSolver.findLargestNumber(fiveArray);
        assertEquals(actual,new BigInteger("9721000"));

    }

    @Test
    public void testOrderFindLargestNumberSimilarNums(){

        BigInteger actual=LargestNumberSolver.findLargestNumber(similarNums);
        assertEquals(actual,new BigInteger("6967650"));

    }
    @Test
    public void findLargestLongTester(){
        long l = LargestNumberSolver.findLargestLong(intAndLongArr);
        assertEquals(1311,l);
    }
    @Test
    public void testFileRead(){
        ArrayList<Integer[]> actual = (ArrayList<Integer[]>)LargestNumberSolver.readFile("shortInts.txt");
        Integer[] compare = new Integer[]{1};
        assertEquals(4,actual.size());
        assertArrayEquals(compare,actual.get(2));
    }

    @Test
    public void testFileReadLongFile(){
        ArrayList<Integer[]> actual = (ArrayList<Integer[]>)LargestNumberSolver.readFile("integers.txt");
        assertEquals(903,actual.size());
    }

    @Test
    public void readFileSizeCheck(){
        var actual = LargestNumberSolver.readFile("shortInts.txt");
        assertEquals(10,actual.get(0).length);
    }

    @Test
    public void testSum(){
        ArrayList smallListCopy = new ArrayList();
        smallListCopy.add(IntArray);
        smallListCopy.add(fiveArray);
        smallListCopy.add(intAndLongArr);
        smallList.add(IntArray);
        smallList.add(fiveArray);
        smallList.add(intAndLongArr);
        BigInteger actual = LargestNumberSolver.sum(smallList);
        assertEquals(17043411,actual.intValue());
        assertEquals(smallList,smallListCopy);
    }

    @Test
    public void testLargestInt(){
        int i = LargestNumberSolver.findLargestInt(intAndLongArr);
        assertEquals(1311,i);
    }
    @Test
    public void testLargestIntOutOfRange(){
        //2147483647
        assertThrows(OutOfRangeException.class, () -> { LargestNumberSolver.findLargestInt(tooLongForIntAndLong);});
    }


    @Test
    public void testLargestLongOutOfRange(){
        //9223372036854775807
        assertThrows(OutOfRangeException.class, () -> { LargestNumberSolver.findLargestLong(tooLongForIntAndLong);});
    }


    @Test
    public void testKthLargest(){
    //send in small list, get kth largest
        smallList.add(IntArray);
        smallList.add(fiveArray);
        smallList.add(intAndLongArr);
        smallList.add(similarNums);
        Integer[] largest = LargestNumberSolver.findKthLargest(smallList, 0);
        Integer[] smallest = LargestNumberSolver.findKthLargest(smallList, 3);
        assertArrayEquals(largest,fiveArray);
        assertArrayEquals(smallest,intAndLongArr);
    }
    @Test
    public void testKTinyData(){
        Integer[] largest=LargestNumberSolver.findKthLargest(tinyList,0);
        assertArrayEquals(largest,new Integer[]{3});
    }

    protected class comparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparable<?> && o2 instanceof Comparable<?>)
                return ((Comparable) o1).compareTo(o2);
            return 0;
        }
        }

    }

