class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        return  dfs(source, destination);
    }
    
    public boolean dfs(int source, int destination) {
        if (source == destination) {
            return true;
        }
        
        for (int neighbor : graph.get(source)) {
            if (!seen.contains(neighbor)) {
                seen.add(neighbor);
                if (dfs(neighbor, destination)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}