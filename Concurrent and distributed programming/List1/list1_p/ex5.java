package list1;
import java.util.Random;


public class ex5 {
    public static void main(String[] args) {
        int rows = 3, columns = 3;

        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[columns][rows];
        int[][] resultMatrix = new int[rows][rows];

        fillMatrix(matrix1);
        fillMatrix(matrix2);

        System.out.println("Matrix1:");
        displayMatrix(matrix1);

        System.out.println("Matrix2:");
        displayMatrix(matrix2);

        multiplyMatrices(matrix1, matrix2, resultMatrix);

        System.out.println("Result (A * B): ");
        displayMatrix(matrix1);
        System.out.println("    * ");
        displayMatrix(matrix2);
        System.out.println("   || ");

        displayMatrix(resultMatrix);
    }


    public static void fillMatrix(int[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(10) + 1;
            }
        }
    }


    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    // Function to multiply two matrices
    public static void multiplyMatrices(int[][] A, int[][] B, int[][] result) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }
}

