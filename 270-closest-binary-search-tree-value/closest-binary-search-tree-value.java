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
    public int closestValue(TreeNode root, double target) {
        return minDiff(root, target, root.val);
    }
    
    public int minDiff(TreeNode node, double target, int closest) {
        if (node == null) {
            return closest;
        }
        
        if (Math.abs(target - node.val) < Math.abs(target - closest)) {
            closest = node.val;
        }

        if (Math.abs(target - node.val) == Math.abs(target - closest)) {
            if (closest > node.val) {
                closest = node.val;
            }

            if (closest < node.val) {
                closest = closest;
            }
        }


        
        if (target > node.val) {
            closest = minDiff(node.right, target, closest);
        } else {
            closest = minDiff(node.left, target, closest);
        }
        
        return closest;
    }
}