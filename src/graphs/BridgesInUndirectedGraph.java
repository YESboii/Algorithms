package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/critical-connections-in-a-network/description/
public class BridgesInUndirectedGraph {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int []dis = new int[n];
        Arrays.fill(dis, -1);
        int []low = new int[n];
        int []time = {0};
        List<List<Integer>> bridges = new ArrayList<>();
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> conn : connections){
            int u = conn.get(0), v = conn.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        findBridges(0, dis, low, time, adj, bridges, -1);
        return bridges;
    }
    private void findBridges(int u, int []dis, int []low, int []time, List<List<Integer>> adj
            , List<List<Integer>> bridges, int parent
    ){
        low[u] = dis[u] = time[0]++;
        for (int v : adj.get(u)){
            if(dis[v] == -1){
                findBridges(v, dis, low, time, adj, bridges, u);
                low[u] = Math.min(low[u], low[v]);
                // if v cannot discover ancestors of u/ descendants of v cannot reach u or ancestors of u
                //then v will have the lowest discovery > dis[u] that is low[v] = dis[v]
                //so this satisfies the condition to be a bridge
                if(low[v] > dis[u]){
                    bridges.add(List.of(u, v));
                }
            }
            //if v is already discovered only updated the low[u] iff v is not the parent of u
            else if(v != parent){
                low[u] = Math.min(low[u], dis[v]);
            }
        }
    }
}
