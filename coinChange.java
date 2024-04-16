import java.util.Scanner;

public class coinChange {
    int n, amt;
    int[] coins;
    int[][] denominations = new int[n + 1][amt + 1];

    int denom() {

        // Initialize the first row except denominations[0][0]
        for (int i = 1; i <= amt; i++) {
            denominations[0][i] = amt + 1; // Set a value greater than the maximum amount
        }

        // Initialize the first column
        for (int j = 0; j <= n; j++) {
            denominations[j][0] = 0;
        }

        // Fill the denominations array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amt; j++) {
                if (coins[i] > j) {
                    denominations[i][j] = denominations[i - 1][j];
                } else {
                    denominations[i][j] = Math.min(denominations[i - 1][j],  1+denominations[i][j - coins[i]]);
                }
            }
        }

        // Print the denominations array
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amt; j++) {
                System.out.print(denominations[i][j] + " ");
            }
            System.out.println();
        }
        return denominations[n][amt];
    }

    void getDenom(){
        int i=n,j=amt,k=0;
        int Den[]=new int[n];
        while(true){
            if(denominations[i][j]==denominations[i-1][j]){
                i--;
            }
            else{
            Den[k++]=denominations[i][j];
            }

        }
    }

    public static void main(String[] args) {
        coinChange coin = new coinChange();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        coin.amt = scan.nextInt();
        System.out.println("Enter the no. of coins: ");
        coin.n = scan.nextInt();
        coin.coins = new int[(coin.n) + 1];
        System.out.println("Start entering the denominations: ");
        for (int i = 1; i <= coin.n; i++) {
            coin.coins[i] = scan.nextInt();
        }
        if(coin.denom()>coin.amt){
            System.out.println("Denominations is not possible");
        }
        else{
            coin.getDenom();
        }
    }
}
