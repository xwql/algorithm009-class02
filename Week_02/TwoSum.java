import java.util.HashMap;

//1. 两数之和 https://leetcode-cn.com/problems/two-sum/description/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = map.get(target - nums[i]);
            if (num != null)
                return new int[]{num, i};
            map.put(nums[i],i);
        }
        return new int[2];
    }
}
