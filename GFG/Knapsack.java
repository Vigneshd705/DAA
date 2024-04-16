
//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Knapsack {
    public static void main(String args[]) throws IOException {
        // reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // reading total testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            // reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int val[] = new int[n];
            int wt[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");

            // inserting the values
            for (int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String s[] = read.readLine().trim().split("\\s+");

            // inserting the weigths
            for (int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            // calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int capacity, int weight[], int profit[], int n) {
        int[][] denominations = new int[n + 1][capacity + 1];
        int val = 0;
        for (int i = 0; i <= capacity; i++) {
            denominations[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] > j) {
                    denominations[i][j] = denominations[i - 1][j];
                } else {
                    denominations[i][j] = Math.max(profit[i - 1] + denominations[i - 1][j - weight[i - 1]],
                            denominations[i - 1][j]);
                }
            }
        }
        return denominations[n][capacity];
    }
}
