package BACKTRACKING;

import java.util.Scanner;

public class N_Queens {
    static int[] a;
    static int count = 0;
    N_Queens(int V){
         a = new int[V];
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("No.of Queens : ");
        int v = in.nextInt();
        new N_Queens(v+1);

        queens(v);
    }
    public static void queens(int n){
        int k = 1;
      //  a[k] = 0;
        while (k!=0){
            do{
                a[k]++;
            }while (a[k] <=n && !place(k)); // k -position

            if (a[k] <= n ){
                if ( k == n){
                    print(n);
                }
                else {
                    k++;
                    a[k] = 0;
                }
            }
            else {
                k--;
            }
        }


    }
    public static boolean place(int pos){
        for (int i=1;i <pos; i++){
            //col & daigonal Check:
            if (a[i] == a[pos] || (Math.abs(a[i]-a[pos]) == Math.abs(i-pos)))
                return false;
        }
        return true;
    }
    public static void print(int n){
        System.out.println("Solution " + (++count) + " : ");
        for (int i = 1; i<=n; i++){
            for (int j = 1;j<=n; j++){
                if (a[i] == j)
                    System.out.print("Q\t");
                else
                    System.out.print("*\t");
            }
            System.out.println();
        }
    }
}
