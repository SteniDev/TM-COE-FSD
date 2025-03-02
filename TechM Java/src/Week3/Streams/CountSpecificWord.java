package Week3.Streams;

import java.util.Arrays;
import java.util.List;

public class CountSpecificWord {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("kfc", "McD", "kdkMonkey", "love", "vv");

		char targetLetter = 'k';
		long count = words.stream().filter(word -> word.startsWith(String.valueOf(targetLetter))).count();

		System.out.println("Number of words starting with '" + targetLetter + "': " + count);
	}
}
