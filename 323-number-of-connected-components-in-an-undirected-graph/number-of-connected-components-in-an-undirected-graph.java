class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<Integer>();
    
    public int countComponents(int n, int[][] edges) {
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];

            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<Integer>());
            }
            
            
            if (!graph.containsKey(j)) {
                graph.put(j, new ArrayList<Integer>());
            }

            graph.get(i).add(j);
            graph.get(j).add(i);
        }
        
        int answer = 0;
        for (int k = 0; k < n; k++) {
            if (!seen.contains(k)) {
                answer++;
                dfs(k);
            }
        }
        
        return answer;
    }
    
    public void dfs(int node) {
        seen.add(node);
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!seen.contains(neighbor)) {
                    dfs(neighbor);
                }
            }
        }
    }
}