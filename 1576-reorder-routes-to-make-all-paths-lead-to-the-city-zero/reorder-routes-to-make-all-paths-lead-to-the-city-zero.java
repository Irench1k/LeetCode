class Solution {
    Set<String> roads = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();

    public int minReorder(int n, int[][] connections) {
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];

            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }

            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
            roads.add(convertToHash(x, y));
        }

        seen.add(0);
        return dfs(0);
    }

    public int dfs(int node) {
        int answer = 0;
        for (int neighbor : graph.get(node)) {
            if (!seen.contains(neighbor)) {
                if (roads.contains(convertToHash(node, neighbor))) {
                    answer++;
                }
                seen.add(neighbor);
                answer += dfs(neighbor);
            }
        }

        return answer;
    }

    public String convertToHash(int x, int y) {
        return String.valueOf(x) + ", " + String.valueOf(y);
    }
}