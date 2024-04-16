package Exp_5;

import java.util.*;

class StronglyC {
    static int vertex = 6;
    static boolean[] visited = new boolean[vertex];
    static Stack<Integer> s = new Stack<>();
    static ArrayList<ArrayList<Integer>> l = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < vertex; i++) {
            l.add(new ArrayList<>());
            l1.add(new ArrayList<>());
        }
        addedge(1, 3);
        addedge(1, 4);
        addedge(2, 1);
        addedge(3, 2);
        addedge(4, 5);
        DFS(1);

        // reverse:
        getTranspose();

        for (int i = 0; i < l1.size(); i++) {
            System.out.print("\n" + i + " : ");
            for (int j = 0; j < l1.get(i).size(); j++) {
                System.out.print(l1.get(i).get(j) + " ");
            }
        }
        System.out.println("\nConnected Components : ");
        Arrays.fill(visited, false);
        while (!s.isEmpty()) {
            int v = s.pop();
            if (!visited[v]) {
                DFS2(v);
                System.out.println();
            }
        }
    }

    public static void addedge(int u, int v) {
        l.get(u).add(v);
    }

    public static void DFS(int src) {
        boolean[] visit = new boolean[vertex];
        DFS_VISIT(src, visit);
    }

    public static void DFS_VISIT(int src, boolean[] visit) {
        visit[src] = true;
        for (int i = 0; i < l.get(src).size(); i++) {
            int index = l.get(src).get(i);
            if (!visit[index]) {
                DFS_VISIT(index, visit);
            }
        }
        s.push(src);
    }

    public static void DFS2(int src) {
        visited[src] = true;
        System.out.print(src + ", ");
        for (int i = 0; i < l1.get(src).size(); i++) {
            int index = l1.get(src).get(i);
            if (!visited[index]) {
                DFS2(index);
            }
        }
    }

    public static void getTranspose() {
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.get(i).size(); j++) {
                int idx = l.get(i).get(j);
                l1.get(idx).add(i);
            }
        }
    }
}