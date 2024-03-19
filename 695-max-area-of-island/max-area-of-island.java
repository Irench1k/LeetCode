class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] seen;
    
    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        int maxValue = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    seen[i][j] = true;
                    int islandArea = dfs(i, j, grid);
                    if (islandArea > maxValue) {
                        maxValue = islandArea;
                    }
                }
            }
        }
        
        return maxValue;
    }
    
    public int dfs(int row, int col, int[][] grid) {
        int answer = 1;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            
            if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                seen[nextRow][nextCol] = true;
                answer += dfs(nextRow, nextCol, grid);
            }
        }
        
        return answer;
    }
    
    public boolean valid(int row, int col, int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        
        return row >= 0 && row < x && col >= 0 && col < y && grid[row][col] == 1;
    }
}