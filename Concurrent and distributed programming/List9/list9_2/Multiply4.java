package List9.list9_2;

public class Multiply4 extends Thread {
    private int[][] A;
    private int[][] B;
    private int[][] result;
    private int startRow;
    private int endRow;

    public Multiply4(int[][] A, int[][] B, int startRow, int endRow, final int SIZE) {
        this.A = A;
        this.B = B;
        this.startRow = startRow;
        this.endRow = endRow;
        this.result = new int[SIZE][SIZE];
    }

    @Override
    public void run() {
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    public int[][] getResult() {
        return result;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }
}
