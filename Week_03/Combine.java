import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        if (k < 1) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, n, k, new LinkedList<Integer>(), 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int n, int k, LinkedList<Integer> tmpList, int start) {
        if (tmpList.size() == k) {
            list.add(new LinkedList<>(tmpList));
            return;
        }
        for (int i = start; i <= n; i++) {
            tmpList.addLast(i);
            backtrack(list, n, k, tmpList, i + 1);
            tmpList.removeLast();
        }
    }
}
