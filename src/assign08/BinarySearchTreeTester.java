package assign08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BinarySearchTreeTester {
    BinarySearchTree<Integer> emptyInt;
    @BeforeEach
    void beforeEach(){
        emptyInt = new BinarySearchTree<Integer>();
    }
    @Test
    void addTest(){
        emptyInt.add(50);
        emptyInt.add(25);
        emptyInt.add(75);
        emptyInt.add(100);
        emptyInt.add(0);
        assertEquals(0,emptyInt.first());
        assertEquals(100,emptyInt.last());
    }
    @Test
    void toArrayTest(){
        emptyInt.add(50);
        emptyInt.add(25);
        emptyInt.add(75);
        emptyInt.add(100);
        emptyInt.add(0);
        ArrayList expected = new ArrayList();
        expected.add(0);
        expected.add(25);
        expected.add(50);
        expected.add(75);
        expected.add(100);
        assertEquals(expected,emptyInt.toArrayList());

    }
}
