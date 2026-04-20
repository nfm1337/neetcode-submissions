class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (grid[0][0] == 1 || grid[ROWS - 1][COLS - 1] == 1) {
            return -1;
        }
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[ROWS][COLS];

        queue.add(new int[]{0, 0});
        visit[0][0] = 1;
        int length = 1;
        while (!queue.isEmpty()) {
            
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                int[][] neighbors = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c},
                                    {r + 1, c + 1}, {r + 1, c - 1}, {r - 1, c + 1}, {r - 1, c - 1}};
                for (int j = 0; j < 8; j++) {
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    if (Math.min(newR, newC) < 0 || newR == ROWS || newC == COLS
                        || visit[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }

                    queue.add(neighbors[j]);
                    visit[newR][newC] = 1;
                }
            }
            length++;
        }

        return -1;
    }
}