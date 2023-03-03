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
    public void insert(){
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

}
