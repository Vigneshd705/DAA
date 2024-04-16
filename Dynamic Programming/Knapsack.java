import java.util.Scanner;

public class Knapsack {

    int n,capacity;
    int[] weight,profit;
    int fillSack(){
        int[][] denominations=new int[n+1][capacity+1];
        int val=0;
        for(int i=0;i<=capacity;i++){
            denominations[0][i]=0;
        }
     
        for(int i=1;i<=n;i++){
            for(int j=1;j<=capacity;j++){
                if(weight[i]>j){
                    denominations[i][j]=denominations[i-1][j];
                }
                else{
                    denominations[i][j]=Math.max(profit[i]+denominations[i-1][j-weight[i]],denominations[i-1][j]);
                }
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=capacity;j++){
                System.out.print(denominations[i][j]+" ");
            }
            System.out.println();
        }
        return denominations[n][capacity];
    }
 public static void main(String[] args) {
    Knapsack bag=new Knapsack();
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter the capacity: ");
    bag.capacity=scan.nextInt();
    System.out.println("Enter the no. of weights: ");
    bag.n=scan.nextInt();
    bag.weight=new int[(bag.n)+1];
    bag.profit=new int[(bag.n)+1];
    System.out.println("Start entering the weights and profits: ");
    for(int i=1;i<=bag.n;i++){
        bag.weight[i]=scan.nextInt();
        bag.profit[i]=scan.nextInt();
    }
    System.out.println("Max Capacity: "+bag.fillSack());

 }   
}
