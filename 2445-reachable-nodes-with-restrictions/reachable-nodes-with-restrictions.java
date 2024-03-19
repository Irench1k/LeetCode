class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    Set<Integer> restrictedValues;
    
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        restrictedValues = new HashSet<>();
        for (int val : restricted) {
            restrictedValues.add(val);
        }
        
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<Integer>());
            }
            
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<Integer>());
            }
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        seen.add(0);
        return dfs(0, restrictedValues);
    }
    
    public int dfs(int node, Set<Integer> restrictedValues) {
        int answer = 1;
        seen.add(node);
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!seen.contains(neighbor)) {
                    if (restrictedValues.contains(neighbor)) {
                        continue;
                    }
                    answer += dfs(neighbor, restrictedValues);
                }
            }
        }
        
        return answer;
    }
}