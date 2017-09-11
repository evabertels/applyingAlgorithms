public class MMrecursive {

  public Matrix[] quarter(Matrix m) {
    int n = m.getSize();
    int[][] matrix = m.getMatrix();

    Matrix[] quarters = Matrix[4];

    for (int i = 0; i < n/2; i++) {
      for (int j = 0; j < n/2; j++) {
        quarters[0].fillMatrix(i, j, matrix[i][j]);
      }
    }

    for (int i = 0; i < n/2; i++) {
      for (int j = n/2; j < n; j++) {
        quarters[1].fillMatrix(i, j, matrix[i][j]);
      }
    }

    for (int i = n/2; i < n; i++) {
      for (int j = 0; j < n/2; j++) {
        quarters[2].fillMatrix(i, j, matrix[i][j]);
      }
    }

    for (int i = n/2; i < n; i++) {
      for (int j = n/2; j < n; j++) {
        quarters[3].fillMatrix(i, j, matrix[i][j]);
      }
    }

    return quarters;
  }

  public int[][] multiply(Matrix a, Matrix b) {
    int[][] A = a.getMatrix();
    int[][] B = b.getMatrix();

    int n = a.getSize();
    int[][] solution = new int[n][n];

    if (n == 1) {
      return A;
    }
  }
}
