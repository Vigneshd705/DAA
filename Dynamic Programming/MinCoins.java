import java.util.Scanner;

public class MinCoins {
    int n, amt;
    int[] coins;

    void minCoins() {
        int[] minCoins = new int[amt + 1];
        int[] usedCoins = new int[amt + 1];

        for (int i = 1; i <= amt; i++) {
            minCoins[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && 1 + minCoins[i - coin] < minCoins[i]) {
                    minCoins[i] = 1 + minCoins[i - coin];
                    usedCoins[i] = coin;
                }
            }
        }

        // Printing the used coins
        System.out.print("Coins used: ");
        int remainingAmt = amt;
        while (remainingAmt > 0) {
            System.out.print(usedCoins[remainingAmt] + " ");
            remainingAmt -= usedCoins[remainingAmt];
        }
        System.out.println();

        System.out.println("Minimum number of coins required: " + minCoins[amt]);
    }

    public static void main(String[] args) {
        MinCoins coin = new MinCoins();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        coin.amt = scan.nextInt();
        System.out.println("Enter the no. of coins: ");
        coin.n = scan.nextInt();
        coin.coins = new int[coin.n];
        System.out.println("Start entering the denominations: ");
        for (int i = 0; i < coin.n; i++) {
            coin.coins[i] = scan.nextInt();
        }
        coin.minCoins();
    }
}
