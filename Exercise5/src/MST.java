import java.io.*;

/**
 * Read in files
 */
public class MST {

    // hash total of edge weights
    private int hashRand(int inIndex){
        final int b = 0x5f375a86; //bunch of random bits
        for(int i = 0; i < 8; i++)
        {
            inIndex = (inIndex + 1)*( (inIndex >> 1)^b);
        }
        return inIndex;
    }

    public static void main(String[] args) {
        int seed, numX, numY, numVertices, numEdges;

        int count = args.length;

        if (count == 0) {
            System.out.println("Too few arguments given.");
        }

        seed = Integer.parseInt(args[0]);

        if (count == 2) {
            numVertices = Integer.parseInt(args[1]);
            Graph graph = new Graph(seed, numVertices);

            int MST = Kruskal.findMST(graph);
        }

        else if (count == 3) {
            numX = Integer.parseInt(args[1]);
            numY = Integer.parseInt(args[2]);
            Graph graph = new Graph(seed, numX, numY);

            int MST = Kruskal.findMST(graph);
        }

        else if (count == 4) {
            BufferedReader br = null;

            try {
                File file = new File(args[1]);
                numVertices = Integer.parseInt(args[2]);
                numEdges = Integer.parseInt(args[3]);

                br = new BufferedReader(new FileReader(file));

                Graph graph = new Graph(seed, numVertices, numEdges, br);

                br.close();

                int MST = Kruskal.findMST(graph);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else {
            System.out.println("Too many arguments given.");
            return;
        }
    }
}
