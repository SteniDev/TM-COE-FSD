package Week3.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2,4,5,5,55,45,88,7,7, 3, 2, 4, 5, 1, 6, 7, 8, 4);

		List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());

		System.out.println("List without duplicates: " + uniqueNumbers);
	}
}
