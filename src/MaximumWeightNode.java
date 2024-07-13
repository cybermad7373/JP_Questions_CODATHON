import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class  MaximumWeightNode {
    public static void main(String[] args) {
        int vertex = 23;
        int[] edges = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21};
        Vector<Integer>[] adj = new Vector[vertex];
        adj = construct(edges, vertex, adj);

        System.out.println("Maximum Weight Node in Graph is: " + MaxWeight(adj));
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
    public static int MaxWeight(Vector<Integer>[] adj){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<adj.length;i++)
        {
            int ch = adj[i].get(0);
            if(!map.containsKey(ch))
            {
                map.put(ch,i);
            }else{
                map.put(ch,map.get(ch)+i);
            }
        }

//        System.out.println(map);
        int maxValue = Integer.MIN_VALUE;
        int maxKey = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer > entry : map.entrySet())
        {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }

        }
        return maxKey;

    }
}