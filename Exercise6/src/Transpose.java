import java.io.*;

/**
 * Created by eva on 10/22/17.
 */
public class Transpose {

    // Create matrix:
    public static void fillMatrix(int[][] matrix, String line) {
        String[] array = line.split(",");

        int i = Integer.parseInt(array[0]);
        int j = Integer.parseInt(array[1]);
        int value = Integer.parseInt(array[2]);

        matrix[i][j] = value;
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

    // Transpose with tiling
    public static int[][] transposeTiling(int[][] A, int block) {
        int N = A.length;
        int s = block;
        int l;
        int[][] B = new int[N][N];

        for (int ii = 0; ii < N; ii+=s) {
            l = ii+s;
            if (l > N) {
                l = N;
            }
            for (int j = 0; j < N; j++) {
                for (int i = ii; i < l; i++) {
                    B[i][j] = A[j][i];
                }
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] A = new int[n][n];
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

        int block = Integer.parseInt(args[2]);
        int x = 10;

        System.out.println("Transpose matrix of size " + n + ", running both methods " + x + " times each:");

        System.out.println("Without tiling: ");
        for (int i = 0; i < x; i++) {
            long startTime = System.nanoTime();
            int[][] At = transpose(A);
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println(estimatedTime);
        }

        System.out.println("With blocks of size " + block + ":");
        for (int i = 0; i < x; i++) {
            long sTime = System.nanoTime();
            int[][] AT = transposeTiling(A, block);
            long eTime = System.nanoTime() - sTime;
            System.out.println(eTime);
        }

        System.out.println("Without tiling (in place): ");
        for (int i = 0; i < x; i++) {
            long startTime = System.nanoTime();
            transposeInPlace(A);
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println(estimatedTime);
        }
    }
}
