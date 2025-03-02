package Week3.Generics;

import java.util.Arrays;
import java.util.List;

public class SumOfNumbers {
	public static <Integer> int[] sumOfNumbers(List<Integer> numbers) {
		int evenSum = 0;
		int oddSum = 0;
		for (Integer num : numbers) {
			int val = (int) num;
			if (val % 2 == 0) {
				evenSum += val;
			} else {
				oddSum += val;
			}
		}
		return new int[] { evenSum, oddSum };
	}

	public static void main(String[] args) {
       List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
       int [] result=sumOfNumbers(numbers);
       System.out.println("Even sum : "+result[0] + "\nOdd sum : "+ result[1]);
	}
}
