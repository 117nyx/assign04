package assign06;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SinglyLinkedTester {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

    @BeforeEach
    public void setUp(){
        list = new SinglyLinkedList<Integer>();
    }

    @Test
    public void insertFirstTestTwo(){
        list.insertFirst(1);
        list.insertFirst(2);
        assertEquals(list.getFirst(),2);
    }
    @Test
    public void insertFirstTestOne(){
        list.insertFirst(1);
        assertEquals(list.getFirst(),1);
    }
    @Test
    public void insertFirstThenInsert(){
        list.insertFirst(1);
        list.insert(0,2);
        assertEquals(list.getFirst(),2);
    }

    @Test
    public void insertOnEmpty(){
        list.insert(0,1);
        assertEquals(list.getFirst(),1);

    }
    @Test
    public void insertMultiple(){
        list.insert(0,1);
        list.insert(1,2);
        assertEquals(list.getFirst(),1);
        assertEquals(list.get(1),2);

    }
    @Test
    public void get(){
        list.insert(0,1);
        list.insert(1,2);
        assertEquals(list.get(0),1);


    }
    @Test
    public void deleteFirst(){
        list.insertFirst(1);
        list.insertFirst(2);
        list.deleteFirst();
        assertEquals(list.getFirst(),1);
    }
    @Test
    public void delete(){
        list.insertFirst(1);
        list.insertFirst(2);
        list.delete(0);
        assertEquals(list.getFirst(),1);


    }
    @Test
    public void indexOf(){
        list.insertFirst(1);
        list.insertFirst(2);
        assertEquals(list.indexOf(1),1);


    }
    @Test
    public void size(){
        list.insert(0,1);
        list.insert(1,2);
        assertEquals(list.size(),1);


    }
    @Test
    public void isEmpty(){
        list.insert(0,1);
        list.insert(1,2);
        assertFalse(list.isEmpty());


    }
//    @Test
//    public void clear(){
//        list.insertFirst(1);
//        list.insertFirst(2);
//        list.clear();
//        assertEquals(list.get(0),1);
//
//
//    }

}
