public class Hash {

  private int[][] A;

  private String hexadecimals = "0x21ae4036,0x32435171,0xac3338cf,0xea97b40c,0x0e504b22,0x9ff9a4ef,0x111d014d,0x934f3787,0x6cd079bf,0x69db5c31,0xdf3c28ed,0x40daf2ad,0x82a5891c,0x4659c7b0,0x73dc0ca8,0xdad3aca2,0x00c74c7e,0x9a2521e2,0xf38eb6aa,0x64711ab6,0x5823150a,0xd13a3a9a,0x30a5aa04,0x0fb9a1da,0xef785119,0xc9f0b067,0x1e7dde42,0xdda4a7b2,0x1a1c2640,0x297c0633,0x744edb48,0x19adce93";

  private String[] hex = hexadecimals.split(",");

  public Hash(int b, int k) {
    A = new int[b][k];
  }

  public Hash() {
    A = new int[32][32];
    System.out.println("hex[0] is " + hex[0]);

    // go through each hexadecimal in hex:
    for (int i = 0; i < 32; i++) {
      // convert to binary representation as a String
      String binaryString = hexToBinary(hex[i]);
      System.out.println(binaryString + binaryString.charAt(i));
/*
      // convert each digit into an int in an array of size 32
      int[] binaryArray = new int[32]; // setup as in matrix, i.e. if binaryArry[32] = 1 and all others are 0, the corresponding int is 1
      for (int j = 32; j > 0; j--){
        binaryArray[j] = Integer.parseInt(binaryString.charAt(j));
      }

      // add binary digits to row in matrix
      for (int k = 0; k < 32; k++) {
        A[i][k] = binaryArray[k];
      }*/
    }
  }

  private int[][] getMatrix() {
    return A;
  }

  private String hexToBinary(String hex) {
    String h = hex.replace("0x","");
    int i = (int) Long.parseLong(h, 16);
    System.out.println("i is " + i);
    return Integer.toBinaryString(i);
  }
}
