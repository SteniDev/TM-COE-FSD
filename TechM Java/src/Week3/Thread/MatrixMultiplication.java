package Week3.Thread;

public class MatrixMultiplication {
	public static void main(String[] args) {
		int[][] A = { { 3,2,1 }, { 88,77,99 } };
		int[][] B = { { 6,3 }, { 2,3, }, { 11, 11 } };

		int rowsA = A.length; //  rows in A
		int colsB = B[0].length; //  columns in B
		int[][] C = new int[rowsA][colsB]; // Result

		Thread[] threads = new Thread[rowsA]; // Create an array of threads

		// Create and start a thread for each row
		for (int i = 0; i < rowsA; i++) {
			threads[i] = new MatrixMultiplicationThread(i, A, B, C);
			threads[i].start();
		}

		// Wait for all threads to finish
		for (int i = 0; i < rowsA; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Print result matrix
		System.out.println("Result Matrix:");
		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}
}
