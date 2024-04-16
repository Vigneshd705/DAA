package BACKTRACKING;

import java.util.Arrays;

public class M_Coloring_Backtracking {
    public static void main(String[] args) {

        int[][] graph = {
                {0,1,1,0},
                {1,0,1,0},
                {1,1,0,1},
                {0,0,1,0}
        };
        int V = 4;
        int m=3;
        int[] color = new int[V];
        Arrays.fill(color,-1);
        System.out.println(graphColoring(graph,m,V,color));
        System.out.println(Arrays.toString(color));

    }
    public static boolean graphColoring(int[][] graph, int m, int v,int[] color){


        System.out.println(Arrays.toString(color));
        return fuc(graph,m,v,0,color);
    }
    public static boolean fuc(int[][] graph, int m, int v,int i,int[] color){
        if (i==v)
            return true;
        for (int j =0; j<m; j++){
            if (safe(graph,i,j,v,color)){
                color[i] = j;

                if (fuc(graph,m,v,i+1,color)){ //assigned colors to all nodes:
                    return true;
                }
                //can't assign color -- backtracking..
                color[i] = -1;
            }
        }
        return false;
    }
    public static boolean safe(int[][] graph, int i, int j, int v,int[] color){
        for (int k=0;k<v;k++){
            if (graph[i][k] == 1 && color[k] == j){
                return false;
            }
        }
        return true;
    }












}
