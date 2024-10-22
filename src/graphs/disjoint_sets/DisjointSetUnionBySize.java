package graphs.disjoint_sets;

import java.util.Arrays;

public class DisjointSetUnionBySize {
    public static void main(String[] args) {
        int [][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {3, 2}};
        DisjointSetSize ds = new DisjointSetSize(5);
        boolean flag = true;
        for(int []edge: edges){
            int u = edge[0], v = edge[1];
            if(ds.find(u) == ds.find(v)) {
                System.out.println("cycle");
                flag = false;
            }
            ds.unionBySize(u, v);
        }
        if(flag) System.out.println("no cycle");
    }
}
class DisjointSetSize{
    private int []parent;
    private int []size;
    DisjointSetSize(int v){
        parent = new int[v];
        size = new int[v];
        Arrays.fill(size, 1);
        for (int i = 0;i < v;i++){
            parent[i] = i;
        }
    }
    public int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    public void unionBySize(int x, int y){
        int setX = find(x);
        int setY = find(y);

        if(setY == setX) return;

        if (size[setX] > size[setY]){
            parent[setY] = setX;
            size[setX] += size[setY];
        } else if (size[setX] <= size[setY]) {
            parent[setX] = setY;
            size[setY] += size[setX];
        }
    }
}
