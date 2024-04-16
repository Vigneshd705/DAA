package DynamicProgramming;

class MatrixChainMultiplication {

    static int matrixChainOrder(int[] p) {
        int n = p.length - 1; // Number of matrices
        int[][] m = new int[n + 1][n + 1]; // Minimum number of scalar multiplications
        int[][] s = new int[n + 1][n + 1]; // Split index

        // Initialization
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0; // Base case: Single matrix has no multiplication cost
        }

        // Dynamic programming to compute minimum number of scalar multiplications
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k; // Update split index
                    }
                }
            }
        }
        printOptimalParenthesization(s, 1, n);
        System.out.println();
        return m[1][n];
    }

    static void printOptimalParenthesization(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParenthesization(s, i, s[i][j]);
            printOptimalParenthesization(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        int[] dimensions = {10, 30, 5, 60}; // Example: Dimensions of matrices A1, A2, A3
        int minMultiplications = matrixChainOrder(dimensions);
        System.out.println("Minimum number of scalar multiplications: " + minMultiplications);
    }
}
