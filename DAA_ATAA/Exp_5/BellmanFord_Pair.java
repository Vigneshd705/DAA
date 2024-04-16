package Exp_5;

import java.util.*;

class BellmanFord_Pair {
    public final int Key;
    public final int Value;

    BellmanFord_Pair(int Key, int Value){
        this.Key = Key;
        this.Value = Value;
    }
}

class BellmanFord {
    static int[] parent = new int[5];
    static ArrayList<ArrayList<BellmanFord_Pair>> l = new ArrayList<>();

    public static void main(String[] args) {
        Arrays.fill(parent, -1);
        for (int i = 0; i < 5; i++) {
            l.add(new ArrayList<>());
        }

        // Adding edges to the graph
        addedge(0, 1, 10);
        addedge(0, 2, 6);
        addedge(0, 3, 5);
        addedge(1, 3, 15);
        addedge(2, 3, 4);

        // Introduce a negative-weight edge (negative cycle)
        // 0 -> 3 : 5(2)
        //addedge(3, 0, -3);

        bellmanFord(4);
    }

    public static void addedge(int u, int v, int weight) {
        l.get(u).add(new BellmanFord_Pair(v, weight));
    }

    public static void bellmanFord(int V) {
        // Initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Distance from source to itself is 0

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            // Iterate over all edges
            for (int u = 0; u < V; u++) {
                for (BellmanFord_Pair p : l.get(u)) {
                    int v = p.Key;
                    int weight = p.Value;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        parent[v] = u;
                    }
                }
            }
        }

        // Check for negative-weight cycles
        for (int u = 0; u < V; u++) {
            for (BellmanFord_Pair p : l.get(u)) {
                int v = p.Key;
                int weight = p.Value;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    System.out.println("Graph contains negative-weight cycle.");
                    return;
                }
            }
        }

        // Print shortest distances and parents
        printShortestDistances(dist, V);
    }

    public static void printShortestDistances(int dist[], int V){
        System.out.println("Vertex \tDistance from Source \tParent");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t" + dist[i] + " \t\t\t\t" + parent[i]);
    }
}
