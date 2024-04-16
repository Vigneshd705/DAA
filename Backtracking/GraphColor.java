import java.util.Scanner;

public class GraphColor {
    public static int V;

    boolean isSafe(int c, int color[], int v, boolean graph[][]) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    boolean graphColoring(int m, boolean graph[][], int color[], int v) {
        if(v==V){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(isSafe(i, color, v, graph)){
                color[v]=i;
                if(graphColoring(m, graph, color, v+1)){
                    return true;
                }
                color[v]=0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        V = scan.nextInt();
        System.out.println("Enter the no.of edges: ");
        int E = scan.nextInt();
        boolean graph[][] = new boolean[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = false;
            }
        }
        for (int i = 0; i < E; i++) {
            System.out.println("Enter the source vertex: ");
            int src = scan.nextInt();
            System.out.println("Enter the destination vetex: ");
            int dest = scan.nextInt();
            graph[src][dest] = true;
            graph[dest][src] = true;
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Enter the no. of colors: ");
        int m = scan.nextInt();
        int color[] = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = 0;
        }
        GraphColor graphcolor=new GraphColor();
        if(!graphcolor.graphColoring(m, graph, color, 0)){
            System.out.println("Solution doesn't exists!");
        };
        for(int i=0;i<V;i++){
            System.out.println(i+": "+color[i]);
        }

    }
}
