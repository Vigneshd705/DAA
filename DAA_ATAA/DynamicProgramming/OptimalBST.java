package DynamicProgramming;

class OptimalBST {

    static double optimalBST(double[] p, int[][] root) {
        int n = p.length;
        double[][] c = new double[n + 2][n + 1];

        // Initialization
        for (int i = 1; i <= n + 1; i++) {
            c[i][i - 1] = 0;
        }
        for (int i = 1; i <= n; i++) {
            c[i][i] = p[i - 1];
            root[i][i] = i;
        }

        // Dynamic programming to compute optimal BST cost and root table
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                c[i][j] = Double.MAX_VALUE;
                double sum = 0;
                for (int s = i; s <= j; s++) {
                    sum += p[s - 1];
                }
                for (int k = i; k <= j; k++) {
                   // double val = ((k > i) ? c[i][k - 1] : 0) + ((k < j) ? c[k + 1][j] : 0) + sum;
                    double val = c[i][k-1] + c[k+1][j] + sum;
                    if (val < c[i][j]) {
                        c[i][j] = val;
                        root[i][j] = k;
                    }
                }
            }
        }

        // Construct the optimal binary search tree
        return c[1][n];
    }


    static void constructOBST(int[][] root, int start, int end, int parent, boolean isLeft) {
        if (start <= end) {
            int k = root[start][end];
            if (parent != 0) {
                if (isLeft) {
                    System.out.println("Node " + k + " is the left child of " + parent);
                } else {
                    System.out.println("Node " + k + " is the right child of " + parent);
                }
            }
            constructOBST(root, start, k - 1, k, true);
            constructOBST(root, k + 1, end, k, false);
        }
    }

    public static void main(String[] args) {
        double[] p = {1, 2, 4, 3};
        int[][] root = new int[p.length + 2][p.length + 2];
        double cost = optimalBST(p, root);
        System.out.println("Optimal BST Cost: " + cost);
        System.out.println("Optimal BST Structure:");
        constructOBST(root, 1, p.length, 0, false);
    }
}
