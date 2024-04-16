package BACKTRACKING;

import java.util.ArrayList;
import java.util.Scanner;

public class SumofSubset {
    static int c;
    static boolean flag;
    public static void main(String[] args) {
        int[] set = new int[]{1,2,1};
        int sum = 3;
        ArrayList<Integer> l = new ArrayList<>();

        sos(0,set.length,set,sum,l);
        if (!flag)
            System.out.println("No Solution exits..");
    }
    public static void sos(int i, int n, int[] set, int targetSum, ArrayList<Integer> l){
        if (targetSum == 0) {
            flag = true;
            System.out.println("Solution " + (++c) + " : "+ l);
            return;
        }

        if (i == n)
            return;

        // without : --- & move next one
        sos(i + 1, n, set, targetSum, new ArrayList<>(l));

        // with : -- & move next one
        l.add(set[i]);
        sos(i + 1, n, set, targetSum - set[i], new ArrayList<>(l));
    }
}
