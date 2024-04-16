import java.util.*;

public class HamiltonianCircuit {
    private static boolean isValid(int vertex, int pos, int[] path, int[][] graph) {
        // Check if the vertex is adjacent to the previous vertex
        if (graph[path[pos - 1]][vertex] == 0) {
            return false;
        }

        // Check if the vertex has already been visited
        for (int i = 0; i < pos; i++) {
            if (path[i] == vertex) {
                return false;
            }
        }

        return true;
    }

    private static boolean hamiltonianUtil(int[][] graph, int[] path, int pos, int numVertices) {
        // Base case: If all vertices are included in the path
        if (pos == numVertices) {
            // Check if there is an edge from the last included vertex to the first vertex
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int vertex = 1; vertex < numVertices; vertex++) {
            if (isValid(vertex, pos, path, graph)) {
                path[pos] = vertex;

                if (hamiltonianUtil(graph, path, pos + 1, numVertices)) {
                    return true;
                }

                // Backtrack
                path[pos] = -1;
            }
        }

        return false;
    }

    public static boolean hamiltonianCircuit(int[][] graph) {
        int numVertices = graph.length;
        int[] path = new int[numVertices];
        Arrays.fill(path, -1);

        // Start from the first vertex
        path[0] = 0;

        if (!hamiltonianUtil(graph, path, 1, numVertices)) {
            System.out.println("No Hamiltonian circuit exists");
            return false;
        }

        System.out.println("Hamiltonian circuit:");
        for (int vertex : path) {
            System.out.print(vertex + " ");
        }
        System.out.println(path[0]);  // Complete the cycle

        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 1, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 1, 0, 1},
            {0, 1, 1, 1, 0}
        };

        hamiltonianCircuit(graph);
    }
}
