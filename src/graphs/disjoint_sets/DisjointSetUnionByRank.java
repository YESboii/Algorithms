package graphs.disjoint_sets;


//also cycle detection using DSU
public class DisjointSetUnionByRank {
    public static void main(String[] args) {
        int [][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        DisjointSetRank ds = new DisjointSetRank(5);
        boolean flag = true;
        for(int []edge: edges){
            int u = edge[0], v = edge[1];
            if(ds.find(u) == ds.find(v)) {
                System.out.println("cycle");
                flag = false;
            }
            ds.unionByRank(u, v);
        }
        if(flag) System.out.println("no cycle");
    }
}
class DisjointSetRank{
    private int []parent;
    private int []rank;
    DisjointSetRank(int v){
        parent = new int[v];
        rank = new int[v];

        for(int i = 0;i < v;i++){
            parent[i] = i;
        }
    }
    /*With this path compression technique, the find operation is now optimized to an amortized time complexity of O(α(n)), where 𝛼(𝑛)
      is the inverse Ackermann function, which grows extremely slowly.*/
    public int find(int x){
        if(x == parent[x]) return x;
//        return find(parent[x]);
        return parent[x] = find(parent[x]); // path compression
    }
    public void unionByRank(int x, int y){
        int setX = find(x);
        int setY = find(y);

        if(setY == setX) return;// belong to same set so union has no meaning

        if(rank[setX] > rank[setY]){
            //perform union
            parent[setY] = setX;
        } else if (rank[setX] < rank[setY]) {
            parent[setX] = setY;
        }else{
            parent[setX] = setY;
            rank[setY]++;
        }
    }
}