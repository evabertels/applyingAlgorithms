import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by eva on 9/26/17.
 */
public class Graph {
    private int V;
    private int E;
    private int[] vertices;
    private int[] vertexSeed;
    private HashMap<Integer, List<Edge>> vertexMap = new HashMap<>();

    public Graph(){}

    // Complete graph:
    public Graph(int seed, int numVertices) {
        this.V = numVertices;
        this.E = (numVertices * (numVertices-1))/2;
        this.vertexSeed = new int[V];
        generateSeeds(seed);

        for (int v = 0; v < V; v++) {
            List<Edge> edges = new ArrayList<>();
            for (int e = 0; e < V; e++) {
                Edge edge = new Edge(v, e, getEdgeWeight(v, e));
                edges.add(edge);
            }
            this.vertexMap.put(v, edges);
        }
        System.out.println("V = " + V + ", E = " + E + ", map size = " + vertexMap.size());
    }

    // Grid graph:
    public Graph (int seed, int numX, int numY) {
        this.V = numX * numY;
        this.E = ((numX-1) * numY) + ((numY-1) * numX);
        this.vertexSeed = new int[V];
        generateSeeds(seed);

        for (int v = 0; v < V; v++) {
            this.vertices[v] = v;
        }
    }

    // Custom graph:
    public Graph (int seed, int numVertices, int numEdges, BufferedReader br) throws IOException {
        this.V = numVertices;
        this.E = numEdges;
        this.vertexSeed = new int[V];
        generateSeeds(seed);

        String line;
        int edgeCounter = 0;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] splitLine = line.split("\\t");
            int v1 = Integer.parseInt(splitLine[0]);
            int v2 = Integer.parseInt(splitLine[1]);
            if (this.vertexMap.containsKey(v1)) {
                Edge edge = new Edge(v1, v2, getEdgeWeight(v1, v2));
                this.vertexMap.get(v1).add(edge); // do I need to put the pair back into the HashMap?
            }
            else {
                List<Edge> edges = new ArrayList<>();
                Edge edge = new Edge(v1, v2, getEdgeWeight(v1, v2));
                edges.add(edge);
                this.vertexMap.put(v1, edges);
            }
        }
    }

    // create edge weights
    private int xorshift32(int seed)
    {
        int ret = seed;
        ret ^= ret << 13;
        ret ^= ret >> 17;
        ret ^= ret << 5;
        return ret;
    }

    private void generateSeeds(int seed)
    {
        this.vertexSeed[0] = xorshift32(seed);
        for(int i = 1; i < V; i++)
        {
            this.vertexSeed[i] = xorshift32(this.vertexSeed[i-1] ^ seed);
        }
    }

    int EDGE_MOD = 100000;
    private int getEdgeWeight(int v1, int v2)
    {
        return xorshift32(this.vertexSeed[v1] ^ this.vertexSeed[v2]) % EDGE_MOD;
    }
}
