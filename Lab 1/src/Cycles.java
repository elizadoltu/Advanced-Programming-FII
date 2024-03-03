// Src : https://www.geeksforgeeks.org/print-all-the-cycles-in-an-undirected-graph/

public class Cycles {
    
    // Variables for DFS
    static final int N = 100_000;
    static int [][] graph = new int [N][];
    static int [][] cycles = new int [N][];
    static int cycleNumber;

    private static void dfs(int u, int p, int[] color, int[] par, int[][] adjacencyMatrix) {
        color[u] = 1;
    
        // Check if the vertex u has neighbors
        if (adjacencyMatrix[u] != null) {
            for (int v = 0; v < adjacencyMatrix[u].length; v++) {
                if (adjacencyMatrix[u][v] == 1) {
                    if (color[v] == 0) {
                        par[v] = u;
                        dfs(v, u, color, par, adjacencyMatrix);
                    } else if (color[v] == 1 && v != p) {
                        // Cycle detected
                        cycleNumber++;
                    }
                }
            }
        }
    
        color[u] = 2;
    }
    
    public static int dfsCycle(int[][] adjacencyMatrix) {
        int[] color = new int[N];
        int[] par = new int[N];
        cycleNumber = 0;

        for (int i = 0; i < N; i++) {
            color[i] = 0;
            par[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            if (color[i] == 0) {
                dfs(i, -1, color, par, adjacencyMatrix);
            }
        }

        return cycleNumber;
    }

}
