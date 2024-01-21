import java.util.ArrayList;
import java.util.Scanner;

public class AdjList {
    public static void main(String[] args) {
        int vertices,edges,src,des;
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        vertices = scan.nextInt();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        System.out.println("Enter the number of edges: ");
        edges=scan.nextInt();
        //Directed Graph
        for(int i=0;i<edges;i++){
            System.out.println("Enter the Source of edge "+(i+1));
            src=scan.nextInt();
            System.out.println("Enter the destination of source "+src);
            des=scan.nextInt();
            adjList.get(src-1).add(des);
        }
        System.out.println(adjList);

        //Undirected Graph
        for(int i=0;i<edges;i++){
            System.out.println("Enter the Source of edge "+(i+1));
            src=scan.nextInt();
            System.out.println("Enter the destination of source "+src);
            des=scan.nextInt();
            adjList.get(src-1).add(des);
            adjList.get(des-1).add(src);
        }
        System.out.println(adjList);
    }
}
