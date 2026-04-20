class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int freshFruits = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int cur = grid[r][c];
                if (cur == 2) {
                    queue.add(new int[]{r, c});
                }
                if (cur == 1) {
                    freshFruits++;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            boolean rottedAny = false;

            for (int i = 0; i < queueSize; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];

                int[][] neighbors = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}};
                for (int j = 0; j < 4; j++) {
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    if (Math.min(newR, newC) < 0 || newR >= ROWS || newC >= COLS || grid[newR][newC] == 0 || grid[newR][newC] == 2) {
                        continue;
                    }

                    queue.add(neighbors[j]);
                    grid[newR][newC] = 2;
                    freshFruits--;
                    rottedAny = true;
                }
            }
            if(rottedAny) {
                minutes++;
            }
        }

        return freshFruits == 0 ? minutes : -1;
    }
}
