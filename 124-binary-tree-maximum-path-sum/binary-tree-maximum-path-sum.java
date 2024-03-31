/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result;
    
    public int maxPathSum(TreeNode root) {
        result = root.val;
        dfs(root);
        return result;
    }


    // Find maximum path WITHOUT splitting
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        // Compute path WITH splitting
        result = Math.max(result, node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax, rightMax);
    }
}