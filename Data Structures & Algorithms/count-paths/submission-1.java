class Solution {
    public int uniquePaths(int m, int n) {
        int rows = m;
        int cols = n;

        int[] prevRow = new int[cols];

        for (int i = rows - 1; i >= 0; i--) {
            int[] currRow = new int[cols];

            currRow[cols - 1] = 1;
            for (int j = cols - 2; j >= 0; j--) {
                currRow[j] = currRow[j + 1] + prevRow[j];
            }
            prevRow = currRow;
        }

        return prevRow[0];
    }
}
