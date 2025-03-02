package Week3.Thread;

public class MatrixMultiplicationThread extends Thread{
	private int row;        // row index of matrix  for calc
    private int[][] A, B, C;

    public MatrixMultiplicationThread(int row, int[][] A, int[][] B, int[][] C) {
        this.row = row;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public void run() {

        int colsA = A[0].length;  //   columns in A (must match rows in B)
        int colsB = B[0].length;//   columns in B
        for (int j = 0; j < colsB; j++) {
            C[row][j] = 0;  // Initialize element
            for (int k = 0; k < colsA; k++) {
                C[row][j] += A[row][k] * B[k][j];
                // Multiply and accumulate
            }
        }
    }
}

