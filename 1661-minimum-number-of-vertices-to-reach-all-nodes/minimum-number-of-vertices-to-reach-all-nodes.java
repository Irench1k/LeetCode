class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        boolean[] indegree = new boolean[n];

        for (List<Integer> edge : edges) {
            int y = edge.get(1);
            indegree[y] = true;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == false) {
                result.add(i);
            }
        }

        return result;
    }
}