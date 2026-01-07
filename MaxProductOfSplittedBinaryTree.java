import java.util.*;

public class MaxProductOfSplittedBinaryTree {
    private static final int MOD = 1_000_000_007;

    private long totalSum = 0L; // sum of all node values
    private long maxProduct = 0L; // best product seen

    /**
     * compute the max product modulo 1e9+7.
     */
    public int maxProduct(TreeNode root) {
        totalSum = computeTotalSum(root);
        maxProduct = 0L;
        computeSubtreeSums(root);
        return (int) (maxProduct % MOD);
    }

    /**
     * Post-order traversal that returns subtree sum and updates maxProduct.
     */
    private long computeSubtreeSums(TreeNode node) {
        if (node == null)
            return 0L;
        long leftSum = computeSubtreeSums(node.left);
        long rightSum = computeSubtreeSums(node.right);
        long sum = node.val + leftSum + rightSum;
        long product = sum * (totalSum - sum);
        if (product > maxProduct)
            maxProduct = product;
        return sum;
    }

    /**
     * Simple recursive total sum calculation.
     */
    private long computeTotalSum(TreeNode node) {
        if (node == null)
            return 0L;
        return node.val + computeTotalSum(node.left) + computeTotalSum(node.right);
    }

    /** Minimal TreeNode. Kept static and local to this file for simplicity. */
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            this.val = v;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextLine()) {
                System.out.println("Provide a level-order line (e.g. '1 2 3 null 4')");
                return;
            }
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Empty input");
                return;
            }
            String[] tokens = line.split("\\s+");
            TreeNode root = buildTree(tokens);
            MaxProductOfSplittedBinaryTree solver = new MaxProductOfSplittedBinaryTree();
            System.out.println(solver.maxProduct(root));
        }
    }

    /**
     * Build a binary tree from level-order tokens. "null" denotes missing nodes.
     */
    private static TreeNode buildTree(String[] tokens) {
        if (tokens.length == 0 || tokens[0].equals("null"))
            return null;
        TreeNode root = parseNode(tokens[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < tokens.length) {
            TreeNode cur = q.poll();
            if (cur == null)
                continue;
            // left
            if (i < tokens.length) {
                TreeNode left = parseNode(tokens[i++]);
                cur.left = left;
                q.add(left);
            }
            // right
            if (i < tokens.length) {
                TreeNode right = parseNode(tokens[i++]);
                cur.right = right;
                q.add(right);
            }
        }
        return root;
    }

    private static TreeNode parseNode(String tok) {
        if (tok == null || tok.equals("null"))
            return null;
        try {
            return new TreeNode(Integer.parseInt(tok));
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
