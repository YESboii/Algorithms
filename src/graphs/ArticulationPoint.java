package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.geeksforgeeks.org/problems/articulation-point2616/1
public class ArticulationPoint {

    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        int []disc = new int[V];
        Arrays.fill(disc, -1);
        int []low = new int[V];
        int []time = {0};
        ArrayList<Integer> aps = new ArrayList<>();
        boolean []isAp = new boolean[V];
        for(int i = 0;i < V;i++){
            if(disc[i] == -1){
                dfs(i, disc, low, time, adj, isAp, -1);

            }

        }
        for(int i = 0; i < V;i++){
            if(isAp[i]) aps.add(i);
        }
        if(aps.size() == 0) return new ArrayList<>(List.of(-1));
        return aps;
    }
    private void dfs(int u, int []disc, int []low, int []time, ArrayList<ArrayList<Integer>> adj,
                     boolean []isAp, int parent){
        low[u] = disc[u] = time[0]++;
        int subGraphs = 0;
        for (int v : adj.get(u)){
            if(disc[v] == -1){
                subGraphs++;
                dfs(v, disc, low, time, adj, isAp, u);
                low[u] = Math.min(low[u], low[v]);
                if(parent != -1 && low[v] >= disc[u]){
                    //2nd case: No vertex starting from v and its descendants
                    //that can reach ANCESTORS OF U, REACHABILITY TO U IS NOT IMPORTANT
                    //AS BY DEFITION OF AP, IT WILL BE REMOVED. SO EVEN IF THE SUBGRAPH
                    //FROM V CAN REACH U U WILL STILL BE AN AP
                    isAp[u] = true;
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if(parent == -1 && subGraphs > 1) isAp[u] = true;
    }
}
