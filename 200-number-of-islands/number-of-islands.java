class Solution {
    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] seen;

    public int numIslands(char[][] grid) {
        int answer = 0;
        seen = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    answer++;
                    seen[i][j] = true;
                    dfs(i, j, grid);
                }
            }
        }

        return answer;
    }

    public void dfs(int row, int col, char[][] grid) {
        for (int[] direction : directions) {
            int nextCol = col + direction[0];
            int nextRow = row + direction[1];

            if (valid(nextRow, nextCol, grid)&& !seen[nextRow][nextCol]) {
                seen[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, grid);
            }
        }
    }

    public boolean valid(int row, int col, char[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        return row >= 0 && row < x && col >= 0 && col < y && grid[row][col] == '1';
    }
}