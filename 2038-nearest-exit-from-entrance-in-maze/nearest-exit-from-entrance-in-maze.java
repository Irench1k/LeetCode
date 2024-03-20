class Solution {
    int[][] directions = new int[][] {{0,1 }, {1, 0}, {0, -1}, {-1, 0}};
    Queue<State> queue = new LinkedList<>();
    int x;
    int y;
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] grid = convertMazeToGrid(maze);
        
        x = grid.length;
        y = grid[0].length;
        int startRow = entrance[0];
        int startCol = entrance[1];
        
        boolean[][] seen = new boolean[x][y];
        seen[startRow][startCol] = true;
        queue.add(new State(startRow, startCol, 0));
        
        while(!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row, col = state.col, steps = state.steps;
            if (isAtBorder(row, col) && !(row == entrance[0] && col == entrance[1])) {
                return steps;
            }
            
            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                
                if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                }
            }
        }
        
        return -1;
    }
    
    public int[][] convertMazeToGrid(char[][] maze) {
        int numRows = maze.length;
        int numCols = maze[0].length;
        int[][] grid = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = maze[i][j] == '.' ? 0 : 1;
            }
        }

        return grid;
    }

    
    public boolean valid(int row, int col, int[][] grid) {
        return row >= 0 && row < x && col >= 0 && col < y && grid[row][col] == 0;
    }
    
    public boolean isAtBorder(int row, int col) {
        return row == 0 || row == x - 1 || col == 0 || col == y - 1;
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