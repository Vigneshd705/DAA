package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair_Trial1{  // implements Comparable<Pair_Trial1> {
    public final int Key;
    public final int Value;
    Pair_Trial1(int Key, int Value){
        this.Key = Key;
        this.Value = Value;
    }

 /*   @Override
   public int compareTo(Pair_Trial1 o) {
        return this.Value - o.Value;
    }*/
}

class PRIMS {
    static ArrayList<ArrayList<Pair_Trial1>> l = new ArrayList<>();
    public static void main(String[] args) {

        for (int i=0;i<5;i++){
            l.add(new ArrayList<>());
        }
        /*undirected-weighted graph: */

        addedge(0, 1, 10);
        addedge(0, 2, 6);
        addedge(0, 3, 5);
        addedge(1, 3, 15);
        addedge(2, 3, 4);
        primMST(4);

    }
    public static void addedge(int u,int v,int weight){
        l.get(u).add(new Pair_Trial1(v,weight));
        l.get(v).add(new Pair_Trial1(u,weight));
    }

    public static void primMST(int V){
        PriorityQueue<Pair_Trial1> pq = new PriorityQueue<>(Comparator.comparingInt((Pair_Trial1 o) -> o.Value));
        int src = 0; // Taking vertex 0 as source

        // Create a parent array and a key array
        int[] parent = new int[V];
        int[] key = new int[V];

        // An array to check if a node has been added to MST or not
        boolean[] mstSet = new boolean[V];

        // Initialize all the arrays
        for (int i = 0; i < V; i++) {
            parent[i] = -1;
            key[i] = Integer.MAX_VALUE;
        }

        // Add source node to the priority queue
        pq.add(new Pair_Trial1(src, key[src]));
        key[src] = 0;

        // Process the vertices
        while (!pq.isEmpty()) {
            int u = pq.poll().Key;
            System.out.println(u);
            mstSet[u] = true;

            for (Pair_Trial1 p : l.get(u)) {
                int v = p.Key;
                int weight = p.Value;
                if (!mstSet[v] && weight < key[v]) {
                    pq.remove(new Pair_Trial1(v, key[v]));
                    key[v] = weight;
                    pq.add(new Pair_Trial1(v, key[v]));
                    parent[v] = u;
                }
            }
        }

        printMST(parent, key, V);
    }

    public static void printMST(int[] parent, int[] key, int V){
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + key[i]);
    }
}
