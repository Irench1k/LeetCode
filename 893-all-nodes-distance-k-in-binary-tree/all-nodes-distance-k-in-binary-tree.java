/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> graph = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    Set<TreeNode> seen = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);
        queue.add(target);
        seen.add(target);
        int distance = 0;

        while(!queue.isEmpty() && distance < k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                TreeNode[] neighbors = new TreeNode[]{node.left, node.right, graph.get(node)};
                for (TreeNode neighbor : neighbors) {
                    if (!seen.contains(neighbor) && neighbor != null) {
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }

        List<Integer> answer = new ArrayList<Integer>();
        for (TreeNode node : queue) {
            answer.add(node.val);
        }

        return answer;

    }

    public void dfs(TreeNode node, TreeNode root) {
        if (node == null) {
            return;
        }

        graph.put(node, root);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}