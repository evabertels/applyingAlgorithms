/**
 * Created by eva on 10/9/17.
 */
public class Tiling {

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

    public static int[][] multiplyTiling(int[][] A, int[][] B, int block) {
        int N = A.length;
        int[][] solution = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    solution[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return solution;
    }

    public static int[][] multiplysomething(int[][] A, int[][] B, int block) {
        int[][] solution = new int[A.length][A.length];
        int sA = block;
        int sB = block;
        int x = 0;
        int y = 0;

        for (int i = sA-block; i < sA; i++) {
            for (int j = sB-block; j < sB; j++) {

            }
        }

        return solution;
    }
}
