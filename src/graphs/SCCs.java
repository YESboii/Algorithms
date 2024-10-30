package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//directed graphs-
//https://www.geeksforgeeks.org/problems/strongly-connected-component-tarjanss-algo-1587115621/1
public class SCCs {
    public static void main(String[] args) {
        int vertices = 7;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(3).add(4);
        adj.get(4).add(0);
        adj.get(4).add(5);
        adj.get(4).add(6);
        adj.get(5).add(2);
        adj.get(5).add(6);
        adj.get(6).add(5);
        findSCC(vertices, adj);
    }

    public static void findSCC(int v, List<List<Integer>> adj){
        int []disc = new int[v];
        Arrays.fill(disc, -1);
        int []low = new int[v];
        boolean []inPath = new boolean[v];
        int []time = {0};
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< v;i++){
            if(disc[i] == -1) tarjan(i, disc, low, inPath, stack, time, adj);
        }

    }

    private static void tarjan(int u, int[] disc, int[] low, boolean[] inPath,
                               Stack<Integer> stack, int []time, List<List<Integer>> adj) {
        low[u] = disc[u] = time[0]++;
        stack.push(u);
        inPath[u] = true;
        for(int v : adj.get(u)){
            if(disc[v] == -1){
                tarjan(v, disc, low, inPath, stack, time, adj);
                low[u] = Math.min(low[u], low[v]); // to check if it's descendant can reach a
                //vertex with a lower discovery time,i.e, ancestors of u

            } else if (inPath[v]) {
                low[u] = Math.min(low[u], disc[v]);// back edge
            }
        }
        System.out.println(Arrays.toString(inPath));
        System.out.println(stack);
        if(disc[u] == low[u]){
            System.out.print("SCC: ");
            while (true){
                int x = stack.pop();
                inPath[x] = false;
                System.out.print(x + " ");
                if(x == u) break;
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }
}
