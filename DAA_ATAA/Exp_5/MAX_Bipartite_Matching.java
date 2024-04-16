package Exp_5;

import java.util.Arrays;

public class MAX_Bipartite_Matching {
    static boolean[] visit;
    static int[] applicants;

    MAX_Bipartite_Matching(int N){
        visit = new boolean[N];
        applicants = new int[N];
    }

    public static void main(String[] args) {

//        int[][] graph = {
//                {1,1,0,1,1},
//                {0,1,0,0,1},
//                {1,1,0,1,1}
//        };
//        int[][] graph = {
//                {1,0},
//                {1,0}
//        };
        int[][] graph = {
                {1,1,1},
                {0,1,1},
                {0,1,0}
        };

        int m = graph.length;
        int N = graph[0].length;
        int ans = 0;
        new MAX_Bipartite_Matching(N);
        Arrays.fill(applicants,-1);
        for (int i=0;i<m;i++){
            Arrays.fill(visit,false);
            if (rec(graph,i))
                ans++;
        }
        System.out.println(ans);
        for (int i = 0; i < N; i++) {
            if (applicants[i] != -1) {
                System.out.println("Job " + i + " is assigned to applicant " + applicants[i]);
            }
        }
    }
    public static boolean rec(int[][] graph, int u){
        for (int i=0; i<graph[0].length; i++){
            if (graph[u][i] == 1 && !visit[i]){
                visit[i] = true;
                if (applicants[i] == -1 || rec(graph,applicants[i])) { //backtrack:
                    applicants[i] = u;
                    return true;
                }
            }
        }
        return false;
    }
}
