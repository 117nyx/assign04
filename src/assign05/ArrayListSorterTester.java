package assign05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ArrayListSorterTester {
    ArrayList<Integer> list1024 = new ArrayList();
    ArrayList<Integer> fiveList = new ArrayList();

    @BeforeEach
    public void setUp() {

        list1024 = ArrayListSorter.generateDescending(1024);
        fiveList.add(1);
        fiveList.add(3);
        fiveList.add(4);
        fiveList.add(2);
        fiveList.add(5);
    }

    @Test
    public void getSwitchValueTest() {
        assertEquals(ArrayListSorter.getSizeToSwitch(),4);
    }
    @Test
    public void mutateSwitchValueTest(){
        ArrayListSorter.setSizeToSwitch(8);
        assertEquals(ArrayListSorter.getSizeToSwitch(),8);
    }
    @Test
    public void generateAscendingTest(){
        assertArrayEquals(ArrayListSorter.generateAscending(5).toArray(),new Integer[]{1,2,3,4,5});
    }
    @Test
    public void generateAscendingArraySizeZero(){
        assertArrayEquals(ArrayListSorter.generateAscending(0).toArray(),new Integer[]{});
    }

    @Test
    public void mergesortTest() {
        ArrayListSorter.mergesort(list1024);
        assertArrayEquals(list1024.toArray(), ArrayListSorter.generateAscending(1024).toArray(), "mergeSort for list 1024 works properly");
    }

    @Test
    public void quicksortTestShort() {
        ArrayListSorter.quicksort(fiveList,0,fiveList.size()-1,"middle");
        assertArrayEquals(fiveList.toArray(), ArrayListSorter.generateAscending(5).toArray(), "quicksort for fiveList works properly");
    }
    @Test
    public void quicksortTestLong() {
        ArrayListSorter.quicksort(list1024,0,list1024.size()-1,"middle");
        assertArrayEquals(list1024.toArray(), ArrayListSorter.generateAscending(1024).toArray(), "quicksort for list1024 works properly");
    }
@Test
    public void partitionTestLast() {
    ArrayList<Integer> partTest = new ArrayList<>();
    partTest.add(20);
    partTest.add(10);
    partTest.add(14);
    partTest.add(37);
    partTest.add(14);
    partTest.add(8);
    partTest.add(29);
    ArrayList<Integer> check = new ArrayList<>();
    check.add(20);
    check.add(10);
    check.add(14);
    check.add(8);
    check.add(14);
    check.add(29);
    check.add(37);
    int partPoint = ArrayListSorter.partition(partTest, 0, partTest.size() - 1, "last");

    assertArrayEquals(check.toArray(), partTest.toArray());
    assertEquals(5,partPoint);
}

    @Test
    public void partitionTestMiddle(){
        ArrayList<Integer> partTest = new ArrayList<>();
        partTest.add(20);
        partTest.add(10);
        partTest.add(14);
        partTest.add(37);
        partTest.add(14);
        partTest.add(8);
        partTest.add(29);
        ArrayList<Integer> check = new ArrayList<>();
        check.add(20);
        check.add(10);
        check.add(14);
        check.add(29);
        check.add(14);
        check.add(8);
        check.add(37);
        int partPoint = ArrayListSorter.partition(partTest,0,partTest.size()-1,"middle");

        assertArrayEquals(check.toArray(), partTest.toArray());
        assertEquals(6,partPoint);
    }



}
