package graphs;

import java.util.ArrayList;
import java.util.List;
//https://www.naukri.com/code360/problems/euler-path_1214547
//   Time Complexity: O(V + E)
//	 Space Complexity: O(V^2 + E)
public class EulerPathInUnDirectedGraphs {
    public static void main(String[] args) {
        int vertices = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
//        adj.get(0).add(2);
//        adj.get(2).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(2).add(4);
        adj.get(4).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        System.out.println(eulerPath(5, adj));
    }
    public static List<Integer> eulerPath(int v, List<List<Integer>> adj){
        List<Integer> ans = new ArrayList<>();
        boolean flag = true;
        boolean [][]visited = new boolean[v][v];
        for (int i = 0;i < v;i++){
            if(adj.get(i).size() % 2 == 1){
                dfs(i, ans, adj, visited);
                flag = false;
                break;
            }
        }
        if (flag) dfs(0, ans, adj, visited);
        return ans;
    }

    private static void dfs(int u, List<Integer> ans, List<List<Integer>> adj, boolean[][] visited) {
        for (int v : adj.get(u)){
            if(!visited[u][v]){
                visited[u][v] = true;
                visited[v][u] = true;
                dfs(v, ans, adj, visited);
            }
        }
        ans.add(u);
    }
}
