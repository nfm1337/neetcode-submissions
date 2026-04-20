class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                maxArea = Math.max(maxArea, dfs(grid, r, c));
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (Math.min(r, c) < 0 || r >= grid.length || c == grid[0].length || 
            grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        int res = 1;
        res += dfs(grid, r - 1, c);
        res += dfs(grid, r + 1, c);
        res += dfs(grid, r, c - 1);
        res += dfs(grid, r, c + 1);

        return res;
    }
}
