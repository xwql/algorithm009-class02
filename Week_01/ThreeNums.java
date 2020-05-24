import java.lang.reflect.Array;
import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
 * 的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * Related Topics 数组 双指针
 */

public class ThreeNums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) return list;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) return list;
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if ((nums[i] + nums[j] + nums[k]) == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) j++;//去重
                    while (j < k && nums[k] == nums[k+1]) k--;//去重
                } else if ((nums[i] + nums[j] + nums[k]) > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};//-4,-1,-1,0,1,2,
        ThreeNums threeNums = new ThreeNums();
        List<List<Integer>> lists = threeNums.threeSum(nums);
        //Arrays.sort(nums);
        for (List<Integer> i : lists) {
            System.out.println(i);
//            for (Integer j: i){
//                System.out.println(j);
//            }
        }
    }
}
