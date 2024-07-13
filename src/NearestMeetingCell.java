import java.util.ArrayList;
import java.util.Vector;

public class NearestMeetingCell {
    public static void main(String[] args) {
        int vertex = 23;
        int[] edges = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21};
        int N1 = 2;
        int N2 = 9;
        Vector<Integer>[] adj = new Vector[vertex];
        adj = construct(edges, vertex, adj);

        System.out.println("Nearest Meeting Cell of 2 and 9 : " + meeting(adj,N1,N2));
    }

    public static Vector<Integer>[] construct(int[] edges, int vertex, Vector<Integer>[] adj) {
        for (int i = 0; i < vertex; i++) {
            adj[i] = new Vector<>();
        }

        for (int i = 0; i < vertex; i++) {
            int nextVertex = edges[i];
            adj[i].add(nextVertex);
        }

        return adj;
    }

    public static int meeting(Vector<Integer>[] adj,int n1,int n2){
        ArrayList<Integer> path1 = path(adj,n1);
        ArrayList<Integer> path2 = path(adj,n2);


        for (int i:path1)
        {
            for (int j : path2)
            {
                if(i==j)
                {
                    return i;
                }
            }
        }
        return -1;
    }
    public static ArrayList<Integer> path(Vector<Integer>[] adj,int pos)
    {
//        int size = 0;
        ArrayList<Integer> pathh = new ArrayList<>() ;
        int current = pos;
        int start = pos;
        boolean[] visited = new boolean[adj.length];
        while (!visited[current] && adj[current].get(0)!=-1) {
            visited[current] = true;
            pathh.add(adj[current].get(0));
//            size++;

            if (current >= 0 && current < adj.length && adj[current].size() > 0) {
                current = adj[current].get(0);
            } else {
                break;
            }

            if (current == start) {
                break;
            }
        }

//        return size;
        return pathh;
    }
}
