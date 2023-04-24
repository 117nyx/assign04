package comprehensive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Foresttest {
    char[] vertices = new char[10];
    DisjointSetForest dsf = new DisjointSetForest<>();
    @BeforeEach
    void setup(){
        for(int i = 0; i <10; i++) {
            int j = 65 + i;
            char add = (char)j;
            vertices[i] = add;
        }
    }
    @Test
    void makeSetTest(){
        dsf.makeSet(1);
        dsf.makeSet(2);
        assertEquals(1,dsf.getRepresentative(1));
        assertEquals(2,dsf.getRepresentative(2));
    }
    @Test
    void unionTest(){
        dsf.makeSet(1);
        dsf.makeSet(2);
        dsf.union(1,2);
        assertEquals(1,dsf.getRepresentative(1));
        assertEquals(1,dsf.getRepresentative(2));
    }
    @Test
    void unionMultipleTest(){
        dsf.makeSet(1);
        dsf.makeSet(2);
        dsf.makeSet(3);
        dsf.makeSet(4);
        dsf.makeSet(5);
        dsf.makeSet(6);
        dsf.union(1,2);
        dsf.union(1,3);
        dsf.union(4,5);
        assertEquals(1,dsf.getRepresentative(1));
        assertEquals(1,dsf.getRepresentative(2));
        assertEquals(1,dsf.getRepresentative(3));
        assertEquals(4,dsf.getRepresentative(4));
        assertEquals(4,dsf.getRepresentative(5));
        assertEquals(6,dsf.getRepresentative(6));
    }
    @Test
    void unionDuplicateDoNothing(){
        dsf.makeSet(1);
        dsf.makeSet(2);
        dsf.union(1,2);
        dsf.union(1,2);
        assertEquals(1,dsf.getRepresentative(1));
        assertEquals(1,dsf.getRepresentative(2));
    }

    @Test
    void testCompression(){

        dsf.makeSet();
    }

}
