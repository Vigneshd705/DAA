
import java.io.*;
import java.util.*;

class MatrixChain {
    static char name;

    static void printParenthesis(int i, int j, int n,
            int[][] bracket) {

        if (i == j) {
            System.out.print(name++);
            return;
        }
        System.out.print("(");
        printParenthesis(i, bracket[i][j], n, bracket);
        printParenthesis(bracket[i][j] + 1, j, n, bracket);
        System.out.print(")");
    }

    static void matrixChainOrder(int p[], int n) {
        int[][] m = new int[n][n];
        int[][] bracket = new int[n][n];
        for (int i = 1; i < n; i++)
            m[i][i] = 0;
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j]
                            + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        bracket[i][j] = k;
                    }
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                System.out.print(bracket[i][j]+" ");
            }
            System.out.println();
        }
        name = 'A';
        printParenthesis(1, n - 1, n, bracket);

    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the no. of matrices: ");
        int m=scan.nextInt();
        int arr[]=new int[m];
        System.out.println("Enter the values:");
        for(int i=0;i<m;i++){
            arr[i]=scan.nextInt();
        }
        int n = arr.length;
        matrixChainOrder(arr, n);
        System.out.println();
    }
}
