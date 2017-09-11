public class MMnaive {

  public static int[][] multiply(Matrix a, Matrix b) {

    int[][] A = a.getMatrix();
    int[][] B = b.getMatrix();

    int n = a.getSize();
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
}
