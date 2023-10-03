package homework3;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;

public class Homework3Test {
    private Homework3 homework3;

    @BeforeEach
    public void setUp(){
        homework3 = new Homework3();
    }

    /**
     * Тестирование на четном числе
     */
    @Test
    public void evenOddNumberTestEvenNum(){
       assertTrue(homework3.evenOddNumber(4));
    }
    /**
     * Тестирование на нечетном числе
     */
    @Test
    public void evenOddNumberTestNotEvenNum(){
        assertFalse(homework3.evenOddNumber(5));
    }

    /**
     * Тест на крайних значениях и значении, внутри интервала
     * @param n число
     */
    @ParameterizedTest
    @ValueSource(ints = {25, 100, 55})
    public void numberInIntervalTestTrue(int n){
        assertTrue(homework3.numberInInterval(n));
    }

    /**
     * Тест на числе, которое не входит в интервал
     */
    @Test
    public void numberInIntervalTestFalse(){
        assertFalse(homework3.numberInInterval(5));
    }
}
