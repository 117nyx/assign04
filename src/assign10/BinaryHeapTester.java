package assign10;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class BinaryHeapTester {
    @BeforeEach
    void setup(){
        int[] arr = new int[8];
    }
    @Test
    void insertTest(){
        BinaryMaxHeap bmh = new BinaryMaxHeap();
        bmh.add(2);
        bmh.add(5);
        bmh.add(10);
        bmh.add(23);
        bmh.add(120);
        bmh.add(0);
        assertArrayEquals(bmh.toArray(),new Integer[]{120,23,5,2,10,0});
    }
    @Test
    void extractMaxTest(){
        BinaryMaxHeap bmh = new BinaryMaxHeap();
        bmh.add(2);
        bmh.add(5);
        bmh.add(10);
        bmh.add(23);
        bmh.add(120);
        bmh.add(0);
        assertFalse(bmh.isEmpty());
        assertEquals(bmh.extractMax(),120);
        assertArrayEquals(bmh.toArray(),new Integer[]{23,10,5,2,0});
        assertEquals(bmh.extractMax(),23);
        assertArrayEquals(bmh.toArray(),new Integer[]{10,2,5,0});
        assertEquals(bmh.extractMax(),10);
        assertArrayEquals(bmh.toArray(),new Integer[]{5,2,0});
        assertEquals(bmh.extractMax(),5);
        assertArrayEquals(bmh.toArray(),new Integer[]{2,0});
        assertEquals(bmh.extractMax(),2);
        assertArrayEquals(bmh.toArray(),new Integer[]{0});
        assertEquals(bmh.extractMax(),0);
        assertArrayEquals(bmh.toArray(),new Integer[]{});
        assertTrue(bmh.isEmpty());
        //assertEquals();
    }
    @Test
    void clearTest()
    {
        BinaryMaxHeap bmh = new BinaryMaxHeap();
        bmh.add(2);
        bmh.add(5);
        bmh.add(10);
        bmh.add(23);
        bmh.add(120);
        bmh.add(0);
        assertFalse(bmh.isEmpty());
        bmh.clear();
        assertTrue(bmh.isEmpty());
    }
    @Test
    void sizeTest(){
        BinaryMaxHeap bmh = new BinaryMaxHeap();
        bmh.add(2);
        assertEquals(1,bmh.size());
        bmh.add(5);
        assertEquals(2,bmh.size());
        bmh.add(10);
        assertEquals(3,bmh.size());
        bmh.add(23);
        assertEquals(4,bmh.size());
        bmh.add(120);
        assertEquals(5,bmh.size());
        bmh.add(0);
        assertEquals(6,bmh.size());
    }
    @Test
    void isEmptyTest(){
        BinaryMaxHeap bmh = new BinaryMaxHeap();
        assertTrue(bmh.isEmpty());
        bmh.add(2);
        bmh.add(5);
        bmh.add(10);
        bmh.add(23);
        bmh.add(120);
        bmh.add(0);
        assertFalse(bmh.isEmpty());
        bmh.clear();
        assertTrue(bmh.isEmpty());
    }
    @Test
    void buildHeapConstructor(){
        ArrayList add = new ArrayList();
        add.add(1);
        add.add(20);
        add.add(3);
        add.add(45);
        add.add(0);

        BinaryMaxHeap bmh = new BinaryMaxHeap(add);
    }
    @Test
    void buildFromList(){
        ArrayList add = new ArrayList();
        add.add(1);
        add.add(20);
        add.add(3);
        add.add(45);
        add.add(0);

        BinaryMaxHeap bmh = new BinaryMaxHeap(add);
        assertEquals(bmh.extractMax(),45);
        assertEquals(bmh.extractMax(),20);
        assertEquals(bmh.extractMax(),3);
        assertEquals(bmh.extractMax(),1);



    }
    @Test
    void comparatorConstructor(){

    }
    @Test
    void comparatorAdd(){

    }
    @Test
    void comparatorExtractMax(){

    }
    @Test
    void peekTest(){

    }
}
