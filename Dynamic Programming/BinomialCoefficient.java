public class BinomialCoefficient {
    
    public static int binomialCoeff(int n, int k) {
        int[][] C = new int[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; i>=j && j<=k; j++) {
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }

        
        return C[n][k];
    }
    
    public static void main(String[] args) {
        int n =7, k = 4;
        System.out.println("Binomial coefficient of " + n + " and " + k + " is " + binomialCoeff(n, k));
    }
}
