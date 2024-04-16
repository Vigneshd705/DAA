package Greedy;

import java.util.*;

public class Kruskals_Alg {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src =src;
            this.dest =dest;
            this.weight =weight;
        }
    }
      static class Subset {
        int parent, rank;
    }
    public static void main(String[] args)
    {
        int V = 4;
        // Create an empty list of edges
        ArrayList<Edge> graphEdges = new ArrayList<>();

        // Add edges manually
        graphEdges.add(new Edge(0, 1, 10));
        graphEdges.add(new Edge(0, 2, 6));
        graphEdges.add(new Edge(0, 3, 5));
        graphEdges.add(new Edge(1, 3, 15));
        graphEdges.add(new Edge(2, 3, 4));


        // Sort the edges in non-decreasing order
        // (increasing with repetition allowed)

        graphEdges.sort(Comparator.comparingInt((Edge o) -> o.weight));


        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; ++v) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        int e = 0;
        int i = 0;
        ArrayList<Edge> result = new ArrayList<>();
        while (e < V - 1) {
            Edge next_edge = graphEdges.get(i++);

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result.add(next_edge);
                Union(subsets, x, y);
                e++;
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result.get(i).src + " -- " + result.get(i).dest + " == " + result.get(i).weight);
    }
     static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    static void Union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
}

