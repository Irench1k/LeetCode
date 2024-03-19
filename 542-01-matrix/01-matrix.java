class Solution {
    Queue<State> queue = new LinkedList<>();
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }
        
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] seen = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new State(i, j, 1));
                    seen[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row, col = state.col, steps = state.steps;
            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (valid(nextRow, nextCol, mat) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                    mat[nextRow][nextCol] = steps;
                }
            }
        }

        return mat;
    }

    public boolean valid(int row, int col, int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        return row >= 0 && row < x && col >= 0 && col < y;
    }
}

class State {
    int row;
    int col;
    int steps;

    public State(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}