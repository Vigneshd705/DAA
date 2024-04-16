package BACKTRACKING;

import java.util.Arrays;

public class HamiltonianCycle {
    static int v = 5;
    public static void main(String[] args) {
        int[][] graph = {
                {0,1,0,1,0},
                {1,0,1,1,1},
                {0,1,0,0,1},
                {1,1,0,0,1},
                {0,1,1,1,0},
                {0,0,1,1,0}
        };
        int[] path = new int[v];
        Arrays.fill(path,-1);
        path[0] = 0;
        int pos = 1;
        if (ham_cycle(graph,path,pos))
            System.out.println(Arrays.toString(path).replace(']',',') +' ' + path[0] + ']');
        else
            System.out.println("No such Hamiltoniain Cycle");
    }
    public static boolean ham_cycle(int[][] graph, int[] path, int pos){
        if (pos == v){
            if (graph[path[pos-1]][path[0]] == 1)
                return true;
            return false;
        }
        for (int i=1; i<v; i++){
            if (isSafe(i,graph,path,pos)){
                path[pos] = i;

                if (ham_cycle(graph,path,pos+1))
                    return true;

                path[pos] = -1;
            }
        }
        return false;
    }
    public static boolean isSafe(int i, int[][] graph, int[] path, int pos){
        if (graph[path[pos-1]][i] == 0)
            return false;
        for (int j = 0; j< pos; j++){
            if (path[j] == i)
                return false;
        }
        return true;
    }
}