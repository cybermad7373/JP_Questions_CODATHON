import java.util.*;

public class GraphPathDFS {
    public static boolean isPathExist(int numNodes, int[][] edges, int start, int end) {

        List<Integer>[] graph = new ArrayList[numNodes + 1];
        for (int i = 1; i <= numNodes; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }


        boolean[] visited = new boolean[numNodes + 1];

        return dfs(graph, start, end, visited);
    }


    private static boolean dfs(List<Integer>[] graph, int current, int end, boolean[] visited) {
        if (current == end) {
            return true;
        }
        if (visited[current]) {
            return false;
        }

        visited[current] = true;

        for (int neighbor : graph[current]) {
            if (dfs(graph, neighbor, end, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int numNodes = 9;
        int[][] edges = {
                {2, 9},
                {7, 2},
                {7, 9},
                {9, 5}
        };
        int start = 7;
        int end = 9;

        boolean result = isPathExist(numNodes, edges, start, end);
        System.out.println(result ? "true" : "false");
    }
}
