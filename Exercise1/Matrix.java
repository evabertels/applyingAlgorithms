public class Matrix {

  private int size;
  private int[][] matrix;

  public Matrix(int size){
    this.size = size;
    this.matrix = new int[size][size];
  }

  public void fillMatrix(int i, int j, int value){
    this.matrix[i][j] = value;
  }

  public int getSize() {
    return this.size;
  }

  public int[][] getMatrix() {
    return this.matrix;
  }
}
