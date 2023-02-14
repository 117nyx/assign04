package assign05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ArrayListSorterTester {
    ArrayList<Integer> list16 = new ArrayList();
    @BeforeEach
    public void setUp(){
        list16 = ArrayListSorter.generatePermuted(16);
    }
    @Test
    public void mergesortTest(){
        ArrayListSorter.mergesort(list16);

    }

    @Test
    public void quicksortTest(){

    }


}
