import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class LargestNumberSolverTester {
    Integer[] IntArray = new Integer[]{3,1,2,10,7,0};
    Integer[] fiveArray = new Integer[]{0,9,2,10,7,0};
    Integer[] intAndLongArr = new Integer[]{11,13};
    ArrayList smallList = new ArrayList();

    @BeforeEach
    void setup(){
        Integer[] IntArray = new Integer[]{3,1,2,10,7,0};
        Integer[] fiveArray = new Integer[]{0,9,2,10,7,0};
        Integer[] intAndLongArr = new Integer[]{11,13};
        ArrayList smallList = new ArrayList();
        smallList.add(IntArray);
        smallList.add(fiveArray);
        smallList.add(intAndLongArr);
    }

    @Test
    public void testInserionSort(){
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
    public void findLargestLongTester(){
        long l = LargestNumberSolver.findLargestLong(intAndLongArr);
        assertEquals(1311,l);
    }
    @Test
    public void testFileRead(){
        ArrayList<Integer[]> actual = (ArrayList<Integer[]>)LargestNumberSolver.readFile("shortInts.txt");

        assertEquals(4,actual.size());
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

    }
    @Test
    public void testLargestIntOutOfRange(){

    }

    @Test
    public void testLargestLong(){

    }
    @Test
    public void testLargestLongOutOfRange(){

    }


    @Test
    public void testKthLargest(){

    }

    @Test
    public void testReadFile(){

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
