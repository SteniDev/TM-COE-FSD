package Week3.Streams;

import java.util.Arrays;
import java.util.List;

public class MinMax {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 10, 2, 8, 15, 1, 6);

		int  max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int min = numbers.stream().reduce(Integer.MAX_VALUE, Integer::min);

		System.out.println("Maximum Value: " + max);
		System.out.println("Minimum Value: " + min);
	}
}
