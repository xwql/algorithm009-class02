/**
 * 529. 扫雷游戏
 */
public class UpdateBoard {
    int m, n;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        int r = click[0], c = click[1];
        dfs(board, r, c);
        return board;
    }

    //递归调用更新值
    private void dfs(char[][] board, int r, int c) {
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {
            int num = calculate(board, r, c);
            if (num > 0) {
                board[r][c] = (char)(num + '0');
            } else {
                board[r][c] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int row = r + i;
                        int col = c + j;
                        if (row < 0 || row >= m || col < 0 || col >= n) continue;
                        if (board[row][col] == 'E') dfs(board, row, col);
                    }
                }
            }
        }
    }

    //判断周围有没有雷
    private int calculate(char[][] board, int r, int c) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                int row = r + i;
                int col = c + j;
                if (row < 0 || row >= m || col < 0 || col >= n) continue;
                if (board[row][col] == 'M') count++;
            }
        }
        return count;
    }
}
