class NumMatrix {

    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.prefix = new int[m + 1][n + 1];

        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                prefix[row][col] = matrix[row - 1][col - 1]
                                + prefix[row][col - 1]
                                + prefix[row - 1][col]
                                - prefix[row - 1][col - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        row2++;
        col1++;
        col2++;

        return prefix[row2][col2]
            - prefix[row1 - 1][col2]
            - prefix[row2][col1 - 1]
            + prefix[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */