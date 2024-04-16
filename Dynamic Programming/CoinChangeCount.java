import java.util.Scanner;public class CoinChangeCount {
    int n,amt;
    int[] coins;
    void denom(){
        int[][] denominations=new int[n+1][amt+1];
        int val=0;
        for(int i=1;i<=amt;i++){
            denominations[0][i]=0;
 
        }
        for(int j=0;j<=n;j++){
            denominations[j][0]=1;

        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amt;j++){
                if(coins[i]>j){
                    denominations[i][j]=denominations[i-1][j];
                }
                else{
                    denominations[i][j]=denominations[i-1][j]+denominations[i][j-coins[i]];
                }
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amt;j++){
                System.out.print(denominations[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Total Ways: "+denominations[n][amt]);
    }
 public static void main(String[] args) {
    CoinChangeCount coin=new CoinChangeCount();
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter the amount: ");
    coin.amt=scan.nextInt();
    System.out.println("Enter the no. of coins: ");
    coin.n=scan.nextInt();
    coin.coins=new int[(coin.n)+1];
    System.out.println("Start entering the denominations: ");
    for(int i=1;i<=coin.n;i++){
        coin.coins[i]=scan.nextInt();
    }
    coin.denom();

 }   
}
