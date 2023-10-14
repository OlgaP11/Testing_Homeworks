package homework6;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOperations {
    public void compareMiddleValuesOfTwoLists(List<Integer> list1, List<Integer> list2){
        double middleValue1 = calculateMiddleValueInList(list1);
        double middleValue2 = calculateMiddleValueInList(list2);

        if (middleValue1 > middleValue2){
            System.out.print("Первый список имеет большее среднее значение");
        } else if(middleValue1 < middleValue2){
            System.out.print("Второй список имеет большее среднее значение");
        } else{
            System.out.print("Средние значения равны");
        }
    }

    public double calculateMiddleValueInList(List<Integer> list) {
        if (list.isEmpty()){
            throw new IllegalArgumentException("Список пустой");
        }
        double sum = 0;
        for (Integer num: list) {
            sum += num;
        }
        return sum/list.size();
    }
}
