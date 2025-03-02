package Week3.Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseList {
	public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(reverseList(numbers)); 
    }
}
