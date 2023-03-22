package assign08;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
public class SpellCheckerTester {
    @BeforeEach
    void BeforeEach(){

    }
    @Test
    void constructionTest(){
        SpellChecker spellTest = new SpellChecker();
        spellTest.addToDictionary("whaleshark");
        spellTest.addToDictionary("hamster");
        spellTest.spellCheck(new File("good_luck.txt"));
    }
}
