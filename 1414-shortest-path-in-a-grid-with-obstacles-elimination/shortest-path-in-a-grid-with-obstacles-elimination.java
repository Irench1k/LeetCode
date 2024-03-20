class Solution {
    Queue<State> queue = new LinkedList<>();
    boolean[][][] seen;
    int remains;
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int x;
    int y;

    public int shortestPath(int[][] grid, int k) {
        x = grid.length;
        y = grid[0].length;

        queue.add(new State(0, 0, 0, k));
        seen = new boolean[x][y][k + 1];
        seen[0][0][k] = true;
        remains = k;

        while(!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row, col = state.col, steps = state.steps, remains = state.remains;

            if (row == x - 1 && col == y - 1) {
                return steps;
            }

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (valid(nextRow, nextCol)) {
                    if (grid[nextRow][nextCol] == 0) {
                        if (valid(nextRow, nextCol) && !seen[nextRow][nextCol][remains]) {
                            seen[nextRow][nextCol][remains] = true;
                            queue.add(new State(nextRow, nextCol, steps + 1, remains));
                        }
                    } else if (remains > 0 && !seen[nextRow][nextCol][remains - 1]) {
                        seen[nextRow][nextCol][remains - 1] = true;
                        queue.add(new State(nextRow, nextCol, steps + 1, remains - 1));
                    }
                }
            }
        }

        return -1;
    }

    public boolean valid(int row, int col) {
        return row >= 0 && row < x && col >= 0 && col < y;
    }
}

class State {
    int row;
    int col;
    int steps;
    int remains;

    public State(int row, int col, int steps, int remains) {
        this.row = row;
        this.col = col;
        this.steps = steps;
        this.remains = remains;
    }
}