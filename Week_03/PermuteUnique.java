import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null && nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, nums, new LinkedList<>(), new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, LinkedList<Integer> tmpList, boolean[] used) {
        if (tmpList.size() == nums.length) {
            list.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            tmpList.addLast(nums[i]);
            used[i] = true;
            backtrack(list, nums, tmpList, used);
            tmpList.removeLast();
            used[i] = false;
        }
    }
}
