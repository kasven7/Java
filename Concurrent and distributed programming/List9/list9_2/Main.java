package List9.list9_2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        int[] sizes = {500, 1000, 1500};

        for (int size : sizes) {
            processMatrixMultiplication(size);
        }
    }

    private static void processMatrixMultiplication(final int SIZE) {
        final int processors = Runtime.getRuntime().availableProcessors();
        final int RANGE = SIZE / processors;
        int[][] A = new int[SIZE][SIZE];
        int[][] B = new int[SIZE][SIZE];
        int[][] C;
        int[][] D = new int[SIZE][SIZE];

        fill_matrix_A(A);
        fill_matrix_B(B);

        System.out.println("\nProcessing matrix size: " + SIZE + "x" + SIZE);
        System.out.println("Number of available processors: " + processors);

        // Single thread
        Multiply multiply = new Multiply(A, B, SIZE);
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

        // Multi-thread
        Multiply4[] multipliers = new Multiply4[processors];
        long multiThreadStartT = System.nanoTime();

        for(int i = 0; i < multipliers.length; i++){
            int startRow = i * RANGE;
            multipliers[i] = new Multiply4(A, B, startRow,
                    (i == multipliers.length - 1) ? SIZE : startRow + RANGE, SIZE);
            multipliers[i].start();
        }

        for (Multiply4 multiplier : multipliers) {
            try {
                multiplier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

        long multiThreadEndT = System.nanoTime();
        double multiThreadT = (multiThreadEndT - multiThreadStartT) / 1000000000.0;

        for (Multiply4 multiplier : multipliers) {
            int[][] partialResult = multiplier.getResult();
            for (int i = multiplier.getStartRow(); i < multiplier.getEndRow(); i++) {
                System.arraycopy(partialResult[i], 0, D[i], 0, SIZE);
            }
        }

        System.out.println("Multi-thread (" + processors + ") time: " +
                String.format("%.2f", multiThreadT) + "s");
        System.out.println("Speedup: " +
                String.format("%.2f", singleThreadT / multiThreadT) + "x");

        // Verification
        boolean resultsMatch = verifyResults(C, D);
        System.out.println("Results verification: " + (resultsMatch ? "MATCH" : "DIFFER"));

        // Calculate MD5 checksums
        String md5Single = calculateMD5(C);
        String md5Multi = calculateMD5(D);
        System.out.println("MD5 checksum (single-thread): " + md5Single);
        System.out.println("MD5 checksum (multi-thread): " + md5Multi);

        // Save results to file
        saveResultsToFile(SIZE, processors, singleThreadT, multiThreadT,
                resultsMatch, md5Single, md5Multi);
    }

    private static String calculateMD5(int[][] matrix) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();

            for (int[] row : matrix) {
                for (int value : row) {
                    sb.append(value).append(",");
                }
            }

            byte[] hash = md.digest(sb.toString().getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    private static void saveResultsToFile(int size, int processors,
                                          double singleThreadTime, double multiThreadTime,
                                          boolean resultsMatch, String md5Single, String md5Multi) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("wyniki.txt", true))) {
            writer.println("\n--- Results ---");
            writer.println("Timestamp: " + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            writer.println("Matrix size: " + size + "x" + size);
            writer.println("Number of processors: " + processors);
            writer.println("Single thread time: " +
                    String.format("%.2f", singleThreadTime) + "s");
            writer.println("Multi-thread time: " +
                    String.format("%.2f", multiThreadTime) + "s");
            writer.println("Speedup: " +
                    String.format("%.2f", singleThreadTime / multiThreadTime) + "x");
            writer.println("Results verification: " +
                    (resultsMatch ? "MATCH" : "DIFFER"));
            writer.println("MD5 checksum (single-thread): " + md5Single);
            writer.println("MD5 checksum (multi-thread): " + md5Multi);
            writer.println("--- End of results ---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Existing methods remain unchanged
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
