class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            if (!isSequenceValid(row)) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            char[] col = new char[board.length];
            for (int j = 0; j < board.length; j++) {
                col[j] = board[j][i];
            }

            if (!isSequenceValid(col)) {
                return false;
            }
        }

        for (int blockRow = 0; blockRow <= 2; blockRow++) {
            for (int blockCol = 0; blockCol <= 2; blockCol++) {
                char[] block = new char[9];
                int index = 0;
            
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        int row = blockRow * 3 + i;
                        int col = blockCol * 3 + j;

                        block[index] = board[row][col];
                        index++;
                    }
                }

                if (!isSequenceValid(block)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSequenceValid(char[] row) {
        int mask = 0;
        for (char c : row) {
            if (!Character.isDigit(c)) continue;
            int digit = c - '0';
            if ((mask & (1 << digit)) != 0) return false;
            mask |= (1 << digit);
        }

        return true;
    }
}
