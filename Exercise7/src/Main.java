import java.io.*;
import java.util.BitSet;
import static java.util.BitSet.valueOf;

/**
 * Read file and naive comparison of all vectors with all.
 */
public class Main {

    public static BitSet[] vectors;
    public static int index = 0;

    // Compare all vectors in the BitSet with each other and return the two most similar ones as String "vector1 vector2"
    public static String compareAll(BitSet[] vectors) {
        String bestMatch = null;
        int similarityScore = 0;

        for (int i = 0; i < vectors.length; i++) {
            for (int j = i+1; j < vectors.length; j++) {
                int similarity = 0;
                for (int k = 0; k < 256; k++) {
                    if (vectors[i].get(k) == true && vectors[j].get(k) == true) {
                        similarity++;
                    }
                }
                if (similarity > similarityScore) {
                    similarityScore = similarity;
                    bestMatch = String.valueOf(i) + " " + String.valueOf(j);
                }
            }
        }
        return bestMatch;
    }

    public static void main(String[] args) {
        int signedLongs = Integer.parseInt(args[1]);
        vectors = new BitSet[Integer.parseInt(args[2])];
        BufferedReader br;

        try {
            File file = new File(args[0]);
            String line;
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String [] vectorStrings = line.split(" ");
                long[] vectorLongs = new long[signedLongs];
                for (int i = 0; i < signedLongs; i++) {
                    vectorLongs[i] = Long.parseLong(vectorStrings[i]);
                }
                // Create BitSet from 64-bit longs and add to array
                vectors[index] = valueOf(vectorLongs);
                index++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(compareAll(vectors));
    }
}
