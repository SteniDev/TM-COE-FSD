package Week3.Streams;

import java.util.Arrays;
import java.util.List;

public class SumOfEvenOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Calculate sum of even numbers
        int sumOfEven = numbers.stream()
                .filter(n -> n % 2 == 0) // Filter even numbers
                .mapToInt(Integer::intValue) // Convert to IntStream (for sum operation)
                .sum();

        // Calculate sum of odd numbers
        int sumOfOdd = numbers.stream()
                .filter(n -> n % 2 != 0) // Filter odd numbers
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of even numbers: " + sumOfEven);
        System.out.println("Sum of odd numbers: " + sumOfOdd);



    }
}
