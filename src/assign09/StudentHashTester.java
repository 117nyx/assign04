package assign09;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

public class StudentHashTester {
    ArrayList bigArr=new ArrayList<>();


        StudentBadHash alan = new StudentBadHash(1019999, "Alan", "Turing");
        StudentBadHash ada = new StudentBadHash(1004203, "Ada", "Lovelace");
        StudentBadHash edsger = new StudentBadHash(1010661, "Edsger", "Dijkstra");
        StudentBadHash grace = new StudentBadHash(1019941, "Grace", "Hopper");

    @BeforeEach
    void BeforeEach(){

    }
    @Test
    public void gpaTest(){
        HashTable<StudentBadHash, Double> studentGpaTable = new HashTable<StudentBadHash, Double>();
        studentGpaTable.put(alan, 3.2);
        studentGpaTable.put(ada, 3.5);
        studentGpaTable.put(edsger, 3.8);
        studentGpaTable.put(grace, 4.0);

        assertTrue(studentGpaTable.containsKey(alan));
        assertTrue(studentGpaTable.containsKey(ada));
        assertTrue(studentGpaTable.containsKey(edsger));
        assertTrue(studentGpaTable.containsKey(grace));

    }
    @Test
    public void gpaTestRemove(){
        HashTable<StudentBadHash, Double> studentGpaTable = new HashTable<StudentBadHash, Double>();
        studentGpaTable.put(alan, 3.2);
        studentGpaTable.put(ada, 3.5);
        studentGpaTable.put(edsger, 3.8);
        studentGpaTable.put(grace, 4.0);

        assertEquals(3.2,studentGpaTable.remove(alan));
        assertFalse(studentGpaTable.containsKey(alan));
        assertEquals(studentGpaTable.remove(ada),3.5);
        assertFalse(studentGpaTable.containsKey(ada));
        assertEquals(studentGpaTable.remove(edsger),3.8);
        assertFalse(studentGpaTable.containsKey(edsger));
        assertEquals(studentGpaTable.remove(grace),4.0);
        assertFalse(studentGpaTable.containsKey(grace));
        assertTrue(studentGpaTable.isEmpty());

    }
    @Test
    void clearTest(){
        HashTable<StudentBadHash, Double> studentGpaTable = new HashTable<StudentBadHash, Double>();
        studentGpaTable.put(alan, 3.2);
        studentGpaTable.put(ada, 3.5);
        studentGpaTable.put(edsger, 3.8);
        studentGpaTable.put(grace, 4.0);
        assertFalse(studentGpaTable.isEmpty());
        studentGpaTable.clear();
        assertTrue(studentGpaTable.isEmpty());
    }
    @Test
    void entriesTest(){
        HashTable<StudentBadHash, Double> studentGpaTable = new HashTable<StudentBadHash, Double>();
        studentGpaTable.put(alan, 3.2);
        studentGpaTable.put(ada, 3.5);
        studentGpaTable.put(edsger, 3.8);
        studentGpaTable.put(grace, 4.0);
       var v= studentGpaTable.entries();
    }
    @Test
    void reHashTest(){
        HashTable<Integer,Integer> hashTable = new HashTable<>();
        Random r = new Random();
        for(int i =0; i< 100;i++){
            hashTable.put(r.nextInt(),r.nextInt());
        }
        assertFalse(hashTable.isEmpty());

    }
}
