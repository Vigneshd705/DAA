import java.io.*;
import java.lang.*;
import java.util.*;

class FloydWarshall {
    final static int INF = 99999, V = 4;
    void floydWarshall(int dist[][])
    {
        int i, j, k;
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j]
                        < dist[i][j])
                        dist[i][j]
                            = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist);
    }
    void printSolution(int dist[][])
    {
        System.out.println(
            "The following matrix shows the shortest "
            + "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int graph[][] = { { 0, 3, INF, 7 },
                          { 8, 0, 2, INF },
                          { 5, INF, 0, 1 },
                          { 2, INF, INF, 0 } };
        FloydWarshall a = new FloydWarshall();

        a.floydWarshall(graph);
    }
}
