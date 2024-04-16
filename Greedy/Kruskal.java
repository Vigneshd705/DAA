import java.util.*;
class Node{
    int src,dest,weight;
    int getWeight(){
        return this.weight;
    }
}

class WeightComparator implements Comparator<Node>{
    public int compare(Node node1,Node node2){
        return Integer.compare(node1.getWeight(),node2.getWeight());
    }
}

public class Kruskal {
    int set[];
    Kruskal(int v){
        set=new int[v];
    }

    ArrayList<ArrayList<Node>> Graph=new ArrayList<>();
    ArrayList<Node> MST=new ArrayList<>();

    void makeSet(int v){
        for(int i=0;i<v;i++){
            set[i]=i;
            Graph.add(new ArrayList<>());
        }
    }

    int findElement(int n){
        if (set[n] != n) {
            set[n] = findElement(set[n]); 
        }
        return set[n];
    }

    void union(int n1,int n2){
        set[findElement(n2)]=findElement(n1);
    }
    void addEdge(int src,int dest,int weight){
        Node node=new Node();
        node.src=src;
        node.dest=dest;
        node.weight=weight;
        Graph.get(src).add(node);

    }
    void mstAddEdge(int src,int dest,int weight){
        Node node=new Node();
        node.src=src;
        node.dest=dest;
        node.weight=weight;
        MST.add(node);
    }
    
    void printEdge(){
        System.out.println("   EDGE       WEIGHT");
        for(Node n:MST){
            System.out.println(n.src+" -> "+n.dest+"\t\t"+n.weight);
        }
    }

    int kruskalAlgorithm() {
        ArrayList<Node> allEdges = new ArrayList<>();
        for (ArrayList<Node> nodeList : Graph) {
            allEdges.addAll(nodeList);
        }
    
        Collections.sort(allEdges, new WeightComparator());
    
        int totalwt = 0;
    
        for (int i = 0; i < allEdges.size(); i++) {
            int u = allEdges.get(i).src;
            int v = allEdges.get(i).dest;
    
            if (findElement(u) != findElement(v)) {
                union(u, v);
                totalwt += allEdges.get(i).weight;
                System.out.println("("+u+"->"+v+"), ");
                System.out.println("Current weight: "+totalwt);
                mstAddEdge(u, v, totalwt);
                
            }
            else{
                System.out.println("Cycle is formed so ("+u+"->"+v+") is rejected");
            }
        }
        return totalwt;
    
    }
    public static void main(String[] args) {
        int vertices=0;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        vertices=scan.nextInt();
        Kruskal graph=new Kruskal(vertices);
        graph.makeSet(vertices);
        System.out.println("Enter the number of edges: ");
        int edges=scan.nextInt();
        for(int i=0;i<edges;i++){
            System.out.println("Enter the source: ");
            int src=scan.nextInt();
            System.out.println("Enter the destination of "+src+" : ");
            int des=scan.nextInt();
            System.out.println("Enter the weight of this edge: ");
            int weight=scan.nextInt();
            graph.addEdge(src,des,weight);
        }
        int totalwt=graph.kruskalAlgorithm();
        graph.printEdge();
        System.out.println("Total Weight of MST: " + totalwt);
    }
}
