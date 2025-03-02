package Week3.Thread;

import java.util.Arrays;

public class MultiThreadedSort {
	public static void main(String[] args) {
		int[] array = { 5,3,8,7,99,55,33,45,21,32,58,13 };

		System.out.println("Original array is : " + Arrays.toString(array));

		MergeSortThread sorter = new MergeSortThread(array);
		sorter.start();

		try {
			sorter.join(); // Wait for sorting to complete
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Sorted array was : " + Arrays.toString(array));
	}
}
