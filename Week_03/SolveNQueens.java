import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new LinkedList<>();
        if (n < 0) return list;
        backtrack(list, n, new LinkedList<String>(), new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return list;
    }

    private void backtrack(List<List<String>> list, int n, LinkedList<String> tmpList, HashSet<Integer> cols, HashSet<Integer> pie, HashSet<Integer> na) {
        if (tmpList.size() == n) {
            list.add(new LinkedList<>(tmpList));
            return;
        }
        int row = tmpList.size();
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            sb.setCharAt(col,'Q');
            tmpList.addLast(sb.toString());
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            backtrack(list, n, tmpList, cols, pie, na);
            tmpList.removeLast();
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }
    }
}
