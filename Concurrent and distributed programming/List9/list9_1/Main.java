package List9.list9_1;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 899;
        final int RANGE = SIZE / 4;
        int[][] A = new int[SIZE][SIZE];
        int[][] B = new int[SIZE][SIZE];
        int[][] C;
        int[][] D = new int[SIZE][SIZE];

        fill_matrix_A(A);
        fill_matrix_B(B);

        Multiply multiply = new Multiply(A, B, SIZE);

        // for a single thread
        long singleThreadStartT = System.nanoTime();
        multiply.start();
        try {
            multiply.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        long singleThreadEndT = System.nanoTime();

        double singleThreadT = (singleThreadEndT - singleThreadStartT) / 1000000000.0;
        C = multiply.getResult();

        System.out.println("Single thread time: " + String.format("%.2f", singleThreadT) + "s");
        System.out.println("End of single thread part");


        // For 4 threads
        Multiply4[] multipliers = new Multiply4[4];
        long multiThreadStartT = System.nanoTime();

        // division between the arrays
        for(int i = 0; i < multipliers.length; i++){
            int startRow = i * RANGE;
            multipliers[i] = new Multiply4(A, B, startRow, (i == multipliers.length - 1) ? SIZE : startRow + RANGE, SIZE);
            multipliers[i].start();
        }

        // Main thread has to wait for the thread to finish its work
        for (Multiply4 multiplier : multipliers) {
            try {
                multiplier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

        long multiThreadEndT = System.nanoTime();
        double multiThreadT = (multiThreadEndT - multiThreadStartT) / 1000000000.0;

        // Combining the results
        for (Multiply4 multiplier : multipliers) {
            int[][] partialResult = multiplier.getResult();
            for (int i = multiplier.getStartRow(); i < multiplier.getEndRow(); i++) {
                System.arraycopy(partialResult[i], 0, D[i], 0, SIZE);
            }
        }

        System.out.println("Multi-thread (4) time: " + String.format("%.2f", multiThreadT) + "s");
        System.out.println("How many times faster has multi thread multiplication been? Answer: " + String.format("%.2f", singleThreadT / multiThreadT) + "x");
        System.out.println("End of multi thread part");


        // Verifying the results
        boolean resultsMatch = verifyResults(C, D);

        if (resultsMatch) {
            System.out.println("Results verification: MATCH");
        } else {
            System.out.println("Results verification: DIFFER");
        }
    }

    public static boolean verifyResults(int[][] singleThreadResult, int[][] multiThreadResult) {
        if (singleThreadResult.length != multiThreadResult.length ||
                singleThreadResult[0].length != multiThreadResult[0].length) {
            System.out.println("Results differ: matrices have different dimensions");
            return false;
        }

        for (int i = 0; i < singleThreadResult.length; i++) {
            for (int j = 0; j < singleThreadResult[i].length; j++) {
                if (singleThreadResult[i][j] != multiThreadResult[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void fill_matrix_A(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.abs((int) Math.round(Math.sin(i+j)*10));
            }
        }
    }

    public static void fill_matrix_B(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.abs((int) Math.round(Math.cos(i+j)*10));
            }
        }
    }

    public static void show_array(int[][] matrix) {
        System.out.println("\nMatrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+", ");
            }
        }
    }
}