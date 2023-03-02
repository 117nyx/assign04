package assign06;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class Tester {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

    @BeforeEach
    public void setUp(){
        list = new SinglyLinkedList<Integer>();
    }

    @Test
    public void insertFirstTest(){
        list.insertFirst(1);
        list.insertFirst(2);
        assertEquals(list.getFirst(),2);
    }

}
