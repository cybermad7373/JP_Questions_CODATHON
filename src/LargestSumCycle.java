
import java.util.Vector;

public class LargestSumCycle {
    public static void main(String[] args) {
        int vertex = 23;
        int[] edges = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21};
        Vector<Integer>[] adj = new Vector[vertex];
        adj = construct(edges, vertex, adj);

        System.out.println("Length of the largest cycle: " + findLargestCycle(adj));
    }

    public static Vector<Integer>[] construct(int[] edges, int vertex, Vector<Integer>[] adj) {
        for (int i = 0; i < vertex; i++) {
            adj[i] = new Vector<>();
        }

        for (int i = 0; i < vertex; i++)
        {
            int nextVertex = edges[i];
            adj[i].add(nextVertex);
        }

        return adj;
    }

    public static int findLargestCycle(Vector<Integer>[] adj) {
        int max = 0;
        boolean[] visited = new boolean[adj.length];

        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                int newMax = circleLength(adj, i, visited);
                if (newMax > max) {
                    max = newMax;
                }
            }
        }

        return max;
    }

    public static int circleLength(Vector<Integer>[] adj, int pos, boolean[] visited) {
        int size = 0;
        int current = pos;
        int start = pos;

        while (!visited[current] && adj[current].get(0)!=-1)
        {
            visited[current] = true;
            size++;

            if (current >= 0 && current < adj.length && adj[current].size() > 0) {
                current = adj[current].get(0);
            } else {
                break;
            }

            if (current == start) {
                break;
            }
        }

        return size;
    }

}
