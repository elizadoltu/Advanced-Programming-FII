// Src : https://www.geeksforgeeks.org/print-all-the-cycles-in-an-undirected-graph/
// https://www.geeksforgeeks.org/count-of-all-cycles-without-any-inner-cycle-in-a-given-graph/
// https://www.c-sharpcorner.com/article/counting-cycles-in-undirected-graph-with-dfs/

import java.util.*;

// public class Cycles {
    
//     // Variables for DFS
//     static final int N = 100_000;
//     static int [][] graph = new int [N][];
//     static int [][] cycles = new int [N][];
//     static int cycleNumber;

//     private static void dfs(int u, int p, int[] color, int[] par, int[][] adjacencyMatrix) {
//         color[u] = 1;
    
//         // Check if the vertex u has neighbors
//         if (adjacencyMatrix[u] != null) {
//             for (int v = 0; v < adjacencyMatrix[u].length; v++) {
//                 if (adjacencyMatrix[u][v] == 1) {
//                     if (color[v] == 0) {
//                         par[v] = u;
//                         dfs(v, u, color, par, adjacencyMatrix);
//                     } else if (color[v] == 1 && v != p) {
//                         // Cycle detected
//                         cycleNumber++;
//                     }
//                 }
//             }
//         }
    
//         color[u] = 2;
//     }
    
//     public static int dfsCycle(int[][] adjacencyMatrix) {
//         int[] color = new int[N];
//         int[] par = new int[N];
//         cycleNumber = 0;

//         for (int i = 0; i < N; i++) {
//             color[i] = 0;
//             par[i] = -1;
//         }

//         for (int i = 0; i < N; i++) {
//             if (color[i] == 0) {
//                 dfs(i, -1, color, par, adjacencyMatrix);
//             }
//         }

//         return cycleNumber;
//     }

// }

public class Cycles {

    static int numberOfCycles(int [][] adjacencyMatrix) {

        int numberVertices = adjacencyMatrix.length;
        boolean [] visited = new boolean[numberVertices];
        int numberCycles = 0;
        
        for (int vertex = 0; vertex < numberVertices; ++vertex) {

            // Perform DFS from the current vertex
            numberCycles += dfsCycle(adjacencyMatrix, vertex, vertex, visited);
            visited[vertex] = true;
        }

        // Each cycle is counted twice (once for each direction), so divide by 2
        return numberCycles / 2;
    }

    // DFS method 
    static int dfsCycle(int [][] adjacencyMatrix, int startVertex, int currentVertex, boolean [] visited) {

        int numberCycles = 0;

        for (int nextVertex = 0; nextVertex < adjacencyMatrix.length; ++nextVertex) {

            // If there is an edge
            if (adjacencyMatrix[currentVertex][nextVertex] == 1) {
                // If the next vertex has been visited and is not the start vertex, increment the number of cycles
                if (visited[nextVertex] && nextVertex != startVertex) {
                    ++numberCycles;
                }

                // If the next vertex has not been visited, perform DFS from the vertex
                else if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    numberCycles += dfsCycle(adjacencyMatrix, startVertex, currentVertex, visited);
                }
            }
        }
        return numberCycles;
    }
}
