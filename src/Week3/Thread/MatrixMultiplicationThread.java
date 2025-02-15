package Week3.Thread;

public class MatrixMultiplicationThread extends Thread{
	private int row;        // Row index of matrix C to compute
    private int[][] A, B, C;

    public MatrixMultiplicationThread(int row, int[][] A, int[][] B, int[][] C) {
        this.row = row;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public void run() {
        int colsB = B[0].length;  // Number of columns in B
        int colsA = A[0].length;  // Number of columns in A (must match rows in B)

        for (int j = 0; j < colsB; j++) {
            C[row][j] = 0;  // Initialize element
            for (int k = 0; k < colsA; k++) {
                C[row][j] += A[row][k] * B[k][j];  // Multiply and accumulate
            }
        }
    }
}

