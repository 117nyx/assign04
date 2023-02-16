package assign05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ArrayListSorterTester {
    ArrayList<Integer> list1024 = new ArrayList();
    ArrayList<Integer> fourList = new ArrayList();
    @BeforeEach
    public void setUp(){

        list1024 = ArrayListSorter.generatePermuted(512);


    }


    @Test
    public void mergesortTest(){
        ArrayListSorter.merge(list1024);

    }

    @Test
    public void quicksortTest(){

    }


}
