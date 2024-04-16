// public class OptimalBST {
    
//     public static int optimalBST(int[] keys, int[] freq) {
//         int n = keys.length;
//         int[][] cost = new int[n + 1][n + 1];
        
//         for (int i = 0; i < n; i++) {
//             cost[i][i] = freq[i];
//         }
        
//         for (int L = 2; L <= n; L++) {
//             for (int i = 0; i <= n - L + 1; i++) {
//                 int j = i + L - 1;
//                 cost[i][j] = Integer.MAX_VALUE;
//                 int sum = 0;
                
//                 for (int r = i; r <= j; r++) {
//                     sum += freq[r];
//                 }
                
//                 for (int r = i; r <= j; r++) {
//                     int c = sum + (r > i ? cost[i][r - 1] : 0) + (r < j ? cost[r + 1][j] : 0);
//                     if (c < cost[i][j]) {
//                         cost[i][j] = c;
//                     }
//                 }
//             }
//         }
        
//         return cost[0][n - 1];
//     }
    
//     public static void main(String[] args) {
//         int[] keys = {10, 12, 20};
//         int[] freq = {34, 8, 50};
        
//         System.out.println("Cost of optimal BST is " + optimalBST(keys, freq));
//     }
// }

public class OptimalBST {

    static class TreeNode {
        int key;
        TreeNode left, right;

        TreeNode(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    public static TreeNode optimalBST(int[] keys, int[] freq) {
        int n = keys.length;
        int[][] cost = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;
                int sum = 0;

                for (int r = i; r <= j; r++) {
                    sum += freq[r];
                }

                for (int r = i; r <= j; r++) {
                    int c = sum + (r > i ? cost[i][r - 1] : 0) + (r < j ? cost[r + 1][j] : 0);
                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }

        return constructTree(keys, freq, cost, 0, n - 1);
    }

    private static TreeNode constructTree(int[] keys, int[] freq, int[][] cost, int start, int end) {
        if (start > end)
            return null;

        int minCost = Integer.MAX_VALUE;
        int rootIndex = -1;
        for (int i = start; i <= end; i++) {
            if (cost[start][i - 1] + cost[i + 1][end] < minCost) {
                minCost = cost[start][i - 1] + cost[i + 1][end];
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(keys[rootIndex]);
        root.left = constructTree(keys, freq, cost, start, rootIndex - 1);
        root.right = constructTree(keys, freq, cost, rootIndex + 1, end);

        return root;
    }

    // Helper function to print the tree (inorder traversal)
    public static void printInOrder(TreeNode root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.key + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] keys = {10, 12, 20};
        int[] freq = {34, 8, 50};

        TreeNode root = optimalBST(keys, freq);
        System.out.println("Inorder traversal of constructed BST:");
        printInOrder(root);
    }
}
