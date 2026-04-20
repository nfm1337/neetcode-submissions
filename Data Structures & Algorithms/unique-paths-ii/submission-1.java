class Solution {
    int[][] cache;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        return dp(obstacleGrid, 0, 0);
    }

    private int dp(int[][] grid, int r, int c) {
        if (r == grid.length || c == grid[0].length || grid[r][c] == 1) {
            return 0;
        }

        if (cache[r][c] > 0) {
            return cache[r][c];
        }

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return 1;
        }

        cache[r][c] = dp(grid, r + 1, c) + dp(grid, r, c + 1);

        return cache[r][c];
    }
}