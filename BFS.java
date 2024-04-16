import java.util.*;

class Graph {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    Queue<Integer> queue = new LinkedList();

    Graph(int V) {
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    void bfsTraversal() {
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for (int i = 0; i < adjList.get(curr).size(); i++) {
                queue.add(adjList.get(curr).get(i));
            }
        }
    }
}

public class BFS {
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
                    System.out.println("Do you want to add another edge?(0/1): ");
                    choice = scan.nextInt();
                    break;
            }
        } while (choice != 0);
        graph.bfsTraversal();
    }
}