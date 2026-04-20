class Solution {
    private int[][] cache;

    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        return dp(0, 0, m, n);
    }

    private int dp(int m, int n, int rows, int cols) {
        if (m >= rows || n >= cols) {
            return 0;
        }

        if (cache[m][n] > 0) {
            return cache[m][n];
        }

        if (m == rows - 1 && n == cols -  1) {
            return 1;
        }

        return dp(m + 1, n, rows, cols) + dp(m, n + 1, rows, cols);
    }
}
