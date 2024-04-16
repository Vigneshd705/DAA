package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GreedyCoinChange {
    static ArrayList<Integer> l = new ArrayList<>();
    public int coinChange(Integer[] coins, int amount) {
        Arrays.sort(coins, Collections.reverseOrder());
        int totalCoins = 0;
        int remainingAmount = amount;

        for (int coin : coins) {
            while (remainingAmount >= coin) {
                remainingAmount -= coin;
                l.add(coin);
                totalCoins++;
            }
        }
        if (remainingAmount == 0) {
            return totalCoins;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        GreedyCoinChange gcc = new GreedyCoinChange();
        Integer[] coins = {1, 2, 5};
        int amount = 11;
        int result = gcc.coinChange(coins, amount);
        System.out.println("Minimum number of coins required: " + result);
        System.out.println(l);
    }
}
