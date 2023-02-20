package assign05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ArrayListSorterTester {
    ArrayList<Integer> list1024 = new ArrayList();
    ArrayList<Integer> fourList = new ArrayList();

    @BeforeEach
    public void setUp() {

        list1024 = ArrayListSorter.generateDescending(1024);


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
    public void mergesortTest() {
        ArrayListSorter.mergesort(list1024);
        assertArrayEquals(list1024.toArray(), ArrayListSorter.generateAscending(1024).toArray(), "mergeSort for list 1024 works properly");
    }

    @Test
    public void quicksortTest() {
        ArrayListSorter.quicksort(list1024,0,list1024.size(),"last");
        assertArrayEquals(list1024.toArray(), ArrayListSorter.generateAscending(1024).toArray(), "quicksort for list 1024 works properly");
    }


}
