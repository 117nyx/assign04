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
    void testCompressionKeepsRep(){
        var x = new DisjointSetForest<>();

        x.makeSet(1);
        x.makeSet(2);
        x.makeSet(3);
        x.makeSet(4);
        x.makeSet(5);
        x.makeSet(6);
        x.makeSet(7);
        x.makeSet(8);
        x.makeSet(9);
        x.makeSet(10);
        x.makeSet(11);
        x.makeSet(12);


        x.union(1,2);
        x.union(1,3);
        x.union(1,4);
        x.union(1,5);
        x.union(1,6);
        x.union(1,7);
        x.union(1,8);
        x.union(1,9);
        x.union(1,10);
        x.union(1,11);
        x.union(1,12);

        for(int i=1;i<=12;i++)
            assertEquals(x.getRepresentative(i),1);



    }
    @Test
    void testAllValWorksOnUnion(){


            DisjointSetForest dsf = new DisjointSetForest();
            dsf.makeSet(1);
            dsf.makeSet(2);
            dsf.makeSet(3);
            dsf.makeSet(4);
            dsf.union(1,4);
            dsf.union(2,3);
            dsf.union(2,4);
            assertEquals(dsf.getRepresentative(1),dsf.getRepresentative(4));

        dsf = new DisjointSetForest();
        dsf.makeSet(1);
        dsf.makeSet(2);
        dsf.makeSet(3);
        dsf.makeSet(4);
        dsf.union(4,1);
        dsf.union(3,2);
        dsf.union(4,2);
        assertEquals(dsf.getRepresentative(1),dsf.getRepresentative(4));
        dsf = new DisjointSetForest();
        dsf.makeSet(1);
        dsf.makeSet(2);
        dsf.makeSet(3);
        dsf.makeSet(4);
        dsf.union(3,1);
        dsf.union(3,2);
        dsf.union(4,2);
        assertEquals(dsf.getRepresentative(1),dsf.getRepresentative(4));




    }

}
