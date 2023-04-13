package assign10;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    }
    @Test
    void extractMaxTest(){

    }
    @Test
    void clearTest()
    {

    }
    @Test
    void sizeTest(){

    }
    @Test
    void isEmptyTest(){

    }
    @Test
    void buildHeapConstructor(){

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
