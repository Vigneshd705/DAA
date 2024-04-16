import java.util.*;

public class PrimAlgorithm {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;
        List<List<Edge>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int src, int dest, int weight) {
            Edge edge = new Edge(src, dest, weight);
            adj.get(src).add(edge);
            edge = new Edge(dest, src, weight);
            adj.get(dest).add(edge); // Since the graph is undirected
        }

        void primMST() {
            boolean[] inMST = new boolean[V];
            int[] parent = new int[V];
            int[] key = new int[V];

            PriorityQueue<Edge> pq = new PriorityQueue<>(V, Comparator.comparingInt(e -> e.weight));
            for (int i = 0; i < V; i++) {
                key[i] = Integer.MAX_VALUE;
                parent[i] = -1;
            }

            key[0] = 0;
            pq.offer(new Edge(-1, 0, 0)); // Dummy edge with src=-1 to start from first vertex

            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                int u = e.dest;

                if (inMST[u])
                    continue;

                inMST[u] = true;

                for (Edge edge : adj.get(u)) {
                    int v = edge.dest;
                    int weight = edge.weight;
                    if (!inMST[v] && key[v] > weight) {
                        key[v] = weight;
                        pq.offer(new Edge(u, v, key[v]));
                        parent[v] = u;
                    }
                }
            }

            System.out.println("Edges of Minimum Spanning Tree:");
            for (int i = 1; i < V; i++) {
                System.out.println(parent[i] + " - " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}
