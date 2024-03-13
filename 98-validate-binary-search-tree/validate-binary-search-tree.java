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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long small, long large) {
        if (root == null) {
            return true;
        }

        if (root.val <= small || root.val >= large) {
            return false;
        }

        boolean left = dfs(root.left, small, root.val);
        boolean right = dfs(root.right, root.val, large);

        return left && right;
    }
}