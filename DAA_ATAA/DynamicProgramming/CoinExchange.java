package DynamicProgramming;

import java.util.ArrayList;

public class CoinExchange {
    public static void main(String[] args) {
        int[] coins = {1,5,6,8}; //sort
        int sum = 11;
        System.out.println("Min. Coins required : " + coinexchange(sum,coins));
    }
    public static int coinexchange(int sum, int[] coin){

        int n = coin.length;
        //initialize:
        int[][] dp = new int[n+1][sum+1];

        for (int i=1;i<=sum;i++)
            dp[0][i] = Integer.MAX_VALUE;
        for (int j=0;j<=n;j++){
            dp[j][0] = 0;
        }

        //...
        for (int i=1;i<=n;i++){ // i -- row
            for (int j=1;j<=sum;j++){ //j --col
                if (j - coin[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j],  1+ dp[i][j-coin[i-1]]);
                }
            }
        }
        if (dp[n][sum] == Integer.MAX_VALUE)
            return -1;
        else {
            ArrayList<Integer> l = new ArrayList<>();
            int i=n;
            int j = sum;
            while (i > 0 && j > 0){
                if (dp[i-1][j] == dp[i][j])
                    i--;
                else {
                    l.add(coin[i-1]);
                    j = j - coin[i-1];
                }
            }
            System.out.println(l);
            return dp[n][sum];
        }
    }
}
