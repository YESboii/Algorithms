package graphs;
import java.util.*;

class RailwayArticulationPoints {
    private int time = 0;

    public void dfs(int u, boolean[] visited, int[] discovery, int[] low, int parent, Map<Integer, List<Integer>> graph, boolean[] articulationPoints) {
        visited[u] = true;
        discovery[u] = low[u] = ++time;
        int children = 0;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                dfs(v, visited, discovery, low, u, graph, articulationPoints);

                low[u] = Math.min(low[u], low[v]);

                if (parent != -1 && low[v] >= discovery[u]) {
                    articulationPoints[u] = true;
                }

                if (parent == -1 && children > 1) {
                    articulationPoints[u] = true;
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }

    public List<Integer> findArticulationPoints(Map<Integer, List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n];
        int[] discovery = new int[n];
        int[] low = new int[n];
        boolean[] articulationPoints = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, discovery, low, -1, graph, articulationPoints);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (articulationPoints[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of railway stations (vertices): ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of direct train routes (edges): ");
        int m = scanner.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        System.out.println("Enter the edges (format: u v): ");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        RailwayArticulationPoints rap = new RailwayArticulationPoints();
        List<Integer> articulationPoints = rap.findArticulationPoints(graph, n);

        System.out.println("Articulation Points: " + articulationPoints);
    }
}

