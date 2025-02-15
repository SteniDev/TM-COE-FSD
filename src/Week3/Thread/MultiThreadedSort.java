package Week3.Thread;

import java.util.Arrays;

public class MultiThreadedSort {
	public static void main(String[] args) {
		int[] array = { 38, 27, 43, 3, 9, 82, 10 };

		System.out.println("Original array: " + Arrays.toString(array));

		MergeSortThread sorter = new MergeSortThread(array);
		sorter.start();

		try {
			sorter.join(); // Wait for sorting to complete
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Sorted array: " + Arrays.toString(array));
	}
}
