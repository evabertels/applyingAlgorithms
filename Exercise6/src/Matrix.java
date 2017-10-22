import java.io.*;
import java.util.Arrays;

/**
 * Created by eva on 10/10/17.
 */
public class Matrix {

    // Create matrix:
    public static void fillMatrix(int[][] matrix, String line) {
        String[] array = line.split(",");

        int i = Integer.parseInt(array[0]);
        int j = Integer.parseInt(array[1]);
        int value = Integer.parseInt(array[2]);

        matrix[i][j] = value;
    }

    // Print matrix
    public static void printMatrix(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.printf("%4d", A[i][j]);
            }
            System.out.println();
        }
    }

    // Transpose matrix in place:
    public static void transposeInPlace(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
    }

    // Transpose in copy:
    public static int[][] transpose(int[][] A) {
        int N = A.length;
        int[][] B = new int[N][N];

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                B[i][j] = A[j][i];
            }
        }
        return B;
    }

    // Multiply two same-sized square matrices:
    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] solution = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    solution[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return solution;
    }

    // Check if two matrices are the same
    private static boolean check(int[][] matrixM, int[][] matrixMT) {
        for (int i = 0; i < matrixM.length; i++) {
            for (int j = 0; j < matrixM.length; j++) {
                if (matrixM[i][j] != matrixMT[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        BufferedReader br;

        try {
            File file = new File(args[1]);
            String line;
            br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) == "#") {
                continue;
            }
            while ((line = br.readLine()) != null) {
                fillMatrix(A, line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File(args[2]);
            String line;
            br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) == "#") {
                continue;
            }
            while ((line = br.readLine()) != null) {
                fillMatrix(B, line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Transpose experiment
        System.out.println("Transpose matrix of size " + n);

        int x = 10;

        System.out.println("Without tiling: ");
        for (int i = 0; i < x; i++) {
            long startTime = System.nanoTime();
            int[][] At = transpose(A);
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println(estimatedTime);
        }

        int block = 1;

        System.out.println("With blocks of size " + block + ":");
        for (int i = 0; i < x; i++) {
            long sTime = System.nanoTime();
            int[][] AT = Tiling.transposeTiling(A, block);
            long eTime = System.nanoTime() - sTime;
            System.out.println(eTime);
        }
/*
        int[][] matrixM = multiply(A, B);
        int[][] matrixMT = Tiling.multiplyTiling(A, B, n);
        if (check(matrixM, matrixMT)) {
            System.out.println("Multiplication result is the same with and without tiling."); }
        else {
            System.out.println("Multiplication error.");
        }

        int[][] AT = Tiling.transposeTiling(A, 3);
        transpose(A);
        if (check(A, AT)){
            System.out.println("Transpose result is the same with and without tiling.");
        }
        else{
            System.out.println("Transpose error.");
        }

        int[][] BT = Tiling.transposeTiling(B, n);
        transpose(B);
        if (check(B, BT)){
            System.out.println("Transpose result is the same with and without tiling.");
        }
        else{
            System.out.println("Transpose error.");
        }
/*
        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("----------");

        int[][] AT = Tiling.transposeTiling(A, n);

        System.out.println("Tiling transpose:");
        printMatrix(AT);
        System.out.println("----------");
        transpose(A);

        System.out.println("Normal transpose:");
        printMatrix(A);
        System.out.println("----------");

        System.out.println("Tiling multiply:");
        int[][] matrixMT = Tiling.multiplyTiling(A, B, n);
        printMatrix(matrixMT);
        System.out.println("----------");

        int[][] matrixM = multiply(A, B);
        System.out.println("Normal multiply:");
        printMatrix(matrixM);
*/
    }

}
