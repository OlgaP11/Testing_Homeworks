package homework6;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.assertEquals;


public class ListOperationsTest {
    private ListOperations listOperations;
    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUp(){
        listOperations = new ListOperations();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    /**
     * Проверка верности расчета среднего значения внутри списка
     */
    @Test
    public void testCalculateMiddleValueInList(){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }
        double expectedAnswer = 2;
        double realAnswer = listOperations.calculateMiddleValueInList(list);

        assertEquals(expectedAnswer, realAnswer, 0.001);
    }

    /**
     * Выбрасывает ли исключение метод нахождения среднего значения в списке, если список пустой
     */
    @Test
    public void testCalculateMiddleValueInEmptyList(){
        List<Integer> list = new ArrayList<>();
        assertThatThrownBy(() -> listOperations.calculateMiddleValueInList(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверка метода сравнения двух списков, если в первом среднее значение больше
     */
    @Test
    public void testCompareMiddleValuesOfTwoListsFirstBigger(){
        List<Integer> list1 = new ArrayList<>();
        for (int i = 100; i < 103; i++) {
            list1.add(i);
        }

        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list2.add(i);
        }

        String expectedOutput = "Первый список имеет большее среднее значение";
        listOperations.compareMiddleValuesOfTwoLists(list1, list2);

        assertEquals(expectedOutput,output.toString());
    }

    /**
     * Проверка метода сравнения двух списков, если во втором среднее значение больше
     */
    @Test
    public void testCompareMiddleValuesOfTwoListsSecondBigger(){
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 4; i < 7; i++) {
            list2.add(i);
        }

        String expectedOutput = "Второй список имеет большее среднее значение";
        listOperations.compareMiddleValuesOfTwoLists(list1, list2);

        assertEquals(expectedOutput,output.toString());
    }
    /**
     * Проверка метода сравнения двух списков, если средние значения в них равны
     */
    @Test
    public void testCompareMiddleValuesOfTwoEqualsLists(){
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list2.add(i);
        }

        String expectedOutput = "Средние значения равны";
        listOperations.compareMiddleValuesOfTwoLists(list1, list2);

        assertEquals(expectedOutput,output.toString());
    }

    /**
     * Интеграционный тест
     * Сравнение средних величин двух списков, если один из них пустой
     */
    @Test
    public void testCompareMiddleValueWithEmptyList(){
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();

        assertThatThrownBy(() -> listOperations.compareMiddleValuesOfTwoLists(list1, list2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
