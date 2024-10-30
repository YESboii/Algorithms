package graphs;

import java.util.*;

public class EulerPathInDirectedGraphs {
    public static void main(String[] args) {
        int vertices = 7;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(2);
        adj.get(2).add(4);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(3).add(2);
        adj.get(3).add(5);
        adj.get(4).add(3);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(3);
//        adj.get(0).add(5);
        System.out.println(eulerPath(7, adj));
    }

    public static List<Integer> eulerPath(int n, List<List<Integer>> adj){
        int []indegree = new int[n];
        int []outdegree = new int[n];
        int vertex = -1;
        for(int i = 0;i < n;i++){
            for(int v : adj.get(i)){
                indegree[v]++;
            }
            outdegree[i] = adj.get(i).size();
            if(outdegree[i] > 0) vertex = i;
        }
        int equal = 0, start = 0, end = 0;
        for(int i = 0;i < n;i++){
            if(indegree[i] == outdegree[i]) equal++;
            else if(indegree[i] - outdegree[i] == 1) end++;
            else if(outdegree[i] - indegree[i] == 1) start++;
        }
        List<Integer> ans = new ArrayList<>();
        // since we need to remove edges as we process them, we need to remove the
        // edges in constant time using ArrayList is not efficient therefore either use a Queue or LinkedList
        List<LinkedList<Integer>> adjList = new ArrayList<>();
        for (List<Integer> list : adj){
            adjList.add(new LinkedList<>(list));
        }
        if(!isStronglyConnected(n, adj, vertex, indegree, outdegree)) {
            ans =  List.of(-1);
        }
        else if(equal == n){
            //case for circuit
            //start at vertex with degree > 0
            dfs(vertex, adjList, ans);
        }else if(start == 1 && end == 1 && equal == n - 2){
            //path
            //start from the vertex with extra outgoing vertex
            for (int i = 0;i < n;i++){
                if(outdegree[i] - indegree[i] == 1){
                    dfs(i, adjList, ans);
                    break;
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
    static  private void dfs(int u, List<LinkedList<Integer>> adjList, List<Integer> ans){
        while (!adjList.get(u).isEmpty()){
            int v = adjList.get(u).removeFirst();
            dfs(v, adjList, ans);
        }
        ans.add(u);
    }

    private static boolean isStronglyConnected(int n, List<List<Integer>> adj, int v, int []indegree, int []outdegree) {
        //use Tarjan's Algorithm to find the number of SCC, and it should be 1
        int []disc = new int[n];
        int []low = new int[n];
        Arrays.fill(disc, -1);

        boolean []inPath = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        int []time = {0};
        int scc = tarjans(v, adj, disc, low, time, inPath, stack);// start the algorithm from
        // a vertex with degree > 0
//        check if scc > 1
        if(scc > 1) return false;
        // now check whether the other unvisited ones have degrees == 0
        for(int i = 0;i < n;i++){
            if(disc[i] == -1 && (indegree[i] > 0 || outdegree[i] > 0)) return false;
            // all the vertices with degrees must belong to the same SCC. if this condition passes
            //then they don't belong to same SCC
        }
        return true;
    }

    private static int tarjans(int u, List<List<Integer>> adj, int[] disc,
                                int[] low, int []time, boolean[] inPath, Stack<Integer> stack) {
        low[u] = disc[u] = time[0]++;
        inPath[u] = true;
        stack.push(u);
        int scc = 0;
        for (int v : adj.get(u)){
            if (disc[v] == -1){
                scc += tarjans(v, adj, disc, low, time, inPath, stack);
                low[u] = Math.min(low[u], low[v]);
            }else if(inPath[v]){
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if(low[u] == disc[u]){
            scc++;
            while (true){
                int x = stack.pop();
                inPath[x] = false;
                if(x == u) break;
            }
        }
        return scc;
    }
}
