package graphs;
import java.util.*;
//Undirected graphs
//https://www.geeksforgeeks.org/problems/euler-circuit-and-path/1
public class EulerGraph {
    public static void main(String[] args) {
        int vertices = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(2).add(4);
        adj.get(4).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        isEuler(5, adj);
    }

    public static void isEuler(int v, List<List<Integer>> adj){
        int res = Utils(v, adj);
        String result = switch (res) {
            case 1 -> "A Euler Graph";
            case 2 -> "A semi-Euler Graph";
            default -> "None";
        };
        System.out.println(result);
    }

    private static int Utils(int v, List<List<Integer>> adj) {
        if(connectivityCheck(v, adj)){
            //count the number of odd degree of vertices
            int count = 0;
            for (int i = 0;i < v;i++){
                if(adj.get(i).size() % 2 == 1)count++;
            }
            if(count > 2) return 3;
            return count == 0 ? 1 : 2;
        }
        return 3;
    }

    private static boolean connectivityCheck(int v, List<List<Integer>> adj) {
        int vertex = -1;
        for(int i = 0;i < v;i++){
            if(adj.get(i).size() > 0){
                vertex = i;
                break;
            }
        }
        if(vertex == -1) return true;// no edges in the graph
        boolean []visited = new boolean[v];
        dfs(vertex, visited, adj);
        for(int i = 0;i < v;i++){
            if(!visited[i] && adj.get(i).size() > 0) return false;//a disconnected component with degree > 0
        }
        return true;
    }

    private static void dfs(int vertex, boolean[] visited, List<List<Integer>> adj) {
        visited[vertex] = true;
        for (int v : adj.get(vertex)){
            if(!visited[v]){
                dfs(v, visited, adj);
            }
        }
    }
}
