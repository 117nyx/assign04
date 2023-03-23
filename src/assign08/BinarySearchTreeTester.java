package assign08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        expected.add(75);
        expected.add(100);
        expected.add(0);
        emptyInt.addAll(expected);
        assertFalse(emptyInt.isEmpty());
        emptyInt.removeAll(expected);
        System.out.println(emptyInt.toArrayList());
        assertTrue(emptyInt.isEmpty());

    }
    @Test
    public void isEmptyAfterRemove(){
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        emptyInt.addAll(expected);
        assertFalse(emptyInt.isEmpty());
        emptyInt.remove(50);
        emptyInt.remove(25);
        System.out.println(emptyInt.toArrayList());
        assertTrue(emptyInt.isEmpty());
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
    @Test
    void size2RemoveTest(){
        emptyInt.add(2);
        emptyInt.add(1);
        emptyInt.remove(1);
        emptyInt.remove(2);


    }
    @Test
    public void leafRemove(){
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        expected.add(75);
        emptyInt.addAll(expected);
        emptyInt.remove(25);
        emptyInt.remove(75);
        System.out.println(emptyInt.toArrayList());
        assertTrue(emptyInt.contains(50));
        assertFalse(emptyInt.contains(25));
        assertFalse(emptyInt.contains(75));
    }
    @Test
    public void oneChildRemove(){
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        expected.add(75);
        expected.add(100);
        expected.add(0);
        emptyInt.addAll(expected);
        emptyInt.remove(25);
        emptyInt.remove(75);
        System.out.println(emptyInt.toArrayList());
        assertTrue(emptyInt.contains(50));
        assertTrue(emptyInt.contains(0));
        assertTrue(emptyInt.contains(100));
        assertFalse(emptyInt.contains(25));
        assertFalse(emptyInt.contains(75));
    }

    @Test
    public void twoChildRemove(){
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        expected.add(75);
        expected.add(100);
        expected.add(0);
        emptyInt.addAll(expected);
        emptyInt.remove(50);
        System.out.println(emptyInt.toArrayList());
        assertFalse(emptyInt.contains(50));
        assertTrue(emptyInt.contains(0));
        assertTrue(emptyInt.contains(100));
        assertTrue(emptyInt.contains(25));
        assertTrue(emptyInt.contains(75));
    }
    @Test
    void removeAllPartialTest(){
        ArrayList expected = new ArrayList();
        expected.add(50);
        expected.add(25);
        expected.add(75);
        expected.add(100);
        expected.add(0);
        expected.add(35);
        ArrayList remove = new ArrayList();
        remove.add(50);
        remove.add(25);
        remove.add(0);
        emptyInt.addAll(expected);
        assertFalse(emptyInt.isEmpty());
        assertTrue(emptyInt.removeAll(remove));
        System.out.println(emptyInt.toArrayList());
        assertTrue(emptyInt.contains(35));
        assertTrue(emptyInt.contains(75));
        assertTrue(emptyInt.contains(100));
        assertFalse(emptyInt.contains(0));
        assertFalse(emptyInt.contains(50));
        assertFalse(emptyInt.contains(25));

    }
    @Test
    void removeAllRandom(){
        ArrayList original = new ArrayList<>();
        for(int i =0; i< 20; i++)
            original.add(i);
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        System.out.println("original "+ original.toString());
        ArrayList remove = new ArrayList();
        for(int i =0; i<10;i++){
            remove.add(original.get(i));

        }
        System.out.println("remove "+ remove.toString());
        emptyInt.addAll(original);
        System.out.println("BST "+emptyInt.toArrayList());
        assertTrue(emptyInt.removeAll(remove));
        System.out.println(emptyInt.toArrayList());
    }

}
