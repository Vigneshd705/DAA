import java.util.Scanner;

public class CoinChange {
    int n, amt;
    int[] coins;

    void denom() {
        int count = 0;
        n=n-1;
        while (amt > 0) {
            if (amt >= coins[n] && n >= 0) {
                System.out.print(coins[n] + " ");
                count = count + 1;
                amt -= coins[n];
            } else
                n--;
        }
        System.out.println("\nCoins used " + count);
    }

    public static void main(String[] args) {
        CoinChange coin = new CoinChange();
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
        coin.denom();
        scan.close();
    }
}
