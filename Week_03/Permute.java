import java.util.ArrayDeque;
import java.util.ArrayList;

import java.util.Deque;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }
        boolean[] used = new boolean[length];
        Deque<Integer> path = new ArrayDeque<>(length);
        dfs(nums, length, 0, res, path, used);
        return res;
    }

    private void dfs(int[] nums, int length, int depth, List<List<Integer>> res, Deque<Integer> path, boolean[] used) {
        if (length == depth) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, length, depth + 1, res, path, used);
            path.removeLast();
            used[i] = false;
        }
    }


}
