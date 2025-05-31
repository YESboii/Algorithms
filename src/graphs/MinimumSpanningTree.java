package graphs;
//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Kruskal's
//sort the edges
//greedily select the edges that do not form cycle exactly n - 1 times
public class MinimumSpanningTree {

    public static int mst(List<int []> edges, int n){
        int result = 0;
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        for (int []edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            if(uf.find(u) != uf.find(v)){
                result += w;
                uf.union(u, v);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0, 1, 10});
        edges.add(new int[]{0, 2, 6});
        edges.add(new int[]{0, 3, 5});
        edges.add(new int[]{1, 3, 15});
        edges.add(new int[]{2, 3, 4});

        int result = mst(edges, 4); // n = 4 (number of nodes)

        System.out.println("Minimum Spanning Tree weight: " + result);
    }
}
class UnionFind{
    private int[] parent;
    private int[] size;
    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0;i < n;i++){
            parent[i] = i;
        }
    }
    public int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y){
        int setX = find(x);
        int setY = find(y);

        if(setX == setY) return;
        //attach the smaller tree with larger tree
        if(size[setX] > size[setY]){
            parent[setY] = setX;
            size[setX] += size[setY];
        }else{
            parent[setX] = setY;
            size[setY] += size[setX];
        }
    }
}
