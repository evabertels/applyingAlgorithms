import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

// Matrix Multiplication main method
public class MM {

  public static String arrayToString(int[][] a) {

    String aString = "";
    int column;
    int row;

    for (row = 0; row < a.length; row++) {
      if (a[row] != null && a[row].length > 0) {
          aString = aString + a[row][0];
          for (column = 1; column < a[row].length; column++) {
              aString = aString + " " + a[row][column];
          }
      }
      aString = aString + " ";
    }
    return aString;
  }

  public static void main(String[] args) {
    final int size = Integer.parseInt(args[0]);

    Matrix A = new Matrix(size);
    Matrix B = new Matrix(size);

    try {
      Scanner matrix1 = new Scanner(new File(args[1]));

      while (matrix1.nextLine().substring(0,1) == "#") {
        continue;
      }
      while (matrix1.hasNext()) {
        String line = matrix1.next();
        String[] array = line.split(",");

        int i = Integer.parseInt(array[0]);
        int j = Integer.parseInt(array[1]);
        int value = Integer.parseInt(array[2]);

        A.fillMatrix(i, j, value);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      Scanner matrix2 = new Scanner(new File(args[2]));

      while (matrix2.nextLine().substring(0,1) == "#") {
        continue;
      }
      while (matrix2.hasNext()) {
        String line = matrix2.next();
        String[] array = line.split(",");

        int i = Integer.parseInt(array[0]);
        int j = Integer.parseInt(array[1]);
        int value = Integer.parseInt(array[2]);

        B.fillMatrix(i, j, value);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    int[][] result = MMnaive.multiply(A,B);
    System.out.println(arrayToString(result));
  }
}
