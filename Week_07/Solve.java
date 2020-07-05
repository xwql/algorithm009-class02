/**
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Solve {
    public void solve(char[][] board) {
        int m = board.length;
        if (m < 2) return;
        int n = board[0].length;
        UnionFind unionFind = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    unionFind.union(i * n + j, 0);
                } else if (board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') {
                        unionFind.union(i * n + j, (i - 1) * n + j);
                    }
                    if (board[i + 1][j] == 'O') {
                        unionFind.union(i * n + j, (i + 1) * n + j);
                    }
                    if (board[i][j - 1] == 'O') {
                        unionFind.union(i * n + j, i * n + j - 1);
                    }
                    if (board[i][j + 1] == 'O') {
                        unionFind.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!unionFind.connected(i * n + j, 0) && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

