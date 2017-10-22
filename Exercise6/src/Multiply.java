import java.io.*;

/**
 * Created by eva on 10/22/17.
 */
public class Multiply {

    // Create matrix:
    public static void fillMatrix(int[][] matrix, String line) {
        String[] array = line.split(",");

        int i = Integer.parseInt(array[0]);
        int j = Integer.parseInt(array[1]);
        int value = Integer.parseInt(array[2]);

        matrix[i][j] = value;
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

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        BufferedReader br;

        try {
            File file = new File(args[1]);
            String line;
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) == "#") {
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
            while ((line = br.readLine()) == "#") {
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

        int block = Integer.parseInt(args[3]);
        int x = 10;

        System.out.println("Multiply matrices of size " + n + ", running both methods " + x + " times each:");

        System.out.println("Without tiling: ");
        for (int i = 0; i < x; i++) {
            long startTime = System.nanoTime();
            int[][] AM = multiply(A, B);
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println(estimatedTime);
        }
    }
}
