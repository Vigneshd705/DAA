import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix {
    public static void main(String[] args) {
        int vertices,edges,src,des;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        vertices = scan.nextInt();
        int adjmatrix[][]=new int[vertices][vertices];
        System.out.println("Enter the number of edges: ");
        edges=scan.nextInt();
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                adjmatrix[i][j]=0;
            }
        }
        //Directed Graph
        for(int i=0;i<edges;i++){
            System.out.println("Enter the source of edge "+(i+1));
            src=scan.nextInt();
            System.out.println("Enter the destination of source "+src);
            des=scan.nextInt();
            adjmatrix[src-1][des-1]=1;
        }
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(adjmatrix[i][j]+" ");
            }
            System.out.println();
        }

        //Undirected Graph
        for(int i=0;i<edges;i++){
            System.out.println("Enter the source of edge "+(i+1));
            src=scan.nextInt();
            System.out.println("Enter the destination of source "+src);
            des=scan.nextInt();
            adjmatrix[src-1][des-1]=1;
            adjmatrix[des-1][src-1]=1;
        }
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(adjmatrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
