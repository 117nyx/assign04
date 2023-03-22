package assign08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

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
    @Test
    void addAllTest(){
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        expected.add(75);
        expected.add(0);
        expected.add(100);
        emptyInt.addAll(expected);
        assertTrue(emptyInt.containsAll(expected));
    }
    @Test
    void addReturnFalseTest() {
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        expected.add(75);
        expected.add(0);
        expected.add(100);
        emptyInt.addAll(expected);
        assertFalse(emptyInt.add(75));
    }
    @Test
    void removeTest() {
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        expected.add(75);
        expected.add(0);
        expected.add(100);
        emptyInt.addAll(expected);
        emptyInt.remove(25);
        emptyInt.remove(75);
        emptyInt.remove(0);
        emptyInt.remove(100);
        ArrayList test = new ArrayList();
        test.add(50);
        assertEquals(test,emptyInt.toArrayList());
        assertTrue(emptyInt.contains(50));
        assertFalse(emptyInt.contains(75));
    }
    @Test
    void removeAllTest(){

    }
    @Test
    void isEmptyTest(){
        assertTrue(emptyInt.isEmpty());
        emptyInt.add(50);
        assertFalse(emptyInt.isEmpty());
    }
    @Test
    void clearTest(){
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        expected.add(75);
        expected.add(0);
        expected.add(100);
        emptyInt.addAll(expected);
        assertFalse(emptyInt.isEmpty());
        emptyInt.clear();
        assertTrue(emptyInt.isEmpty());
    }
    @Test
    void sizeTest(){
        assertEquals(0,emptyInt.size());
        emptyInt.add(5);
        assertEquals(1,emptyInt.size());
        emptyInt.add(2);
        assertEquals(2,emptyInt.size());
        emptyInt.add(7);
        assertEquals(3,emptyInt.size());
        emptyInt.add(1);
        assertEquals(4,emptyInt.size());
    }
    @Test
    void sizeLeftLean(){
        ArrayList arr = new ArrayList();
        for(int i = 100;i>0;i--){
            arr.add(i);
        }
        emptyInt.addAll(arr);
        assertEquals(100,emptyInt.size());
    }
    @Test
    void sizeRandomLargeSize(){
        Random rand = new Random(1);
        ArrayList arr = new ArrayList();
        for(int i = 100000;i>0;i--){
            arr.add(rand.nextInt());
        }
        emptyInt.addAll(arr);
        assertEquals(100000,emptyInt.size(),10);
    }
}
