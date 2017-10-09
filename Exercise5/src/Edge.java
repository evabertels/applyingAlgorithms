/**
 * Created by eva on 9/26/17.
 */
public class Edge {
    private final int u;
    private final int v;
    private final int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int compareTo(Edge that) {
        return Integer.compare(this.weight, that.weight);
    }
}
