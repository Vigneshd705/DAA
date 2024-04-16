import java.util.*;

class Graph {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    boolean visited[];

    Graph(int V) {
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
            visited[i] = false;
        }
    }

    void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    void dfsTraversal(int src) {
        if (visited[src] != true) {
            visited[src] = true;
            for (int i = 0; i < adjList.get(src).size(); i++) {
                int curr = adjList.get(src).get(i);
                System.out.print(curr + " ");
                dfsTraversal(curr);
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vertices = scan.nextInt();
        Graph graph = new Graph(vertices);
        int choice = 1, src, dest;
        do {
            switch (choice) {
                case 1:
                    System.out.println("Enter the src: ");
                    src = scan.nextInt();
                    while (src >= vertices) {
                        System.out.println("Vertex " + src + " is not found of the graph");
                        src = scan.nextInt();
                    }
                    System.out.println("Enter the destination: ");
                    dest = scan.nextInt();
                    while (dest >= vertices) {
                        System.out.println("Vertex " + dest + " is not found of the graph");
                        dest = scan.nextInt();
                    }
                    graph.addEdge(src, dest);
                    break;
            }
            System.out.println("Do you want to add another edge?(0/1): ");
            choice = scan.nextInt();
        } while (choice != 0);
        System.out.println("Enter the source:");
        src = scan.nextInt();
        System.out.println(graph.adjList.get(src).get(0));
        graph.dfsTraversal(src);
    }
}
