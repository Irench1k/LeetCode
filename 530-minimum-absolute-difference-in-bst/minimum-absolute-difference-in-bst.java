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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        Integer min = Integer.MAX_VALUE;

        for (int i = 0; i< result.size() - 1; i++) {
            int diff = Math.abs(result.get(i) - result.get(i + 1));
            if (diff < min) {
                min = diff;
            }
        }

        return min;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}