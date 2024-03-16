class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<Integer>();
    public int findCircleNum(int[][] isConnected) {
        for (int x = 0; x < isConnected.length; x++) {
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }

            for (int y = x + 1; y < isConnected.length; y++) {
                if (!graph.containsKey(y)) {
                    graph.put(y, new ArrayList<>());
                }

                if (isConnected[x][y] == 1) {
                    graph.get(x).add(y);
                    graph.get(y).add(x);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!seen.contains(i)) {
                answer++;
                seen.add(i);
                dfs(i);
            }
        }

        return answer;
    }

    public void dfs(int node) {
        for (int neighbor : graph.get(node)) {
            if (!seen.contains(neighbor)) {
                seen.add(neighbor);
                dfs(neighbor);
            }
        }
    }
}