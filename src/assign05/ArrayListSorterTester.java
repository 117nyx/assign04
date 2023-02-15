package assign05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ArrayListSorterTester {
    ArrayList<Integer> list1024 = new ArrayList();
    @BeforeEach
    public void setUp(){
        list1024 = ArrayListSorter.generatePermuted(1024);
    }
    @Test
    public void mergesortTest(){
        ArrayListSorter.mergesort(list1024);
        assertArrayEquals(list1024.toArray(),ArrayListSorter.generateAscending(1024).toArray());

    }

    @Test
    public void quicksortTest(){

    }


}
