package List9.list9_2;

public class Multiply extends Thread{
    private int[][] A;
    private int[][] B;
    private int[][] result;


    public Multiply(int[][] A, int[][] B, final int SIZE){
        this.A = A;
        this.B = B;
        result = new int[SIZE][SIZE];
    }

    public void run(){
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    public int[][] getResult(){return result;}
}
